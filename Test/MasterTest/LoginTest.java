package MasterTest;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import Master.Pages;

//@Listeners(TestNGListerner2.class)
public class LoginTest extends Testbase
{
	//private WebDriver driver1;
	@Test(dataProvider="Dataprovider")
	public void loginvalid(String saasId, String userName, String password) throws Exception
	{
		System.out.println("01");
		boolean q=Pages.Home(driver1).IsAt(driver1);
		System.out.println("02"+q);
		if(q==false)
		{
			System.out.println("03");
			driver1=Pages.TopNavigation(driver1).EFSlogoutas(driver1);
			System.out.println("Came in so made log out");
		}
		Thread.sleep(2000);
		System.out.println("04");
		Pages.Home(driver1).EFSlogin(driver1,saasId, userName, password);
		Thread.sleep(2000);
		//login_Errormessage
		
		Assert.assertTrue(Pages.Dashboard(driver1).IsAt(driver1));
		//driver=Pages.TopNavigation(driver).EFSlogoutas();
		
	}
	@Test(dataProvider="Dataprovider")
	public void logininvalid(String saasId, String userName, String password) throws Exception
	{
		boolean q=Pages.Home(driver1).IsAt(driver1);
		RLog(driver1, "INFO","Checking we are in LoginPage or not ... "+q);
		if(q==false)
		{
			driver1=Pages.TopNavigation(driver1).EFSlogoutas(driver1);

			RLog(driver1, "INFO","LoginPage not available so doing logout Done... ");
		}
		Thread.sleep(2000);
		RLog(driver1, "INFO","Login Started ... ");
		String Output=Pages.Home(driver1).EFSlogin(driver1,saasId, userName, password);
		
		RLog(driver1, "INFO",Output);
		System.out.println("Login invalid started 3 ");
		Thread.sleep(2000);
		
		
		
		Assert.assertTrue(Pages.Dashboard(driver1).IsAt(driver1));
		/**
		if(Pages.Dashboard(driver).IsAt()==false)
		{
			Pages.Home(driver).Getmessage();
			
		}
		else
		{
			
		}
		
		**/
		
		//driver=Pages.TopNavigation(driver).EFSlogoutas();

	}
}
