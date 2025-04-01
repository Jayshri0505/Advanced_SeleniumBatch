package Practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;


import Generic_Utility.ExcelFileUtility;

public class Day11_UtilityByExcel {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
	
		ExcelFileUtility exutil=new ExcelFileUtility();
		
		String data1 = exutil.readingDataFromPropertyFile("DDT", 1, 2);
		String data2 = exutil.readingDataFromPropertyFile("DDT",1 ,3);
		System.out.println(data1);
		System.out.println(data2);
		
	}

}

