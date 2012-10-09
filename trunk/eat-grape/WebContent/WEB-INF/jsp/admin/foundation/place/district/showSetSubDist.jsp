<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<form id="pagerForm" method="post" action="${ctx}/admin/foundation/place/district/showSetSubDist.htm?action=zdylbzs">
	<!--【可选】其它查询条件，业务有关，有什么查询条件就加什么参数。
      			也可以在searchForm上设置属性rel=”pagerForm”，js框架会自动把searchForm搜索条件复制到pagerForm中 -->
	<input type="hidden" name="userName" value="${param.userName}" />
	<input type="hidden" name="email" value="${param.email}" />
</form>

<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="add" href="${ctx}/admin/foundation/place/district/showAdd.htm?pid=${param.pid}&action=tjdyzs&dialogId=${param.dialogId}" target="dialog"  mask="true" rel="${param.dialogId}_add" width="520" height="250"><span>添加区域</span></a></li>
			<li><a class="delete" href="${ctx}/admin/foundation/place/district/delete.htm?district.id={sid}&action=zxdysc&dialogId=${param.dialogId}" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
			<li><a class="edit" href="${ctx}/admin/foundation/place/district/showUpdate.htm?district.id={sid}&action=xgdyzs&dialogId=${param.dialogId}" target="dialog"  mask="true"><span>区域修改</span></a></li>
		</ul>
	</div>
	<table class="table" layoutH="50">
		<thead>
			<tr align="center">
				<th width="180">区域名称</th>
				<th width="180">名称拼音</th>
				<th width="150">操作</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="list" var="item">
				<tr target="sid" rel="<s:property value="#item.id" />" align="center">
					<td><s:property value="#item.name" /></td>
					<td><s:property value="#item.pinyinName" /></td>
					<td>
						<a title="${item.name}-设置子区域" target="dialog" rel="dialog_${item.id}" mask="false" minable="true" 
							href="${ctx}/admin/foundation/place/district/showSetSubDist.htm?pid=${item.id}&action=zdylbzs&dialogId=dialog_${item.id}"
							width="800" height="480">设置子区域</a>
					</td>
				</tr>
			</s:iterator>
		</tbody>
	</table>
</div>
