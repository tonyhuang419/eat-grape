package com.eatle.web.action;

import java.awt.Color;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;

import org.apache.struts2.ServletActionContext;

import com.eatle.utils.CreateVerificationCode;

public class VerifyCodeAction extends BaseAction
{
	private static final long serialVersionUID = 4948574845742310L;
	
	// 保存服务器端生成的验证码值（由com.eatle.utils.CreateVerificationCode.java产生验证码图片时赋值）
	public static String verifyCode_s = "";
	
	public InputStream  getVerifyCode() throws Exception 
	{
		// 验证码图片包装输出流
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		// 验证码图片输出流
		ImageOutputStream iops = ImageIO.createImageOutputStream(baos);
		// 将获取的验证码图片写到输出流
		ImageIO.write(CreateVerificationCode.getNumCheckCode(75, 25,
				new Color(223, 241, 255), new Color(100, 195, 246), 4, 3), "gif", iops);
		// 以上面的输出流为源创建输入流
		ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
		
		// 将服务器端生成的验证码值存入Session
		ServletActionContext.getRequest().getSession().setAttribute("verifyCode_s", verifyCode_s);

		// 返回输入流
		return bais;
	}
}
