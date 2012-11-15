<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<form id="pagerForm" method="post" action="${ctx}/admin/system/frontdata/friendshipLink/showIndex.htm?action=account_mgr&navTabId=${param.navTabId}">
	<input type="hidden" name="pageNum" value="${page.currentPage}" />
	<input type="hidden" name="numPerPage" value="${page.pageSize}" />
	<input type="hidden" name="orderField" value="${param.orderField}" />
	<input type="hidden" name="orderDirection" value="asc" />
	
	<!--【可选】其它查询条件，业务有关，有什么查询条件就加什么参数。
      			也可以在searchForm上设置属性rel=”pagerForm”，js框架会自动把searchForm搜索条件复制到pagerForm中 -->
	<input type="hidden" name="name" value="${param.name}" />
	<input type="hidden" name="isDisplay" value="${param.isDisplay}" />
</form>


<div class="pageHeader">
	<form rel="pagerForm" onsubmit="return navTabSearch(this);" action="${ctx}/admin/system/frontdata/friendshipLink/showIndex.htm?action=zxzhss&navTabId=${param.navTabId}" method="post">
	<div class="searchBar">
		<table class="searchContent">
			<tr>
				<td>
					链接名称：<input type="text" name="name" />
				</td>
				<td>
					<select class="combox" name="isDisplay">
						<option value="">首页展示</option>
						<option value="0">是</option>
						<option value="1">否</option>
					</select>
				</td>
				<td>
					<div class="subBar">
						<ul>
							<li><div class="buttonActive"><div class="buttonContent"><button type="submit">搜索</button></div></div></li>
						</ul>
					</div>
				</td>
			</tr>
		</table>
	</div>
	</form>
</div>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="add" href="${ctx}/admin/system/frontdata/friendshipLink/showAdd.htm?action=tjzhzs&navTabId=${param.navTabId}" target="dialog" mask="true" width="520" height="250"><span>添加链接</span></a></li>
			<li><a class="delete" href="${ctx}/admin/system/frontdata/friendshipLink/delete.htm?friendshipLink.id={sid}&action=zxzhsc&navTabId=${param.navTabId}" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
			<li><a class="edit" href="${ctx}/admin/system/frontdata/friendshipLink/showUpdate.htm?friendshipLink.id={sid}&action=xgzhzs&navTabId=${param.navTabId}" target="dialog" mask="true" width="520" height="250"><span>修改链接</span></a></li>
			<li class="line">line</li>
			<li><a class="icon" href="${ctx}/admin/system/frontdata/friendshipLink/downXls.htm?fileName=FriendshipLink.xls&action=dzzhexcel" target="dwzExport" targetType="navTab" title="确定要导出这些记录吗?"><span>导出链接</span></a></li>
		</ul>
	</div>
	<table class="table" layoutH="117">
		<thead>
			<tr align="center">
				<th width="180">链接名称</th>
				<th width="350">链接地址</th>
				<th width="100">链接Logo</th>
				<th width="100">排序号</th>
				<th width="100">首页展示</th>
				<th width="120">操作</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="page.items" var="item">
				<tr target="sid" rel="${item.id}" align="center">
					<td>${item.linkName}</td>
					<td>${item.linkUrl}</td>
					<td style="padding-top: 4px;">
						<img src="${ctx}${item.logoUrl}" alt="${item.linkName}" align="absmiddle"/>
					</td>
					<td>${item.sortOrder}</td>
					<td>${item.isDisplayStr}&nbsp;</td>
					<td>
						<a title="${item.linkName}-友情链接Logo设置" target="dialog" rel="dialog_fl_${item.id}" mask="false" minable="true" 
							href="${ctx}/admin/system/frontdata/friendshipLink/showLogoUpload.htm?friendshipLink.id=${item.id}&action=zdylbzs&navTabId=${param.navTabId}"
							width="500" height="250">设置Logo</a>
					</td>
				</tr>
			</s:iterator>
			
		</tbody>
	</table>
	<div class="panelBar" layoutH="0">
		<div class="pages">
			<span style="margin-right: 3px;">显示</span>
			<select class="combox" name="numPerPage" onchange="navTabPageBreak({numPerPage:this.value})">
				<option value="15" <c:if test="${page.pageSize == 15}">selected</c:if>>15</option>
				<option value="20" <c:if test="${page.pageSize == 20}">selected</c:if>>20</option>
				<option value="25" <c:if test="${page.pageSize == 25}">selected</c:if>>25</option>
				<option value="30" <c:if test="${page.pageSize == 30}">selected</c:if>>30</option>
			</select>
			<span style="margin-left: 5px;">共 - ${page.totalCount} - 条</span>
		</div>
		
		<div class="pagination" targetType="navTab" totalCount="${page.totalCount }" numPerPage="${page.pageSize }" pageNumShown="10" currentPage="${page.currentPage }"></div>

	</div>
</div>
