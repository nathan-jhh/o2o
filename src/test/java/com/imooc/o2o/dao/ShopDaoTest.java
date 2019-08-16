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

public class ShopDaoTest extends BaseTest{
	@Autowired
	private ShopDao shopDao;
	
	@Test
	public void testQueryShopListAndCount() {
		Shop shopCondition = new Shop();
		PersonInfo owner = new PersonInfo();
		owner.setUserId(1L);
		shopCondition.setOwner(owner);
		Area area = new Area();
		area.setAreaId(6);
		shopCondition.setArea(area);;
		List<Shop> shopList = shopDao.queryShopList(shopCondition, 0, 103);
		int count = shopDao.queryShopCount(shopCondition);
		System.out.println("店铺列表的大小：" + shopList.size());
		System.out.println("店铺总数的大小：" + count);
//		ShopCategory sc = new ShopCategory();
//		sc.setShopCategoryId(1L);
//		shopCondition.setShopCategory(sc);
//		List<Shop> shopList1 = shopDao.queryShopList(shopCondition, 0, 2);
//		int count1 = shopDao.queryShopCount(shopCondition);
//		System.out.println("新店铺列表的大小：" + shopList1.size());
//		System.out.println("新店铺总数的大小：" + count1);
	}
	
	@Test
	@Ignore
	public void testQueryByShopId() {
		long shopId = 16;
		Shop shop = shopDao.queryByShopId(shopId);
		System.out.println("area_id: " + shop.getArea().getAreaId());
		System.out.println("area_name: " + shop.getArea().getAreaName());
	}
	
	@Test
	@Ignore
	public void testInsertShop() {
		Shop shop = new Shop();
		PersonInfo owner = new PersonInfo();
		Area area = new Area();
		ShopCategory shopCategory = new ShopCategory();
		
		owner.setUserId(1L);
		area.setAreaId(4);
		shopCategory.setShopCategoryId(1L);
		shop.setOwner(owner);
		shop.setArea(area);
		shop.setShopCategory(shopCategory);
		shop.setShopName("测试的店铺");
		shop.setShopDesc("test");
		shop.setShopAddr("test");
		shop.setPhone("test");
		shop.setShopImg("test");
		shop.setCreateTime(new Date());
		shop.setEnableStatus(1);
		shop.setAdvice("审核中");
		int effectedNum = shopDao.insertShop(shop);
		assertEquals(1,effectedNum);
		
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
		assertEquals(1,effectedNum);
	}
}
