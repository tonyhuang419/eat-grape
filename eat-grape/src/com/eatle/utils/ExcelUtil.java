package com.eatle.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;

/**
 * @corpor: 公司：深讯信科
 * @author: 作者：谭又中
 * @explain: 释义：数据导出到Excel
 * @version: 日期：2012-9-14 下午05:50:06
 */
@SuppressWarnings("deprecation")
public class ExcelUtil
{
	private static HSSFWorkbook wb;

	private static CellStyle titleStyle;		// 标题行样式
	private static Font titleFont;				// 标题行字体		
	private static CellStyle dateStyle;			// 日期行样式
	private static Font dateFont;				// 日期行字体
	private static CellStyle headStyle;			// 表头行样式
	private static Font headFont;				// 表头行字体
	private static CellStyle contentStyle ;		// 内容行样式
	private static Font contentFont;			// 内容行字体
	
	/**
	 * @throws IOException 
	 * @Description: 将Map里的集合对象数据输出Excel数据流(简单样式输出：仅支持单个Sheet，且样式单调)
	 */
	public static void export2SimpleExcel(String sheetName,
			String[] columnPropterties, String[] columnNames, List<?> list,
			OutputStream out) throws IOException
	{
		wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet(sheetName);
		// 创建第1行，也就是输出表头
		HSSFRow row = sheet.createRow(0);
		HSSFCell cell;
		for (int i = 0; i < columnNames.length; i++)
		{
			cell = row.createCell(i);
			cell.setCellValue(new HSSFRichTextString(columnNames[i]));
		}
		// 下面是输出各行的数据
		for (int i = 0; i < list.size(); i++)
		{
			row = sheet.createRow(i + 1);
			Object o = list.get(i);
			for (int j = 0; j < columnPropterties.length; j++)
			{
				cell = row.createCell(j);
				Object obj = ReflectionUtils.invokeGetterMethod(o, columnPropterties[j]);
				cell.setCellValue(obj == null ? "" : obj.toString());
			}
		}
		wb.write(out);
	}

	/**
	 * @throws IOException 
	 * @Description: 将Map里的集合对象数据输出Excel数据流(依据输入模板输出数据)
	 */
	@SuppressWarnings("unchecked")
	public static void export2ExcelByTemplate(ExportSetInfo setInfo) throws IOException
	{
		init(setInfo.getTemplateInput());
		Set<Entry<String, List>> set = setInfo.getObjsMap().entrySet();
		String[] sheetNames = new String[setInfo.getObjsMap().size()];
		int sheetNameNum = 0;
		for (Entry<String, List> entry : set)
		{
			sheetNames[sheetNameNum] = entry.getKey();
			sheetNameNum++;
		}
		HSSFSheet[] sheets = getSheetsByTemplate(setInfo.getObjsMap().size(), sheetNames);
		int sheetNum = 0;
		for (Entry<String, List> entry : set)
		{
			// Sheet
			List objs = entry.getValue();
			// 表体
			String[] fieldNames = setInfo.getFieldNames().get(sheetNum);
			int rowNum = setInfo.getStartRowNums()[sheetNum];
			for (Object obj : objs)
			{
				HSSFRow contentRow = sheets[sheetNum].createRow(rowNum);
				contentRow.setHeight((short) 300);
				HSSFCell[] cells = createCellsForTemplate(contentRow, setInfo.getFieldNames().get(sheetNum).length);
				int cellNum = 0;
				if(fieldNames != null)
				{
					for (int num = 0; num < fieldNames.length; num++)
					{
						Object value = ReflectionUtils.invokeGetterMethod(obj, fieldNames[num]);
						cells[cellNum].setCellValue(value == null ? "" : value.toString());
						cellNum++;
					}
				}
				rowNum++;
			}
//			adjustColumnSize(sheets, sheetNum, fieldNames);	// 自动调整列宽
			sheetNum++;
		}
		wb.write(setInfo.getOut());
	}
	
	/**
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 * @Description: 将Map里的集合对象数据输出Excel数据流
	 */
	@SuppressWarnings({ "unchecked" })
	public static void export2Excel(ExportSetInfo setInfo) throws 
		IOException, IllegalArgumentException, IllegalAccessException
	{
		init();
		Set<Entry<String, List>> set = setInfo.getObjsMap().entrySet();
		String[] sheetNames = new String[setInfo.getObjsMap().size()];
		int sheetNameNum = 0;
		for (Entry<String, List> entry : set)
		{
			sheetNames[sheetNameNum] = entry.getKey();
			sheetNameNum++;
		}
		HSSFSheet[] sheets = createSheets(setInfo.getObjsMap().size(), sheetNames);
		int sheetNum = 0;
		for (Entry<String, List> entry : set)
		{
			// Sheet
			List objs = entry.getValue();
			// 标题行
			createTableTitleRow(setInfo, sheets, sheetNum);
			// 日期行
			createTableDateRow(setInfo, sheets, sheetNum);
			// 表头
			creatTableHeadRow(setInfo, sheets, sheetNum);
			// 表体
			String[] fieldNames = setInfo.getFieldNames().get(sheetNum);
			int rowNum = 3;
			for (Object obj : objs)
			{
				HSSFRow contentRow = sheets[sheetNum].createRow(rowNum);
				contentRow.setHeight((short) 300);
				HSSFCell[] cells = createCells(contentRow, setInfo.getFieldNames().get(sheetNum).length);
				int cellNum = 1;					// 去掉一列序号，因此从1开始
				if(fieldNames != null)
				{
					for (int num = 0; num < fieldNames.length; num++)
					{
						Object value = ReflectionUtils.invokeGetterMethod(obj, fieldNames[num]);
						cells[cellNum].setCellValue(value == null ? "" : value.toString());
						cellNum++;
					}
				}
				rowNum++;
			}
//			adjustColumnSize(sheets, sheetNum, fieldNames);	// 自动调整列宽
			sheetNum++;
		}
		wb.write(setInfo.getOut());
	}

	/**
	 * @Description: 初始化
	 */
	private static void init()
	{
		wb = new HSSFWorkbook();
		initStyles();
	}
	
	/**
	 * @throws IOException 
	 * @Description: 初始化（带模板文件输入流）
	 */
	private static void init(InputStream input) throws IOException
	{
		wb = new HSSFWorkbook(input);
		initStyles();
	}
	
	/**
	 * @throws IOException 
	 * @Description: 初始化样式
	 */
	private static void initStyles()
	{
		titleFont = wb.createFont();
		titleStyle = wb.createCellStyle();
		dateStyle = wb.createCellStyle();
		dateFont = wb.createFont();
		headStyle = wb.createCellStyle();
		headFont = wb.createFont();
		contentStyle = wb.createCellStyle();
		contentFont = wb.createFont();
		
		initTitleCellStyle();
		initTitleFont();
		initDateCellStyle();
		initDateFont();
		initHeadCellStyle();
		initHeadFont();
		initContentCellStyle();
		initContentFont();
	}

	/**
	 * @Description: 自动调整列宽
	 */
	@SuppressWarnings("unused")
	private static void adjustColumnSize(HSSFSheet[] sheets, int sheetNum,
			String[] fieldNames)
	{
		for(int i = 0; i < fieldNames.length + 1; i++)
		{
			sheets[sheetNum].autoSizeColumn(i, true);
		}
	}

	/**
	 * @Description: 创建标题行(需合并单元格)
	 */
	private static void createTableTitleRow(ExportSetInfo setInfo,
			HSSFSheet[] sheets, int sheetNum)
	{
		CellRangeAddress titleRange = new CellRangeAddress(0, 0, 0, 
				setInfo.getFieldNames().get(sheetNum).length);
		sheets[sheetNum].addMergedRegion(titleRange);
		HSSFRow titleRow = sheets[sheetNum].createRow(0);
		titleRow.setHeight((short) 800);
		HSSFCell titleCell = titleRow.createCell(0);
		titleCell.setCellStyle(titleStyle);
		titleCell.setCellValue(setInfo.getTitles()[sheetNum]);
	}

	/**
	 * @Description: 创建日期行(需合并单元格)
	 */
	private static void createTableDateRow(ExportSetInfo setInfo,
			HSSFSheet[] sheets, int sheetNum)
	{
		CellRangeAddress dateRange = new CellRangeAddress(1, 1, 0, 
				setInfo.getFieldNames().get(sheetNum).length);
		sheets[sheetNum].addMergedRegion(dateRange);
		HSSFRow dateRow = sheets[sheetNum].createRow(1);
		dateRow.setHeight((short) 350);
		HSSFCell dateCell = dateRow.createCell(0);
		dateCell.setCellStyle(dateStyle);
		dateCell.setCellValue(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
	}

	/**
	 * @Description: 创建表头行(需合并单元格)
	 */
	private static void creatTableHeadRow(ExportSetInfo setInfo,
			HSSFSheet[] sheets, int sheetNum)
	{
		// 表头
		HSSFRow headRow = sheets[sheetNum].createRow(2);
		headRow.setHeight((short) 350);
		// 序号列
		HSSFCell snCell = headRow.createCell(0);
		snCell.setCellStyle(headStyle);
		snCell.setCellValue("序号");
		// 列头名称
		for(int num = 1, len = setInfo.getHeadNames().get(sheetNum).length; num <= len; num++)
		{
			HSSFCell headCell = headRow.createCell(num);
			headCell.setCellStyle(headStyle);
			headCell.setCellValue(setInfo.getHeadNames().get(sheetNum)[num - 1]);
		}
	}

	/**
	 * @Description: 创建所有的Sheet
	 */
	private static HSSFSheet[] createSheets(int num, String[] names)
	{
		HSSFSheet[] sheets = new HSSFSheet[num];
		for (int i = 0; i < num; i++)
		{
			sheets[i] = wb.createSheet(names[i]);
		}
		return sheets;
	}
	
	/**
	 * @Description: 从模板中获取所有的Sheet
	 */
	private static HSSFSheet[] getSheetsByTemplate(int num, String[] names)
	{
		HSSFSheet[] sheets = new HSSFSheet[num];
		for (int i = 0; i < num; i++)
		{
			sheets[i] = wb.getSheet(names[i]);
		}
		return sheets;
	}

	/**
	 * @Description: 创建内容行的每一列(附加一列序号)
	 */
	private static HSSFCell[] createCells(HSSFRow contentRow, int num)
	{
		HSSFCell[] cells = new HSSFCell[num + 1];

		for (int i = 0,len = cells.length; i < len; i++)
		{
			cells[i] = contentRow.createCell(i);
			cells[i].setCellStyle(contentStyle);
		}
		// 设置序号列值，因为出去标题行和日期行，所有-2
		cells[0].setCellValue(contentRow.getRowNum() - 2);

		return cells;
	}
	
	/**
	 * @Description: 创建内容行的每一列(无列序号)
	 */
	private static HSSFCell[] createCellsForTemplate(HSSFRow contentRow, int num)
	{
		HSSFCell[] cells = new HSSFCell[num];
		
		for (int i = 0,len = cells.length; i < len; i++)
		{
			cells[i] = contentRow.createCell(i);
			cells[i].setCellStyle(contentStyle);
		}
		
		return cells;
	}

	/**
	 * @Description: 初始化标题行样式
	 */
	private static void initTitleCellStyle()
	{
		titleStyle.setAlignment(CellStyle.ALIGN_CENTER);
		titleStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		titleStyle.setFont(titleFont);
		titleStyle.setFillBackgroundColor(IndexedColors.SKY_BLUE.index);
	}

	/**
	 * @Description: 初始化日期行样式
	 */
	private static void initDateCellStyle()
	{
		dateStyle.setAlignment(CellStyle.ALIGN_CENTER_SELECTION);
		dateStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		dateStyle.setFont(dateFont);
		dateStyle.setFillBackgroundColor(IndexedColors.SKY_BLUE.index);
	}

	/**
	 * @Description: 初始化表头行样式
	 */
	private static void initHeadCellStyle()
	{
		headStyle.setAlignment(CellStyle.ALIGN_CENTER);
		headStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		headStyle.setFont(headFont);
		headStyle.setFillBackgroundColor(IndexedColors.YELLOW.index);
		headStyle.setBorderTop(CellStyle.BORDER_MEDIUM);
		headStyle.setBorderBottom(CellStyle.BORDER_THIN);
		headStyle.setBorderLeft(CellStyle.BORDER_THIN);
		headStyle.setBorderRight(CellStyle.BORDER_THIN);
		headStyle.setTopBorderColor(IndexedColors.BLUE.index);
		headStyle.setBottomBorderColor(IndexedColors.BLUE.index);
		headStyle.setLeftBorderColor(IndexedColors.BLUE.index);
		headStyle.setRightBorderColor(IndexedColors.BLUE.index);
	}

	/**
	 * @Description: 初始化内容行样式
	 */
	private static void initContentCellStyle()
	{
		contentStyle.setAlignment(CellStyle.ALIGN_CENTER);
		contentStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		contentStyle.setFont(contentFont);
		contentStyle.setBorderTop(CellStyle.BORDER_THIN);
		contentStyle.setBorderBottom(CellStyle.BORDER_THIN);
		contentStyle.setBorderLeft(CellStyle.BORDER_THIN);
		contentStyle.setBorderRight(CellStyle.BORDER_THIN);
		contentStyle.setTopBorderColor(IndexedColors.BLUE.index);
		contentStyle.setBottomBorderColor(IndexedColors.BLUE.index);
		contentStyle.setLeftBorderColor(IndexedColors.BLUE.index);
		contentStyle.setRightBorderColor(IndexedColors.BLUE.index);
		contentStyle.setWrapText(true);	// 字段换行
	}
	
	/**
	 * @Description: 初始化标题行字体
	 */
	private static void initTitleFont()
	{
		titleFont.setFontName("华文楷体");
		titleFont.setFontHeightInPoints((short) 20);
		titleFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
		titleFont.setCharSet(Font.DEFAULT_CHARSET);
		titleFont.setColor(IndexedColors.BLUE_GREY.index);
	}

	/**
	 * @Description: 初始化日期行字体
	 */
	private static void initDateFont()
	{
		dateFont.setFontName("隶书");
		dateFont.setFontHeightInPoints((short) 10);
		dateFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
		dateFont.setCharSet(Font.DEFAULT_CHARSET);
		dateFont.setColor(IndexedColors.BLUE_GREY.index);
	}

	/**
	 * @Description: 初始化表头行字体
	 */
	private static void initHeadFont()
	{
		headFont.setFontName("宋体");
		headFont.setFontHeightInPoints((short) 10);
		headFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
		headFont.setCharSet(Font.DEFAULT_CHARSET);
		headFont.setColor(IndexedColors.BLUE_GREY.index);
	}

	/**
	 * @Description: 初始化内容行字体
	 */
	private static void initContentFont()
	{
		contentFont.setFontName("宋体");
		contentFont.setFontHeightInPoints((short) 10);
		contentFont.setBoldweight(Font.BOLDWEIGHT_NORMAL);
		contentFont.setCharSet(Font.DEFAULT_CHARSET);
		contentFont.setColor(IndexedColors.BLUE_GREY.index);
	}
	

	/**
	 * @Description: 封装Excel导出的设置信息
	 * @author: 谭又中
	 */
	public static class ExportSetInfo
	{
		@SuppressWarnings("unchecked")
		private LinkedHashMap<String, List> objsMap;
		
		private String[] titles;
		
		private List<String[]> headNames;
		
		private List<String[]> fieldNames;
		
		private OutputStream out;

		private InputStream templateInput;
		
		private Integer[] startRowNums;

		
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

		public List<String[]> getFieldNames()
		{
			return fieldNames;
		}

		/**
		 * @param clazz 对应每个sheet里的每行数据的对象的属性名称
		 */
		public void setFieldNames(List<String[]> fieldNames)
		{
			this.fieldNames = fieldNames;
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

		public InputStream getTemplateInput()
		{
			return templateInput;
		}

		/**
		 * @param input 模板文件输入流（依据模板输出时必须设值）
		 */
		public void setTemplateInput(InputStream templateInput)
		{
			this.templateInput = templateInput;
		}
		
		public Integer[] getStartRowNums()
		{
			return startRowNums;
		}

		/**
		 * @param startRowNum 从第几行开始写数据（从0开始，依据模板输出时必须设值）
		 */
		public void setStartRowNums(Integer[] startRowNums)
		{
			this.startRowNums = startRowNums;
		}
	}
}