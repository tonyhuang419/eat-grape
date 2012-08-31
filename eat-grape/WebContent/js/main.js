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
function login(username, password, verifycode)
{
	$.ajax({
		type: "POST",
		url: "login.htm",
		data: "user.userName=" + username + "&user.pwd=" + password + "&verifycode_c=" + verifycode,
		success: function(msg){
			var res = msg.resultMap.res;
			if(res == 0)
			{
				showMsg("用户不存在！", 1);
				$("#username").focus();
			}
			else if(res == 1)
			{
				window.location.href = "home.htm";
			}
			else if(res == 2)
			{
				showMsg("用户名或密码错误！", 1);
				$("#password").focus();
			}
			else
			{
				showMsg("验证码输入错误！", 1);
				$("#verifyImg").attr("src", "verifycode.htm?" + Math.random());
				$("#verifycode").focus();
			}
		}
	});
}

function clickLoginButton(event, btnId)
{
	if(event.keyCode==13)
	{
		$("#"+btnId).focus();
	}
}

/* 消息提示框 */
function showMsg(msg, time)
{
	art.dialog({
		title : "温馨提示",
		content : msg,
		left : '50%',
		top : '50%',
		icon : 'face-sad',
		time : time,
	    drag : false,
	    fixed : true,
		close : function(){
			art.dialog.close();
		}
	}).lock();
}