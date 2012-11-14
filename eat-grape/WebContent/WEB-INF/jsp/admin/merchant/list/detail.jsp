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

<div class="pageContent" layoutH="32">
	<table width="80%" border="0" align="center">
	  <tr>
	    <td>
		    <table width="100%" border="0">
		      <tr>
		        <td height="60" align="center">
					<img src="${ctx}${merchant.merchantLogoUrl}" alt="${merchant.merchantName}" align="absmiddle"/>
					<span class="STYLE1"> - [${merchant.merchantName}] - 详细基本信息</span>
				</td>
		      </tr>
		      <tr>
		        <td>
		        	<table width="100%" border="0">
			          <tr>
			            <td width="20%" height="50" align="right">商&nbsp;家&nbsp;名&nbsp;称：</td>
			            <td width="30%" height="50">${merchant.merchantName}</td>
			            <td width="20%" height="50" align="right">商&nbsp;家&nbsp;电&nbsp;话：</td>
			            <td width="30%" height="50">${merchant.merchantPhone}</td>
			          </tr>
			          <tr>
			            <td width="20%" height="50" align="right">商&nbsp;家&nbsp;邮&nbsp;箱：</td>
			            <td width="30%" height="50">${merchant.merchantEmail}</td>
			            <td width="20%" height="50" align="right">商&nbsp;家&nbsp;地&nbsp;址：</td>
			            <td width="30%" height="50" nowrap="nowrap">${merchant.merchantAddress}</td>
			          </tr>
			          <tr>
			            <td width="20%" height="50" align="right">法定代表人：</td>
			            <td width="30%" height="50">${merchant.legalName}</td>
			            <td width="20%" height="50" align="right">加&nbsp;盟&nbsp;时&nbsp;间：</td>
			            <td width="30%" height="50">${merchant.merchantJoinTime}</td>
			          </tr>
			          <tr>
			            <td width="20%" height="50" align="right">身份证号码：</td>
			            <td width="30%" height="50">${merchant.legalIdCard}</td>
			            <td width="20%" height="50" align="right">家&nbsp;庭&nbsp;地&nbsp;址：</td>
			            <td width="30%" height="50" nowrap="nowrap">${merchant.legalHomeAddress}</td>
			          </tr>
			          <tr>
			            <td width="20%" height="50" align="right">法定人电话：</td>
			            <td width="30%" height="50">${merchant.legalPhone}</td>
			            <td width="20%" height="50" align="right">现&nbsp;居&nbsp;地&nbsp;址：</td>
			            <td width="30%" height="50" nowrap="nowrap">${merchant.legalAddress}</td>
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