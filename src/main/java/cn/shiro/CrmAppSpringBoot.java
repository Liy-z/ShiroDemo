package cn.shiro;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "cn.shiro.*")
public class CrmAppSpringBoot{

	/**
	 * Start
	 */
	public static void main(String[] args) {
		SpringApplication.run(CrmAppSpringBoot.class, args);
	}

}
