package com.yjf.scheduler;

import com.yjf.scheduler.pojo.TaskInfo;
import com.yjf.scheduler.service.ITaskInfoSV;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class SchedulerApplicationTests {

    @Autowired
    ITaskInfoSV iTaskInfoSV;
    @Test
    void svae() throws Exception{
        TaskInfo taskInfo = new TaskInfo();
        taskInfo.setTask_name("a");
        taskInfo.setCreate_time(new Date());
        iTaskInfoSV.save(taskInfo);
    }

}
