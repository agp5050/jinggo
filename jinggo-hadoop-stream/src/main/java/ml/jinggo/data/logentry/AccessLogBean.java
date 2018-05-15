package ml.jinggo.data.logentry;

import java.io.Serializable;
/**
 * ClassName: AccessLogBean
 * @Description: AccessLogBean是浏览器数据封装的pojo类，主要有
 * ipAddress
 * dateTime
 * requests
 * responseStats 
 * bytesSent
 * referer
 * browser
 * areaAddress
 * loaclAddress
 * receiveTime
 * ，对这几个参数字段的封装。
 * @author 王宏
 * @date 2017年11月20日
 */
public class AccessLogBean implements Serializable{
	/**
	 * 序列化ID
	 */
	private static final long serialVersionUID = 2719076604915643039L;

	public AccessLogBean() {
	}
	public AccessLogBean(String defaultInfo) {
		CANNOT_GET = defaultInfo;
	}
	private static String CANNOT_GET = "can not get";
	
	/**
	 * ip地址
	 */
	private String ipAddress = CANNOT_GET;
	/**
	 * 日期
	 */
	private String dateTime = CANNOT_GET;
	/**
	 * 请求url
	 */
	private String requests = CANNOT_GET;
	/**
	 * 响应
	 */
	private String responseStats = CANNOT_GET;
	/**
	 * 发送的字节数
	 */
	private String bytesSent = CANNOT_GET;
	/**
	 * 跳转的url
	 */
	private String referer = CANNOT_GET;
	/**
	 * 浏览器类型
	 */
	private String browser = CANNOT_GET;
	/**
	 * 对方所在地址
	 */
	private String areaAddress = CANNOT_GET;
	/**
	 * 本地地址
	 */
	private String loaclAddress = CANNOT_GET;
	/**
	 * 接受数据时间
	 */
	private String receiveTime = CANNOT_GET;
	
	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public String getRequests() {
		return requests;
	}

	public void setRequests(String requests) {
		this.requests = requests;
	}

	public String getResponseStats() {
		return responseStats;
	}

	public void setResponseStats(String responseStats) {
		this.responseStats = responseStats;
	}

	public String getBytesSent() {
		return bytesSent;
	}

	public void setBytesSent(String bytesSent) {
		this.bytesSent = bytesSent;
	}

	public String getReferer() {
		return referer;
	}

	public void setReferer(String referer) {
		this.referer = referer;
	}

	public String getBrowser() {
		return browser;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}

	public String getAreaAddress() {
		return areaAddress;
	}

	public void setAreaAddress(String areaAddress) {
		this.areaAddress = areaAddress;
	}

	public String getLoaclAddress() {
		return loaclAddress;
	}

	public void setLoaclAddress(String loaclAddress) {
		this.loaclAddress = loaclAddress;
	}

	public String getReceiveTime() {
		return receiveTime;
	}

	public void setReceiveTime(String receiveTime) {
		this.receiveTime = receiveTime;
	}

	/**
	 *
	 * @param splitFormat 拆分的字符串
	 * @return 类似toString，返回字符串+拆分数据
	 */
	public String combineString(String splitFormat) {
		return  ipAddress + splitFormat + dateTime + splitFormat + requests
				+ splitFormat + responseStats + splitFormat + bytesSent + splitFormat
				+ referer + splitFormat + browser + splitFormat + areaAddress
				+ splitFormat + loaclAddress + splitFormat + receiveTime ;
	}
	
}
