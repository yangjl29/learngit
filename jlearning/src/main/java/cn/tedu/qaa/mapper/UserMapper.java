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
	User selectByUsername(String username);  //查询用户名
	
	
	
	/**
	 * 根据id查找user
	 * @param id
	 * @return
	 */
	User selectUserById(Integer id);    //查询用户名id
	
	
	/**
	 * 通过邮箱查询
	 * @param email
	 * @return：如果存在，那么返回行数；
	 * 			如果不存在，返回0；
	 */
	Integer selectByEmail(String email);    //查询email
}
