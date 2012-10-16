package com.eatle.service.test.system;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.junit.Test;

import com.eatle.persistent.pojo.system.basedata.Menu;
import com.eatle.persistent.pojo.system.useradmin.User;
import com.eatle.service.system.basedata.IMenuService;
import com.eatle.service.system.useradmin.IRolePrivilegeService;
import com.eatle.service.system.useradmin.IUserService;
import com.eatle.service.test.BaseTest;
import com.eatle.utils.ExcelUtil;
import com.eatle.utils.ExcelUtil.ExportSetInfo;

/**
 * @corpor 公司：深讯信科
 * @author 作者：谭又中
 * @explain 释义：
 * @version 日期：2012-8-31 上午12:34:10
 */
public class RolePrivilegeTest extends BaseTest
{

	private static IRolePrivilegeService rolePrivilegeService = (IRolePrivilegeService) ctx
			.getBean("rolePrivilegeService");

	private static IUserService userService = (IUserService) ctx
			.getBean("userService");

	private static IMenuService menuService = (IMenuService) ctx
			.getBean("menuService");

	@Test
	public void test()
	{
		// System.out.println(rolePrivilegeService.findAll().size());

		System.out.println(rolePrivilegeService.findAll().size());
	}

	@Test
	public void deleteByCriteria()
	{
		rolePrivilegeService.deleteByRoleIdAndPrivId(3L, 17L);
	}

	// Excel导出测试
	@SuppressWarnings("unchecked")
	@Test
	public void export2Excel() throws FileNotFoundException, IOException
	{
		LinkedHashMap<String, List> map = new LinkedHashMap<String, List>();
		List l1 = userService.findAll();
		List l2 = menuService.findAll();
		map.put("用户信息表", l1);
		map.put("菜单信息1", l2);
		map.put("菜单信息2", l2);

		List<String[]> headNames = new ArrayList<String[]>();
		headNames.add(new String[] { "用户名", "密码", "电子邮件", "类型", "角色" });
		headNames.add(new String[] { "Rel", "动作指令", "菜单名称", "URL", "父级菜单" });
		headNames.add(new String[] { "Rel", "动作指令", "菜单名称", "URL", "父级菜单" });

//		ExportSetInfo setInfo = new ExportSetInfo();
//		setInfo.setObjsMap(map);
//		setInfo.setClazz(new Class[] { User.class, Menu.class, Menu.class });
//		setInfo.setTitles(new String[] { "用户列表", "菜单列表1", "菜单列表2" });
//		setInfo.setStartFieldIndexs(new int[] { 2, 1, 1 });
//		setInfo.setEndFieldIndexs(new int[] { 6, 5, 5 });
//		setInfo.setHeadNames(headNames);
//		setInfo.setOut(new FileOutputStream("c:\\a.xls"));
//
//		ExcelUtil.export2Excel(setInfo);
	}
}