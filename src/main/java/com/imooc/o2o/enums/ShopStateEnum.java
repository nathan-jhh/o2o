package com.imooc.o2o.enums;

public enum ShopStateEnum {
	CHECK(0,"审核中"),OFFLINE(-1,"非法店铺"),SUCCESS(1,"操作成功"),NULL_SHOP(-1003,"shop信息为空"),
	PASS(2,"通过认证"),INNER_ERROR(-1001,"内部系统错误"),NULL_SHOPID(-1002,"ShopId为空");
	
	private int state;
	private String stateInfo;
	
	public int getState() {
		return state;
	}

	public String getStateInfo() {
		return stateInfo;
	}

	// 构造函数私有，保证enum值不被外部程序修改
	private ShopStateEnum(int state, String stateInfo) {
		this.state = state;
		this.stateInfo = stateInfo;
	}
	
	/**
	 *  依据传入的state返回相应的enum值
	 * @param state
	 * @return
	 */
	public static ShopStateEnum stateOf(int state) {
		for(ShopStateEnum stateEnum : values()) {
			return stateEnum;
		}
		// 如没找到，返回空值
		return null;
	}
}
