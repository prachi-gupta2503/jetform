package com.adjecti.common.util;

import com.adjecti.jetform.model.KeyValue;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.lang.time.DateUtils;



public class CommonUtils {
	private static final String VOWELS = "AEIOUY";

	public static String toCSV(Object[] array) {
		String csv = "";
		for (Object s : array) {
			csv += s + ",";
		}
		if (csv.length() > 0) {
			csv = csv.substring(0, csv.length() - 1);
		}
		return csv;
	}

	public static String toCSV(List list) {
		String csv = "";
		for (Object s : list) {
			csv += s + ",";
		}
		if (csv.length() > 0) {
			csv = csv.substring(0, csv.length() - 1);
		}
		return csv;
	}

	public static int[] csvToIntArray(String csv) {
		String[] parts = csv.split(",");
		int[] array = new int[parts.length];
		int i = 0;
		for (String s : parts) {
			array[i++] = toInt(s);
		}

		return array;
	}

	public static List<Integer> csvToIntList(String csv) {
		String[] parts = csv.split(",");
		List<Integer> list = new ArrayList<Integer>();
		for (String s : parts) {
			list.add(toInt(s));
		}

		return list;
	}

	public static long[] csvToLongArray(String csv) {
		String[] parts = csv.split(",");
		long[] array = new long[parts.length];
		int i = 0;
		for (String s : parts) {
			array[i++] = toLong(s);
		}

		return array;
	}

	public static List<Long> csvToLongList(String csv) {
		String[] parts = csv.split(",");
		List<Long> list = new ArrayList<Long>();
		for (String s : parts) {
			list.add(toLong(s));
		}

		return list;
	}

	public static double[] csvToDoubleArray(String csv) {
		String[] parts = csv.split(",");
		double[] array = new double[parts.length];
		int i = 0;
		for (String s : parts) {
			array[i++] = toInt(s);
		}

		return array;
	}

	public static List<Double> csvToDoubleList(String csv) {
		String[] parts = csv.split(",");
		List<Double> list = new ArrayList<Double>();
		for (String s : parts) {
			list.add(toDouble(s));
		}

		return list;
	}

	public static float[] csvToFloatArray(String csv) {
		String[] parts = csv.split(",");
		float[] array = new float[parts.length];
		int i = 0;
		for (String s : parts) {
			array[i++] = toInt(s);
		}

		return array;
	}

	public static List<Float> csvToFloatList(String csv) {
		String[] parts = csv.split(",");
		List<Float> list = new ArrayList<Float>();
		for (String s : parts) {
			list.add(toFloat(s));
		}

		return list;
	}

	public static int toInt(String str) {
		int i = 0;
		try {
			i = Integer.parseInt(StringUtils.trim(str));
		} catch (Exception e) {
		}
		return i;
	}

	public static float toFloat(String str) {
		float i = 0;
		try {
			i = Float.parseFloat(StringUtils.trim(str));
		} catch (Exception e) {
		}
		return i;
	}

	public static double toDouble(String str) {
		double i = 0;
		try {
			i = Double.parseDouble(StringUtils.trim(str));
		} catch (Exception e) {
		}
		return i;
	}

	public static long toLong(String str) {
		long i = 0;
		try {
			i = Long.parseLong(StringUtils.trim(str));
		} catch (Exception e) {
		}
		return i;
	}

	public static boolean toBoolean(String str) {
		boolean i = false;
		try {
			i = Boolean.parseBoolean(StringUtils.trim(str));
		} catch (Exception e) {
		}
		return i;
	}

	public static <E> E findCollection(Collection<? extends E> c, String key, Object value) {
		E r = null;

		for (E o : c) {
			try {
				String x = BeanUtils.getProperty(o, key);
				if (x.equals(String.valueOf(value))) {
					r = o;
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return r;
	}

	public static List<KeyValue> toKeyValues(List objects, String keyAttribute, String valueAttribute) {
		List<KeyValue> data = new ArrayList<KeyValue>();
		if (CollectionUtils.isEmpty(objects)) {
			return data;
		}
		Object obj = objects.get(0);
		boolean map = false;

		if (obj instanceof Map) {
			map = true;
		}
		for (Object o : objects) {
			KeyValue kvp = new KeyValue();
			if (map) {
				Map m = (Map) o;
				kvp.setKey(String.valueOf(m.get(keyAttribute)));
				kvp.setValue(String.valueOf(m.get(valueAttribute)));
			} else {
				try {
					kvp.setKey(BeanUtils.getProperty(o, keyAttribute));
					kvp.setValue(BeanUtils.getProperty(o, valueAttribute));
				} catch (Exception e) {
				}
			}
			data.add(kvp);
		}
		return data;

	}

	public static Object stringToObject(String str, String returnType) {
		Object value = null;
		if (java.util.Date.class.getName().equalsIgnoreCase(returnType)) {
			try {
				value = DateUtils.parseDate(str, new String[] { "dd-MM-yyyy", "dd/MM/yyyy", "yyyy-MM-dd", "yyyy/MM/dd" });
			} catch (Exception e) {
			
			}
		} else if (java.lang.Integer.class.getName().equalsIgnoreCase(returnType)) {
			value = NumberUtils.createInteger(str);
		} else if (java.lang.Long.class.getName().equalsIgnoreCase(returnType)) {
			value = NumberUtils.createLong(str);
		} else if (java.lang.Float.class.getName().equalsIgnoreCase(returnType)) {
			value = NumberUtils.createFloat(str);
		} else if (java.lang.Double.class.getName().equalsIgnoreCase(returnType)) {
			value = NumberUtils.createDouble(str);
		} else if (java.lang.Boolean.class.getName().equalsIgnoreCase(returnType)) {
			value = BooleanUtils.toBoolean(str);
		} else {
			value = str;
		}
		return value;
	}

	public static boolean startsWithVowel(String s) {
		if (s == null || s.length() == 0) {
			return false;
		}
		return VOWELS.indexOf(s.charAt(0)) != -1;
	}

	public static Date toDate(String value, String sourceFormat) {
		value = value.replace("/", "-");
		sourceFormat = sourceFormat.replace("/", "-");
		DateFormat srcFmt = new SimpleDateFormat(sourceFormat);

		try {
			return srcFmt.parse(value);
		} catch (ParseException e) {
		}
		return null;
	}

	public static String formatedDateString(String value, String sourceFormat, String targetFormat) {
		value = value.replace("/", "-");
		sourceFormat = sourceFormat.replace("/", "-");
		targetFormat = targetFormat.replace("/", "-");

		DateFormat srcFmt = new SimpleDateFormat(sourceFormat);
		DateFormat tgtFmt = new SimpleDateFormat(targetFormat);
		try {
			return tgtFmt.format(srcFmt.parse(value));
		} catch (ParseException e) {
		}
		return null;
	}
}
