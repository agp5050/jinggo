package ml.jinggo.data.logFactory;

import ml.jinggo.data.VO.PaymentInfo;

/**
 * 支付类实际接口
 */
public interface PaymentBuilder {
    // 具体建造方法
    public void buildOrderId();

    public void buildCreateOrderTime();

    public void buildPaymentId();

    public void buildPaymentTime();

    public void buildProductId();

    public void buildProductName();

    public void buildProductPrice();

    public void buildPromotionPrice();

    public void buildShopId();

    public void buildShopName();

    public void buildShopMobilePhone();

    public void buildNum();

    public void buildtimeStamp();
    // 将具体建造的事务实例化
    public PaymentInfo retrieveResult();
}
