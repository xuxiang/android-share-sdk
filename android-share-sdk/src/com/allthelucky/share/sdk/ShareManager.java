package com.allthelucky.share.sdk;

import java.net.URLDecoder;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.app.library.http.RequestListener;
import com.app.library.http.RequestManager;

/**
 * 
 * 分享管理工具
 * 
 * @author savant-pan
 * 
 */
public class ShareManager {

	public void init(Context context) {

	}

	/**
	 * 设置授权数据
	 * 
	 * @param context
	 * @param type
	 * @param responseData
	 */
	public static void setupAuth(Context context, int type, String responseData) {
		SharedPreferences sharedPreferences = context.getSharedPreferences("auth-" + type, Context.MODE_PRIVATE);
		Editor editor = sharedPreferences.edit();
		editor.putBoolean("flag", true);
		if (responseData != null) {
			String array[] = responseData.split("&");
			for (String parameter : array) {
				String v[] = parameter.split("=");
				try {
					editor.putString(URLDecoder.decode(v[0]), URLDecoder.decode(v[1]));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		editor.commit();
	}

	/**
	 * 取授权参数
	 * 
	 * @param context
	 * @param type
	 * @return
	 */
	private static SharedPreferences getAuth(Context context, int type) {
		return context.getSharedPreferences("auth-" + type, Context.MODE_PRIVATE);
	}

	/**
	 * 检测是否已授权
	 * 
	 * @param context
	 * @param type
	 */
	public static boolean hasAuth(Activity context, int type) {
		SharedPreferences sharedPreferences = context.getSharedPreferences("auth-" + type, Context.MODE_PRIVATE);
		if (!sharedPreferences.getBoolean("flag", false)) {
			final Intent intent = new Intent(context, ShareAuthActivity.class);
			intent.putExtra("type", type);
			intent.putExtra("auth_url", getAuthUrl(type));
			context.startActivity(intent);
			return false;
		} else {
			return true;
		}
	}

	/**
	 * 发布一条微博
	 * 
	 * @param context
	 * @param type
	 * @param shareParams
	 * @param shareListener
	 */
	public static void addWeibo(Context context, int type, ShareParams shareParams, ShareListener shareListener) {
		try {
			request(context, getWeiboUrl(type), addWeiboParams(context, type, shareParams), shareListener, "POST");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 请求网络
	 * 
	 * @param context
	 * @param requestUrl
	 * @param shareParams
	 * @param shareListener
	 * @param requestMethod
	 * @throws Exception
	 */
	public static void request(Context context, String requestUrl, ShareParams shareParams,
			ShareListener shareListener, String requestMethod) throws Exception {
		if (requestMethod == null || "".equals(requestMethod)) {
			requestMethod = "GET";
		}

		RequestManager requestManager = RequestManager.getInstance();
		if ("POST".equalsIgnoreCase(requestMethod)) {
			requestManager.post(context, requestUrl, shareParams, new ShareRequester(shareListener), 0);
		} else {
			requestManager.get(context, requestUrl, shareParams, new ShareRequester(shareListener), false, 1);
		}
	}

	/**
	 * 取微博发布接口地址
	 * 
	 * @param type
	 * @return
	 */
	private static String getWeiboUrl(int type) {
		if (ShareWebo.SINA == type) {
			return ShareWebo.SINA_URL;
		} else {
			return ShareWebo.TECENT_URL;
		}
	}

	/**
	 * 添加授权数据到参数列表
	 * 
	 * @param context
	 * @param type
	 * @param shareParams
	 * @return
	 */
	private static ShareParams addWeiboParams(Context context, int type, ShareParams shareParams) {
		SharedPreferences sharedPreferences = getAuth(context, type);
		if (ShareWebo.SINA == type) {
			shareParams.put("access_token", sharedPreferences.getString("access_token", ""));
		} else {
			shareParams.put("oauth_consumer_key", ShareWebo.TECENT_KEY);
			shareParams.put("access_token", sharedPreferences.getString("access_token", ""));
			shareParams.put("openid", sharedPreferences.getString("openid", ""));
			shareParams.put("clientip", "127.0.0.1");
			shareParams.put("oauth_version", "2.a");
			shareParams.put("scope", "all");
		}
		return shareParams;
	}

	/**
	 * 取授权地址
	 * 
	 * @param type
	 * @return
	 */
	private static String getAuthUrl(int type) {
		if (ShareWebo.SINA == type) {
			return ShareWebo.SINA_AUTH_URL + "?client_id=" + ShareWebo.SINA_KEY + "&response_type=token&redirect_uri="
					+ ShareWebo.CALLBACK_RUL + "&display=mobile";
		} else {
			return ShareWebo.TECENT_AUTH_URL + "?client_id=" + ShareWebo.TECENT_KEY
					+ "&response_type=token&redirect_uri=" + ShareWebo.CALLBACK_RUL;
		}
	}
}

/**
 * 请求网络结果处理
 * 
 * @author Administrator
 * 
 */
class ShareRequester implements RequestListener {
	private ShareListener shareListener;

	public ShareRequester(ShareListener shareListener) {
		this.shareListener = shareListener;
	}

	@Override
	public void onStart() {
		if (this.shareListener != null) {
			this.shareListener.onStart();
		}
	}

	@Override
	public void onCompleted(byte[] data, int statusCode, String description, int actionId) {
		if (this.shareListener != null) {
			if (data != null && data.length != 0) {
				this.shareListener.onResult(ShareListener.OK, Utils.bytesToString(data));
			} else {
				this.shareListener.onResult(ShareListener.ERR, null);
			}
		}
	}
}
