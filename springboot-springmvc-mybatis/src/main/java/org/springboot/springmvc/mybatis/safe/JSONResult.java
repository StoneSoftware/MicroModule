package org.springboot.springmvc.mybatis.safe;

import org.json.JSONObject;

class JSONResult {
	public static String fillResultString(Integer status, String message,
			Object result) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("status", status);
		jsonObject.put("message", message);
		jsonObject.put("result", result);
		return jsonObject.toString();
	}
}
