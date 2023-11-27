package com.adj.xls.util;

import com.adj.xls.annotation.ExcelCellName;
import com.adj.xls.config.Formatting;
import com.adj.xls.exception.HeaderMissingException;
import com.adj.xls.option.PoijiOptions;

import java.util.Collection;
import java.util.Set;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

/**
 * Created by adj on 2.05.2020
 */
public final class AnnotationUtil {

	private AnnotationUtil() {
	}

	/**
	 * Validate that all headers specified via @ExcelCellName annotations are
	 * present in the list of header names.
	 * <p>
	 * Validation is only performed if it is set in the PoijiOptions
	 *
	 * @throws HeaderMissingException if one or more headers are missing
	 */
	public static <T> void validateMandatoryNameColumns(PoijiOptions options, Formatting formatting, Class<T> modelType,
			Collection<String> headerNames) {
		if (options.getNamedHeaderMandatory()) {
			Collection<ExcelCellName> excelCellNames = ReflectUtil.findRecursivePoijiAnnotations(modelType,
					ExcelCellName.class);

			BiPredicate<String, String> comparator = String::equals;

			Set<String> missingHeaders = excelCellNames.stream()
					.filter(excelCellName -> headerNames.stream().noneMatch(
							title -> comparator.test(formatting.transform(options, excelCellName.value()), title)))
					.map(ExcelCellName::value).collect(Collectors.toSet());

			if (!missingHeaders.isEmpty()) {
				throw new HeaderMissingException("Some headers are missing in the sheet: " + missingHeaders);
			}
		}
	}
}
