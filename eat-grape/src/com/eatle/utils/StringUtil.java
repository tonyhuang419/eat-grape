package com.eatle.utils; 

import java.util.UUID;

/** @corpor  公司：深讯信科
 *  @author  作者：谭又中
 *  @explain 释义：
 *  @version 日期：2012-10-9 上午10:36:56 
 */
public class StringUtil
{
	/**
	 * @Description 将字符串按分隔符进行反转
	 * @param sourceStr 源字符串
	 * @param splitStr 分隔符
	 * @return returnStr 反转后的字符串
	 */
	public static String reverseStrAsSplitStr(String sourceStr, String splitStr)
	{
		String returnStr = "";
		String[] strArr = sourceStr.split(splitStr);
		for(int i = strArr.length - 1; i >= 0; i--)
		{
			returnStr += strArr[i] + " ";
		}
		returnStr = returnStr.substring(0, returnStr.length() - 1);
		return returnStr;
	}

	/**
	 *  @deprecated: getUUID() ：构造上传文件保存的UUID文件名
	 * 	@param fileName ：源文件名，用于获取文件拓展名
	 */
	public static String getUUIDName(String fileName)
	{
		String uuid = UUID.randomUUID().toString();
		String fileType = fileName.substring(fileName.lastIndexOf("."));
		
		return uuid + fileType;		
	}
	
	public static void main(String[] args)
	{
		String s = "aaa;bbb;ccc;ddd";
		System.out.println(reverseStrAsSplitStr(s, ";"));
	}
}
 