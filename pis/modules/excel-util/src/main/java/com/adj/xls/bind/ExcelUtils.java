package com.adj.xls.bind;

import static com.adj.xls.util.PoijiConstants.XLSX_EXTENSION;
import static com.adj.xls.util.PoijiConstants.XLS_EXTENSION;

import com.adj.xls.bind.mapping.HSSFPropertyFile;
import com.adj.xls.bind.mapping.HSSFPropertyStream;
import com.adj.xls.bind.mapping.PoijiPropertyHelper;
import com.adj.xls.bind.mapping.UnmarshallerHelper;
import com.adj.xls.exception.IllegalCastException;
import com.adj.xls.exception.InvalidExcelFileExtension;
import com.adj.xls.exception.PoijiExcelType;
import com.adj.xls.exception.PoijiException;
import com.adj.xls.option.PoijiOptions;
import com.adj.xls.option.PoijiOptions.PoijiOptionsBuilder;
import com.adj.xls.util.Files;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

import org.apache.poi.ss.usermodel.Sheet;

/**
 * The entry point of the mapping process.
 * <p>
 * Example:
 * <pre>
 * List<Employee> employees = Poiji.fromExcel(new File("employees.xls"), Employee.class);
 * employees.size();
 * // 3
 * Employee firstEmployee = employees.get(0);
 * // Employee{employeeId=123923, name='Joe', surname='Doe', age=30, single=true, birthday='4/9/1987'}
 * </pre>
 * <p>
 * Created by adj on 16/01/2017.
 */
public final class ExcelUtils {

    private static final Files files = Files.getInstance();

    private ExcelUtils() {
    }

    /**
     * converts excel properties into an object
     *
     * @param file excel file ending with .xlsx.
     * @param type type of the root object.
     * @param <T>  type of the root object.
     * @return the newly created objects
     * @throws PoijiException            if an internal exception occurs during the mapping process.
     * @throws InvalidExcelFileExtension if the specified excel file extension is invalid.
     * @throws IllegalCastException      if this Field object is enforcing Java language access control and the underlying field is either inaccessible or final.
     * @see ExcelUtils#fromExcelProperties(File, Class, PoijiOptions)
     */
    public static <T> T fromExcelProperties(final File file, final Class<T> type) {
        return fromExcelProperties(file, type, PoijiOptionsBuilder.settings().build());
    }

    /**
     * converts excel properties into an object
     *
     * @param inputStream excel file stream
     * @param excelType   type of the excel file, xlsx only!
     * @param type        type of the root object.
     * @param <T>         type of the root object.
     * @return the newly created object
     * @throws PoijiException            if an internal exception occurs during the mapping process.
     * @throws InvalidExcelFileExtension if the specified excel file extension is invalid.
     * @throws IllegalCastException      if this Field object is enforcing Java language access control and the underlying field is either inaccessible or final.
     * @see ExcelUtils#fromExcelProperties(InputStream, PoijiExcelType, Class, PoijiOptions)
     */
    public static <T> T fromExcelProperties(final InputStream inputStream,
                                            PoijiExcelType excelType,
                                            final Class<T> type) {
        return fromExcelProperties(inputStream, excelType, type, PoijiOptionsBuilder.settings().build());
    }

    /**
     * converts excel properties into an object
     *
     * @param file    excel file ending with .xlsx.
     * @param type    type of the root object.
     * @param <T>     type of the root object.
     * @param options specifies to change the default behaviour of the poiji. In this case, only the password has an effect
     * @return the newly created object
     * @throws PoijiException            if an internal exception occurs during the mapping process.
     * @throws InvalidExcelFileExtension if the specified excel file extension is invalid.
     * @throws IllegalCastException      if this Field object is enforcing Java language access control and the underlying field is either inaccessible or final.
     * @see ExcelUtils#fromExcelProperties(File, Class)
     */
    public static <T> T fromExcelProperties(final File file, final Class<T> type, final PoijiOptions options) {
        HSSFPropertyFile hssfPropertyFile = deserializerPropertyFile(file, options);
        return hssfPropertyFile.unmarshal(type);
    }

    private static HSSFPropertyFile deserializerPropertyFile(final File file, PoijiOptions options) {
        String extension = files.getExtension(file.getName());
        if (XLSX_EXTENSION.equals(extension)) {
            return PoijiPropertyHelper.createPoijiPropertyFile(file, options);
        } else if (XLS_EXTENSION.equals(extension)) {
            throw new InvalidExcelFileExtension("Reading metadata from (" + extension + "), is not supported");
        } else {
            throw new InvalidExcelFileExtension("Invalid file extension (" + extension + "), expected .xlsx");
        }
    }

    private static HSSFPropertyStream deserializerPropertyStream(PoijiExcelType excelType, InputStream inputStream, PoijiOptions options) {
        if (excelType == PoijiExcelType.XLSX) {
            return PoijiPropertyHelper.createPoijiPropertyStream(inputStream, options);
        } else {
            throw new InvalidExcelFileExtension("Reading metadata from (" + excelType + "), is not supported");
        }
    }

    /**
     * converts excel properties into an object
     *
     * @param inputStream excel file stream
     * @param excelType   type of the excel file, xlsx only!
     * @param type        type of the root object.
     * @param <T>         type of the root object.
     * @param options     specifies to change the default behaviour of the poiji. In this case, only the password has an effect
     * @return the newly created object
     * @throws PoijiException            if an internal exception occurs during the mapping process.
     * @throws InvalidExcelFileExtension if the specified excel file extension is invalid.
     * @throws IllegalCastException      if this Field object is enforcing Java language access control and the underlying field is either inaccessible or final.
     * @see ExcelUtils#fromExcelProperties(InputStream, PoijiExcelType, Class)
     */
    public static <T> T fromExcelProperties(final InputStream inputStream,
                                            PoijiExcelType excelType,
                                            final Class<T> type,
                                            PoijiOptions options) {
        Objects.requireNonNull(excelType);
        HSSFPropertyStream hssfPropertyStream = deserializerPropertyStream(excelType, inputStream, options);
        return hssfPropertyStream.unmarshal(type);
    }

    /**
     * converts excel rows into a list of objects
     *
     * @param file excel file ending with .xls or .xlsx.
     * @param type type of the root object.
     * @param <T>  type of the root object.
     * @return the newly created list of objects
     * @throws PoijiException            if an internal exception occurs during the mapping process.
     * @throws InvalidExcelFileExtension if the specified excel file extension is invalid.
     * @throws IllegalCastException      if this Field object is enforcing Java language access control and the underlying field is either inaccessible or final.
     * @see ExcelUtils#fromExcel(File, Class, PoijiOptions)
     */
    public static <T> List<T> fromExcel(final File file, final Class<T> type) {
        final ArrayList<T> list = new ArrayList<>();
        fromExcel(file, type, list::add);
        return list;
    }

    /**
     * converts excel rows into a list of objects
     *
     * @param file     excel file ending with .xls or .xlsx.
     * @param type     type of the root object.
     * @param <T>      type of the root object.
     * @param consumer output retrieves records
     * @throws PoijiException            if an internal exception occurs during the mapping
     *                                   process.
     * @throws InvalidExcelFileExtension if the specified excel file extension
     *                                   is invalid.
     * @throws IllegalCastException      if this Field object is enforcing Java language access control and the underlying field is either inaccessible or final.
     * @see ExcelUtils#fromExcel(File, Class, PoijiOptions)
     */
    public static <T> void fromExcel(final File file, final Class<T> type, final Consumer<? super T> consumer) {
        final Unmarshaller unmarshaller = deserializer(file, PoijiOptionsBuilder.settings().build());
        unmarshaller.unmarshal(type, consumer);
    }

    /**
     * converts excel rows into a list of objects
     *
     * @param inputStream excel file stream
     * @param excelType   type of the excel file, xls or xlsx
     * @param type        type of the root object.
     * @param <T>         type of the root object.
     * @return the newly created list of objects
     * @throws PoijiException            if an internal exception occurs during the mapping process.
     * @throws InvalidExcelFileExtension if the specified excel file extension is invalid.
     * @throws IllegalCastException      if this Field object is enforcing Java language access control and the underlying field is either inaccessible or final.
     * @see ExcelUtils#fromExcel(InputStream, PoijiExcelType, Class, PoijiOptions)
     */
    public static <T> List<T> fromExcel(final InputStream inputStream,
                                        PoijiExcelType excelType,
                                        final Class<T> type) {
        final ArrayList<T> list = new ArrayList<>();
        fromExcel(inputStream, excelType, type, list::add);
        return list;
    }

    /**
     * converts excel rows into a list of objects
     *
     * @param inputStream excel file stream
     * @param excelType   type of the excel file, xls or xlsx
     * @param type        type of the root object.
     * @param <T>         type of the root object.
     * @param consumer    represents an operation that accepts the type argument
     * @throws PoijiException            if an internal exception occurs during the mapping process.
     * @throws InvalidExcelFileExtension if the specified excel file extension is invalid.
     * @throws IllegalCastException      if this Field object is enforcing Java language access control and the underlying field is either inaccessible or final.
     * @see ExcelUtils#fromExcel(File, Class, PoijiOptions)
     */
    public static <T> void fromExcel(final InputStream inputStream,
                                     PoijiExcelType excelType,
                                     final Class<T> type,
                                     final Consumer<? super T> consumer) {
        Objects.requireNonNull(excelType);

        final Unmarshaller unmarshaller = deserializer(inputStream, excelType, PoijiOptionsBuilder.settings().build());
        unmarshaller.unmarshal(type, consumer);
    }

    /**
     * converts excel rows into a list of objects
     *
     * @param file    excel file ending with .xls or .xlsx.
     * @param type    type of the root object.
     * @param <T>     type of the root object.
     * @param options specifies to change the default behaviour of the poiji.
     * @return the newly created list of objects
     * @throws PoijiException            if an internal exception occurs during the mapping process.
     * @throws InvalidExcelFileExtension if the specified excel file extension is invalid.
     * @throws IllegalCastException      if this Field object is enforcing Java language access control and the underlying field is either inaccessible or final.
     * @see ExcelUtils#fromExcel(File, Class)
     */
    public static <T> List<T> fromExcel(final File file, final Class<T> type, final PoijiOptions options) {
        final ArrayList<T> list = new ArrayList<>();
        fromExcel(file, type, options, list::add);
        return list;
    }

    /**
     * converts excel rows into a list of objects
     *
     * @param file     excel file ending with .xls or .xlsx.
     * @param type     type of the root object.
     * @param <T>      type of the root object.
     * @param options  specifies to change the default behaviour of the poiji.
     * @param consumer represents an operation that accepts the type argument
     * @throws PoijiException            if an internal exception occurs during the mapping process.
     * @throws InvalidExcelFileExtension if the specified excel file extension is invalid.
     * @throws IllegalCastException      if this Field object is enforcing Java language access control and the underlying field is either inaccessible or final.
     * @see ExcelUtils#fromExcel(File, Class)
     */
    public static <T> void fromExcel(final File file, final Class<T> type, final PoijiOptions options, final Consumer<? super T> consumer) {
        final Unmarshaller unmarshaller = deserializer(file, options);
        unmarshaller.unmarshal(type, consumer);
    }

    /**
     * converts excel rows into a list of objects
     *
     * @param inputStream excel file stream
     * @param excelType   type of the excel file, xls or xlsx
     * @param type        type of the root object.
     * @param <T>         type of the root object.
     * @param options     specifies to change the default behaviour of the poiji.
     * @return the newly created list of objects
     * @throws PoijiException            if an internal exception occurs during the mapping process.
     * @throws InvalidExcelFileExtension if the specified excel file extension is invalid.
     * @throws IllegalCastException      if this Field object is enforcing Java language access control and the underlying field is either inaccessible or final.
     * @see ExcelUtils#fromExcel(InputStream, PoijiExcelType, Class)
     */
    public static <T> List<T> fromExcel(final InputStream inputStream,
                                        final PoijiExcelType excelType,
                                        final Class<T> type,
                                        final PoijiOptions options) {
        Objects.requireNonNull(excelType);
        final ArrayList<T> list = new ArrayList<>();
        fromExcel(inputStream, excelType, type, options, list::add);
        return list;
    }

    /**
     * converts excel rows into a list of objects
     *
     * @param inputStream excel file stream
     * @param excelType   type of the excel file, xls or xlsx
     * @param type        type of the root object.
     * @param <T>         type of the root object.
     * @param options     specifies to change the default behaviour of the poiji.
     * @param consumer    represents an operation that accepts the type argument
     * @throws PoijiException            if an internal exception occurs during the mapping process.
     * @throws InvalidExcelFileExtension if the specified excel file extension is invalid.
     * @throws IllegalCastException      if this Field object is enforcing Java
     *                                   language access control and the underlying field is either inaccessible or final.
     * @see ExcelUtils#fromExcel(File, Class)
     */
    public static <T> void fromExcel(final InputStream inputStream,
                                     final PoijiExcelType excelType,
                                     final Class<T> type,
                                     final PoijiOptions options,
                                     final Consumer<? super T> consumer) {
        Objects.requireNonNull(excelType);

        final Unmarshaller unmarshaller = deserializer(inputStream, excelType, options);
        unmarshaller.unmarshal(type, consumer);
    }

    /**
     * converts excel rows into a list of objects
     *
     * @param sheet   excel sheet its workbook must be either  an instance of {@code HSSFWorkbook} or {@code XSSFWorkbook}.
     * @param type    type of the root object.
     * @param <T>     type of the root object.
     * @param options specifies to change the default behaviour of the poiji.
     * @throws PoijiException if an internal exception occurs during the mapping process.
     * @see ExcelUtils#fromExcel(Sheet, Class, PoijiOptions, Consumer)
     * @see ExcelUtils#fromExcel(Sheet, Class)
     */
    public static <T> List<T> fromExcel(final Sheet sheet,
                                        final Class<T> type,
                                        final PoijiOptions options) {
        Objects.requireNonNull(sheet);
        final ArrayList<T> list = new ArrayList<>();
        fromExcel(sheet, type, options, list::add);
        return list;
    }


    /**
     * converts excel rows into a list of objects
     *
     * @param sheet excel sheet its workbook must be either an instance of {@code HSSFWorkbook} or {@code XSSFWorkbook}.
     * @param type  type of the root object.
     * @param <T>   type of the root object.
     * @throws PoijiException if an internal exception occurs during the mapping process.
     * @see ExcelUtils#fromExcel(Sheet, Class, PoijiOptions)
     * @see ExcelUtils#fromExcel(Sheet, Class, PoijiOptions, Consumer)
     */
    public static <T> List<T> fromExcel(final Sheet sheet,
                                        final Class<T> type) {
        Objects.requireNonNull(sheet);
        final ArrayList<T> list = new ArrayList<>();
        fromExcel(sheet, type, PoijiOptionsBuilder.settings().build(), list::add);
        return list;
    }


    /**
     * converts excel rows into a list of objects
     *
     * @param sheet    excel sheet its workbook must be either an instance of {@code HSSFWorkbook} or {@code XSSFWorkbook}.
     * @param type     type of the root object.
     * @param <T>      type of the root object.
     * @param options  specifies to change the default behaviour of the poiji.
     * @param consumer represents an operation that accepts the type argument.
     * @throws PoijiException if an internal exception occurs during the mapping process.
     * @see ExcelUtils#fromExcel(Sheet, Class, PoijiOptions)
     * @see ExcelUtils#fromExcel(Sheet, Class)
     */
    public static <T> void fromExcel(final Sheet sheet,
                                     final Class<T> type,
                                     final PoijiOptions options,
                                     final Consumer<? super T> consumer) {
        Objects.requireNonNull(sheet);
        final Unmarshaller unmarshaller = UnmarshallerHelper.SheetInstance(sheet, options);
        unmarshaller.unmarshal(type, consumer);
    }

    private static Unmarshaller deserializer(final File file, final PoijiOptions options) {
        final PoijiFile<?> poijiFile = new PoijiFile<>(file);

        String extension = files.getExtension(file.getName());

        if (XLS_EXTENSION.equals(extension)) {
            return UnmarshallerHelper.HSSFInstance(poijiFile, options);
        } else if (XLSX_EXTENSION.equals(extension)) {
            return UnmarshallerHelper.XSSFInstance(poijiFile, options);
        } else {
            throw new InvalidExcelFileExtension("Invalid file extension (" + extension + "), expected .xls or .xlsx");
        }
    }

    private static Unmarshaller deserializer(final InputStream inputStream, PoijiExcelType excelType, final PoijiOptions options) {
        final PoijiInputStream<?> poijiInputStream = new PoijiInputStream<>(inputStream);

        if (excelType == PoijiExcelType.XLS) {
            return UnmarshallerHelper.HSSFInstance(poijiInputStream, options);
        } else if (excelType == PoijiExcelType.XLSX) {
            return UnmarshallerHelper.XSSFInstance(poijiInputStream, options);
        } else {
            throw new InvalidExcelFileExtension("Invalid file extension (" + excelType + "), expected .xls or .xlsx");
        }
    }

}
