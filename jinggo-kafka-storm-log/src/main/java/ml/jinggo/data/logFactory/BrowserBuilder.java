package ml.jinggo.data.logFactory;

import ml.jinggo.data.VO.BrowserLog;

/**
 * Browser建造类接口
 */
public interface BrowserBuilder {
    // 具体构造方法和实例
    public void buildType();

    public void buildHrefTag();

    public void buildHrefContent();

    public void buildReferrerUrl();

    public void buildRequestUrl();

    public void buildClickTime();

    public void buildAppName();

    public void buildAppVersion();

    public void buildLanguage();

    public void buildPlatform();

    public void buildScreen();

    public void buildCoordinate();

    public void buildSystemId();

    public void buildUserName();

    public void buildtimeStamp();
    // 将具体建造的事务实例化
    public BrowserLog retrieveResult();
}
