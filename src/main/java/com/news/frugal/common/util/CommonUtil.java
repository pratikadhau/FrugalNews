package com.news.frugal.common.util;

import org.codehaus.jackson.map.ObjectMapper;

public class CommonUtil {
	public <T> String writeResponseAsString(T responseObject) {
		final ObjectMapper mapper = new ObjectMapper();
		String responseJsonString = "";

		try {
			responseJsonString = mapper.writeValueAsString(responseObject);
		} catch (Throwable t) {
			System.out.println("JSON Parsing failed, root cause: " + t.getMessage());
		}

		return responseJsonString;
	}
}
