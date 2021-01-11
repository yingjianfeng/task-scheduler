package com.yjf.scheduler.service.impl;

import com.yjf.scheduler.service.IJobService;
import org.quartz.*;
import org.springframework.stereotype.Component;

/**
 * Title: JobServiceImpl
 * Description: TODO
 *
 * @author yingjf
 * @date 2021/1/11 11:53
 */
@PersistJobDataAfterExecution
@DisallowConcurrentExecution
@Component
public  class JobServiceImpl implements IJobService , Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        JobDataMap jobDataMap = jobExecutionContext.getMergedJobDataMap();
    }



}
