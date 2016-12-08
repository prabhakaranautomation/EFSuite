package testUtills;

import static org.monte.media.FormatKeys.EncodingKey;
import static org.monte.media.FormatKeys.FrameRateKey;
import static org.monte.media.FormatKeys.KeyFrameIntervalKey;
import static org.monte.media.FormatKeys.MIME_AVI;
import static org.monte.media.FormatKeys.MediaTypeKey;
import static org.monte.media.FormatKeys.MimeTypeKey;
import static org.monte.media.VideoFormatKeys.CompressorNameKey;
import static org.monte.media.VideoFormatKeys.DepthKey;
import static org.monte.media.VideoFormatKeys.ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE;
import static org.monte.media.VideoFormatKeys.QualityKey;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.monte.media.Format;
import org.monte.media.FormatKeys.MediaType;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import Master.HomePage;
import Master.Pages;
import MasterGenerators.Party;
import MasterGenerators.Auto.Partye;


//import com.relevantcodes.extentreports.LogStatus;
//import MasterGenerators.Auto;
//import MasterGenerators.Party;
//import java.lang.reflect.Method;
//import java.util.Date;
//import java.util.List;

public class Utills
{
	public static File f1;
	public static Properties Repository1 =new Properties();
	
	public static FileInputStream FI1;
	
	public WebDriver driver1;
	public WebDriver driver;
	
	public static Map<String, Party> PartyBundle=Collections.synchronizedMap(new HashMap<String, Party>());
	public static Map<String, ArrayList<String>> MethodBundle=Collections.synchronizedMap(new HashMap<String, ArrayList<String>>());
	
	public static String currentMethodstarttime="null";
	public static String currentSessionID="null";
	public static String currentLogtime="null";
	public static String currentMethodName="null";
	
	public static ExtentReports extent;
	public static ExtentTest test;
	
	public static ArrayList<ArrayList<String>> Onereport;
	
	public static enum Loge {INFO, LOWLOG, HIGHLOG, FAILINFO, FAILIMG, IMG};
	
	private static ScreenRecorder screenRecorder;
	
	protected SoftAssert AssertionMulti=new SoftAssert();

	
	public void startRecording()
    {    
		try 
		{
			String s="ScreenRecorder";		//("D:\\Videos");
			
			File file = new File(s);
			                 
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			int width = screenSize.width;
			int height = screenSize.height;
			                  
			Rectangle captureSize = new Rectangle(0,0, width, height);
			            
			   
			// Create an instance of GraphicsConfiguration to get the Graphics configuration of the Screen.
			// This is needed for ScreenRecorder class.
			GraphicsConfiguration gc = GraphicsEnvironment
			    .getLocalGraphicsEnvironment()
			    .getDefaultScreenDevice()
			    .getDefaultConfiguration();

			 // Create a instance of ScreenRecorder with the required configurations
			this.screenRecorder = new SpecializedScreenRecorder(
					gc, 
					captureSize,
					new Format(
								MediaTypeKey, 
								MediaType.FILE, 
								MimeTypeKey, 
								MIME_AVI
								),
					new Format(
								MediaTypeKey, 
								MediaType.VIDEO, 
								EncodingKey, 
								ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
								CompressorNameKey, 
								ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
								DepthKey, 
								24, 
								FrameRateKey, 
								Rational.valueOf(15),
								QualityKey, 
								1.0f,
								KeyFrameIntervalKey, 
								15 * 60
								),
					new Format(
								MediaTypeKey, 
								MediaType.VIDEO, 
								EncodingKey, 
								"black",
								FrameRateKey, 
								Rational.valueOf(30)
								),
					null, 
					file, 
					currentMethodName);
			
			this.screenRecorder.start();
		} 
		catch (HeadlessException e) 
		{
			System.out.println("Screen Record Start HeadlessException Error : "+e.getMessage());
		} 
		catch (IOException e) 
		{
			System.out.println("Screen Record Start IOException Error : "+e.getMessage());
		} 
		catch (AWTException e) 
		{
			System.out.println("Screen Record Start AWTException Error : "+e.getMessage());
		}
    
    }
    public void stopRecording()
    {
    	// Call the stop method of ScreenRecorder to end the recording
      try 
      {
		this.screenRecorder.stop();
      } 
      catch (IOException e) 
      {
    	  System.out.println("Screen Record Stop IOException Error : "+e.getMessage());
      }
    }
	
    
	public void SendTestAlertMessageAs(WebDriver drivernew, String Message) 
	{  
	  try 
	  {
		  		  
		//Generating Alert Using Javascript Executor
		  //JavascriptExecutor js = (JavascriptExecutor)driver;
		  
		  //System.out.println(" Before Alert Message Execution ");
		  //String script="alert('" +Message+ " ');";

		  
		  if (drivernew instanceof JavascriptExecutor) 
		  {
				((JavascriptExecutor) drivernew)
					.executeScript("alert( '"+Message+"' );");
		  }
		  
		  Thread.sleep(2000);
		  drivernew.switchTo().alert().accept();
		  
//		  Robot robot=new Robot();
//		  robot.keyPress(KeyEvent.VK_SPACE);
		  
		  
//		  System.out.println(" Middle Alert Message Execution " + script);
		  //js.executeScript(script);
		  
//		  System.out.println(" After Alert Message Execution 0 ");
		  //Thread.sleep(5000);
		  
		  
		  
		  //WebDriverWait wait = new WebDriverWait(driver, 2);
	      //wait.until(ExpectedConditions.alertIsPresent());
	      //System.out.println(" After Alert Message Execution 0.1 ");
	      
	      //js.executeScript( "window.onbeforeunload = function(e){};" );
	      
//		  driver.switchTo().alert().accept();
//		  System.out.println(" After Alert Message Execution ");
		  
//		  driver.Keyboard.PressKey(Keys.Tab);
//		  driver.Keyboard.PressKey(Keys.Space);
	  } 
	  catch (Exception e) 
	  {
		System.out.println(" Exception When show Alert " +e.getMessage());
	  }
	}
	
	public String takeScreenshot(WebDriver drivernew)
	{
		String Userdirector=System.getProperty("user.dir");
		String customelocation="\\ScreenShots\\";
		String datetimesec= new SimpleDateFormat("MM-dd-yyyy_HH-ss")
				.format(new GregorianCalendar().getTime());
		datetimesec=datetimesec+"-"+System.nanoTime();
		
		String Path= (""+Userdirector +customelocation +datetimesec);
		
		String failureImageFileName= Path +"_" +currentMethodName + ".jpg";
		
		
		//Capture entire page screenshot and then store it to destination drive
		File screenshot = ((TakesScreenshot)drivernew).getScreenshotAs(OutputType.FILE);
		
		try 
		{
		  FileUtils.copyFile(screenshot, new File(failureImageFileName));
		  RLog(drivernew, "IMG","Screenshot Captured");
		  return failureImageFileName;
		} 
		catch (IOException e) 
		{
		  RLog(drivernew, "INFO","Unable to copy the screen shot file "+ e.getMessage());
		}
		return null;
		
	}
	
	public static String GetStringFromSentence(String InputSendence, int SpecifyTheWordPresenceNumber)
	{
		
		String Str 		= new String(InputSendence);
		String[] ss 	= Str.split(" ");
		
		return ss[SpecifyTheWordPresenceNumber].toString();
	}
	
	public static String GetStringFromSentence(String InputSendence, String Separator, int SpecifyTheWordPresenceNumber)
	{
		
		String Str 		= new String(InputSendence);
		String[] ss 	= Str.split(Separator);
		
		return ss[SpecifyTheWordPresenceNumber].toString();
	}
	
	public static String Lastgenerator(WebDriver driver, Partye partytype)
	{
		String DriverwithPartye=((RemoteWebDriver)driver).getSessionId().toString()+"_"+partytype.toString();
		return DriverwithPartye;
		
	}
	
	
	public static String GetCodefromMessage(String fullString, String Master)
	{
		if(Master.toLowerCase().contains("partymaster"))
		{
			return GetStringFromSentence(fullString,1);
		}
		else if(Master.toLowerCase().contains("quotation"))
		{
			return GetStringFromSentence(fullString,2);
		}
		else
		{
			return null;
		}
	}
	
	public static String GetWord(String InputSendence, String separtor,int SpecifyTheWordPresenceNumber)
	{
		return GetStringFromSentence(InputSendence,separtor,SpecifyTheWordPresenceNumber);
	}
	
	public static void RLog(String status,String EnterStringForLoginReport)
	{
		
		
		if(status.toLowerCase().contentEquals("highlog") 
				|| status.toLowerCase().contentEquals("info") 
				|| status.toLowerCase().contentEquals("failimg") 
				|| status.toLowerCase().contentEquals("failinfo")
				|| status.toLowerCase().contentEquals("img"))
		{
			Reporter.log(EnterStringForLoginReport);
			System.out.println("-->"+EnterStringForLoginReport);
			//if(sID==currenct sID)
			//get method name and start time 
			//
			
			if(!currentMethodName.contentEquals("null"))
			{
				//get current log as ArrayList
				
				ArrayList<String> y= new ArrayList<String>();
				
				currentLogtime=new SimpleDateFormat("MM-dd-yyyy_HH-mm-ss.SSS")
						.format(Calendar.getInstance().getTime());
				
				y.add(0, status);
				y.add(1,currentMethodName);
				y.add(2, currentMethodstarttime);
				y.add(3,EnterStringForLoginReport);
				y.add(4,currentLogtime);
				
				Onereport.add(y);

			}
		}
		else
		{
			System.out.println("Error in Add Log type - Other than Frame Work Add Log type in : zFeature : Uttills fail");
		}
		
	}
	
	
	public static void RLog(WebDriver driver, String status,String EnterStringForLoginReport)
	{
		String browserdetails=(((RemoteWebDriver)driver).getCapabilities().getBrowserName().toString()
				+""
				+GetWord(((RemoteWebDriver)driver).getSessionId().toString(),"-",0)
				+"_"
				+((RemoteWebDriver)driver).getCapabilities().getVersion().toString()
				+"_"
				+((RemoteWebDriver)driver).getCapabilities().getPlatform().toString()
				);
		
		String id11 = ((RemoteWebDriver)driver).getSessionId().toString();
		
		System.out.println(browserdetails+GetStringFromSentence(id11,"-",0)+"LOW LOG :  "+EnterStringForLoginReport);
		
		if(status.toLowerCase().contentEquals("highlog") 
				|| status.toLowerCase().contentEquals("info") 
				|| status.toLowerCase().contentEquals("failimg") 
				|| status.toLowerCase().contentEquals("failinfo")
				|| status.toLowerCase().contentEquals("img"))
		{
			Reporter.log(EnterStringForLoginReport);
			System.out.println("-->"+EnterStringForLoginReport);
			
			
			if(MethodBundle.containsKey(id11))
			{
				ArrayList<String> x=MethodBundle.get(id11);
				//x.get(0);
				//x.get(1);
				
				ArrayList<String> y= new ArrayList<String>();
				y.add(0, status);
				
				y.add(1,x.get(0));
				//y.add(1,currentMethodName);//cancreateparty
				
				y.add(2,x.get(1));
				//y.add(2,currentMethodstarttime);//MM-dd-yyyy_HH-mm-ss.SSS
				
				y.add(3,EnterStringForLoginReport);
				y.add(4,currentLogtime);
				y.add(4,id11);
				
				Onereport.add(y);
				
			}
			else
			{
				System.out.println("Frame work issue in RLOG");
			}
			
//			if(!currentMethodName.contentEquals("null"))
//			{
//				//get current log as ArrayList
//				
//				ArrayList<String> y= new ArrayList<String>();
//				
//				currentLogtime=new SimpleDateFormat("MM-dd-yyyy_HH-mm-ss.SSS")
//						.format(Calendar.getInstance().getTime());
//				
//				y.add(0, status);
//				y.add(1,currentMethodName);//cancreateparty
//				y.add(2,currentMethodstarttime);//MM-dd-yyyy_HH-mm-ss.SSS
//				y.add(3,EnterStringForLoginReport);
//				y.add(4,currentLogtime);
//				
//				Onereport.add(y);
//
//			}
		}
		else
		{
			System.out.println("Error in Add Log type - Other than Frame Work Add Log type in : zFeature : Uttills fail");
		}
		
	}
	
	protected static String getCurrentDateTime() 
	{
		String Date=new SimpleDateFormat("MM-dd-yyyy_HH-mm-ss.SSS").format(new GregorianCalendar().getTime());
        return Date;    
    }
	
	public static WebDriver GridBrowserInitialize(String browser,String platform, String browserVersion) //400
	{
		String URL="http://192.168.1.63:8080/index.html";
		
		if (browser.equalsIgnoreCase("firefox"))
		{
			try 
			{
				System.out.println(" Executing on FireFox");
				
				DesiredCapabilities cap = DesiredCapabilities.firefox();
				cap.setBrowserName("firefox");
				
				String Node = "http://192.168.50.87:5555/wd/hub";
				RemoteWebDriver driverfirefox = new RemoteWebDriver(new URL(Node), cap);
				
				driverfirefox.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
				driverfirefox.navigate().to(URL);
				driverfirefox.manage().window().maximize();
				
				Pages.Home(driverfirefox).EFSlogin(driverfirefox,"EFS","sathish","sathish");

				//HomePage Homepagefirefox=PageFactory.initElements(driver, HomePage.class);
				
				//Homepagefirefox.EFSlogin("EFS","sathish","sathish");
				
				driverfirefox.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				
				return driverfirefox;
				
			} 
			catch (MalformedURLException e) 
			{
				System.out.println("Error Fire Fox " +e.getMessage());
			}
		}
		else if (browser.equalsIgnoreCase("chrome"))
		{
			try 
			{
				System.out.println(" Executing on CHROME");
				
				DesiredCapabilities cap = DesiredCapabilities.chrome();
				cap.setBrowserName("chrome");
				
				String Node = "http://192.168.50.87:5557/wd/hub";
				RemoteWebDriver driverchrome = new RemoteWebDriver(new URL(Node), cap);
				
				driverchrome.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
				driverchrome.navigate().to(URL);
				driverchrome.manage().window().maximize();
				
				Pages.Home(driverchrome).EFSlogin(driverchrome,"EFS","sathish","sathish");
				
				//HomePage Homepagechrome=PageFactory.initElements(driver, HomePage.class);
				
				//Homepagechrome.EFSlogin("EFS","sathish","sathish");
				
				driverchrome.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				
				return driverchrome;
				
			} 
			catch (MalformedURLException e) 
			{
				System.out.println("Error Chrome " +e.getMessage());
			}
			
		}
		else if (browser.equalsIgnoreCase("ie"))
		{
			try
			{
				System.out.println(" Executing on IE");
				
				DesiredCapabilities cap = DesiredCapabilities.chrome();
				cap.setBrowserName("ie");
				
				String Node = "http://192.168.50.87:5558/wd/hub";
				RemoteWebDriver driverie = new RemoteWebDriver(new URL(Node), cap);
				
				driverie.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
				driverie.navigate().to(URL);
				driverie.manage().window().maximize();
				
				Pages.Home(driverie).EFSlogin(driverie,"EFS","sathish","sathish");
				
				//HomePage Homepageie=PageFactory.initElements(driver, HomePage.class);
				//Homepageie.EFSlogin("EFS","sathish","sathish");
				
				driverie.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				
				return driverie;
				
			} 
			catch (MalformedURLException e) 
			{
				System.out.println("Error  IE" +e.getMessage());
			}
			
			
		}
		else
		{
			
			throw new IllegalArgumentException("The Browser Type is Undefined");
		}
		return null;
		
	}
	
//	
//	public static WebDriver BrowserInitialize()
//	{
//		try 
//		{
//			f1=new File(System.getProperty("user.dir")+"\\src\\config.properties");
//			FI1=new FileInputStream(f1);
//			Repository1.load(FI1);
//		} 
//		catch (FileNotFoundException e) 
//		{
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
//		catch (IOException e) 
//		{
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		HomePage Homepage =startbrowser(Repository1.getProperty("browser"), Repository1.getProperty("url"));
//		
//		driver.manage().window().maximize();
//		
//		RLog("INFO","Loging in values are = "+ Repository1.getProperty("saasid")+ Repository1.getProperty("username")+ Repository1.getProperty("password"));
//		//driver=
//		Homepage.EFSlogin(Repository1.getProperty("saasid"), Repository1.getProperty("username"), Repository1.getProperty("password"));
//		
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//		return driver;
//	}
//	
//	public static HomePage startbrowser(String browsername, String url)
//	{
//		if(browsername.equalsIgnoreCase("firefox"))
//		{
//			RLog("INFO","Firefox Browser opening in Progress ....");
//			driver=new FirefoxDriver();
//		}
//		else if(browsername.equalsIgnoreCase("chrome"))
//		{
//			RLog("INFO","Chrome Browser opening in Progress ....");
//			System.setProperty("webdriver.chrome.driver", "C:\\Users\\prabakar.inmaa\\Desktop\\soft\\chromedriver.exe");
//			
//			ChromeOptions options = new ChromeOptions();
//			options.addArguments("window-size=1024,768");
//			
//			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
//			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
//			
//			driver = new ChromeDriver(capabilities);
//			
//		}
//		else if(browsername.equalsIgnoreCase("IE"))
//		{
//			RLog("INFO","IE Browser opening in Progress ....");
//			System.setProperty("webdriver.ie.driver", "C:\\Users\\prabakar.inmaa\\Desktop\\soft\\IEDriverServer.exe");
//			
//			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
//			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
//			
//			driver=new InternetExplorerDriver(capabilities);
//		}
//		else
//		{
//			System.out.println("ISSUE");
//		}
//		
//		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//		
//		driver.get(url);
//		
//		driver.manage().window().maximize();
//		RLog("INFO","URL Passing as ..."+url);
//		
//		HomePage Homepage=PageFactory.initElements(driver, HomePage.class);
//		return Homepage;
//	}
//	
//	
//	public static void implicitWait(int timeInsec)
//	{
//		Reporter.log("Waiting for Page load ....");
//		try
//		{
//			driver.manage().timeouts().implicitlyWait(timeInsec, TimeUnit.SECONDS);
//			Reporter.log("Page is Loaded");
//		}
//		catch(Throwable error)
//		{
//			System.out.println("Time out for page load request to complete after "+ timeInsec +" Seconds");
//			Assert.assertTrue(false,"Time out for page load request to complete after "+ timeInsec +" Seconds");
//		}
//	}
//	
	public void driverwait() throws InterruptedException
	{
		Thread.sleep(30000);
	}

}
