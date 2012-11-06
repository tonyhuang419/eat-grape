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
					<span class="STYLE1">[${recommendMerchant.shopName}] - 推荐商家详细信息</span>
				</td>
		      </tr>
		      <tr>
		        <td>
		        	<table width="100%" border="0">
			          <tr>
			            <td width="20%" height="50" align="right">餐厅名称：</td>
			            <td width="30%" height="50">${recommendMerchant.shopName}</td>
			            <td width="20%" height="50" align="right">餐厅电话：</td>
			            <td width="30%" height="50">${recommendMerchant.shopTel}</td>
			          </tr>
			          <tr>
			            <td width="20%" height="50" align="right">餐厅地址：</td>
			            <td width="30%" height="50">${recommendMerchant.shopAddr}</td>
			            <td width="20%" height="50" align="right">推荐用户：</td>
			            <td width="30%" height="50">${recommendMerchant.identifyStr}</td>
		              </tr>
			          <tr>
			            <td width="20%" height="50" align="right">身份类型：</td>
			            <td width="30%" height="50">${recommendMerchant.identifyTypeStr}</td>
			            <td width="20%" height="50" align="right">推荐时间：</td>
			            <td width="30%" height="50">${recommendMerchant.subTimeStr}</td>
			          </tr>
					  <tr>
			            <td width="20%" height="50" align="right">处理状态：</td>
			            <td width="30%" height="50">${recommendMerchant.handleStatusStr}</td>
			            <td width="20%" height="50" align="right">处理时间：</td>
			            <td width="30%" height="50">${recommendMerchant.handleTimeStr}</td>
			          </tr>
					  <tr>
			            <td width="20%" height="50" align="right">处理备注：</td>
			            <td width="80%" height="50" colspan="3">${recommendMerchant.handleRemark}</td>
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