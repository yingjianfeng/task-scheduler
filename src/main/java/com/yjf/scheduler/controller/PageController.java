package com.yjf.scheduler.controller;

import com.yjf.scheduler.config.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Title: PageController
 * Description: TODO
 *
 * @author yingjf
 * @date 2021/1/11 16:01
 */
@RequestMapping("/html")
@Controller
@Slf4j
public class PageController {

    @Log("html/index")
    @GetMapping("/test")
    public String test(){

        return "html/index";
    }
    @Log("html/webSocket")
    @GetMapping("/socket")
    public String socket(){

        return "html/webSocket";
    }

}
