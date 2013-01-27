$(document).ready(function () {
	setInterval(function() {
		var url = ctx + "/admin/system/systemdata/systemInfo/ajaxLoadSystemInfo.htm";
		
		$.ajaxSettings.global=false;
		
		$.post(url, null, function(data) {
			var serverInfo = data.serverInfo;
			var clientInfo = data.clientInfo;
			
			$("#serverTime").html(serverInfo.serverTime);
			$("#serverRunTime").html(serverInfo.serverRunTime);
			$("#freeMemory").html(serverInfo.freeMemory + " MB");
			$("#sessionCount").html(serverInfo.sessionCount);

			$("#clientPort").html(clientInfo.clientPort);
		}, "json");
	}, 1000);
});