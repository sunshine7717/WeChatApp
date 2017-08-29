package com.lanou.mapper;

import java.util.List;

import com.lanou.bean.TbAddress;

public interface TbAddressMapper {
	
	List<TbAddress> selectAddress(Integer userId);
		
    int deleteByPrimaryKey(Integer id);

    int insert(TbAddress record);

    int insertSelective(TbAddress record);

    TbAddress selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbAddress record);

    int updateByPrimaryKey(TbAddress record);
    
    List<TbAddress> selectOneAddress(String addid);
}