package com.imooc.o2o.dto;

import java.util.List;

import com.imooc.o2o.entity.Shop;

public class ShopExecution {
	//结果状态
	private int state;
	
	//状态标志
	private String stateInfo;
	
	//店铺数量
	private int count;
	
	//操作的shop（增删改店铺时使用）
	private Shop shop;
	
	//shop列表（查询店铺列表时使用）
	private List<Shop> shopList;
	
	
}
