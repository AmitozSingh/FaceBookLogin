package Core;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import DataProvider.ExcelReadWrite;

public class TextExcel  extends ExcelReadWrite{

	@Test
	public void ExcelHandler() throws Exception
	{
		
	
	FileInputStream fs=new FileInputStream("C:\\Users\\SUNNY\\workspace\\FaceBookLogin\\"+"LoginDetail"+".xlsx");
	XSSFWorkbook wb=new XSSFWorkbook(fs) ;
	XSSFSheet sh=wb.getSheet("Sheet1");
	int RowCount=sh.getPhysicalNumberOfRows();
	System.out.println("count is :"+RowCount);
	for(int i=1;i<RowCount;i++)
	{
		/*XSSFRow row =sh.getRow(i);
		XSSFCell cell= row.createCell(3);
		cell.setCellValue("Pass");
		FileOutputStream fo =new FileOutputStream("C:\\Users\\SUNNY\\workspace\\FaceBookLogin\\"+"LoginDetail"+".xlsx");
		wb.write(fo);
		System.out.println("Excel Write Down");*/
		WriteExcel("LoginDetail", "Sheet1",i, 3, "Pass");
		
	}
	wb.close();
	}
}
