<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>

<style>
<!--
.STYLE1 {font-size: 14px}
-->
</style>

<div class="pageContent" layoutH="35">
	<table width="80%" border="0" align="center" cellpadding="1" cellspacing="1" style="margin: 20px 0px 0px 0px;">
		<tr>
		  	<td height="80" colspan="5" align="center">
				<table width="100%" border="0" cellspacing="0" cellpadding="0" style="margin-bottom: 10px;">
                  <tr>
                    <td width="30%" align="right">
						<img src="${ctx}${restaurant.logoUrl}" title="${restaurant.merchantName}" style="margin-right: 25px;"/>
					</td>
                    <td width="70%" style="border-bottom:#ddd solid" align="left">
						<span style="font-size: 25px;padding-left: 25px;">${restaurant.name}</span>
					</td>
                  </tr>
                </table>
		  	</td>
	  	</tr>
		<tr>
			<td height="30" colspan="5">
				<span class="STYLE1">【餐厅基本信息】</span>
			</td>
		</tr>
		<tr>
			<td colspan="5" align="right">
				<table width="100%" border="0" cellspacing="0" cellpadding="0" class="table">
					<tr>
						<td width="15%" height="25" align="right">隶属单位：</td>
						<td height="25" align="left" align="left">${restaurant.merchantName}</td>
					</tr>
					<tr>
						<td width="15%" height="25" align="right">分店名称：</td>
						<td height="25" align="left">${restaurant.name}</td>
					</tr>
					<tr>
						<td width="15%" height="25" align="right">餐厅地址：</td>
						<td height="25" align="left">${restaurant.address}</td>
					</tr>
					<tr>
                      <td width="15%" height="25" align="right">主营类型： </td>
					  <td height="25" align="left">${restaurant.shopTypeStr}</td>
				  </tr>
				  <tr>
					  <td height="25" align="right">加盟时间：</td>
					  <td height="25" align="left">${restaurant.businessHours}</td>
				  </tr>
					<tr>
						<td width="15%" height="25" align="right">营业时间：</td>
						<td height="25" align="left">${restaurant.businessHours}</td>
					</tr>
					<tr>
                      <td width="15%" height="25" align="right">起送价格： </td>
					  <td height="25" align="left">${restaurant.sendUpPrice}</td>
				  </tr>
					
					<tr>
						<td width="15%" height="25" align="right">送餐速度：</td>
						<td height="25" align="left">${restaurant.sendMealsSpeeding}</td>
					</tr>
					<tr>
						<td width="15%" height="25" align="right">送餐说明：</td>
						<td height="25" align="left">${restaurant.sendMealsDescription}</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td height="30" colspan="5"><span class="STYLE1">【餐厅联系信息】</span></td>
		</tr>
		<tr>
			<td align="right">
				<table width="100%" border="0" cellspacing="0" cellpadding="0" class="table">
					<tr>
                      <td width="15%" height="25" align="right">经理姓名： </td>
					  <td height="25" align="left">${restaurant.contactName}</td>
					  <td width="15%" height="25" align="right">联系电话： </td>
					  <td height="25" align="left">${restaurant.contactPhone}</td>
				  </tr>
					<tr>
                      <td width="15%" height="25" align="right">联系邮箱： </td>
					  <td height="25" align="left">${restaurant.contactEmail}</td>
					  <td width="15%" height="25" align="right">联系QQ： </td>
					  <td height="25" align="left">${restaurant.contactQq}</td>
				  </tr>
				</table>			
			</td>
		</tr>
	</table>
</div>
<div class="formBar">
	<ul>
		<li><div class="buttonActive"><div class="buttonContent"><button id="saveColor" type="button">我要编辑餐厅信息</button></div></div></li>
	</ul>
</div>