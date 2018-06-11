package ml.jinggo.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.testng.Assert.*;

/**
 * Created by gz12 on 2018-06-06.
 */
public class MailSenderTest {
    public static void main(String[] args) {
        String resourceFile = "event/beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(resourceFile);
        MailSender mailSender = ctx.getBean(MailSender.class);
        mailSender.sendMail("jinggo@sohu.com");
        System.out.println("done.");
    }
}