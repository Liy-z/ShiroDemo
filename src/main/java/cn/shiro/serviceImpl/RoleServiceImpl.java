package cn.shiro.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.shiro.extity.Role;
import cn.shiro.mapper.RoleMapper;
import cn.shiro.service.RoleService;
@Service
public class RoleServiceImpl implements RoleService{
	@Autowired
	private RoleMapper rm;

	@Override
	public List<Role> roleShow(Integer userId) {
		// TODO Auto-generated method stub
		List<Role> list = rm.roleShow(userId);
		return list;
	}

}
