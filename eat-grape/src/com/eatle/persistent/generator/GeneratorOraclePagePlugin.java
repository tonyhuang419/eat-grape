package com.eatle.persistent.generator;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;

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
 *@Description: Oracle分页支持
 */
public class GeneratorOraclePagePlugin extends PluginAdapter
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
		XmlElement answer = new XmlElement("include"); //$NON-NLS-1$
		answer.addAttribute(new Attribute("refid", //$NON-NLS-1$
				introspectedTable.getBaseColumnListId()));
		return answer;
	}

	protected XmlElement getBlobColumnListElement(
			IntrospectedTable introspectedTable)
	{
		XmlElement answer = new XmlElement("include"); //$NON-NLS-1$
		answer.addAttribute(new Attribute("refid", //$NON-NLS-1$
				introspectedTable.getBlobColumnListId()));
		return answer;
	}

	/**
	 * @Description ：为selectByMap添加Oracle分页的代码（表中包含大字段）
	 */
	@Override
	public boolean sqlMapSelectByExampleWithBLOBsElementGenerated(
			XmlElement element, IntrospectedTable introspectedTable)
	{
		element.addElement(0, new TextElement(
				"select * from (select a.*, rownum rn from ("));
		element.addElement(new TextElement(") a"));

		XmlElement whereElement_1 = new XmlElement("where");
		XmlElement ifElement_1 = new XmlElement("if");
		ifElement_1.addAttribute(new Attribute("test",
				"startIndex != null and pageSize != null"));
		ifElement_1.addElement(new TextElement(
				"rownum &lt;= (${startIndex} + ${pageSize})"));
		whereElement_1.addElement(ifElement_1);
		element.addElement(whereElement_1);

		element.addElement(new TextElement(")"));

		XmlElement whereElement_2 = new XmlElement("where");
		XmlElement ifElement_2 = new XmlElement("if");
		ifElement_2.addAttribute(new Attribute("test", "startIndex != null"));
		ifElement_2.addElement(new TextElement("rn &gt;= ${startIndex}"));
		whereElement_2.addElement(ifElement_2);
		element.addElement(whereElement_2);

		return true;
	}

	/**
	 * @Description ：为selectByMap添加Oracle分页的代码（表中不包含大字段）
	 */
	@Override
	public boolean sqlMapSelectByExampleWithoutBLOBsElementGenerated(
			XmlElement element, IntrospectedTable introspectedTable)
	{
		element.addElement(0, new TextElement(
				"select * from (select a.*, rownum rn from ("));
		element.addElement(new TextElement(") a"));

		XmlElement whereElement_1 = new XmlElement("where");
		XmlElement ifElement_1 = new XmlElement("if");
		ifElement_1.addAttribute(new Attribute("test",
				"startIndex != null and pageSize != null"));
		ifElement_1.addElement(new TextElement(
				"rownum &lt;= (${startIndex} + ${pageSize})"));
		whereElement_1.addElement(ifElement_1);
		element.addElement(whereElement_1);

		element.addElement(new TextElement(")"));

		XmlElement whereElement_2 = new XmlElement("where");
		XmlElement ifElement_2 = new XmlElement("if");
		ifElement_2.addAttribute(new Attribute("test", "startIndex != null"));
		ifElement_2.addElement(new TextElement("rn &gt;= ${startIndex}"));
		whereElement_2.addElement(ifElement_2);
		element.addElement(whereElement_2);

		return true;
	}

	/**
	 * @Description: 为insert方法添加主键值（通过序列获取）
	 */
	@Override
	public boolean sqlMapInsertElementGenerated(XmlElement element,
			IntrospectedTable introspectedTable)
	{
		Properties props = new Properties();
		try
		{
			props.load(new FileInputStream(new File(this.getClass()
					.getResource("/com/eatle/persistent/generator/generatorConfig.properties").toURI())));
			XmlElement selectKeyElement = new XmlElement("selectKey");
			selectKeyElement.addAttribute(new Attribute("resultType", "long"));
			selectKeyElement.addAttribute(new Attribute("keyProperty", "id"));
			selectKeyElement.addAttribute(new Attribute("order", "BEFORE"));
			selectKeyElement.addElement(new TextElement("select "
					+ props.getProperty("sequenceName")
					+ ".NEXTVAL as ID from dual "));

			element.addElement(selectKeyElement);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return true;
	}
}