package cn.shiro.filter;

import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import groovy.util.logging.Slf4j;

@ControllerAdvice
@Slf4j
public class MyErrorHandler {
	@ExceptionHandler
	@ResponseBody
	public String ErrorHandler(AuthorizationException e) {
		return "没有通过权限验证";
	}

}
