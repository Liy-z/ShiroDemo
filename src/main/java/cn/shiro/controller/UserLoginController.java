package cn.shiro.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.shiro.extity.User;
@Controller
public class UserLoginController {
	
	//@ResponseBody
	@RequestMapping("/userlogin")
	public String userlogin(User user) {
		//添加用户认证信息
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(
				user.getAccountName(),
				user.getPassword()
		);
		System.out.println("============="+user+user.getAccountName()+"=="+user.getPassword());
		try {
			//进行验证，这里可以捕获异常，然后返回对应信息
			subject.login(usernamePasswordToken);
			System.out.println("==========成功！");
			
		} catch (AuthenticationException e) {
			e.printStackTrace();
			return "账号或密码错误！";
		} catch (AuthorizationException e) {
			e.printStackTrace();
			return "没有权限";
		}
		return "redirect:/userShow";
	}

	//注解验证角色和权限
	@ResponseBody
	@RequiresRoles("admin")
	@RequiresPermissions("add")
	@RequestMapping("/index")
	public String index() {
		
		return "index!";
	}
}
