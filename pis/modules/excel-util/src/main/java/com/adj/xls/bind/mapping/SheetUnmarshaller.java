package com.adj.xls.bind.mapping;

import com.adj.xls.exception.PoijiException;
import com.adj.xls.option.PoijiOptions;

import org.apache.poi.hssf.usermodel.HSSFFormulaEvaluator;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.Optional;
import java.util.function.Consumer;

/**
 * Created by adj on 11.10.2020
 */
public final class SheetUnmarshaller extends HSSFUnmarshaller {

    private Sheet sheet;

    SheetUnmarshaller(final Sheet sheet, final PoijiOptions options) {
        super(options);
        this.sheet = sheet;
    }

    @Override
    public <T> void unmarshal(Class<T> type, Consumer<? super T> consumer) {

        Workbook workbook = workbook();
        if (workbook instanceof HSSFWorkbook) {
            baseFormulaEvaluator = HSSFFormulaEvaluator.create((HSSFWorkbook) workbook, null, null);
        } else if (workbook instanceof XSSFWorkbook) {
            baseFormulaEvaluator = XSSFFormulaEvaluator.create((XSSFWorkbook) workbook, null, null);
        } else {
            throw new PoijiException("Workbook is not supported.");
        }
        processRowsToObjects(sheet, type, consumer);
    }

    @Override
    public <T> Optional<String> getSheetName(Class<T> type, PoijiOptions options) {
        return Optional.empty();
    }

    @Override
    protected Workbook workbook() {
        return sheet.getWorkbook();
    }
}
