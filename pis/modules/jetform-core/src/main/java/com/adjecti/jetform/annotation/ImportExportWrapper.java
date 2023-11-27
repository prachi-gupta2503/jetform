package com.adjecti.jetform.annotation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ImportExportWrapper implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Class<?> objectClass;
	private boolean importable=true;
	private boolean exportable=true;
	private String format=ImportExport.Format.EXCEL.name();
	private int startRow=0;
	private int startCol=0;
	private boolean header=true;
	
	private List<ImportExportAttributeWrapper>  elements=new ArrayList<ImportExportAttributeWrapper>();
	public Class<?> getObjectClass() {
		return objectClass;
	}
	public void setObjectClass(Class<?> objectClass) {
		this.objectClass = objectClass;
	}
	public boolean isImportable() {
		return importable;
	}
	public void setImportable(boolean importable) {
		this.importable = importable;
	}
	public boolean isExportable() {
		return exportable;
	}
	public void setExportable(boolean exportable) {
		this.exportable = exportable;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	
	public int getStartRow() {
		return startRow;
	}
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}
	public int getStartCol() {
		return startCol;
	}
	public void setStartCol(int startCol) {
		this.startCol = startCol;
	}
	public boolean isHeader() {
		return header;
	}
	public void setHeader(boolean header) {
		this.header = header;
	}
	public List<ImportExportAttributeWrapper> getElements() {
		return elements;
	}
	public void setElements(List<ImportExportAttributeWrapper> elements) {
		this.elements = elements;
	}
	
	public void addElement(ImportExportAttributeWrapper element){
		this.elements.add(element);
	}
	public void removeElement(ImportExportAttributeWrapper element){
		this.elements.remove(element);
	}
	public List<String> getColumns(){
		List<String> list=new ArrayList<String>();
		for(ImportExportAttributeWrapper e:elements){
			list.add(e.getColumn());
		}
		return list;
	}
	public List<String> getFields(){
		List<String> list=new ArrayList<String>();
		for(ImportExportAttributeWrapper e:elements){
			list.add(e.getField());
		}
		return list;
	}
	@Override
	public String toString() {
		return "ImportExportWrapper [objectClass=" + objectClass + ", importable=" + importable + ", exportable=" + exportable + ", format=" + format + ", elements=" + elements + "]";
	}
}
