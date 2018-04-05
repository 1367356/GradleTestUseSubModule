package com.li.controller;

import com.li.dao.pojo.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    Logger logger= LogManager.getLogger(LoginController.class);
    @RequestMapping("/loginTest")
    public String login() {
        return "login.html";
    }

    @RequestMapping("/login")
    public String loginhtml() {
        return "/visitor/login.html";
    }

    @RequestMapping(value = "/loginUser")
    public String loginUser(String username,String password,HttpSession session) {
        UsernamePasswordToken usernamePasswordToken=new UsernamePasswordToken(username,password);
        Subject subject = SecurityUtils.getSubject();
        try {

            logger.info(username);
            logger.warn(usernamePasswordToken);

            //在调用了login方法后,SecurityManager会收到AuthenticationToken,并将其发送给已配置的Realm执行必须的认证检查
            //每个Realm都能在必要时对提交的AuthenticationTokens作出反应
            //所以这一步在调用login(token)方法时,它会走到MyRealm.doGetAuthenticationInfo()方法中,具体验证方式详见此方法

            subject.login(usernamePasswordToken);   //完成登录，重点将会调用shrio去验证
            logger.warn("success");
            User user=(User) subject.getPrincipal();

            session.setAttribute("user", user);
            return "/user/index.html";  //首页
        } catch(Exception e) {
            return "/visitor/login.html";//返回登录页面
        }
    }
    @RequestMapping("/logOut")
    public String logOut(HttpSession session) {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
//        session.removeAttribute("user");
        return "login";
    }
}