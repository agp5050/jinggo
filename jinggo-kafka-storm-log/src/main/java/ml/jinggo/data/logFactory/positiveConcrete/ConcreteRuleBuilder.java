package ml.jinggo.data.logFactory.positiveConcrete;

import ml.jinggo.data.VO.RuleInfo;
import ml.jinggo.data.logFactory.RuleBuilder;
import ml.jinggo.data.utils.DateUtil;
import ml.jinggo.data.utils.RandomWeight;

import java.util.Random;
/**
 * Rule实例建造类
 */
public class ConcreteRuleBuilder implements RuleBuilder {
    // RuleInfo实际构造类
    private RuleInfo info = new RuleInfo();

    private final String[] isNormalIp = {"1", "0"}; //用户是否在常用ip下单
    private final double[] ipWeight = {4.0, 6.0}; //建造生产权重

    private final String[] isNormalDevice = {"1", "0"}; //用户是否在常用设备上下单
    private final double[] deviceWeight = {6.0, 4.0};

    private final String[] isNormalAddress = {"1", "0"}; //用户收货地址是否是常用收货地址
    private final double[] addressWeight = {6.0, 4.0};

    private final String[] isNormalMobile = {"1", "0"}; //用户收获手机号是否是常用手机号
    private final double[] mobileWeight = {7.0, 3.0};

    private final String[] isChangeAccountPassword = {"1", "0"}; //用户近期是否修改过登录密码
    private final double[] accountPasswordWeight = {6.5, 3.5};

    private final String[] isChangePaymentPassword = {"1", "0"}; //用户近期是否修改过支付密码
    private final double[] paymentPassword = {6.0, 4.0};

    private final String[] isChangeMobile = {"1", "0"}; //用户近期是否修改过手机号码
    private final double[] changemobileWeight = {7.0, 3.0};

    private final String[] isCashonDelivery = {"1", "0"}; //订单是否是到货付款
    private final double[] cashonDeliveryWeight = {6.8, 3.2};

    private final String[] orderproductNumByPrice = {"1", "0"}; //订单中指定价格的商品数量是否满足阈值
    private final double[] priceWeight = {5.0, 5.0};

    private final String[] orderproductNumByCategory = {"1", "0"}; //订单中指定类目的商品价格是否满足阈值
    private final double[] categoryWeight = {6.6, 3.4};
    // 具体建造实例
    public void buildisNormalIp() {
        info.setIsNormalIp(isNormalIp[RandomWeight.run(ipWeight)]);
    }

    public void buildisNormalDevice() {
        info.setIsNormalDevice(isNormalDevice[RandomWeight.run(deviceWeight)]);
    }

    public void buildisNormalAddress() {
        info.setIsNormalAddress(isNormalAddress[RandomWeight.run(addressWeight)]);
    }

    public void buildisNormalMobile() {
        info.setIsNormalMobile(isNormalMobile[RandomWeight.run(mobileWeight)]);
    }

    public void buildisChangeAccountPassword() {
        info.setIsChangeAccountPassword(isChangeAccountPassword[RandomWeight.run(accountPasswordWeight)]);
    }

    public void buildisChangePaymentPassword() {
        info.setIsChangePaymentPassword(isChangePaymentPassword[RandomWeight.run(paymentPassword)]);
    }

    public void buildisChangeMobile() {
        info.setIsChangeMobile(isChangeMobile[RandomWeight.run(changemobileWeight)]);
    }

    public void buildisCashonDelivery() {
        info.setIsCashonDelivery(isCashonDelivery[RandomWeight.run(cashonDeliveryWeight)]);
    }

    public void buildorderproductNumByPrice() {
        info.setOrderproductNumByPrice(orderproductNumByPrice[RandomWeight.run(priceWeight)]);
    }

    public void buildorderproductNumByCategory() {
        info.setOrderproductNumByCategory(orderproductNumByCategory[RandomWeight.run(categoryWeight)]);
    }

    public void buildorderAmount() {
        info.setOrderAmount(1000 + new Random().nextInt(9000) + "");
    }

    @Override
    public void buildtimeStamp() {
        info.setTimeStamp(DateUtil.timeToLong());
    }

    public RuleInfo retrieveResult() {
        return this.info;
    }
}
