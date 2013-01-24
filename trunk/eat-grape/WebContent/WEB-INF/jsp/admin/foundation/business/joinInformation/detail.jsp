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
					<span class="STYLE1">[${joinInformation.shopName}] - 加盟审核详细信息</span>
				</td>
		      </tr>
		      <tr>
		        <td>
		        	<table width="100%" border="0">
			          <tr>
			            <td width="20%" height="50" align="right"><span class="detail_column_title">餐厅名称：</span></td>
			            <td width="30%" height="50">${joinInformation.shopName}</td>
			            <td width="20%" height="50" align="right"><span class="detail_column_title">联&nbsp;&nbsp;系&nbsp;&nbsp;人：</span></td>
			            <td width="30%" height="50">${joinInformation.linkMan}</td>
			          </tr>
			          <tr>
			            <td width="20%" height="50" align="right"><span class="detail_column_title">联系电话：</span></td>
			            <td width="30%" height="50">${joinInformation.linkTel}</td>
			            <td width="20%" height="50" align="right"><span class="detail_column_title">联系邮箱：</span></td>
			            <td width="30%" height="50">${joinInformation.linkEmail}</td>
			          </tr>
			          <tr>
			            <td width="20%" height="50" align="right"><span class="detail_column_title">联系Q Q：</span></td>
			            <td width="30%" height="50">${joinInformation.linkQq}</td>
			            <td width="20%" height="50" align="right"><span class="detail_column_title">申请时间：</span></td>
			            <td width="30%" height="50">${joinInformation.subTimeStr}</td>
			          </tr>
			          <tr>
			            <td width="20%" height="50" align="right"><span class="detail_column_title">餐厅地址：</span></td>
			            <td width="30%" height="50">${joinInformation.shopAddr}</td>
			            <td width="20%" height="50" align="right"><span class="detail_column_title">送餐地点：</span></td>
			            <td width="30%" height="50">${joinInformation.sendPlace}</td>
		              </tr>
					  <tr>
			            <td width="20%" height="50" align="right"><span class="detail_column_title">审核状态：</span></td>
			            <td width="30%" height="50">${joinInformation.auditStatusStr}</td>
			            <td width="20%" height="50" align="right"><span class="detail_column_title">审核时间：</span></td>
			            <td width="30%" height="50">${joinInformation.auditTimeStr}</td>
			          </tr>
					  <tr>
			            <td width="20%" height="50" align="right"><span class="detail_column_title">审核备注：</span></td>
			            <td width="80%" height="50" colspan="3">${joinInformation.auditRemark}</td>
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