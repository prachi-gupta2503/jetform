package com.adjecti.common.util;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.HashMap;
import java.util.Map;

public class JetFormResourceCache {

	private static final Log LOGGER = LogFactoryUtil.getLog(FormEntityCache.class.getName());

	private static Map<String, String> jetFormResourceCache = new HashMap<String, String>();

	public static void registerJetFormResourceCache(String fileName, String filePath) {
		
		jetFormResourceCache.put(fileName, filePath);
	}

	public static String getFilePath(String fileName) {
		
		return jetFormResourceCache.get(fileName);
	}

	public static void clearJetFormResourceCache() {
		
		jetFormResourceCache.clear();
	}

}
