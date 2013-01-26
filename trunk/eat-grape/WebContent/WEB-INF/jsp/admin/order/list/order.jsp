<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<form id="pagerForm" method="post" action="${ctx}/admin/order/list/showIndex.htm?action=account_mgr&navTabId=${param.navTabId}">
	<input type="hidden" name="pageNum" value="${page.currentPage}" />
	<input type="hidden" name="numPerPage" value="${page.pageSize}" />
	<input type="hidden" name="orderField" value="${param.orderField}" />
	<input type="hidden" name="orderDirection" value="asc" />
	
	<!--【可选】其它查询条件，业务有关，有什么查询条件就加什么参数。
      			也可以在searchForm上设置属性rel=”pagerForm”，js框架会自动把searchForm搜索条件复制到pagerForm中 -->
	<input type="hidden" name="orderNum" value="${param.orderNum}" />
	<input type="hidden" name="contactName" value="${param.contactName}" />
	<input type="hidden" name="customerName" value="${param.customerName}" />
	<input type="hidden" name="restaurantName" value="${param.customerName}" />
	<input type="hidden" name="restaurantName" value="${param.contactPhone}" />
	<input type="hidden" name="restaurantName" value="${param.sendAddress}" />
	<input type="hidden" name="startTime" value="${param.startTime}" />
	<input type="hidden" name="endTime" value="${param.endTime}" />
	<input type="hidden" name="orderStatus" value="${param.orderStatus}" />
	<input type="hidden" name="notifyType" value="${param.notifyType}" />
</form>

<div class="pageHeader">
	<form rel="pagerForm" onsubmit="return navTabSearch(this);" action="${ctx}/admin/order/list/showIndex.htm?action=zxzhss&navTabId=${param.navTabId}" method="post">
	<div class="searchBar">
		<table class="searchContent">
			<tr>
				<td>
					订单号：<input type="text" name="orderNum" />
				</td>
				<td>
					订餐顾客：<input type="text" name="customerName" />
				</td>
				<td>
					餐厅名称：<input type="text" name="restaurantName" />
				</td>
				<td>
					联系电话：<input type="text" name="contactPhone" />
				</td>
				<td colspan="2">
					<select class="combox" name="notifyType">
						<option value="">通知类型</option>
						<s:iterator value="#request.notify" var="n">
							<option value="${n.key}">${n.value}</option>
						</s:iterator>
					</select>
				</td>
			</tr>
			<tr>
				<td>
					联系人：<input type="text" name="contactName" />
				</td>
				<td>
					送餐地址：<input type="text" name="sendAddress" />
				</td>
				<td>
					起始时间：<input type="text" name="startTime" class="date" format="yyyy-MM-dd HH:mm:ss" readonly="readonly" />
				</td>
				<td>
					结束时间：<input type="text" name="endTime" class="date" format="yyyy-MM-dd HH:mm:ss" readonly="readonly" />
				</td>
				<td>
					<select class="combox" name="orderStatus">
						<option value="">订单状态</option>
						<s:iterator value="#request.status" var="s">
							<option value="${s.key}">${s.value}</option>
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
			<li><a class="delete" href="${ctx}/admin/order/list/delete.htm?order.id={sid}&action=zxzhsc&navTabId=${param.navTabId}" target="ajaxTodo" title="将删除该订单及其下的所有订单项，确定要删除吗?"><span>删除订单</span></a></li>
			<li class="line">line</li>
			<li><a class="icon" href="${ctx}/admin/order/list/downXls.htm?fileName=Order.xls&action=dzzhexcel" target="dwzExport" targetType="navTab" title="确定要导出这些记录吗?"><span>导出订单</span></a></li>
		</ul>
	</div>
	<table class="table" layoutH="137">
		<thead>
			<tr align="center">
				<th width="180">订单号</th>
				<th width="100">联系人</th>
				<th width="120">联系电话</th>
				<th width="180">订餐顾客</th>
				<th width="180">餐厅名称</th>
				<th width="150">下单时间</th>
				<th width="120">通知类型</th>
				<th width="120">订单状态</th>
				<th width="100">详细信息</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="page.items" var="item">
				<tr target="sid" rel="${item.id}" align="center">
					<td>${item.orderNum}</td>
					<td>${item.contactName}</td>
					<td>${item.contactPhone}</td>
					<td>${item.customerName}</td>
					<td>${item.restaurantName}</td>
					<td>${item.orderTimeStr}</td>
					<td>${item.notifyTypeStr}&nbsp;</td>
					<td>${item.orderStatusStr}&nbsp;</td>
					<td>
						<a title="订单：${item.orderNum}-详细信息" target="dialog" rel="dialog_${item.id}" mask="false" 
							href="${ctx}/admin/order/list/showDetail.htm?order.id=${item.id}&action=zdylbzs"
							width="800" height="500" resizable="false" maxable="false" minable="true">查  看</a>
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
