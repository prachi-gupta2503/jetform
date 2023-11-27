package com.adj.xls.config;

import com.adj.xls.exception.PoijiException;
import com.adj.xls.option.PoijiOptions;
import com.adj.xls.parser.BooleanParser;
import com.adj.xls.parser.Parsers;
import com.adj.xls.util.PoijiConstants;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.lang.StringUtils;

/**
 * Created by adj on 22/01/2017.
 */
public class DefaultCasting implements Casting {
    private final boolean errorLoggingEnabled;

    private final List<DefaultCastingError> errors = new ArrayList<>();

    public DefaultCasting() {
        this(false);
    }

    public DefaultCasting(boolean errorLoggingEnabled) {
        this.errorLoggingEnabled = errorLoggingEnabled;
    }

    private <T> T onError(String value, String sheetName, int row, int col, Exception exception, T defaultValue) {
        logError(value, defaultValue, sheetName, row, col, exception);
        return defaultValue;
    }

    private void logError(String value, Object defaultValue, String sheetName, int row, int col, Exception exception) {
        if (errorLoggingEnabled) {
            errors.add(new DefaultCastingError(value, defaultValue, sheetName, row, col, exception));
        }
    }

    private Boolean primitiveBooleanValue(String value, String sheetName, int row, int col) {
        try {
            return Parsers.booleans().parse(value);
        } catch (BooleanParser.BooleanParseException bpe) {
            return onError(value, sheetName, row, col, bpe, false);
        }
    }

    private Boolean booleanValue(String value, String sheetName, int row, int col, PoijiOptions options) {
        try {
            return Parsers.booleans().parse(value);
        } catch (BooleanParser.BooleanParseException bpe) {
            return onError(value, sheetName, row, col, bpe, options.preferNullOverDefault() ? null : false);
        }
    }

    private int primitiveIntegerValue(String value, String sheetName, int row, int col) {
        try {
            return Parsers.integers().parse(value).intValue();
        } catch (NumberFormatException nfe) {
            return onError(value, sheetName, row, col, nfe, 0);
        }
    }

    private Integer integerValue(String value, String sheetName, int row, int col, PoijiOptions options) {
        try {
            return Parsers.integers().parse(value).intValue();
        } catch (NumberFormatException nfe) {
            return onError(value, sheetName, row, col, nfe, options.preferNullOverDefault() ? null : 0);
        }
    }

    private long primitiveLongValue(String value, String sheetName, int row, int col) {
        try {
            return Parsers.longs().parse(value).longValue();
        } catch (NumberFormatException nfe) {
            return onError(value, sheetName, row, col, nfe, 0L);
        }
    }

    private Long longValue(String value, String sheetName, int row, int col, PoijiOptions options) {
        try {
            return Parsers.longs().parse(value).longValue();
        } catch (NumberFormatException nfe) {
            return onError(value, sheetName, row, col, nfe, options.preferNullOverDefault() ? null : 0L);
        }
    }

    private double primitiveDoubleValue(String value, String sheetName, int row, int col, PoijiOptions options) {
        try {
            return Parsers.numbers(options.getLocale()).parse(value).doubleValue();
        } catch (NumberFormatException nfe) {
            return onError(value, sheetName, row, col, nfe, 0d);
        }
    }

    private Double doubleValue(String value, String sheetName, int row, int col, PoijiOptions options) {
        try {
            return Parsers.numbers(options.getLocale()).parse(value).doubleValue();
        } catch (NumberFormatException nfe) {
            return onError(value, sheetName, row, col, nfe, options.preferNullOverDefault() ? null : 0d);
        }
    }

    private float primitiveFloatValue(String value, String sheetName, int row, int col, PoijiOptions options) {
        try {
            return Parsers.numbers(options.getLocale()).parse(value).floatValue();
        } catch (NumberFormatException nfe) {
            return onError(value, sheetName, row, col, nfe, 0f);
        }
    }

    private Float floatValue(String value, String sheetName, int row, int col, PoijiOptions options) {
        try {
            return Parsers.numbers(options.getLocale()).parse(value).floatValue();
        } catch (NumberFormatException nfe) {
            return onError(value, sheetName, row, col, nfe, options.preferNullOverDefault() ? null : 0f);
        }
    }

    private BigDecimal bigDecimalValue(String value, String sheetName, int row, int col, PoijiOptions options) {
        try {
            return Parsers.bigDecimals().parse(value);
        } catch (NumberFormatException | IllegalStateException e) {
            return onError(value, sheetName, row, col, e, options.preferNullOverDefault() ? null : BigDecimal.ZERO);
        }
    }

    private String[] parseArrayList(String value, PoijiOptions options, String sheetName, int row, int col) {
        try {
            return value.split(options.getListDelimiter());
        } catch (Exception e) {
            return onError(value, sheetName, row, col, e, options.preferNullOverDefault() ? null : new String[]{});
        }
    }

    private Date dateValue(String value, String sheetName, int row, int col, PoijiOptions options) {

        //ISSUE #57
        //if a date regex has been specified then it wont be null
        //so then make sure the string matches the pattern
        //if it doesn't, fall back to default
        //else continue to turn string into java date

        //the reason for this is sometime Java will manage to parse a string to a date object
        //without any exceptions but since the string was not an exact match you get a very strange date
        if (options.getDateRegex() != null && !value.matches(options.getDateRegex())) {
            return options.preferNullOverDefault() ? null : Calendar.getInstance().getTime();
        } else {
            try {
            	
            	String dateFormat = options.datePattern();
            	System.out.println("Date Value - "+value);
                String year=  value.substring(value.lastIndexOf("/")+1);
                if(StringUtils.isNotBlank(year) && year.length()<4) {
                	
                	dateFormat="M/dd/yy";
                }
            	final SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
                sdf.setLenient(options.getDateLenient());
                
                return sdf.parse(value);
            } catch (ParseException e) {
            	if(options.datePattern().equalsIgnoreCase(PoijiConstants.DEFAULT_DATE_PATTERN)) {
            		//return onError(value, sheetName, row, col, e, options.preferNullOverDefault() ? null : Calendar.getInstance().getTime());
            		return onError(value, sheetName, row, col, e, null);
            	}
            	try {
            		System.out.println("Date ParseException 11- "+e.getMessage());
	            	final SimpleDateFormat sdf = new SimpleDateFormat(PoijiConstants.DEFAULT_DATE_PATTERN);
	                 sdf.setLenient(options.getDateLenient());
	                 return sdf.parse(value);
            	} catch (ParseException ex) {
            		System.out.println("Date ParseException 22- "+e.getMessage());
            	//	return onError(value, sheetName, row, col, ex, options.preferNullOverDefault() ? null : Calendar.getInstance().getTime());
            		return onError(value, sheetName, row, col, ex, null);
            	}
            }
        }
    }

    private LocalDate localDateValue(String value, String sheetName, int row, int col, PoijiOptions options) {

        //ISSUE #57
        //if a date regex has been specified then it wont be null
        //so then make sure the string matches the pattern
        //if it doesn't, fall back to default
        //else continue to turn string into java date

        //the reason for this is sometime java will manage to parse a string to a date object
        //without any exceptions but since the string was not an exact match you get a very strange date
        if (options.getDateRegex() != null && !value.matches(options.getDateRegex())) {
            return options.preferNullOverDefault() ? null : LocalDate.now();
        } else {
            try {
                return LocalDate.parse(value, options.dateFormatter());
            } catch (DateTimeParseException e) {
                return onError(value, sheetName, row, col, e, options.preferNullOverDefault() ? null : LocalDate.now());
            }
        }
    }

    private LocalDateTime localDateTimeValue(String value, String sheetName, int row, int col, PoijiOptions options) {
        if (options.getDateTimeRegex() != null && !value.matches(options.getDateTimeRegex())) {
            return options.preferNullOverDefault() ? null : LocalDateTime.now();
        } else {
            try {
                return LocalDateTime.parse(value, options.dateTimeFormatter());
            } catch (DateTimeParseException e) {
                return onError(value, sheetName, row, col, e, options.preferNullOverDefault() ? null : LocalDateTime.now());
            }
        }
    }


    private Object enumValue(String value, String sheetName, int row, int col, Class<?> type) {
        return Arrays.stream(type.getEnumConstants())
                .filter(o -> ((Enum<?>) o).name().equals(value))
                .findFirst()
                .orElseGet(() -> {
                    IllegalArgumentException e = new IllegalArgumentException("No enumeration " + type.getSimpleName() + "." + value);
                    return onError(value, sheetName, row, col, e, null);
                });
    }

    private Object castListValue(String value, String sheetName, int row, int col, Field field, PoijiOptions options) {
        final ParameterizedType genericType = (ParameterizedType) field.getGenericType();
        final Type fieldType = genericType.getActualTypeArguments()[0];
        String[] valueList = value.split(options.getListDelimiter());

        if (fieldType == Integer.class) {
            return Stream.of(valueList)
                    .map(rv -> primitiveIntegerValue(rv, sheetName, row, col))
                    .collect(Collectors.toList());
        } else if (fieldType == BigDecimal.class) {
            return Stream.of(valueList)
                    .map(rv -> bigDecimalValue(rv, sheetName, row, col, options))
                    .collect(Collectors.toList());
        } else if (fieldType == Long.class) {
            return Stream.of(valueList)
                    .map(rv -> longValue(rv, sheetName, row, col, options))
                    .collect(Collectors.toList());
        } else if (fieldType == Double.class) {
            return Stream.of(valueList)
                    .map(rv -> doubleValue(rv, sheetName, row, col, options))
                    .collect(Collectors.toList());
        } else if (fieldType == Boolean.class) {
            return Stream.of(valueList)
                    .map(rv -> booleanValue(rv, sheetName, row, col, options))
                    .collect(Collectors.toList());
        } else if (fieldType == Float.class) {
            return Stream.of(valueList)
                    .map(rv -> floatValue(rv, sheetName, row, col, options))
                    .collect(Collectors.toList());
        } else {
            return Arrays.asList(valueList);
        }
    }

    @Override
    public Object castValue(Field field, String rawValue, int row, int col, PoijiOptions options) {
        Class<?> fieldType = field.getType();
        return getValueObject(field, row, col, options, rawValue, fieldType);
    }

    protected Object getValueObject(Field field, int row, int col, PoijiOptions options, String rawValue, Class<?> fieldType) {
        String sheetName = options.getSheetName();
        String value = options.trimCellValue() ? rawValue.trim() : rawValue;

        Object o;
        if (fieldType == int.class) {
            o = primitiveIntegerValue(value, sheetName, row, col);

        } else if (fieldType == Integer.class) {
            o = integerValue(value, sheetName, row, col, options);

        } else if (fieldType == BigDecimal.class) {
            o = bigDecimalValue(value, sheetName, row, col, options);

        } else if (fieldType == long.class) {
            o = primitiveLongValue(value, sheetName, row, col);

        } else if (fieldType == Long.class) {
            o = longValue(value, sheetName, row, col, options);

        } else if (fieldType == double.class) {
            o = primitiveDoubleValue(value, sheetName, row, col, options);

        } else if (fieldType == Double.class) {
            o = doubleValue(value, sheetName, row, col, options);

        } else if (fieldType == boolean.class) {
            o = primitiveBooleanValue(value, sheetName, row, col);

        } else if (fieldType == Boolean.class) {
            o = booleanValue(value, sheetName, row, col, options);

        } else if (fieldType == float.class) {
            o = primitiveFloatValue(value, sheetName, row, col, options);

        } else if (fieldType == Float.class) {
            o = floatValue(value, sheetName, row, col, options);

        } else if (fieldType == Date.class) {
            o = dateValue(value, sheetName, row, col, options);

        } else if (fieldType == LocalDate.class) {
            o = localDateValue(value, sheetName, row, col, options);

        } else if (fieldType == LocalDateTime.class) {
            o = localDateTimeValue(value, sheetName, row, col, options);

        } else if (fieldType.isEnum()) {
            o = enumValue(value, sheetName, row, col, fieldType);

        } else if (value.isEmpty()) {
            o = options.preferNullOverDefault() ? null : value;
        } else if (fieldType == List.class) {
            o = castListValue(value, sheetName, row, col, field, options);
        } else {
            o = value;

        }
        return o;
    }

    public boolean isErrorLoggingEnabled() {
        return errorLoggingEnabled;
    }

    public List<DefaultCastingError> getErrors() {
        if (errorLoggingEnabled) {
            return Collections.unmodifiableList(errors);
        } else {
            throw new PoijiException("logging not enabled");
        }
    }

}
