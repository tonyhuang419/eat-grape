<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>

<HTML>
	<HEAD>
		<title>Not Found</title>
		<META http-equiv=refresh content="5;URL = ${ctx}/admin/index.htm">
		<STYLE type=text/css>
			INPUT {
				FONT-SIZE: 12px
			}
			TD {
				FONT-SIZE: 12px
			}
			.p2 {
				FONT-SIZE: 12px
			}
			.p6 {
				FONT-SIZE: 12px;
				COLOR: #1b6ad8
			}
			A {
				COLOR: #1b6ad8;
				TEXT-DECORATION: none
			}
			A:hover {
				COLOR: red
			}
		</STYLE>

		<META content="Microsoft FrontPage 5.0" name=GENERATOR>
	</HEAD>
	<BODY oncontextmenu="return false" onselectstart="return false">
		<P align=center>
		</P>
		<P align=center>
		</P>
		<TABLE cellSpacing=0 cellPadding=0 width=540 align=center border=0>
			<TBODY>
				<TR>
					<TD vAlign=top height=270>
						<DIV align=center>
							<BR>
							<IMG height=211 src="${ctx}/images/404/error.gif" width=329>
							<BR>
							<BR>
							<TABLE cellSpacing=0 cellPadding=0 width="80%" border=0>
								<TBODY>
									<TR>
										<TD>
											<BR/>
											<FONT class=p2>
												<FONT color=#ff0000>
													<IMG height=13 src="${ctx}/images/404/emessage.gif" width=12/>&nbsp;无法访问本页的原因是：
												</FONT>
												<FONT color=#000000>
													您所请求的页面不存在!
												</FONT>
											</FONT>
											<BR/><BR/><BR/>
										</TD>
									</TR>
								</TBODY>
							</TABLE>
						</DIV>
					</TD>
				</TR>
				<TR>
					<TD height=5></TD>
					<TR>
						<TD align=middle>
							<CENTER>
								<TABLE cellSpacing=0 cellPadding=0 width=480 border=0>
									<TBODY>
										<TR>
											<TD width=6>
												<IMG height=26 src="${ctx}/images/404/left.gif" width=7>
											</TD>
											<TD background=${ctx}/images/404/bg.gif>
												<DIV align=center>
													<FONT class=p6>
														<A href="${ctx}/admin/index.htm">返回首页</A>
														| 
														<A href="javascript:history.go(-1)">返回出错页</A> 
														| 
														<A href="javascript:window.close();">关闭本页</A>
													</FONT>
												</DIV>
											</TD>
											<TD width=7>
												<IMG src="${ctx}/images/404/right.gif" width="7" height="26">
											</TD>
										</TR>
									</TBODY>
								</TABLE>
							</CENTER>
						</TD>
					</TR>
			</TBODY>
		</TABLE>
		<P align=center>
		</P>
		<P align=center>
		</P>
	</BODY>
</HTML>