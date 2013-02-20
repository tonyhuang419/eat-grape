<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>

<div class="pageContent" style="padding:2px;">
	<div class="tabs">
		<div class="tabsContent" layoutH="15">
			<div>
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<c:forEach items="${systemLogs}" step="7" varStatus="rowNum">
					  <tr>
						<c:forEach items="${systemLogs}" var="sl" varStatus="colNum" begin="${rowNum.index + 0}" end="${rowNum.index + 6}">
							<td>
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
								  <tr>
									<td colspan="2" width="20%">
										<img src="${ctx}/images/backend/log.jpg" title="${sl.fileName} / ${sl.fileSize}" style="margin: 10px;"/>
									</td>
								  </tr>
								  <tr>
								    <td colspan="2" align="center">${sl.lastModified}</td>
						          </tr>
								  <tr>
								    <td colspan="2" align="center">
								    	<a href="${ctx}/admin/system/systemdata/systemLog/detail.htm?systemLog.fileName=${sl.fileName}" target="dialog" mask="true" width="1000" height="600" title="${sl.fileName}--日志查看">查看</a>&nbsp;&nbsp;&nbsp;&nbsp;
								    	<a href="${ctx}/admin/system/systemdata/systemLog/downLog.htm?systemLog.fileName=${sl.fileName}" target="dwzExport">下载</a>&nbsp;&nbsp;&nbsp;&nbsp;
								    	<a href="${ctx}/admin/system/systemdata/systemLog/delete.htm?systemLog.fileName=${sl.fileName}&navTabId=${param.navTabId}" target="ajaxTodo" title="确定要删除 [${sl.fileName}] 吗?">删除</a>
								    </td>
							      </tr>
								</table>
							</td>
						</c:forEach>
					  </tr>
					</c:forEach>
				</table>				
			</div>
		</div>
		<div class="tabsFooter">
			<div class="tabsFooterContent"></div>
		</div>
	</div>
</div>