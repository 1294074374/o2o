package com.imooc.o2o.dao;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.imooc.o2o.BaseTest;
import com.imooc.o2o.entity.PersonInfo;

public class PersonInfoDaoTest extends BaseTest {

	@Autowired
	private PersonInfoDao personInfoDao;

	@Test
	@Ignore
	public void testQueryPersonInfoById() {
		long userId = 1L;
		PersonInfo personInfo = personInfoDao.queryPersonInfoById(userId);
		System.out.println(personInfo.getName().toString());
	}

	@Test
	@Ignore
	public void testInsertPersonInfo() {
		PersonInfo personInfo = new PersonInfo();
		personInfo.setName("测试2");
		personInfo.setProfileImg("测试2");
		personInfo.setEmail("测试2.@qq.com");
		personInfo.setUserType(1);
		personInfo.setGender("2");
		personInfo.setEnableStatus(1);
		personInfo.setCreateTime(new Date());
		personInfo.setLastEditTime(new Date());
		int effectNum = personInfoDao.insertPersonInfo(personInfo);
		assertEquals(1,effectNum);
	}
}
