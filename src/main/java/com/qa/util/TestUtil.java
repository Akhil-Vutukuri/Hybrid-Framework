package com.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TestUtil extends BaseTest {
	static int PAGE_LOAD_TIMEOUT = 20;
	static int IMPLICIT_WAIT = 30;
	
	static String filePath2 = "E:\\Akhil's\\actiTimePOMCucumber\\src\\main\\java\\com\\qa\\testdata\\actiTIME_TestData.xlsx";
	
	/* this is a generic method to switch into a frame.
	 * public void switchToFrame() {
	 *  driver.switchTo().frame(nameOrId);
	 * }
	 */
	/*
	 * public static String TESTDATA_SHEET_PATH =
	 * "/Users/naveenkhunteta/Documents/workspace" +
	 * "/FreeCRMTest/src/main/java/com/crm/qa/testdata/FreeCrmTestData.xlsx";
	 * 
	 * static Workbook book; static org.apache.poi.ss.usermodel.Sheet sheet;
	 * 
	 * public static Object[][] getTestData(String sheetName) { FileInputStream file
	 * = null; try { file = new FileInputStream(TESTDATA_SHEET_PATH); } catch
	 * (FileNotFoundException e) { e.printStackTrace(); } try { book =
	 * WorkbookFactory.create(file); } catch (InvalidFormatException e) {
	 * e.printStackTrace(); } catch (IOException e) { e.printStackTrace(); } sheet =
	 * book.getSheet(sheetName); Object[][] data = new
	 * Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()]; //
	 * System.out.println(sheet.getLastRowNum() + "--------" + //
	 * sheet.getRow(0).getLastCellNum()); for (int i = 0; i < sheet.getLastRowNum();
	 * i++) { for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
	 * data[i][k] = sheet.getRow(i + 1).getCell(k).toString(); //
	 * System.out.println(data[i][k]); } } return data; }
	 */

	public static String read_Data_from_XLsheet(String filePath , String sheetName, int row, int cell)
	{
		String data = "";
		
		Workbook workbook;
		try {
			workbook = WorkbookFactory.create(new FileInputStream(filePath));
			data =  workbook.getSheet(sheetName).getRow(row).getCell(cell).toString();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
	
	public static int get_Row_Size(String FilePath, String sheetName)
	{
		int rowCount = 0;
		
		Workbook workbook;
		try {
			workbook = WorkbookFactory.create(new FileInputStream(FilePath));
			rowCount = workbook.getSheet(sheetName).getLastRowNum();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowCount;
	}
	
	public static void takeScreenShot(WebDriver driver , String filepath)
	{
		try {
			TakesScreenshot ts = (TakesScreenshot)driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			File des = new File(filepath);
			FileUtils.copyFile(src, des);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*
	 * public static void takeScreenshotAtEndOfTest() throws IOException { File
	 * scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE); String
	 * currentDir = System.getProperty("user.dir");
	 * 
	 * FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" +
	 * System.currentTimeMillis() + ".png"));
	 * 
	 * }
	 */

}
