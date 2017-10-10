package com.readyidu.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 加载配置文件
 * @author yuzhang
 *
 */
public class ConfigSettings {

	public static Properties properties;

	static {
		properties = new Properties();
		InputStream stream = null;
		try {
			stream = ConfigSettings.class.getClassLoader().getResourceAsStream(
					"properties/redis.properties");
			properties.load(stream);
		} catch (Exception e) {
			String s = e.getLocalizedMessage();
			System.out.print(s);
		} finally {
			if (stream != null) {
				try {
					stream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static String getProperty(String key, String defaultValue) {
		return properties.getProperty(key, defaultValue);
	}

	public static String getProperty(String key) {
		return getProperty(key, null);
	}

}
