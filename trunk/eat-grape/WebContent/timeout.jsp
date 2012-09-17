<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>未登陆</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<%@ include file="/WEB-INF/common/jslibs.jsp"%>
  </head>
  
  <body>
	<script>
		art.dialog({
			title : "温馨提示",
			content : "抱歉，您还没有登陆系统！",
			left : "50%",
			icon : "face-sad",
		    drag : false,
		    fixed : true,
		    resize : false,
			close : function(){
				return false;
			},
			okVal : "登  陆",
			ok : function(){
				window.location.href = "${ctx}/index.htm";
				return false;
			}
		}).lock();
	</script>
  </body>
</html>
