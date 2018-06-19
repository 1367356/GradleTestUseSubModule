package com.li.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {

    @RequestMapping("/home1")
    public String home1(Model model) {

        Parameter parameter=new Parameter();
        parameter.setId("111111");
        parameter.setName("liyafei");
        model.addAttribute("response", parameter);

        return "home";
    }
}
