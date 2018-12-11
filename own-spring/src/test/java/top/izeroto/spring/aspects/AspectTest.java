package top.izeroto.spring.aspects;

import org.aspectj.lang.annotation.*;

@Aspect
public class AspectTest {

	@Pointcut("execution(* *.getName(...))")
	public void pointCut(){

	}

	@Before("top.izeroto.spring.bean.TestBean.getName()")
	public void beforeMethod(){
		System.out.println("before");
	}

	@After("top.izeroto.spring.bean.TestBean.getName()")
	public void afterMethod() {
		System.out.println("after");
	}


	@Around("top.izeroto.spring.bean.TestBean.getName()")
	public void aroundMethod(){
		System.out.println("around");
	}
}
