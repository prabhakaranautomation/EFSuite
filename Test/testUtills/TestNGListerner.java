//package testUtills;
//
//import java.io.File;
//import java.io.IOException;
//import java.nio.file.Path;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Calendar;
//import java.util.Date;
//import java.util.GregorianCalendar;
//import java.util.List;
//import java.util.Map;
//
//import org.apache.commons.io.FileUtils;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.testng.IReporter;
//import org.testng.IResultMap;
//import org.testng.ISuite;
//import org.testng.ISuiteResult;
//import org.testng.ITestContext;
//import org.testng.ITestListener;
//import org.testng.ITestResult;
//import org.testng.xml.XmlSuite;
//
//import com.relevantcodes.extentreports.ExtentReports;
//import com.relevantcodes.extentreports.ExtentTest;
//import com.relevantcodes.extentreports.LogStatus;
//
//
//public class TestNGListerner extends Utills implements ITestListener,IReporter
//{
//	
//	
//	@Override
//	public void onFinish(ITestContext result) 
//	{
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void onStart(ITestContext result) {
//		
//		
//	}
//
//	@Override
//	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void onTestFailure(ITestResult result) 
//	{
//		
//		if(!result.isSuccess())
//		{
//			String Userdirector=System.getProperty("user.dir");
//			String customelocation="\\ScreenShots\\";
//			
//			String failureImageFileName= Userdirector+customelocation
//					+new SimpleDateFormat("MM-dd-yyyy_HH-ss")
//					.format(new GregorianCalendar().getTime())
//					+"_"+result.getMethod().getMethodName()+ ".jpg";
//			
//			
//			//Capture entire page screenshot and then store it to destination drive
//			File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//			
//			try 
//			{
//			  FileUtils.copyFile(screenshot, new File(failureImageFileName));
//			  System.out.println("Screenshot Captured");
//			} 
//			catch (IOException e) 
//			{
//			  System.out.print("Unable to copy the screen shot file "+ e.getMessage());
//			}
//			
//			//almethodname.add(result.getMethod().getMethodName());
//			//al.add(failureImageFileName);
//			
//			//String imagecaptured = test.addScreenCapture(failureImageFileName);
//			
////			Reporter.log("<a href=\""+failureImageFileName
////					+ "\"><img src=\"file:///"+failureImageFileName
////					+"\" alt=\"\""
////					+"height='100' widht='200'/>" 
////					+ "<br />");
//			
//			//Reporter.setCurrentTestResult(null);
//			System.out.println("Screenshot added in report Captured");
//			
//		}
//		System.out.println("###################### TestCase failed Contact Developer " + result.getName());
//		
//	}
//
//	@Override
//	public void onTestSkipped(ITestResult result) 
//	{
//		System.out.println("######################TestCase skipped Contact Developer  " + result.getName());
//		
//	}
//
//	@Override
//	public void onTestStart(ITestResult result) 
//	{
//		
//		System.out.println("TestCase Started and details are ######################" + result.getName());
//		currentMethodName=result.getMethod().getMethodName();
//	}
//
//	@Override
//	public void onTestSuccess(ITestResult result) 
//	{
//		System.out.println("TestCase Success and details are  ######################" + result.getName());
//		
//	}
//
//	@Override
//	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
//		extent = new ExtentReports(outputDirectory + File.separator + "ExtentReportTestNGIReporterLisener.html", true);
//		  System.out.println(""+Onereport);
//		  for(ArrayList<String> xy:Onereport)
//          {
//          	System.out.println("OUR FINAL REPORT "+ xy );
//          }
//        for (ISuite suite : suites) {
//            Map<String, ISuiteResult> result = suite.getResults();
//  
//            for (ISuiteResult r : result.values()) {
//                ITestContext context = r.getTestContext();
//  
//                buildTestNodes(context.getPassedTests(), LogStatus.PASS);
//                buildTestNodes(context.getFailedTests(), LogStatus.FAIL);
//                buildTestNodes(context.getSkippedTests(), LogStatus.SKIP);
//            }
//        }
//  
//        extent.flush();
//        extent.close();
//		
//	}
//	private void buildTestNodes(IResultMap tests, LogStatus status) {
//		ExtentTest test;
//		  
//        if (tests.size() > 0) 
//        {
//            for (ITestResult result : tests.getAllResults()) 
//            {
//            	
//            	System.out.println("TOP ***** " + result.getMethod().getMethodName());
//                test = extent.startTest(result.getMethod().getMethodName());
//  
//                //test = extent.startTest(“[” + result.getMethod().getMethodName() + “], [” + result.getMethod().getDescription() + “]”);
//                
//                test.getTest().setStartedTime(getTime(result.getStartMillis()));
//                
//                
//                test.getTest().setEndedTime(getTime(result.getEndMillis()));
//                
//                
////                test.getTest().startedTime = getTime(result.getStartMillis());
////                test.getTest().endedTime = getTime(result.getEndMillis());
//  
//                for (String group : result.getMethod().getGroups())
//                    test.assignCategory(group);
//  
//                String message = "Test " + status.toString().toLowerCase() + "ed";
//  
//                System.out.println("Before error checking"+ message);
//                
//                if (result.getThrowable() != null)
//                {
//                	message = result.getThrowable().getMessage();
//                	System.out.println("Error present "+ message);
//                }
//                    
//  
//                
//                
//                
//                
//                
//                
//                
//                
//                
////                System.out.println("Final OUT +++++++" + al);
//                System.out.println("Final message =====" +status +"____"+message);
//                //Object ia[] = al.toArray();
//                //Object iamethodname[] = almethodname.toArray();
//               // Object iInfoLogvalues[] = alInfoLogvalues.toArray();
//                		
//                //Object iamethodname[] =alInfoLogvalues.toArray();
//                System.out.println("AAAA 0 "+iamethodname +ia);
//                System.out.println("AAAAAAAA 1"
//							                +ia.length
//							                + iamethodname.length);
//                System.out.println("22222"+iInfoLogvalues.length 
//					                		+ iamethodname.length
//					                		+"^^^^^^"
//					                		+iInfoLogvalues);
//
////                for(ArrayList<String> xy:Onereport)
////                {
////                	RLog("OUR FINAL REPORT "+xy );
////                }
//                
//                for(int o=0;o<iInfoLogvalues.length;o++)
//                {
//                	System.out.println("Q"+iInfoLogvalues[o]);
//                }
//                
//                
//                
//                
//            	if(ITestResult.SUCCESS==result.getStatus())
//        		{
//            		test.log(status, message );
//        			System.out.println("Report updated for –> PASS");
//        		}
//        		else if(ITestResult.FAILURE==result.getStatus())
//        		{
//        			for(int i=0;i<ia.length;i++)
//                    {
//                    	System.out.println("I =  "+i);
//                    	
//                    	if(result.getMethod().getMethodName().equals(iamethodname[i].toString()))
//                    	{
//                    		int currentscreenshotfileintex=1;
//                    		
//                    		
//                    		System.out.println("FINAL INSIDE "+i  + iamethodname[i]+ ia[i]);
//                    		String imagecaptured = test.addScreenCapture(ia[i].toString());
//                    		
//                    		System.out.println("FINAL INSIDE  " +status 
//    															+"+++++"
//    															+message);
//                    		
//                    		test.log(status, message, imagecaptured );
//                    		break;
//                    	}
//                    }
//        			//test.log(LogStatus.FAIL, "MyStep name",imagecaptured );
//        			System.out.println("Report updated for –> FAIL");
//        		}
//        		else if(ITestResult.SKIP==result.getStatus())
//        		{
//        			test.log(status, message );
//        			//test.log(LogStatus.SKIP, "MyStep name",imagecaptured );
//        			System.out.println("Report updated for –> SKIPPED");
//        		}
//                
//            	
//            	
//            	
//            	
//            	
//            	
//            	System.out.println("___________________________________");
//                extent.endTest(test);
//            }
//        }
//    }
//  
//    private Date getTime(long millis) {
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTimeInMillis(millis);
//        return calendar.getTime();        
//    }
//	
//
//}
