function validate() {
	if($("#w_combox_community").val() != "") {
		$("#addForm").submit();
	} else {
		alertWarn("请选择送餐社区");
	}
}