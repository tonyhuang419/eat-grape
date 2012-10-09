<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<script type="text/javascript">
	function refreshDialogAjaxDone(json){
		DWZ.ajaxDone(json);
		if(json.statusCode == DWZ.statusCode.ok){
			if(json.dialogId){
				if("closeCurrent" == json.callbackType){
					$.pdialog.closeCurrent();
				}
				// 刷新dialogId指定的dialog，url：刷新时可重新指定加载数据的url, data：为加载数据时所需的参数。
				var dialogId = json.dialogId;
				var pid = json.pid;
				$.pdialog.reload("${ctx}/system/useradmin/priv/showSetSubPriv.htm?pid=" + pid + "&action=zqxlbzs&dialogId=" + dialogId, {}, dialogId);
			}
		}
	}
</script>


<div class="pageContent">
	<form method="post" action="${ctx}/system/useradmin/priv/add.htm?navTabId=${navTabId}&action=zxqxtj&dialogId=${dialogId}" class="pageForm required-validate"
			 onsubmit="return validateCallback(this, <s:if test="#attr.dialogId != \"\"">refreshDialogAjaxDone</s:if><s:else>dialogAjaxDone</s:else>);">
		<div class="pageFormContent" layoutH="56">
			<input type="hidden"  name="priv.pid" value="${param.pid}">
			<p>
				<label>权限名称：</label>
				<input name="priv.privName" class="required" type="text" size="30"  alt="请输入权限名称"/>
			</p>
			<p>
				<label>菜单名称：</label>
				<input name="priv.meueName"  type="text" size="30"  alt="请输入菜单名称"/>
			</p>
			<p>
				<label>动作标识：</label>
				<input name="priv.action"  type="text" size="30"  alt="请输入动作标识"/>
			</p>
			<p>
				<label>描述：</label>
				<input type="text"  value="" name="priv.description" class="textInput">
			</p>
			<p>
				<label>是否显示：</label>
				<input type="checkbox" name="priv.isShow" value="1"/>
			</p>
		</div>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div></li>
			</ul>
		</div>
	</form>
</div>
