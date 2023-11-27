package com.adj.xls.config;

import com.adj.xls.option.PoijiOptions;


/**
 * A formatting interface to build a custom poiji header formatting.
 * <p>
 * Created by adj on 24/10/2020.
 */
public interface Formatting {

    /**
     * Normalize header names using custom formatting
     *
     * @param options poiji options
     * @param value   header name
     * @return normalized header name
     */
    String transform(PoijiOptions options, String value);
}
