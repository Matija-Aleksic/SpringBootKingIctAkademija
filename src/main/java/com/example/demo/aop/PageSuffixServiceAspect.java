package com.example.demo.aop;

import com.example.demo.service.PageSuffixService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PageSuffixServiceAspect {
    Logger logger= LoggerFactory.getLogger(PageSuffixServiceAspect.class);
    @Before("execution(* com.example.demo.service.PageSuffixService.getSuffix(..))")
    public void beforePageServiceGetDashboard(JoinPoint joinpoint){
        logger.error("before pageSuffixService service got dashboard" + joinpoint.getTarget().getClass().getName());

    }
    @AfterReturning(
            pointcut = "execution(* com.example.demo.service.PageSuffixService.getSuffix(..))",
            returning = "result"
    )
    public void afterPageServiceGetDashboard(JoinPoint joinpoint,String result){
        String PageSuf;
        logger.error("before pageSuffixService service got dashboard" + result );

    }
}
