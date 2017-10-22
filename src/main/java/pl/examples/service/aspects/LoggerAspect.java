package pl.examples.service.aspects;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created by toustym on 09.10.2017.
 */
//@Aspect
@Component
public class LoggerAspect  {

    @Before("execution(* pl.examples.service.BookRepository.*(..))")
    public void logInfoBefore() {
        System.out.println("Log before ");
    }

    @After("execution(* pl.examples.service.BookRepository.*(..))")
    public void logInfoAfter() {
        System.out.println("Method executed ");
    }

    @AfterThrowing("execution(* pl.examples.service.BookRepository.*(..))")
    public void logError(){
        System.out.println("Method finished with error ");
    }

    @AfterReturning("execution(* pl.examples.service.BookRepository.*(..))")
    public void logSuccess() {
        System.out.println("Method successfully returned");
    }
}
