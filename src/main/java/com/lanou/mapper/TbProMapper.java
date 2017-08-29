package com.lanou.mapper;

import java.util.List;

import javax.annotation.Resource;

import com.lanou.bean.TbPro;
import com.lanou.bean.TbType;

@Resource
public interface TbProMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbPro record);

    int insertSelective(TbPro record);

    List<TbPro> selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbPro record);

    int updateByPrimaryKey(TbPro record);
    
    List<TbPro> selectPro();
    
    List<TbPro> selectProType(Integer id);
    
}