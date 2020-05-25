package cn.shiro.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.shiro.extity.Resources;
import cn.shiro.mapper.ResourcesMapper;
import cn.shiro.service.ResourcesService;
@Service
public class ResourcesServiceImpl implements ResourcesService{
	@Autowired
	private ResourcesMapper rm;

	@Override
	public List<Resources> showResources(Integer userId) {
		// TODO Auto-generated method stub
		List<Resources> list = rm.showResources(userId);
		return list;
	}

}
