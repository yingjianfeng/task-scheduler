package com.yjf.scheduler.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * Title: taskParam
 * Description: TODO
 *
 * @author yingjf
 * @date 2021/1/11 14:44
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName("task_param")
public class TaskParam {
    int task_code;
    String param_name;
    String param_value;
    String param_desc;
    String ramark;
}
