package com.yjf.scheduler.controller;

import com.yjf.scheduler.pojo.TaskInfo;
import com.yjf.scheduler.service.ITaskInfoSV;
import com.yjf.scheduler.service.ITaskParamSV;
import com.yjf.scheduler.service.impl.JobServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.quartz.impl.StdScheduler;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Title: TaskController
 * Description: TODO
 *
 * @author yingjf
 * @date 2021/1/11 15:37
 */
@RestController
@RequestMapping("/task")
@Slf4j
public class TaskController {
    @Autowired
    ITaskInfoSV iTaskInfoSV;

    @Autowired
    ITaskParamSV iTaskParamSV;
    @Autowired
    private Scheduler scheduler;

    @GetMapping("/showList")
    public List showList() throws Exception{
        List list = iTaskInfoSV.qryAll();
        log.info("========="+list);
        return list;
    }
    @GetMapping("/start/{taskCode}")
    public void start(@PathVariable String taskCode)throws Exception{
        try {
            TaskInfo info = iTaskInfoSV.qryByTaskCode(Integer.parseInt(taskCode));
            Object object =Class.forName(info.getProcess_class()).newInstance();
            Job job = (Job)object;
            JobDetail jobDetail = JobBuilder.newJob(job.getClass()).withIdentity(taskCode).withDescription(info.getTask_desc()).build();

            CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity(taskCode)
                    .withSchedule(CronScheduleBuilder.cronSchedule(info.getCron())).build();
            StdSchedulerFactory stdSchedulerFactory = new StdSchedulerFactory();
            scheduler.start();
            scheduler.scheduleJob(jobDetail, cronTrigger);
            iTaskInfoSV.updateTaskState(Integer.parseInt(taskCode),"正在执行");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @GetMapping("/stop/{taskCode}")
    public void stop(@PathVariable String taskCode){
        try {
            scheduler.deleteJob(JobKey.jobKey(taskCode));
            iTaskInfoSV.updateTaskState(Integer.parseInt(taskCode),"未执行");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @GetMapping("/get")
    public List get() throws Exception{
        StdScheduler std =  (StdScheduler)scheduler;
        List<JobExecutionContext> currentlyExecutingJobs = std.getCurrentlyExecutingJobs();
        return currentlyExecutingJobs;
    }

    @GetMapping("/getParams/{taskCode}")
    public List get(@PathVariable String taskCode) throws Exception{
        return iTaskParamSV.qryByTaskCode(Integer.parseInt(taskCode));
    }

}
