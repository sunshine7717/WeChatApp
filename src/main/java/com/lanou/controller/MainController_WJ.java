package com.lanou.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lanou.bean.TbAddress;
import com.lanou.bean.TbOrder;
import com.lanou.bean.TbPro;
import com.lanou.bean.TbSize;
import com.lanou.bean.TbType;
import com.lanou.bean.TbUser;
import com.lanou.bean.TbUserinfo;
import com.lanou.service_wj.UService;

@Controller
public class MainController_WJ {

	@Resource
	UService service;

	@RequestMapping(value = "/getname")
	@ResponseBody
	public Map<String, Object> getName(HttpSession session) {

		
		return service.getName(session);
	}

	@RequestMapping(value = "/selectInfo")
	@ResponseBody
	public Map<String, Object> selectInfo(HttpSession session) {

		return service.selectPersonInfo(session);
	}

	@RequestMapping(value = "/register")
	@ResponseBody
	public Map<String, Object> register(TbUser tbuser, TbUserinfo userinfo) {
		Map<String, Object> map = new HashMap<String, Object>();

		String str = service.register(tbuser, userinfo);
		map.put("info", str);

		return map;
	}

	/*
	 * 登录方法
	 */
	@RequestMapping(value = "/login")
	@ResponseBody
	public Map<String, Object> login(TbUser tbuser, HttpSession session) {
		Map<String, Object> map = new HashMap<String, Object>();

		String str = service.login(tbuser, session);
		System.out.println(str);
		map.put("info", str);
		return map;
	}

	/*
	 * 获取当前用户session
	 */
	@RequestMapping(value = "/getSession")
	public Object getSession(HttpSession session) {
		Map<String, Object> map = new HashMap<String, Object>();

		TbUser user = (TbUser) session.getAttribute("user");
		String username = user.getUserName();
		System.out.println(user);
		return username;
	}

	/*
	 * 用户退出
	 */
	@RequestMapping(value = "/logout")
	@ResponseBody
	public Map<String, Object> logout(HttpSession session) {

		return service.logout(session);

	}

	/*
	 * 修改个人信息
	 */
	@RequestMapping(value = "/updateUserInfo")
	@ResponseBody
	public Map<String, Object> updateUserInfo(TbUserinfo tbinfo, HttpSession session) {
	

		return service.updateUserInfo(tbinfo, session);
	}

	@RequestMapping(value = "/selectAllPro")
	@ResponseBody
	public List<TbPro> selectUrl() {

		return service.selectAllPro();
	}

	@RequestMapping(value = "/selectType")
	@ResponseBody
	public List<TbType> selectType() {

		return service.selectAllType();
	}

	@RequestMapping(value = "/selectPro")
	@ResponseBody
	public List<Object> selectProById(@RequestParam("id") Integer id) {

		return service.selectProById(id);
	}

	@RequestMapping(value = "/selectProType")
	@ResponseBody
	public List<Object> selectProByTypeId(@RequestParam("typeId") Integer typeId) {

		return service.selectPtoByTypeId(typeId);
	}

	@RequestMapping(value = "/selectSizeByProId")
	@ResponseBody
	public List<TbSize> selectSizeByProId(@RequestParam("proId") Integer proId) {

		return service.selectSize(proId);

	}

	@RequestMapping(value = "/selectAddress")
	@ResponseBody
	public List<TbAddress> selectAddress(HttpSession session) {

		return service.selsteAddress(session);

	}

	@RequestMapping(value = "/insertOrder")
	@ResponseBody
	public Map<String, Object> insertOrder(TbOrder order, HttpSession session) {

		return service.insertOrder(order, session);
	}

	@RequestMapping(value = "/findaddress")
	@ResponseBody
	public List<Object> findaddress(HttpSession session) {

		return service.selectByUserId(session);
	}

	@RequestMapping(value = "/updateState")
	@ResponseBody
	public Map<String, Object> updateState(TbOrder order) {
		return service.updateState(order);
	}

	@RequestMapping(value = "/deleteorder")
	@ResponseBody
	public Map<String, Object> deleteOrder(TbOrder order) {
		return service.deleteOrder(order);
	}

	@RequestMapping(value = "/deleteAddress")
	@ResponseBody
	public Map<String, Object> deleteAddress(TbAddress tbAddress) {

		return service.deleteAddress(tbAddress);
	}

	@RequestMapping(value = "/insertAddress")
	@ResponseBody
	public Map<String, Object> insertAddress(TbAddress tbAddress, HttpSession session) {

		return service.insertAddress(tbAddress, session);
	}

	/*@RequestMapping(value = "/selectType1")
	@ResponseBody
	public Map<String, Object> selectType1(@RequestParam("typeId")Integer typeId){
		
		return service.selectTyprName(typeId);
	}*/
	
	/*------------------跳转方法------------------*/
	@RequestMapping(value = "/products")
	public String frontPage() {
		return "products";
	}

	@RequestMapping(value = "/index")
	public String frontPage1() {
		return "index";
	}

	@RequestMapping(value = "/personal_center")
	public String frontPage2() {
		return "personal_center";
	}

	@RequestMapping(value = "/descript")
	public String frontPage3() {
		return "descript";
	}

	@RequestMapping(value = "/myorders")
	public String frontPage4() {
		return "myorders";
	}

	@RequestMapping(value = "/products_type")
	public String frontPage5() {
		return "products_type";
	}

	@RequestMapping(value = "/buy_now")
	public String frontPage6() {
		return "buy_now";
	}

	@RequestMapping(value = "/master_address")
	public String frontPage7() {
		return "master_address";
	}

	@RequestMapping(value = "/new_address")
	public String frontPage8() {
		return "new_address";
	}
}
