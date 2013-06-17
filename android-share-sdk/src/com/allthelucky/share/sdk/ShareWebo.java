package com.allthelucky.share.sdk;

/**
 * 微博参数配置
 * 
 * @author savant-pan
 * 
 */
public class ShareWebo {
	/**
	 * 新浪微博
	 * /
	public static final int SINA = 0;
	/**
	 * 新浪微博应用ID
	 * /
	public static final String SINA_KEY = "1228343418";
	/**
	 * 新浪微博应用SECRET
	 * /
	public static final String SINA_SECRET = "1228343418";
	/**
	 * 新浪微博授权地址
	 * /
	public static final String SINA_AUTH_URL = "https://open.weibo.cn/oauth2/authorize";
	/**
	 * SINA API服务接口调用地址
	 */
	public static final String SINA_URL = "https://api.weibo.com/2/statuses/update.json";
	/**
	 * 腾讯微博微博
	 * /
	public static final int TECENT = 1;
	/**
	 * 腾讯微博应用ID
	 * /
	public static final String TECENT_KEY = "801263295";
	/**
	 * 腾讯微博应用SECRET
	 * /
	public static final String TECENT_SECRET = "c04459e0802f19e213af7ac548984708";
	/**
	 * 腾讯微博应用授权地址
	 * /
	public static final String TECENT_AUTH_URL = "https://open.t.qq.com/cgi-bin/oauth2/authorize";
	/**
	 * TECENT API服务接口调用地址
	 */
	public static final String TECENT_URL = "https://open.t.qq.com/api/t/add";
	/**
	 * 微博授权回调地址（公用）
	 */
	public static final String CALLBACK_RUL = "http://h.qdone.net.cn/share/index.html";

}
