<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>

<link rel="stylesheet" href="${ctx}/style/backend/colorselect/farbtastic.css" type="text/css" />
<script type="text/javascript" src="${ctx}/js/backend/colorselect/farbtastic.js"></script>
<script type="text/javascript" src="${ctx}/js/backend/colorselect/init.js"></script>

<div class="pageContent" layoutH="35">
	<form action="${ctx}/admin/system/systemdata/colorIdentify/doSetColor.htm" id="colorSetForm" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
	  <table width="75%" border="0" align="center" cellpadding="0" cellspacing="0" style="margin-left: 20px;">
	    <tr>
	      <td height="250">
	      	<div id="colorpicker1"></div>
		    <label>Level1:</label>
	      	<input id="colorLevel1" name="colorMap.level1" type="text" class="required" maxlength="7" value="${colorMap.level1}"/>
	      </td>
	      <td height="250">
	      	<div id="colorpicker2"></div>
	    	<label>Level2:</label>
	     	<input id="colorLevel2" name="colorMap.level2" type="text" class="required" maxlength="7" value="${colorMap.level2}"/>
	      </td>
	      <td height="250">
	      	<div id="colorpicker3"></div>
	    	<label>Level3:</label>
	     	<input id="colorLevel3" name="colorMap.level3" type="text" class="required" maxlength="7" value="${colorMap.level3}"/>
	      </td>
	    </tr>
	    <tr>
	      <td height="250">
	      	<div id="colorpicker4"></div>
	    	<label>Level4:</label>
	     	<input id="colorLevel4" name="colorMap.level4" type="text" class="required" maxlength="7" value="${colorMap.level4}"/>
	      </td>
	      <td height="250">
	      	<div id="colorpicker5"></div>
	    	<label>Level5:</label>
	     	<input id="colorLevel5" name="colorMap.level5" type="text" class="required" maxlength="7" value="${colorMap.level5}"/>
	      </td>
	      <td height="250">
	      	<div id="colorpicker6"></div>
	    	<label>Level6:</label>
	    	<input id="colorLevel6" name="colorMap.level6" type="text" class="required" maxlength="7" value="${colorMap.level6}" />
	      </td>
	    </tr>
	  </table>
	</form>
</div>
<div class="formBar">
	<ul>
		<li><div class="buttonActive"><div class="buttonContent"><button id="saveColor" type="button">保存</button></div></div></li>
	</ul>
</div>