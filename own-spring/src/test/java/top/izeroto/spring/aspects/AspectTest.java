package top.izeroto.spring.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class AspectTest {

	@Pointcut("execution(* top.izeroto.spring.bean.*.toString(..))")
	public void pointCut(){

	}

	@Before("pointCut()")
	public void beforeMethod(){
		System.out.println("before");
	}

	@After("pointCut()")
	public void afterMethod() {
		System.out.println("after");
	}


	@Around("pointCut()")
	public Object aroundMethod(ProceedingJoinPoint point){
		System.out.println("around before");
		Object object = null;
		try {
			object = point.proceed();
		} catch (Throwable throwable) {
			throwable.printStackTrace();
		}
		System.out.println("around after");
		return object;
	}
}
