package com.adj.xls.bind;

/**
 * Created by adj on 25.05.2020
 */
public interface PropertyUnmarshaller {

    <T> T unmarshal(Class<T> type);

    <T> T returnFromExcelFile(Class<T> type);

    <T> T returnFromEncryptedFile(Class<T> type);
}
