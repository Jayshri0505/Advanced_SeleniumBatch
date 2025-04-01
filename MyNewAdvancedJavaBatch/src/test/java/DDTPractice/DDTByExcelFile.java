package DDTPractice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class DDTByExcelFile {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
	
		FileInputStream fis=new FileInputStream("C:\\Users\\hp\\eclipse-workspace\\MyNewAdvancedJavaBatch\\src\\test\\resources\\Book1.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		
		
		String data1 = wb.getSheet("DDT").getRow(1).getCell(2).getStringCellValue();

		String data2 = wb.getSheet("DDT").getRow(1).getCell(3).getStringCellValue();
		System.out.println(data1);
		System.out.println(data2);
		
	}

}
