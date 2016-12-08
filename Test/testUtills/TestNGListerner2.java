package testUtills;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.xml.XmlSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import MasterGenerators.Party;
import MasterGenerators.Auto.Partye;


public class TestNGListerner2 extends Utills implements ITestListener,IReporter
{
	
	
	@Override
	public void onFinish(ITestContext result) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext result) {
		
//		System.out.println("onstart method date "
//				+new SimpleDateFormat("MM-dd-yyyy_HH-ss-mmm")
//				.format(Calendar.getInstance().getTimeInMillis()));
//		
//		String xxx = new SimpleDateFormat("MM-dd-yyyy_HH-ss-mmm")
//				.format(getTime(result.getStartDate().getTime()));
//		System.out.println("xxx"+xxx);
//		System.out.println( "xxxxx"+new SimpleDateFormat("MM-dd-yyyy_HH-ss-mmm")
//		.format(new GregorianCalendar().getTime()));
	}

	
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
		String failureImageFileName = null;
		if(!result.isSuccess())
		{
//			//iMPORTANT FOR TAKE SCREEN SHOT
//			failureImageFileName=takeScreenshot(driver);
//			RLog("FAILINFO","From Test Fail****"+result.getThrowable().getMessage());
//			RLog("FAILIMG", failureImageFileName);
//			
//			
//			
//			
//			
//			//String imagecaptured = test.addScreenCapture(failureImageFileName);
//			
//			Reporter.log("<a href=\""+failureImageFileName
//					+ "\"><img src=\"file:///"+failureImageFileName
//					+"\" alt=\"\""
//					+"height='100' widht='200'/>" 
//					+ "<br />");
//			
//			Reporter.setCurrentTestResult(null);
			System.out.println("Screenshot added in report Captured");
			
		}
		

		//SendTestAlertMessageAs(currentMethodName+ " : failed ");
		System.out.println("###### TestCase failed Contact Developer " + result.getName());
		RLog("INFO","###### TestCase failed Contact Developer " + result.getName());
	}

	@Override
	public void onTestSkipped(ITestResult result) 
	{
		System.out.println("#######TestCase skipped Contact Developer  " + result.getName());
		//RLog(driver1, "INFO","#######TestCase skipped Contact Developer  " + result.getName());
		//SendTestAlertMessageAs(currentMethodName+ " : skipped ");
	}

	@Override
	public void onTestStart(ITestResult result) 
	{
		System.out.println("onTestStart ");
		currentMethodstarttime = new SimpleDateFormat("MM-dd-yyyy_HH-mm-ss.SSS")
				.format(getTime(result.getStartMillis()));
		
		
		
		String currentMethodDateTime=currentMethodstarttime+"-"+System.nanoTime();
		currentMethodName=result.getMethod().getMethodName();
		
		ArrayList<String> ss=new ArrayList<String>();
		
		System.out.println("current Method Name"+result.getMethod().getMethodName());
		ss.add(0,result.getMethod().getMethodName());//
		
		System.out.println("current Method start time"+currentMethodstarttime);
		ss.add(1,currentMethodstarttime);
		
		System.out.println("currentSessionID"+currentSessionID);
		MethodBundle.put(currentSessionID,ss);
		
		System.out.println("HA"+MethodBundle.size()+"_"+MethodBundle);
		
		try 
        {
			//videoReord.startRecording();
			startRecording();
		} 
        catch (Exception e) 
        {
        	System.out.println("start Video Recorder Error"+e.getMessage());
		}
		System.out.println("*******"
					+result.getMethod().getMethodName() 
					+"Started and Time is " 
					+ new SimpleDateFormat("MM-dd-yyyy_HH-mm-ss.SSS")
						.format(getTime(result.getStartMillis())) 
					+"*****"
					+ result.getName());
		
		//RLog(driver1, "INFO","*******"+currentMethodName +"Started and Time is " + currentMethodstarttime +"*****"+ result.getName());
		//SendTestAlertMessageAs(driver1,currentMethodName+ "Started ");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) 
	{
		System.out.println("##########"
						+result.getMethod().getMethodName()  
						+" Success and details are  ##########" 
						+ result.getName());
		//RLog(driver1, "INFO","##########"+currentMethodName +" Success and details are  ##########" + result.getName());
		//SendTestAlertMessageAs(currentMethodName+ " : Success ");
	}

	@Override
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		
		//ExtentReports(String filePath, Boolean replaceExisting)
		extent = new ExtentReports(outputDirectory 
									+ File.separator 
									+ "ExtentReportTestNGIReporterLisener.html", true);
		  
        for (ISuite suite : suites) {
            Map<String, ISuiteResult> result = suite.getResults();
  
            for (ISuiteResult r : result.values()) 
            {
            	
                ITestContext context = r.getTestContext();
  
                
                
                //System.out.println("Date"+context.getStartDate().from(instant));
                
                buildTestNodes(context.getPassedTests(), LogStatus.PASS);
                buildTestNodes(context.getFailedTests(), LogStatus.FAIL);
                buildTestNodes(context.getSkippedTests(), LogStatus.SKIP);
            }
        }
  
        extent.flush();
        extent.close();
		
	}
	private void buildTestNodes(IResultMap tests, LogStatus status) {
		//ExtentTest test;
		  
        if (tests.size() > 0) 
        {
        	
            for (ITestResult result : tests.getAllResults()) 
            {
            	test = extent.startTest(result.getMethod().getMethodName());
                
                test.getTest().setStartedTime(getTime(result.getStartMillis()));
                
                
                	

                
                
                String yyy=new SimpleDateFormat("MM-dd-yyyy_HH-mm-ss.SSS")
                			.format(getTime(result.getStartMillis()));
                
                //Instant instant = Instant.now();
                //String zzz=new SimpleDateFormat("MM-dd-yyyy_HH-mm-ss.SSS")
				//.format(instant);
                
                //ITestNGMethod s=result.getMethod();
                
                //System.out.println("yyy"+yyy +"zzz"+zzz);
                //System.out.println("ssss"
		         //       +s.getDate()
		         //       +"___"
                //		+instant.toString ().replace ( "T" , " " ).replace( "Z" , ""));
                
                
                
                
                //test.getTest().setEndedTime(getTime(result.getEndMillis()));
                
                for (String group : result.getMethod().getGroups())
                    test.assignCategory(group);
  
                String message = "Test " + status.toString().toLowerCase() + "ed";
  
                System.out.println("Before error checking"+ message);
                
                if (result.getThrowable() != null)
                {
                	message = result.getThrowable().getMessage();
                	System.out.println("Error present "+ message);
                }
                
                if(!Onereport.isEmpty())
        		{
                	System.out.println(""+Onereport.size());
        			for(int i = 0; i < Onereport.size();i++)
        			{
        				if(Onereport.get(i).get(2).contentEquals(yyy) && Onereport.get(i).get(1).contentEquals(result.getMethod().getMethodName()))
        				{
        					if(Onereport.get(i).get(0).toLowerCase().contentEquals("info"))
        					{
        						test.log(status, Onereport.get(i).get(3) );
        					}
        					else if(Onereport.get(i).get(0).toLowerCase().contentEquals("failimg"))
        					{
        						String imagecaptured = test.addScreenCapture((Onereport.get(i).get(3)));
	            				test.log(status, message, imagecaptured );
	                     		
        					}
        					else if(Onereport.get(i).get(0).toLowerCase().contentEquals("failinfo"))
        					{
        						test.log(status, message);
        					}
        					else 
        					{
        						System.out.println("Final Log Report LogType Othar(info,failimg,failinfo) than Framework : PLACE testUtills - TESTNG LISENER2 ");
        					}
        				}
        			}
        			
        		}
        		else
        		{
        			//System.out.println("checking Reporterlist  empty");
        			System.out.println("There is no logs present .... ");
        		}
            	
                test.getTest().setEndedTime(getTime(result.getEndMillis()));
                
                extent.endTest(test);
            }
        }
    }  
    private Date getTime(long millis) 
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        
        return calendar.getTime();
    }
	

}
