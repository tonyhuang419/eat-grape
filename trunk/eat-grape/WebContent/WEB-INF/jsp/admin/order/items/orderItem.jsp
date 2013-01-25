<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<div class="pageContent">
	<table class="table" layoutH="117">
		<thead>
			<tr align="center">
				<th width="150">商品名称</th>
				<th width="150">单价</th>
				<th width="180">数量</th>
				<th width="120">折扣</th>
				<th width="150">备注</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="page.items" var="item">
				<tr target="sid_user" rel="${item.id}" align="center">
					<td>${item.itemName}</td>
					<td>${item.unitPrice}</td>
					<td>${item.count}</td>
					<td>${item.discount}</td>
					<td>${item.description}</td>
				</tr>
			</s:iterator>
		</tbody>
	</table>
</div>
