package cn.shiro.service;

import java.util.List;

import cn.shiro.extity.Role;
import cn.shiro.extity.User;
import cn.shiro.extity.User_role;

public interface UserService {
	//查询用户
	public List<User> userShow();
	public User userLogin(String name);
	//查询角色
	public List<Role> roleShow();
	//添加用户与和角色关联表
	public boolean addUserRole(User_role ur);
	
	public boolean addUser(User user);
	
}
