/* 异步上传Logo文件 */
function ajaxFileUpload() {
	$("#loading").ajaxStart(function() {
		$(this).show();
	}).ajaxComplete(function() {
		$(this).hide();
	});
	$.ajaxFileUpload( {
		url : $("#uploadForm").attr("action"),
		secureuri : false,
		fileElementId : "logoFile",
		dataType : "json",
		success : function(json, status) {
			DWZ.ajaxDone(json);
			if ("closeCurrent" == json.callbackType) {
				$.pdialog.closeCurrent();
			}
		},
		error : function(data, status, e) {
			alert(e);
		}
	})
	return false;
}