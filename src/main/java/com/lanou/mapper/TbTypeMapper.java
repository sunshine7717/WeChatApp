package com.lanou.mapper;

import java.util.List;

import com.lanou.bean.TbType;

public interface TbTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbType record);

    int insertSelective(TbType record);

    List selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbType record);

    int updateByPrimaryKey(TbType record);
    
    List<TbType> selectType();
    
    List<TbType> selectById(Integer typeId);
}