<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>

<script type="text/javascript" src="${ctx}/js/backend/base/modifyPwd/index.js"></script>
<div class="pageContent">
	<form id="modifyPwdForm" method="post" action="${ctx}/admin/base/modifyPwd/modify.htm?action=zxzhtj&navTabId=${param.navTabId}" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
		<div class="pageFormContent" layoutH="56">
		    <table width="60%" height="200" border="0" align="center" cellpadding="0" cellspacing="0" style="margin: 30px 0px 0px 30px">
              <tr>
                <td width="15%" align="right"><label>用户名称：</label></td>
                <td>
					<input name="user.id" type="hidden" value="${user.id}"/>
					<input type="text" size="35" readonly="readonly" value="${user.userName}"/>
				</td>
              </tr>
              <tr>
                <td width="15%" align="right"><label>旧&nbsp;&nbsp;密&nbsp;&nbsp;码：</label></td>
                <td>
					<input id="oldPwd" class="required" type="text" size="35" alt="请输入旧密码" style="ime-mode: disabled;" name="oldPwd"/>
				</td>
              </tr>
              <tr>
                <td width="15%" align="right"><label>新&nbsp;&nbsp;密&nbsp;&nbsp;码：</label></td>
                <td>
					<input id="newPwd" class="required" type="text" size="35" alt="请输入新密码" style="ime-mode: disabled;"/>
				</td>
              </tr>
              <tr>
                <td width="15%" align="right"><label>确认密码：</label></td>
                <td>
					<input id="confirmPwd" class="required" type="text" size="35" alt="请再次输入新密码" style="ime-mode: disabled;" name="user.pwd">
				</td>
              </tr>
            </table>
		</div>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button id="modifyBtn" type="button">修改</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button type="button" class="close">放弃</button></div></div></li>
			</ul>
		</div>
	</form>
</div>
