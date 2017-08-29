package com.lanou.mapper;

import com.lanou.bean.TbCar;

public interface TbCarMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbCar record);

    int insertSelective(TbCar record);

    TbCar selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbCar record);

    int updateByPrimaryKey(TbCar record);
}