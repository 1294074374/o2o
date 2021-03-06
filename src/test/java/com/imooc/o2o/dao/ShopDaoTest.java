package com.imooc.o2o.dao;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.imooc.o2o.BaseTest;
import com.imooc.o2o.entity.Area;
import com.imooc.o2o.entity.PersonInfo;
import com.imooc.o2o.entity.Shop;
import com.imooc.o2o.entity.ShopCategory;

//继承BaseTest 引入spring依赖
public class ShopDaoTest extends BaseTest {
	@Autowired
	private ShopDao shopDao;

	@Test
	
	public void testQueryShopListAndCount() {
		Shop shopCondition = new Shop();
		PersonInfo owner = new PersonInfo();
		owner.setUserId(1L);
		shopCondition.setOwner(owner);
		int count = shopDao.queryShopCount(shopCondition);
		List<Shop> list = shopDao.queryShopList(shopCondition, 0, 5);
		System.out.println("店铺列表的大小:" + list.size());
		System.out.println("店铺总数" + count);
		ShopCategory sc = new ShopCategory();
		sc.setShopCategoryId(3L);

	}
	
	@Test
	@Ignore
	public void testQueryShopCount() {
		Shop shopCondition = new Shop();
		PersonInfo owner = new PersonInfo();
		owner.setUserId(1L);
		shopCondition.setOwner(owner);
		int count = shopDao.queryShopCount(shopCondition);
		System.out.println("店铺总数" + count);
	}

	@Test
	@Ignore
	public void testInsertShop() {
		Shop shop = new Shop();
		PersonInfo owner = new PersonInfo();
		Area area = new Area();
		ShopCategory shopCategory = new ShopCategory();
		owner.setUserId(1L);
		area.setAreaId(2);
		shopCategory.setShopCategoryId(1L);
		shop.setOwner(owner);
		shop.setArea(area);
		shop.setShopCategory(shopCategory);
		shop.setShopName("婷婷");
		shop.setShopDesc("3306");
		shop.setShopAddr("8");
		shop.setPhone("t问问");
		shop.setShopImg("t问问t");
		shop.setCreateTime(new Date());
		shop.setEnableStatus(1);
		shop.setAdvice("审核中");
		int effectedNum = shopDao.insertShop(shop);
		assertEquals(1, effectedNum);
	}

	@Test
	@Ignore
	public void testUpdateShop() {
		Shop shop = new Shop();
		shop.setShopId(1L);
		shop.setShopDesc("测试描述");
		shop.setShopAddr("测试地址");
		shop.setLastEditTime(new Date());
		int effectedNum = shopDao.updateShop(shop);
		assertEquals(1, effectedNum);
	}

	@Test
	@Ignore
	public void testQueryByShopId() {
		long shopId = 4;
		Shop shop = shopDao.queryByShopId(shopId);
		System.out.println(shop.getArea().getAreaId());
		System.out.println(shop.getArea().getAreaName());

	}
}
