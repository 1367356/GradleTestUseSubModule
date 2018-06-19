package com.li.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ExceptionHandlerController {
    @RequestMapping("/exceptionTest")
    @ResponseBody
    public String test() throws Exception{
        System.out.println("测试");
        int i=1/0;
        return Integer.toString(i);
    }
    @ControllerAdvice
    class HandlerException{
        @ExceptionHandler(Exception.class)
        @ResponseBody
        public String defultExcepitonHandler(Exception e) {
    //        return "{\"error\":\"error\"}";
            return "error";
        }
    }
}
