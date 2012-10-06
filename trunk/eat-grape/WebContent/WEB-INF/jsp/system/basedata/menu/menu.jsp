<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>

<div class="accordion" style="margin: 5px 5px 0px 5px;" layoutH="10">
	<ul class="tree treeFolder treeCheck expand">
		${allMenuHtml}
	</ul>
</div>

<script type="text/javascript">
	// 右键管理菜单
	$(".menu").contextMenu('funcMgrCM', {
    	bindings : {
    		// 新增菜单
			newMenu : function(t){
				var url = "${ctx}/system/basedata/menu/showAdd.htm?menu.parentId=" + t.attr("id") + "&action=tjgnzs&navTabId=${navTabId}";
				var dlgId = "dialog_menu_" + t.attr("id");
				var title = t.text() + " - 菜单添加";
				var options = {
					mask : true,
					width :520,
					height : 252
				};
            	$.pdialog.open(url, dlgId, title, options);
            },
    		// 修改菜单
			updateMenu : function(t){
				var url = "${ctx}/system/basedata/menu/showUpdate.htm?menu.id=" + t.attr("id") + "&action=xggnzs&navTabId=${navTabId}";
				var dlgId = "dialog_menu_" + t.attr("id");
				var title = t.text() + " - 菜单修改";
				var options = {
					mask : true, 
					width :520,
					height : 250
				};
            	$.pdialog.open(url, dlgId, title, options);
            },
            // 删除菜单(支持多项)
			deleteMenu : function(t){
            	var checkBoxs = $("input:checked");
            	if(checkBoxs.length == 0)
            	{
            		alertErr("请勾选需要删除的菜单！");
            	}
            	else
	            {
	            	var url = "${ctx}/system/basedata/menu/delete.htm";
					var msg = "您确认删除这 - " + checkBoxs.length + " - 项菜单吗？";
					var delMenuIds = "";	// 需删除的菜单ID集合
					for(var i = 0; i < checkBoxs.length; i++)
					{
						delMenuIds += checkBoxs[i].value + ",";
					}
					delMenuIds = delMenuIds.substring(0, delMenuIds.length - 1);
					var data = {
						"delMenuIds" : delMenuIds,
						"action" : "zxgnsc",
						"navTabId" : "${navTabId}"
					};
					// Ajax删除确认
	            	confirm2Ajax(url, msg, data, 
	            		function(json){
		            		DWZ.ajaxDone(json);
		            		if(json.statusCode == DWZ.statusCode.ok)
		            		{
								navTab.reloadFlag("${navTabId}");
		            		}
	            		}, "json"
	            	);
            	}
            },
            // 刷新菜单树
			freshMenu : function(t){
				navTab.reloadFlag("${navTabId}");
            }
      	}
	});
</script>