<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<style type="text/css">
<!--
.STYLE1 {
	font-family: "华文楷体";
	font-size: 25px;
}
-->
</style>

<div class="pageContent" layoutH="32">
	<table width="80%" border="0" align="center">
	  <tr>
	    <td>
		    <table width="100%" border="0">
		      <tr>
		        <td height="60" align="center">
					<span class="STYLE1">反馈建议详细信息</span>
				</td>
		      </tr>
		      <tr>
		        <td>
		        	<table width="100%" border="0">
			          <tr>
			            <td width="20%" height="50" align="right">反馈用户：</td>
			            <td width="30%" height="50">${feedback.identifyStr}</td>
			            <td width="20%" height="50" align="right">身份类型：</td>
			            <td width="30%" height="50">${feedback.identifyTypeStr}</td>
			          </tr>
			          <tr>
			            <td width="20%" height="50" align="right">联系邮箱：</td>
			            <td width="30%" height="50">${feedback.email}</td>
			            <td width="20%" height="50" align="right">反馈时间：</td>
			            <td width="30%" height="50">${feedback.subTimeStr}</td>
		              </tr>
			          <tr>
			            <td width="20%" height="50" align="right">反馈内容：</td>
			            <td width="80%" height="50" colspan="3">${feedback.content}</td>
		              </tr>
					  <tr>
			            <td width="20%" height="50" align="right">处理状态：</td>
			            <td width="30%" height="50">${feedback.handleStatusStr}</td>
			            <td width="20%" height="50" align="right">处理时间：</td>
			            <td width="30%" height="50">${feedback.handleTimeStr}</td>
			          </tr>
					  <tr>
			            <td width="20%" height="50" align="right">处理备注：</td>
			            <td width="80%" height="50" colspan="3">${feedback.handleRemark}</td>
			          </tr>
			        </table>
		      	</td>
		      </tr>
		    </table>
	  	</td>
	  </tr>
	</table>
</div>

<div class="formBar">
	<ul>
		<li><div class="buttonActive"><div class="buttonContent"><button type="button">打印</button></div></div></li>
		<li><div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div></li>
	</ul>
</div>