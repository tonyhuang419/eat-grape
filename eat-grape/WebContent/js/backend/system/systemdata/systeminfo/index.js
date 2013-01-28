$(document).ready(function () {
	setInterval(function() {
		var url = ctx + "/admin/system/systemdata/systemInfo/ajaxLoadSystemInfo.htm";

		// 关闭数据加载提示
		$.ajaxSettings.global = false;
		
		$.post(url, null, function(data) {
			var serverInfo = data.serverInfo;
			var clientInfo = data.clientInfo;
			
			$("#serverTime").html(serverInfo.serverTime);
			$("#serverRunTime").html(serverInfo.serverRunTime);
			$("#freeMemory").html(serverInfo.freeMemory + " MB");
			$("#sessionCount").html(serverInfo.sessionCount);

			$("#clientPort").html(clientInfo.clientPort);
		}, "json");
		// 开启数据加载提示
		$.ajaxSettings.global = true;
	}, 100000);
});