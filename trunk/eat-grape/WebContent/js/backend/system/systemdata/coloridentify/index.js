// 初始化颜色选择器
$(document).ready(function() {
	 $("#colorpicker1").farbtastic("#colorLevel1");
	 $("#colorpicker2").farbtastic("#colorLevel2");
	 $("#colorpicker3").farbtastic("#colorLevel3");
	 $("#colorpicker4").farbtastic("#colorLevel4");
	 $("#colorpicker5").farbtastic("#colorLevel5");
	 $("#colorpicker6").farbtastic("#colorLevel6");
	 
	 $("#saveColor").on("click", function() {
		$("#colorSetForm").submit();
	 });
});