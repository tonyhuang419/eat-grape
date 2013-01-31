function validate() {
	if($("#w_combox_school").val() != "") {
		$("#addForm").submit();
	} else {
		alertWarn("请选择送餐学校");
	}
}