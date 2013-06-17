package com.allthelucky.share.sdk;

import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;

/**
 * 测试程序
 * 
 * @author savant-pan
 * 
 */
public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ShareErrUtils.init(this);
		testSina();
		// testTecent();
	}

	/**
	 * 新浪微博测试
	 */
	protected void testSina() {
		boolean flag = ShareManager.hasAuth(MainActivity.this, ShareWebo.SINA);
		if (flag) {// 如果未授权，测进入授权界面，否则发布新微博
			ShareParams shareParams = new ShareParams();
			shareParams.put("status", "hello,world");
			ShareManager.addWeibo(MainActivity.this, ShareWebo.SINA, shareParams, new ShareListener() {
				@Override
				public void onStart() {

				}

				@Override
				public void onResult(int code, String result) {
					System.out.println("status:" + code + ",result:" + result);
					JSONObject object = Utils.stringToJSONObject(result);
					if (object != null) {
						ShareErrUtils.getMessage(ShareWebo.SINA, object.optInt("error_code"));
					} else {
						//failed
					}
				}
			});
		}
	}

	/**
	 * QQ微博测试
	 */
	protected void testTecent() {
		boolean flag = ShareManager.hasAuth(MainActivity.this, ShareWebo.TECENT);
		if (flag) {// 如果未授权，测进入授权界面，否则发布新微博
			ShareParams shareParams = new ShareParams();
			shareParams.put("content", "hello,world");
			shareParams.put("format", "json");
			ShareManager.addWeibo(MainActivity.this, ShareWebo.TECENT, shareParams, new ShareListener() {
				@Override
				public void onStart() {

				}

				@Override
				public void onResult(int code, String result) {
					System.out.println("status:" + code + ",result:" + result);
					JSONObject object = Utils.stringToJSONObject(result);
					if (object != null) {
						ShareErrUtils.getMessage(ShareWebo.TECENT, object.optInt("error_code"));
					}
				}
			});
		}
	}

}
