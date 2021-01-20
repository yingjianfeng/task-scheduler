package com.yjf.scheduler.service.impl;

import com.yjf.scheduler.dao.TaskLogDao;
import com.yjf.scheduler.pojo.TaskLog;
import com.yjf.scheduler.service.ITaskLogSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Title: TaskLogSVImpl
 * Description: TODO
 *
 * @author yingjf
 * @date 2021/1/20 16:39
 */
@Service
public class TaskLogSVImpl implements ITaskLogSV {
    @Autowired
    TaskLogDao taskLogDao;
    @Override
    public void save(TaskLog taskLog) throws Exception {
        taskLogDao.insert(taskLog);
    }
}
