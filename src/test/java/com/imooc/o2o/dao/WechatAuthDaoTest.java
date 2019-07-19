package com.imooc.o2o.dao;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.imooc.o2o.BaseTest;
import com.imooc.o2o.entity.PersonInfo;
import com.imooc.o2o.entity.WechatAuth;

public class WechatAuthDaoTest extends BaseTest {
	@Autowired
	private WechatAuthDao wechatAuthDao;

	@Test
	@Ignore
	public void testQueryWechatAuthDao() {
		String OpenId = "ss";
		WechatAuth wechatAuth = wechatAuthDao.queryWechatAuthByOpenId(OpenId);
		System.out.println(wechatAuth.getCreateTime().toString());
	}

	@Test
	@Ignore
	public void testInsertWechatAuth() {
		PersonInfo personInfo = new PersonInfo();
		personInfo.setUserId(1L);
		WechatAuth wechatAuth = new WechatAuth();
		wechatAuth.setOpenId("测试1");
		wechatAuth.setWechatAuthId(1L);
		wechatAuth.setPersionInfo(personInfo);
		wechatAuth.setCreateTime(new Date());
		int effectNum = wechatAuthDao.insertWechatAuth(wechatAuth);
		assertEquals(1, effectNum);
	}
}
