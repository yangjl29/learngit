package cn.tedu.qaa.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.qaa.bean.ResponseResult;
import cn.tedu.qaa.bean.User;
import cn.tedu.qaa.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Resource
	private IUserService userService;
	
	@RequestMapping("/showLogin.do")
	public String showLogin(){
		return "login";
	}
	
	@RequestMapping("/login.do")
	@ResponseBody
	public ResponseResult<Void> login(String username,String password,HttpSession session){
		ResponseResult<Void> rr = null;
		try {
			User user = userService.login(username, password);
			rr = new ResponseResult<>(1,"登录成功");
			
			session.setAttribute("user", user);
		} catch (Exception e) {
			rr = new ResponseResult<>(0,"登录失败");
		}
		return rr;
	}
}
