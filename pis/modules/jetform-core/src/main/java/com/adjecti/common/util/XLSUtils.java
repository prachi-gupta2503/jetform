package com.adjecti.common.util;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLSUtils {

	public static final int MAX_DATA_COLUMNS = 100;
	public static final int MAX_HEADER_ROW = 10;
	public static final String TYPE_XLSX="xlsx";
	final static Log LOGGER = LogFactoryUtil.getLog(XLSUtils.class.getName());
	public static Map getObjects(String xlsFile, String[] sheets, int headerRow, Class objectClass, Map mapping) {

		Map<String, List> dataMap = new HashMap<String, List>();
		Workbook workbook = null;
		// Cell cell = null;
		try {

			if (mapping == null || mapping.size() == 0) {
				if (mapping == null) {
					mapping = new HashMap();
				}
				Field[] fields = objectClass.getDeclaredFields();
				for (int i = -0; i < fields.length; i++) {
					mapping.put(fields[i].getName(), fields[i].getName());
				}
			}

			FileInputStream file = new FileInputStream(new File(xlsFile));
			Sheet sheet = null;

			if (xlsFile.endsWith(".xlsx")) {
				workbook = new XSSFWorkbook(file);
			} else {
				workbook = new HSSFWorkbook(file);
			}

			FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
			int sheetCtr = 0;
			while (true) {
				sheet = null;

				if (sheets != null && sheets.length > 0) {
					sheet = (sheets.length > sheetCtr) ? workbook.getSheet(sheets[sheetCtr++]) : null;
				} else {
					try {
						sheet = workbook.getSheetAt(sheetCtr++);
					} catch (Exception e) {
						System.out.println("No more sheets found");
						break;
					}
				}

				if (sheet == null) {
					break;
				}

				List dataList = new ArrayList();
				Map<String, Integer> colMap = new HashMap();
				if (headerRow > 0) {
					Row header = sheet.getRow(headerRow - 1);
					for (int i = 0; true; i++) {
						Cell cell = header.getCell(i);
						if (cell == null || cell.getCellType() == CellType.BLANK) {
							if (i > 20) {
								break;
							}
							continue;
						}
						String headerValue = StringUtils.trim(cell.getStringCellValue()).toUpperCase();
						if (headerValue.equals("")) {
							break;
						}
						Iterator itr = mapping.entrySet().iterator();
						while (itr.hasNext()) {
							Map.Entry entry = (Map.Entry) itr.next();
							String headerAttribute = StringUtils.trim((String) entry.getValue()).toLowerCase();
							if (headerValue.equalsIgnoreCase(headerAttribute)) {
								if (colMap == null) {
									colMap = new HashMap<String, Integer>();
								}
								colMap.put((String) entry.getKey(), i);
								break;
							}
						}
					}
				} else {
					colMap = mapping;
				}

				int fieldCol = 0;
				Row dataRow = null;
				Object entity = null;
				Object value = null;
				String fieldName = null;
				boolean emptyRow = true;
				for (int rowCtr = headerRow; true; rowCtr++) {
					dataRow = sheet.getRow(rowCtr);
					if (dataRow == null) {
						break;
					}
					Iterator itr = colMap.entrySet().iterator();
					entity = objectClass.newInstance();
					emptyRow = true;
					while (itr.hasNext()) {
						Map.Entry entry = (Map.Entry) itr.next();
						fieldName = (String) entry.getKey();
						fieldCol = ((Integer) entry.getValue()).intValue();
						Cell cell = dataRow.getCell(fieldCol);
						if (cell == null) {
							continue;
						}

						value = null;

						CellValue cellValue = evaluator.evaluate(cell);
						if (cellValue == null) {
							continue;
						}
						if (cellValue.getCellType() == CellType.BOOLEAN) {
							value = cellValue.getBooleanValue();
						} else if (cellValue.getCellType() == CellType.NUMERIC) {
							if (DateUtil.isCellDateFormatted(cell)) {
								value = DateUtil.getJavaDate(cellValue.getNumberValue());
							} else {
								value = cellValue.getNumberValue();
							}
						} else if (cellValue.getCellType() == CellType.BLANK) {
							value = cellValue.getStringValue();
						}
						if (value != null) {
							try {
								BeanUtils.setProperty(entity, fieldName, value);
								emptyRow = false;
							} catch (Exception e) {
								emptyRow = false;
								e.printStackTrace();
							}
						}
					}
					if (emptyRow) {
						break;
					}
					dataList.add(entity);
				}
				dataMap.put(sheet.getSheetName(), dataList);
			}
			file.close();
		} catch (Exception e) {
		}finally {
			try {
				workbook.close();
			} catch (Exception e) {
			}
		}
		return dataMap;
	}

	public static String exportToExcel(List<Object[]> expList, int rowNum, String fileName) {
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("Sheet1");
		rowNum--;
		for (Object[] objArr : expList) {
			Row row = sheet.createRow(rowNum++);
			int cellnum = 0;
			for (Object obj : objArr) {
				Cell cell = row.createCell(cellnum++);
				if (obj == null) {
					continue;
				}
				if (obj instanceof Date) {
					cell.setCellValue((Date) obj);
				} else if (obj instanceof Boolean) {
					cell.setCellValue((Boolean) obj);
				} else if (obj instanceof String) {
					cell.setCellValue((String) obj);
				} else if (obj instanceof Double) {
					cell.setCellValue((Double) obj);
				} else if (obj instanceof Long) {
					cell.setCellValue((Long) obj);
				} else if (obj instanceof Float) {
					cell.setCellValue((Float) obj);
				} else if (obj instanceof Integer) {
					cell.setCellValue((Integer) obj);
				}
			}
		}

		try {
			File file = File.createTempFile(fileName, ".xlsx");
			FileOutputStream out = new FileOutputStream(file);
			workbook.write(out);
			out.close();
			// System.out.println("Excel written successfully..");
			return file.getAbsolutePath();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static List<Map<String, Object>> readData(String xlsFile, int startRow, int startCol, boolean header) throws IOException {
		FileInputStream file = null;
		Workbook workbook = null;
		Sheet sheet = null;
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();

		try {
			file = new FileInputStream(new File(xlsFile));

			if (xlsFile.endsWith(".xlsx")) {
				workbook = new XSSFWorkbook(file);
			} else {
				workbook = new HSSFWorkbook(file);
			}
			sheet = workbook.getSheetAt(0);

			if (sheet == null) {
				return null;
			}
			FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();

			int dataRow = startRow, dataCol = startCol;
			boolean dataExists = false;
			if (dataRow == 0 || dataCol == 0) {
				while (true) {
					Row row = sheet.getRow(dataRow);
					if (row == null) {
						if (dataRow >= 9) {
							break;
						} else {
							dataRow++;
							continue;
						}
					}
					dataCol = 0;
					while (true) {
						Cell cell = row.getCell(dataCol);
						if (cell == null || cell.getCellType() == CellType.BLANK) {
							if (dataCol >= 9) {
								break;
							} else {
								dataCol++;
								continue;
							}
						} else {
							dataExists = true;
							break;
						}
					}
					if (dataExists) {
						break;
					}
				}
			}
			if (!dataExists) {
				return result;
			}

			int r = dataRow, c = dataCol;
			List<String> headers = new ArrayList<String>();

			if (header) {
				Row row = sheet.getRow(r);
				while (true) {
					Cell cell = row.getCell(c);
					if (cell == null || cell.getCellType() == CellType.BLANK || c >= (dataCol + MAX_DATA_COLUMNS)) {
						break;
					}
					headers.add(cell.getStringCellValue());
					c++;
				}
				r++;
			} else {
				while (c < (dataCol + MAX_DATA_COLUMNS)) {
					headers.add(CellReference.convertNumToColString(c));
					c++;
				}
			}
			if (CollectionUtils.isEmpty(headers)) {
				return null;
			}
			while (true) {
				Row row = sheet.getRow(r++);
				Map<String, Object> values = new HashMap<String, Object>();

				c = dataCol;
				for (String key : headers) {
					Cell cell = row.getCell(c);
					if (cell == null || cell.getCellType() == CellType.BLANK) {
						continue;
					}
					Object value = getCellValue(cell, evaluator);
					values.put(key, value);
				}
				if (values.isEmpty()) {
					break;
				}
				result.add(values);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				file.close();
			} catch (Exception e) {
			}
		}
		return result;
	}

	public static List getColumnData(String xlsFile, int startRow, int startCol, String columnName) {

		FileInputStream file = null;
		Workbook workbook = null;
		Sheet sheet = null;
		List result = new ArrayList();
		try {
			file = new FileInputStream(new File(xlsFile));

			if (xlsFile.endsWith(".xlsx")) {
				workbook = new XSSFWorkbook(file);
			} else {
				workbook = new HSSFWorkbook(file);
			}
			for (int sno = 0; true; sno++) {
				try {
					sheet = workbook.getSheetAt(sno);
				} catch (Exception e) {
					break;
				}
				if (sheet == null) {
					break;
				}
				FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();

				int dataRow = startRow, dataCol = startCol;
				boolean columnFound = false;
				if (dataRow == 0 || dataCol == 0) {
					for (dataRow = 0; dataRow < MAX_HEADER_ROW; dataRow++) {
						Row row = sheet.getRow(dataRow);
						if (row != null) {
							dataCol = 0;
							for (dataCol = 0; dataCol < MAX_DATA_COLUMNS; dataCol++) {
								Cell cell = row.getCell(dataCol);
								if (cell != null && cell.getCellType() != CellType.BLANK) {
									CellValue cellValue = evaluator.evaluate(cell);
									String hText = String.valueOf(cellValue.getStringValue());
									if (hText.equalsIgnoreCase(columnName)) {
										columnFound = true;
										break;
									}
								}
							}
						}
						if (columnFound) {
							break;
						}
					}
				}
				if (!columnFound) {
					dataRow = 0;
					for (dataCol = 0; dataCol < MAX_DATA_COLUMNS; dataCol++) {
						String c = CellReference.convertNumToColString(dataCol);
						if (columnName.equalsIgnoreCase(c)) {
							columnFound = true;
							break;
						}
					}
				}

				int rNo = dataRow;

				for (rNo = dataRow + 1; true; rNo++) {
					Row row = sheet.getRow(rNo);
					if (row == null) {
						break;
					}
					Cell cell = row.getCell(dataCol);
					if (cell != null && cell.getCellType() != CellType.BLANK) {
						Object value = getCellValue(cell, evaluator);
						if (value != null) {
							result.add(getCellValue(cell, evaluator));
						}
					} else {
						break;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				file.close();
			} catch (Exception e) {
			}
		}
		return result;
	}

	public static List getColumnData(String xlsFile, int startRow, int startCol, String[] headers, int[] sheetIndex) {
		InputStream file=null;
		List result = new ArrayList();
		try {
			file = new FileInputStream(new File(xlsFile));
			String xlsType=xlsFile.substring(xlsFile.lastIndexOf(".")+1);
			result=getColumnData(file, xlsType, startRow, startCol, headers, sheetIndex);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				file.close();
			} catch (Exception e) {
			}
		}
		return result;
	}
	
	public static List getColumnData(InputStream xlsFile, String excelType, int startRow, int startCol, String[] headers, int[] sheetIndex) {
		Workbook workbook = null;
		Sheet sheet = null;
		int dataCols[] = new int[headers.length];

		List result = new ArrayList();
		try {

			if (excelType.equalsIgnoreCase(TYPE_XLSX)) {
				workbook = new XSSFWorkbook(xlsFile);
			} else {
				workbook = new HSSFWorkbook(xlsFile);
			}
			// Initializing the datacol with -1
			for (int i = 0; i < dataCols.length; i++) {
				dataCols[i] = -1;
			}

			for (int index: sheetIndex) {
				try {
					sheet = workbook.getSheetAt(index);
				} catch (Exception e) {
					throw e;
				}
				if (sheet == null) {
					throw new Exception("Worksheet is null or no worksheet found.");
				}
				FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();

				int dataRow = startRow, dataCol = startCol;
				boolean columnFound = false;
				if (dataRow == 0 || dataCol == 0) {
					for (dataRow = 0; dataRow < MAX_HEADER_ROW; dataRow++) {
						Row row = sheet.getRow(dataRow);
						if (row != null) {
							for (dataCol = 0; dataCol < MAX_DATA_COLUMNS; dataCol++) {
								Cell cell = row.getCell(dataCol);
								if (cell != null && cell.getCellType() != CellType.BLANK) {
									CellValue cellValue = evaluator.evaluate(cell);
									String hText = StringUtils.trim(String.valueOf(cellValue.getStringValue()));
									hText=StringUtils.trim(hText);
									for (int i = 0; i < headers.length; i++) {
										if (hText.equalsIgnoreCase(headers[i])) {
											dataCols[i] = dataCol;
											columnFound = true;
											break;
										}
									}
								}
							}
						}
						if (columnFound) {
							break;
						}
					}
				}
				if (!columnFound) {
					dataRow = 0;
					for (dataCol = 0; dataCol < MAX_DATA_COLUMNS; dataCol++) {
						String c = CellReference.convertNumToColString(dataCol);
						for (int i = 0; i < headers.length; i++) {
							if (headers[i].equalsIgnoreCase(c)) {
								dataCols[i] = dataCol;
								columnFound = true;
								break;
							}
						}
					}
				}

				int rNo = dataRow;

				for (rNo = dataRow + 1; true; rNo++) {
					Row row = sheet.getRow(rNo);
					if (row == null) {
						break;
					}
					Object[] values = new Object[dataCols.length];
					boolean blankRow = true;
					for (int i = 0; i < dataCols.length; i++) {
						dataCol = dataCols[i];
						if (dataCol >= 0) {
							Cell cell = row.getCell(dataCol);
							//LOGGER.info(dataCol+":"+(cell!=null?cell.getCellType():-100));
							if (cell != null && cell.getCellType() != CellType.BLANK) {
								if(cell.getCellType()==CellType.FORMULA){
									try{
										values[i] =getCellValue(cell,evaluator);
									}catch(Exception e){
										LOGGER.info(e.getMessage()+" - "+i+" - "+headers[i]);
									}
								}else{
									values[i] = getCellValue(cell);
								}
								if (values[i] != null) {
									blankRow = false;
								}
								//LOGGER.info(values[i]);
							}
						}
					}
					if (blankRow) {
						break;
					} else {
						result.add(values);
					}
				}
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		} finally {
			try {
				xlsFile.close();
			} catch (Exception e) {
			}
			try {
				workbook.close();
			} catch (Exception e) {
			}
		}
		return result;
	}

	public static void setCellValue(Cell cell, Object value) {
		if (value == null) {
			return;
		}
		if (value instanceof java.util.Date || value instanceof java.sql.Date) {
			cell.setCellValue((Date) value);
		} else if (value instanceof java.lang.Boolean) {
			cell.setCellValue((Boolean) value);
		} else if (value instanceof String) {
			cell.setCellValue((String) value);
		} else if (value instanceof java.lang.Double) {
			cell.setCellValue((Double) value);
		} else if (value instanceof java.lang.Long) {
			cell.setCellValue((Long) value);
		} else if (value instanceof java.lang.Float) {
			cell.setCellValue((Float) value);
		} else if (value instanceof java.lang.Integer) {
			cell.setCellValue((Integer) value);
		}
	}

	public static Object getCellValue(Cell cell, FormulaEvaluator evaluator) {

		CellValue cellValue = evaluator.evaluate(cell);
		if (cellValue == null) {
			return null;
		}
		Object value = null;
		if (cellValue.getCellType() == CellType.BOOLEAN) {
			value = cellValue.getBooleanValue();
		} else if (cellValue.getCellType() == CellType.NUMERIC) {
			if (DateUtil.isCellDateFormatted(cell)) {
				value = DateUtil.getJavaDate(cellValue.getNumberValue());
			} else {
				double cellval = cellValue.getNumberValue();
				int intVal=(int)cellval;
				if((cellval-intVal)>0) {
					value=cellval;
				}else {
					value=intVal;
				}
			}
		} else if (cellValue.getCellType() != CellType.BLANK) {
			value = cellValue.getStringValue();
		}
		return value;
	}

	public static Object getCellValue(Cell cell) {

		Object value = null;
		if(cell==null || cell.getCellType()==CellType.BLANK || cell.getCellType()==CellType.ERROR){
			return null;
		}
		
		if (cell.getCellType() == CellType.BOOLEAN) {
			value = cell.getBooleanCellValue();
		} else if (cell.getCellType() == CellType.NUMERIC) {
			if (DateUtil.isCellDateFormatted(cell)) {
				value = cell.getDateCellValue();
			} else {
				double cellval = cell.getNumericCellValue();
				
				int intVal=(int)cellval;
				if((cellval-intVal)>0) {
					value=cellval;
				}else {
					value=intVal;
				}
				//LOGGER.info("reading number : "+cellval+" - "+intVal+" - "+(cellval-intVal)+" - "+((cellval-intVal)>0));
			}
		} else if (cell.getCellType() != CellType.BLANK) {
			value = cell.getStringCellValue();
		}
		return value;
	}
	
	public static void main(String x[]) {

		/*String cols[]=new String[]{"S. No.","ID. No","Name","Designation", "Department","Access Key", "Residence City",	"Employment Status",
				"Joining Date",	"Processing Month", "Last CL Bal", "Last EL Bal", "Working Days", "Leave Days", "Days Present", "CLBal","ELBal",
				"Paid Days","Net CTC Per Month","Current Month CTC","PF Employer", "PF Employee","Basic","Gratuity","HRA","Technical Allowance",
				"Special Allowance",	"Arrear","Gross Salary", "TDS",	"Salary on hold",	"Net Salary Payable"};
		*/
//		String cols[]=new String[]{"Unit Code", "Section Code", "Personal No",	"Post Box",	"Rank No",	"Trade Code",	"Grade Code",	"Designation Code",	"Date Of Joining Unit",	"First Name",	"Middle Name",	"Last Name",	"Gender Code",	"Date Of Birth",	 "Caste Category Code",	"Mobile No","Email Id",
//				"GPF/NPS","GPF/NPS No",	"IDAM Access",	"Email Access",	"Digital Signing",	"eGov Access",	"PIS Access"};
//		List result=getColumnData("/Users/arjun/Downloads/OFB_Bulk_UserOnBoarding_V1.0.xlsx", 0, 0, cols,new int[]{0});
			String cols[]=new String[]{"Sl No", "Unit Code","Section Code","Short Description","Long Description"};
			List result=getColumnData("/Users/arjun/Documents/SRIT/Master data/masterdata-excels/Section-Master08092021.xlsx", 0, 0, cols,new int[]{0});
			
			for(String c:cols){
				System.out.print(c+", ");
			}
			System.out.println("");
			for(Object da:result){
				Object[] oa=(Object[])da;
				for(Object o:oa){
					System.out.print(String.valueOf(o)+",");
				}
				System.out.println("");
			}
			
			if (0 == 0) {
				System.exit(0);
			}
		/*Long storeId = 2l;
		Long categoryId = 1l;

		String path = "../product-sheet.xlsx";
		Properties mapping = new Properties();
		try {
			String propFile = "com/adjecti/cart/resource/product-xls-mapping.properties";

			if (storeId != null) {
				propFile = "com/adjecti/cart/resource/store-product-xls-mapping.properties";
			}
			mapping.load(XLSUtils.class.getClassLoader().getResourceAsStream(propFile));
		} catch (Exception e) {
			e.printStackTrace();
		}

		Class clazz = null;
		Map objects = XLSUtils.getObjects(path, null, Integer.parseInt(mapping.getProperty("header.row").trim()), clazz, mapping);
		 */
	}
}