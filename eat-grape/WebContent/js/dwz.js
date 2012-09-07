// 确认提示框（超链接）
function confirm2Link(msg, url)
{
	alertMsg.confirm(msg, {
		okCall: function(){
			window.location.href = url;
		}
	});
}

// 确认提示框（Ajax）
function confirm2Ajax(url, msg, data, callback, type)
{
	alertMsg.confirm(msg, {
		okCall: function(){
			$.post(url, data, callback, type);
		}
	});
}

// 成功提示框
function alertSuc(msg)
{
	alertMsg.correct(msg);
}

// 错误提示框
function alertErr(msg)
{
	alertMsg.error(msg);
}

// 警告提示框
function alertWarn(msg)
{
	alertMsg.warn(msg);
}

// 信息提示框
function alertInfo(msg)
{
	alertMsg.info(msg);
}