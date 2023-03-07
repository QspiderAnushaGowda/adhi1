package Generic_utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * method is used to read the data from excel file
 * @author adhi1
 *
 */
public class Excel_Utility {

	public String getExcelData(String sheetName,int rowNum, int celNum) throws Throwable
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/OrganizationName.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		String value = book.getSheet(sheetName).getRow(rowNum).getCell(celNum).getStringCellValue();
		return value;
	}
}
