package com.yjf.scheduler.config;

import com.yjf.scheduler.pojo.TaskLog;
import com.yjf.scheduler.service.ITaskLogSV;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;

/**
 * Title: LogConfig
 * Description: TODO
 *
 * @author yingjf
 * @date 2021/1/20 16:41
 */
@Aspect
@Component
public class LogConfig  {

    @Autowired
    ITaskLogSV iTaskLogSV;

    /**
     * 定义切入点，切入点为com.example.aop下的所有函数
     */
    @Pointcut("execution(public * com.yjf.scheduler.controller.*.*(..))")
    public void log(){}

    /**
     * 前置通知：在连接点之前执行的通知
     * @param joinPoint
     * @throws Throwable
     */
    @Before("log()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 记录下请求内容
//        logger.info("URL : " + request.getRequestURL().toString());
//        logger.info("HTTP_METHOD : " + request.getMethod());
//        logger.info("IP : " + request.getRemoteAddr());
//        logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
//        logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));


        Log annotation = null;
        MethodSignature sign = (MethodSignature) joinPoint.getSignature();
        Method method = sign.getMethod();
        //获取方法上的注解
        annotation = method.getAnnotation(Log.class);
            if(annotation!=null){
                String opt_name = annotation.value();
                String ip = request.getRemoteAddr();
                Date opt_date = new Date();
                String machine = request.getHeader("user-agent");
                TaskLog taskLog = new TaskLog();
                taskLog.setOpt_name(opt_name);
                taskLog.setIp(ip);
                taskLog.setOpt_date(opt_date);
                taskLog.setMachine(machine);
                iTaskLogSV.save(taskLog);
//                System.out.println("有注解:"+annotation.value()+request.getRemoteAddr());
            }else {
                System.out.println("无注解");
            }

    }

    @AfterReturning(returning = "ret",pointcut = "log()")
    public void doAfterReturning(Object ret) throws Throwable {

    }
//    public String getScheme(HttpServletRequest request){
//        UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));
//        Browser browser = userAgent.getBrowser();
//        OperatingSystem operatingSystem = userAgent.getOperatingSystem();
//        Version browserVersion = userAgent.getBrowserVersion();
//        log.info(browser.getName());
//        log.info(operatingSystem.getName());
//        log.info(browserVersion.getVersion());
//    }
}
