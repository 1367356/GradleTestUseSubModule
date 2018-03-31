package com.li.controller;

import com.li.pojo.Order;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class LoginController {

    @RequestMapping("/login")
    public String login() {
        return "login";
    }
    @RequestMapping("/test2")
    public String test2() {
        return "index";
    }
    @RequestMapping("/public")
    public String test3() {
        return "/public/public.html";
    }
    @RequestMapping("/orderTest")
    @ResponseBody
    public List order(String orderNo,String sortFiled) {

        System.out.println(orderNo+"  "+sortFiled);
        List list=new ArrayList();
        Order order=new Order();
        order.setHotelName("name");
        order.setHotelSeq("123");
        list.add(order);
        return list;
    }


}
