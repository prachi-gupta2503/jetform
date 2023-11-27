package com.adjecti.jetform.annotation;


public class ImportExportAttributeWrapper {
	private String column;
	private String field;
	private Class<?> type;
	public String getColumn() {
		return column;
	}

	public void setColumn(String column) {
		this.column = column;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public Class<?> getType() {
		return type;
	}

	public void setType(Class<?> type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "ImportExportAttributeWrapper [column=" + column + ", field=" + field + ", type=" + type + "]";
	}
}
