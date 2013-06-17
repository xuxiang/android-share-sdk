package com.allthelucky.share.sdk;

/**
 * 微博参数配置
 * 
 * @author savant-pan
 * 
 */
public class ShareWebo {
	public static final int SINA = 0;
	public static final String SINA_KEY = "1228343418";
	public static final String SINA_SECRET = "1228343418";
	public static final String SINA_AUTH_URL = "https://open.weibo.cn/oauth2/authorize";

	public static final int TECENT = 1;
	public static final String TECENT_KEY = "801263295";
	public static final String TECENT_SECRET = "c04459e0802f19e213af7ac548984708";
	public static final String TECENT_AUTH_URL = "https://open.t.qq.com/cgi-bin/oauth2/authorize";

	/**
	 * 微博授权回调地址（公用）
	 */
	public static final String CALLBACK_RUL = "http://h.qdone.net.cn/share/index.html";
	/**
	 * SINA API服务接口调用地址
	 */
	public static final String SINA_URL = "https://api.weibo.com/2/statuses/update.json";
	/**
	 * TECENT API服务接口调用地址
	 */
	public static final String TECENT_URL = "https://open.t.qq.com/api/t/add";

}
