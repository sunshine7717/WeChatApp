package com.lanou.service_wj;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.lanou.bean.TbAddress;
import com.lanou.bean.TbOrder;
import com.lanou.bean.TbPro;
import com.lanou.bean.TbSize;
import com.lanou.bean.TbType;
import com.lanou.bean.TbUser;
import com.lanou.bean.TbUserinfo;

public interface IUService {

	public List<TbPro> selectAllPro();

	public List<TbType> selectAllType();

	public List<Object> selectProById(Integer id);

	public List<Object> selectPtoByTypeId(Integer typeId);

	public List<TbSize> selectSize(Integer typeId);

	public List<TbAddress> selsteAddress(HttpSession session);

	public Map<String, Object> insertOrder(TbOrder order, HttpSession session);

	public List<Object> selectByUserId(HttpSession session);

	public Map<String, Object> updateState(TbOrder order);
	
	public Map<String, Object> deleteOrder(TbOrder order);
	
	public Map<String, Object> deleteAddress(TbAddress tbAddress);
	
	public Map<String,Object> insertAddress(TbAddress tbAddress,HttpSession session);
	
	//public Map<String, Object> selectTyprName(Integer typeId);
	
	//注册
	public String register(TbUser tbuser, TbUserinfo userinfo);

	//登录
	public String login(TbUser tbuser, HttpSession session);

	//退出登录
	public Map<String, Object> logout(HttpSession session);

	// 修改个人信息
	public Map<String, Object> updateUserInfo(TbUserinfo tbinfo, HttpSession session);
	
	public Map<String, Object> getName(HttpSession session);
	
	public Map<String,Object> selectPersonInfo(HttpSession session);
}
