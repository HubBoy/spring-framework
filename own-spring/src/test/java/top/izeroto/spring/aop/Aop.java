package top.izeroto.spring.aop;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.izeroto.spring.bean.TestBean;

public class Aop {

	@Test
	public void aopTest(){
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-aop.xml");
		TestBean testbean = (TestBean)context.getBean("testBean");
		testbean.toString();
	}

}
