<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<form id="pagerForm" method="post" action="${ctx}/admin/customer/list/showIndex.htm?action=account_mgr&navTabId=${param.navTabId}">
	<input type="hidden" name="pageNum" value="${page.currentPage}" />
	<input type="hidden" name="numPerPage" value="${page.pageSize}" />
	<input type="hidden" name="orderField" value="${param.orderField}" />
	<input type="hidden" name="orderDirection" value="asc" />
	
	<!--【可选】其它查询条件，业务有关，有什么查询条件就加什么参数。
      			也可以在searchForm上设置属性rel=”pagerForm”，js框架会自动把searchForm搜索条件复制到pagerForm中 -->
	<input type="hidden" name="loginEmail" value="${param.loginEmail}" />
	<input type="hidden" name="mobilePhone" value="${param.mobilePhone}" />
	<input type="hidden" name="startTime" value="${param.startTime}" />
	<input type="hidden" name="endTime" value="${param.endTime}" />
	<input type="hidden" name="isEnabled" value="${param.isEnabled}" />
</form>

<div class="pageHeader">
	<form rel="pagerForm" onsubmit="return navTabSearch(this);" action="${ctx}/admin/customer/list/showIndex.htm?action=zxzhss&navTabId=${param.navTabId}" method="post">
	<div class="searchBar">
		<table class="searchContent">
			<tr>
				<td>
					登录邮箱：<input type="text" name="loginEmail" />
				</td>
				<td>
					手机号码：<input type="text" name="mobilePhone" />
				</td>
				<td>
					起始注册时间：<input type="text" name="startTime" class="date" format="yyyy-MM-dd HH:mm:ss" readonly="readonly" />
				</td>
				<td>
					结束注册时间：<input type="text" name="endTime" class="date" format="yyyy-MM-dd HH:mm:ss" readonly="readonly" />
				</td>
				<td>
					<select class="combox" name="isEnabled">
						<option value="">是否可用</option>
						<s:iterator value="#request.enabled" var="n">
							<option value="${n.key}">${n.value}</option>
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
			<li><a class="delete" href="${ctx}/admin/customer/list/delete.htm?customer.id={sid_user}&action=zxzhsc&navTabId=${param.navTabId}" target="ajaxTodo" title="确定要删除吗?"><span>删除顾客</span></a></li>
			<li class="line">line</li>
			<li><a class="icon" href="${ctx}/admin/customer/list/downXls.htm?fileName=CustomerData.xls&action=dzzhexcel" target="dwzExport" targetType="navTab" title="确定要导出这些记录吗?"><span>导出顾客</span></a></li>
		</ul>
	</div>
	<table class="table" layoutH="117">
		<thead>
			<tr align="center">
				<th width="150">登录邮箱</th>
				<th width="120">昵称</th>
				<th width="120">真实姓名</th>
				<th width="120">手机号码</th>
				<th width="100">积分</th>
				<th width="80">可用状态</th>
				<th width="150">注册时间</th>
				<th width="100">详细信息</th>
				<th width="180">操  作</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="page.items" var="item">
				<tr target="sid_user" rel="${item.id}" align="center">
					<td>${item.loginEmail}</td>
					<td>${item.nickName}</td>
					<td>${item.trueName}</td>
					<td>${item.mobilePhone}</td>
					<td>${item.score}</td>
					<td>${item.isEnabledStr}&nbsp;</td>
					<td>${item.registerTimeStr}</td>
					<td>
						<a title="${item.loginEmail}-详细信息" target="dialog" rel="dialog_${item.id}" mask="false" minable="true" 
							href="${ctx}/admin/customer/list/showDetail.htm?customer.id=${item.id}&action=zdylbzs"
							width="700" height="450">查  看</a>
					</td>
					<td>
						<s:if test="#item.isEnabled == 0">
							<a href="${ctx}/admin/customer/list/changeEnable.htm?customer.id=${item.id}&action=zxzhsc&navTabId=${param.navTabId}" 
								target="ajaxTodo" title="确定要禁用 - ${item.loginEmail} - 吗?"><span>禁用</span></a>
						</s:if>
						<s:else>
							<a href="${ctx}/admin/customer/list/changeEnable.htm?customer.id=${item.id}&action=zxzhsc&navTabId=${param.navTabId}" 
								target="ajaxTodo" title="确定要激活 - ${item.loginEmail} - 吗?"><span>激活</span></a>
						</s:else>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="${ctx}/admin/customer/list/resetPassword.htm?customer.id=${item.id}&action=zxzhsc&navTabId=${param.navTabId}" 
							target="ajaxTodo" title="将 - ${item.loginEmail} - 的密码重置?"><span>重置密码</span></a>
						&nbsp;&nbsp;&nbsp;&nbsp;
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
