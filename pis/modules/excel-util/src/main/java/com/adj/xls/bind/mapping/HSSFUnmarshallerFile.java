package com.adj.xls.bind.mapping;

import com.adj.xls.bind.PoijiFile;
import com.adj.xls.exception.PoijiException;
import com.adj.xls.option.PoijiOptions;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.IOException;

/**
 *
 * Created by adj on 16/01/2017.
 */
final class HSSFUnmarshallerFile extends HSSFUnmarshaller {

    private final PoijiFile<?> poijiFile;

    HSSFUnmarshallerFile(PoijiFile<?> poijiFile, PoijiOptions options) {
        super(options);
        this.poijiFile = poijiFile;
    }

    @Override
    protected Workbook workbook() {
        try {
            return WorkbookFactory.create(poijiFile.file(), options.getPassword(), true);
        } catch (IOException e) {
            throw new PoijiException("Problem occurred while creating HSSFWorkbook", e);
        }
    }
}
