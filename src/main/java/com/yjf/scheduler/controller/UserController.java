package com.yjf.scheduler.controller;

import com.yjf.scheduler.config.Log;
import com.yjf.scheduler.service.IJobService;
import com.yjf.scheduler.service.impl.JobServiceImpl;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * Title: UserController
 * Description: TODO
 *
 * @author yingjf
 * @date 2021/1/11 11:33
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/welcome")
    public String welcome(){

        return "welcome";
    }
    @Log("start")
    @GetMapping("/start/{taskCode}")
    public void start(@PathVariable String taskCode){
//        String taskCode = String.valueOf(System.currentTimeMillis());
        try {
            JobDetail jobDetail = JobBuilder.newJob(JobServiceImpl.class).withIdentity(taskCode).build();

            CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity(taskCode)
                    .withSchedule(CronScheduleBuilder.cronSchedule("*/5 * * * * ?")).build();
            StdSchedulerFactory stdSchedulerFactory = new StdSchedulerFactory();
            scheduler.start();
            scheduler.scheduleJob(jobDetail, cronTrigger);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Autowired
    private Scheduler scheduler;
    @Log("stop")
    @GetMapping("/stop/{taskCode}")
    public void stop(@PathVariable String taskCode){
        try {
            scheduler.deleteJob(JobKey.jobKey(taskCode));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




}
