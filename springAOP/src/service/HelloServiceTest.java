package service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("test-applicationContext.xml")
public class HelloServiceTest {
	@Autowired
	ApplicationContext ctx;
	@Test
	public void test(){
		
		ProxyFactoryBean pfbean = new ProxyFactoryBean();
		pfbean.setTarget(new HelloServiceImpl());
		pfbean.addAdvisor((Advisor) ctx.getBean("uppercaseAdvisor"));
		
		HelloService helloServiceimpl = (HelloService) pfbean.getObject();
		
		assertThat(helloServiceimpl.sayHello("Toby"), is("HELLO TOBY"));
		assertThat(helloServiceimpl.sayHi("Toby"), is("HI TOBY"));
		assertThat(helloServiceimpl.sayThankYou("Toby"), is("Thank You Toby"));
	}
}
