package com.yjf.scheduler.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yjf.scheduler.dao.TaskParamDao;
import com.yjf.scheduler.pojo.TaskParam;
import com.yjf.scheduler.service.ITaskParamSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Title: TaskParamSVImpl
 * Description: TODO
 *
 * @author yingjf
 * @date 2021/1/11 17:17
 */
@Service
public class TaskParamSVImpl implements ITaskParamSV {

    @Autowired
    TaskParamDao iTaskParamSV;


    @Override
    public List<TaskParam> qryByTaskCode(int taskCode) throws Exception {
        QueryWrapper wapper = new QueryWrapper();
        wapper.eq("task_code",taskCode);
        return iTaskParamSV.selectList(wapper);
    }
}
