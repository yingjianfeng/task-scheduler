package com.yjf.scheduler.task;

import com.yjf.scheduler.service.impl.AbstractJob;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * Title: NewTask
 * Description: TODO
 *
 * @author yingjf
 * @date 2021/1/11 17:24
 */
@Slf4j
public class NewTask extends AbstractJob {
    public Map map = null;
    @Override
    protected void init(Map param) throws Exception {
        this.map = param;
    }

    @Override
    protected void execute() throws Exception {
        log.info(""+map);
    }
}
