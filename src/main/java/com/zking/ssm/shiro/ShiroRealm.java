package com.zking.ssm.shiro;

import com.zking.ssm.model.SysUser;
import com.zking.ssm.service.ISysUserMapper;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;


public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private ISysUserMapper is;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取账号
        String username = principalCollection.getPrimaryPrincipal().toString();

        //根据账号获取角色
        Set<String> roles = is.findRoles(username);
        //根据账号获取权限
        Set<String> permissions = is.findPermissions(username);

        SimpleAuthorizationInfo au=new SimpleAuthorizationInfo();
        au.setRoles(roles);
        au.setStringPermissions(permissions);


        return au;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String s = authenticationToken.getPrincipal().toString();
        String s1 = authenticationToken.getCredentials().toString();

        SysUser loinguser = is.Loinguser(s);
            if(loinguser==null){
                throw  new UnknownAccountException("账号不存在");
            }
        SimpleAuthenticationInfo c=new SimpleAuthenticationInfo(
                loinguser.getUsername(),
                loinguser.getPassword(),
                ByteSource.Util.bytes(loinguser.getSalt()),
                this.getName()
        );

        return c;
    }
}
