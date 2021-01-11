package com.yjf.scheduler.service;

import com.yjf.scheduler.pojo.TaskParam;

import java.util.List;

/**
 * Title: ITaskParamSV
 * Description: TODO
 *
 * @author yingjf
 * @date 2021/1/11 17:17
 */
public interface ITaskParamSV {

    public List<TaskParam> qryByTaskCode(int taskCode)throws Exception;

}
