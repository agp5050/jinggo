package ml.jinggo.data.logDirector;


import ml.jinggo.data.logFactory.PaymentBuilder;

/**
 * Payment导演类，负责构建具体类
 */
public class PaymentDirector {
    // builder类的声明
    private PaymentBuilder builder;
    // 构造的初始化
    public PaymentDirector(PaymentBuilder builder) {
        this.builder = builder;
    }
    // 具体构造实例
    public void construct() {
        builder.buildOrderId();
        builder.buildCreateOrderTime();
        builder.buildPaymentId();
        builder.buildPaymentTime();
        builder.buildProductId();
        builder.buildProductName();
        builder.buildProductPrice();
        builder.buildPromotionPrice();
        builder.buildShopId();
        builder.buildShopName();
        builder.buildShopMobilePhone();
        builder.buildNum();
        builder.buildtimeStamp();
    }
}
