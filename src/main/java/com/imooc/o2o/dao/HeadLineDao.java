package com.imooc.o2o.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.imooc.o2o.entity.HeadLine;

public interface HeadLineDao {
	/**
	 * 根据传入的查询条件(头条名查询头条)
	 * @param headLineCondition
	 * @return
	 */
	List<HeadLineDao> queryHeadLine(@Param("headLineCondition") HeadLine headLineCondition);
	
}
