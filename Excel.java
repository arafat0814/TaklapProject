package utility;

import utility.FileUtils;
import java.util.ArrayList;
import java.util.Map;

public class Excel {
	private ExcelReader excelManager;
	private ArrayList<Map<String, String>> filteredRows;

	// CONSTRUCTOR
	public Excel(String excelName) {
		excelManager = new ExcelReader(FileUtils.getExcelPath(excelName));
		this.filteredRows = null;
	}

	/**
	 * Filters the rows in the specified sheet that contained in the excel
	 * 
	 * @param sheetname
	 *            desired sheet name in the excel
	 * @param headerCol
	 *            header column
	 * @param actualCol
	 *            actual column value that needs to be filterd with
	 * @return filtered excel rows
	 */
	public Excel withSheetFilter(String sheetname, String headerCol, String actualCol) {
		ArrayList<Map<String, String>> content = excelManager.returnExcelContent(sheetname);
		filteredRows = excelManager.getdata(content, headerCol, actualCol);
		return this;
	}

	/**
	 * Filters the excel content with the rows specified with header column and its
	 * value
	 * 
	 * @param headerColumn
	 *            header column name
	 * @param actualColumnValue
	 *            actual column value
	 * @return returns rows that are filtered with actual column value
	 */
	public Excel withFilter(String headerColumn, String actualColumnValue) {
		ArrayList<Map<String, String>> content = excelManager.returnExcelContent();
		filteredRows = excelManager.getdata(content, headerColumn, actualColumnValue);
		return this;
	}

	/**
	 * From the header row, gets the column value specified by the headColumString
	 * parameter
	 * 
	 * @param headColumnString
	 *            target head column String
	 * @return value of column given by the headColumnString
	 */
	public String getColValueFilterd(String headColumnString) {
		if (this.filteredRows == null) {
			throw new NullPointerException(
					"At dart.utility.excel.Excels: You must first call withFilter() or withSheetFilter() method.");
		}

		if (this.filteredRows.size() > 1) {
			throw new IllegalArgumentException(
					"PATH: dart.utility.excel: Excels Class. Filterd Excel has more than one rows, please use method: getValue(int, String)");
		}

		return this.filteredRows.get(0).get(headColumnString);
	}

	/**
	 * From the specified row by index, gets the column value specified by the
	 * headColumString parameter
	 * 
	 * @param rowIdx
	 *            target row index
	 * @param headColumnString
	 *            target head column String
	 * @return value of column given by the headColumnString
	 */
	public String getColValueFilterd(int rowIdx, String headColumnString) {
		if (this.filteredRows == null) {
			throw new NullPointerException(
					"PATH: dart.utility.excel: Excels Class. You must first call filterRows() method.");
		}
		return this.filteredRows.get(rowIdx).get(headColumnString);
	}
}
