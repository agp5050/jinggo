package ml.jinggo.data.logFactory;

import ml.jinggo.data.VO.RuleInfo;

/**
 * 规则建造接口
 */
public interface RuleBuilder {
    // 具体建造类
    public void buildisNormalIp();

    public void buildisNormalDevice();

    public void buildisNormalAddress();

    public void buildisNormalMobile();

    public void buildisChangeAccountPassword();

    public void buildisChangePaymentPassword();

    public void buildisChangeMobile();

    public void buildisCashonDelivery();

    public void buildorderproductNumByPrice();

    public void buildorderproductNumByCategory();

    public void buildorderAmount();

    public void buildtimeStamp();
    // 将具体建造的事务实例化
    public RuleInfo retrieveResult();
}
