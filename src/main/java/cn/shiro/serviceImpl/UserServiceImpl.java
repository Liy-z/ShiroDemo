package cn.shiro.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.shiro.extity.Role;
import cn.shiro.extity.User;
import cn.shiro.extity.User_role;
import cn.shiro.mapper.UserMapper;
import cn.shiro.service.UserService;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public List<User> userShow() {
		// TODO Auto-generated method stub
		List<User> list = userMapper.userShow();
		return list;
	}

	@Override
	public User userLogin(String name) {
		// TODO Auto-generated method stub
	
		return this.userMapper.userLogin(name);
	}

	@Override
	public List<Role> roleShow() {
		// TODO Auto-generated method stub
		List<Role> list = this.userMapper.roleShow();
		return list;
	}


	@Override
	public boolean addUser(User user) {
		// TODO Auto-generated method stub

		boolean result = false;
		try {
			if(userMapper.addUser(user) == 1){
				result = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}
		return result;
	}




	@Override
	public boolean addUserRole(User_role ur) {
		// TODO Auto-generated method stub
		boolean result = false;
		try {
			if(userMapper.addUserRole(ur) == 1){
				result = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	


	




	

}
