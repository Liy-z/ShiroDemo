package cn.shiro.mapper;

import java.util.List;

import cn.shiro.extity.Role;

public interface RoleMapper {
	
	public List<Role> roleShow(Integer userId);

}
