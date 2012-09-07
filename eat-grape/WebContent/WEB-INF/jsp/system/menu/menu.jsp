<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>

<div style="margin: 5px 5px 0px 5px;" layoutH="10">
	<div class="accordion" fillSpace="sidebar">
		${allMenuHtml}
	</div>
</div>

<script type="text/javascript">
	// 右键管理菜单
	$(".menu").contextMenu('funcMgrCM', {
    	bindings : {
    		// 新增菜单
			newMenu : function(t){
				var url = "system/menu/showAdd.htm?menu.parentId=" + t.attr("id") + "&navTabId=${navTabId}";
				var dlgId = "dialog_menu_" + t.attr("id");
				var title = t.text() + " - 菜单添加";
				var options = {
					mask : true, 
					width :520,
					height : 250
				};
            	$.pdialog.open(url, dlgId, title, options);
            },
    		// 修改菜单
			updateMenu : function(t){
				var url = "system/menu/showUpdate.htm?menu.id=" + t.attr("id") + "&navTabId=${navTabId}";
				var dlgId = "dialog_menu_" + t.attr("id");
				var title = t.text() + " - 菜单修改";
				var options = {
					mask : true, 
					width :520,
					height : 250
				};
            	$.pdialog.open(url, dlgId, title, options);
            },
            // 删除菜单
			deleteMenu : function(t){
				var url = "system/menu/delete.htm";
				var msg = "您确认删除 ”" + t.text() + "“ 吗？";
				var data = {
					"menu.id" : t.attr("id"),
					"navTabId" : "${navTabId}"
				};
            	confirm2Ajax(url, msg, data, null, "json");
            },
            // 刷新菜单树
			freshMenu : function(t){
				navTab.reloadFlag("${navTabId}");
            }
      	}
	});
</script>