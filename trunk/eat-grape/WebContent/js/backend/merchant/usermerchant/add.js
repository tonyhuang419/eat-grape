$(document).ready(function () {
	$("#addUserMerchantForm").submit(
		function () {
			var userIdCount = $("input[name='userMerchant.userId']:checked").length;
			var restaurantIdCount = $("input[name='userMerchant.manageRestaurantList']:checked").length;
			if(userIdCount < 1) {
				alertErr("请您先选择账号！");
				return false;
			} else if(restaurantIdCount < 1) {
				var userName = $("input[name='userMerchant.userId']:checked").attr('title');
				alertErr("请您先勾选账号 - " + userName + " - 可管理的餐厅！");
				return false;
			} else {
				return validateCallback(this, dialogAjaxDone);
			}
		}
	);
});