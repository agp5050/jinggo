package ml.jinggo.web

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.{RequestMapping, RequestMethod, RestController}
import tk.jingzing.api.CurrencyRateService
import tk.jingzing.api.WebApiResponse
import tk.jingzing.service.CurrencyPair
import tk.jingzing.service.ExchangeRate

/**
  * Created by gz12 on 2018-06-22.
  */
@RestController
class ScalaRateController {
  @Autowired
  var rateService: CurrencyRateService = _

  @RequestMapping(value = Array("/"), method = Array(RequestMethod.GET))
  def quote(symbol: String) : WebApiResponse[ExchangeRate] = {
    val response: WebApiResponse[ExchangeRate] = new WebApiResponse[ExchangeRate]
    response.setCode(WebApiResponse.SUCCESS_CODE)
    response.setData(rateService.quote(CurrencyPair.from(symbol)))

    response
  }
}
