package com.adj.xls.config;

import com.adj.xls.option.PoijiOptions;

public class DefaultFormatting implements Formatting {

	public DefaultFormatting() {
	}

	@Override
	public String transform(PoijiOptions options, String value) {
		if (options.getCaseInsensitive()) {
			value = value.toLowerCase();
		}
		if (options.getIgnoreWhitespaces()) {
			value = value.trim();
		}
		return value;
	}

}
