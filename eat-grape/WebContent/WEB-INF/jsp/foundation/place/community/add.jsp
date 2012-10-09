<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<script type="text/javascript">
	function refreshDialogAjaxDone(json){
		//DWZ.ajaxDone(json);
		if(json.statusCode == DWZ.statusCode.ok){
			if(json.dialogId){
				if("closeCurrent" == json.callbackType){
					$.pdialog.closeCurrent();
				}
				// 刷新dialogId指定的dialog，url：刷新时可重新指定加载数据的url, data：为加载数据时所需的参数。
				var dialogId = json.dialogId;
				var pid = json.pid;
				$.pdialog.reload("${ctx}/foundation/place/community/showSetSubDist.htm?pid=" + pid + "&action=zdylbzs&dialogId=" + dialogId, {}, dialogId);
			}
		}
	}
</script>


<div class="pageContent">
	<form method="post" action="${ctx}/foundation/place/community/add.htm?navTabId=${navTabId}&action=zxdytj&dialogId=${dialogId}" class="pageForm required-validate"
			 onsubmit="return validateCallback(this, <s:if test="#attr.dialogId != \"\"">refreshDialogAjaxDone</s:if><s:else>dialogAjaxDone</s:else>);">
		<div class="pageFormContent" layoutH="56">
			<p>
				<label>社区名称：</label>
				<input name="community.name" class="required" type="text" size="30"  alt="请输入社区名称"/>
			</p>
			<p>
				<label>名称拼音：</label>
				<input name="community.pinyinName"  type="text" size="30"  alt="请输入名称拼音"/>
			</p>
		</div>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
				<li>
					<div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div>
				</li>
			</ul>
		</div>
	</form>
</div>
