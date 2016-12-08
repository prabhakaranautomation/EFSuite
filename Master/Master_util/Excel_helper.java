package Master_util;

import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_helper 
{
	private String filepath;
	private FileInputStream fis;
	private Workbook workbook;
	
	private int datasetStartRowNumber=-1;
	private int datesetEndRowNumber=0;
	private int datasetLastColumnNumber=0;
	
	public Excel_helper(String filepath)
	{
		this.filepath=filepath;
		try
		{
			fis=new FileInputStream(filepath);
			workbook=WorkbookFactory.create(fis);
			System.out.println("excel file init done");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("excel file init fail " +e.getMessage());
		}
		
	}
	public int getfirstRowNumber(String sheetname,int testNameColumn, String testName)
	{
		
		Row row;
		String cell = null;
		
		Sheet sh=workbook.getSheet(sheetname);
		//System.out.println(" getfirstRowNumber sheet got init ");
			
		Iterator<Row> rowIterator = sh.iterator();
		
		while(rowIterator.hasNext()) 
		{
	        row = rowIterator.next();
	        //System.out.println("ROWs " +row.getRowNum());
			try 
			{
				cell = row.getCell(0).getStringCellValue(); //testNameColumn
				//System.out.println("cell value " +cell);
			} 
			catch (Exception e) 
			{
				//System.out.println("cell fail  " +e.getMessage());
			}
	        if(cell!=null && cell.equals(testName))
	        {
	        	if(datasetStartRowNumber==-1)
	        	{
	        		//System.out.println("found Ro " +row.getRowNum());
	        		datasetStartRowNumber=row.getRowNum();
	        	}
	        }
	        else
	        {
	        	//System.out.println("not equal to test name " +row.getRowNum());
	        }
	        
		}
			
		return datasetStartRowNumber;
	}
	public int getlastRownumber(String sheetname,int testStartRowNumber, String testName)
	{
		Row row;
		String cell = null;
		
		Sheet sh=workbook.getSheet(sheetname);
		//System.out.println(" getlastRownumber sheet got init ");
		
		//datasetStartRowNumber
		Iterator<Row> rowIterator = sh.iterator();
		
		while(rowIterator.hasNext()) 
		{
	        row = rowIterator.next();
	        //System.out.println("ROWs " +row.getRowNum());
			
	        try 
			{
				cell = row.getCell(0).getStringCellValue(); //testNameColumn
				//System.out.println("cell value " +cell);
			} 
			catch (Exception e) 
			{
				//System.out.println("cell fail  " +e.getMessage());
			}
			
			
			
	        if(cell!=null && cell.equals(testName))
	        {

        		//System.out.println("found Ro " +row.getRowNum());
        		datesetEndRowNumber=row.getRowNum();
	        }
	        else
	        {
	        	//System.out.println("not equal to test name " +row.getRowNum());
	        }
		
		}
		return datesetEndRowNumber;
	}
	public int getlastColumnnumber(String sheetname,int testStartRowNumber, String testName)
	{
		Sheet sh=workbook.getSheet(sheetname);
		//System.out.println(" getlastColumnnumber sheet got init ");
		
		if(sh.getRow(testStartRowNumber).getCell(0).getStringCellValue().equals(testName))
		{
			//System.out.println("get 2 ");
			datasetLastColumnNumber =sh.getRow(testStartRowNumber).getLastCellNum();
			//System.out.println("get 3 ");
		}
		//System.out.println("getlastColumnnumber completed ");
		return datasetLastColumnNumber;
		
	}
	public Object[][] getDataset(String sheetname,int testFirstRowNumber, int testlastRowNumber, int testDatastartColumn, int testDataEndColumn, String testName)
	{
		Sheet sh=workbook.getSheet(sheetname);
		//System.out.println(" getDataset sheet got init ");
		
		Object[][] loginas=new String[testlastRowNumber-testFirstRowNumber][testDataEndColumn-1];
		//3,3
		for(int i=0;i<(testlastRowNumber-testFirstRowNumber);i++)
		{
			for(int j=0;j<(testDataEndColumn-1);j++)
			{
				Cell cell =sh.getRow(testFirstRowNumber+1+i).getCell(testDatastartColumn+j);
				
				switch (cell.getCellType()) 
		        {
		        case HSSFCell.CELL_TYPE_FORMULA:
		        	loginas[i][j]=cell.getCellFormula();
		            break;
		        case HSSFCell.CELL_TYPE_NUMERIC:
		        	loginas[i][j]=cell.getNumericCellValue();
		            break;
		        case HSSFCell.CELL_TYPE_STRING:
		        	loginas[i][j]=cell.getStringCellValue();
		            break;
		        case HSSFCell.CELL_TYPE_BLANK:
		        	loginas[i][j]=(HSSFCell.CELL_TYPE_BLANK);
		            break;
		        case HSSFCell.CELL_TYPE_BOOLEAN:
		        	loginas[i][j]=cell.getBooleanCellValue();
		            break;
		        case HSSFCell.CELL_TYPE_ERROR:
		        	loginas[i][j]=cell.getErrorCellValue();
		            break;
		        default:
		        	loginas[i][j]=cell.getStringCellValue();
		            break;
		        }
		            
				//loginas[i][j]=sh.getRow(testFirstRowNumber+1+i).getCell(testDatastartColumn+j).getStringCellValue();
				
				System.out.println("---------------- "+ loginas[i][j]);
			}
		}
		return loginas;
	}
	
	
	/**
	public int rowcount(int sheetNumber,int column) throws Exception //
	{
		try 
		{
			Sheet sheet1=workbook.getSheetAt(sheetNumber);
			//sheet1=workbook.getSheetAt(sheetNumber);
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
	**/
}
