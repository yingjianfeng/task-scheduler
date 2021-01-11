package com.yjf.scheduler.service.impl;

import com.yjf.scheduler.pojo.TaskParam;
import com.yjf.scheduler.service.ITaskInfoSV;
import com.yjf.scheduler.service.ITaskParamSV;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Title: AbstractJob
 * Description: TODO
 *
 * @author yingjf
 * @date 2021/1/11 17:01
 */
public abstract class AbstractJob extends JobServiceImpl {

    @Autowired
    ITaskParamSV iTaskParamSV;

    protected abstract void init(Map param) throws Exception;

    protected abstract void execute() throws Exception;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        JobDataMap map = jobExecutionContext.getJobDetail().getJobDataMap();
        Map param = new HashMap();

        try {
            String taskCode = (String) map.get("task_code");
            List<TaskParam> taskParams = iTaskParamSV.qryByTaskCode(Integer.parseInt(jobExecutionContext.getTrigger().getKey().getName()));
            for (TaskParam taskParam:taskParams){
                param.put(taskParam.getParam_name(),taskParam.getParam_value());
            }
            // 查询数据库;
            init(param);
            execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
