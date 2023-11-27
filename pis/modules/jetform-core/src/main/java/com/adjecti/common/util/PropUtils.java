package com.adjecti.common.util;


import java.util.Properties;

import org.apache.commons.lang.StringUtils;

public class PropUtils {
	

	
	public static boolean getBoolean(Properties p, String key) {
		try {
			return Boolean.parseBoolean(p.getProperty(key));
		} catch (Exception e) {
		}
		return false;
	}

	public static boolean getBoolean(Properties p, String key, boolean defaultVal) {
		try {
			String v=p.getProperty(key);
			if(StringUtils.isNotEmpty(v)){
				return Boolean.parseBoolean(p.getProperty(key));
			}
			
		} catch (Exception e) {
		}
		return defaultVal;
	}

	public static int getInt(Properties p, String key) {
		try {
			return Integer.parseInt(p.getProperty(key));
		} catch (Exception e) {
		}
		return 0;
	}

	public static int getInt(Properties p, String key, int defaultVal) {
		try {
			return Integer.parseInt(p.getProperty(key));
		} catch (Exception e) {
		}
		return defaultVal;
	}
	
	public static long getLong(Properties p, String key) {
		try {
			return Long.parseLong(p.getProperty(key));
		} catch (Exception e) {
		}
		return 0;
	}

	public static long getLong(Properties p, String key, long defaultVal) {
		try {
			return Long.parseLong(p.getProperty(key));
		} catch (Exception e) {
		}
		return defaultVal;
	}

	public static double getDouble(Properties p, String key) {
		try {
			return Double.parseDouble(p.getProperty(key));
		} catch (Exception e) {
		}
		return 0;
	}

	public static double getDouble(Properties p, String key, double defaultVal) {
		try {
			return Double.parseDouble(p.getProperty(key));
			
		} catch (Exception e) {
		}
		return defaultVal;
	}

	public static String getString(Properties p, String key) {
		try {
			return p.getProperty(key) == null ? "" : p.getProperty(key);
		} catch (Exception e) {
		}
		return null;
	}

	public static String getString(Properties p, String key, String defaultVal) {
		try {
			return p.getProperty(key) == null ? defaultVal : p.getProperty(key);
		} catch (Exception e) {
		}
		return defaultVal;
	}
	
	
	
	public static void main(String [] p){
		System.out.println(Integer.parseInt(null));
	}

	public static Properties getProperties(String resourceKey) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/*public static Configuration getConfiguration(String name) {
		return ConfigurationFactoryUtil.getConfiguration(PortalClassLoaderUtil.getClassLoader(), name);
	}*/
	
/*	public static Properties getConfiguration(String name) {
		System.out.println(name);
		
		try {
			Configuration cfg=ConfigurationFactoryUtil.getConfiguration(PortalClassLoaderUtil.getClassLoader(), name);
			return cfg.getProperties();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Properties();
	}*/
}
