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
	 */
	public static final int SINA = 0;
	/**
	 * 新浪微博应用ID
	 */
	public static final String SINA_KEY = "aaaaaaaaa";
	/**
	 * 新浪微博应用SECRET
	 */
	public static final String SINA_SECRET = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";
	/**
	 * 新浪微博授权地址
	 */
	public static final String SINA_AUTH_URL = "https://open.weibo.cn/oauth2/authorize";
	/**
	 * SINA 微博发布接口地址
	 */
	public static final String SINA_URL = "https://api.weibo.com/2/statuses/update.json";
	/**
	 * 腾讯微博微博
	 */
	public static final int TECENT = 1;
	/**
	 * 腾讯微博应用ID
	 */
	public static final String TECENT_KEY = "bbbbbbbbb";
	/**
	 * 腾讯微博应用SECRET
	 */
	public static final String TECENT_SECRET = "yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy";
	/**
	 * 腾讯微博应用授权地址
	 */
	public static final String TECENT_AUTH_URL = "https://open.t.qq.com/cgi-bin/oauth2/authorize";
	/**
	 * TECENT 微博发布接口地址
	 */
	public static final String TECENT_URL = "https://open.t.qq.com/api/t/add";
	/**
	 * 微博授权回调地址（公用）
	 */
	public static final String CALLBACK_RUL = "http://zzz.zzzz.zzz/zz.html";

}
