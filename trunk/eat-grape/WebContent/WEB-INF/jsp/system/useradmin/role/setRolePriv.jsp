<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>

<div class="accordion" layoutH="35">
	<ul class="tree treeFolder treeCheck expand">
		${privTreeStr}
	</ul>
</div>
<div class="formBar">
	<ul>
		<li><div class="buttonActive"><div class="buttonContent"><button type="button" onclick="savePrivs()">保存</button></div></div></li>
		<li><div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div></li>
	</ul>
</div>

<script type="text/javascript">
	function savePrivs()
	{
		var chkPrivs = $("input:checked");
		
		var url = "system/useradmin/role/setPriv.htm?action=zxqxfp";
		var msg = "您确认分配这 - " + chkPrivs.length + " - 项权限吗？";
		var privsIds = "";	// 需设置的权限的ID集合
		for(var i = 0; i < chkPrivs.length; i++)
		{
			privsIds += chkPrivs[i].value + ",";
		}
		privsIds = privsIds.substring(0, privsIds.length - 1);
		var data = {
			"role.id" : "${role.id}",
			"privsIds" : privsIds,
			"navTabId" : "${navTabId}"
		};
		// Ajax保存确认
		confirm2Ajax(url, msg, data, 
			function(json){
				DWZ.ajaxDone(json);
				if(json.statusCode == DWZ.statusCode.ok)
				{
					$.pdialog.closeCurrent(); 
				}
			}, "json"
		);
	}
</script>
