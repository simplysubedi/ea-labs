package customers;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StopWatch;

@Aspect
@Configuration
public class TimerAdvice {

@Around("execution(* customers.CustomerDAO.*(..))")
    public Object profile (ProceedingJoinPoint call ) throws Throwable {
        StopWatch clock = new StopWatch();
        clock.start(call.getSignature().getName());
        Object retVal = call.proceed();
        clock.stop();
// print the time to the console
    System.out.println("Time taken to call save() method from DAO object is: "+clock.prettyPrint());
        return retVal;
}}
