package cn.shiro.controller;


import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.shiro.extity.Role;
import cn.shiro.extity.User;
import cn.shiro.extity.User_role;
import cn.shiro.service.UserService;
import cn.shiro.util.PasswordHelper;

@Controller
public class UserController {
	@Autowired
	private UserService us;
	
	@RequestMapping("/roleShow")
	public String roleShow(Model model) {
		List<Role> list = us.roleShow();
		model.addAttribute("list", list);
		return "add";
	}
	
	@RequiresPermissions("add")
	@RequestMapping("/userShow")
	public String userShow(Model model) {
		List<User> list = us.userShow();
		model.addAttribute("list", list);
		return "index";
	}
	
	@RequestMapping("/addUser")
	public String addUser(User user,int roleId,User_role ur) {
		PasswordHelper ph = new PasswordHelper();
		ph.encryptPassword(user);
		System.out.println("====================="+user+"=="+user.getAccountName());
		
		//ur.setRoleId();
		if(us.addUser(user)) {
			User user1 = us.userLogin(user.getAccountName());
			ur = new User_role();
			ur.setUserId(user1.getId());
			ur.setRoleId(roleId);
			System.out.println("======="+ur);
			if(us.addUserRole(ur)) {
				return "login";
			}
			
		}
		
		return "asd";
	}

}
