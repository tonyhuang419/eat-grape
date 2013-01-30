<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML xmlns="http://www.w3.org/1999/xhtml">
	<HEAD>
		<title>登录-馋八戒</title>
		<%@ include file="/WEB-INF/common/jslibs.jsp"%>
		<STYLE type=text/css>
			BODY {
				FONT-SIZE: 12px;
				BACKGROUND: #FFFFFF;
				FONT-FAMILY: 宋体
			}
			
			TD {
				FONT-SIZE: 12px;
				COLOR: #ffffff;
				FONT-FAMILY: 宋体
			}
		</STYLE>
	</HEAD>
	<BODY>
		<DIV id=div1
			style="LEFT: 0px; POSITION: absolute; TOP: 0px; BACKGROUND-COLOR: #0066ff"></DIV>
		<DIV id=div2
			style="LEFT: 0px; POSITION: absolute; TOP: 0px; BACKGROUND-COLOR: #0066ff"></DIV>
		<SCRIPT language="javascript"> 
			var speed = 20;
			var temp = new Array(); 
			var clipright = document.body.clientWidth / 2,clipleft = 0; 
			for (i=1; i <= 2; i++){ 
				temp[i] = eval("document.getElementById('div" + i + "').style");
				temp[i].width = document.body.clientWidth / 2;
				temp[i].height = document.body.clientHeight;
				temp[i].left = (i-1) * parseInt(temp[i].width);
			} 
			function openit(){ 
				clipright -= speed;
				temp[1].clip = "rect(0 " + clipright + " auto 0)";
				clipleft += speed;
				temp[2].clip="rect(0 auto auto " + clipleft + ")";
				if (clipright <= 0)
					clearInterval(tim);
			} 
			tim = setInterval("openit()",100);
		</SCRIPT>
		<TABLE cellSpacing=0 cellPadding=0 width=900 align=center border=0>
			<TBODY>
				<TR>
					<TD style="HEIGHT: 105px">
						<IMG src="${ctx}/images/backend/login/login_1.gif" border=0>
					</TD>
				</TR>
				<TR>
					<TD background=${ctx}/images/backend/login/login_2.jpg height=300>
						<TABLE height=300 cellPadding=0 width=900 border=0>
							<TBODY>
								<TR>
									<TD colSpan=2 height=35></TD>
								</TR>
								<TR>
									<TD width=360></TD>
									<TD>
										<TABLE cellSpacing=0 cellPadding=2 border=0>
											<TBODY>
												<TR>
													<TD style="HEIGHT: 28px" width=80>
														登 录 名：
													</TD>
													<TD style="HEIGHT: 28px" width=150>
														<INPUT id="username" type="text" style="WIDTH: 130px; ime-mode: disabled;" name="username" 
															maxlength="16" onkeydown="clickLoginButton(event, 'loginBtn')"
																onfocus="getFocus(this.id)" onblur="loseFocus(this.id)">
													</TD>
													<TD style="HEIGHT: 28px" width=370>
														<SPAN id=RequiredFieldValidator3
															style="FONT-WEIGHT: bold; VISIBILITY: hidden; COLOR: white">请输入登录名</SPAN>
													</TD>
												</TR>
												<TR>
													<TD style="HEIGHT: 28px">
														登录密码：
													</TD>
													<TD style="HEIGHT: 28px">
														<INPUT id="password" style="WIDTH: 130px; ime-mode: disabled;" type=password name="password" 
															maxlength="16" onkeydown="clickLoginButton(event, 'loginBtn')"
																onfocus="getFocus(this.id)" onblur="loseFocus(this.id)">
													</TD>
													<TD style="HEIGHT: 28px">
														<SPAN id=RequiredFieldValidator4
															style="FONT-WEIGHT: bold; VISIBILITY: hidden; COLOR: white">请输入密码</SPAN>
													</TD>
												</TR>
												<TR>
													<TD style="HEIGHT: 28px">
														验 证 码：
													</TD>
													<TD style="HEIGHT: 28px">
														<INPUT id="verifycode" style="WIDTH: 130px; ime-mode: disabled;" name="verifycode" 
															maxlength="4" onkeydown="clickLoginButton(event, 'loginBtn');" 
																onfocus="getFocus(this.id)" onblur="loseFocus(this.id)">
													</TD>
													<TD style="HEIGHT: 28px">
														<img id="verifyImg" src="verifycode.htm" alt="换一张"
															width="75" height="24" onclick="changeImage(this);"/>
													</TD>
												</TR>
												<TR>
													<TD style="HEIGHT: 18px"></TD>
													<TD style="HEIGHT: 18px"></TD>
													<TD style="HEIGHT: 18px"></TD>
												</TR>
												<TR>
													<TD></TD>
													<TD>
														<INPUT id="loginBtn" onclick="check();" type="button"
															style="width:104px; height:36px; border: 0px; background-image: url(${ctx}/images/backend/login/login_button_1.jpg)"
																onmouseover="mouseOver(this.id, '${ctx}/images/backend/login/login_button_2.jpg')"
																	onmouseout="mouseOut(this.id, '${ctx}/images/backend/login/login_button_1.jpg')" />
													</TD>
												</TR>
											</TBODY>
										</TABLE>
									</TD>
								</TR>
							</TBODY>
						</TABLE>
					</TD>
				</TR>
				<TR>
					<TD>
						<IMG src="${ctx}/images/backend/login/login_3.jpg" border=0>
					</TD>
				</TR>
			</TBODY>
		</TABLE>
		</DIV>
		</DIV>
	</BODY>
</HTML>
