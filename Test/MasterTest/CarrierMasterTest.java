package MasterTest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Master.Pages;

public class CarrierMasterTest extends Testbase
{
	private WebDriver driver;
	@Test(dataProvider="Dataprovider")
	public void CarrierMasterAirNewTest(String carrierName, String carrierCode, String carrierNo, String ICAOCode) throws Exception
	{
		
		Thread.sleep(1000);
		System.out.println("Logged in completed ..");
		
		Pages.CarrierMaster(driver).Goto(driver);
		System.out.println("Carrier Master Page Opening ");
		Thread.sleep(1000);
		
		Pages.CarrierMaster(driver).CarrierMasterAddNewAir(driver,carrierName, carrierCode,carrierNo, ICAOCode);
		Thread.sleep(2000);
		System.out.println("Air Carrier Master Page Entry done ");
		
		//Pages.Enquiry(driver).Goto();
		//System.out.println("done3");
		
		/**
		Pages.Home(driver).Goto();
		Pages.Home(driver).EFSloginas("EFS", "sathish", "sathish");
		**/
	}
	
	
}
