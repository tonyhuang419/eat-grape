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
					<img src="${ctx}/${restaurant.logoUrl}" alt="" align="absmiddle"/>
					<span class="STYLE1"> - [${restaurant.name}] - 详细基本信息</span></td>
		      </tr>
		      <tr>
		        <td>
		        	<table width="100%" border="0">
			          <tr>
			            <td width="20%" height="50" align="right">餐厅名称：</td>
			            <td width="30%" height="50">${restaurant.name}</td>
			            <td width="20%" height="50" align="right">联&nbsp;&nbsp;系&nbsp;&nbsp;人：</td>
			            <td width="30%" height="50">${restaurant.contactName}</td>
			          </tr>
			          <tr>
			            <td width="20%" height="50" align="right">联系电话：</td>
			            <td width="30%" height="50">${restaurant.contactPhone}</td>
			            <td width="20%" height="50" align="right">联系邮箱：</td>
			            <td width="30%" height="50">${restaurant.contactEmail}</td>
			          </tr>
			          <tr>
			            <td width="20%" height="50" align="right">联系Q Q：</td>
			            <td width="30%" height="50">${restaurant.contactQq}</td>
			            <td width="20%" height="50" align="right">营业时间：</td>
			            <td width="30%" height="50">${restaurant.businessHours}</td>
			          </tr>
			          <tr>
			            <td width="20%" height="50" align="right">起送价格： </td>
			            <td width="30%" height="50">${restaurant.sendUpPrice} 元</td>
			            <td width="20%" height="50" align="right">餐厅地址：</td>
			            <td width="30%" height="50">${restaurant.address}</td>
			          </tr>
			          <tr>
			            <td width="20%" height="50" align="right">送餐说明：</td>
			            <td width="30%" height="50">${restaurant.sendMealsDescription}</td>
			            <td width="20%" height="50" align="right">所属商家：</td>
			            <td width="30%" height="50">${restaurant.merchantName}</td>
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