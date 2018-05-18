package ml.jinggo.data.logFactory.negativeConcrete;


import ml.jinggo.data.VO.BrowserLog;
import ml.jinggo.data.logFactory.BrowserBuilder;

/**
 * Created by Administrator on 2017/10/17.
 */
public class ConcreteBrowserBuilder implements BrowserBuilder {
    private BrowserLog log = new BrowserLog();
    private static final String[] type = {}; //1.浏览日志 2.点击日志3.搜索日志4.购买日志

    private static final String[] hrefTag = {};  //标签标识
    private static final String[] hrefContent = {};  //标签对应的标识，主要针对a标签后的内容
    private static final String[] referrerUrl = {}; //来源网址
    private static final String[] requestUrl = {}; //来源网址
    private static final String[] clickTime = {};  //点击时间
    private static final String[] appName = {};  //浏览器类型
    private static final String[] appVersion = {}; //浏览器版本
    private static final String[] language = {}; //浏览器语言
    private static final String[] platform = {};  //操作系统
    private static final String[] screen = {};  //屏幕尺寸
    private static final String[] coordinate = {};  //点击鼠标时的坐标
    private static final String[] systemId = {};  //产生点击流的系统编号
    private static final String[] userName = {};  //用户名称


    public void buildType() {

    }

    public void buildHrefTag() {

    }

    public void buildHrefContent() {

    }

    public void buildReferrerUrl() {

    }

    public void buildRequestUrl() {

    }

    public void buildClickTime() {

    }

    public void buildAppName() {

    }

    public void buildAppVersion() {

    }

    public void buildLanguage() {

    }

    public void buildPlatform() {

    }

    public void buildScreen() {

    }

    public void buildCoordinate() {

    }

    public void buildSystemId() {

    }

    public void buildUserName() {

    }

    @Override
    public void buildtimeStamp() {

    }

    public BrowserLog retrieveResult() {
        return log;
    }
}
