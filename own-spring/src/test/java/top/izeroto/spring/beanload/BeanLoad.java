package top.izeroto.spring.beanload;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import top.izeroto.spring.bean.AliasBean;
import top.izeroto.spring.bean.TestBean;

/**
 * bean加载获取探究
 */
public class BeanLoad {

    /**
     * beanFactory
     */
    @Test
    public void testBeanFactoryGetBean(){
        //beanFactory  注册bean
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        //beanDefinition 加载解析bean
        XmlBeanDefinitionReader beanReader = new XmlBeanDefinitionReader(factory);
		beanReader.setEventListener(new BeanRegisteredListener());
        //resource xmlbean资源
        ClassPathResource resource = new ClassPathResource("spring/spring-bean.xml");
        //加载bean
        int count = beanReader.loadBeanDefinitions(resource);
        System.out.println("注册bean个数"+count);
        TestBean bean = (TestBean) factory.getBean("testBean");
        Assert.assertEquals("testBean",bean.getName());
		AliasBean testAliasBean = (AliasBean) factory.getBean("testAliasBean");
		Assert.assertEquals("aliasBean",testAliasBean.getName());
		AliasBean aliasBean = (AliasBean) factory.getBean("aliasBean");
		Assert.assertEquals("aliasBean",aliasBean.getName());
		Assert.assertEquals(testAliasBean,aliasBean);
	}

	/**
	 * applicationContext
	 */
	@Test
	public void testApplicationContextGetBean(){
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-bean.xml");
		System.out.println("加载bean数："+context.getBeanDefinitionCount());
		TestBean bean = (TestBean) context.getBean("testBean");
		Assert.assertEquals("testBean",bean.getName());
    }
}
