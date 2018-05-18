package ml.jinggo.data.logDirector;

import ml.jinggo.data.logFactory.RuleBuilder;

/**
 * 规则导演类，负责具体构造实例
 */
public class RuleDirector {
    // builder声明变量
    private RuleBuilder builder;
    // ruleDirector构造实例
    public RuleDirector(RuleBuilder builder) {
        this.builder = builder;
    }
    // 具体实例进行构造
    public void construct() {
        builder.buildisNormalIp();
        builder.buildisNormalDevice();
        builder.buildisNormalAddress();
        builder.buildisNormalMobile();
        builder.buildisChangeAccountPassword();
        builder.buildisChangePaymentPassword();
        builder.buildisChangeMobile();
        builder.buildisCashonDelivery();
        builder.buildorderproductNumByPrice();
        builder.buildorderproductNumByCategory();
        builder.buildorderAmount();
        builder.buildtimeStamp();
    }
}
