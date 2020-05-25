package cn.shiro.crmm;


import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import cn.shiro.extity.Resources;
import cn.shiro.extity.Role;
import cn.shiro.extity.User;
import cn.shiro.service.ResourcesService;
import cn.shiro.service.RoleService;
import cn.shiro.service.UserService;

public class MyShiroRealm extends AuthorizingRealm{
	@Autowired
	private UserService us;
	@Autowired
	private ResourcesService rs;
	@Autowired
	private RoleService roleService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		// TODO Auto-generated method stub
		//获取登录用户
		Integer userId = (Integer) SecurityUtils.getSubject().getSession().getAttribute("userSessionId");
		System.out.println("======================"+userId);
		//根据用户名去数据库查询用户信息
		List<Resources> res=  rs.showResources(userId);
		System.out.println("====================="+res);
		List<Role> r = roleService.roleShow(userId);
		//User user = us.userLogin(name);
		//添加角色和权限
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		for(Role role : r) {
			//添加角色
			simpleAuthorizationInfo.addRole(role.getRoleKey());
			System.out.println("==========="+role.getRoleKey());
			
		}
		System.out.println("qwe");
		for(Resources resources : res) {
			//添加角色
			simpleAuthorizationInfo.addStringPermission(resources.getResKey());
			System.out.println("aaa==="+resources.getResKey());
		}
		return simpleAuthorizationInfo;
	}

	@SuppressWarnings("unused")
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
		// TODO Auto-generated method stub
		//加这一步的目的是在Post请求的时候会先认证，然后在到请求
		if(authenticationToken.getPrincipal() == null) {
			return null;
		}
		//获取用户信息
		String name = authenticationToken.getPrincipal().toString();
		
		User user = us.userLogin(name);
		
		String pwd = user.getPassword();
		System.out.println("============="+pwd+"==="+user.getCredentialsSalt());
		if(user == null) {
			//这里返回后会报出对应异常
			return null;
		} else {
			//这里验证authenticationToken和simpleAuthenticationInfo的信息
			SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(
					name,pwd,
					ByteSource.Util.bytes(name + "" + user.getCredentialsSalt()),// salt=username+salt
					getName()
			);
			// 当验证都通过后，把用户信息放在session里
			Session session = SecurityUtils.getSubject().getSession();
			session.setAttribute("userSession", user);
			session.setAttribute("userSessionId", user.getId());
			return simpleAuthenticationInfo;
		}
	}

}
