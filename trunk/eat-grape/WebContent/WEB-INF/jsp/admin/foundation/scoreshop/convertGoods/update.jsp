<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>

<script type="text/javascript">
	$(document).ready(function() {
		var oldTotal = parseInt($("#total").val());
		var oldSurplus = parseInt($("#surplus").val());
		
		$("#total").on("keyup", function() {
			var newSurplus = oldSurplus + ($(this).val() - oldTotal);
			$("#surplus").val(newSurplus <= 0 ? 0 : newSurplus);
		});
		
		$("#surplus").on("keyup", function() {
			var surplus = parseInt($("#surplus").val());
			var total = parseInt($("#total").val());
			if(surplus > total) {
				alertWarn("剩余数量不能超过总数量！");
			}
		});
	});
</script>

<div class="pageContent">
	<form method="post" action="${ctx}/admin/foundation/scoreshop/convertGoods/update.htm?action=zxdyxg&navTabId=${param.navTabId}" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<input name="convertGoods.id" type="hidden" value="${convertGoods.id}" />
			<p>
				<label>商品名称：</label>
				<input name="convertGoods.name" class="required" type="text" size="30" value="${convertGoods.name}"/>
			</p>
			<p>
				<label>供货数量：</label>
				<input id="total" name="convertGoods.total" class="required digits" type="text" size="30" value="${convertGoods.total}" maxlength="6"/>
			</p>
			<p>
				<label>剩余数量：</label>
				<input id="surplus" name="convertGoods.surplus" class="required digits" type="text" size="30" value="${convertGoods.surplus}" maxlength="6"/>
			</p>
			<p>
				<label>价格（积分）：</label>
				<input name="convertGoods.score" class="required digits" type="text" size="30" value="${convertGoods.score}" maxlength="8"/>
			</p>
			<p>
				<label>商品描述：</label>
				<input name="convertGoods.description" type="text" size="30" value="${convertGoods.description}"/>
			</p>
		</div>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div></li>
			</ul>
		</div>
	</form>
</div>
