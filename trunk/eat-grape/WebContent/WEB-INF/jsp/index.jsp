<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=7" />
		<title>Eatle_后台管理系统</title>
		<%@ include file="/WEB-INF/common/jslibs.jsp"%>
		<script type="text/javascript">
			$(function(){
				DWZ.init("${ctx}/dwz.frag.xml", {
				//	loginUrl:"index.htm", loginTitle:"登录",	// 弹出登录对话框
					loginUrl:"index.htm",	// 跳到登录页面
					statusCode:{ok:200, error:300, timeout:301}, //【可选】
					pageInfo:{pageNum:"pageNum", numPerPage:"numPerPage", orderField:"orderField", orderDirection:"orderDirection"}, //【可选】
					debug:false,	// 调试模式 【true|false】
					callback:function(){
						initEnv();
						$("#themeList").theme({themeBase:"themes"}); // themeBase 相对于index页面的主题base路径
					}
				});
			});
		</script>
	</head>

	<body scroll="no">
		<div id="layout">
			<div id="header">
				<div class="headerNav">
					<a class="logo" href="http://j-ui.com">标志</a>
					<ul class="nav">
						<li id="switchEnvBox"><a href="javascript:">（<span>北京</span>）切换城市</a>
							<ul>
								<li><a href="sidebar_1.html">北京</a></li>
								<li><a href="sidebar_2.html">上海</a></li>
								<li><a href="sidebar_2.html">南京</a></li>
								<li><a href="sidebar_2.html">深圳</a></li>
								<li><a href="sidebar_2.html">广州</a></li>
								<li><a href="sidebar_2.html">天津</a></li>
								<li><a href="sidebar_2.html">杭州</a></li>
							</ul>
						</li>
						
						<li><a href="changepwd.html" target="dialog" width="600">设置</a></li>
						<li><a href="http://weibo.com/dwzui" target="_blank">微博</a></li>
						<li><a href="#" onclick="confirm2Link('您确定退出吗？', 'loginout.htm')">退出</a></li>
					</ul>
					<ul class="themeList" id="themeList">
						<li theme="default"><div class="selected">蓝色</div></li>
						<li theme="green"><div>绿色</div></li>
						<!--<li theme="red"><div>红色</div></li>-->
						<li theme="purple"><div>紫色</div></li>
						<li theme="silver"><div>银色</div></li>
						<li theme="azure"><div>天蓝</div></li>
					</ul>
				</div>
	
				<!-- navMenu -->
				
			</div>
	
			<div id="leftside">
				<div id="sidebar_s">
					<div class="collapse">
						<div class="toggleCollapse"><div></div></div>
					</div>
				</div>
				<div id="sidebar">
					<div class="toggleCollapse"><h2>主菜单</h2><div>收缩</div></div>
	
					<div class="accordion" fillSpace="sidebar">
						${allMenuHtml}
					</div>
				</div>
			</div>
			<div id="container">
				<div id="navTab" class="tabsPage">
					<div class="tabsPageHeader">
						<div class="tabsPageHeaderContent"><!-- 显示左右控制时添加 class="tabsPageHeaderMargin" -->
							<ul class="navTab-tab">
								<li tabid="main" class="main"><a href="javascript:;"><span><span class="home_icon">&nbsp;首&nbsp;&nbsp;页</span></span></a></li>
							</ul>
						</div>
						<div class="tabsLeft">left</div><!-- 禁用只需要添加一个样式 class="tabsLeft tabsLeftDisabled" -->
						<div class="tabsRight">right</div><!-- 禁用只需要添加一个样式 class="tabsRight tabsRightDisabled" -->
						<div class="tabsMore">more</div>
					</div>
					<ul class="tabsMoreList">
						<li><a href="javascript:;">&nbsp;首&nbsp;&nbsp;页</a></li>
					</ul>
					<div class="navTab-panel tabsPageContent layoutBox">
						<div class="page unitBox" style="height: 100%; margin: 1px;">
							<img src="${ctx}/image/welcome.png" alt="" width="100%" height="100%"/>
						</div>
						
					</div>
				</div>
			</div>
	
		</div>
	
		<div id="footer">Copyright &copy; 2012 <a href="demo_page2.html" target="dialog">eatle</a></div>
	
	<!-- 注意此处js代码用于google站点统计，非DWZ代码，请删除 -->
	<script type="text/javascript">
	  var _gaq = _gaq || [];
	  _gaq.push(['_setAccount', 'UA-16716654-1']);
	  _gaq.push(['_trackPageview']);
	
	  (function() {
	    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
	    ga.src = ('https:' == document.location.protocol ? ' https://ssl' : ' http://www') + '.google-analytics.com/ga.js';
	    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
	  })();
	</script>
	
	</body>
</html>