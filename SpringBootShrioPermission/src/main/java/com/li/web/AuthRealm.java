package com.li.web;
import com.li.dao.pojo.Module;
import com.li.dao.pojo.Role;
import com.li.dao.pojo.User;
import com.li.service.impl.UserServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class AuthRealm extends AuthorizingRealm {

    Logger logger = LogManager.getLogger(AuthRealm.class);
    @Autowired
    private UserServiceImpl userService;
    JedisPoolUtil jpu=new JedisPoolUtil();
    private Jedis jedis=jpu.getJedis();

    //认证.登录
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken utoken=(UsernamePasswordToken) token;//获取用户输入的token
        String username = utoken.getUsername();

        User user;
        byte[] byt=jedis.get(username.getBytes());
        Object obj=null;
        if (byt!=null && byt.length != 0) {
            obj=new Serialize().unserizlize(byt);
        }
        if(obj!=null && obj instanceof User){
//            return (User)obj;
            logger.debug("走redis");
            user=(User)obj;
        }else {
            user = userService.findUserByName(username);  //使用mybatis从数据库中得到用户
            if(user!=null){
                logger.debug("走mybatis");
                jedis.set(username.getBytes(), new Serialize().serialize(user));
            }
        }
//        logger.warn(username);
//        //User user = userService.findUserByName(username);  //使用mybatis从数据库中得到用户，也可以通过redis存放用户名和密码。
//        logger.warn(user.getUsername());

        return new SimpleAuthenticationInfo(user, user.getPassword(),this.getClass().getName());//放入shiro.调用CredentialsMatcher检验密码
    }
    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        User user=(User) principal.fromRealm(this.getClass().getName()).iterator().next();//获取session中的用户
        List<String> permissions=new ArrayList<>();
        Set<Role> roles = user.getRoles();
        if(roles.size()>0) {
            for(Role role : roles) {
                Set<Module> modules = role.getModules();
                if(modules.size()>0) {
                    for(Module module : modules) {
                        permissions.add(module.getMname());
                    }
                }
            }
        }
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
        info.addStringPermissions(permissions);//将权限放入shiro中.
        return info;
    }

}