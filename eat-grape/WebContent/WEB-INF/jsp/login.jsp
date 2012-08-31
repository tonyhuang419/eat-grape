<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>后台管理</title>
	<link href="themes/css/login.css" rel="stylesheet" type="text/css" />
	<%@ include file="/WEB-INF/common/jslibs.jsp"%>
</head>

<body>
	<div id="login">
		<div id="login_header">
			<h1 class="login_logo">
				<a href="http://demo.dwzjs.com"><img src="themes/default/images/login_logo.gif" /></a>
			</h1>
			<div class="login_headerContent">
				<div class="navList">
					<ul>
						<li><a href="#">设为首页</a></li>
						<li><a href="http://bbs.dwzjs.com">反馈</a></li>
						<li><a href="doc/dwz-user-guide.pdf" target="_blank">帮助</a></li>
					</ul>
				</div>
				<h2 class="login_title"><img src="themes/default/images/login_title.png" /></h2>
			</div>
		</div>
		<div id="login_content">
			<div class="loginForm">
					<p>
						<label>用户名&nbsp;：</label>
						<input id="username" type="text" name="username" maxlength="16"
							class="login_input" onkeydown="clickLoginButton(event, 'loginBtn')"/>
					</p>
					<p>
						<label>密&nbsp;&nbsp;&nbsp;&nbsp;码&nbsp;：</label>
						<input id="password" type="password" name="password" maxlength="16"
							class="login_input" onkeydown="clickLoginButton(event, 'loginBtn')"/>
					</p>
					<p>
						<label>验证码&nbsp;：</label>
						<input id="verifycode" type="text" name="verifycode" maxlength="4"
							 class="code" onkeydown="clickLoginButton(event, 'loginBtn')"/>
						<span>
							<img id="verifyImg" src="verifycode.htm" alt="换一张" width="75" height="24" onclick="changeImage(this)"/>
						</span>
					</p>
					<div class="login_bar">
						<input id="loginBtn" class="sub" type="button" value="" onclick="check()" />
					</div>
			</div>
			<div class="login_banner"><img src="themes/default/images/login_banner.jpg" /></div>
			<div class="login_main">
				<ul class="helpList">
					<li><a href="#">下载驱动程序</a></li>
					<li><a href="#">如何安装密钥驱动程序？</a></li>
					<li><a href="#">忘记密码怎么办？</a></li>
					<li><a href="#">为什么登录失败？</a></li>
				</ul>
				<div class="login_inner">
					<p>您可以使用 网易网盘 ，随时存，随地取</p>
					<p>您还可以使用 闪电邮 在桌面随时提醒邮件到达，快速收发邮件。</p>
					<p>在 百宝箱 里您可以查星座，订机票，看小说，学做菜…</p>
				</div>
			</div>
		</div>
		<div id="login_footer">
			Copyright &copy; 2012 eatle Inc. All Rights Reserved.
		</div>
	</div>
</body>
</html>