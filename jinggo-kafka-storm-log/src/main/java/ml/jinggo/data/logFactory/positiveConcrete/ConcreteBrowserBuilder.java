package ml.jinggo.data.logFactory.positiveConcrete;

import ml.jinggo.data.VO.BrowserLog;
import ml.jinggo.data.logFactory.BrowserBuilder;
import ml.jinggo.data.utils.DateUtil;
import ml.jinggo.data.utils.RandomUserName;
import ml.jinggo.data.utils.RandomWeight;

import java.util.UUID;
/**
 * Browser具体实例建造类
 */
public class ConcreteBrowserBuilder implements BrowserBuilder {
    // BrowserLog 类实例化
    private BrowserLog log = new BrowserLog();
    // 日志点击类型
    private String[] type = {"1", "2", "3", "4"}; //1.浏览日志 2.点击日志3.搜索日志4.购买日志
    private double[] typeweight = {8.0, 20.0, 10.0, 7.0};// 权重

    private String[] hrefTag = {"<a>", "<div>", "<frame>", "<span>", "<ul>"};  //标签标识<a> <div> <frame> <span> <ul>
    private double[] flagweight = {5.0, 10.0, 6.0, 8.0, 22.0};

    private String[] hrefContent = {"www.baidu.com", "www.google.com", "www.tanzhouedu.com", "www.qq.com", "www.itstar.vip", "#top", "#t1"};  //标签对应的标识，主要针对a标签后的内容
    private double[] contentweight = {7.0, 12.0, 15.0, 22.0, 6.0, 8.0, 10.0};

    private String[] referrerUrl = {"www.baidu.com", "www.google.com", "www.tanzhouedu.com", "www.qq.com", "www.itstar.vip", "#top", "#t1"}; //来源网址
    private double[] referweight = {9.0, 3.0, 17.0, 10.0, 40.0, 10.0, 2.0};

    private String[] requestUrl = {"www.baidu.com", "www.google.com", "www.tanzhouedu.com", "www.qq.com", "www.itstar.vip", "#top", "#t1"}; //来源网址
    private double[] requestweight = {4.0, 5.5, 1.0, 12.0, 3.0, 6.0, 17.0};

    private String[] clickTime = {"24-03", "07-09", "11-14", "15-20", "20-23"};  //点击时间
    private double[] clickweight = {16.0, 17.0, 15.0, 10.0, 3.0};

    private String[] appName = {"IE", "FF", "Opera", "Safari", "Chrome"};  //浏览器类型
    private double[] nameweight = {4.0, 18.0, 13.0, 16.0, 15.0};

    private String[] appVersion = {"1.0", "2.0", "3.0", "4.5", "7.0", "8.0"}; //浏览器版本
    private double[] versionweight = {1.0, 2.0, 2.0, 40.0, 20.0, 20.0};

    private String[] language = {"简体中文", "繁體中文", "English", "French", "German", "Japanese", "Korean", "Spanish", "Swedish"}; //浏览器语言
    private double[] langweight = {11.0, 12.0, 20.0, 13.0, 3.0, 10.0, 4.0, 1.0, 3.0};

    private String[] platform = {"linux", "mac", "windows", "os/2", "solaris", "sunos", "mpe/ix", "hp-ux", "aix", "freebsd"};  //操作系统
    private double[] platweight = {70.0, 12.0, 40.0, 15.0, 15.0, 20.0, 20.0, 15.0, 12.0, 30.0};

    private String[] screen = {"1366*768", "1024*768", "1280*960", "1280*1024", "1440*900", "1920*1080"};  //屏幕尺寸
    private double[] screenweight = {80.0, 20.0, 13.0, 25.0, 20.0, 7.0};

    private String[] coordinate = {"200*200", "400*200", "350*350", ""};  //点击鼠标时的坐标
    private double[] coorweight = {30.0, 35.0, 25.0, 10.0};

    private String systemId = UUID.randomUUID().toString();  //产生点击流的系统编号
    private String[] userName = {RandomUserName.run(), "wangwe0726"};  //用户名称
    private double[] unameweight = {9.0, 1.0};

    public void buildType() {
        log.setType(type[RandomWeight.run(typeweight)]);
    }

    public void buildHrefTag() {
        log.setHrefTag(hrefTag[RandomWeight.run(flagweight)]);
    }

    public void buildHrefContent() {
        log.setHrefContent(hrefContent[RandomWeight.run(contentweight)]);
    }

    public void buildReferrerUrl() {
        log.setReferrerUrl(referrerUrl[RandomWeight.run(referweight)]);
    }

    public void buildRequestUrl() {
        log.setRequestUrl(requestUrl[RandomWeight.run(requestweight)]);
    }

    public void buildClickTime() {
        log.setClickTime(clickTime[RandomWeight.run(clickweight)]);
    }

    public void buildAppName() {
        log.setAppName(appName[RandomWeight.run(nameweight)]);
    }

    public void buildAppVersion() {
        log.setAppVersion(appVersion[RandomWeight.run(versionweight)]);
    }

    public void buildLanguage() {
        log.setLanguage(language[RandomWeight.run(langweight)]);
    }

    public void buildPlatform() {
        log.setPlatform(platform[RandomWeight.run(platweight)]);
    }

    public void buildScreen() {
        log.setScreen(screen[RandomWeight.run(screenweight)]);
    }

    public void buildCoordinate() {
        log.setCoordinate(coordinate[RandomWeight.run(coorweight)]);
    }

    public void buildSystemId() {
        log.setSystemId(systemId);
    }

    public void buildUserName() {
        log.setUserName(userName[RandomWeight.run(unameweight)]);
    }

    @Override
    public void buildtimeStamp() {
        log.setTimeStamp(DateUtil.timeToLong());
    }

    public BrowserLog retrieveResult() {
        return log;
    }
}
