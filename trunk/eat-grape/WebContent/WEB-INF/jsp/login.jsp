<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>登陆后台管理系统</title>
	<%@ include file="/WEB-INF/common/jslibs.jsp"%>
	<style type="text/css">
		body { 
			margin: 0px;
			background: #FFFFFF;
			background-image: url(${ctx}/image/login_bg.jpg);
			background-repeat: repeat-x;
		}
	</style>
</head>
<body>
	<div id="login">
		<div id="login_content">
			<div class="loginForm">
				<form action="">
					<p>
						<label>用户名&nbsp;：</label>
						<input id="username" type="text" name="username" maxlength="16"
							class="login_input" onkeydown="clickLoginButton(event, 'loginBtn')"
								onfocus="getFocus(this.id)" onblur="loseFocus(this.id)"/>
					</p>
					<p>
						<label>密&nbsp;&nbsp;&nbsp;&nbsp;码&nbsp;：</label>
						<input id="password" type="password" name="password" maxlength="16"
							class="login_input" onkeydown="clickLoginButton(event, 'loginBtn')" 
								onfocus="getFocus(this.id)" onblur="loseFocus(this.id)"/>
					</p>
					<p>
						<label>验证码&nbsp;：</label>
						<input id="verifycode" type="text" name="verifycode" maxlength="4"
							 class="code" onkeydown="clickLoginButton(event, 'loginBtn')"
								onfocus="getFocus(this.id)" onblur="loseFocus(this.id)"/>
						<span>
							<img id="verifyImg" src="verifycode.htm" alt="换一张" width="75" height="24" onclick="changeImage(this)"/>									
						</span>
					</p>
					<div class="login_bar">
						<input id="loginBtn" class="sub" type="button" value="" onclick="check()" 
							onmouseover="mouseOver(this.id, '${ctx}/image/login_btn_bg2.jpg')" 
								onmouseout="mouseOut(this.id, '${ctx}/image/login_btn_bg1.jpg')"/>
						<input id="resetBtn" class="reset" type="reset" value="" 
							onmouseover="mouseOver(this.id, '${ctx}/image/reset_btn_bg2.jpg')" 
								onmouseout="mouseOut(this.id, '${ctx}/image/reset_btn_bg1.jpg')"/>
					</div>
				</form>
			</div>
			<div class="login_banner"><img src="${ctx}/image/login_banner.jpg" /></div>
	  	</div>
		<div id="login_footer">
			Copyright &copy; 2012 eatle Inc. All Rights Reserved.
		</div>
	</div>
</body>
</html>