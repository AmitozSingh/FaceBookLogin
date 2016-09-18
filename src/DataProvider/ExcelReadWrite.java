package DataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;










import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Hyperlink;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class ExcelReadWrite {

	int countoftestcase=1;
	public String ReadExcel(String FileName, String FileSheet,int row, int Colum) throws Exception
	{
		FileInputStream fs=new FileInputStream("C:\\Users\\SUNNY\\workspace\\FaceBookLogin\\"+FileName+".xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fs) ;
		XSSFSheet sh=wb.getSheet(FileSheet);
		XSSFRow rw=sh.getRow(row);
		XSSFCell cell=rw.getCell(Colum);
		String Value=cell.getStringCellValue();
		wb.close();
		return Value;
		
	}
	
	public void WriteExcel(String FileName, String FileSheet,int row, int Colum, String Data) throws Exception
	{
		FileInputStream fs=new FileInputStream("C:\\Users\\SUNNY\\workspace\\FaceBookLogin\\"+FileName+".xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fs) ;
		XSSFSheet sh=wb.getSheet(FileSheet);
		
		XSSFRow rw=sh.getRow(row);
		
		
		
		if(Data.equalsIgnoreCase("Fail"))
		{
			XSSFFont font = wb.createFont();
			font.setFontHeightInPoints((short) 15);
			font.setBold(true);
			font.setColor(HSSFColor.RED.index);
			
			XSSFCellStyle style = wb.createCellStyle();
			
			style.setFont(font);
			XSSFCell cell = rw.createCell(Colum);
			cell.setCellValue(Data);
			cell.setCellStyle(style);
		}
		else
		{
			XSSFFont font = wb.createFont();
			font.setBold(true);
			font.setColor(HSSFColor.GREEN.index);
			XSSFCellStyle style = wb.createCellStyle();
			style.setFont(font);
			XSSFCell cell = rw.createCell(Colum);
			cell.setCellValue(Data);
			cell.setCellStyle(style);
		}
		
		
		
		FileOutputStream fo =new FileOutputStream("C:\\Users\\SUNNY\\workspace\\FaceBookLogin\\"+FileName+".xlsx");
		wb.write(fo);
		System.out.println("Excel Write Down");
		wb.close();
		
		
	}
	
	public static void hyperlinkScreenshot(XSSFCell cell, String FileAddress){
	    XSSFWorkbook wb=cell.getRow().getSheet().getWorkbook();
	    CreationHelper createHelper = wb.getCreationHelper();
	    CellStyle hlink_style = wb.createCellStyle();
	    Font hlink_font = wb.createFont();
	    hlink_font.setUnderline(Font.U_SINGLE);
	    hlink_font.setColor(IndexedColors.BLUE.getIndex());
	    hlink_style.setFont(hlink_font);
	    Hyperlink hp = createHelper.createHyperlink(Hyperlink.LINK_FILE);
	    FileAddress=FileAddress.replace("\\", "/");
	    hp.setAddress(FileAddress);
	    cell.setHyperlink(hp);
	    cell.setCellStyle(hlink_style);
	
}
	/*@AfterClass
	public void WriteResultInExcel()
	{
		FileInputStream fs=new FileInputStream("C:\\Users\\SUNNY\\workspace\\FaceBookLogin\\"+FileName+".xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fs) ;
		XSSFSheet sh=wb.getSheet("Sheet1");
		int RowCount=sh.getPhysicalNumberOfRows();
		XSSFRow rw=sh.getRow(row);
	}*/
	/*@AfterClass*/
	public void ExcelHandler( String Status) throws Exception
	{
		System.out.println("Count is "+countoftestcase);	
	
	FileInputStream fs=new FileInputStream("C:\\Users\\SUNNY\\workspace\\FaceBookLogin\\"+"LoginDetail"+".xlsx");
	XSSFWorkbook wb=new XSSFWorkbook(fs) ;
	XSSFSheet sh=wb.getSheet("Sheet1");
	int RowCount=sh.getPhysicalNumberOfRows();
	/*System.out.println("count is :"+RowCount);
	for(int i=1;i<RowCount;i++)
	{
		XSSFRow row =sh.getRow(i);
		XSSFCell cell= row.createCell(3);
		cell.setCellValue("Pass");
		FileOutputStream fo =new FileOutputStream("C:\\Users\\SUNNY\\workspace\\FaceBookLogin\\"+"LoginDetail"+".xlsx");
		wb.write(fo);
		System.out.println("Excel Write Down");*/
		WriteExcel("LoginDetail", "Sheet1",countoftestcase, 3, Status);
		countoftestcase++;
		
		System.out.println("Count is "+countoftestcase);
		
/*	}*/
	/*wb.close();*/
	}
	
}
