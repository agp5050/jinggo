package ml.jinggo

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import tk.jingzing.api.CurrencyRateService
import tk.jingzing.dao.CurrencyRateRepository
import tk.jingzing.service.CurrencyRateServiceImpl

/**
  * Created by gz12 on 2018-06-22.
  */
@SpringBootApplication
class ScalaRateApplication {

  @Bean
  def rateRepository: CurrencyRateRepository = {
    val dao = new CurrencyRateRepository
    dao
  }

  @Bean
  def rateService: CurrencyRateService = {
    val service: CurrencyRateServiceImpl = new CurrencyRateServiceImpl
    service.setRateRepository(rateRepository)
    service
  }
}

object ScalaRateApplication{
  def main(args: Array[String]): Unit = {
    SpringApplication.run(classOf[ScalaRateApplication],args: _*)
  }
}
