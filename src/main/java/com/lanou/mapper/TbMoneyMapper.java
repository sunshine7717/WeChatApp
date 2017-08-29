package com.lanou.mapper;

import com.lanou.bean.TbMoney;

public interface TbMoneyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbMoney record);

    int insertSelective(TbMoney record);

    TbMoney selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbMoney record);

    int updateByPrimaryKey(TbMoney record);
}