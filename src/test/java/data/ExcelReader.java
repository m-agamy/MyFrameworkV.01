package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	/*public static void main(String[] args) throws IOException {
		
	getExcelData("UserRegistrationData",4);
	}*/
	
	static FileInputStream fis;
	
	public Object[][] getExcelData(String sheetName,int Coulms) throws IOException{
		
		//String excelFilePath = System.getProperty("user.dir")+"src/test/java/data/userData.xlsx";
		File excelFile=new File("D:\\QC\\selunim work\\Taf\\src\\test\\java\\data\\userData.xlsx");
		fis = new FileInputStream(excelFile);
		
		XSSFWorkbook wb= new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet(sheetName);
	
		int numOfRows= (sheet.getLastRowNum()+1);
		//System.out.println(sheet.getLastRowNum());
	///	System.out.println(numOfRows);
		int numOfCoulms= Coulms;
		
		String excelDataArr [][] = new String [numOfRows][numOfCoulms];
		
		for (int i = 0; i < numOfRows; i++) {
			for (int j = 0; j < numOfCoulms; j++) {
				excelDataArr[i][j]= sheet.getRow(i).getCell(j).toString();
				//System.out.println(excelDataArr[i][j]);
			}
		}
		wb.close();
		return excelDataArr ;
	}

}