package Master;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

public class DashboardPage extends TopNavigationPage
{
	WebDriver DashBoarddriver;
	
	public DashboardPage(RemoteWebDriver driverDashboardPage)//400
	{
		super(driverDashboardPage);
		this.DashBoarddriver=driverDashboardPage;
		System.out.println("Dashborad constructor starts");
	}
	public void Goto(WebDriver drivernew) throws InterruptedException
	{
		Pages.TopNavigation(drivernew).Dashboard(drivernew);
		System.out.println("Success Goto");
	}
	public Boolean IsAt(WebDriver drivernew)
	{
		String welcome="Dashboard";
		String text=drivernew.findElement(By.xpath("//a[contains(text(),'Dashboard')]")).getText();
		
		Assert.assertEquals(welcome, text);
		return true;
	}
	

}
