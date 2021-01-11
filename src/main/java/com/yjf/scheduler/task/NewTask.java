package com.yjf.scheduler.task;

import com.yjf.scheduler.service.impl.AbstractJob;

import java.util.Map;

/**
 * Title: NewTask
 * Description: TODO
 *
 * @author yingjf
 * @date 2021/1/11 17:24
 */
public class NewTask extends AbstractJob {
    public Map map = null;
    @Override
    protected void init(Map param) throws Exception {
        this.map = param;
    }

    @Override
    protected void execute() throws Exception {
        System.out.println(map);
    }
}
