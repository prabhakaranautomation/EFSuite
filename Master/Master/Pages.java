package Master;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import eSales.EnquiryPage;
import eSales.QuotationPage;

public class Pages 
{
	//public WebDriver driver;
	//public static HomePage a;
	public static <T> T initElements(WebDriver driver, Class<T> pageClassToProxy)//400
	{
		T page = instantiatePage(driver, pageClassToProxy);
		PageFactory.initElements(driver, page);
		return page;
		
	}
	private static <T> T instantiatePage(WebDriver driver, Class<T> pageClassToProxy) //400
	{
		    try 
		    {
		      try 
		      {
		        Constructor<T> constructor = pageClassToProxy.getConstructor(WebDriver.class);//400
		        return constructor.newInstance(driver);
		      } 
		      catch (NoSuchMethodException e) 
		      {
		        return pageClassToProxy.newInstance();
		      }
		    } 
		    
		    catch (InstantiationException e) 
		    {
		      throw new RuntimeException(e);
		    } 
		    
		    catch (IllegalAccessException e) 
		    {
		      throw new RuntimeException(e);
		    } 
		    
		    catch (InvocationTargetException e) 
		    {
		      throw new RuntimeException(e);
		    }
	}
	
	
	public static HomePage Home(WebDriver driver)//400
	{
		HomePage a = initElements(driver,HomePage.class);
		System.out.println("01.01");
		return a;
	}
	public static TopNavigationPage TopNavigation(WebDriver driver)//400
	{
		TopNavigationPage b = initElements(driver,TopNavigationPage.class);
		return b;
	}
	
	public static DashboardPage Dashboard(WebDriver driver)//400
	{
		DashboardPage c = initElements(driver,DashboardPage.class);
		return c;
	}
	public static CarrierMasterPage CarrierMaster(WebDriver driver)//400
	{
		CarrierMasterPage d = initElements(driver,CarrierMasterPage.class);
		return d;
	}
	public static EnquiryPage Enquiry(WebDriver driver)//400
	{
		EnquiryPage e = initElements(driver,EnquiryPage.class);
		return e;
	}
	public static QuotationPage Quotation(WebDriver driver)//400
	{
		QuotationPage f = initElements(driver,QuotationPage.class);
		return f;
	}
	public static PartyMasterPage PartyMaster(WebDriver driver)//400
	{
		PartyMasterPage g = initElements(driver, PartyMasterPage.class);
		return g;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
