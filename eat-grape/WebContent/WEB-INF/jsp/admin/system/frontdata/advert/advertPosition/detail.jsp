<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<style type="text/css">
<!--
.STYLE1 {
	font-family: "华文楷体";
	font-size: 30px;
}
-->
</style>

<div class="pageContent" layoutH="32" >
	<table width="100%" border="0" align="center">
	  <tr>
	    <td>
		    <table width="100%" border="0">
		      <tr>
		        <td height="60" align="center"><span class="STYLE1">[${advertPosition.positionName}] - 详细信息</span>				</td>
		      </tr>
		      <tr>
		        <td>
		        	<table width="100%" border="0">
			          <tr>
			            <td width="20%" height="50" align="right">名&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;称：</td>
			            <td width="30%" height="50">${advertPosition.positionName}</td>
			            <td width="20%" height="50" align="right">尺&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;寸：</td>
			            <td width="30%" height="50">${advertPosition.positionWidth} * ${advertPosition.positionHeight}</td>
			          </tr>
			          <tr>
			            <td width="20%" height="50" align="right">描&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;述：</td>
			            <td height="50" colspan="3">${advertPosition.positionDescription}</td>
		              </tr>
			          <tr>
			            <td width="20%" height="50" align="right">模版代码：</td>
			            <td height="50" colspan="3">
				            <label>
				            	<textarea cols="80" rows="13">${advertPosition.positionStyle}</textarea>
				            </label>
			          	</td>
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
		<li><div class="button"><div class="buttonContent"><button type="button" class="close">关闭</button></div></div></li>
	</ul>
</div>