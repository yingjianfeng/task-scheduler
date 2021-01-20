package com.yjf.scheduler.service;

import com.yjf.scheduler.pojo.TaskLog;

/**
 * Title: ITaskLogSV
 * Description: TODO
 *
 * @author yingjf
 * @date 2021/1/20 16:40
 */
public interface ITaskLogSV {
    public void save(TaskLog taskLog) throws Exception;

}
