package utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;

import config.Constants;

public class ExcelRWData {
	private static HSSFSheet ExcelWSheet;
	private static HSSFWorkbook ExcelWBook;
	private static HSSFCell Cell;
	private static HSSFRow Row;

	//This method is to set the File path and to open the Excel file
	//Pass Excel Path and SheetName as Arguments to this method
	public static void setExcelFile(String Path) throws Exception {
		try {
			FileInputStream ExcelFile = new FileInputStream(Path);
			System.out.println(Path+ " is set");
			ExcelWBook = new HSSFWorkbook(ExcelFile);
		}
		catch(Exception e) {
			Log.error("Class Utils | Method setExcelFile | Exception desc : "+e.getMessage());
			//			DriverScript.bResult = false;
		}
	}

	//This method is to read the test data from the Excel cell
	//In this we are passing parameters/arguments as Row Num and Col Num
	public static String getCellData(int RowNum, int ColNum, String SheetName) throws Exception{
		ExcelWSheet = ExcelWBook.getSheet(SheetName);
		System.out.println("Excel Work Sheet "+ExcelWSheet);
		try{
			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			System.out.println(Cell);
			String CellData = Cell.getStringCellValue();
			System.out.println("Cell data is "+CellData);
			return CellData;
		}catch (Exception e){
			Log.error("Class Utils | Method getCellData | Exception desc : "+e.getMessage());
			//			DriverScript.bResult = false;
			return"";
		}
	}
	//This method is to get the row count used of the excel sheet
	public static int getRowCount(String SheetName){
		int number=0;
		try {
			ExcelWSheet = ExcelWBook.getSheet(SheetName);
			number=ExcelWSheet.getLastRowNum()+1;
		}
		catch(Exception e) {
			Log.error("Class Utils | Method getRowCount | Exception desc : "+e.getMessage());
			//			DriverScript.bResult = false;
		}
		return number;
	}

	//This method is to get the Row number of the test case
	//This methods takes three arguments(Test Case name , Column Number & Sheet name)
	public static int getRowContains(String sTestCaseName, int colNum,String SheetName) throws Exception{
		int i = 0; 
		try {
			ExcelWSheet = ExcelWBook.getSheet(SheetName);
			int rowCount = ExcelRWData.getRowCount(SheetName);
			//			System.out.println("Row count is "+rowCount);
			for (; i<rowCount; i++){
				if  (ExcelRWData.getCellData(i,colNum,SheetName).equalsIgnoreCase(sTestCaseName)){
					break;
				}
			}
		}
		catch(Exception e){
			Log.error("Class Utils | Method getRowContains | Exception desc : "+e.getMessage());
			//			DriverScript.bResult = false;
		}
		//		System.out.println("Row value is "+i);
		return i;
	}

	//This method is to get the count of the test steps of test case
	//This method takes three arguments (Sheet name, Test Case Id & Test case row number)
	public static int getTestStepsCount(String SheetName, String sTestCaseID, int iTestCaseStart) throws Exception{
		try {
			for(int i=iTestCaseStart;i<=ExcelRWData.getRowCount(SheetName);i++){
				if(!sTestCaseID.equals(ExcelRWData.getCellData(i, Constants.Col_TestCaseID, SheetName))){
					int number = i;
					return number;
				}
			}
			ExcelWSheet = ExcelWBook.getSheet(SheetName);
			int number=ExcelWSheet.getLastRowNum()+1;
			return number;
		}
		catch(Exception e) {
			Log.error("Class Utils | Method getTestStepsCount | Exception desc : "+e.getMessage());
			//			DriverScript.bResult = false;
			return 0;
		}

	}

	//	This method is used to set Test Result
	public static void setTestResult(String SheetName, int rowNum, int colNum, String Result) {
		try {
			ExcelWSheet = ExcelWBook.getSheet(SheetName);
			Row = ExcelWSheet.getRow(rowNum);
//			Cell = Row.getCell(colNum, Row.RETURN_BLANK_AS_NULL);
			Cell = Row.getCell(colNum, MissingCellPolicy.RETURN_BLANK_AS_NULL);
			if(Cell == null) {
				Cell = Row.createCell(colNum);
				Cell.setCellValue(Result);
				System.out.println("Cell value was null, "+Result+" set");
			}
			else
			{
				Cell.setCellValue(Result);
				System.out.println("Cell value set to "+Result);
			}
			FileOutputStream fileOut = new FileOutputStream(Constants.Path_Testdata);
			ExcelWBook.write(fileOut);
			fileOut.close();
			ExcelWBook = new HSSFWorkbook(new FileInputStream(Constants.Path_Testdata));
		}
		catch(Exception e) {
			e.printStackTrace();
			//			DriverScript.bResult = false;
		}
	}


}
