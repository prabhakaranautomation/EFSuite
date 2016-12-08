package MasterTest;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.xml.XmlClass;


import MasterGenerators.Auto;
import MasterGenerators.Party;
import MasterGenerators.Auto.Partye;
import Master_util.Data_driven_helper;
import testUtills.Utills;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.xml.parsers.ParserConfigurationException;
import org.testng.xml.Parser;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;
import org.xml.sax.SAXException;

import Master.Pages;

//
//import java.awt.GraphicsConfiguration;
//import java.awt.GraphicsEnvironment;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.nio.file.Path;
//import java.sql.Array;
//
//import java.util.Properties;
//
//import org.apache.commons.io.FileUtils;
//import org.monte.screenrecorder.ScreenRecorder;
//
//import java.awt.*;
//import org.monte.media.Format;
//import org.monte.media.math.Rational;
//import static org.monte.media.AudioFormatKeys.*;
//import static org.monte.media.VideoFormatKeys.*;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebElement;
//import org.testng.ISuite;
//import org.testng.ITestNGMethod;
//import org.testng.ITestResult;
//
//
//import org.testng.annotations.AfterSuite;
//import Master.Pages;
//import testUtills.SpecializedScreenRecorder;
//import java.util.Date;
//import java.util.GregorianCalendar;
//import java.util.List;
//import com.relevantcodes.extentreports.ExtentReports;
//import com.relevantcodes.extentreports.ExtentTest;
//import com.relevantcodes.extentreports.LogStatus;


public class Testbase2 extends Utills
{
//	public static Properties Repository =new Properties();
//	public File f;
//	public FileInputStream FI;
	
	private  List<WebDriver> webDriverPool = Collections.synchronizedList(new ArrayList<WebDriver>());
    private  ThreadLocal<WebDriver> driverThread = null;
    
    //private  BrowserSetup browser1;
    //public WebDriver driver;
    
	//protected ThreadLocal<RemoteWebDriver> threadDriver = null;
	
	@BeforeSuite()
	public void bsuite()
	{	
		Onereport=new ArrayList<ArrayList<String>>();
		Auto.initialize();
		
		System.out.println("Before Suite Done");
		//RLog("INFO","Before Suite Onereport Initializeed ");
	}
	
	//@Parameters({ "browser"})
	@BeforeTest
	public void init()//String browser
	{
		String browser="chrome";
		
		if (browser.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
			System.out.println("FIREFOX");
			
		}
		else if (browser.equalsIgnoreCase("chrome"))
		{
			// Set path for Chrome Driver executable
	        System.setProperty("webdriver.chrome.driver", "C:\\Users\\prabakar.inmaa\\workspace\\eFreightSuite\\Drivers\\chromedriver.exe");
	        
	        // Launch ChromeDriver
	        driver = new ChromeDriver();
	        
	        System.out.println("CHROME");
		}
		else if (browser.equalsIgnoreCase("IE"))
		{
			// Set path for Internet Explorer Driver executable
	        System.setProperty("webdriver.ie.driver", "C:\\Users\\prabakar.inmaa\\workspace\\eFreightSuite\\Drivers\\IEDriverServer.exe");
	        
	        // Launch InternetExplorerDriver
	        driver = new InternetExplorerDriver();
	        
	        System.out.println("IE");
		}
		else if (browser.equalsIgnoreCase("HtmlUnit"))
		{
			//driver = new HtmlUnitDriver();
		}
		else if (browser.equalsIgnoreCase("safari"))
		{
			
		}
		webDriverPool.add(driver);
		System.out.println("Added in wedriver pool");
		driver.get("http://192.168.1.63:8080/index.html#/home");
		driver.manage().window().maximize();
		System.out.println("driver navigated ");
		
		Pages.Home(driver).EFSlogin(driver, "EFS","sathish","sathish");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		System.out.println("driver logged in ");
	}
	
	@BeforeMethod
	public void beforemethod()
	{
		System.out.println("Before Method ");
//		//BeforeMethodVariable="A";
//		System.out.println("before method date"
//									+new SimpleDateFormat("MM-dd-yyyy_HH-mm-sss")
//											.format(Calendar.getInstance().getTimeInMillis())
//									+"-"+ System.nanoTime());
//		// add sID, Current Method name, current method name start time 
//		
//		
//		System.out.println("ABCD"+Thread.currentThread().getStackTrace()[1].getMethodName());
//		currentSessionID = ((RemoteWebDriver)driver1).getSessionId().toString();
//		System.out.println("current Session ID beforemethod : "+currentSessionID);
//		
//		String browserdetails=(((RemoteWebDriver)driver1).getCapabilities().getBrowserName().toString()
//				+""
//				+GetWord(((RemoteWebDriver)driver1).getSessionId().toString(),"-",0)
//				+"_"
//				+((RemoteWebDriver)driver1).getCapabilities().getVersion().toString()
//				+"_"
//				+((RemoteWebDriver)driver1).getCapabilities().getPlatform().toString()
//				);
//		System.out.println("browser details"+browserdetails);
	}
	
	@AfterMethod
	public void aftermethod()
	{
		
	}
	
	@AfterTest
	public void AfterTestclose()
	{
		try 
		{
			//videoReord.stopRecording();
			stopRecording();
		} 
		catch (Exception e) 
		{
			System.out.println("Stop video Record Error is : "+e.getMessage());
			
		}
		System.out.println("Webdriver size"+webDriverPool.size());
		
		for (WebDriver driverclose : webDriverPool) 
		{
	        if(driver.equals(driverclose))
	        {
	        	String CurrentDriverSessionID=((RemoteWebDriver)driver).getSessionId().toString();
				Set<String> keys = PartyBundle.keySet();
		        for(String key: keys)
		        {
		        	System.out.println("KeY : "+key);
		        	
		        	if(GetStringFromSentence(key,"_",0).contentEquals(CurrentDriverSessionID))
		        	{
		        		PartyBundle.remove(key);
		        		System.out.println("KeyMatched So After Test Removed this Key : "+key);
		        	}
		        	else
		        	{
		        		System.out.println("Key didn't match : "+key);
		        	}
		        }
	        	System.out.println("driver equals to current driver so closed this alone " );
	        	RLog(driver, "INFO","Browser closeed ");
	        	driver.quit();
	        }
	        else
	        {
	        	System.out.println("Web Driver Pool does not match");
	        }
        }
		System.out.println("After Test Completed " );
		
//		closeBrowser();
	}
	
	@AfterSuite()
	public void Aftersuite()
	{	
		//Onereport=new ArrayList<ArrayList<String>>();
		//Auto.initialize();
		
		System.out.println("After Suite Done");
		//RLog("INFO","Before Suite Onereport Initializeed ");
	}
	
//	public void closeBrowser()
//	{
//		driver.quit();
//		//closeBrowser();
//	}
//	
	private Date getTime(long millis) 
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        
        return calendar.getTime();
    }
	
	@DataProvider(name="validcustomer")
	public static Object[][] validcustomer(Method method)
	{
		System.out.println("Data Provider starts " +method.getName());
		String Methodname=method.getName();
		String filepath=("C:\\Users\\prabakar.inmaa\\Desktop\\JIRA_EXCEL_INPUT\\prabhakaran.xlsx");
		Data_driven_helper excel=new Data_driven_helper(filepath);
		
		System.out.println("Method Name is " +method.getName());
		Object[][] a1 = excel.getTestCaseDataSets("Sheet1",Methodname );
		
		return a1;
	}
	
	@DataProvider(name="Dataprovider")
	public static Object[][] Dataprovider(Method method,ITestContext context) 
	{
		
		String filepath=("C:\\Users\\prabakar.inmaa\\Desktop\\JIRA_EXCEL_INPUT\\prabhakaran.xlsx");
		Data_driven_helper excel=new Data_driven_helper(filepath);
		
		System.out.println("Data Provider Started and Method Name is " +method.getName());
		
		try {
			Collection<XmlSuite> suites = new Parser(context.getSuite().getXmlSuite().getFileName()).parse();
			for (XmlSuite xmlSuite : suites)
			{
				//System.out.println("SUITE NAME" + xmlSuite.getName() + "<---XML-context --->"+context.getSuite().getName());
				for (XmlTest xmlTest: xmlSuite.getTests())
				{
					
					if (xmlTest.getName().equals(context.getCurrentXmlTest().getName()))
					{
						//System.out.println("TEST NAME" + xmlTest.getName()+ "<---XML-context --->"+context.getCurrentXmlTest().getName());
						//System.out.println("context.getCurrentXmlTest" +context.getCurrentXmlTest().getName());
						//System.out.println("Contest "+context.getName());
						
						for (XmlClass xmlClass : xmlTest.getXmlClasses())
						{
							try 
							{
								Class d = Class.forName(xmlClass.getName());
								Method me[] = d.getDeclaredMethods();
								
								String searchMethoda = xmlClass.getName() + "." + method.getName();
								for(int z=0;z<me.length;z++)
								{
									if(me[z].toString().contains(searchMethoda))
									{
										//System.out.println("++++++++++++++++++++++++++++++++++++");
										
										String ClassNameSheetName=xmlClass.getName();
										String Methodname=method.getName();
										//System.out.println("s[i]" +me.length+ "..."+z +"..."+ d.getName()+ "....." +me[z]);
										
										Object[][] a1 = excel.getTestCaseDataSets(ClassNameSheetName, Methodname );
										return a1;
									}
								}
							} 
							catch (ClassNotFoundException e1) 
							{
								System.out.println("Date Provider Fail -  ClassNotFoundException = " + e1.getMessage());
							} 
							catch (SecurityException e2) 
							{
								System.out.println("Date Provider Fail -  ClassNotFoundException = " + e2.getMessage());
							}
						}
					}
				}
			}
		} catch (ParserConfigurationException e3) {
			System.out.println("Date Provider Fail ParserConfigurationException = " + e3.getMessage());
		} catch (SAXException e4) {
			System.out.println("Date Provider Fail  SAXException =" + e4.getMessage());
		} catch (IOException e5) {
			System.out.println("Date Provider Fail  IOException =" + e5.getMessage());
		}
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
		return null;
	}
	
	
//	public void loadPropertiesFile() 
//	{
//		try 
//		{
//			f=new File(System.getProperty("user.dir")+"\\src\\config.properties");
//			FI=new FileInputStream(f);
//			Repository.load(FI);
//			
//			f=new File(System.getProperty("user.dir")+"\\Master\\Master_PageLocator\\HomePage.properties");
//			FI=new FileInputStream(f);
//			Repository.load(FI);
//			
//		} 
//		catch (FileNotFoundException e1) 
//		{
//			System.out.println("Unable to Load Property file FileNotFoundException " + e1.getMessage());
//		} 
//		catch (IOException e2) 
//		{
//			System.out.println("Unable to Load Property file IOException   " + e2.getMessage());
//		}
//		
//	}
//	public static WebElement getLocator(String locator) throws Exception
//	{
//		String locatorType=locator.split("_")[0];
//		String locatorValue=locator.split("_")[1];
//		
//		if(locatorType.toLowerCase().equals("id"))
//			return driver.findElement(By.id(locatorValue));
//		
//		else if(locatorType.toLowerCase().equals("name"))
//			return driver.findElement(By.name(locatorValue));
//		
//		else if((locatorType.toLowerCase().equals("classname")) || (locatorType.toLowerCase().equals("class")))
//			return driver.findElement(By.className(locatorValue));
//		
//		else if((locatorType.toLowerCase().equals("tagname")) || (locatorType.toLowerCase().equals("tag")))
//			return driver.findElement(By.className(locatorValue));
//		
//		else if((locatorType.toLowerCase().equals("linktext")) || (locatorType.toLowerCase().equals("link")))
//			return driver.findElement(By.linkText(locatorValue));
//		
//		else if(locatorType.toLowerCase().equals("partiallinktext"))
//			return driver.findElement(By.partialLinkText(locatorValue));
//		
//		else if((locatorType.toLowerCase().equals("cssselector"))|| (locatorType.toLowerCase().equals("css")))
//			return driver.findElement(By.cssSelector(locatorValue));
//		
//		else if(locatorType.toLowerCase().equals("xpath"))
//			return driver.findElement(By.xpath(locatorValue));
//		
//		else
//			throw new Exception(" Unkown locator Type '" + locatorType + "'");
//		
//	}
//	public WebElement getWebelement(String locator) throws Exception
//	{
//		return getLocator(Repository.getProperty(locator));
//	}
	
	
}
