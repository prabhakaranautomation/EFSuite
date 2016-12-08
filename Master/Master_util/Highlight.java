package Master_util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Highlight
{
	public static void heightlight(WebDriver driver, WebElement element)
	{
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		js.executeScript("arguments[0].setAttribute('style','background: yellow; ');", element);
		//'border:2px solid red;
		try 
		{
			Thread.sleep(500);
		}
		
		catch (InterruptedException e) 
		{
			System.out.println("Java script Thread fail " +e.getMessage());
		}
		js.executeScript("arguments[0].setAttribute('style','border: solid 2px white')", element);
	}
	

}
