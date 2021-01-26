package dev.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

// 1. L'aspect doit être un bean Spring
@Component
@Aspect
public class LogAspect {

//    @Pointcut("ddd")
//    public void point1() {
//
//    }


    @Before("execution(public * dev.dao.IPlatDao.listerPlats())")
//    @After
//    @AfterReturning
//    @AfterThrowing
//    @Around
    public void logDao(JoinPoint pj) {
        System.out.println("-----> Avant listerPlats()");
    }

    @Around("execution(public * dev.dao.IPlatDao.listerPlats())")
    public Object perf(ProceedingJoinPoint pjp) throws Throwable {

        long start = System.currentTimeMillis();
        // begin
        Object resultat = pjp.proceed();// invocation de IPlatDao.listerPlats()
        // commit
        long end = System.currentTimeMillis();

        System.out.println("PERF IPlatDao.listerPlats() : " + (end - start) + " ms");
        return resultat;
    }


}
