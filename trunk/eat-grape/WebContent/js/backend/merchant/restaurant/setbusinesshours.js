/* 餐厅营业时间设置 */
$("document").ready(function() {
	var currentBusinessHoursCount = $("span[style='']").length;
	// 添加时间段按钮事件
	$("#addBusinessHoursButton").click(function() {
		if(currentBusinessHoursCount < 3){
			currentBusinessHoursCount++;
			$("#businessHours" + currentBusinessHoursCount).css("display", "");
		} else {
			alertWarn("最多设置 3 组时间！");
		}
	});
	// 删除时间段按钮事件
	$("#deleteBusinessHoursButton").click(function() {
		if(currentBusinessHoursCount > 1){
			$("#businessHours" + currentBusinessHoursCount).css("display", "none");
			$("#startBusinessHours" + currentBusinessHoursCount).val("");
			$("#endBusinessHours" + currentBusinessHoursCount).val("");
			currentBusinessHoursCount--;
		} else {
			alertWarn("至少保留 1 组时间！");
		}
	});
	// 设置按钮事件
	$("#setBusinessHoursButton").click(function() {
		var businessHours = new Array();
		$("#businessHoursDiv").find("input[type='text']").each(function() {
			if($(this).val() != "") {
				businessHours.push($(this).val());
			}
		});
		if(businessHours.length > 0 && (businessHours.length % 2) == 0) {
			$.ajax( {
				type : "POST",
				url : $("#setBusinessHoursForm").attr("action"),
				data : "restaurant.businessHours=" + businessHours,
				dataType : 'json',
				success : function(json) {
					DWZ.ajaxDone(json);
					if ("closeCurrent" == json.callbackType) {
						$.pdialog.closeCurrent();
					}
				}
			});
		} else {
			alertWarn("时间选择有误！");
		}
	});
});
