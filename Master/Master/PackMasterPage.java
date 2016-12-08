package Master;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PackMasterPage extends TopNavigationPage
{
	//private WebDriver driver;
	
	@FindBy(how=How.XPATH,using=".//*[@id='table-body']/tr[1]/td[2]") 
	private WebElement first;
	
	public PackMasterPage(RemoteWebDriver driverT)//400
	{
		super(driverT);
		this.driver1=driverT;
		System.out.println("PackMaster constructor starts");
	}
	public void PackMastervalidentry()
	{
		first.click();
	}

}
