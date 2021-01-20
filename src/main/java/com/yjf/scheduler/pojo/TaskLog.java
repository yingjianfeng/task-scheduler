package com.yjf.scheduler.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * Title: TaskLog
 * Description: TODO
 *
 * @author yingjf
 * @date 2021/1/20 16:36
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName("task_log")
public class TaskLog {
    @TableId
    int id;
    int user_id;
    String ip;
    String opt_name;
    Date opt_date;
    String machine;
    String remarks;
}
