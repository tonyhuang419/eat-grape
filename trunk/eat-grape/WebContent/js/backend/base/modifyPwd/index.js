$(document).ready(function() {
	$("#modifyBtn").on("click", function() {
		var oldPwd = $.trim($("#oldPwd").val()); 
		var newPwd = $.trim($("#newPwd").val()); 
		var confirmPwd = $.trim($("#confirmPwd").val()); 
		
		if(oldPwd == "") {
			alertWarn("“旧密码”未填写"); return;
		} else if(newPwd == "") {
			alertWarn("“新密码”未填写"); return;
		} else if(confirmPwd == "") {
			alertWarn("“确认密码”未填写"); return;	
		}
		
		var url = ctx + "/admin/base/modifyPwd/queryOldPwd.htm"
		$.post(url, null, function(data) {
			if(data.oldPwd == oldPwd) {
				if(newPwd == confirmPwd) {
					$("#modifyPwdForm").submit();
				} else {
					alertErr("两次新密码不一致，请重新输入！");
					return;
				}
			} else {
				alertErr("旧密码验证失败，请重新输入！");
				return;
			}
		}, "json");
	});
});