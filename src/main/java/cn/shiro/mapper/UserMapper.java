package cn.shiro.mapper;

import java.util.List;

import cn.shiro.extity.Role;
import cn.shiro.extity.User;
import cn.shiro.extity.User_role;

public interface UserMapper {
	//查询用户
	public List<User> userShow();
	public User userLogin(String name);
	//查询角色
	public List<Role> roleShow();
	//添加用户与和角色关联表
	public int addUserRole(User_role ur);
	
	public int addUser(User user);

}
