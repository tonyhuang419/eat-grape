<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<form id="pagerForm" method="post" action="${ctx}/admin/system/frontdata/advert/showIndex.htm?action=account_mgr&navTabId=${param.navTabId}">
	<input type="hidden" name="pageNum" value="${page.currentPage}" />
	<input type="hidden" name="numPerPage" value="${page.pageSize}" />
	<input type="hidden" name="orderField" value="${param.orderField}" />
	<input type="hidden" name="orderDirection" value="asc" />
	
	<!--【可选】其它查询条件，业务有关，有什么查询条件就加什么参数。
      			也可以在searchForm上设置属性rel=”pagerForm”，js框架会自动把searchForm搜索条件复制到pagerForm中 -->
	<input type="hidden" name="name" value="${param.name}" />
	<input type="hidden" name="linkMan" value="${param.linkMan}" />
	<input type="hidden" name="type" value="${param.type}" />
	<input type="hidden" name="enabled" value="${param.enabled}" />
</form>


<div class="pageHeader">
	<form rel="pagerForm" onsubmit="return navTabSearch(this);" action="${ctx}/admin/system/frontdata/advert/showIndex.htm?action=zxzhss&navTabId=${param.navTabId}" method="post">
	<div class="searchBar">
		<table class="searchContent">
			<tr>
				<td>
					广告名称：<input type="text" name="name" />
				</td>
				<td>
					联系人：<input type="text" name="linkMan" />
				</td>
				<td>
					<select class="combox" name="type">
						<option value="">广告类型</option>
						<s:iterator value="#request.advertType" var="at">
							<option value="${at.key}">${at.value}</option>
						</s:iterator>
					</select>
				</td>
				<td>
					<select class="combox" name="enabled">
						<option value="">广告状态</option>
						<s:iterator value="#request.advertEnabled" var="ae">
							<option value="${ae.key}">${ae.value}</option>
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
			<li><a class="add" href="${ctx}/admin/system/frontdata/advert/showAdd.htm?action=tjzhzs&navTabId=${param.navTabId}" target="dialog" mask="true" width="520" height="250"><span>发布广告</span></a></li>
			<li><a class="delete" href="${ctx}/admin/system/frontdata/advert/delete.htm?advert.id={sid}&action=zxzhsc&navTabId=${param.navTabId}" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
			<li><a class="edit" href="${ctx}/admin/system/frontdata/advert/showUpdate.htm?advert.id={sid}&action=xgzhzs&navTabId=${param.navTabId}" target="dialog" mask="true" width="520" height="250"><span>更新广告</span></a></li>
			<li class="line">line</li>
			<li><a class="icon" href="${ctx}/admin/system/frontdata/advert/advertPosition/showIndex.htm?action=zdylbzs&navTabId=advert_position_mgr" target="navTab" rel="advert_position_mgr"><span>广告位管理</span></a></li>
		</ul>
	</div>
	<table class="table" layoutH="117">
		<thead>
			<tr align="center">
				<th width="180">广告名称</th>
				<th width="80">广告类型</th>
				<th width="280">广告链接</th>
				<th width="100">广告联系人</th>
				<th width="100">点击量</th>
				<th width="180">发布时间</th>
				<th width="120">广告位</th>
				<th width="80">状态</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="page.items" var="item">
				<tr target="sid" rel="${item.id}" align="center">
					<td>${item.advertName}</td>
					<td>${item.advertTypeStr}&nbsp;</td>
					<td>${item.advertLink}</td>
					<td>${item.linkMan}</td>
					<td>${item.clickCount}</td>
					<td>${item.issueTimeStr}</td>
					<td>${item.advertPosition.positionName}</td>
					<td>${item.advertEnabledStr}&nbsp;</td>
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
