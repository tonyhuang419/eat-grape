<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<form id="pagerForm" method="post" action="${ctx}/admin/system/frontdata/systemNotice/showIndex.htm?action=city_community_area&navTabId=${param.navTabId}">
	<input type="hidden" name="pageNum" value="${page.currentPage}" />
	<input type="hidden" name="numPerPage" value="${page.pageSize}" />
	<input type="hidden" name="orderField" value="${param.orderField}" />
	<input type="hidden" name="orderDirection" value="asc" />
	
	<!--【可选】其它查询条件，业务有关，有什么查询条件就加什么参数。
      			也可以在searchForm上设置属性rel=”pagerForm”，js框架会自动把searchForm搜索条件复制到pagerForm中 -->
	<input type="hidden" name="title" value="${param.title}" />
	<input type="hidden" name="content" value="${param.content}" />
	<input type="hidden" name="startTime" value="${param.startTime}" />
	<input type="hidden" name="endTime" value="${param.endTime}" />
	<input type="hidden" name="target" value="${param.target}" />
</form>

<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);" action="${ctx}/admin/system/frontdata/systemNotice/showIndex.htm?action=zxdyss&navTabId=${param.navTabId}" method="post">
	<div class="searchBar">
		<table class="searchContent">
			<tr>
				<td>
					标题：<input type="text" name="title" />
				</td>
				<td>
					内容：<input type="text" name="content" />
				</td>
				<td>
					起始时间：<input type="text" name="startTime" class="date" format="yyyy-MM-dd HH:mm:ss" readonly="readonly" />
				</td>
				<td>
					结束时间：<input type="text" name="endTime" class="date" format="yyyy-MM-dd HH:mm:ss" readonly="readonly" />
				</td>
				<td>
					<select class="combox" name="target">
						<option value="">公告对象</option>
						<s:iterator value="#request.userIdentity" var="ui">
							<option value="${ui.key}">${ui.value}</option>
						</s:iterator>
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
			<li><a class="add" href="${ctx}/admin/system/frontdata/systemNotice/showAdd.htm?action=tjzhzs&navTabId=${param.navTabId}" target="dialog" mask="true" width="520" height="250"><span>发布公告</span></a></li>
			<li><a class="delete" href="${ctx}/admin/system/frontdata/systemNotice/delete.htm?systemNotice.id={sid}&action=zxdysc&navTabId=${param.navTabId}" target="ajaxTodo" title="确定要删除吗？"><span>删除信息</span></a></li>
			<li><a class="edit" href="${ctx}/admin/system/frontdata/systemNotice/showUpdate.htm?systemNotice.id={sid}&action=xgzhzs&navTabId=${param.navTabId}" target="dialog" mask="true" width="520" height="250"><span>公告更新</span></a></li>
			<li><a class="icon" href="${ctx}/admin/system/frontdata/systemNotice/downXls.htm?fileName=SystemNotice.xls&action=dzzhexcel" target="dwzExport" targetType="navTab" title="确定要导出这些公告吗?"><span>导出公告</span></a></li>
		</ul>
	</div>
	<table class="table" layoutH="117">
		<thead>
			<tr align="center">
				<th width="200">公告标题</th>
				<th width="350">公告内容</th>
				<th width="100">公告人</th>
				<th width="150">公告时间</th>
				<th width="100">公告对象</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="page.items" var="item">
				<tr target="sid" rel="<s:property value="#item.id" />" align="center">
					<td>${item.title}</td>
					<td>${item.content}</td>
					<td>${item.userStr}</td>
					<td>${item.sendTimeStr}</td>
					<td>${item.targetStr}&nbsp;</td>
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
