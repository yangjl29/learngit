package cn.tedu.qaa.mapper;

import cn.tedu.qaa.bean.User;

public interface UserMapper {
	/**
	 * 插入用户信息
	 * @param user
	 */
	void insertUser(User user);
	
	
	/**
	 * 根据username查找user
	 * @param username
	 * @return
	 */
	User selectByUsername(String username);
	
	
	
	/**
	 * 根据id查找user
	 * @param id
	 * @return
	 */
	User selectUserById(Integer id);
}
