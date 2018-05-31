package ml.jinggo.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//将一个POJO标注为定义bean的配置类
@Configuration
public class AppConf {
	@Bean
	public UserDao userDao(){
	   return new UserDao();	
	}
	
	@Bean
	public LogDao logDao(){
		return new LogDao();
	}
	
	@Bean
	public LogonService logonService(){
		LogonService logonService = new LogonService();
		logonService.setLogDao(logDao());
		logonService.setUserDao(userDao());
		return logonService;
	}
}
