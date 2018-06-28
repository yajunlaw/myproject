package com.bjb.springboot.bootdemo.shiro;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bjb.springboot.bootdemo.pojo.Permission;
import com.bjb.springboot.bootdemo.pojo.Role;
import com.bjb.springboot.bootdemo.pojo.User;
import com.bjb.springboot.bootdemo.service.PermissionService;
import com.bjb.springboot.bootdemo.service.RoleService;
import com.bjb.springboot.bootdemo.service.UserService;

@Component
public class MyRealm extends AuthorizingRealm {

	private static Logger logger = LogManager.getLogger(MyRealm.class);
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private PermissionService permissionService;
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		logger.debug("##################执行Shiro权限认证##################");
        User user = (User) principalCollection.getPrimaryPrincipal();
        if(user!=null){
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            Role role = roleService.selectRoleByUser(user.getUsername());
            List<Permission> permissions = permissionService.selectPermissionsByRole(role.getrId());
            for (Permission p : permissions){
                info.addStringPermission(p.getpName());
            }
            info.addRole(role.getrName());
            return info;
        }
        return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        logger.info("用户验证执行 : "+token.getUsername());
        User user = userService.selectUserByPass(token.getUsername(), new String(token.getPassword()));
        if(user==null){
            logger.error("用户 { "+token.getUsername()+" } 不存在 ");
        }
        if(user.getStatus()==0){
            logger.error("用户 { "+token.getUsername()+" } 被禁止登录 ");
        }else{
            //System.out.println("效验更新前ROLE："+user.getR_id());
        }
        return new SimpleAuthenticationInfo(user,user.getPassword(),getName());
	}
}
