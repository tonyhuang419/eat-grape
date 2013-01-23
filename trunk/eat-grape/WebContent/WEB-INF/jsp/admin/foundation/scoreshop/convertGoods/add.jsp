<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>

<script type="text/javascript">
	$(document).ready(function() {
		$("#total").on("keyup", function() {
			$("#surplus").val($(this).val());
		});
	});
</script>

<div class="pageContent">
	<form method="post" action="${ctx}/admin/foundation/scoreshop/convertGoods/add.htm?navTabId=${navTabId}&action=zxdytj&dialogId=${dialogId}" class="pageForm required-validate"
			 onsubmit="return validateCallback(this, dialogAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<p>
				<label>商品名称：</label>
				<input name="convertGoods.name" class="required" type="text" size="30"/>
			</p>
			<p>
				<label>供货数量：</label>
				<input id="total" name="convertGoods.total" class="required digits" type="text" size="30" maxlength="6"/>
			</p>
			<p>
				<label>剩余数量：</label>
				<input id="surplus" name="convertGoods.surplus" class="required digits" type="text" size="30" readonly="readonly" maxlength="6"/>
			</p>
			<p>
				<label>所需积分：</label>
				<input name="convertGoods.score" class="required digits" re type="text" size="30" maxlength="8"/>
			</p>
			<p>
				<label>商品描述：</label>
				<input name="convertGoods.description" type="text" size="30"/>
			</p>
		</div>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
				<li>
					<div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div>
				</li>
			</ul>
		</div>
	</form>
</div>
