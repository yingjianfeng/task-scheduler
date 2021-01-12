package com.yjf.scheduler.task;

import com.yjf.scheduler.service.impl.AbstractJob;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * Title: SayHelloTask
 * Description: TODO
 *
 * @author yingjf
 * @date 2021/1/12 10:55
 */
@Slf4j
public class SayHelloTask extends AbstractJob {
    @Override
    protected void init(Map param) throws Exception {

    }

    @Override
    protected void execute() throws Exception {
        log.info("hello");
    }
}
