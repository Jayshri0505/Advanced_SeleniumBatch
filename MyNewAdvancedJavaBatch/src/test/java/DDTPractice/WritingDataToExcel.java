package DDTPractice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WritingDataToExcel {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("C:\\Users\\hp\\eclipse-workspace\\MyNewAdvancedJavaBatch\\src\\test\\resources\\Book1.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.createSheet("DDT1").createRow(1).createCell(2).setCellValue("Selenium");
		FileOutputStream fos=new FileOutputStream("C:\\\\Users\\\\hp\\\\eclipse-workspace\\\\MyNewAdvancedJavaBatch\\\\src\\\\test\\\\resources\\\\Book1.xlsx");
		
		wb.write(fos);
		wb.close();
		System.out.println("Written Successfully");
		
	}

}
