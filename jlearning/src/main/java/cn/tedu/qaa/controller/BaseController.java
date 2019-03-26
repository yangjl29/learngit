package cn.tedu.qaa.controller;

import javax.servlet.http.HttpSession;

import cn.tedu.qaa.bean.User;

public class BaseController {

	//获取当前用户的id
	public Integer getId(HttpSession session){
		
		Integer id = null;
		User user = (User)session.getAttribute("user");
		
		if(user!=null){
			id = user.getId();
		}
		
		return id;
	}
}
