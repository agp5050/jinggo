package ml.jinggo.event;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author wangyj
 * @description
 * @create 2018-06-06 9:06
 **/
public class MailSender implements ApplicationContextAware {

    private ApplicationContext ctx ;

    @Override
    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        this.ctx = ctx;
    }

    public void sendMail(String to){
        System.out.println("MailSender:模拟发送邮件...");
        MailSendEvent mse = new MailSendEvent(this.ctx,to);
        ctx.publishEvent(mse);
    }
}
