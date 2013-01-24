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
		        <td height="50" align="center"><span class="STYLE1">[${convertGoods.name}] - 商品详细信息</span></td>
		      </tr>
		      <tr>
		        <td>
		        	<table width="100%" border="0">
			          <tr>
			            <td width="20%" height="45" align="right"><span class="detail_column_title">商&nbsp;家&nbsp;名&nbsp;称：</span></td>
			            <td width="30%" height="45">${convertGoods.name}</td>
			            <td rowspan="4">
			            	<s:if test="#request.convertGoods.picUrl == null">
			            		<img src="${ctx}/images/backend/no_photo.jpg" title="暂未上传" align="absmiddle"/>			            	</s:if>
			            	<s:else>
			            		<img src="${ctx}${convertGoods.picUrl}" title="${convertGoods.name}" align="absmiddle"/>			            	</s:else>			            </td>
		              </tr>
			          <tr>
			            <td width="20%" height="45" align="right"><span class="detail_column_title">总&nbsp;共&nbsp;数&nbsp;量：</span></td>
			            <td width="30%" height="45">${convertGoods.total}</td>
		              </tr>
			          <tr>
			            <td width="20%" height="45" align="right"><span class="detail_column_title">剩 余 数 量：</span></td>
			            <td width="30%" height="45">${convertGoods.surplus}</td>
		              </tr>
			          <tr>
			            <td width="20%" height="45" align="right"><span class="detail_column_title">所 需 积 分：</span></td>
			            <td width="30%" height="45">${convertGoods.score} 积分</td>
		              </tr>
			          <tr>
			            <td width="20%" height="45" align="right"><span class="detail_column_title">商 品 描 述：</span></td>
			            <td height="45" colspan="2">${convertGoods.description}</td>
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
		<li><div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div></li>
	</ul>
</div>