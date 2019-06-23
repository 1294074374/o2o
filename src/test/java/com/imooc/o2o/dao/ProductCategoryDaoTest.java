package com.imooc.o2o.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import com.imooc.o2o.BaseTest;
import com.imooc.o2o.entity.ProductCategory;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductCategoryDaoTest extends BaseTest{
	@Autowired
	private ProductCategoryDao productCategoryDao;
	
	@Test
	@Ignore
	public void testAQueryByShopId() throws Exception{
		long shopId = 1L;
		List<ProductCategory> productCategoryList = productCategoryDao.queryProductCategoryList(shopId);
		System.out.println("该店铺自定义类别数为:"+productCategoryList.size());
	}
	
	@Test
	@Ignore
	public void testBBatchInsertProductCategory() throws Exception{
		ProductCategory productCategory1 = new ProductCategory();
		productCategory1.setShopId(2L);
		productCategory1.setPriority(10);
		productCategory1.setProductCategoryName("测试商品类别1");
		productCategory1.setCreateTime(new Date());
		ProductCategory productCategory2 = new ProductCategory();
		productCategory2.setShopId(2L);
		productCategory2.setPriority(5);
		productCategory2.setProductCategoryName("测试商品类别2");
		productCategory2.setCreateTime(new Date());
		List<ProductCategory> list = new ArrayList<ProductCategory>();
		list.add(productCategory1);
		list.add(productCategory2);
		int effectedNum = productCategoryDao.batchInsertProductCategory(list);
		assertEquals(2,effectedNum);
	}
	
	@Test
	@Ignore
	public void testCDeleteProductCategory() {
		long shopId=2L;
		List<ProductCategory> productCategoryList = productCategoryDao.queryProductCategoryList(shopId);
		for(ProductCategory pc : productCategoryList) {
			if("测试商品类别1".equals(pc.getProductCategoryName()) || "测试商品类别2".equals(pc.getProductCategoryName())){
				int effectedNum = productCategoryDao.deleteProductCategory(pc.getProductCategoryId(), shopId);
				assertEquals(1,effectedNum);
			}
		}
	}
	
	
}
