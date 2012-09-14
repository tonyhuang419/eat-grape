package com.eatle.utils;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
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

/**
 * @corpor 公司：深讯信科
 * @author 作者：谭又中
 * @explain 释义：数据导出到Excel
 * @version 日期：2012-9-14 下午05:50:06
 */
public class ExcelUtil
{
	static HSSFWorkbook wb = new HSSFWorkbook();

	/**
	 * @deprecated: 将Map里的集合对象数据输出Excel数据流
	 * @param objMap 导出数据，其中泛型：String : 代表sheet名称，List : 代表单个sheet里的所有行数据。
	 * @param clazz 对应每个sheet里的每行数据所表示的对象的类型
	 * @param titles 对应每个sheet里的标题，即顶部大字
	 * @param out Excel数据将输出到该数据流
	 */
	public static void export2Excel(LinkedHashMap<String, List> objsMap, 
			Class[] clazz, String[] titles, OutputStream out) throws IOException
	{
		Set<Entry<String, List>> set = objsMap.entrySet();
		String[] sheetNames = new String[objsMap.size()];
		int sheetNameNum = 0;
		for (Entry<String, List> entry : set)
		{
			sheetNames[sheetNameNum] = entry.getKey();
			sheetNameNum++;
		}
		HSSFSheet[] sheets = getSheets(objsMap.size(), sheetNames);
		int sheetNum = 0;
		for (Entry<String, List> entry : set)
		{
			// 页签
			List objs = entry.getValue();
			boolean isHeadRow = true;
			int rowNum = 2;
			for (Object obj : objs)
			{
				Field[] fields = clazz[sheetNum].getDeclaredFields();
				// 标题(需合并单元格)
				CellRangeAddress range = new CellRangeAddress(0, 0, 0, fields.length - 1);
				sheets[sheetNum].addMergedRegion(range);
				HSSFRow titleRow = sheets[sheetNum].createRow(0);
				titleRow.setRowStyle(getHeadCellStyle());
				titleRow.setHeight((short) 800);
				HSSFCell titleCell = titleRow.createCell(0);
				titleCell.setCellStyle(getTitleCellStyle());
				titleCell.setCellValue(titles[sheetNum]);
				// 表头
				if(isHeadRow)
				{
					HSSFRow headRow = sheets[sheetNum].createRow(1);
					headRow.setHeight((short) 350);
					for(int num = 0, len = fields.length; num < len; num++)
					{
						HSSFCell headCell = headRow.createCell(num);
						headCell.setCellStyle(getHeadCellStyle());
						headCell.setCellValue(fields[num].getName());
					}
					isHeadRow = false;
				}
				// 表体
				HSSFRow contentRow = sheets[sheetNum].createRow(rowNum);
				contentRow.setHeight((short) 300);
				HSSFCell[] cells = getCells(contentRow, fields.length);
				int cellNum = 0;
				for (Field field : fields)
				{
					field.setAccessible(true);
					try
					{
						sheets[sheetNum].autoSizeColumn(cellNum);	// 自动调整列宽
						if (field.getType() == String.class)
							cells[cellNum].setCellValue((String) field.get(obj));
						if (field.getType() == Boolean.class)
							cells[cellNum].setCellValue((Boolean) field.get(obj));
						if (field.getType() == Date.class)
							cells[cellNum].setCellValue((Date) field.get(obj));
						if (field.getType() == Double.class)
							cells[cellNum].setCellValue((Double) field.get(obj));
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
		wb.write(out);
	}

	private static HSSFSheet[] getSheets(int num, String[] names)
	{
		HSSFSheet[] sheets = new HSSFSheet[num];
		for (int i = 0; i < num; i++)
		{
			sheets[i] = wb.createSheet(names[i]);
		}
		return sheets;
	}

	private static HSSFCell[] getCells(HSSFRow contentRow, int num)
	{
		HSSFCell[] cells = new HSSFCell[num];

		for (int i = 0; i < num; i++)
		{
			cells[i] = contentRow.createCell(i);
			cells[i].setCellStyle(getContentCellStyle());
		}

		return cells;
	}

	private static CellStyle getTitleCellStyle()
	{
		CellStyle style = wb.createCellStyle();

		style.setAlignment(CellStyle.ALIGN_CENTER);
		style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		style.setFont(getTitleFont());
		style.setFillBackgroundColor(IndexedColors.SKY_BLUE.index);
		style.setBorderTop(CellStyle.BORDER_THIN);
		style.setBorderBottom(CellStyle.BORDER_THIN);
		style.setBorderLeft(CellStyle.BORDER_THIN);
		style.setBorderRight(CellStyle.BORDER_THIN);
		style.setTopBorderColor(IndexedColors.BLUE.index);
		style.setBottomBorderColor(IndexedColors.BLUE.index);
		style.setLeftBorderColor(IndexedColors.BLUE.index);
		style.setRightBorderColor(IndexedColors.BLUE.index);

		return style;
	}

	private static CellStyle getHeadCellStyle()
	{
		CellStyle style = wb.createCellStyle();

		style.setAlignment(CellStyle.ALIGN_CENTER);
		style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		style.setFont(getHeadFont());
		style.setFillBackgroundColor(IndexedColors.YELLOW.index);
		style.setBorderTop(CellStyle.BORDER_THIN);
		style.setBorderBottom(CellStyle.BORDER_THIN);
		style.setBorderLeft(CellStyle.BORDER_THIN);
		style.setBorderRight(CellStyle.BORDER_THIN);
		style.setTopBorderColor(IndexedColors.BLUE.index);
		style.setBottomBorderColor(IndexedColors.BLUE.index);
		style.setLeftBorderColor(IndexedColors.BLUE.index);
		style.setRightBorderColor(IndexedColors.BLUE.index);

		return style;
	}

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
		style.setWrapText(true);

		return style;
	}
	
	private static Font getTitleFont()
	{
		Font font = wb.createFont();
		font.setFontName("宋体");
		font.setFontHeightInPoints((short) 20);
		font.setBoldweight(Font.BOLDWEIGHT_BOLD);
		font.setCharSet(Font.DEFAULT_CHARSET);
		font.setColor(IndexedColors.BLUE_GREY.index);
		
		return font;
	}
	
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
}