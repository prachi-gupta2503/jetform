package com.adj.xls.parser;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * @see <a href="https://www.ibm.com/developerworks/library/j-numberformat/index.html">Resolving NumberFormat's parsing issues</a>
 */
public class Parsers {

    private Parsers() {
        // static factory
    }

    public static NumberParser longs() {
        return integers();
    }

    public static NumberParser integers() {
        NumberFormat format = NumberFormat.getInstance();
        format.setParseIntegerOnly(true);
        return new NumberParser(format);
    }

    public static BigDecimalParser bigDecimals() {
        return new BigDecimalParser();
    }

    public static NumberParser numbers(Locale locale) {
        return new NumberParser(NumberFormat.getInstance(locale));
    }

    public static BooleanParser booleans() {
        return new BooleanParser();
    }
}
