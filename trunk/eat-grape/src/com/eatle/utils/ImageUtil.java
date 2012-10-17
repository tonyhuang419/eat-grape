package com.eatle.utils;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

/**
 * @corpor 公司：深讯信科
 * @author 作者：谭又中
 * @explain 释义：图形工具类
 * @version 日期：2012-10-11 下午01:30:44
 */
public class ImageUtil
{
	/**
	 * @Description: 缩略图像
	 * @throws IOException 
	 * @param sourceImg : 源图像File
	 * @param targetImg : 生成路径File
	 * @param targetSize : 缩小目标尺寸
	 */
	public static void thumbnails(File sourceImg, File targetImg, float targetSize) throws IOException
	{
		Image src = ImageIO.read(sourceImg); 	// 构造Image对象
		int old_w = src.getWidth(null); 		// 得到源图宽
		int old_h = src.getHeight(null); 		// 得到源图高
		int new_w = 0;
		int new_h = 0;
		float tempdouble;
		if (old_w > old_h)
		{
			tempdouble = old_w / targetSize;
		}
		else
		{
			tempdouble = old_h / targetSize;
		}
		new_w = Math.round(old_w / tempdouble);	// 计算新图宽
		new_h = Math.round(old_h / tempdouble);	// 计算新图高
		BufferedImage target = new BufferedImage(new_w, new_h, BufferedImage.TYPE_INT_RGB);
		target.getGraphics().drawImage(src, 0, 0, new_w, new_h, null);
		FileOutputStream newImage = new FileOutputStream(targetImg); 	
		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(newImage);
		encoder.encode(target);
		newImage.close();
	}
	
	public static void main(String[] args) throws IOException
	{
//		thumbnails(new File("c:/a.jpg"), new File("c:/b.jpg"), 100);
		thumbnails(new File("c:/c.png"), new File("c:/d.png"), 100);
	}
}
