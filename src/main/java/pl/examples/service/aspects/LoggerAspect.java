package pl.examples.service.aspects;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import pl.examples.model.Book;

/**
 * Created by toustym on 09.10.2017.
 */
@Aspect
@Component
public class LoggerAspect {

	//@Before("execution(* pl.examples.service.BookRepository.*(..))")
	@Before("pl.examples.service.aspects.AspectUtil.allBookRepositoryMethods()")
	public void logInfoBefore(JoinPoint joinPoint) {
		Object[] args = joinPoint.getArgs();
		System.out.printf("Log before %s with args %s \n", joinPoint.getSignature(), Arrays.toString(args));
	}

	//@After("execution(* pl.examples.service.BookRepository.*(..))")
	@After("pl.examples.service.aspects.AspectUtil.allBookRepositoryMethods()")
	public void logInfoAfter() {
		System.out.println("Method executed ");
	}

	/*@AfterThrowing(
			pointcut = "execution(* pl.examples.service.BookRepository.*(..))",
			throwing = "error")*/
	//@AfterThrowing("pl.examples.service.aspects.AspectUtil.allBookRepositoryMethods()")
	@AfterThrowing(
			pointcut = "pl.examples.service.aspects.AspectUtil.allBookRepositoryMethods()",
			throwing = "error")
	public void logError(JoinPoint joinPoint, Throwable error) {
		System.out.printf("Method %s finished with error %s", joinPoint.getSignature(), error.getMessage());
	}

	@AfterReturning(pointcut = "execution(* pl.examples.service.BookRepository.get(..)) && args(isbn)",
			returning = "result")
	public void logSuccess(String isbn, Book result) {
		if(result != null){
			System.out.printf("Method get() successfully returned value %s for isbn %s \n", result, isbn);
		}
	}
}
