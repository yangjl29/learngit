package cn.tedu.qaa.service;

import cn.tedu.qaa.bean.User;

public interface IUserService {

	/**
	 * 添加用户信息
	 * @param user
	 */
	void addUser(User user);
	  
	
	
	User login(String username,String password);
	
	
	User selectById(Integer id);
	
	
	/**
	 * 验证用户是否存在
	 * @param username
	 * @return  如果存在，返回true；
	 * 			如果不存在，返回false
	 */
	boolean checkUsername(String username);
	
}
