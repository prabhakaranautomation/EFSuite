package eSales;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import Master.Pages;
import Master.TopNavigationPage;

public class EnquiryPage extends TopNavigationPage
{
	//private WebDriver driver;
	
	public EnquiryPage(WebDriver driverHomePage)//400
	{
		super(driverHomePage);
		this.driver1=driverHomePage;
		System.out.println("Loginpage constructor starts");
	}

	
	
	public void Goto()
	{
		Pages.TopNavigation(driver1).Enquiry();
		System.out.println("Success Goto CarrierMaster");
	}
}
