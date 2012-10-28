<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<form id="pagerForm" method="post" action="${ctx}/admin/system/useradmin/account/showIndex.htm?action=account_mgr&navTabId=${param.navTabId}">
	<input type="hidden" name="pageNum" value="1" />
	<input type="hidden" name="numPerPage" value="${page.pageSize}" />
	<input type="hidden" name="orderField" value="${param.orderField}" />
	<input type="hidden" name="orderDirection" value="asc" />
	
	<!--【可选】其它查询条件，业务有关，有什么查询条件就加什么参数。
      			也可以在searchForm上设置属性rel=”pagerForm”，js框架会自动把searchForm搜索条件复制到pagerForm中 -->
	<input type="hidden" name="userName" value="${param.userName}" />
	<input type="hidden" name="email" value="${param.email}" />
</form>


<div class="pageHeader">
	<form rel="pagerForm" onsubmit="return navTabSearch(this);" action="${ctx}/admin/system/useradmin/account/showIndex.htm?action=zxzhss&navTabId=${param.navTabId}" method="post">
	<div class="searchBar">
		<table class="searchContent">
			<tr>
				<td>
					用户名：<input type="text" name="userName" />
				</td>
				<td>
					邮箱：<input type="text" name="email" />
				</td>
				<td>
					<select class="combox" name="type">
						<option value="">用户类型</option>
						<option value="1">个人</option>
						<option value="2">公司</option>
					</select>
				</td>
				<td>
					<select class="combox" name="roleId">
						<option value="">角色类型</option>
						<s:iterator value="#request.allRole" var="r">
							<option value="${r.id}">${r.roleName}</option>
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
			<li><a class="add" href="${ctx}/admin/system/useradmin/account/showAdd.htm?action=tjzhzs&navTabId=${param.navTabId}" target="dialog" mask="true" width="520" height="250"><span>添加账号</span></a></li>
			<li><a class="delete" href="${ctx}/admin/system/useradmin/account/delete.htm?user.id={sid_user}&action=zxzhsc&navTabId=${param.navTabId}" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
			<li><a class="edit" href="${ctx}/admin/system/useradmin/account/showUpdate.htm?user.id={sid_user}&action=xgzhzs&navTabId=${param.navTabId}" target="dialog" mask="true" width="520" height="250"><span>修改</span></a></li>
			<li class="line">line</li>
			<li><a class="icon" href="${ctx}/admin/system/useradmin/account/downXls.htm?fileName=UserData.xls&action=dzzhexcel" target="dwzExport" targetType="navTab" title="确定要导出这些记录吗?"><span>导出Excel</span></a></li>
		</ul>
	</div>
	<table class="table" layoutH="117">
		<thead>
			<tr align="center">
				<th width="180">用户名</th>
				<th width="180">密码</th>
				<th width="200">邮箱</th>
				<th width="120">用户类型</th>
				<th width="120">角色类型</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="page.items" var="item">
				<tr target="sid_user" rel="${item.id}" align="center">
					<td>${item.userName}</td>
					<td>${item.pwd}</td>
					<td>${item.email}</td>
					<td>
						<s:if test="#item.type == 1">个人</s:if>
						<s:elseif test="#item.type == 2">公司</s:elseif>
					</td>
					<td>
						<s:iterator value="#request.allRole" var="r">
							<s:if test="#item.roleId == #r.id">${r.roleName}</s:if>
						</s:iterator>
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
