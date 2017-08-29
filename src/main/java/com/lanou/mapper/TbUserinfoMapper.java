package com.lanou.mapper;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;

import com.lanou.bean.TbUserinfo;
@Resource
public interface TbUserinfoMapper {
	
//	int updateUserid(Integer userId);
	
	
	
	int updateUserinfo(TbUserinfo tbinfo);
	
	
    int deleteByPrimaryKey(Integer id);

    int insert(TbUserinfo record);

    int insertSelective(TbUserinfo record);

    TbUserinfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbUserinfo record);

    int updateByPrimaryKey(TbUserinfo record);
    
    TbUserinfo selectInfoByUserId(@Param("userId")Integer userId);
}