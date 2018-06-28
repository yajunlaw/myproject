package com.bjb.springboot.bootdemo.shiro;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShiroConfiguration {

	private static Logger logger = LogManager.getLogger(ShiroConfiguration.class);
	
	@Bean
	public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
		
		logger.info("shiro configuration initialized");
		
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		
		//必须设置SecurityManager
		shiroFilterFactoryBean.setSecurityManager(securityManager);
		
		//拦截器
		Map<String,String> filterChainDefinitionMap = new LinkedHashMap<String,String>();
		
		//登出
		filterChainDefinitionMap.put("/logout", "logout");
		
		//authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问
		filterChainDefinitionMap.put("/css/*", "anon");
		filterChainDefinitionMap.put("/js/*", "anon");
		filterChainDefinitionMap.put("/img/*", "anon");
		filterChainDefinitionMap.put("/images/*", "anon");
		filterChainDefinitionMap.put("/login", "anon");
		filterChainDefinitionMap.put("/**", "authc");
		
		//如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
		shiroFilterFactoryBean.setLoginUrl("/to_login");
		//登录成功以后访问的页面
		shiroFilterFactoryBean.setSuccessUrl("/index");
		//未授权页面
		shiroFilterFactoryBean.setUnauthorizedUrl("/403");
		
		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
		
		return shiroFilterFactoryBean;
	}
	
	@Bean
	public SecurityManager securityManager(MyRealm myRealm) {
		
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		securityManager.setRealm(myRealm);
		
		return securityManager;
	}
	
	//开启AOP注解支持
	@Bean
	public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
		
		AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
		authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
		
		return authorizationAttributeSourceAdvisor;
	}
	
	/**
     * DefaultAdvisorAutoProxyCreator，Spring的一个bean，由Advisor决定对哪些类的方法进行AOP代理。
     */
	@Bean
	public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
		
		DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
		
		defaultAdvisorAutoProxyCreator.setProxyTargetClass(true);
		
		return defaultAdvisorAutoProxyCreator;
	}
}
