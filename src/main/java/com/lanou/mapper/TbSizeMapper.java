package com.lanou.mapper;

import java.util.List;

import com.lanou.bean.TbSize;

public interface TbSizeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbSize record);

    int insertSelective(TbSize record);

    TbSize selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbSize record);

    int updateByPrimaryKey(TbSize record);
    
    List<TbSize> selectPriceBy(Integer proId);

	List<TbSize> selectSize(Integer proId);
	
	List<TbSize> selectOneSize(Integer sizeid);
}