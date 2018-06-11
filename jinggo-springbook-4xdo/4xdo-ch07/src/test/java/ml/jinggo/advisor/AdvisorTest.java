package ml.jinggo.advisor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

public class AdvisorTest {

	@Test
	public void advice() {
		String configPath = "advisor/beans.xml";
		ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
		Waiter waiter = (Waiter) ctx.getBean("waiter");
		Seller seller = (Seller) ctx.getBean("seller");
		waiter.greetTo("John");
		waiter.serveTo("jj");
		seller.greetTo("cc");
	}
}
