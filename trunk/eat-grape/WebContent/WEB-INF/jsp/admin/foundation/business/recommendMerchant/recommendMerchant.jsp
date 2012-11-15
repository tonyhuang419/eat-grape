<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<form id="pagerForm" method="post" action="${ctx}/admin/foundation/business/recommendMerchant/showIndex.htm?action=city_community_area&navTabId=${param.navTabId}">
	<input type="hidden" name="pageNum" value="${page.currentPage}" />
	<input type="hidden" name="numPerPage" value="${page.pageSize}" />
	<input type="hidden" name="orderField" value="${param.orderField}" />
	<input type="hidden" name="orderDirection" value="asc" />
	
	<!--【可选】其它查询条件，业务有关，有什么查询条件就加什么参数。
      			也可以在searchForm上设置属性rel=”pagerForm”，js框架会自动把searchForm搜索条件复制到pagerForm中 -->
	<input type="hidden" name="shopName" value="${param.shopName}" />
	<input type="hidden" name="startTime" value="${param.startTime}" />
	<input type="hidden" name="endTime" value="${param.endTime}" />
	<input type="hidden" name="handleStatus" value="${param.handleStatus}" />
</form>

<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);" action="${ctx}/admin/foundation/business/recommendMerchant/showIndex.htm?action=zxdyss&navTabId=${param.navTabId}" method="post">
	<div class="searchBar">
		<table class="searchContent">
			<tr>
				<td>
					餐厅名称：<input type="text" name="shopName" />
				</td>
				<td>
					起始时间：<input type="text" name="startTime" class="date" format="yyyy-MM-dd HH:mm:ss" readonly="readonly" />
				</td>
				<td>
					结束时间：<input type="text" name="endTime" class="date" format="yyyy-MM-dd HH:mm:ss" readonly="readonly" />
				</td>
				<td>
					<select class="combox" name="handleStatus">
						<option value="">处理状态</option>
						<option value="0">待处理</option>
						<option value="1">已查看</option>
						<option value="2">已处理</option>
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
			<li><a class="delete" href="${ctx}/admin/foundation/business/recommendMerchant/delete.htm?recommendMerchant.id={sid}&action=zxdysc&navTabId=${param.navTabId}" target="ajaxTodo" title="确定要删除吗？"><span>删除信息</span></a></li>
			<li><a class="icon" href="${ctx}/admin/foundation/business/recommendMerchant/downXls.htm?fileName=RecommendMerchantData.xls&action=dzzhexcel" target="dwzExport" targetType="navTab" title="确定要导出这些记录吗?"><span>导出信息</span></a></li>
		</ul>
	</div>
	<table class="table" layoutH="117">
		<thead>
			<tr align="center">
				<th width="250">餐厅名称</th>
				<th width="180">餐厅电话</th>
				<th width="120">推荐人</th>
				<th width="100">身份类型</th>
				<th width="200">推荐时间</th>
				<th width="100">处理状态</th>
				<th width="250">操作</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="page.items" var="item">
				<tr target="sid" rel="<s:property value="#item.id" />" align="center">
					<td>${item.shopName}</td>
					<td>${item.shopTel}</td>
					<td>${item.identifyStr}</td>
					<td>${item.identifyTypeStr}&nbsp;</td>
					<td>${item.subTimeStr}</td>
					<td>${item.handleStatusStr}&nbsp;</td>
					<td>
						<a title="${item.shopName}-推荐商家详细信息" target="dialog" rel="dialog_${item.id}" mask="false" minable="true" 
							href="${ctx}/admin/foundation/business/recommendMerchant/showDetail.htm?recommendMerchant.id=${item.id}&action=zdylbzs"
							width="700" height="400">
							查  看
						</a>&nbsp;&nbsp;&nbsp;
						<a class="delete" target="ajaxTodo" title="确定要删除吗？"
							href="${ctx}/admin/foundation/business/recommendMerchant/delete.htm?recommendMerchant.id=${item.id}&action=zxdysc&navTabId=${param.navTabId}" >
							删  除
						</a>&nbsp;&nbsp;&nbsp;
						<s:if test="#item.handleStatus != 2">
							<a title="${item.shopName}-推荐处理" target="dialog" rel="dialog_${item.id}" mask="false" minable="true" 
								href="${ctx}/admin/foundation/business/recommendMerchant/showHandle.htm?id=${item.id}&action=zdylbzs&navTabId=${param.navTabId}"
								width="600" height="280">
								处  理
							</a>
						</s:if>
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
