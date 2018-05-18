package ml.jinggo.data.logDirector;

import ml.jinggo.data.logFactory.BrowserBuilder;
/**
 * BrowserDirector导演类，指定什么类型数据生产。
 */
public class BrowserDirector {
    // 内部构造
    private BrowserBuilder builder;
    // 构造类并实例化
    public BrowserDirector(BrowserBuilder builder) {
        this.builder = builder;
    }
    // 具体构造的实际类
    public void consturct() {
        builder.buildType();
        builder.buildHrefTag();
        builder.buildHrefContent();
        builder.buildReferrerUrl();
        builder.buildRequestUrl();
        builder.buildClickTime();
        builder.buildAppName();
        builder.buildAppVersion();
        builder.buildLanguage();
        builder.buildPlatform();
        builder.buildScreen();
        builder.buildCoordinate();
        builder.buildSystemId();
        builder.buildUserName();
        builder.buildtimeStamp();
    }
}
