<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<link type="text/css" href="${ctx}/style/backend/common/style.css" rel="stylesheet"/>
<style type="text/css">
<!--
.STYLE1 {
	font-family: "宋体";
	font-size: 25px;
}
-->
</style>

<div class="pageContent" layoutH="32">
	<table width="100%" border="0" align="center">
	  <tr>
	    <td>
		    <table width="100%" border="0">
		      <tr>
		        <td height="50" align="center"><span class="STYLE1">[${order.orderNum}] - 订单详细信息</span></td>
		      </tr>
		      <tr>
		        <td>
		        	<table width="100%" border="0">
			          <tr>
			            <td width="10%" height="30" align="right"><span class="detail_column_title">订&nbsp;&nbsp;单&nbsp;&nbsp;号：</span></td>
			            <td width="24%" height="30">${order.orderNum}</td>
			            <td width="12%" height="30" align="right"><span class="detail_column_title">联&nbsp;&nbsp;系&nbsp;&nbsp;人：</span></td>
		                <td width="22%" height="30">${order.contactName}</td>
		                <td width="10%" height="30" align="right"><span class="detail_column_title">联系电话：</span></td>
		                <td width="22%" height="30">${order.contactPhone}</td>
			          </tr>
			          <tr>
			            <td width="10%" height="30" align="right"><span class="detail_column_title">备选电话：</span></td>
			            <td width="24%" height="30">${order.anotherPhone}</td>
		                <td width="12%" height="30" align="right"><span class="detail_column_title">订单状态：</span></td>
			            <td width="22%" height="30">${order.orderStatusStr}</td>
			            <td width="10%" height="30" align="right"><span class="detail_column_title">状态说明：</span></td>
			            <td width="22%" height="30">${order.orderStatusDescription}</td>
			          </tr>
			          <tr>
			            <td width="10%" height="30" align="right"><span class="detail_column_title">通知类型：</span></td>
			            <td width="24%" height="30">${order.notifyTypeStr}</td>
		                <td width="12%" height="30" align="right"><span class="detail_column_title">总价/折扣：</span></td>
			            <td width="22%" height="30">${order.orderTotalMoney}/${order.orderDiscount}</td>
			            <td width="10%" height="30" align="right"><span class="detail_column_title">餐厅名称：</span></td>
			            <td width="22%" height="30">${order.restaurantName}</td>
			          </tr>
			          <tr>
			            <td width="10%" height="30" align="right"><span class="detail_column_title">订餐顾客：</span></td>
			            <td width="24%" height="30">${order.customerName}</td>
		                <td width="12%" height="30" align="right"><span class="detail_column_title">下单时间：</span></td>
			            <td width="22%" height="30">${order.orderTimeStr}</td>
			            <td width="10%" height="30" align="right"><span class="detail_column_title">送餐时间：</span></td>
			            <td width="22%" height="30">${order.sendTimeStr}</td>
			          </tr>
			          <tr>
			            <td width="10%" height="30" align="right"><span class="detail_column_title">送餐备注：</span></td>
			            <td width="24%" height="30">${order.sendRemark}</td>
	                    <td width="12%" height="30" align="right"><span class="detail_column_title">送餐地址：</span></td>
			            <td height="30" colspan="3">${order.sendAddress}</td>
		              </tr>
		        </table>
		       </td>
		      </tr>
		      <tr>
		        <td>&nbsp;</td>
	          </tr>
		    </table>
	  	</td>
	  </tr>
  </table>
</div>

<div class="formBar">
	<ul>
		<li><div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div></li>
	</ul>
</div>