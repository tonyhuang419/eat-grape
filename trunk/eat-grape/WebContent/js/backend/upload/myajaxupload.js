/* 异步上传Logo文件 */
function ajaxFileUpload() {
	$.ajaxFileUpload( {
		url : $("#uploadForm").attr("action"),
		secureuri : false,
		fileElementId : "file1",
		dataType : "json",
		success : function(json, status) {
			$("#notify").html(json.resp);
			$("#backBtn").attr("disabled", false);
		},
		error : function(data, status, e) {
			alert(e);
		}
	})
	return false;
}