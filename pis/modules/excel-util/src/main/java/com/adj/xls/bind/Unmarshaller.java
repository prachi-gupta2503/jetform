package com.adj.xls.bind;

import com.adj.xls.annotation.ExcelSheet;
import com.adj.xls.option.PoijiOptions;

import java.util.Optional;
import java.util.function.Consumer;

/**
 * Created by adj on 08/03/2018
 */
public interface Unmarshaller {

    <T> void unmarshal(Class<T> type, Consumer<? super T> consumer);

    default <T> Optional<String> getSheetName(Class<T> type, PoijiOptions options) {
        if (type.isAnnotationPresent(ExcelSheet.class)) {
            ExcelSheet excelSheet = type.getAnnotation(ExcelSheet.class);
            String annotatedSheetName = excelSheet.value();
            return Optional.of(annotatedSheetName);
        }

        String configuredSheetName = options.getSheetName();
        return Optional.ofNullable(configuredSheetName);
    }
}
