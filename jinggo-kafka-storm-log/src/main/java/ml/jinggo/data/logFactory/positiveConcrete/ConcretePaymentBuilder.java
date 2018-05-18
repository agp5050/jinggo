package ml.jinggo.data.logFactory.positiveConcrete;

import ml.jinggo.data.VO.PaymentInfo;
import ml.jinggo.data.logFactory.PaymentBuilder;
import ml.jinggo.data.utils.*;

import java.util.Random;
import java.util.UUID;


public class ConcretePaymentBuilder implements PaymentBuilder {
    private PaymentInfo info = new PaymentInfo();


    private String[] productName = {"Nike背包", "Adidas运动衫", "李宁运动鞋 ", "Kappa外套", "361腰包", "大数据视频课程", "大数啫喱水"}; //商品名称
    private double[] productweight = {7.0, 15.0, 28.0, 60.0, 28.0, 15.0};

    private String[] productPrice = {"100", "200", "500", "350", "1200", "50"}; //商品价格100 200 500 350 1200 50
    private double[] priceweight = {40.0, 20.0, 7.0, 6.0, 10.0, 30.0};

    private String[] promotionPrice = {"80", "100", "200", "125", "750", "30"}; //促销价格80 100 200 125 750 30
    private double[] promotionweight = {6.0, 15.0, 18.0, 30.0, 25.0, 40.0};

    private String shopId = ShopIDBuilder.run(); //商品编号

    private String[] shopName = {"圣达威服饰", "丽诗服饰", "晓风书屋", "老知青", "启明星影像", "澳林体育", "黄则和"}; //商铺名称
    private double[] shopweight = {12.0, 18.0, 22.0, 80.0, 18.0, 15.0, 13.0};

    private String[] shopMobilePhone = {"158****1305", "138****4689", "159****6488", "150****6399", "150****8847"}; //商铺手机号
    private double[] phoneweight = {30.0, 40.0, 18.0, 35.0, 24.0};

    private static final String num = new Random().nextInt() + ""; //订单数量

    public void buildOrderId() {
        info.setOrderId(UUID.randomUUID().toString());
    }

    public void buildCreateOrderTime() {
        info.setCreateOrderTime(RandomDate.run());
    }

    public void buildPaymentId() {
        info.setPaymentId(PaymentIdBuilder.run());
    }

    public void buildPaymentTime() {
        info.setPaymentTime(RandomDate.run());
    }

    public void buildProductId() {
        info.setProductId(OrderIdBuilder.run());
    }

    public void buildProductName() {
        info.setProductName(productName[RandomWeight.run(productweight)]);
    }

    public void buildProductPrice() {
        info.setProductPrice(productPrice[RandomWeight.run(priceweight)]);
    }

    public void buildPromotionPrice() {
        info.setPromotionPrice(promotionPrice[RandomWeight.run(promotionweight)]);
    }

    public void buildShopId() {
        info.setShopId(shopId);
    }

    public void buildShopName() {
        info.setShopName(shopName[RandomWeight.run(shopweight)]);
    }

    public void buildShopMobilePhone() {
        info.setShopMobilePhone(shopMobilePhone[RandomWeight.run(phoneweight)]);
    }

    public void buildNum() {
        info.setNum(num);
    }

    @Override
    public void buildtimeStamp() {
        info.setTimeStamp(DateUtil.timeToLong());
    }

    public PaymentInfo retrieveResult() {
        return this.info;
    }

}
