package com.yjf.scheduler.controller;

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


    @GetMapping("/test")
    public String test(){

        return "html/index";
    }

}
