<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>

<div class="pageContent" style="padding:2px;">
	<div class="tabs" currentIndex="0" eventType="click">
		<div class="tabsHeader">
			<div class="tabsHeaderContent">
				<ul>
					<li><a href="${ctx}/admin/merchant/restaurant/sendplace/showSchoolTab.htm?restaurantId=${param.restaurantId}&schoolName=${param.schoolName}&englishName=${param.englishName}&districtName=${param.districtName}&action=zdylbzs&navTabId=${param.navTabId}" class="j-ajax"><span>学&nbsp;&nbsp;校</span></a></li>
					<li><a href="${ctx}/admin/merchant/restaurant/sendplace/showCommunityTab.htm?restaurantId=${restaurant.id}&action=zdylbzs&navTabId=${param.navTabId}" class="j-ajax"><span>社区/楼宇</span></a></li>
				</ul>
			</div>
		</div>
		<div class="tabsContent" layoutH="43">
			<div></div>
			<div></div>
		</div>
		<div class="tabsFooter">
			<div class="tabsFooterContent"></div>
		</div>
	</div>
</div>