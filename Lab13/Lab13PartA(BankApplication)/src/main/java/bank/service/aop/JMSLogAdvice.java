package bank.service.aop;

import bank.logging.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StopWatch;

@Aspect
@Configuration
public class JMSLogAdvice {
private Logger logger;
    @After("execution(* bank.jms.JMSSenderImpl.sendJMSMessage(..))&& args(message)")
    public void logDAOCall (String message) {
        System.out.println("Message logged: "+ message);
    }
}
