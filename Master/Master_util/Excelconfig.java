package Master_util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelconfig 
{
	private XSSFWorkbook wb;
	
	private XSSFSheet sheet1;
	private FileInputStream fis;
	public Excelconfig(String excelpath) throws IOException
	{
		File src=new File(excelpath);
		FileInputStream fis=new FileInputStream(src);
		wb=new XSSFWorkbook(fis);
			
	}
	
	/**
	public void write(String excelpath1, String xxx) throws Exception 
	{
		sheet1=wb.getSheetAt(0);
		//Row row=sheet1.getRow(20);
		Row newRow = sheet1.createRow(20);
		Cell cell=newRow.createCell(1);
		cell.setCellType(cell.CELL_TYPE_STRING);
		cell.setCellValue(xxx);
		
		File src=new File(excelpath1);
		FileOutputStream fos=new FileOutputStream(src);
		wb.write(fos);
		fos.close();
		System.out.println("Excel File Written XXX");
		
	}
	**/
	public void WriteExcelas(String Write_Excel_Path, int Sheetnumber, int RowNum, int ColNum, String Cell_value) throws Exception
	{
		try 
		{
			File src1=new File(Write_Excel_Path);
			FileInputStream fis1=new FileInputStream(src1);
			XSSFWorkbook wb1=new XSSFWorkbook(fis1);
			
			XSSFSheet sheet11=wb1.getSheetAt(Sheetnumber);
			System.out.println("1111");
			//Row row=sheet1.getRow(RowNum);
			//Row newRow = sheet1.createRow(RowNum);
			//Due to already we have created Row 
			Row newRow = sheet1.getRow(RowNum);
			System.out.println("1112");
			System.out.println("ff" + sheet11.getRow(RowNum).getCell(ColNum).getStringCellValue());
			System.out.println("1112.3");
			Cell cell=newRow.createCell(ColNum);
			System.out.println("1113");
			
			cell.setCellType(cell.CELL_TYPE_STRING);
			System.out.println("1114");
			cell.setCellValue(Cell_value);
			System.out.println("1114");
			fis1.close();
			System.out.println("1115");
			
			File writesrc=new File(Write_Excel_Path);
			System.out.println("1116");
			FileOutputStream fos=new FileOutputStream(writesrc);
			System.out.println("1117");
			wb.write(fos);
			System.out.println("1118");
			fos.close();
			System.out.println("1119");
			
			System.out.println("Excel File Written. WriteExcelas");
		} 
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
	}
	public void OutputStream(String Write_Excel_Path) throws IOException
	{
		fis.close();
		File writesrc=new File(Write_Excel_Path);
		FileOutputStream fos=new FileOutputStream(writesrc);
		wb.write(fos);
		fos.close();
	}
	public void WriteExcelasdate(String Write_Excel_Path, int Sheetnumber, int RowNum, int ColNum, String Date_value) throws Exception
	{
		sheet1=wb.getSheetAt(Sheetnumber);
		//Row row=sheet1.getRow(RowNum);
		Row newRow = sheet1.createRow(RowNum);
		Cell cell=newRow.createCell(ColNum);
		cell.setCellType(cell.CELL_TYPE_NUMERIC);
		cell.setCellValue(Date_value);
		
		File writesrc=new File(Write_Excel_Path);
		FileOutputStream fos=new FileOutputStream(writesrc);
		wb.write(fos);
		fos.close();
		System.out.println("Excel File Written. WriteExcelasdate");
	}
	
	public int rowcount(int sheetNumber,int column) throws Exception //
	{
		try 
		{
			sheet1=wb.getSheetAt(sheetNumber);
			int rowcount=sheet1.getLastRowNum();
			return rowcount;
			
		} 
		catch (Exception e) 
		{
			throw (e);
			//System.out.println(e.getMessage());
		}
	}
	public int get_rows() throws Exception
	{
		
	return sheet1.getPhysicalNumberOfRows();
	}
	// This method to get the data and get the value as strings.
	public String getCellDataasstring(String sheetName,int RowNum, int ColNum) throws Exception
	{
		try
		{
			sheet1=wb.getSheet(sheetName);
			String CellData =sheet1.getRow(RowNum).getCell(ColNum).getStringCellValue();
			System.out.println("The value of CellData " + CellData);
			return CellData;
		}
		catch (Exception e) 
		{
			throw (e);
			//System.out.println(e.getMessage());
		}
	}
	// This method to get the data and get the value as number.
	public double getCellDataasnumber(String sheetName,int RowNum, int ColNum) throws Exception
	{
		try
		{
			sheet1=wb.getSheet(sheetName);
			double CellData =sheet1.getRow(RowNum).getCell(ColNum).getNumericCellValue();
			System.out.println("The value of CellData " + CellData);
			return CellData;
		}
		catch (Exception e)
		{
			return 000.00;
			//System.out.println(e.getMessage());
		}
	}

	public String getdata(String excelpath, int sheetNumber,int row,int column) throws IOException
	{
				File src=new File(excelpath);
				FileInputStream fis=new FileInputStream(src);
				wb=new XSSFWorkbook(fis);
				
				sheet1=wb.getSheetAt(sheetNumber);
				
				if(sheet1.equals(""))
				{
					return ("");
				}
				else
				{
					String data=sheet1.getRow(row).getCell(column).getStringCellValue();
					return data;
				}
				
	}
	public int getCelltype(String sheetName,int RowNum, int ColNum) throws Exception
	{

			sheet1=wb.getSheet(sheetName);
			int CellDatatype =sheet1.getRow(RowNum).getCell(ColNum).getCellType();
			System.out.println("The value of CellData " + CellDatatype);
			return CellDatatype;
	
	}
	public String getCellDataasdate(String sheetName,int RowNum, int ColNum) throws Exception
	{
		try
		{
			DateFormat df = new SimpleDateFormat("dd/MMM/yyyy");   //HH:mm:ss
			sheet1=wb.getSheet(sheetName);
			java.util.Date CellData = sheet1.getRow(RowNum).getCell(ColNum).getDateCellValue();
			String reportDate = df.format(CellData);
			return reportDate;
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		return null;
	}
}