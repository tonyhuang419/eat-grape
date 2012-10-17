<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<form id="pagerForm" method="post" action="${ctx}/admin/merchant/restaurant/showIndex.htm?merchantId=${param.merchantId}&action=account_mgr&navTabId=${param.navTabId}">
	<input type="hidden" name="pageNum" value="1" />
	<input type="hidden" name="numPerPage" value="${page.pageSize}" />
	<input type="hidden" name="orderField" value="${param.orderField}" />
	<input type="hidden" name="orderDirection" value="asc" />
	
	<!--【可选】其它查询条件，业务有关，有什么查询条件就加什么参数。
      			也可以在searchForm上设置属性rel=”pagerForm”，js框架会自动把searchForm搜索条件复制到pagerForm中 -->
	<input type="hidden" name="name" value="${param.name}" />
	<input type="hidden" name="address" value="${param.address}" />
	<input type="hidden" name="contactName" value="${param.contactName}" />
	<input type="hidden" name="contactPhone" value="${param.contactPhone}" />
</form>


<div class="pageHeader">
	<form rel="pagerForm" onsubmit="return navTabSearch(this);" action="${ctx}/admin/merchant/restaurant/showIndex.htm?merchantId=${param.merchantId}&action=zxzhss&navTabId=${param.navTabId}" method="post">
	<div class="searchBar">
		<table class="searchContent">
			<tr>
				<td>
					餐厅名称：<input type="text" name="name" />
				</td>
				<td>
					餐厅地址：<input type="text" name="address" />
				</td>
				<td>
					联系人：<input type="text" name="contactName" />
				</td>
				<td>
					联系电话：<input type="text" name="contactPhone" />
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
			<li><a class="add" href="${ctx}/admin/merchant/restaurant/showAdd.htm?merchantId=${param.merchantId}&action=tjzhzs&navTabId=${param.navTabId}" target="dialog" mask="true" width="900" height="320"><span>添加餐厅</span></a></li>
			<li><a class="delete" href="${ctx}/admin/merchant/restaurant/delete.htm?restaurant.id={sid_user}&action=zxzhsc&navTabId=${param.navTabId}" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
			<li><a class="edit" href="${ctx}/admin/merchant/restaurant/showUpdate.htm?restaurant.id={sid_user}&merchantId=${param.merchantId}&action=xgzhzs&navTabId=${param.navTabId}" target="dialog" mask="true" width="900" height="320"><span>餐厅修改</span></a></li>
			<li class="line">line</li>
			<li><a class="icon" href="${ctx}/admin/merchant/restaurant/downXls.htm?fileName=RestaurantData.xls&action=dzzhexcel" target="dwzExport" targetType="navTab" title="确定要导出这些记录吗?"><span>导出Excel</span></a></li>
		</ul>
	</div>
	<table class="table" layoutH="117">
		<thead>
			<tr align="center">
				<th width="150">餐厅名称</th>
				<th width="150">联系人</th>
				<th width="180">联系电话</th>
				<th width="120">联系邮箱</th>
				<th width="120">详细信息</th>
				<th width="210">操作</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="page.items" var="item">
				<tr target="sid_user" rel="${item.id}" align="center">
					<td>${item.name}</td>
					<td>${item.contactName}</td>
					<td>${item.contactPhone}</td>
					<td>${item.contactEmail}</td>
					<td>
						<a title="${item.name}-详细信息" target="dialog" rel="dialog_${item.id}" mask="false" minable="true" 
							href="${ctx}/admin/merchant/restaurant/showDetail.htm?restaurant.id=${item.id}&action=zdylbzs"
							width="700" height="400">查  看</a>
					</td>
					<td>
						<a title="${item.name}-Logo设置" target="dialog" rel="dialog_${item.id}" mask="false" minable="true" 
							href="${ctx}/admin/merchant/restaurant/showLogoUpload.htm?restaurant.id=${item.id}&action=zdylbzs"
							width="500" height="250">设置Logo</a>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<a title="${item.name}-营业时间设置" target="dialog" rel="dialog_${item.id}" mask="false" minable="true" 
							href="${ctx}/admin/merchant/restaurant/showSetBusinessHours.htm?restaurant.id=${item.id}&action=zdylbzs"
							width="500" height="250">营业时间</a>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<a title="${item.name}-送餐地点管理" target="navTab" rel="${item.id}" mask="false" minable="true" 
							href="${ctx}/admin/merchant/restaurant/sendplace/showIndex.htm?restaurant.id=${item.id}&action=zdylbzs&navTabId=sendplace_${item.id}"
							width="900" height="480">送餐地点</a>
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
