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
</form>


<div class="pageHeader">
	<form rel="pagerForm" onsubmit="return navTabSearch(this);" action="${ctx}/admin/system/frontdata/advert/advertPosition/showIndex.htm?action=zxzhss&navTabId=${param.navTabId}" method="post">
	<div class="searchBar">
		<table class="searchContent">
			<tr>
				<td>
					名称：<input type="text" name="name" />
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
			<li><a class="add" href="${ctx}/admin/system/frontdata/advert/advertPosition/showAdd.htm?action=tjzhzs&navTabId=${param.navTabId}" target="dialog" mask="true" width="720" height="320"><span>添加广告位</span></a></li>
			<li><a class="delete" href="${ctx}/admin/system/frontdata/advert/advertPosition/delete.htm?advertPosition.id={sid}&action=zxzhsc&navTabId=${param.navTabId}" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
			<li><a class="edit" href="${ctx}/admin/system/frontdata/advert/advertPosition/showUpdate.htm?advertPosition.id={sid}&action=xgzhzs&navTabId=${param.navTabId}" target="dialog" mask="true" width="720" height="320"><span>更新广告位</span></a></li>
		</ul>
	</div>
	<table class="table" layoutH="117">
		<thead>
			<tr align="center">
				<th width="200">名称</th>
				<th width="100">宽度</th>
				<th width="100">高度</th>
				<th width="250">描述</th>
				<th width="250">详细信息</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="page.items" var="item">
				<tr target="sid" rel="${item.id}" align="center">
					<td>${item.positionName}</td>
					<td>${item.positionWidth}</td>
					<td>${item.positionHeight}</td>
					<td>${item.positionDescription}</td>
					<td>
						<a title="${item.positionName}-详细信息" target="dialog" rel="dialog_${item.id}" mask="false" minable="true" 
							href="${ctx}/admin/system/frontdata/advert/advertPosition/showDetail.htm?advertPosition.id=${item.id}&action=zdylbzs"
							width="720" height="480">查  看</a>
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
