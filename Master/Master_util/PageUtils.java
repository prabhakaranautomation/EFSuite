package Master_util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import testUtills.Utills;


public class PageUtils extends Utills
{
	//extends Utills
	//protected WebDriver driver1;//400 200
	
	//WebDriver Pageutildriver;
	public PageUtils(WebDriver driverTopNavigationPage)//400
	{
		this.driver=driverTopNavigationPage;
		//System.out.println("PageUtils constructor starts");
	}
	
	@FindBy(how=How.CSS,using="input[class^='btn'][value='Save']")//ul[class^='list-inline'][class*='text-right'][class$='masopertion-action']
	public static WebElement CommonSAVE;
	
//	@FindBy(how=How.CSS,using="div[class^='panel'][class*='panel-default'][class$='masOpertion']") 
//	public static WebElement Common_Page;//Add_Quote_Page
	
	@FindBy(how=How.ID,using="service-panel") 
	public static WebElement Common_Page;//Add_Quote_Page
	
	@FindBy(how=How.ID,using="partyMain-panel") 
	public static WebElement Add_Quote_Page;//
	
	@FindBy(how=How.CSS,using="div[role='document'][class='ngdialog-content']")
	private WebElement Confirmation_Message;
	
	@FindBy(how=How.CSS,using="div[class='ngdialog-footer']") 
	private WebElement Confirmation_Message_Footer;
	
//	@FindBy(how=How.CSS,using="div[class='ngdialog-close']") 
//	private WebElement Confirmation_Message_close;
	
	
	
	@FindBy(how=How.CSS,using="span[class$='error-message']") 
	private WebElement Screen_Error_Window;
	
	@FindBy(how=How.CSS,using="div[class^='alert'][class*='alert-danger'][class$='fixed']") 
	private WebElement Screen_Side_Alert_Window;
	
	
	
	@FindBy(how=How.CSS,using="ul[id^='ui-id'][style^='display: block;']") 
	private WebElement LOV_LIST_PANEL;
	
	@FindBy(how=How.CLASS_NAME,using="ui-state-focus") 
	private WebElement Add_Quote_LOV_Focuson;
	

//	
//	@FindBy(how=How.CSS,using=".opc-5.f-12b4") 
//	private WebElement Add_Quote_StartIndicator;
	
	@FindBy(how=How.CSS,using="button[class^='btn'][ng-click='cancel()'][class$='btn-gray']") 
	private WebElement View_Screen_Back_btn;

	@FindBy(how=How.CSS,using="div[class^='col-xs-4'][class$='ng-scope']") 
	private List<WebElement> CHECKBOXBANKHEADERtop;
	
	@FindBy(how=How.CSS,using="table[class='table super-table floatThead-table']") 
	private WebElement Listscreen_header;
	
	@FindBy(how=How.ID,using="super-table") 
	private WebElement Listscreen_Details;
	
	
	
	
	
	public boolean IsRowpresentInListScreen()
	{
		List<WebElement> BodyListRows=Listscreen_Details
				.findElement(By.tagName("tbody"))
				.findElements(By.tagName("tr"));
		
		System.out.println("List screen rows count "+BodyListRows.size());
		if(BodyListRows.size()==0)
		{
			
			return false;
		}
		else
		{
			return true;
		}
	}
	
	public void EnterListscreenSearch(WebDriver drivernew, String LabelStringValue, String Value)
	{
		System.out.println("EnterListscreenSearch 1 : "+getCurrentDateTime());
		try 
		{
			Thread.sleep(2000);
		} 
		catch (InterruptedException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int finalsingleelementpositionnumber=0;
		//Listscreen_header is the header table 
		//HeaderRowEleemnts is the Row in the table that is Lable row and Text box row 
		
		
		List<WebElement> HeaderRowEleemnts = Listscreen_header
				.findElement(By.tagName("thead"))
				.findElements(By.tagName("tr"));
		
		//To get the header Lable row 
		WebElement head=HeaderRowEleemnts.get(0);
		
		// Inside the headerlable row to identify the list of lables  
		List<WebElement> allheader=head.findElements(By.tagName("th"));
		
		//inside the lable row chekcing which lable is match  as per input parameter 
		for(int j=0;j<allheader.size();j++)
		{
			WebElement finalsingleelement = allheader.get(j);
			if(finalsingleelement.getText().contentEquals(LabelStringValue))
			{
				finalsingleelementpositionnumber=j;
			}
		}
		System.out.println("Name in "+finalsingleelementpositionnumber);
		
		
//		driver.findElement(By.xpath(".//*[@id='main-view']/div/div/div[1]/div/div[3]/div/super-table/div/table/thead/tr[2]/th[2]/input"))
//										.sendKeys(Value);
//		
//		
		
		// to get the Text Box row
		WebElement headTextboxRow =HeaderRowEleemnts.get(1);
		
		// to get all the text boxes 
		List<WebElement> allheaderTextbox=headTextboxRow.findElements(By.tagName("th"));
		
		System.out.println("Total text Boxes th count " +allheaderTextbox.size());
		
		//SendAlertMessageAs("Inside : "+i);
		WebElement singletextbox=allheaderTextbox.get(finalsingleelementpositionnumber);
		System.out.println("th table get text" +singletextbox.getText());
		
		WebElement finalsingleelementTextbox =singletextbox.findElement(By.tagName("input"));
		
		clickWhenReady(drivernew, finalsingleelementTextbox, 30);
		//driver.findElement(By.xpath(".//*[@id='main-view']/div/div/div[1]/div/div[3]/div/super-table/div/table/thead/tr[2]/th[2]/input")).click();
		
		


		for(int i=0;i<Value.length();i++)
		{
			System.out.println(Value.charAt(i));
			finalsingleelementTextbox.sendKeys(String.valueOf(Value.charAt(i)));
			try 
			{
				Thread.sleep(2000);
			} 
			catch (InterruptedException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		finalsingleelementTextbox.sendKeys(Keys.TAB);
		
		
	}
	
	public String ClickListscreen(String LabelStringValue, String Value)
	{
		try 
		{
			Thread.sleep(2000);
		} 
		catch (InterruptedException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String clickedvalue=null;
		int finalsingleelementpositionnumber=0;
		
		//Listscreen_header is the header table 
		//HeaderRowEleemnts is the Row in the table that is Lable row and Text box row 
		
		
		List<WebElement> HeaderRowEleemnts = Listscreen_header
				.findElement(By.tagName("thead"))
				.findElements(By.tagName("tr"));
		
		//To get the header Lable row 
		WebElement head=HeaderRowEleemnts.get(0);
		
		// Inside the headerlable row to identify the list of lables  
		List<WebElement> allheader=head.findElements(By.tagName("th"));
		
		//inside the lable row chekcing which lable is match  as per input parameter 
		for(int j=0;j<allheader.size();j++)
		{
			WebElement finalsingleelement = allheader.get(j);
			if(finalsingleelement.getText().contentEquals(LabelStringValue))
			{
				finalsingleelementpositionnumber=j;
			}
		}
		
		System.out.println("ClickListscreen" +finalsingleelementpositionnumber);
		
		List<WebElement> BodyListRows=Listscreen_Details
				.findElement(By.tagName("tbody"))
				.findElements(By.tagName("tr"));
		
		System.out.println("ClickListscreen List body details "+ BodyListRows.size());

		// To work in all the rows 
		for(int j=0;j<BodyListRows.size();j++)
		{
			//To get single row from all the rows 
			WebElement BodyListSinglerow=BodyListRows.get(j);
			
			//To Get all the elements in the row 
			List<WebElement> element=BodyListSinglerow.findElements(By.tagName("td"));
			
			// to check Label name column number equal body column number text !! matches then click 
			if(element.get(finalsingleelementpositionnumber).getText().contentEquals(Value))
			{
				clickedvalue=element.get(finalsingleelementpositionnumber).getText();
				element.get(finalsingleelementpositionnumber).click();
				return clickedvalue;
			}
			
		}
		try 
		{
			Thread.sleep(1000);
		} 
		catch (InterruptedException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void SavePage(WebDriver Drivernew)
	{
		FindAndClick(Drivernew, CommonSAVE);
		RLog(Drivernew,"INFO"," Save Button clicked ");
	}
	
	public void ClickAndClear(WebDriver drivernew, WebElement element)
	{
		clickWhenReady(drivernew, element, 10);
		element.clear();
	}
	
	public void FindAndClick(WebDriver Drivernew, WebElement elementnew)
	{
		//WebElement element = driver.findElement(By("elementnew"));
		
		try 
		{
			Actions action = new Actions(Drivernew);
			action.moveToElement(elementnew).click(elementnew).build().perform();
			//elementnew.click();
		} 
		catch (Exception e) 
		{
			System.out.println("Find And Click Error Occured "+e.getMessage());
		}
	}
	
	public void SendAlertMessageAs(WebDriver drivernew, String Message) 
	{  
	  try 
	  {
		//Generating Alert Using Javascript Executor
		  JavascriptExecutor js = (JavascriptExecutor) drivernew;
		  
		  System.out.println(" Before Alert Message Execution ");
		  String script="alert('" +Message+ " ');";
		  
		  System.out.println(" Middle Alert Message Execution " + script);
		  js.executeScript(script);
		  
		  System.out.println(" After Alert Message Execution ");
		  Thread.sleep(2000);
		  drivernew.switchTo().alert().accept();
		  
	  } 
	  catch (Exception e) 
	  {
		System.out.println(" Exception When show Alert " +e.getMessage());
	  }
	}
	
	public String GetConfirmationMessage()
	{
		//clickWhenReady(Confirmation_Message, 30);
		
		String FinalMessage=Confirmation_Message.findElement(By.tagName("p")).getText();
		System.out.println("uu");
		Confirmation_Message.findElement(By.cssSelector("div[class='ngdialog-footer']"))
							.findElement(By.tagName("button"))
							.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("GetConfirmationMessage brfore check back button present or not end time : "+getCurrentDateTime());
		
		
		
		
		
		if(isElementPresent(View_Screen_Back_btn)==true)
		{
			View_Screen_Back_btn.click();
			System.out.println("Back button present "+getCurrentDateTime());
		}
		else
		{
			System.out.println("Back button not present "+getCurrentDateTime());
		}
		
		
		
		
		//clickWhenReady(View_Screen_Cancel_btn, 20);
		
		//WebElement MessageFooder = Confirmation_Message.findElement(By.cssSelector("div[class='ngdialog-footer']"));
		//WebElement OkButton = MessageFooder.findElement(By.tagName("button"));

		//System.out.println("Confirmation_Message ok button is displayed " + OkButton.isDisplayed()+ "__" +OkButton.getText()+ "--" +OkButton.getTagName());
		
		//OkButton.click();
		System.out.println("GetConfirmationMessage end time : "+getCurrentDateTime());
		return FinalMessage;
	}
	
	public String CheckFinal(WebDriver drivernew)
	{
		System.out.println("1");
		System.out.println("1 : "+getCurrentDateTime());
		System.out.println("2");
//		
//		try 
//		{
//			System.out.println(""+ Confirmation_Message.isDisplayed());
//		} 
//		catch (Exception e) 
//		{
//			System.out.println("error : "+e.getMessage());
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println("2.1");
//		boolean ConfirmationMessage1 =isElementPresent(Confirmation_Message_close);
//		
//		try 
//		{
//			System.out.println(""+ Confirmation_Message_close.isDisplayed());
//		} 
//		catch (Exception e) 
//		{
//			System.out.println("error : "+e.getMessage());
//			
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		//System.out.println("_"+Confirmation_Message_close.isEnabled());
		//System.out.println("_"+Confirmation_Message_close.isSelected());
		
		boolean ConfirmationMessage2 =isElementPresent(Confirmation_Message_Footer);
		//System.out.println("1"+ Confirmation_Message_Footer.isDisplayed()+"_"+Confirmation_Message_Footer.isEnabled()+"_"+Confirmation_Message_Footer.isSelected());
		
		boolean ConfirmationMessageBoolean =isElementPresent(Confirmation_Message);
		
		boolean Side_Alert_ErrorBoolean=isElementPresent(Screen_Side_Alert_Window);
		boolean elementerrorBoolean=isElementPresent(Screen_Error_Window);
		
		//.//*[@id='ngdialog1']/div[2]/div[1]/button
		
		System.out.println("2 : "+getCurrentDateTime());
		
		System.out.println(""
								+ConfirmationMessageBoolean
								+Side_Alert_ErrorBoolean
								+elementerrorBoolean);
		if(ConfirmationMessageBoolean==true && Side_Alert_ErrorBoolean==true && elementerrorBoolean==true)
		{
			System.out.println("FinalErrorCheck 111");
			System.out.println("3 : "+getCurrentDateTime());
			
			String Side_Alert_Error=Screen_Side_Alert_Window.findElement(By.tagName("span")).getText();
			Screen_Side_Alert_Window.findElement(By.tagName("a")).click();
			RLog(drivernew,"INFO","*****Alert Message is : "+Side_Alert_Error);
			
			String ConfirmationMessage=GetConfirmationMessage();
			
			RLog(drivernew,"INFO","*****Confirmation Message is : "+ConfirmationMessage );
			
			
			RLog(drivernew,"INFO","*****CONFIRMATION, ALERT ERROR AND FIELD ERROR PRESENT KINDLY CHECK ");
			
			String Error = ConfirmationMessage+" AND "+Side_Alert_Error;
			RLog(drivernew,"INFO","3 Error Issue : Alert Message AND Confirmation Message is : "+Error);

			//////////////////////////
			//need to handle Field Error 
			return Error;
		}
		
		else if(!ConfirmationMessageBoolean==true && Side_Alert_ErrorBoolean==true && elementerrorBoolean==true)
		{
			System.out.println("4 : "+getCurrentDateTime());
			System.out.println("FinalErrorCheck 011");
			
			String Side_Alert_Error=Screen_Side_Alert_Window.findElement(By.tagName("span")).getText();
			Screen_Side_Alert_Window.findElement(By.tagName("a")).click();
			RLog(drivernew,"INFO","*****Alert Message is : "+Side_Alert_Error);
			
			String elementerror = GetError();
			RLog(drivernew,"INFO","*****Field Error Present Error is " + elementerror);
			
			if(elementerror.contentEquals("")==true)
			{
				String Error =Side_Alert_Error;
				RLog(drivernew,"INFO","*****Alert Message  is :"+Side_Alert_Error);
				return Error;
			}
			else
			{
				RLog(drivernew,"INFO","*****ALERT ERROR AND FIELD ERROR PRESENT KINDLY CHECK ");
				String Error =Side_Alert_Error+"AND"+elementerror;
				RLog(drivernew,"INFO","Alert Message AND FIELD ERROR is :"+Side_Alert_Error+ " AND "+ "Element Error Is : " +elementerror);
				return Error;
			}
		}
		
		else if(ConfirmationMessageBoolean==true && Side_Alert_ErrorBoolean==true && !elementerrorBoolean==true)
		{
			System.out.println("5 : "+getCurrentDateTime());
			System.out.println("FinalErrorCheck 110");
			
			String Side_Alert_Error=Screen_Side_Alert_Window.findElement(By.tagName("span")).getText();
			Screen_Side_Alert_Window.findElement(By.tagName("a")).click();
			RLog(drivernew,"INFO","*****Alert Message is : "+Side_Alert_Error);
			
			String ConfirmationMessage=GetConfirmationMessage();
			RLog(drivernew,"INFO","*****Confirmation Message is : "+ConfirmationMessage);
			
			RLog(drivernew,"INFO","*****CONFIRMATION AND ALERT ERROR PRESENT KINDLY CHECK ");
			
			String error =""+ConfirmationMessage+Side_Alert_Error;
			RLog(drivernew,"INFO","*****Alert Message AND Confirmation message is :" +Side_Alert_Error+"AND"+ConfirmationMessage);
			return error;
		}
		else if(ConfirmationMessageBoolean==true && !Side_Alert_ErrorBoolean==true && elementerrorBoolean==true)
		{
			System.out.println("6 : "+getCurrentDateTime());
			System.out.println("FinalErrorCheck 101");
			String ConfirmationMessage=GetConfirmationMessage();
			RLog(drivernew,"INFO","Confirmation Message is : "+ConfirmationMessage);
			/////////////////////
			//need to handle for Field Error 
			
			RLog(drivernew,"INFO","*****CONFIRMATION AND FIELD ERROR PRESENT KINDLY CHECK ");
			System.out.println("FinalErrorCheck last 6  time : "+getCurrentDateTime());
			return ConfirmationMessage;
			
		}
		else if(ConfirmationMessageBoolean==true && !Side_Alert_ErrorBoolean==true && !elementerrorBoolean==true)
		{
			System.out.println("7 : "+getCurrentDateTime());
			System.out.println("FinalErrorCheck 100");
			String ConfirmationMessage=GetConfirmationMessage();
			RLog(drivernew,"INFO","Confirmation message is :" +ConfirmationMessage);
			
			return ConfirmationMessage;
		}
		else if(!ConfirmationMessageBoolean==true && Side_Alert_ErrorBoolean==true && !elementerrorBoolean==true)
		{
			System.out.println("8 : "+getCurrentDateTime());
			System.out.println("FinalErrorCheck 101");
			String Side_Alert_Error=Screen_Side_Alert_Window.findElement(By.tagName("span")).getText();
			Screen_Side_Alert_Window.findElement(By.tagName("a")).click();
			RLog(drivernew,"INFO","Alert Message is :"+Side_Alert_Error);
			
			return Side_Alert_Error;
		}
		else if(!ConfirmationMessageBoolean==true && !Side_Alert_ErrorBoolean==true && elementerrorBoolean==true)
		{
			System.out.println("9 : "+getCurrentDateTime());
			System.out.println("FinalErrorCheck 001");
			String elementerror= GetError();
			RLog(drivernew,"INFO","Field Error Present Error is " + elementerror);
			return elementerror;
		}
		else
		{
			System.out.println("Screen Error, element Error and Confirmation Message not available ... ");
			
		}
		
		System.out.println("2 : "+getCurrentDateTime());
		return null;
	}
	
	public void enterDate(WebDriver drivernew, WebElement element, int period,String format)//success
	{
		element.click();
		Highlight.heightlight(drivernew, element);
		element.sendKeys(getDate(period, format));
		element.sendKeys(Keys.TAB);
	}
	
	public String getDate(int period,String format) // success
	{
		//Parameters :
		//period : no of days gap between the current and desired date
		//format : Format of the date (Ex : dd/MM/yyyy . yyyy MMM dd)
		
	     Calendar currentDate = Calendar.getInstance();
	     SimpleDateFormat formatter= new SimpleDateFormat(format);
	     currentDate.add(Calendar.DAY_OF_MONTH, period);
	     String date = formatter.format(currentDate.getTime());
	     return date;
	}
	
/////////////////////////////////////////////////////	
	public void selectDate(String date)
	 {
//		 WebElement dateWidget = driver.findElement(By.id("ui-datepicker-div"));
//		 List<WebElement> rows=dateWidget.findElements(By.tagName("tr"));
//		 List<WebElement> columns=dateWidget.findElements(By.tagName("td"));
//
//		 for (WebElement cell: columns)
//		 {
//			 //Selects Date
//			 if (cell.getText().equals(date))
//			 {
//				 cell.findElement(By.linkText(date)).click();
//				 break;
//			 }
//		 }
	 }

///////////////////////////////////////
	public void FluentWait()
	{
//		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
//				//Wait for the condition
//			       .withTimeout(30, TimeUnit.SECONDS) 
//			         // which to check for the condition with interval of 5 seconds. 
//			       .pollingEvery(5, TimeUnit.SECONDS) 
//			     //Which will ignore the NoSuchElementException
//			       .ignoring(NoSuchElementException.class);
	}
////////////////////	//////////////////
	
	public void clickWhenReady(WebDriver drivernew, WebElement element, int timeout) 
	{
		try 
		{
			WebDriverWait wait = new WebDriverWait(drivernew, timeout);
			element = wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
			System.out.println("Element Clicked when its ready");
		} 
		catch (Exception e) 
		{
			System.out.println("clickWhenReady error occured" + element.toString() + " was not clickable after " + timeout +"seconds");
			RLog(drivernew,"failinfo","Error : Page Utills - ClickWhen Ready "+element+"Error : "+e.getMessage());
		}
		
	}
	
	public void doubleClickWhenReady(WebDriver drivernew, WebElement element, int timeout) 
	{
		
		try 
		{
			WebDriverWait wait = new WebDriverWait(drivernew, timeout);
			element = wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
			element.click();
		} 
		catch (Exception e) 
		{
			System.out.println("doubleClickWhenReady error occured" + element.toString() + " was not clickable after " + timeout +"seconds");
		}
		
	}
	
//	public WebElement getWhenVisible(By locator, int timeout) {
//		 
//		WebElement element = null;
//		 
//		WebDriverWait wait = new WebDriverWait(driver, timeout);
//		 
//		element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
//		 
//		return element;
//		 
//	}
	
	
	public boolean isElementPresent(WebElement findelement)
	{
		try 
		{
			String text=findelement.getText();
			System.out.println("element present ");
			return true;
		} 
		catch (Exception e)
		{
			System.out.println(" Element Not Present  ...." );
			return false;
		}
	}
	
	public boolean isErrorPresent(WebDriver drivernew)
	{
		String text=null;
		try 
		{
			text=Screen_Error_Window.getText();
			
			SendTestAlertMessageAs(drivernew,"Error Message is : ** 1  "+text);
			
			try {
				Thread.sleep(5000);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String errortext=Screen_Error_Window
					.findElement(By.tagName("small"))
					.getText();
			
			SendTestAlertMessageAs(drivernew, "Error Message is : **  "+errortext);
			
			if(!errortext.isEmpty())
			{
				return true;
			}
			//System.out.println("isErrorPresent = Yes,  Error Present ...."+ text);
			//return true;
			return false;
		} 
		catch (Exception e) 
		{
			//System.out.println("isErrorPresent = No Error Not Present ....");
			return false;	
		}
		
		
	}
	
	public String GetError()
	{
		String text=null;
		String LastAction=null;
		try 
		{
			//Checking Current VIsible Page  Error 
			text=Screen_Error_Window.getText();
			//System.out.println("DISPLAY1"+text+ text.isEmpty());
			
			//if error is not in visible then Move to Top
			if(text.isEmpty())
			{
				//To click on Full Page
				Common_Page.click();
				Common_Page.sendKeys(Keys.PAGE_UP);
				try 
				{
					Thread.sleep(3000);
				} 
				catch (InterruptedException e) 
				{
					e.printStackTrace();
				}
				Common_Page.click();
				Common_Page.sendKeys(Keys.PAGE_UP);
				Common_Page.click();
				try 
				{
					Thread.sleep(3000);
				} 
				catch (InterruptedException e) 
				{
					e.printStackTrace();
				}

				
				text=Screen_Error_Window.getText();
				
				//System.out.println("DISPLAY2"+text+ text.isEmpty());
				if(text.isEmpty())
				{
					
					Common_Page.sendKeys(Keys.PAGE_DOWN);
					
					//System.out.println("page down" );	
					LastAction="Down";
					
					try 
					{
						Thread.sleep(3000);
					} 
					catch (InterruptedException e) 
					{
						e.printStackTrace();
					}
				
					text=Screen_Error_Window.getText();
					
					//System.out.println("DISPLAY3"+text+ text.isEmpty());
					if(text.isEmpty())
					{
							Common_Page.sendKeys(Keys.PAGE_DOWN);
							try 
							{
								Thread.sleep(3000);
							} 
							catch (InterruptedException e) 
							{
								e.printStackTrace();
							}
						
							text=Screen_Error_Window.getText();
							//System.out.println("Error Checking 2st Level " +text );
							
					}
				
			   }
			}
//			//To Go Back to Same Position After identified Error
//			if(LastAction.contentEquals("Down"))
//			{
//				Common_Page.sendKeys(Keys.PAGE_UP);
//				Common_Page.sendKeys(Keys.PAGE_UP);
//				System.out.println("Reverse page up" );
//			}
//			else if (LastAction.contentEquals("Up"))
//			{
//				Common_Page.sendKeys(Keys.PAGE_DOWN);
//				Common_Page.sendKeys(Keys.PAGE_DOWN);
//				System.out.println("Reverse page down" );
//			}
//			else
//			{
//				System.out.println("Reverse Action - No Up or Down Match to Nutralise" );
//			}
//			// Wait After Page Up Or Page Down
//			try 
//			{
//				Thread.sleep(5000);
//			} 
//			catch (InterruptedException e) 
//			{
//				e.printStackTrace();
//			}
			//System.out.println("Final Error : "+text +LastAction);
			LastAction=null;
			//System.out.println("Final Error : "+text +LastAction);

			
			return text;
		}
		catch (Exception e) 
		{
			System.out.println("fail Try catch When get error From screen....");
			return null;
		}
	}
	
	public void SelectFromCheckBox(String PartyTypeLabel)
	{
		System.out.println("Total Check Box List : " +CHECKBOXBANKHEADERtop.size());
		
		for(WebElement element:CHECKBOXBANKHEADERtop)
		{
			WebElement checkbox=element.findElement(By
					.cssSelector("ul[class='list-inline']"))
					.findElement(By.tagName("li"));
			
			String ee=checkbox.getText();
			
			if(ee.toLowerCase().contentEquals(PartyTypeLabel.toLowerCase()))
			{
				System.out.println("Matched Check box is : "+ee);
				if(checkbox.isSelected()==false)
				{
					checkbox.click();
					System.out.println("CLICK DONE" +ee);
				}
				else
				{
					System.out.println("Already Check Box is in Selected status");
				}
				
			}
		}
		
		
//		System.out.println("List Inside 1st step" 
//							+element.getText()
//							+"___"
//							+element.getSize());
		
//		WebElement checkboxrow = element.findElement(By.className("row"));
//		
//		System.out.println("checkboxrow"+checkboxrow.isDisplayed()
//									+"___"
//									+checkboxrow.getText());
		
		//List<WebElement> checkboxlist = element.findElements(By.cssSelector("div[class='col-xs-4']"));
		
//		System.out.println("List Inside"+ checkboxlist.size()
//											+checkboxlist.toString() );
		
//		for(WebElement checkbox : checkboxlist)
//		{
//			WebElement box = checkbox.findElement(By.className("list-inline"));
//			
//			
//			//System.out.println("All - " +checkbox.getText() +"_+"+box.getText());
//			if(box.getText().contains(PartyType))
//			{
//				box.click();
//				//checkbox.click();
//				//System.out.println("Check Box clicked" +checkbox.getText());
//				break;
//			}
//		}
	}
	
	public String FirstLOVText(WebDriver drivernew, WebElement element)
	{
		clickWhenReady(drivernew, element, 30);
		
		element.clear();
		Highlight.heightlight(drivernew, element);
		
		//To Get Focus on List Values Press down 
		element.sendKeys(Keys.CONTROL);
		try 
		{
			Thread.sleep(2000);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		element.sendKeys(Keys.DOWN);
		try 
		{
			Thread.sleep(2000);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		if(isElementPresent(Add_Quote_LOV_Focuson)!=true)
		{
			
			element.sendKeys(Keys.DOWN);
			System.out.println("++++++++ SELECT LOV Probelem 2 time DOWN pressed +++++++");
			try 
			{
				Thread.sleep(2000);
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
		String FisrtLOVText=Add_Quote_LOV_Focuson.getText();
		
		return FisrtLOVText;
	}
	
	public void ClickFirstLOV(WebDriver drivernew, WebElement element)
	{
		
		clickWhenReady(drivernew, element, 10);
		
		element.clear();
		Highlight.heightlight(drivernew, element);
		
		//To Get Focus on List Values Press down 
		element.sendKeys(Keys.CONTROL);
//		try 
//		{
//			Thread.sleep(2000);
//		} 
//		catch (InterruptedException e) 
//		{
//			e.printStackTrace();
//		}
		element.sendKeys(Keys.DOWN);
		try 
		{
			Thread.sleep(1000);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		if(isElementPresent(Add_Quote_LOV_Focuson)==true)
		{
			Add_Quote_LOV_Focuson.click();
		}
		else if(isElementPresent(Add_Quote_LOV_Focuson)!=true)
		{
			element.sendKeys(Keys.DOWN);
			System.out.println("++++++++ SELECT LOV Probelem 2 time DOWN pressed +++++++");
			try 
			{
				Thread.sleep(2000);
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
			if(isElementPresent(Add_Quote_LOV_Focuson)==true)
			{
				Add_Quote_LOV_Focuson.click();
			}
			else 
			{
				element.sendKeys(Keys.DOWN);
				System.out.println("++++++++ SELECT LOV Probelem 2 time DOWN pressed +++++++");
				try 
				{
					Thread.sleep(2000);
				} 
				catch (InterruptedException e) 
				{
					e.printStackTrace();
				}
				if(isElementPresent(Add_Quote_LOV_Focuson)==true)
				{
					Add_Quote_LOV_Focuson.click();
				}
				else 
				{
					element.sendKeys(Keys.DOWN);
					System.out.println("++++++++ SELECT LOV Probelem 2 time DOWN pressed +++++++");
					try 
					{
						Thread.sleep(2000);
					} 
					catch (InterruptedException e) 
					{
						e.printStackTrace();
					}
				}
			}
		}
		else
		{
			Add_Quote_LOV_Focuson.click();
		}
		
		
	}
	
	public boolean IsPresentInLOV(WebDriver drivernew, WebElement element,  String Value) //Success
	{
		//Wait for the Field present and click 
		clickWhenReady(drivernew, element, 30);
		
		element.clear();
		Highlight.heightlight(drivernew, element);
		
		//Send the Received Value to the Field 
		element.sendKeys(Value);
		
		//To Get Focus on List Values Press down 
		element.sendKeys(Keys.DOWN);
		try 
		{
			Thread.sleep(2000);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		if(isElementPresent(Add_Quote_LOV_Focuson)!=true)
		{
			
			element.sendKeys(Keys.DOWN);
			System.out.println("++++++++ SELECT LOV Probelem 2 time DOWN pressed +++++++");
			try 
			{
				Thread.sleep(2000);
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
		
		// Need To Get Here for checking 
		String FisrtLOVText=Add_Quote_LOV_Focuson.getText();
		
		// To Get all the elemts present in LoV Panel
		int NumnerOfElements=LOV_LIST_PANEL.findElements(By.tagName("li")).size();
		
		//To Check More than 1 number of LOV value presence 
		if(NumnerOfElements!=1 && NumnerOfElements!=0)
		{
			for(int i=1;i<=NumnerOfElements;i++)
			{
				if((Value).equals(Add_Quote_LOV_Focuson.getText()))
		    	{
		    		 RLog(drivernew,"INFO","Provided LOV " +Value+ " Matched from ..."+ NumnerOfElements +" Values");
		    		 clickWhenReady(drivernew, Add_Quote_LOV_Focuson, 30);
		    		 return true;
		    	}
				else if(i==NumnerOfElements)
				{
					RLog(drivernew,"INFO"," Provided "+Value+ " Does Not match any value from the" +NumnerOfElements +" List of Values " );
					return false;
				}
				
				element.sendKeys(Keys.DOWN);
				try 
				{
					Thread.sleep(1000);
				} 
				catch (InterruptedException e) 
				{
					e.printStackTrace();
				}
			}
		}
		//To filter and click presented one lOV from ADD New and NO records found  
		else if(NumnerOfElements==1 && !FisrtLOVText.contentEquals("+ Add New") && !FisrtLOVText.contentEquals("No Records Found"))
		{
			Add_Quote_LOV_Focuson.click();
   		 	RLog(drivernew,"INFO"," Only One LOV That is  " +Value+ " Matched ...");
   		 	return true;
		}
		//To Check presented one LOV 
		else if(NumnerOfElements==1)
		{
			if(Add_Quote_LOV_Focuson.getText().contentEquals("+ Add New"))
			{
				System.out.println("+ Add New only available in the List : Framework Issue");
				return false;
			}
			else if(Add_Quote_LOV_Focuson.getText().contentEquals("No Records Found"))
			{
				System.out.println(" No Records Found in Master For this :"+ Value +" Error :"+ FisrtLOVText);
				return false;
			}
			else
			{
				System.out.println(" Somthing Else Happen Received One LOV List But Not Matches Framework"+Add_Quote_LOV_Focuson.getText());
				return false;
			}
		}
		else
		{
			System.out.println("Zeror List Error in LOV FrameWork");
			return false;
		}
		element.sendKeys(Keys.TAB);
		return false;
		
	}
	
	public String selectFromLOV(WebDriver drivernew, WebElement element,  String Value) //Success
	{
		//Wait for the Field present and click 
		clickWhenReady(drivernew, element, 30);
		
		element.clear();
		Highlight.heightlight(drivernew, element);
		element.sendKeys(Keys.CONTROL);
		
		//Send the Received Value to the Field 
		element.sendKeys(Value);
		
		try 
		{
			Thread.sleep(2000);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		//To Get Focus on List Values Press down 
		element.sendKeys(Keys.DOWN);
		

		System.out.println("Focus" + Add_Quote_LOV_Focuson.isDisplayed());
		if(isElementPresent(Add_Quote_LOV_Focuson)!=true)
		{
			
			element.sendKeys(Keys.DOWN);
			System.out.println("++++++++ SELECT LOV Probelem 2 time DOWN pressed +++++++");
			try 
			{
				Thread.sleep(1000);
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
		
		//Here the First LOV List Value Available so Need To Get Here for checking 
		String FisrtLOVText=Add_Quote_LOV_Focuson.getText();

		int NumnerOfElements=LOV_LIST_PANEL.findElements(By.tagName("li")).size();

		if(NumnerOfElements!=1 && NumnerOfElements!=0)
		{
			for(int i=1;i<=NumnerOfElements;i++)
			{
				if((Value).equals(Add_Quote_LOV_Focuson.getText()))
		    	{
					
		    		 System.out.println(" Provided LOV " +Value+ " Matched from ..."+ NumnerOfElements +" Values");
		    		 clickWhenReady(drivernew, Add_Quote_LOV_Focuson, 30);
		    		 //Add_Quote_LOV_Focuson.click();
					 break;
		    	}
				else if(i==NumnerOfElements)
				{
					System.out.println(" Provided "+Value+ " Does Not match any value from the" +NumnerOfElements +" List of Values " );
					break;
				}
				
				element.sendKeys(Keys.DOWN);
				try 
				{
					Thread.sleep(1000);
				} 
				catch (InterruptedException e) 
				{
					e.printStackTrace();
				}
			}
		}
		
		else if(NumnerOfElements==1 && !FisrtLOVText.contentEquals("+ Add New") && !FisrtLOVText.contentEquals("No Records Found"))
		{
			//clickWhenReady(Add_Quote_LOV_Focuson, 30);
			Add_Quote_LOV_Focuson.click();
//			if(isElementPresent(Add_Quote_LOV_Focuson)==true)
//			{
//				Add_Quote_LOV_Focuson.click();
//				System.out.println("2 time clcicked ");
//			}
   		 	System.out.println(" Only One LOV That is  " +Value+ " Matched ...");
		}
		else if(NumnerOfElements==1)
		{
			if(Add_Quote_LOV_Focuson.getText().contentEquals("+ Add New"))
			{
				System.out.println("+ Add New only available in the List : Framework Issue");
			}
			else if(Add_Quote_LOV_Focuson.getText().contentEquals("No Records Found"))
			{
				System.out.println(" No Records Found in Master For this :"+ Value +" Error :"+ FisrtLOVText);
				String x=Add_Quote_LOV_Focuson.getText();
				element.sendKeys(Keys.TAB);
				element.sendKeys(Keys.TAB);
				return x;
			}
			else
			{
				System.out.println(" Somthing Else Happen Received One List But Not Matches Framework");
			}
		}
		else
		{
			System.out.println("Zeror List Error in LOV FrameWork");
		}
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		element.sendKeys(Keys.TAB);
		
		return null;

	}

	public void xx()
	{

//		System.out.println("A SIZE 9");
//		try 
//		{
//			Thread.sleep(10000);
//		} 
//		catch (InterruptedException e) 
//		{
//			e.printStackTrace();
//		}
//		
//		
//		System.out.println("A SIZE 9.1");
//		WebElement cityField = driver.findElement(By.cssSelector("input[ng-model='quotationDetail.grossWeight']"));
//		System.out.println("A SIZE 9.2");
//		System.out.println(""+cityField.isDisplayed() 
//							+cityField.isEnabled() 
//							+cityField.isSelected());
//		
//		System.out.println("A SIZE 9.3");
//		cityField.clear();
//		System.out.println("A SIZE 9.4");
//		cityField.sendKeys("2000");
//		System.out.println("A SIZE 9.5");
//		new WebDriverWait(driver,30)
//		.until(ExpectedConditions
//		.elementToBeClickable(Add_Quote_Services_Gross));
//		
//		System.out.println("A SIZE 9.3");
//		
//		Add_Quote_Services_Gross.click();
//		Add_Quote_Services_Gross.sendKeys("1000");
//		//WebElement cc=driver.findElement(By.xpath("//*[contains(@ng-model='quotationDetail.grossWeight') and type='text']"));
//		System.out.println("A SIZE 10");
//		//cc.sendKeys("1000");
//		System.out.println("A SIZE 11");
//		List<WebElement> a=driver.findElements(By.cssSelector("input[ng-model='quotationDetail.grossWeight']"));
//		System.out.println("A SIZE "+a.size());
//		
//		try 
//		{
//			Thread.sleep(2000);
//		} 
//		catch (InterruptedException e) 
//		{
//			e.printStackTrace();
//		}
//		System.out.println("yyy"+a.lastIndexOf(1));
//		for(WebElement c:a)
//		{
//			try 
//			{
//				Thread.sleep(2000);
//			} 
//			catch (InterruptedException e) 
//			{
//				e.printStackTrace();
//			}
//			System.out.println("1");
//			c.click();
//			System.out.println("2");
//			try 
//			{
//				Thread.sleep(2000);
//			} 
//			catch (InterruptedException e) 
//			{
//				e.printStackTrace();
//			}
//			System.out.println("3");
//			c.sendKeys("1000");
//			System.out.println("GGGGGG" +Add_Quote_Services_Grossweight.getText());
//		}
//		
		
		
		/**
		System.out.println("Party name" +party.partyName);
		Actions action = new Actions(driver);
		action.moveToElement(Add_Quote_Party).perform();
		System.out.println("Party address" +party.partyAddress1);
		action.doubleClick();
		**/
		
		//Select dropdown=new Select(Add_Quote_Party_LOV);
		//dropdown.selectByIndex(1);
		
		//Add_Quote_Party_Address1.sendKeys(party.partyAddress1);
		
		

//		Wait wait =new FluentWait(driver)
//				.withTimeout(60, TimeUnit.SECONDS)
//				.pollingEvery(10, TimeUnit.MILLISECONDS)
//				.ignoring(NoSuchElementException.class);
//		wait.until(new Function<webdriver,webElement>()
//				{
//					public WebElement apply(WebDriver driver)
//					{
//						return Add_Quote_Party;
//					}
//			
//				}
//				
//				);
		
		//Add_Quote_ServicesTabPage.sendKeys(Keys.SPACE);
		
		
//		//WebElement element = driver.findElement(By.xpath(".//*[@id='service-panel']/div[6]/div[1]/div[3]/div[1]/div/div[1]/div/input"));
//		Coordinates coordinate = ((Locatable)Add_Quote_Services_Name).getCoordinates(); 
//		coordinate.onPage(); 
//		coordinate.inViewPort();
//		
////		int elementPosition = Add_Quote_Services_Origin.getLocation().getY();
////		   String js = String.format("window.scroll(0, %s)", elementPosition);
////		   ((JavascriptExecutor)driver).executeScript(js);
////		   
//		   
//		//((JavascriptExecutor)driver).executeScript("scroll(0, 400)");
////		((JavascriptExecutor) driver)
////        .executeScript("window.scrollTo(0, document.body.scrollHeight)");
////		
//		((JavascriptExecutor) driver).executeScript(
//                "arguments[0].scrollIntoView(true);", Add_Quote_Services_Name);
//		
////		Add_Quote_Services_Origin=driver.findElement(By.xpath(".//*[@id='service-panel']/div[6]/div[1]/div[3]/div[1]/div/div[1]/div/input"));
//		
		
	}
	public void scroll(WebDriver drivernew, WebElement element)
	{
		int elementPosition = element.getLocation().getY();
		System.out.println(" location value"+ element.getLocation().getY());
		
		String js = String.format("window.scroll(0, %s)", elementPosition);
		((JavascriptExecutor)drivernew).executeScript(js);
		
		//((JavascriptExecutor)drivernew).executeScript("scroll(0, 400)");
		//((JavascriptExecutor) drivernew).executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
		//((JavascriptExecutor) drivernew).executeScript("arguments[0].scrollIntoView(true);", element);
		
	}
	
	
	
	
	
	
	
	
	
	
}
