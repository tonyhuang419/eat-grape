<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>

<script type="text/javascript" src="${ctx}/js/backend/system/systemdata/systeminfo/index.js"></script>

<div class="pageContent">
	<table width="80%" border="0" align="center" cellpadding="1" cellspacing="1" style="margin: 20px 0px 0px 50px;">
		<tr>
			<td height="30" colspan="5">
				<span style="font-size: 14px;">【服务器相关信息】</span>
			</td>
		</tr>
		<tr>
			<td colspan="5" align="right">
				<table width="100%" border="0" cellspacing="0" cellpadding="0" class="table">
					<tr>
						<td width="15%" height="25" align="right">
							服务器名称：
						</td>
						<td height="25" colspan="3" id="serverName">
							${serverInfo.serverName}
						</td>
					</tr>
					<tr>
						<td width="15%" height="25" align="right">
							服务器路径：
						</td>
						<td height="25" colspan="3" id="serverDir">
							${serverInfo.serverDir}
						</td>
					</tr>
					<tr>
						<td width="15%" height="25" align="right">
							域名地址：
						</td>
						<td height="25" id="serverDns">
							${serverInfo.serverDns}
						</td>
						<td width="15%" height="25" align="right">
							IP地址：
						</td>
						<td height="25" id="serverIp">
							${serverInfo.serverIp}
						</td>
					</tr>
					<tr>
						<td width="15%" height="25" align="right">
							通信端口：
						</td>
						<td height="25" id="serverPort">
							${serverInfo.serverPort}
						</td>
						<td width="15%" height="25" align="right">
							当前时间：
						</td>
						<td height="25" id="serverTime">
							${serverInfo.serverTime}
						</td>
					</tr>
					<tr>
						<td width="15%" height="25" align="right">
							运行时间：
						</td>
						<td height="25" id="serverRunTime">
							${serverInfo.serverRunTime}
						</td>
						<td width="15%" height="25" align="right">
							操作系统：
						</td>
						<td height="25" id="osName">
							${serverInfo.osName}
						</td>
					</tr>
					<tr>
						<td width="15%" height="25" align="right">
							系统架构：
						</td>
						<td height="25" id="osArch">
							${serverInfo.osArch}
						</td>
						<td width="15%" height="25" align="right">
							系统版本：
						</td>
						<td height="25" id="osVersion">
							${serverInfo.osVersion}
						</td>
					</tr>
					<tr>
						<td width="15%" height="25" align="right">
							JRE绝对路径：
						</td>
						<td height="25" colspan="3" id="javaHome">
							${serverInfo.javaHome}
						</td>
					</tr>
					<tr>
						<td width="15%" height="25" align="right">
							JRE版本：
						</td>
						<td height="25" id="javaVersion">
							${serverInfo.javaVersion}
						</td>
						<td width="15%" height="25" align="right">
							总共内存：
						</td>
						<td height="25" id="totalMemory">
							${serverInfo.totalMemory} MB
						</td>
					</tr>
					<tr>
						<td width="15%" height="25" align="right">
							空闲内存：
						</td>
						<td height="25" id="freeMemory">
							${serverInfo.freeMemory} MB
						</td>
						<td width="15%" height="25" align="right">
							最大内存：
						</td>
						<td height="25" id="maxMemory">
							${serverInfo.maxMemory} MB
						</td>
					</tr>
					<tr>
						<td width="15%" height="25" align="right">
							在线人数：
						</td>
						<td height="25" id="sessionCount">
							${serverInfo.sessionCount}
						</td>
						<td width="15%" height="25" align="right">
							Application数量：
						</td>
						<td height="25" id="applicationCount">
							${serverInfo.applicationCount}
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td height="30" colspan="5">
				<span style="font-size: 14px;">【客户端相关信息】</span>
			</td>
		</tr>
		<tr>
			<td colspan="5" align="right">
				<table width="100%" border="0" cellspacing="0" cellpadding="0" class="table">
					<tr>
						<td width="15%" height="25" align="right">
							客户端IP：
						</td>
						<td height="25" id="clientIp">
							${clientInfo.clientIp}
						</td>
						<td width="15%" height="25" align="right">
							通信端口：
						</td>
						<td height="25" id="clientPort">
							${clientInfo.clientPort}
						</td>
						<td width="15%" height="25" align="right">
							语音环境：
						</td>
						<td height="25" id="language">
							${clientInfo.language}
						</td>
					</tr>
					<tr>
						<td width="15%" height="25" align="right">
							代理信息：
						</td>
						<td height="25" colspan="5" id="clientAgent">
							${clientInfo.clientAgent}
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</div>