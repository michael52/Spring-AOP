package pl.examples.service.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;


/**
 * Created by toustym on 22.10.2017.
 */

//@Aspect
@Component
public class TimeLoggerAspect {

    @Around("execution(* pl.examples.service.BookRepository.*(..))")
    public Object masureExecTime(ProceedingJoinPoint pjp) throws Throwable {
        Instant before = Instant.now();
        //@Before
        try {
            Object result = pjp.proceed();
            //@After
            return result;
            //@AfterThrowing, gdyby nie bylo thorws
        } finally {
            //@AfterReturning
            Instant after = Instant.now();
            Duration execTime = Duration.between(before, after);
            System.out.printf("%s execution took %d ms\n", pjp.toShortString(), execTime.toMillis());
        }
    }
}
