<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>登录-馋八戒</title>
	<%@ include file="/WEB-INF/common/jslibs.jsp"%>
	<link type="text/css" href="${ctx}/style/backend/login/layout_login.css" rel="stylesheet"/>
</head>
<body class="logincss" screen_capture_injected="true">
	<form action="">
		<div class="logbox">
			<div class="loginbox">
				<table width="282" border="0" align="right" cellpadding="0" cellspacing="0">
					<tbody>
						<tr>
							<td>
								<table width="282" border="0" cellspacing="0" cellpadding="0">
									<tbody>
										<tr>
											<td height="33" style="border: 1px solid #d9d9d9; background: url(${ctx}/images/backend/login/icon_username.jpg) no-repeat; padding-left: 30px; color: #999; font-size: 14px; font-weight: bold">
												用户名<input name="username" type="text" maxlength="16" id="username" class="login_input" onkeydown="clickLoginButton(event, 'loginBtn')" onfocus="getFocus(this.id)" onblur="loseFocus(this.id)"/>
											</td>
										</tr>
									</tbody>
								</table>
							</td>
						</tr>
						<tr>
							<td style="padding-top: 12px">
								<table width="282" border="0" cellspacing="0" cellpadding="0">
									<tbody>
										<tr>
											<td height="33" style="border: 1px solid #d9d9d9; background: url(${ctx}/images/backend/login/icon_password.jpg) no-repeat; padding-left: 30px; color: #999; font-size: 14px; font-weight: bold">
												密&nbsp;&nbsp;&nbsp;&nbsp;码<input name="password" type="password" maxlength="16" id="password" class="login_input" onkeydown="clickLoginButton(event, 'loginBtn')" onfocus="getFocus(this.id)" onblur="loseFocus(this.id)"/>
											</td>
										</tr>
									</tbody>
								</table>
							</td>
						</tr>
						<tr>
							<td style="padding-top: 12px">
								<table width="282" border="0" cellspacing="0" cellpadding="0">
									<tbody>
										<tr>
											<td height="33" style="border: 1px solid #d9d9d9; background: url(${ctx}/images/backend/login/icon_password.jpg) no-repeat; padding-left: 30px; color: #999; font-size: 14px; font-weight: bold" nowrap="nowrap">
												验证码<input name="verifycode" type="text" maxlength="4" id="verifycode" class="code" onkeydown="clickLoginButton(event, 'loginBtn')" onfocus="getFocus(this.id)" onblur="loseFocus(this.id)"/>
												<img id="verifyImg" src="verifycode.htm" title="换一张" width="75" height="24" onclick="changeImage(this)"/>
											</td>
										</tr>
									</tbody>
								</table>
							</td>
						</tr>
						<tr>
							<td height="50" valign="bottom">
								<table border="0" align="center" cellpadding="0" cellspacing="0">
									<tbody>
										<tr>
											<td>
												<input type="button" name="loginBtn" id="loginBtn" class="sub" onclick="check();"/>
											</td>
											<td width="80" align="right">
												&nbsp;
											</td>
										</tr>
									</tbody>
								</table>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<p>
			Copyright<span class="copyright">©</span> 2012-2013 www.c8j.cn
		</p>
	</form>
</body>
</html>