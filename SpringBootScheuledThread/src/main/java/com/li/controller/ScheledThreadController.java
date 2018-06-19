package com.li.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-06-16 09:01
 * 调度线程控制器，定时执行
 **/
@Controller
public class ScheledThreadController {
    ScheduledExecutorService scheduledExecutorService=new ScheduledThreadPoolExecutor(2);  //指定线程个数

    @RequestMapping("/start")
    @ResponseBody
    public void start() {

            scheduledExecutorService.scheduleAtFixedRate(new Runnable() {  //以固定频率执行,线程1
                @Override
                public void run() {
                    System.out.println(Thread.currentThread()+"开启了"+System.currentTimeMillis());
                }
            }, 10,10,TimeUnit.SECONDS);


            scheduledExecutorService.scheduleAtFixedRate(new Runnable() {  //以固定频率执行，线程2
                @Override
                public void run() {
                    System.out.println(Thread.currentThread()+"开启了"+System.currentTimeMillis());
                }
            }, 10,10,TimeUnit.SECONDS);
    }

    @RequestMapping("/stop")
    @ResponseBody
    public String stop() {
        scheduledExecutorService.shutdown();

        boolean shutdown = scheduledExecutorService.isShutdown();
        if (shutdown) {
            return "关闭成功";
        }
        return "关闭失败";
    }
}
