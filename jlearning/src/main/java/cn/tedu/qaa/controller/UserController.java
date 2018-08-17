package cn.tedu.qaa.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpRequest;
import org.springframework.remoting.httpinvoker.HttpInvokerServiceExporter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.qaa.bean.ResponseResult;
import cn.tedu.qaa.bean.User;
import cn.tedu.qaa.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController{

	@Resource
	private IUserService userService;
	//显示注册页面
	@RequestMapping("/showRegister.do")
	public String showRegister(){
		return "register";
	}
	
	
	
	
	//显示登录页面
	@RequestMapping("/showLogin.do")
	public String showLogin(){
		return "login";
	}
	   
   
	//异步提交注册
	@RequestMapping("/register.do")
	@ResponseBody
	public ResponseResult<Void> register(
			@RequestParam("username") String username,
			@RequestParam("password") String password,
			@RequestParam("email") String email){
		 ResponseResult<Void> rr = null;
		 try{
			 User user = new User();
			 user.setUsername(username);
			 user.setPassword(password);
			 user.setEmail(email);
			 userService.addUser(user);    
			 
			 rr = new ResponseResult<Void>(1,"添加成功！");
		 }catch(RuntimeException e){
			 rr = new ResponseResult<Void>(0,e.getMessage());
		 }
		return rr;
		
	}
    
	
	//异步提交登录
	@RequestMapping("/login.do")
	@ResponseBody
	public ResponseResult<Void> login(String username,String password,HttpSession session){
		ResponseResult<Void> rr = null;
		try {
			User user = userService.login(username, password);
			rr = new ResponseResult<Void>(1,"登录成功");
			
			session.setAttribute("user", user);
		} catch (RuntimeException e) {
			rr = new ResponseResult<Void>(0,e.getMessage());
		}
		return rr;
	}
	
	
	
	
	
	//实现异步验证，用户名是否存在
	@RequestMapping("/checkUsername.do")
	@ResponseBody
	public ResponseResult<Void> checkUsername(
			@RequestParam("username") String username){
		//1.声明ResponseResult<Void>对象
		ResponseResult<Void> rr = null;
		//2.调用业务层方法
		boolean b = 
		userService.checkUsername(username);
		//3.如果b为true；定义状态码 ： 0
		//   和状态信息:用户名不可以使用
		if(b){
			rr = new ResponseResult<Void>(0,"用户名不可以使用");
				
		}else{
		//4.如果b为false；定义状态码 ：1
		//   和状态信息:用户名可以使用
			rr = new ResponseResult<Void>(1,"用户名可以使用");
				
		}
		return rr;
	}
	
	
	//验证邮箱的异步请求方法
	@RequestMapping("checkEmail.do")
	@ResponseBody
	public ResponseResult<Void> checkEmail(
			String email){
		ResponseResult<Void> rr = null; 
		if(userService.checkEmail(email)){
			rr=new ResponseResult<Void>(0,"邮箱不能使用");   
		}else{
			rr=new ResponseResult<Void>(1,"邮箱可以使用");   
		}
		return rr;     
	}
	
	//退出的功能
	@RequestMapping("/exit.do")
	public String exit(HttpSession session){
		session.invalidate();
		return "redirect:../questions/showQuestions.do";
	}
}










