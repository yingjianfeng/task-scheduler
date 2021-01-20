package com.yjf.scheduler.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Title: Log
 * Description: TODO
 *
 * @author yingjf
 * @date 2021/1/20 16:51
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface Log {
    String value();
}
