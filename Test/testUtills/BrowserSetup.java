package testUtills;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Optional;

public class BrowserSetup 
{

	public BrowserSetup(String browser, @Optional("none") String browserVersion, String platform)
	{
		if (browser.equalsIgnoreCase("firefox"))
		{
			
	
	//	        FirefoxProfile fp = new FirefoxProfile();
	//	        dc.setCapability(FirefoxDriver.PROFILE, fp);
			
//				DesiredCapabilities dc = new DesiredCapabilities();
//		        dc.setBrowserName(DesiredCapabilities.firefox().getBrowserName());
			
//		        threadDriver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), dc));
			
			try 
			{
				System.out.println(" Executing on FireFox");
				
				DesiredCapabilities cap = DesiredCapabilities.firefox();
				cap.setBrowserName("firefox");
				String Node = "http://192.168.50.87:5555/wd/hub";
				WebDriver driverfirefox = new RemoteWebDriver(new URL(Node), cap);
				
				//return  driverfirefox;
			} 
			catch (MalformedURLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
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
				WebDriver driverchrome = new RemoteWebDriver(new URL(Node), cap);
				//return  driverchrome;
			} 
			catch (MalformedURLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		}
		//return null;
	}

}
