package Master_util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;

public class WriteExcelConfig 
{
	public String WriteExcelpath;
	public XSSFRow outRow;
	public XSSFRow writeRow;
	public WriteExcelConfig()
	{
		
	}
	public void writeheader(String WriteExcelpath, int writerowNum, int[] writecolNum, String[] Cell_value) throws Exception
	{
		File writefile= new File(WriteExcelpath);
		FileInputStream writecellstream=null;
		writecellstream = new FileInputStream(writefile);
		System.out.println("5.1");
		XSSFWorkbook workbook = new XSSFWorkbook(writecellstream);
		XSSFSheet writeSheet = workbook.getSheetAt(0);
		System.out.println("5.2");
		
		writeRow = writeSheet.createRow(0);
		
		for(int s=0;s<writecolNum.length;s++)
		{
			System.out.println("5.2" +s + Cell_value[s] + writecolNum[s]);
			XSSFCell writecell=writeRow.createCell(s);
			writecell.setCellType(writecell.CELL_TYPE_STRING);
			writecell.setCellValue(Cell_value[s]);
		}
		
		writecellstream.close();
		File writesrc=new File(WriteExcelpath);
		FileOutputStream foos=new FileOutputStream(writesrc);
		workbook.write(foos);
		foos.close();
		
		System.out.println("Excel File Header Written");
	}
	public void write(String WriteExcelpath, int writerowNum, int writecolNum, String Cell_value) throws Exception
	{
		File writefile= new File(WriteExcelpath);
		FileInputStream writecellstream=null;
		writecellstream = new FileInputStream(writefile);
		System.out.println("5.1");
		XSSFWorkbook workbook = new XSSFWorkbook(writecellstream);
		XSSFSheet writeSheet = workbook.getSheetAt(0);
		System.out.println("5.2");
		
		if(writeSheet.getLastRowNum() ==0 && writeSheet.getFirstRowNum()==0)
    	{
			
			writeRow = writeSheet.createRow(writerowNum);
    		System.out.println("row 0");
    	}
    	
    	// To get old rows
    	else if(writerowNum >= writeSheet.getFirstRowNum() && writerowNum <= writeSheet.getLastRowNum())
    	{
    		writeRow=writeSheet.getRow(writerowNum);
    		System.out.println("between");
    	}
    	//To Create other Rows
    	else
    	{
    		writeRow = writeSheet.createRow(writerowNum);
    		System.out.println("nothing" + writeSheet.getLastRowNum() + writeSheet.getFirstRowNum());
    	}
		XSSFCell writecell = writeRow.createCell(writecolNum);
		writecell.setCellType(writecell.CELL_TYPE_STRING);
		System.out.println("1114");
		writecell.setCellValue(Cell_value);
		System.out.println("1114");
		
		writecellstream.close();
		System.out.println("1115");
		File writesrc=new File(WriteExcelpath);
		System.out.println("1116");
		FileOutputStream foos=new FileOutputStream(writesrc);
		System.out.println("1117");
		workbook.write(foos);
		System.out.println("1118");
		foos.close();
		System.out.println("1119");
		
		System.out.println("Excel File Written. WriteExcelas");
	}
	
	public void write(String ReadExcelpath,String WriteExcelpath, int rowNum, int colNum, int newrowNum, int newcolNum) throws Exception 
	{
		
		//WriteExcelpath="C:\\Users\\prabakar.inmaa\\Desktop\\JIRA_EXCEL_INPUT\\BookDAILYENTRY.xlsx";
		//FileInputStream excellFile1=null;
		//ReadExcelpath="C:\\Users\\prabakar.inmaa\\Downloads\\AAA Moved To QA (NewAge Software and Solutions).xlsx";
		System.out.println("1");
		FileInputStream excellFile1 = new FileInputStream(new File(ReadExcelpath));
		System.out.println("2");
		XSSFWorkbook workbook = new XSSFWorkbook(excellFile1);
		System.out.println("3");
        // Get first/desired sheet from the workbook
        XSSFSheet insheet = workbook.getSheetAt(0);
        System.out.println("4");
        
        File outFile=null;
        outFile = new File(WriteExcelpath);
        System.out.println("5");
        
        XSSFWorkbook outWorkbook;
        outWorkbook = WriteExcel(outFile, insheet, rowNum, colNum, newrowNum, newcolNum);
        
        //outFile=null;
        excellFile1.close();
		workbook.close();
		System.out.println("6");
		
		
        //System.out.println("6");
        
		if (!outFile.exists()) 
        {
            outFile.createNewFile();
        }
        
		System.out.println("8");
        FileOutputStream out=null;
        System.out.println("9");
        out = new FileOutputStream(outFile);
        System.out.println("10");
        outWorkbook.write(out);
        System.out.println("11");
        out.close();
        System.out.println("Cell Written success");
		
	}
	public XSSFWorkbook WriteExcel(File file, XSSFSheet sheet, int rowNum, int colNum, int newrowNum, int newcolNum) throws IOException
	{
	
		
		FileInputStream excellFilex=null;
		excellFilex = new FileInputStream(file);
		System.out.println("5.1");
		XSSFWorkbook workbook = new XSSFWorkbook(excellFilex);
		XSSFSheet outSheet = workbook.getSheetAt(0);
		System.out.println("5.2");
		
		
		
		
		Map<Integer, XSSFCellStyle> styleMap = new HashMap<Integer, XSSFCellStyle>();
	
		System.out.println("old row present or not " + outSheet.getLastRowNum() + outSheet.getFirstRowNum() + rowNum);
		

    	
    	// To create new Row First time
    	if(outSheet.getLastRowNum() ==0 && outSheet.getFirstRowNum()==0)
    	{
    		outRow = outSheet.createRow(newrowNum);
    		System.out.println("row 0");
    	}
    	
    	// To get old rows
    	else if(newrowNum >= outSheet.getFirstRowNum() && newrowNum <= outSheet.getLastRowNum())
    	{
    		outRow=outSheet.getRow(newrowNum);
    		System.out.println("between");
    	}
    	//To Create other Rows
    	else
    	{
    		outRow = outSheet.createRow(newrowNum);
    		System.out.println("nothing" + outSheet.getLastRowNum() + outSheet.getFirstRowNum() + rowNum);
    	}

        // To get the old sheet row number
        XSSFRow row = sheet.getRow(rowNum);
        System.out.println("5.3");
    	XSSFCell outCell = outRow.createCell(newcolNum);
    	System.out.println("5.4");
        XSSFCell cell = row.getCell(colNum);
        System.out.println("5.5");
        if (cell != null) 
        {
            if (cell.getSheet().getWorkbook() == outCell.getSheet().getWorkbook()) 
            {
                outCell.setCellStyle(cell.getCellStyle());
                System.out.println("5.6");
                
            } 
            else 
            {
                int stHashCode = cell.getCellStyle().hashCode();
                XSSFCellStyle newCellStyle = styleMap.get(stHashCode);
                
                if (newCellStyle == null) 
                {
                    newCellStyle = outCell.getSheet().getWorkbook().createCellStyle();
                    newCellStyle.cloneStyleFrom(cell.getCellStyle());
                    styleMap.put(stHashCode, newCellStyle);
                }
                outCell.setCellStyle(newCellStyle);
            }
            switch (cell.getCellType()) 
            {
            case HSSFCell.CELL_TYPE_FORMULA:
                outCell.setCellFormula(cell.getCellFormula());
                break;
            case HSSFCell.CELL_TYPE_NUMERIC:
                outCell.setCellValue(cell.getNumericCellValue());
                break;
            case HSSFCell.CELL_TYPE_STRING:
                outCell.setCellValue(cell.getStringCellValue());
                break;
            case HSSFCell.CELL_TYPE_BLANK:
                outCell.setCellType(HSSFCell.CELL_TYPE_BLANK);
                break;
            case HSSFCell.CELL_TYPE_BOOLEAN:
                outCell.setCellValue(cell.getBooleanCellValue());
                break;
            case HSSFCell.CELL_TYPE_ERROR:
                outCell.setCellErrorValue(cell.getErrorCellValue());
                break;
            default:
                outCell.setCellValue(cell.getStringCellValue());
                break;
            }
            
        }
        System.out.println("5.9");
	    excellFilex.close();
	    System.out.println("5.10");
	    return workbook;
	}

}
