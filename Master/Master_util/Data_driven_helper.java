package Master_util;

public class Data_driven_helper extends Excel_helper 
{
	public final static int testNameColumn =1;
	
	public final static int testDatastartColumn =1;
	
	public Data_driven_helper(String filepath)
	{
		super(filepath);
	}
	
	public Object[][] getTestCaseDataSets(String sheetname, String testName)
	{
		int testFirstRowNumber=getfirstRowNumber(sheetname,testNameColumn,testName);//3
		//System.out.println("from Date driven testFirstRowNumber "+testFirstRowNumber);
		
		int testlastRowNumber =getlastRownumber(sheetname, testFirstRowNumber, testName);
		//System.out.println("from Date driven testlastRowNumber "+testlastRowNumber);
		
		//testDatastartColumn
		//System.out.println("from Date driven testDatastartColumn "+testDatastartColumn);
		
		int testDataEndColumn = getlastColumnnumber(sheetname, testFirstRowNumber, testName);
		//System.out.println("from Date driven testDataEndColumn "+testDataEndColumn);
		
		Object[][] aa=getDataset(sheetname,testFirstRowNumber, testlastRowNumber, testDatastartColumn, testDataEndColumn, testName);
		
		return aa;
	}
}
