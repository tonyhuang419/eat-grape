package com.eatle.utils;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Random;

/** @corpor  公司：深讯信科
 *  @author  作者：谭又中
 *  @explain 释义：权限动作指令加密
 *  @version 日期：2012-9-14 上午10:11:18 
 */
public class Encrypt
{
	// 处理一行字符串方法
	public static String encrypt(String str)
	{
		String binStr = strToBinary(str);	// 转换为对应ASC码的二进制字符串
		String findValueInTable = "";
		// 对二进制字符串长度处理
		if (binStr.length() % 24 == 8)
		{
			binStr += "0000";
		}
		if (binStr.length() % 24 == 16)
		{
			binStr += "00";
		}
		findValueInTable = binChangeToChar(binStr);

		return findValueInTable.toLowerCase();
	}

	// 将字符串的每个字符的ASC码转换为二进制字符串
	private static String strToBinary(String str)
	{
		String binStr = "";
		for (int i = 0; i < str.length(); i++)
		{
			char c = str.charAt(i);		// 遍历字符串的每个字符
			if (Integer.toBinaryString(c).length() == 8)
			{
				binStr += Integer.toBinaryString(c);				// 将每个字符的对应二进制字符串累加到返回值变量上
			}
			switch (Integer.toBinaryString(c).length())
			{
				case 7:
					binStr += "0" + Integer.toBinaryString(c);		// 将每个字符的对应二进制字符串累加到返回值变量上
					break;
				case 6:
					binStr += "00" + Integer.toBinaryString(c);		// 将每个字符的对应二进制字符串累加到返回值变量上
					break;
				case 5:
					binStr += "000" + Integer.toBinaryString(c);	// 将每个字符的对应二进制字符串累加到返回值变量上
					break;
				case 4:
					binStr += "0000" + Integer.toBinaryString(c);	// 将每个字符的对应二进制字符串累加到返回值变量上
					break;
				case 3:
					binStr += "00000" + Integer.toBinaryString(c);	// 将每个字符的对应二进制字符串累加到返回值变量上
					break;
				case 2:
					binStr += "000000" + Integer.toBinaryString(c);	// 将每个字符的对应二进制字符串累加到返回值变量上
					break;
				case 1:
					binStr += "0000000" + Integer.toBinaryString(c);// 将每个字符的对应二进制字符串累加到返回值变量上
					break;
				default:
					binStr += Integer.toBinaryString(c);			// 将每个字符的对应二进制字符串累加到返回值变量上
					break;
			}
		}
		return binStr;
	}

	// 将二进制字符串转换为十进制数据,并拆分为6位一段进行查参照表，将查找到的字符累加返回
	private static String binChangeToChar(String binStr)
	{
		String findValueInTable = "";
		HashMap<Integer, Character> hashTable = createTable();	// 创建参照表
		String[] binStrArr = binStrToArr(binStr);
		// 将二进制字符串转换为十进制字符串
		int times = 0;
		for (int i = 0; i < binStrArr.length; i++)
		{
			BigInteger bigInt = new BigInteger(binStrArr[i], 2);// 大数整型对象
			String decStr = bigInt.toString(10);				// 转换为指定进制的字符串

			// 将最终查表返回的字符串进行拆分为长度为4的字串，并以“_”分隔
			if (times == 4)
			{
				findValueInTable += hashTable.get(Integer.parseInt(decStr));
				times = 0;
			}
			else
			{
				findValueInTable += hashTable.get(Integer.parseInt(decStr));
			}
			times++;
		}
		return findValueInTable;// 由于返回长度大于生成码，截取和生成码长度相同的字符
	}

	// 将二进制串转换为每个元素长度为6个字符的数组
	private static String[] binStrToArr(String binStr)
	{
		String[] binStrArr = new String[binStr.length() / 6];

		for (int i = 0, j = 0; i < binStr.length(); i += 6, j++)
		{
			if (i < binStr.length() - 6)
			{
				binStrArr[j] = binStr.substring(i, i + 6);
			}
			else
			{
				binStrArr[j] = binStr.substring(i);
			}
		}

		return binStrArr;
	}

	// 建立映射表（用哈希Map）
	private static HashMap<Integer, Character> createTable()
	{
		HashMap<Integer, Character> hashTable = new HashMap<Integer, Character>();
		char value = 'A';
		for (int i = 0; i <= 9; i++)	// 0-9存储A-J
		{
			hashTable.put(i, value);
			value++;
		}
		value = '0';
		for (int i = 10; i <= 19; i++) 	// 10-19存储0-9
		{
			hashTable.put(i, value);
			value++;
		}
		value = 'K';
		for (int i = 20; i <= 34; i++) 	// 20-34存储K-Y
		{
			hashTable.put(i, value);
			value++;
		}
		value = 'Z';
		for (int i = 35; i <= 60; i++) 	// 35-60存储Z-A
		{
			hashTable.put(i, value);
			value--;
		}
		// 61-63存储B-D
		hashTable.put(61, 'B');
		hashTable.put(62, 'C');
		hashTable.put(63, 'D');

		return hashTable;
	}
	
	
	// 获取5位随机校验码
	public static String getCheckCode()
	{
		String code = "";
		
		HashMap<Integer, Character> map = createTable();
		for(int i = 0; i < 5; i++)
		{
			code += map.get(new Random().nextInt(63));
		}
		
		return code;
	}
	
	
	public static void main(String[] args)
	{
		System.out.println(encrypt("tanyouzhong"));
		System.out.println(getCheckCode());
	}
}
