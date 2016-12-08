package Master;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Master_util.PageUtils;

public class TopNavigationPage extends PageUtils
{
	//WebDriver TopNavigatiodriver;//protected //200
	//public static HomePage Homepage;
	
	public TopNavigationPage(WebDriver driverTopNavigationPage)//400 200
	{
		super(driverTopNavigationPage);
		this.driver=driverTopNavigationPage;
		//System.out.println("TopNavigationPage constructor starts");
	}
	
	@FindBy(how=How.XPATH,using=".//*[@id='wrapper']/app-bar/header/div[1]/ul/li[1]/a/i/span") 
	private WebElement Menu;
	
	@FindBy(how=How.XPATH,using=".//*[@id='wrapper']/sidebar-menu/div/ul/li[1]/a/b") 
	private WebElement Dashboard;
	
	@FindBy(how=How.XPATH,using=".//*[@id='wrapper']/sidebar-menu/div/ul/li[2]/a/b") 
	private WebElement Task;
	
	@FindBy(how=How.XPATH,using=".//*[@id='wrapper']/sidebar-menu/div/ul/li[3]/a/b") 
	private WebElement Sales;
	
	
	
	
	@FindBy(how=How.XPATH,using=".//*[@id='wrapper']/sidebar-menu/div/ul/li[10]/a/b") 
	private WebElement Reports;
	
	@FindBy(how=How.XPATH,using=".//*[@id='wrapper']/sidebar-menu/div/ul/li[11]/a") 
	private WebElement Master;	
	
	
	@FindBy(how=How.XPATH,using=".//*[@id='wrapper']/subbar-menu/div/ul/li[1]/a/span/b") 
	private WebElement enquiryform;
	
	@FindBy(how=How.XPATH,using=".//*[@id='wrapper']/subbar-menu/div/ul/li[2]/a/span/b") 
	private WebElement CarrierMaster;
	
	@FindBy(how=How.XPATH,using=".//*[@id='wrapper']/subbar-menu/div/ul/li[2]/a/span/b") 
	private WebElement Quotationform;
	
	
	@FindBy(how=How.XPATH,using=".//*[@id='wrapper']/subbar-menu/div/ul/li[15]/a/span/b") 
	private WebElement PartyMasterform;
	
	
	
	@FindBy(how=How.XPATH,using=".//*[@id='wrapper']/app-bar/header/div[2]/div/div[3]/a/div/div") 
	private WebElement logoutoption;
	
	@FindBy(how=How.XPATH,using=".//*[@id='wrapper']/app-bar/header/div[2]/div/div[3]/ul/li/a") 
	private WebElement logout;
	
	public	HomePage EFSlogout(WebDriver drivernew)
	{
		
		logoutoption.click();
		logout.click();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		HomePage Homepage=PageFactory.initElements(drivernew, HomePage.class);
		
		return Homepage;
	}
	
	public	WebDriver EFSlogoutas(WebDriver drivernew)//400
	{
		
		logoutoption.click();
		logout.click();
		
		return drivernew;
		
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Homepage=PageFactory.initElements(driver, HomePage.class);
		//return Homepage;
	}
	
	public void Dashboard(WebDriver drivernew)
	{
		try {
			
			super.clickWhenReady(drivernew, Menu, 30);
			//new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOf(Menu)).click();
			//Menu.click();
			System.out.println("menu clicked");
			Thread.sleep(1000);
			
			super.clickWhenReady(drivernew, Dashboard, 30);

			//new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOf(Dashboard)).click();
			//Dashboard.click();
			System.out.println("Sales clicked");
			Thread.sleep(1000);
			
			//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			//return driver;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void Enquiry()
	{
		try 
		{
			Menu.click();
			System.out.println("menu clicked");
			Thread.sleep(1000);
			
			Sales.click();
			System.out.println("Sales clicked");
			Thread.sleep(1000);
			
			enquiryform.click();
			System.out.println("enquiryform clicked");
			Thread.sleep(1000);
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void Home()
	{
		try {
			Menu.click();
			System.out.println("menu clicked");
			Thread.sleep(1000);
			
			Master.click();
			System.out.println("Sales clicked");
			Thread.sleep(1000);
			
			CarrierMaster.click();
			System.out.println("enquiryform clicked");
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//
	}
	
	public void CarrierMaster(WebDriver drivernew)
	{
		try 
		{
			clickWhenReady(drivernew,Menu,30);
			//Menu.click();
			System.out.println("menu clicked");
			Thread.sleep(1000);
			
			clickWhenReady(drivernew, Master, 30);
			//Master.click();
			System.out.println("Master clicked");
			Thread.sleep(1000);
			
			clickWhenReady(drivernew, CarrierMaster, 30);
			//CarrierMaster.click();
			System.out.println("enquiryform clicked");
			Thread.sleep(1000);
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void PartyMaster(WebDriver drivernew)
	{
		try 
		{
			Thread.sleep(2000);
			clickWhenReady(drivernew, Menu, 30);
			System.out.println("menu clicked");
			
			clickWhenReady(drivernew, Master, 30);
			System.out.println("Master clicked");
			
			//Master.sendKeys(Keys.PAGE_DOWN);
			
			Thread.sleep(2000);
			//scroll(drivernew,PartyMasterform);
			System.out.println("PartyMasterform scroll");
			
			//clickWhenReady(drivernew, PartyMasterform, 30);
			FindAndClick(drivernew, PartyMasterform);
			
			System.out.println("PartyMasterform clicked");
			
		} 
		catch (Exception e) 
		{
			RLog(drivernew,"INFO","Top Navigation Party Master Error "+e.getMessage());
		}
	}
	
	public void Quotation(WebDriver drivernew)
	{
		try 
		{
			Thread.sleep(1000);
			//FindAndClick(Menu);
			clickWhenReady(drivernew, Menu, 30);
			//System.out.println("top navigation menu clicked");
			Thread.sleep(1000);
			clickWhenReady(drivernew, Sales, 30);
			//System.out.println("top navigation Sales Module clicked");

			Thread.sleep(1000);
			clickWhenReady(drivernew, Quotationform, 30);
			//System.out.println("top navigation Quotationform clicked");
		} 
		catch (Exception e) {
			RLog(drivernew,"INFO","Top Navigation Quotation Navigation error" +e.getMessage());
		}
	}
	

}
