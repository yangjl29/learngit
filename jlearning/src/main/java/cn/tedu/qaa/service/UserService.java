package cn.tedu.qaa.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.qaa.bean.User;
import cn.tedu.qaa.mapper.UserMapper;
import cn.tedu.qaa.service.ex.PasswordNotMatchException;
import cn.tedu.qaa.service.ex.UserNotFoundException;
@Service
public class UserService implements IUserService {

	@Resource 
	private UserMapper userMapper; //持久层的对象
	
	
	
	@Override
	public void addUser(User user) {
		userMapper.insertUser(user);
	}

	
	
	@Override
	public User login(String username, String password){
		
		User user = userMapper.selectByUsername(username);
		
		if(user == null){
			throw new UserNotFoundException("账号不存在");
		}
		else{
			if(user.getPassword().equals(password)){
				return user;
			}
			else{
				throw new PasswordNotMatchException("密码错误");
			}
		}
	}

	
	
	@Override
	public User selectById(Integer id) {
		
		return userMapper.selectUserById(id);
	}



	@Override
	public boolean checkUsername(String username) {
	
		return userMapper.selectByUsername(username)!=null;
	}

	
	
}
