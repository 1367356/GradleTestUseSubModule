package com.li.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @RequestMapping("login")
    public String login() {
        return "login";
    }

    @RequestMapping("/print")
    public void print() {
        System.out.println("print");
    }


    @RequestMapping("/mv")
    public ModelAndView test(){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("mv");
        //设置返回的数据为json类型，也可以不设置，返回对象
        //mv.setView(new MappingJackson2JsonView());
        return mv;
    }


    /**
     * 响应到JSP页面page1
     */
    @RequestMapping("/page")
    public ModelAndView page1(){
        // 页面位置 /WEB-INF/jsp/page/page1.jsp
        //page/page1:页面路径地址/页面名称
        ModelAndView mav = new ModelAndView("page");
        mav.addObject("content", "hello");
        return mav;
    }
}
