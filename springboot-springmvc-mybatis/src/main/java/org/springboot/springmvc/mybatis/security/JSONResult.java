package org.springboot.springmvc.mybatis.security;

import org.json.JSONException;
import org.json.JSONObject;

public class JSONResult {
	public static String fillResultString(final Integer status,
			final String message, final Object result) {
		JSONObject jsonObject = null;
		try {
			jsonObject = new JSONObject() {
				{
					put("status", status);
					put("message", message);
					put("result", result);
				}
			};
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonObject.toString();
	}
}
