package com.adj.xls.bind;

import java.io.File;
import java.io.InputStream;

/**
 * Created by adj on 16/01/2017.
 */
public final class PoijiFile<T extends File> {

    private final T t;

    PoijiFile(T t) {
        this.t = t;
    }

    /**
     * the T derived from {@link InputStream}
     * @return T
     */
    public T file() {
        return t;
    }
}
