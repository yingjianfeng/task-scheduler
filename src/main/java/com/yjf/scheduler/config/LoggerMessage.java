package com.yjf.scheduler.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * Title: LoggerMessage
 * Description: TODO
 *
 * @author yingjf
 * @date 2021/1/12 15:07
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
public class LoggerMessage implements Serializable {
    private String body;
    private String timestamp;
    private String threadName;
    private String className;
    private String level;
    private String exception;
    private String cause;
}
