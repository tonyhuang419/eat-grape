package com.eatle.persistent.generator;

import java.util.List;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.JavaVisibility;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.Parameter;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;

/**
 * 
 *@Title: MySQL分页支持
 *@Description:
 *@Author:xt
 *@Since:2012-7-3
 *@Version:1.1.0
 */
public class GeneratorMysqlPagePlugin extends PluginAdapter
{

	@Override
	public boolean validate(List<String> warnings)
	{
		return true;
	}

	private void addField(String fieldName, FullyQualifiedJavaType fieldType,
			TopLevelClass topLevelClass, String javaDocLine)
	{
		Field tmpField = new Field(fieldName, fieldType);
		tmpField.setVisibility(JavaVisibility.PRIVATE);
		tmpField.addJavaDocLine(javaDocLine);
		topLevelClass.addField(tmpField);

		Method setMethod = new Method();
		setMethod.setName("set" + fieldName.toUpperCase().substring(0, 1)
				+ fieldName.substring(1));
		Parameter param = new Parameter(fieldType, fieldName);
		setMethod.addParameter(param);
		setMethod.setVisibility(JavaVisibility.PUBLIC);
		setMethod.addBodyLine("this." + fieldName + "=" + fieldName + ";");

		topLevelClass.addMethod(setMethod);

		Method getMethod = new Method();
		getMethod.setName("get" + fieldName.toUpperCase().substring(0, 1)
				+ fieldName.substring(1));

		getMethod.setReturnType(fieldType);
		getMethod.setVisibility(JavaVisibility.PUBLIC);
		getMethod.addBodyLine("return this." + fieldName + ";");

		topLevelClass.addMethod(getMethod);

	}

	@Override
	public boolean modelExampleClassGenerated(TopLevelClass topLevelClass,
			IntrospectedTable introspectedTable)
	{
		FullyQualifiedJavaType intType = FullyQualifiedJavaType
				.getIntInstance();
		addField("startIndex", intType, topLevelClass, "// 开始索引号");
		addField("pageSize", intType, topLevelClass, "// 每页大小");

		Method newConstructorMethod = new Method();
		newConstructorMethod.setConstructor(true);
		newConstructorMethod.addParameter(new Parameter(intType, "pageSize"));
		newConstructorMethod.addParameter(new Parameter(intType, "startIndex"));
		newConstructorMethod.addBodyLine("this();");
		newConstructorMethod.addBodyLine("this.pageSize=pageSize;");
		newConstructorMethod.addBodyLine("this.startIndex=startIndex;");
		newConstructorMethod.setVisibility(JavaVisibility.PUBLIC);
		newConstructorMethod.setName(topLevelClass.getType().getShortName());

		topLevelClass.addMethod(newConstructorMethod);
		return true;
	}

	protected XmlElement getBaseColumnListElement(
			IntrospectedTable introspectedTable)
	{
		XmlElement answer = new XmlElement("include");
		answer.addAttribute(new Attribute("refid",
				introspectedTable.getBaseColumnListId()));
		return answer;
	}

	protected XmlElement getBlobColumnListElement(
			IntrospectedTable introspectedTable)
	{
		XmlElement answer = new XmlElement("include");
		answer.addAttribute(new Attribute("refid",
				introspectedTable.getBlobColumnListId()));
		return answer;
	}

	/**
	 * @Description ：为selectByMap添加MySQL分页的代码（表中包含大字段）
	 */
	@Override
	public boolean sqlMapSelectByExampleWithBLOBsElementGenerated(
			XmlElement element, IntrospectedTable introspectedTable)
	{
		XmlElement ifElement = new XmlElement("if");
		ifElement.addAttribute(new Attribute("test", "pageSize > 0"));
		ifElement.addElement(new TextElement("limit ${startIndex},${pageSize}"));
		element.addElement(ifElement);
		return true;
	}

	/**
	 * @Description ：为selectByMap添加MySQL分页的代码（表中包含大字段）
	 */
	@Override
	public boolean sqlMapSelectByExampleWithoutBLOBsElementGenerated(
			XmlElement element, IntrospectedTable introspectedTable)
	{
		XmlElement ifElement = new XmlElement("if");
		ifElement.addAttribute(new Attribute("test", "pageSize > 0"));
		ifElement.addElement(new TextElement("limit ${startIndex},${pageSize}"));
		element.addElement(ifElement);
		return true;
	}
}