package com.bahu.buffzs.config;


import com.bahu.buffzs.pojo.BuffAdminRole;
import com.bahu.buffzs.pojo.BuffAdminUser;
import com.bahu.buffzs.service.AdminUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author： Mr.Baron
 * @date： 2019/10/30
 * @description：
 */
@Slf4j
public class UserRealm extends AuthorizingRealm {
    @Autowired
    private AdminUserService adminUserService;

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authtoken) throws AuthenticationException {

        UsernamePasswordToken token = (UsernamePasswordToken) authtoken;
        BuffAdminUser user = adminUserService.findUserByName(token.getUsername());
        if (user == null) {
            log.info("user","账号不存在");
            throw new UnknownAccountException("账号不存在！");
        }
        //获取用户输入密码
        String oringnPassword = new String((char[]) token.getCredentials());
        /*String salt = user.getSalt();
        logger.info("用户名："+token.getUsername()+"===="+"密码"+oringnPassword);
        //将用户输入的密码加密
        String encodedPassword =  new SimpleHash("MD5",oringnPassword,salt,3).toString();
        */
        //比对用户输入密码与数据库密码
        if (!oringnPassword.equals(user.getPassword())) {
            log.info("oringnPassword","密码错误");
            throw new AccountException("密码错误！");
        }
        //自定义的认证信息  在登录时也要提供
        return new SimpleAuthenticationInfo(user.getUsername(), oringnPassword, getName());
        //return new SimpleAuthenticationInfo(user.getUsername(),"",getName());
        //return new SimpleAuthenticationInfo(user.getName(),oringnPassword,ByteSource.Util.bytes(salt),getName());
    }

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        //登录用户名
        String name = (String) principals.getPrimaryPrincipal();
        BuffAdminUser user = adminUserService.findUserByName(name);
        //角色信息导入shiro
        List<BuffAdminRole> roles = adminUserService.getRoleByUserId(user.getId());
        Set<String> roleNames = roles.stream().map(BuffAdminRole::getRole).collect(Collectors.toSet());
        simpleAuthorizationInfo.setRoles(roleNames);
        // logger.info("当前用户角色 ："+roleNames);
//        //权限信息导入shiro
//        List<ShiroPermission> permissions = userService.getPermissionByUserId(user.getId());
//        Set<String> permissionNames = permissions.stream().map(ShiroPermission::getName).collect(Collectors.toSet());
//        simpleAuthorizationInfo.setStringPermissions(permissionNames);
//        logger.info("当前用户权限 ："+permissionNames);
        return simpleAuthorizationInfo;
    }
}
