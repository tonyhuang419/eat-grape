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
				$.pdialog.reload("${ctx}/foundation/place/shool/showSetSubDist.htm?pid=" + pid + "&action=zdylbzs&dialogId=" + dialogId, {}, dialogId);
			}
		}
	}
</script>


<div class="pageContent">
	<form method="post" action="${ctx}/foundation/place/shool/add.htm?navTabId=${navTabId}&action=zxdytj&dialogId=${dialogId}" class="pageForm required-validate"
			 onsubmit="return validateCallback(this, <s:if test="#attr.dialogId != \"\"">refreshDialogAjaxDone</s:if><s:else>dialogAjaxDone</s:else>);">
		<div class="pageFormContent" layoutH="56">
			<p>
				<label>学校名称：</label>
				<input name="shool.name" class="required" type="text" size="30"  alt="请输入学校名称"/>
			</p>
			<p>
				<label>学校拼音名称：</label>
				<input name="shool.englishName"  type="text" size="30"  alt="请输入学校拼音名称"/>
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
