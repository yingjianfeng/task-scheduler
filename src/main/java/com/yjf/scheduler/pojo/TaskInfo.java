package com.yjf.scheduler.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * Title: taskInfo
 * Description: TODO
 *
 * @author yingjf
 * @date 2021/1/11 14:40
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName("task_info")
public class TaskInfo {
    @TableId
    int task_code;
    String task_name;
    String task_desc;
    String version;
    String cron;
    String process_class;
    @JsonFormat(pattern = "yyyy-MM-dd")
    Date create_time;
    String remark;
    String state;
}
