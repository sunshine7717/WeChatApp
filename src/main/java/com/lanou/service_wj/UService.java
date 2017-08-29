package com.lanou.service_wj;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.javassist.expr.NewArray;
import org.springframework.stereotype.Service;

import com.lanou.bean.TbAddress;
import com.lanou.bean.TbOrder;
import com.lanou.bean.TbPro;
import com.lanou.bean.TbSize;
import com.lanou.bean.TbType;
import com.lanou.bean.TbUser;
import com.lanou.bean.TbUserinfo;
import com.lanou.mapper.TbAddressMapper;
import com.lanou.mapper.TbOrderMapper;
import com.lanou.mapper.TbProMapper;
import com.lanou.mapper.TbSizeMapper;
import com.lanou.mapper.TbTypeMapper;
import com.lanou.mapper.TbUserMapper;
import com.lanou.mapper.TbUserinfoMapper;

@Service
public class UService implements IUService {

	@Resource
	TbProMapper proMapper;

	@Resource
	TbTypeMapper typeMapper;

	@Resource
	TbSizeMapper sizeMapper;

	@Resource
	TbAddressMapper addressMapper;

	@Resource
	TbOrderMapper orderMapper;
	@Resource
	private TbUserMapper tbuserMapper;

	@Resource
	private TbUserinfoMapper tbinfoMapper;
	int proId;

	/*
	 * 注册
	 */
	public String register(TbUser tbuser, TbUserinfo userinfo) {

		System.out.println("-----------");

		if (tbuser.getUserName() == null || tbuser.getUserName().equals("")) {
			return "用户名为空,请输入用户名!";
		} else if (tbuser.getUserPwd() == null || tbuser.getUserPwd().equals("")) {
			return "密码为空,请输入密码!";
		} else if (userinfo.getUserinfoName() == null || userinfo.getUserinfoName().equals("")) {
			return "姓名为空,请输入姓名!";
		} else if (userinfo.getUserinfoIdcard() == null || userinfo.getUserinfoIdcard().equals("")) {
			return "身份证号码为空,请输入身份证号码!";
		} else if (userinfo.getUserinfoTel() == null || userinfo.getUserinfoTel().equals("")) {
			return "电话为空,请输入电话号码!";
		} else {
			System.out.println("++++++++++++");
			int number = tbuserMapper.insertSelective(tbuser);

			// 将用户ID插入到个人信息表中
			TbUser tbu = tbuserMapper.selectUser(tbuser.getUserName(), tbuser.getUserPwd());
			userinfo.setUserId(tbu.getId());
			int num = tbinfoMapper.insertSelective(userinfo);

			if (number > 0) {
				return "success";
			} else {
				return "error";
			}
		}

	}

	/*
	 * 登录
	 */
	public String login(TbUser tbuser, HttpSession session) {
		System.out.println(tbuser.getUserName() + "," + tbuser.getUserPwd());
		if (tbuser.getUserName() == null || tbuser.getUserName().equals("")) {
			System.out.println("------------");
			return "用户名为空,请输入用户名!";
		} else if (tbuser.getUserPwd() == null || tbuser.getUserPwd().equals("")) {
			System.out.println("+++++++++++++");
			return "密码为空,请输入密码!";
		} else {

			TbUser tbu = tbuserMapper.selectUser(tbuser.getUserName(), tbuser.getUserPwd());
			if (tbu != null) {
				System.out.println(tbu.getId() + "________");
				session.setAttribute("user", tbu.getId());
				session.setAttribute("name", tbuser.getUserName());
				System.out.println(session.getAttribute("user") + "------++++++------");

				session.getAttribute("user");

				// TbUserinfo userinfo = new TbUserinfo();
				// Integer userid = (Integer) session.getAttribute("user");
				// userinfo.setUserId(userid);
				// int num = tbinfoMapper.insertSelective(userinfo);

				return "success";
			} else {
				return "error";
			}

		}
	}

	public Map<String, Object> getName(HttpSession session) {
		Map<String, Object> result = new HashMap<String, Object>();
		String name = (String) session.getAttribute("name");

		int userId = (Integer) session.getAttribute("user");
		if (name == null || name.equals("")) {
			result.put("state", 0);
		}
		if (userId == 0) {
			result.put("state", 0);
		} else {

			result.put("state", 1);
			result.put("userId", userId);
			result.put("name", name);
		}
		return result;
	}

	/*
	 * 退出登录
	 */
	public Map<String, Object> logout(HttpSession session) {
		Map<String, Object> result = new HashMap<String, Object>();
		session.removeAttribute("user");
		if (session.getAttribute("user") == null) {
			result.put("state", 1);
			result.put("data", "你已经成功退出登录");
		} else {
			result.put("state", 0);
			result.put("data", "退出失败，请重新退出");
		}
		return result;
	}

	/*
	 * 修改个人信息
	 */
	public Map<String, Object> updateUserInfo(TbUserinfo tbinfo, HttpSession session) {

		Map<String, Object> result = new HashMap<String, Object>();

		Integer userId = (Integer) session.getAttribute("user");
		tbinfo.setUserId(userId);
		System.out.println(tbinfo.getUserinfoTel() + "-------");
		if (tbinfo.getUserinfoName() == null || tbinfo.getUserinfoName().equals("")) {
			result.put("state", "姓名为空,请输入姓名!");

		}
		if (tbinfo.getUserinfoIdcard() == null || tbinfo.getUserinfoIdcard().equals("")) {
			result.put("state", "身份证号为空,请输入身份证号!");

		}
		if (tbinfo.getUserinfoTel() == null || tbinfo.getUserinfoTel().equals("")) {
			result.put("state", "电话号码为空,请输入电话号码!");

		} else {

			int a = tbinfoMapper.updateUserinfo(tbinfo);
			System.out.println(a + "22222");
			if (a > 0) {

				result.put("state", 1);
				result.put("data", "信息修改成功");

			} else {
				result.put("state", 0);
				result.put("data", "信息修改失败!");

			}
		}
		return result;
	}

	public List<TbPro> selectAllPro() {
		List<TbPro> list = proMapper.selectPro();
		return list;
	}

	public List<TbType> selectAllType() {
		List<TbType> list = typeMapper.selectType();
		return list;
	}

	public List<Object> selectProById(Integer id) {

		List<TbPro> tbpro = proMapper.selectByPrimaryKey(id);
		for (int i = 0; i < tbpro.size(); i++) {
			proId = tbpro.get(i).getId();
		}
		List<TbSize> tbsize = sizeMapper.selectPriceBy(proId);
		for (int i = 0; i < tbsize.size(); i++) {

			String a = tbsize.get(i).getSizePrice();
		}
		List<Object> list = new ArrayList<Object>();
		list.add(tbpro);
		list.add(tbsize);
		List<Object> list1 = new ArrayList<Object>();
		list1.add(list);
		return list1;
	}

	public List<Object> selectPtoByTypeId(Integer typeId) {
         List<Object> lists=new ArrayList<Object>();
         List<Object> list2=new ArrayList<Object>();
		List<TbPro> list = proMapper.selectProType(typeId);
		List<TbType> list1 = typeMapper.selectById(typeId);
		lists.add(list);
		lists.add(list1);
		list2.add(lists);
		return list2;
	}

	public List<TbSize> selectSize(Integer proId) {
		List<TbSize> list = sizeMapper.selectSize(proId);

		return list;
	}

	public List<TbAddress> selsteAddress(HttpSession session) {
		List<TbAddress> list = null;
		try {
			int userId = (Integer) session.getAttribute("user");
			System.out.println("userIduserIduserIduserIduserId" + userId);
			list = addressMapper.selectAddress(userId);
		} catch (Exception e) {
			System.out.println("1");
		}

		return list;
	}

	public Map<String, Object> insertOrder(TbOrder order, HttpSession session) {
		Map<String, Object> result = new HashMap<String, Object>();
		int userId = (Integer) session.getAttribute("user");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = df.format(new Date());
		Timestamp ts = Timestamp.valueOf(time);
		order.setOrderState(0);
		order.setOrderTime(ts);
		order.setProNum("1个");
		order.setUserId(userId);
		int a = orderMapper.insert(order);
		if (a > 0) {

			result.put("data", "支付成功");
		} else {

			result.put("data", "支付失败");
		}
		return result;
	}

	public List<Object> selectByUserId(HttpSession session) {

		int userId = (Integer) session.getAttribute("user");

		List<TbOrder> order = orderMapper.selectOrder(userId);
		List<Object> list = new ArrayList<Object>();
		for (int i = 0; i < order.size(); i++) {
			List<Object> lists = new ArrayList<Object>();
			// 查询商品
			int id = order.get(i).getProId();
			List<TbPro> pro = proMapper.selectByPrimaryKey(id);
			// 查询大小
			int sizeid = order.get(i).getSizeId();
			List<TbSize> size = sizeMapper.selectOneSize(sizeid);
			// 查询地址
			String addid = order.get(i).getAddressId();
			List<TbAddress> address = addressMapper.selectOneAddress(addid);
			lists.add(order.get(i));
			lists.add(pro);
			lists.add(size);
			lists.add(address);
			list.add(lists);
		}
		return list;
	}

	public Map<String, Object> updateState(TbOrder order) {
		Map<String, Object> result = new HashMap<String, Object>();
		int a = orderMapper.updateByUserId(order.getId());
		System.out.println(a);
		if (a >= 1) {
			result.put("data", "收货成功");
		} else {
			result.put("data", "收货失败");
		}
		return result;
	}

	public Map<String, Object> deleteOrder(TbOrder order) {

		Map<String, Object> result = new HashMap<String, Object>();
		TbOrder tbOrder = orderMapper.selectByPrimaryKey(order.getId());
		int state = tbOrder.getOrderState();
		if (state == 1) {
			int a = orderMapper.deleteByPrimaryKey(order.getId());

			if (a == 0) {
				result.put("state", 1);
				result.put("data", "删除成功");
			} else {
				result.put("state", 0);
				result.put("data", "数据异常");
			}
		} else if (state == 0) {
			result.put("a", state);
			result.put("data", "删除失败，请先确认收货");
		} else if (state == 3) {
			result.put("a", state);
			result.put("data", "删除失败，未发货");
		}

		return result;
	}

	public Map<String, Object> deleteAddress(TbAddress tbAddress) {
		Map<String, Object> result = new HashMap<String, Object>();
		int a = addressMapper.deleteByPrimaryKey(tbAddress.getId());
		System.out.println(a);
		if (a == 1) {
			result.put("state", 1);
			result.put("data", "删除成功");
		} else {

			result.put("state", 0);
			result.put("data", "删除失败");
		}
		return result;
	}

	public Map<String, Object> insertAddress(TbAddress tbAddress, HttpSession session) {
		Map<String, Object> result = new HashMap<String, Object>();
		int userId = (Integer) session.getAttribute("user");
		tbAddress.setUserId(userId);
		int a = addressMapper.insert(tbAddress);
		System.out.println(a);
		if (a == 1) {
			result.put("state", 1);
			result.put("data", "增加地址成功");
		} else {

			result.put("state", 0);
			result.put("data", "增加地址失败");
		}
		return result;
	}

	public Map<String, Object> selectPersonInfo(HttpSession session) {
		Map<String, Object> result = new HashMap<String, Object>();
		TbUserinfo userinfo = new TbUserinfo();
		int userId = (Integer) session.getAttribute("user");

		userinfo = tbinfoMapper.selectInfoByUserId(userId);

		result.put("data", userinfo);
		return result;
	}

	/*public Map<String, Object> selectTyprName(Integer typeId) {
		Map<String, Object> result = new HashMap<String, Object>();
		System.out.println(typeId + "aaaaa");
		TbType type = typeMapper.selectById(typeId);
		System.out.println(type + "sss");
		if (type.getTypeName() == null || type.getTypeName().equals("")) {

			result.put("data", "查不到此类型");
		} else {
			result.put("data", type);
		}
		return result;
	}*/

}
