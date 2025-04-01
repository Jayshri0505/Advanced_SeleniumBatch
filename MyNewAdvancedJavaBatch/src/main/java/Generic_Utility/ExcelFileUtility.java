package Generic_Utility;


	import java.io.FileInputStream;
	import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

	public class ExcelFileUtility {
		public String readingDataFromPropertyFile(String sheet,int rowNum,int cellNum) throws IOException {
			FileInputStream fis=new FileInputStream("C:\\Users\\hp\\eclipse-workspace\\MyNewAdvancedJavaBatch\\src\\test\\resources\\Book1.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheet).getRow(rowNum).getCell(cellNum).getStringCellValue();
		
		return data;
		}

	}


