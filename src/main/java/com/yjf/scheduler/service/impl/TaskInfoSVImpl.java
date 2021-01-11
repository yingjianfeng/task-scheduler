package com.yjf.scheduler.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yjf.scheduler.dao.TaskInfoDao;
import com.yjf.scheduler.pojo.TaskInfo;
import com.yjf.scheduler.service.ITaskInfoSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Title: TaskInfoSVImpl
 * Description: TODO
 *
 * @author yingjf
 * @date 2021/1/11 14:48
 */
@Service
public class TaskInfoSVImpl implements ITaskInfoSV {
    @Autowired
    TaskInfoDao taskInfoDao;


    @Override
    public void save(TaskInfo taskInfo) throws Exception {
        taskInfoDao.insert(taskInfo);
    }

    @Override
    public List qryAll() throws Exception {
        Wrapper wapper = new QueryWrapper();
        return taskInfoDao.selectList(wapper);
    }

    @Override
    public TaskInfo qryByTaskCode(int taskCode) throws Exception {
        QueryWrapper wapper = new QueryWrapper();
        wapper.eq("task_code",taskCode);
        return taskInfoDao.selectOne(wapper);
    }
}
