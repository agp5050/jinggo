package ml.jinggo.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ApplicationContextEvent;

/**
 * @author wangyj
 * @description
 * @create 2018-06-05 18:41
 **/
public class MailSendEvent extends ApplicationContextEvent {

    private String to;

    public MailSendEvent(ApplicationContext source, String to) {
        super(source);
        this.to = to;
    }

    public String getTo() {

        return this.to;
    }
}
