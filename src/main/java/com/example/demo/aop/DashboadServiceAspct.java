package com.example.demo.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DashboadServiceAspct {
    Logger logger= LoggerFactory.getLogger(DashboadServiceAspct.class);
    @Before("execution(* com.example.demo.service.DashboardService.getDashboard(..))")
    public void beforeDashboardServiceGetDashboard(JoinPoint joinpoint){
        logger.error("before dashboad service got dashboard" + joinpoint.getTarget().getClass().getName());
    }
}
