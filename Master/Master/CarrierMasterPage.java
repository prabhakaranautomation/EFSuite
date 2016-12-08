package Master;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import Master_util.PageUtils;

public class CarrierMasterPage extends PageUtils
{
	WebDriver driver;
	public CarrierMasterPage(RemoteWebDriver driverCarrierMasterPage)//400
	{
		super(driverCarrierMasterPage);
		this.driver=driverCarrierMasterPage;
		//System.out.println("CarrierMasterPage constructor starts");
	}

	
	@FindBy(how=How.XPATH,using=".//*[@id='main-view']/div/div/div[1]/div/div[1]/div/div[1]/div/a") 
	private WebElement Master_CarrierMasterage_Add_Carrier_button;
	
	
	
	@FindBy(how=How.XPATH,using=".//*[@id='carrier-panel']/div[2]/div/button-group/div/div[1]/button") 
	private WebElement Master_CarrierMasterage_Add_Carrier_Transport_Mode_Air;
	
	@FindBy(how=How.XPATH,using=".//*[@id='carrier-panel']/div[2]/div/button-group/div/div[2]/button") 
	private WebElement Master_CarrierMasterage_Add_Carrier_Transport_Mode_Ocean;
	
	@FindBy(how=How.XPATH,using=".//*[@id='carrier-panel']/div[2]/div/button-group/div/div[3]/button") 
	private WebElement Master_CarrierMasterage_Add_Carrier_Transport_Mode_Rail;
	
	@FindBy(how=How.XPATH,using=".//*[@id='carrier-panel']/div[2]/div/button-group/div/div[4]/button") 
	private WebElement Master_CarrierMasterage_Add_Carrier_Transport_Mode_Road;
	
	
	
	@FindBy(how=How.ID,using="carrierName") 
	private WebElement Master_CarrierMasterage_Add_Carrier_CarrierName;
	
	@FindBy(how=How.XPATH,using=".//*[@id='carrierCode']") 
	private WebElement Master_CarrierMasterage_Add_Carrier_Code;
	
	@FindBy(how=How.XPATH,using=".//*[@id='carrier-panel']/div[5]/div/div/div[1]/input") 
	private WebElement Master_CarrierMasterage_Add_Carrier_CarrierNo;
	
	@FindBy(how=How.XPATH,using=".//*[@id='iataCode']") 
	private WebElement Master_CarrierMasterage_Add_Carrier_ICAOCode;
	
	@FindBy(how=How.XPATH,using=".//*[@id='scacCode']") 
	private WebElement Master_CarrierMasterage_Add_Carrier_SCACCode;
	
	
	
	public void CarrierMasterAddNewAir(WebDriver drivernew, String carrierName, String carrierCode, String carrierNo, String ICAOCode)
	{
		Master_CarrierMasterage_Add_Carrier_button.click();
		System.out.println("Add_Carrier_button Clicked");
		
		try 
		{
			Thread.sleep(5000);
		} 
		catch (InterruptedException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Master_CarrierMasterage_Add_Carrier_Transport_Mode_Air.click();
		System.out.println("Transport_Mode_Air.clicked ");
		
		Master_CarrierMasterage_Add_Carrier_CarrierName.sendKeys(carrierName);
		System.out.println("Carrier Name Entered  ");
		
		Master_CarrierMasterage_Add_Carrier_Code.sendKeys(carrierCode);
		System.out.println("Carrier Code Entered  ");
		
		Master_CarrierMasterage_Add_Carrier_CarrierNo.sendKeys(carrierNo);
		System.out.println("Carrier No Entered  ");
		
		Master_CarrierMasterage_Add_Carrier_ICAOCode.sendKeys(ICAOCode);
		System.out.println("ICAOCode Entered  ");
		try 
		{
			Thread.sleep(5000);
		} 
		catch (InterruptedException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void Goto(WebDriver drivernew)
	{
		Pages.TopNavigation(drivernew).CarrierMaster(drivernew);
		System.out.println("Success Goto CarrierMaster");
	}
	
}
