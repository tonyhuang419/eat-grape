<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<form id="pagerForm" method="post" action="${ctx}/admin/merchant/list/showIndex.htm?action=account_mgr&navTabId=${param.navTabId}">
	<input type="hidden" name="pageNum" value="${page.currentPage}" />
	<input type="hidden" name="numPerPage" value="${page.pageSize}" />
	<input type="hidden" name="orderField" value="${param.orderField}" />
	<input type="hidden" name="orderDirection" value="asc" />
	
	<!--【可选】其它查询条件，业务有关，有什么查询条件就加什么参数。
      			也可以在searchForm上设置属性rel=”pagerForm”，js框架会自动把searchForm搜索条件复制到pagerForm中 -->
	<input type="hidden" name="merchantName" value="${param.merchantName}" />
	<input type="hidden" name="merchantAddress" value="${param.merchantAddress}" />
	<input type="hidden" name="legalName" value="${param.legalName}" />
	<input type="hidden" name="legalPhone" value="${param.legalPhone}" />
</form>


<div class="pageHeader">
	<form rel="pagerForm" onsubmit="return navTabSearch(this);" action="${ctx}/admin/merchant/list/showIndex.htm?action=zxzhss&navTabId=${param.navTabId}" method="post">
	<div class="searchBar">
		<table class="searchContent">
			<tr>
				<td>
					商家名称：<input type="text" name="merchantName" />
				</td>
				<td>
					商家地址：<input type="text" name="merchantAddress" />
				</td>
				<td>
					法定人：<input type="text" name="legalName" />
				</td>
				<td>
					法定人电话：<input type="text" name="legalPhone" />
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
			<li><a class="add" href="${ctx}/admin/merchant/list/showAdd.htm?action=tjzhzs&navTabId=${param.navTabId}" target="dialog" mask="true" width="900" height="320"><span>添加商家</span></a></li>
			<li><a class="delete" href="${ctx}/admin/merchant/list/delete.htm?merchant.id={sid_user}&action=zxzhsc&navTabId=${param.navTabId}" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
			<li><a class="edit" href="${ctx}/admin/merchant/list/showUpdate.htm?merchant.id={sid_user}&action=xgzhzs&navTabId=${param.navTabId}" target="dialog" mask="true" width="900" height="320"><span>商家修改</span></a></li>
			<li class="line">line</li>
			<li><a class="icon" href="${ctx}/admin/merchant/list/downXls.htm?fileName=MerchantData.xls&action=dzzhexcel" target="dwzExport" targetType="navTab" title="确定要导出这些记录吗?"><span>导出商家信息</span></a></li>
			<li><a class="icon" href="${ctx}/admin/merchant/restaurant/downXls.htm?fileName=RestaurantData.xls&action=dzzhexcel" target="dwzExport" targetType="navTab" title="确定要导出这些记录吗?"><span>导出餐厅信息</span></a></li>
		</ul>
	</div>
	<table class="table" layoutH="117">
		<thead>
			<tr align="center">
				<th width="150">商家名称</th>
				<th width="150">商家电话</th>
				<th width="180">商家邮箱</th>
				<th width="120">法定人</th>
				<th width="150">法定人电话</th>
				<th width="100">详细信息</th>
				<th width="210">操  作</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="page.items" var="item">
				<tr target="sid_user" rel="${item.id}" align="center">
					<td>${item.merchantName}</td>
					<td>${item.merchantPhone}</td>
					<td>${item.merchantEmail}</td>
					<td>${item.legalName}</td>
					<td>${item.legalPhone}</td>
					<td>
						<a title="${item.merchantName}-详细信息" target="dialog" rel="dialog_${item.id}" mask="false" minable="true" 
							href="${ctx}/admin/merchant/list/showDetail.htm?merchant.id=${item.id}&action=zdylbzs"
							width="700" height="400">查  看</a>
					</td>
					<td>
						<a title="${item.merchantName}-餐厅管理" target="navTab" rel="restaurant_${item.id}" 
							href="${ctx}/admin/merchant/restaurant/showIndex.htm?merchantId=${item.id}&action=zdylbzs&navTabId=restaurant_${item.id}">管理餐厅</a>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<a title="${item.merchantName}-Logo设置" target="dialog" rel="dialog_${item.id}" mask="false" minable="true" 
							href="${ctx}/admin/merchant/list/showLogoUpload.htm?merchant.id=${item.id}&action=zdylbzs"
							width="500" height="250">设置Logo</a>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<a title="${item.merchantName}-用户关联" target="dialog" rel="dialog_${item.id}" mask="false" minable="true" 
							href="${ctx}/admin/merchant/list/showLogoUpload.htm?merchant.id=${item.id}&action=zdylbzs"
							width="500" height="250">关联用户</a>
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
