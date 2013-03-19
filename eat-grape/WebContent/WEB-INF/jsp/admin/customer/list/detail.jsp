<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<link type="text/css" href="${ctx}/style/backend/common/style.css" rel="stylesheet"/>
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
		        	<s:if test="#request.customer.headPicUrl == ''">
						<img src="${ctx}/images/backend/no_photo.jpg" title="${customer.loginEmail}" align="absmiddle"/>
					</s:if>
					<s:else>
						<img src="${ctx}${customer.headPicUrl}" title="${customer.loginEmail}" align="absmiddle"/>
					</s:else>
					<span class="STYLE1"> - [${customer.loginEmail}] - 详细基本信息</span>
				</td>
		      </tr>
		      <tr>
		        <td>
		        	<table width="100%" border="0">
			          <tr>
			            <td width="20%" height="50" align="right"><span class="detail_column_title">登&nbsp;录&nbsp;邮&nbsp;箱：</span></td>
			            <td width="30%" height="50">${customer.loginEmail}</td>
			            <td width="20%" height="50" align="right"><span class="detail_column_title">顾&nbsp;客&nbsp;昵&nbsp;称：</span></td>
			            <td width="30%" height="50">${customer.nickName}</td>
			          </tr>
			          <tr>
			            <td width="20%" height="50" align="right"><span class="detail_column_title">登&nbsp;录&nbsp;密&nbsp;码：</span></td>
			            <td width="30%" height="50">${customer.password}</td>
			            <td width="20%" height="50" align="right"><span class="detail_column_title">真&nbsp;实&nbsp;姓&nbsp;名：</span></td>
			            <td width="30%" height="50" nowrap="nowrap">${customer.trueName}</td>
			          </tr>
			          <tr>
			            <td width="20%" height="50" align="right"><span class="detail_column_title">移&nbsp;动&nbsp;电&nbsp;话：</span></td>
			            <td width="30%" height="50">${customer.mobilePhone}</td>
			            <td width="20%" height="50" align="right"><span class="detail_column_title">账&nbsp;号&nbsp;状&nbsp;态：</span></td>
			            <td width="30%" height="50">${customer.isEnabledStr}</td>
			          </tr>
			          <tr>
			            <td width="20%" height="50" align="right"><span class="detail_column_title">当&nbsp;前&nbsp;积&nbsp;分：</span></td>
			            <td width="30%" height="50">${customer.score}</td>
			            <td width="20%" height="50" align="right"><span class="detail_column_title">顾&nbsp;客&nbsp;类&nbsp;型：</span></td>
			            <td width="30%" height="50" nowrap="nowrap">${customer.customerTypeStr}</td>
			          </tr>
			          <tr>
			            <td width="20%" height="50" align="right"><span class="detail_column_title">注&nbsp;册&nbsp;时&nbsp;间：</span></td>
			            <td width="30%" height="50">${customer.registerTimeStr}</td>
			            <td width="20%" height="50" align="right"><span class="detail_column_title">注&nbsp;册&nbsp;IP：</span></td>
			            <td width="30%" height="50" nowrap="nowrap">${customer.registerIp}</td>
			          </tr>
			          <tr>
			            <td width="20%" height="50" align="right"><span class="detail_column_title">最后登录时间：</span></td>
			            <td width="30%" height="50">${customer.lastLoginTimeStr}</td>
			            <td width="20%" height="50" align="right"><span class="detail_column_title">最后登陆IP：</span></td>
			            <td width="30%" height="50" nowrap="nowrap">${customer.lastLoginIp}</td>
			          </tr>
			          <tr>
			            <td width="20%" height="50" align="right"><span class="detail_column_title">游&nbsp;客&nbsp;ID：</span></td>
			            <td width="30%" height="50">${customer.visitorUuid}</td>
			            <td width="20%" height="50" align="right"><span class="detail_column_title">关&nbsp;联&nbsp;QQ：</span></td>
			            <td width="30%" height="50" nowrap="nowrap">${customer.relativeQq}</td>
			          </tr>
			          <tr>
			            <td width="20%" height="50" align="right"><span class="detail_column_title">关&nbsp;联&nbsp;新&nbsp;浪：</span></td>
			            <td width="30%" height="50">${customer.relativeSina}</td>
			            <td width="20%" height="50" align="right"><span class="detail_column_title">关联人人网：</span></td>
			            <td width="30%" height="50" nowrap="nowrap">${customer.relativeRrw}</td>
			          </tr>
			          <tr>
			            <td width="20%" height="50" align="right"><span class="detail_column_title">所&nbsp;属&nbsp;社&nbsp;区：</span></td>
			            <td width="30%" height="50">${customer.communityName}</td>
			            <td width="20%" height="50" align="right"><span class="detail_column_title">所&nbsp;属&nbsp;学&nbsp;校：</span></td>
			            <td width="30%" height="50" nowrap="nowrap">${customer.schoolName}</td>
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
		<li><div class="buttonActive"><div class="buttonContent"><button type="button" onclick="printData();">打印</button></div></div></li>
		<li><div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div></li>
	</ul>
</div>