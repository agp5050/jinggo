package ml.jinggo.event;

import org.springframework.context.ApplicationListener;

/**
 * @author wangyj
 * @description
 * @create 2018-06-06 9:01
 **/
public class MailSendListener implements ApplicationListener<MailSendEvent> {
    @Override
    public void onApplicationEvent(MailSendEvent event) {
        MailSendEvent mse = (MailSendEvent) event;
        System.out.println("MailSendListener:向" + mse.getTo() + "发送完一封邮件");
    }
}
