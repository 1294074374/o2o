package com.imooc.o2o.dao;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.imooc.o2o.BaseTest;
import com.imooc.o2o.entity.LocalAuth;
import com.imooc.o2o.entity.PersonInfo;

public class LocalAuthDaoTest extends BaseTest {
	@Autowired
	private LocalAuthDao localAuthDao;
	private static final String username = "testusername";
	private static final String password = "testpassword";

	@Test
	
	public void testQueryLocalAuthByUserNameAndPwd() {
		String userName = "123";
		String password = "123";
		LocalAuth localAuth = localAuthDao.queryLocalAuthByUserNameAndPwd(userName, password);
		assertEquals("测试", localAuth.getPersonInfo().getName());
	}

	@Test
	@Ignore
	public void testQueryLocalAuthById() {
		long userId = 1L;
		LocalAuth localAuth = localAuthDao.queryLocalAuthById(userId);
		assertEquals("测试", localAuth.getPersonInfo().getName());
	}

	@Test

	@Ignore
	public void testInsertLocalAuth() {
		// 新增一条平台账号信息
		LocalAuth localAuth = new LocalAuth();
		PersonInfo personInfo = new PersonInfo();
		personInfo.setUserId(1L);
		// 给平台账号绑定上用户信息
		localAuth.setPersonInfo(personInfo);
		localAuth.setUserName(username);
		localAuth.setPassword(password);
		localAuth.setCreateTime(new Date());
		localAuth.setLastEditTime(new Date());
		int effectedNum = localAuthDao.insertLocalAuth(localAuth);
		assertEquals(1, effectedNum);
	}

	@Test
	@Ignore
	public void testUpdateLocalAuth() {
		Long userId=1L;
		String userName="testusername";
		String password="testpassword";
		String newPassword="testupdate";
		Date lastEditTime=new Date();
		int effectedNum=localAuthDao.updateLocalAuth(userId, userName, password, newPassword, lastEditTime);
		assertEquals(1, effectedNum);
	}
}
