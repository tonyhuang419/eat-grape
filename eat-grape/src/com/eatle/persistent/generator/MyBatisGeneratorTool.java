package com.eatle.persistent.generator;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

/**
 *@Description:生成器启动类
 */
public class MyBatisGeneratorTool
{
	public static void main(String[] args)
	{
		List<String> warnings = new ArrayList<String>();
		boolean overwrite = true;
		String genCfg = "generatorConfig.xml";
		File configFile = new File(MyBatisGeneratorTool.class.getResource(
				genCfg).getFile());
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = null;
		try
		{
			System.out
					.println("--------->>>Start to generate code....--------------------");
			config = cp.parseConfiguration(configFile);
			DefaultShellCallback callback = new DefaultShellCallback(overwrite);
			MyBatisGenerator myBatisGenerator = null;
			myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
			myBatisGenerator.generate(null);
			System.out
					.println("--------->>>Finished to generate code....--------------------");
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		catch (InvalidConfigurationException e)
		{
			e.printStackTrace();
		}
		catch (XMLParserException e)
		{
			e.printStackTrace();
		}
	}
}
