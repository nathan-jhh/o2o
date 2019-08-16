package com.imooc.o2o.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.imooc.o2o.BaseTest;
import com.imooc.o2o.entity.ShopCategory;

public class ShopCategoryServiceTest extends BaseTest {
	@Autowired
	private ShopCategoryService shopCategoryService;

	@Test
	public void testGetShopCategoryList() {
		List<ShopCategory> categoryList = shopCategoryService.getShopCategoryList(null);
		System.out.println(categoryList.get(0).getShopCategoryName());
		System.out.println(categoryList.size());
		ShopCategory shopCategoryCondition = new ShopCategory();
		ShopCategory parent = new ShopCategory();
		parent.setShopCategoryId(6L);
		shopCategoryCondition.setParent(parent);
		categoryList = shopCategoryService.getShopCategoryList(shopCategoryCondition);
		System.out.println(categoryList.get(0).getShopCategoryName());
	}
}
