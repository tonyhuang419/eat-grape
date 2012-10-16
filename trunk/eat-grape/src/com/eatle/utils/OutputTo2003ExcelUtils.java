/**
 * Copyright (C) 2012 SXIT
 * 2012-6-5
 */
package com.eatle.utils;

import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 * 导出Excel文件Utils
 * @author <a href="xiangtao@sxit.com.cn">xiangtao</a>
 * @date 2012-6-5
 * @see ReflectionUtils
 */
public class OutputTo2003ExcelUtils
{

	/**
	 * 导出list里的数据
	 * @param sheetName excel sheetName名称
	 * @param columnPropterties 业务对象的属性名
	 * @param columnNames excel表头的名
	 * @param list 业务对象集合
	 * @return HSSFWorkbook 对象
	 */
	public static HSSFWorkbook output(String sheetName,
			String[] columnPropterties, String[] columnNames, List<?> list)
	{
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet(sheetName);
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
		return workbook;
	}
}
