// 更换验证码
function changeImage(img)
{
	img.src = "verifycode.htm?" + Math.random();
}

// 登陆表单校验
function check()
{
	var username = $.trim($("#username").val());
	var password = $.trim($("#password").val());
	var verifycode = $.trim($("#verifycode").val());

	if(username == "")
	{showMsg("请输入用户名！", 1);$("#username").focus();return;}
	if(password == "")
	{showMsg("请输入密码！", 1);$("#password").focus();return;}
	if(verifycode == "")
	{showMsg("请输入验证码！", 1);$("#verifycode").focus();return;}
		
	login(username, password, verifycode);
}

// 登陆验证Ajax
function login(username, password, verifycode) {
	$.ajax( {
		type : "POST",
		url : "login.htm",
		data : "user.userName=" + username + "&user.pwd=" + password + "&verifycode_c=" + verifycode,
		success : function(msg) {
			var res = msg.resultMap.res;
			if(res == 0) {
				showMsg("用户不存在！", 1);
				$("#username").focus();
			}
			else if(res == 1) {
				window.location.href = "home.htm";
			}
			else if(res == 2) {
				showMsg("用户名或密码错误！", 1);
				$("#password").focus();
			}
			else {
				showMsg("验证码输入错误！", 1);
				$("#verifyImg").attr("src", "verifycode.htm?" + Math.random());
				$("#verifycode").focus();
			}
		}
	});
}

// 文本输入框获得焦点
function getFocus(id) {
	$("#" + id).css("border", "1px solid #1493FF");
}

// 文本输入框失去焦点
function loseFocus(id) {
	$("#" + id).css("border", "1px solid #64C3F6");
}

// 鼠标捕获按钮
function mouseOver(id, url) {
	$("#" + id).css("background-image", "url(" + url + ")");
}

// 鼠标离开按钮
function mouseOut(id, url) {
	$("#" + id).css("background-image", "url(" + url + ")");
}

// 响应登陆按钮回车事件
function clickLoginButton(event, btnId) {
	if(event.keyCode == 13) {
		$("#" + btnId).focus();
	}
}