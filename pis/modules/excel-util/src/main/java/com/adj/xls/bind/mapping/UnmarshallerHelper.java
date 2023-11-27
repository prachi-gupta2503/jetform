package com.adj.xls.bind.mapping;

import com.adj.xls.bind.PoijiFile;
import com.adj.xls.bind.PoijiInputStream;
import com.adj.xls.bind.Unmarshaller;
import com.adj.xls.option.PoijiOptions;

import org.apache.poi.ss.usermodel.Sheet;

/**
 * Created by adj on 17/01/2017.
 */
public final class UnmarshallerHelper {

    public static Unmarshaller HSSFInstance(PoijiFile<?> poijiFile, PoijiOptions options) {
        return new HSSFUnmarshallerFile(poijiFile, options);
    }

    public static Unmarshaller HSSFInstance(PoijiInputStream<?> poijiInputStream, PoijiOptions options) {
        return new HSSFUnmarshallerStream(poijiInputStream, options);
    }

    public static Unmarshaller XSSFInstance(PoijiFile<?> poijiFile, PoijiOptions options) {
        return new XSSFUnmarshallerFile(poijiFile, options);
    }

    public static Unmarshaller XSSFInstance(PoijiInputStream<?> poijiInputStream, PoijiOptions options) {
        return new XSSFUnmarshallerStream(poijiInputStream, options);
    }

    public static Unmarshaller SheetInstance(Sheet sheet, PoijiOptions options) {
        return new SheetUnmarshaller(sheet, options);
    }
}
