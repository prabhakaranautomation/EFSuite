package MasterTest;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
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


import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.sql.Array;

import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.monte.screenrecorder.ScreenRecorder;

import java.awt.*;
import org.monte.media.Format;
import org.monte.media.math.Rational;
import static org.monte.media.AudioFormatKeys.*;
import static org.monte.media.VideoFormatKeys.*;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.ISuite;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;


import org.testng.annotations.AfterSuite;
import Master.Pages;
import testUtills.SpecializedScreenRecorder;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class Testbase extends Utills
{
//	public static Properties Repository =new Properties();
//	public File f;
//	public FileInputStream FI;
	
	private  List<WebDriver> webDriverPool = Collections.synchronizedList(new ArrayList<WebDriver>());
    private  ThreadLocal<WebDriver> driverThread = null;
    
    //private  BrowserSetup browser1;
    //public WebDriver driver1;
    
	//protected ThreadLocal<RemoteWebDriver> threadDriver = null;
	
	@BeforeSuite()
	public void bsuite()
	{	
		Onereport=new ArrayList<ArrayList<String>>();
		Auto.initialize();
		
		System.out.println("Before Suite Done");
		//RLog("INFO","Before Suite Onereport Initializeed ");
	}
	
	// Use this method instead of driver.get()
	public WebDriver getDriver() 
	{
	    return this.driverThread.get();
	}
	
	@Parameters({ "Runas","browser","platform","browserVersion","Node","binary"})
	@BeforeTest
	public void init(ITestContext context, @Optional("none") String Runas, @Optional("none") String browser, @Optional("none") String platform, @Optional("none") String browserVersion, @Optional("none") String Node, @Optional("none") String binary)
	{
		if(Runas.contains("none"))
		{
			System.out.println("Our thought");
					
					this.driverThread   = new ThreadLocal<WebDriver>()
					{
						@Override
						protected WebDriver initialValue()
						{
							WebDriver driverfirefox;
							DesiredCapabilities cap = new DesiredCapabilities();
							System.out.println("Cabality Fire Forx 45.0.2 Path : " +new File("C:\\Program Files (x86)\\MozillaFireFox45.0.2\\firefox.exe").getAbsolutePath());

							cap.setCapability(FirefoxDriver.BINARY, new File("C:\\Program Files\\Mozilla\\firefox.exe").getAbsolutePath());
					        cap.setBrowserName(DesiredCapabilities.firefox().getBrowserName());
					        cap.setVersion("45.0.2");
					        cap.setPlatform(org.openqa.selenium.Platform.WINDOWS);
					        cap.setJavascriptEnabled(true);
					        
					        
					        
					        System.out.println("B4 driver creation ");
							
							
							try 
							{
								
								driverfirefox = new RemoteWebDriver(new URL("http://192.168.50.85:5558/wd/hub"), cap);
							
							
								org.openqa.selenium.remote.SessionId id = ((RemoteWebDriver)driverfirefox).getSessionId();
								System.out.println(browser+" Session ID "+id.toString());
								
								webDriverPool.add(driverfirefox);
								System.out.println(browser+"Added in webDriverPool");
								
							    driverfirefox.navigate().to("http://192.168.1.63:8080/index.html");
							    driverfirefox.manage().window().maximize();
							    System.out.println(browser+ "Navigated To URL and Done Maximize");
							    
							    System.out.println("BB firefox"
										+((RemoteWebDriver)driverfirefox).getCapabilities().getPlatform().toString()
										+"_"
										+((RemoteWebDriver)driverfirefox).getCapabilities().getBrowserName().toString()
										+"_"
										+((RemoteWebDriver)driverfirefox).getCapabilities().getVersion().toString()
										);
								
							    Pages.Home(driverfirefox).EFSlogin(driverfirefox, "EFS","sathish","sathish");
							    driverfirefox.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
								
							    return driverfirefox;
							} 
							catch (MalformedURLException e) 
							{
								System.out.println("Browser conenction issue :"+e.getMessage());
								e.printStackTrace();
							}
							return null;
					        
						}
					};
			
			//driver=getDriver();
		}
		else if(Runas.contains("GRID"))
		{
			
			//TestContext
			System.out.println("1out side");
			//final BrowserSetup browser1 = new BrowserSetup(browser, browserVersion, platform);
			this.driverThread   = new ThreadLocal<WebDriver>() 
			{
		        @Override
		        protected WebDriver initialValue()
		        {
		        	System.out.println("Input browser Name : " +browser+ "Inside @OverRide First Step " );

		        	if (browser.equalsIgnoreCase("firefox"))
		    		{
		        		try 
		        		{
		        			System.out.println(" Executing on FIREFOX");
							
//		        			 File pathToBinary = new File("C:\\Program Files (x86)\\MozillaFireFox45.0.3\\firefox.exe"); 
//		        			 FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
		        			 
//		        			 ffBinary.setEnvironmentProperty("DISPLAY", ":20");
		        			 
//		        			 FirefoxProfile firefoxProfile = new FirefoxProfile();       
//		        			 WebDriver driver = new FirefoxDriver(ffBinary,firefoxProfile);

					        //final FirefoxProfile fp = new FirefoxProfile();
					        //fp.setPreference("xpinstall.signatures.required", false);
					        
//					        fp.setEnableNativeEvents(true);
//					        fp.setAcceptUntrustedCertificates(true);
//					        addFirefoxExtensions(getFirefoxExtensionPath(), fp);
		        			
		        			//WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);
		        			
					        System.out.println("Starts");
					        DesiredCapabilities cap = new DesiredCapabilities();
					        //cap.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR,UnexpectedAlertBehaviour.ACCEPT);

//					        //When you run selenium tests in stand-alone Selenium, you specify the type of the browser in the constructor.
//					        WebDriver driver = new RemoteWebDriver(new URL("http://jenkins.mydomain:4444/wd/hub"), capability);

					        //In addition to standard platform matching capability offered out-of-the-box 
					        //by Selenium Grid, Jenkins allows you to specify "jenkins.label" as a capability, 
					        //whose value is an expression of label names to narrow down where to run the tests. 
					        //See the following example:
					        
//					        DesiredCapabilities capability = DesiredCapabilities.firefox();
//							// say you use the redhat5 label to indicate RHEL5 and the amd64 label to specify the architecture
//							capability.setCapability("jenkins.label","redhat5 && amd64");
//							// Say you want a specific node to thread your request, just specify the node name (it must be running a selenium configuration though)
//							capability.setCapability("jenkins.nodeName","(master)");
					     
					        if (browserVersion.toString().contains("40.0.3"))
					        {
					        	System.out.println("Cabality Fire Forx 40.0.3 Path : " +new File("C:\\Program Files (x86)\\MozillaFireFox40.0.3\\firefox.exe").getAbsolutePath());
						        cap.setCapability(FirefoxDriver.BINARY, new File("C:\\Program Files (x86)\\MozillaFireFox40.0.3\\firefox.exe").getAbsolutePath());
						        
					        }
					        else if(browserVersion.toString().contains("45.0.2"))
					        {
					        	System.out.println("Cabality Fire Forx 45.0.2 Path : " +new File("C:\\Program Files (x86)\\MozillaFireFox45.0.2\\firefox.exe").getAbsolutePath());
						        //cap.setCapability(FirefoxDriver.BINARY, new File("C:\\Program Files\\Mozilla\\firefox.exe").getAbsolutePath());//C:\Program Files\Mozilla //C:\\Program Files (x86)\\Mozilla Firefox
						        cap.setCapability(FirefoxDriver.BINARY, new File(binary).getAbsolutePath());
					        }
					        else if(browserVersion.toString().contains("49.0.1"))
					        {
					        	System.out.println("Cabality Fire Forx 49.0.1 Path : " +new File("C:\\Program Files (x86)\\MozillaFireFox49.0.1\\firefox.exe").getAbsolutePath());
						        cap.setCapability(FirefoxDriver.BINARY, new File("C:\\Program Files (x86)\\MozillaFireFox49.0.1\\firefox.exe").getAbsolutePath());
					        }
					        else if(browserVersion.toString().contains("41.0.2"))
					        {
					        	System.out.println("Cabality Fire Forx 41.0.2 Path : " +new File("C:\\Program Files (x86)\\MozillaFireFox45.0.2\\firefox.exe").getAbsolutePath());
						        //cap.setCapability(FirefoxDriver.BINARY, new File("C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe").getAbsolutePath());//C:\\Program Files (x86)\\MozillaFireFox45.0.2
					        	cap.setCapability(FirefoxDriver.BINARY, new File(binary).getAbsolutePath());
					        }
					        else if(browserVersion.toString().contains("50.0"))
					        {
					        	System.out.println("Cabality Fire Forx 50.0 Path : " +new File("C:\\Program Files\\Mozilla Firefox\\firefox.exe").getAbsolutePath());
						        //cap.setCapability(FirefoxDriver.BINARY, new File("C:\\Program Files\\Mozilla Firefox\\firefox.exe").getAbsolutePath());//C:\\Program Files (x86)\\MozillaFireFox45.0.2
						        cap.setCapability(FirefoxDriver.BINARY, new File(binary).getAbsolutePath());
					        }
					        //cap.setCapability(FirefoxDriver.PROFILE, fp);
					        
					        System.out.println("Capability Browser Name : "+DesiredCapabilities.firefox().getBrowserName());
					        cap.setBrowserName(DesiredCapabilities.firefox().getBrowserName());
					        
					        System.out.println("browser Version"+browserVersion);
					        cap.setVersion(browserVersion);
					        
					        cap.setPlatform(org.openqa.selenium.Platform.WINDOWS);
					        
					        cap.setJavascriptEnabled(true);
					        
					        
					        
					        System.out.println("B4 driver creation ");
							WebDriver driverfirefox = new RemoteWebDriver(new URL(Node), cap);
							
							System.out.println("End");
							
//							System.out.println("121 "
//											+((RemoteWebDriver)driverfirefox).getCommandExecutor()
//											+"--"
//											+((RemoteWebDriver)driverfirefox).getCapabilities()
//											+"--"
//											+((RemoteWebDriver)driverfirefox).getSessionId()
//											);
							
							//LazyCommandExecutor ts=(LazyCommandExecutor) driverfirefox.getCommandExecutor();
							
							org.openqa.selenium.remote.SessionId id = ((RemoteWebDriver)driverfirefox).getSessionId();
							System.out.println(browser+" Session ID "+id.toString());
							
							webDriverPool.add(driverfirefox);
							System.out.println(browser+"Added in webDriverPool");
							
						    driverfirefox.navigate().to("http://192.168.1.63:8080/index.html");
						    driverfirefox.manage().window().maximize();
						    System.out.println(browser+ "Navigated To URL and Done Maximize");
						    
						    System.out.println("BB firefox"
									+((RemoteWebDriver)driverfirefox).getCapabilities().getPlatform().toString()
									+"_"
									+((RemoteWebDriver)driverfirefox).getCapabilities().getBrowserName().toString()
									+"_"
									+((RemoteWebDriver)driverfirefox).getCapabilities().getVersion().toString()
									);
							
						    
						    
						    Pages.Home(driverfirefox).EFSlogin(driverfirefox, "EFS","sathish","sathish");
						    driverfirefox.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
							
						    
						    
						    
							return driverfirefox;
						}
		        		catch (MalformedURLException e) 
		        		{
							System.out.println("Browser Error "+e.getMessage());
							RLog("INFO", "Browser Error Is : "+e.getMessage());
						}
						
		    		}
		        	else if (browser.equalsIgnoreCase("chrome"))
		    		{
		    			try 
		    			{
		    				System.out.println(" Executing on CHROME");
		    				
		    				DesiredCapabilities capchrome = DesiredCapabilities.chrome();
		    				capchrome.setBrowserName("chrome");
		    				capchrome.setVersion(browserVersion);
		    				capchrome.setPlatform(org.openqa.selenium.Platform.WINDOWS);
		    				
		    				//String Node = "http://192.168.50.87:5557/wd/hub";
		    				//String Node = "http://localhost:4444/wd/hub";
		    				WebDriver driverchrome = new RemoteWebDriver(new URL(Node), capchrome);
		    				org.openqa.selenium.remote.SessionId id2 = ((RemoteWebDriver)driverchrome).getSessionId();
							
							System.out.println(browser +" Session ID "+id2.toString());

		    				webDriverPool.add(driverchrome);
		    				System.out.println(browser+"Added in webDriverPool");
		    				
		    				driverchrome.navigate().to("http://192.168.1.63:8080/index.html");
		    			    driverchrome.manage().window().maximize();
		    			    System.out.println(browser+ "Navigated To URL and Done Maximize");
		    			    
		    			    System.out.println("BB chrome"
									+((RemoteWebDriver)driverchrome).getCapabilities().getPlatform().toString()
									+"_"
									+((RemoteWebDriver)driverchrome).getCapabilities().getBrowserName().toString()
									+"_"
									+((RemoteWebDriver)driverchrome).getCapabilities().getVersion().toString()
									);
							
		    			    
		    			    
		    			    Pages.Home(driverchrome).EFSlogin(driverchrome, "EFS","sathish","sathish");
		    			    driverchrome.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		    				
		    				return  driverchrome;
		    			} 
		    			catch (MalformedURLException e) 
		    			{
		    				System.out.println(""+ e.getMessage());

		    			}
		    	
		    		}

		        	else if (browser.equalsIgnoreCase("ie"))
		    		{
		    			try 
		    			{
		    				System.out.println(" Executing on INTERNET EXPLORE");
		    				
		    				//DesiredCapabilities.internetExplorer();
		    				
		    				
		    				DesiredCapabilities capIE = DesiredCapabilities.internetExplorer();
		    				System.out.println("1");
		    				//capIE.setBrowserName("ie");
		    				System.out.println("2");
		    				//capIE.setVersion(browserVersion);
		    				System.out.println("3");
		    				//capIE.setPlatform(org.openqa.selenium.Platform.WINDOWS);
		    				System.out.println("4");
		    				//String Node = "http://192.168.50.87:5557/wd/hub";
		    				//String Node = "http://localhost:4444/wd/hub";
		    				
		    				capIE.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL,"http://192.168.1.63:8080/index.html");
		    				System.out.println("5");
		    				WebDriver driverie = new RemoteWebDriver(new URL(Node), capIE);
		    				System.out.println("6");
		    				org.openqa.selenium.remote.SessionId id3 = ((RemoteWebDriver)driverie).getSessionId();
		    				
							System.out.println(browser +" Session ID "+id3.toString());

		    				webDriverPool.add(driverie);
		    				System.out.println(browser+"Added in webDriverPool");
		    				
		    				//driverie.navigate().to("http://192.168.1.63:8080/index.html");
		    			    driverie.manage().window().maximize();
		    			    //System.out.println(browser+"Added in webDriverPool");
		    			    
		    			    System.out.println("BB IE"
									+((RemoteWebDriver)driverie).getCapabilities().getPlatform().toString()
									+"_"
									+((RemoteWebDriver)driverie).getCapabilities().getBrowserName().toString()
									+"_"
									+((RemoteWebDriver)driverie).getCapabilities().getVersion().toString()
									);
							
		    			    
		    			    
		    			    Pages.Home(driverie).EFSlogin(driverie, "EFS","sathish","sathish");
		    			    driverie.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		    				
		    				return  driverie;
		    			} 
		    			catch (MalformedURLException e) 
		    			{
		    				System.out.println(""+ e.getMessage());

		    			}
		    	
		    		}

		        	
		        	return null;
				        //WebDriver webDriver = new RemoteWebDriver(...);
				          
			    }
		      };
			
		      driver=getDriver();
		}
		
	      
	      
	      try 
	        {
				//videoReord.startRecording();
				startRecording();
			} 
	        catch (Exception e) 
	        {
	        	System.out.println("start Video Recorder Error"+e.getMessage());
			}
		//RLog(driver1, "INFO","Before Test Initialize");
		
		
		
		//driver=GridBrowserInitialize(browser,platform,browserVersion);
		
		//driver=BrowserInitialize();
		
		//loadPropertiesFile();
		
	}
	
	@BeforeMethod
	public void beforemethod()
	{
		
		System.out.println("Before Method ");
		//BeforeMethodVariable="A";
		System.out.println("before method date"
									+new SimpleDateFormat("MM-dd-yyyy_HH-mm-sss")
											.format(Calendar.getInstance().getTimeInMillis())
									+"-"+ System.nanoTime());
		// add sID, Current Method name, current method name start time 
		
		
		System.out.println("ABCD"+Thread.currentThread().getStackTrace()[1].getMethodName());
		currentSessionID = ((RemoteWebDriver)driver).getSessionId().toString();
		System.out.println("current Session ID beforemethod : "+currentSessionID);
		
		String browserdetails=(((RemoteWebDriver)driver).getCapabilities().getBrowserName().toString()
				+""
				+GetWord(((RemoteWebDriver)driver).getSessionId().toString(),"-",0)
				+"_"
				+((RemoteWebDriver)driver).getCapabilities().getVersion().toString()
				+"_"
				+((RemoteWebDriver)driver).getCapabilities().getPlatform().toString()
				);
		System.out.println("browser details"+browserdetails);
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
		for (WebDriver driverh : webDriverPool) 
		{
	        if(driver.equals(driverh))
	        {
//	        	String CurrentDriverSessionID=((RemoteWebDriver)driver).getSessionId().toString();
//				Set<String> keys = PartyBundle.keySet();
//		        for(String key: keys)
//		        {
//		        	System.out.println("KeY : "+key);
//		        	
//		        	if(GetStringFromSentence(key,"_",0).contentEquals(CurrentDriverSessionID))
//		        	{
//		        		PartyBundle.remove(key);
//		        		System.out.println("KeyMatched So After Test Removed this Key : "+key);
//		        	}
//		        	else
//		        	{
//		        		System.out.println("Key didn't match : "+key);
//		        	}
//		        }
	        	System.out.println("driver equals to current driver so closed this alone " );
	        	RLog(driverh, "INFO","Browser closeed ");
	        	driverh.quit();
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
