package com.eatle.utils;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.Map.Entry;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.RichTextString;

/**
 * @corpor 公司：深讯信科
 * @author 作者：谭又中
 * @explain 释义：数据导出到Excel
 * @version 日期：2012-9-14 下午05:50:06
 */
@SuppressWarnings("deprecation")
public class ExcelUtil
{
	static HSSFWorkbook wb;

	/**
	 * @deprecated: 将Map里的集合对象数据输出Excel数据流
	 */
	@SuppressWarnings({ "unchecked" })
	public static void export2Excel(ExportSetInfo setInfo) throws IOException
	{
		wb = new HSSFWorkbook();
		Set<Entry<String, List>> set = setInfo.getObjsMap().entrySet();
		String[] sheetNames = new String[setInfo.getObjsMap().size()];
		int sheetNameNum = 0;
		for (Entry<String, List> entry : set)
		{
			sheetNames[sheetNameNum] = entry.getKey();
			sheetNameNum++;
		}
		HSSFSheet[] sheets = getSheets(setInfo.getObjsMap().size(), sheetNames);
		int sheetNum = 0;
		for (Entry<String, List> entry : set)
		{
			// Sheet
			List objs = entry.getValue();
			boolean isHeadRow = true;
			int rowNum = 3;
			for (Object obj : objs)
			{
				Field[] fields = setInfo.getClazz()[sheetNum].getDeclaredFields();
				// 标题行(需合并单元格)
				CellRangeAddress titleRange = new CellRangeAddress(0, 0, 0, 
						setInfo.getEndFieldIndexs()[sheetNum] - setInfo.getStartFieldIndexs()[sheetNum] + 1);
				sheets[sheetNum].addMergedRegion(titleRange);
				HSSFRow titleRow = sheets[sheetNum].createRow(0);
				titleRow.setHeight((short) 800);
				HSSFCell titleCell = titleRow.createCell(0);
				titleCell.setCellStyle(getTitleCellStyle());
				titleCell.setCellValue(setInfo.getTitles()[sheetNum]);
				// 日期行(需合并单元格)
				CellRangeAddress dateRange = new CellRangeAddress(1, 1, 0, 
						setInfo.getEndFieldIndexs()[sheetNum] - setInfo.getStartFieldIndexs()[sheetNum] + 1);
				sheets[sheetNum].addMergedRegion(dateRange);
				HSSFRow dateRow = sheets[sheetNum].createRow(1);
				dateRow.setHeight((short) 350);
				HSSFCell dateCell = dateRow.createCell(0);
				dateCell.setCellStyle(getDateCellStyle());
				dateCell.setCellValue(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
				// 表头
				if(isHeadRow)
				{
					HSSFRow headRow = sheets[sheetNum].createRow(2);
					headRow.setHeight((short) 350);
					// 序号列
					HSSFCell snCell = headRow.createCell(0);
					snCell.setCellStyle(getHeadCellStyle());
					snCell.setCellValue("序号");
					// 列头名称
					for(int num = 1, len = setInfo.getHeadNames().get(sheetNum).length; num <= len; num++)
					{
						HSSFCell headCell = headRow.createCell(num);
						headCell.setCellStyle(getHeadCellStyle());
						headCell.setCellValue(setInfo.getHeadNames().get(sheetNum)[num - 1]);
					}
					isHeadRow = false;
				}
				// 表体
				HSSFRow contentRow = sheets[sheetNum].createRow(rowNum);
				contentRow.setHeight((short) 300);
				HSSFCell[] cells = getCells(contentRow, setInfo.getEndFieldIndexs()[sheetNum] - setInfo.getStartFieldIndexs()[sheetNum] + 1);
				sheets[sheetNum].autoSizeColumn(0);	// 序号列自动调整列宽
				int cellNum = 1;					// 去的一列序号，因此从1开始
				for (int num = setInfo.getStartFieldIndexs()[sheetNum]; 
					num <= setInfo.getEndFieldIndexs()[sheetNum]; num++)
				{
					fields[num].setAccessible(true);
					try
					{
						sheets[sheetNum].autoSizeColumn(cellNum);	// 内容列自动调整列宽
						if(fields[num].getType() == Boolean.class 
								|| fields[num].getType() == boolean.class)
							cells[cellNum].setCellValue((Boolean) fields[num].get(obj));
						else if(fields[num].getType() == Calendar.class)
							cells[cellNum].setCellValue((Calendar) fields[num].get(obj));
						else if(fields[num].getType() == Date.class)
							cells[cellNum].setCellValue((Date) fields[num].get(obj));
						else if(fields[num].getType() == Double.class 
								|| fields[num].getType() == double.class)
							cells[cellNum].setCellValue((Double) fields[num].get(obj));
						else if(fields[num].getType() == RichTextString.class)
							cells[cellNum].setCellValue((RichTextString) fields[num].get(obj));
						else
							cells[cellNum].setCellValue(fields[num].get(obj).toString());
					}
					catch (Exception e)
					{
						e.printStackTrace();
					}
					cellNum++;
				}
				rowNum++;
			}
			sheetNum++;
		}
		wb.write(setInfo.getOut());
	}

	/**
	 * @deprecated: 创建所有的Sheet
	 */
	private static HSSFSheet[] getSheets(int num, String[] names)
	{
		HSSFSheet[] sheets = new HSSFSheet[num];
		for (int i = 0; i < num; i++)
		{
			sheets[i] = wb.createSheet(names[i]);
		}
		return sheets;
	}


	/**
	 * @deprecated: 创建内容行的每一列(附加一列序号)
	 */
	private static HSSFCell[] getCells(HSSFRow contentRow, int num)
	{
		HSSFCell[] cells = new HSSFCell[num + 1];

		for (int i = 0,len = cells.length; i < len; i++)
		{
			cells[i] = contentRow.createCell(i);
			cells[i].setCellStyle(getContentCellStyle());
		}
		// 设置序号列值，因为出去标题行和日期行，所有-2
		cells[0].setCellValue(contentRow.getRowNum() - 2);

		return cells;
	}

	/**
	 * @deprecated: 标题行样式
	 */
	private static CellStyle getTitleCellStyle()
	{
		CellStyle style = wb.createCellStyle();

		style.setAlignment(CellStyle.ALIGN_CENTER);
		style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		style.setFont(getTitleFont());
		style.setFillBackgroundColor(IndexedColors.SKY_BLUE.index);
		return style;
	}

	/**
	 * @deprecated: 日期行样式
	 */
	private static CellStyle getDateCellStyle()
	{
		CellStyle style = wb.createCellStyle();

		style.setAlignment(CellStyle.ALIGN_CENTER_SELECTION);
		style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		style.setFont(getDateFont());
		style.setFillBackgroundColor(IndexedColors.SKY_BLUE.index);
		return style;
	}

	/**
	 * @deprecated: 表头行样式
	 */
	private static CellStyle getHeadCellStyle()
	{
		CellStyle style = wb.createCellStyle();

		style.setAlignment(CellStyle.ALIGN_CENTER);
		style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		style.setFont(getHeadFont());
		style.setFillBackgroundColor(IndexedColors.YELLOW.index);
		style.setBorderTop(CellStyle.BORDER_MEDIUM);
		style.setBorderBottom(CellStyle.BORDER_THIN);
		style.setBorderLeft(CellStyle.BORDER_THIN);
		style.setBorderRight(CellStyle.BORDER_THIN);
		style.setTopBorderColor(IndexedColors.BLUE.index);
		style.setBottomBorderColor(IndexedColors.BLUE.index);
		style.setLeftBorderColor(IndexedColors.BLUE.index);
		style.setRightBorderColor(IndexedColors.BLUE.index);

		return style;
	}

	/**
	 * @deprecated: 内容行样式
	 */
	private static CellStyle getContentCellStyle()
	{
		CellStyle style = wb.createCellStyle();

		style.setAlignment(CellStyle.ALIGN_CENTER);
		style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		style.setFont(getContentFont());
		style.setBorderTop(CellStyle.BORDER_THIN);
		style.setBorderBottom(CellStyle.BORDER_THIN);
		style.setBorderLeft(CellStyle.BORDER_THIN);
		style.setBorderRight(CellStyle.BORDER_THIN);
		style.setTopBorderColor(IndexedColors.BLUE.index);
		style.setBottomBorderColor(IndexedColors.BLUE.index);
		style.setLeftBorderColor(IndexedColors.BLUE.index);
		style.setRightBorderColor(IndexedColors.BLUE.index);
		style.setWrapText(true);	// 字段换行

		return style;
	}
	
	/**
	 * @deprecated: 标题行字体
	 */
	private static Font getTitleFont()
	{
		Font font = wb.createFont();
		font.setFontName("华文楷体");
		font.setFontHeightInPoints((short) 20);
		font.setBoldweight(Font.BOLDWEIGHT_BOLD);
		font.setCharSet(Font.DEFAULT_CHARSET);
		font.setColor(IndexedColors.BLUE_GREY.index);
		
		return font;
	}

	/**
	 * @deprecated: 日期行字体
	 */
	private static Font getDateFont()
	{
		Font font = wb.createFont();
		font.setFontName("隶书");
		font.setFontHeightInPoints((short) 10);
		font.setBoldweight(Font.BOLDWEIGHT_BOLD);
		font.setCharSet(Font.DEFAULT_CHARSET);
		font.setColor(IndexedColors.BLUE_GREY.index);
		
		return font;
	}

	/**
	 * @deprecated: 表头行字体
	 */
	private static Font getHeadFont()
	{
		Font font = wb.createFont();
		font.setFontName("宋体");
		font.setFontHeightInPoints((short) 10);
		font.setBoldweight(Font.BOLDWEIGHT_BOLD);
		font.setCharSet(Font.DEFAULT_CHARSET);
		font.setColor(IndexedColors.BLUE_GREY.index);
		
		return font;
	}

	/**
	 * @deprecated: 内容行字体
	 */
	private static Font getContentFont()
	{
		Font font = wb.createFont();
		font.setFontName("宋体");
		font.setFontHeightInPoints((short) 10);
		font.setBoldweight(Font.BOLDWEIGHT_NORMAL);
		font.setCharSet(Font.DEFAULT_CHARSET);
		font.setColor(IndexedColors.BLUE_GREY.index);
		
		return font;
	}
	
	
	/**
	 * @deprecated: 封装Excel导出的设置信息
	 * @author: 谭又中
	 */
	public static class ExportSetInfo
	{
		@SuppressWarnings("unchecked")
		private LinkedHashMap<String, List> objsMap;

		@SuppressWarnings("unchecked")
		private Class[] clazz;
		
		private String[] titles;
		
		private int[] startFieldIndexs;
		
		private int[] endFieldIndexs;
		
		private List<String[]> headNames;
		
		private OutputStream out;

		
		@SuppressWarnings("unchecked")
		public LinkedHashMap<String, List> getObjsMap()
		{
			return objsMap;
		}

		/**
		 * @param objMap 导出数据
		 * 
		 * 泛型
		 * String : 代表sheet名称
		 * List : 代表单个sheet里的所有行数据
		 */
		@SuppressWarnings("unchecked")
		public void setObjsMap(LinkedHashMap<String, List> objsMap)
		{
			this.objsMap = objsMap;
		}

		@SuppressWarnings("unchecked")
		public Class[] getClazz()
		{
			return clazz;
		}

		/**
		 * @param clazz 对应每个sheet里的每行数据所表示的对象的类型
		 */
		@SuppressWarnings("unchecked")
		public void setClazz(Class[] clazz)
		{
			this.clazz = clazz;
		}

		public String[] getTitles()
		{
			return titles;
		}

		/**
		 * @param titles 对应每个sheet里的标题，即顶部大字
		 */
		public void setTitles(String[] titles)
		{
			this.titles = titles;
		}

		public int[] getStartFieldIndexs()
		{
			return startFieldIndexs;
		}

		/**
		 * @param startFieldIndexs 单个对象内需要导出的字段的起始索引[从0开始]
		 */
		public void setStartFieldIndexs(int[] startFieldIndexs)
		{
			this.startFieldIndexs = startFieldIndexs;
		}

		public int[] getEndFieldIndexs()
		{
			return endFieldIndexs;
		}

		/**
		 * @param endFieldIndexs 单个对象内需要导出的字段的结束索引[从0开始]
		 */
		public void setEndFieldIndexs(int[] endFieldIndexs)
		{
			this.endFieldIndexs = endFieldIndexs;
		}

		public List<String[]> getHeadNames()
		{
			return headNames;
		}

		/**
		 * @param headNames 对应每个页签的表头的每一列的名称
		 */
		public void setHeadNames(List<String[]> headNames)
		{
			this.headNames = headNames;
		}

		public OutputStream getOut()
		{
			return out;
		}

		/**
		 * @param out Excel数据将输出到该输出流
		 */
		public void setOut(OutputStream out)
		{
			this.out = out;
		}
	}
}