package Master;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import org.testng.Reporter;

import com.relevantcodes.extentreports.LogStatus;

import Master_util.Highlight;
import Master_util.PageUtils;
import testUtills.Utills;

public class HomePage extends PageUtils
//extends Utills
{
	
	WebDriver Homedriver;
	//public static DashboardPage Dashboardpage;
	
	public HomePage(WebDriver driverHomePage) //400
	{
		super(driverHomePage);
		this.Homedriver=driverHomePage;
	}
	
	@FindBy(id="saasId") 
	private WebElement saasId;
	
	@FindBy(id="userName") 
	private WebElement userName;
	
	@FindBy(id="Password") 
	private WebElement Password;
	
	@FindBy(how=How.XPATH,using=".//*[@id='loginForm']/div[2]/input") 
	private WebElement submit_button;
	
	@FindBy(how=How.LINK_TEXT,using="Trouble signing in ?") 
	private WebElement forget_password;
	
	@FindBy(how=How.XPATH,using="html/body/div[1]/div/div[2]/div/div/ul[2]/li[1]/a") 
	private WebElement poweredby;
	
	@FindBy(how=How.XPATH,using=".//*[@id='loginForm']/div[3]/div[2]/div[2]/span/small") 
	private WebElement userName_message;
	
	@FindBy(how=How.XPATH,using=".//*[@id='loginForm']/div[1]/span") 
	private WebElement message;
	
	@FindBy(how=How.CSS,using="span[class='ng-binding']") 
	private WebElement login_Errormessage;
	
//	@FindBy(how=How.CSS,using="div[class^='alert'][class*='alert-danger']") 
//	private WebElement Screen_Error_Window;
	/**
	public void LogInAsLastGeneratedUser()
	{
		EFSlogin(UserGenerator.LastGeneratedUser);
	}
	public void LogInAsLastRegisteredUser(LoginOptions userLastGeneratedPassword)
	{
		EFSlogin(UserGenerator.LastGeneratedUser);
	}
	**/
	
//	public String GetScreenError()
//	{
//		if(isElementPresent(Screen_Error_Window))
//		{
//			String ScreenErrorMessage=Screen_Error_Window.findElement(By.cssSelector("span[class='ng-binding']")).getText();
//			Screen_Error_Window.findElement(By.tagName("a")).click();
//			return ScreenErrorMessage;
//		}
//		return null;
//	}
	
//	public boolean isElementPresent(WebElement findelement)
//	{
//		try 
//		{
//			String text=findelement.getText();
//			return true;
//		} 
//		catch (Exception e) 
//		{
//			System.out.println(" isElementPresent = No, Element Not Present  ....");
//			return false;
//		}
//	}
	
	public String EFSlogin(WebDriver drivernew, String id, String name, String pass)
	{
		try {
			
			clickWhenReady(drivernew, saasId, 90);
			
			ClickAndClear(drivernew, saasId);
			Highlight.heightlight(drivernew, saasId);
			saasId.sendKeys(id);
			RLog(drivernew, "INFO","Saas ID entered as..."+id);
			
			
			userName.clear();
			Highlight.heightlight(drivernew, userName);
			userName.sendKeys(name);
			RLog(drivernew, "INFO","User Name entered as..."+name);
			
			Password.clear();
			Highlight.heightlight(drivernew, Password);
			Password.sendKeys(pass);
			RLog(drivernew, "INFO","Password entered as .. "+pass);
			
			//Highlight.heightlight(drivernew, submit_button);
			submit_button.click();
			
			RLog(drivernew, "INFO","iSign In button pressed ..");
			
			return null;//CheckFinal();
			
		} catch (Exception e) 
		{
			return e.getMessage();
		}
	}
	public void ClickLostyourPasswordLink()
	{
		 forget_password.click();
	}
	public Boolean isLoginSuccessfull(WebDriver drivernew)
	{
		String welcome="Dashboard";
		String text=drivernew.findElement(By.xpath("//a[contains(text(),'Dashboard')]")).getText();
		
		Assert.assertEquals(welcome, text);
		return true;
	}
	public boolean IsAt(WebDriver drivernew) throws InterruptedException
	{
		System.out.println("01.02");
		if(drivernew.findElements(By.xpath("html/body/div[1]/div/div[2]/div/div/ul[2]/li[1]/a")).size()>0)
		{
			System.out.println("01.03");
			return true;
		}
		else
		{
			System.out.println("else 01.04");
			return false;
		}
	}
	public void Goto(WebDriver drivernew) throws InterruptedException
	{
		boolean a=Pages.Home(drivernew).IsAt(drivernew);
		if(a==false)
		{
			Pages.TopNavigation(drivernew).EFSlogout(drivernew);
		}
	}
	
	
	

}
