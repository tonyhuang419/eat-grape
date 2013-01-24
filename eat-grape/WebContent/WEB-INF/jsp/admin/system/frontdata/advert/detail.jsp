<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<link type="text/css" href="${ctx}/style/backend/common/style.css" rel="stylesheet"/>
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
					<img src="${ctx}/${advert.logoUrl}" alt="" align="absmiddle"/>
					<span class="STYLE1"> - [${advert.name}] - 详细基本信息</span></td>
		      </tr>
		      <tr>
		        <td>
		        	<table width="100%" border="0">
			          <tr>
			            <td width="20%" height="50" align="right"><span class="detail_column_title">餐厅名称：</span></td>
			            <td width="30%" height="50">${advert.name}</td>
			            <td width="20%" height="50" align="right"><span class="detail_column_title">联&nbsp;&nbsp;系&nbsp;&nbsp;人：</span></td>
			            <td width="30%" height="50">${advert.contactName}</td>
			          </tr>
			          <tr>
			            <td width="20%" height="50" align="right"><span class="detail_column_title">联系电话：</span></td>
			            <td width="30%" height="50">${advert.contactPhone}</td>
			            <td width="20%" height="50" align="right"><span class="detail_column_title">联系邮箱：</span></td>
			            <td width="30%" height="50">${advert.contactEmail}</td>
			          </tr>
			          <tr>
			            <td width="20%" height="50" align="right"><span class="detail_column_title">联系Q Q：</span></td>
			            <td width="30%" height="50">${advert.contactQq}</td>
			            <td width="20%" height="50" align="right"><span class="detail_column_title">营业时间：</span></td>
			            <td width="30%" height="50">${advert.businessHours}</td>
			          </tr>
			          <tr>
			            <td width="20%" height="50" align="right"><span class="detail_column_title">起送价格： </span></td>
			            <td width="30%" height="50">${advert.sendUpPrice} 元</td>
			            <td width="20%" height="50" align="right"><span class="detail_column_title">餐厅地址：</span></td>
			            <td width="30%" height="50" nowrap="nowrap">${advert.address}</td>
			          </tr>
			          <tr>
			            <td width="20%" height="50" align="right"><span class="detail_column_title">送餐说明：</span></td>
			            <td width="30%" height="50">${advert.sendMealsDescription}</td>
			            <td width="20%" height="50" align="right"><span class="detail_column_title">所属商家：</span></td>
			            <td width="30%" height="50">${advert.merchantName}</td>
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