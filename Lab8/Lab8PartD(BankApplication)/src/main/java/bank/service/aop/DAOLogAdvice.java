package bank.service.aop;

import bank.logging.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StopWatch;
@Aspect
@Configuration

public class DAOLogAdvice {

    private Logger logger;
    @Before("execution(* bank.dao.*.*(..))")
    public void logDAOCall (JoinPoint joinPoint) {
        System.out.println("Call of every method "+ joinPoint.getSignature().getName());
    }

}
