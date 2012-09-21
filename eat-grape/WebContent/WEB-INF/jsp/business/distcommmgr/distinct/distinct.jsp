<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<form id="pagerForm" method="post" action="${ctx}/business/distcommmgr/distinct/showIndex.htm?action=city_distinct_area&TabId=${param.navTabId}">
	
	<input type="hidden" name="pageNum" value="${page.currentPage}" />
	<input type="hidden" name="numPerPage" value="${page.pageSize}" />
	<input type="hidden" name="orderField" value="${param.orderField}" />
	<input type="hidden" name="orderDirection" value="asc" />
	
	<!--【可选】其它查询条件，业务有关，有什么查询条件就加什么参数。
      			也可以在searchForm上设置属性rel=”pagerForm”，js框架会自动把searchForm搜索条件复制到pagerForm中 -->
	<input type="hidden" name="userName" value="${param.userName}" />
	<input type="hidden" name="email" value="${param.email}" />
</form>


<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);" action="business/distcommmgr/distinct/showIndex.htm?action=zxdyss" method="post">
	<div class="searchBar">
		<table class="searchContent">
			<tr>
				<td>
					地域名称：<input type="text" name="distName" />
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
			<li><a class="add" href="business/distcommmgr/distinct/showAdd.htm?action=tjdyzs&navTabId=${param.navTabId}" target="dialog" mask="true" width="520" height="250"><span>添加地域</span></a></li>
			<li><a class="delete" href="business/distcommmgr/distinct/delete.htm?distinct.id={sid}&action=zxdysc&navTabId=${param.navTabId}" target="ajaxTodo" title="确定要删除吗？"><span>删除</span></a></li>
			<li><a class="edit" href="business/distcommmgr/distinct/showUpdate.htm?distinct.id={sid}&action=xgdyzs&navTabId=${param.navTabId}" target="dialog" mask="true" width="520" height="250"><span>修改</span></a></li>
		</ul>
	</div>
	<table class="table" layoutH="117">
		<thead>
			<tr align="center">
				<th width="180">地域名称</th>
				<th width="150">操作</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="page.items" var="item">
				<tr target="sid" rel="<s:property value="#item.id" />" align="center">
					<td><s:property value="#item.distName" /></td>
					<td>
						<a title="${item.distName}-设置子地域" target="dialog" rel="dialog_${item.id}" mask="false" minable="true" 
							href="business/distcommmgr/distinct/showSetSubDist.htm?pid=${item.id}&action=zdylbzs&dialogId=dialog_${item.id}"
							width="800" height="480">设置子地域</a>
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
