/* 异步上传Logo文件 */
function ajaxFileUpload() {
	$.ajaxFileUpload( {
		url : $("#uploadForm").attr("action"),
		secureuri : false,
		fileElementId : "logoFile",
		dataType : "json",
		success : function(json, status) {
			dialogAjaxDone(json);
		},
		error : function(data, status, e) {
			alert(e);
		}
	});
	return false;
}