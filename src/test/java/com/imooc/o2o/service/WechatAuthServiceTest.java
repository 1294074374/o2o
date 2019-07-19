package com.imooc.o2o.service;

import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.imooc.o2o.BaseTest;
import com.imooc.o2o.dto.WechatAuthExecution;
import com.imooc.o2o.entity.PersonInfo;
import com.imooc.o2o.entity.WechatAuth;

public class WechatAuthServiceTest extends BaseTest {
	@Autowired
	private WechatAuthService wechatAuthService;

	@Test
	@Ignore
	public void testGetWechatAuthByOpenId() {
		String openId = "ss";
		WechatAuth wechatAuth = wechatAuthService.getWechatAuthByOpenId(openId);
		System.out.println(wechatAuth.getOpenId().toString());
	}

	@Test
	public void testRegiest() {
		PersonInfo personInfo = new PersonInfo();
		WechatAuth wechatAuth = new WechatAuth();
		// personInfo.setUserId(1L);
		personInfo.setUserType(1);
		wechatAuth.setPersionInfo(personInfo);
		wechatAuth.setOpenId("测试一下");
		wechatAuth.setCreateTime(new Date());
		WechatAuthExecution wechatAuthExecution = wechatAuthService.regiest(wechatAuth);
		System.out.println(wechatAuthExecution.getState());
		System.out.println(wechatAuthExecution.getStateInfo());

	}

}
