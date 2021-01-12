package com.yjf.scheduler.service;

import com.yjf.scheduler.pojo.TaskInfo;

import java.util.List;

/**
 * Title: ITaskInfoSV
 * Description: TODO
 *
 * @author yingjf
 * @date 2021/1/11 14:48
 */
public interface ITaskInfoSV {
    public void save(TaskInfo taskInfo)throws Exception;

    public List qryAll()throws Exception;

    public TaskInfo qryByTaskCode(int taskCode)throws Exception;

    public void updateTaskState(int taskCode,String state)throws Exception;
}
