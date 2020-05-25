package cn.shiro.service;

import java.util.List;

import cn.shiro.extity.Role;

public interface RoleService {
	
	public List<Role> roleShow(Integer userId);
}
