package com.adj.xls.bind;

import java.io.InputStream;

/**
 * Created by adj on 08/03/2018.
 */
public final class PoijiInputStream<T extends InputStream> {

    private final T t;

    PoijiInputStream(T t) {
        this.t = t;
    }

    /**
     * the T derived from {@link InputStream}
     * @return T
     */
    public T stream() {
        return t;
    }
}
