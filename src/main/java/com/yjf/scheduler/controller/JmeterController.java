package com.yjf.scheduler.controller;

import com.yjf.scheduler.config.Log;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Title: JmeterController
 * Description: TODO
 *
 * @author yingjf
 * @date 2021/1/13 17:38
 */
@RestController
public class JmeterController {
    int i = 0;
    @GetMapping("/jmeter")
    @Log("jmeter")
    public String jmeter(){
        i++;
        return "jmeter---->"+i;
    }
    @Log("test")
    @GetMapping("/test")
    public String test(){
        i++;
        return "test---->"+i;
    }
}
