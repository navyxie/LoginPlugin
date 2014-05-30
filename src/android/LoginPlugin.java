package com.kalengo.weathermeida.plugins;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

import com.kalengo.weathermeida.ui.MeActivity;
import com.kalengo.weathermeida.ui.TrendDetailActivity;
import com.kalengo.weathermeida.util.UrlUtil;

/**
 * @author Administrator 第三方登录
 */
public class LoginPlugin extends CordovaPlugin {

	public static final String LOGIN = "login";
	public static final String FINISH = "finish";
	public static final String SINA = "sina";
	public static final String QQ = "qq";

	public boolean execute(String action, JSONArray data,
			CallbackContext callbackContext) throws JSONException {
		UrlUtil.info("david", action + "---" + data.getString(0));
		if (LOGIN.equals(action)) {
			login(data.getString(0), callbackContext);
			return true;// 不加上你会哭
		} else if (FINISH.equals(action)) {
			MeActivity.isRefresh = true;
			// if (Util.loadingDialog != null) {
			// Util.loadingDialog.dismiss();
			// Util.loadingDialog = null;
			// }
			// Util.dismissDialog();
			this.cordova.getActivity().finish();
		}
		return false;
	}

	private void login(final String path, final CallbackContext callbackContext)
			throws JSONException {
		final TrendDetailActivity a = (TrendDetailActivity) this.cordova
				.getActivity();
		Runnable runnable = new Runnable() {

			@Override
			public void run() {
				if (SINA.equals(path)) {
					a.sinaLogin(callbackContext);

				} else if (QQ.equals(path)) {
					a.QQLogin(callbackContext);
				}
			}
		};
		this.cordova.getActivity().runOnUiThread(runnable);

	}

}
