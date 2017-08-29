package com.lanou.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lanou.bean.TbOrder;

public interface TbOrderMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(TbOrder record);

	int insertSelective(TbOrder record);

	TbOrder selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(TbOrder record);

	int updateByPrimaryKey(TbOrder record);

	List<TbOrder> selectOrder(Integer userId);

	int updateByUserId(@Param("id") Integer id);
	
}