package com.lanou.mapper;

import java.util.List;

import javax.annotation.Resource;

import com.lanou.bean.TbUser;
@Resource
public interface TbUserMapper {
	
	TbUser selectUser(String userName, String userPwd);
	
	/**************************************************/
	
    int deleteByPrimaryKey(Integer id);

    int insert(TbUser record);

    int insertSelective(TbUser record);

    TbUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbUser record);

    int updateByPrimaryKey(TbUser record);
}