package SprintFirst;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class dataProvider {
	
	
	public static void main(String[] args) throws IOException {
		XSSFWorkbook workbook = new XSSFWorkbook("./data/Login.xlsx");
		XSSFSheet sheet = workbook.getSheetAt(0);
		int rowcount = sheet.getLastRowNum();
		for (int i =0; i<=rowcount; i++) {
			XSSFRow row = sheet.getRow(i);
			int colcount = row.getLastCellNum();
			System.out.println(colcount);
			for(int j =0; j<colcount;j++) {
				String text = row.getCell(j).getStringCellValue();
				System.out.println(text);
			}
			workbook.close();
		}
	
		
		
	}

}
