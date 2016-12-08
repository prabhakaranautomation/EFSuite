package eSales;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import Master.Pages;
import MasterGenerators.Party;
import MasterGenerators.PartyNameGenerator;
import MasterGenerators.RandomGetData;
import MasterGenerators.Auto;
import MasterGenerators.Auto.PartyAddresse;
import MasterGenerators.Auto.Partye;
import Master_util.PageUtils;

public class QuotationPage extends PageUtils
{
	//private WebDriver driver;//protected
	public QuotationPage(WebDriver driverQuotation)//400
	{
		super(driverQuotation);
		this.driver=driverQuotation;
	}
	
	@FindBy(how=How.XPATH,using=".//*[@id='main-view']/div/div/div[1]/div/div[1]/section/div[1]/div/button") 
	private WebElement Add_Quote_button;

	//.//*[@id='main-view']/div/div/div[1]/div/div[1]/section/div[1]/div/button
	
	@FindBy(how=How.XPATH,using=".//*[@id='main-view']/div/div/div/form/div/div[1]/div[1]/h4") 
	private WebElement Add_Quote_screenname;
	
	
	@FindBy(how=How.XPATH,using=".//*[@id='service-panel']/div[3]/div/div[1]/div/div[1]/div[1]/div/input") 
	private WebElement Add_Quote_Party;
	
	@FindBy(how=How.XPATH,using=".//*[@id='service-panel']/div[3]/div/div[1]/div/div[1]/div[1]/div/span") 
	private WebElement Add_Quote_Party_LOVBtn;
	@FindBy(how=How.ID,using="ui-id-2") 
	private WebElement Add_Quote_Party_LOVList;
	
	@FindBy(how=How.CSS,using="a[class='selectPicker-sm'][title='Select Party Address']") 
	private WebElement Add_Quote_Party_Address_Picker_Btn;
	
	@FindBy(how=How.XPATH,using=".//*[@id='service-panel']/div[3]/div/div[1]/div/div[2]/div/div/div[1]/input") 
	private WebElement Add_Quote_Party_Address1;
	@FindBy(how=How.XPATH,using=".//*[@id='service-panel']/div[3]/div/div[1]/div/div[2]/div/div/div[3]/input") 
	private WebElement Add_Quote_Party_Address2;
	@FindBy(how=How.XPATH,using=".//*[@id='service-panel']/div[3]/div/div[1]/div/div[2]/div/div/div[4]/input") 
	private WebElement Add_Quote_Party_Address3;
	@FindBy(how=How.XPATH,using=".//*[@id='service-panel']/div[3]/div/div[1]/div[2]/div/div/div[5]/input") 
	private WebElement Add_Quote_Party_Address4;
	
	
	
	
	@FindBy(how=How.XPATH,using=".//*[@id='service-panel']/div[3]/div/div[2]/div/div[1]/div[1]/div/input") 
	private WebElement Add_Quote_Shipper;
	@FindBy(how=How.XPATH,using=".//*[@id='service-panel']/div[3]/div/div[2]/div/div[1]/div[1]/div/span") 
	private WebElement Add_Quote_Shipper_LOVBtn;
	@FindBy(how=How.ID,using="ui-id-3") 
	private WebElement Add_Quote_Shipper_LOVList;
	@FindBy(how=How.XPATH,using=".//*[@id='service-panel']/div[3]/div/div[2]/div[2]/div/div/div[1]/input") 
	private WebElement Add_Quote_Shipper_Address1;
	@FindBy(how=How.XPATH,using=".//*[@id='service-panel']/div[3]/div/div[2]/div[2]/div/div/div[3]/input") 
	private WebElement Add_Quote_Shipper_Address2;
	@FindBy(how=How.XPATH,using=".//*[@id='service-panel']/div[3]/div/div[2]/div[2]/div/div/div[4]/input") 
	private WebElement Add_Quote_Shipper_Address3;
	@FindBy(how=How.XPATH,using=".//*[@id='service-panel']/div[3]/div/div[2]/div[2]/div/div/div[5]/input") 
	private WebElement Add_Quote_Shipper_Address4;
	
	@FindBy(how=How.XPATH,using=".//*[@id='service-panel']/div[4]/div[1]/div[1]/div[1]/div/input") 
	private WebElement Add_Quote_LoggedOn;
	
	@FindBy(how=How.XPATH,using=".//*[@id='service-panel']/div[4]/div[1]/div[1]/div[1]/div/input") 
	private WebElement Add_Quote_Logged_By;
	@FindBy(how=How.XPATH,using=".//*[@id='service-panel']/div[4]/div[1]/div[1]/div/div[2]/div/span") 
	private WebElement Add_Quote_Logged_By_LOVBtn;
	@FindBy(how=How.ID,using="ui-id-4") 
	private WebElement Add_Quote_Logged_By_LOVList;
	
	
	@FindBy(how=How.XPATH,using=".//*[@id='enabled']") 
	private WebElement Add_Quote_Routed;
	@FindBy(how=How.XPATH,using=".//*[@id='service-panel']/div[4]/div[3]/div[1]/div[2]/input") 
	private WebElement Add_Quote_Attention;
	
	@FindBy(how=How.XPATH,using=".//*[@id='service-panel']/div[4]/div[1]/div[2]/div/div[1]/div/input") 
	private WebElement Add_Quote_ValidFrom;
	@FindBy(how=How.XPATH,using=".//*[@id='service-panel']/div[4]/div[1]/div[2]/div/div[2]/div/input") 
	private WebElement Add_Quote_ExpiresOn;
	
	@FindBy(how=How.XPATH,using=".//*[@id='service-panel']/div[4]/div[3]/div[2]/div[1]/div/input") 
	private WebElement Add_Quote_SalesCoordinator;
	@FindBy(how=How.XPATH,using=".//*[@id='service-panel']/div[4]/div[3]/div[2]/div[1]/div/span") 
	private WebElement Add_Quote_SalesCoordinator_LOVBtn;
	@FindBy(how=How.ID,using="ui-id-5") 
	private WebElement Add_Quote_SalesCoordinator_LOVList;
	
	@FindBy(how=How.XPATH,using=".//*[@id='service-panel']/div[4]/div[3]/div[2]/div[2]/div/input") 
	private WebElement Add_Quote_Salesman;
	@FindBy(how=How.XPATH,using=".//*[@id='service-panel']/div[4]/div[3]/div[2]/div[2]/div/span") 
	private WebElement Add_Quote_Salesman_LOVBtn;
	@FindBy(how=How.ID,using="ui-id-6") 
	private WebElement Add_Quote_Salesman_LOVList;
	
	@FindBy(how=How.XPATH,using=".//*[@id='service-panel']/div[5]/ul/li[1]/button") 
	private WebElement Add_Quote_ServicesTabPage;
	
	@FindBy(how=How.XPATH,using=".//*[@id='service-panel']/div[6]/div[1]/div[1]/div/div/div/div/input") 
	private WebElement Add_Quote_Services_Name;
	@FindBy(how=How.XPATH,using=".//*[@id='service-panel']/div[6]/div[1]/div[1]/div/div/div/div/span") 
	private WebElement Add_Quote_Services_Name_LOVBtn;
	@FindBy(how=How.ID,using="ui-id-7") 
	private WebElement Add_Quote_Services_Name_LOVList;
	
	@FindBy(how=How.XPATH,using=".//*[@id='service-panel']/div[6]/div[1]/div[3]/div[1]/div/div[1]/div/input") 
	private WebElement Add_Quote_Services_Origin;
	@FindBy(how=How.XPATH,using=".//*[@id='service-panel']/div[6]/div[1]/div[3]/div[1]/div/div[1]/div/span") 
	private WebElement Add_Quote_Services_Origin_LOVBtn;
	@FindBy(how=How.ID,using="ui-id-8") 
	private WebElement Add_Quote_Services_Origin_LOVList;
	
	@FindBy(how=How.XPATH,using=".//*[@id='service-panel']/div[6]/div[1]/div[3]/div[1]/div/div[2]/div/input") 
	private WebElement Add_Quote_Services_Destination;
	@FindBy(how=How.XPATH,using=".//*[@id='service-panel']/div[6]/div[1]/div[3]/div[1]/div/div[2]/div/span") 
	private WebElement Add_Quote_Services_Destination_LOVBtn;
	@FindBy(how=How.ID,using="ui-id-9") 
	private WebElement Add_Quote_Services_Destination_LOVList;
	
	@FindBy(how=How.XPATH,using=".//*[@id='service-panel']/div[6]/div[1]/div[5]/div[1]/div/div/div/input") 
	private WebElement Add_Quote_Services_TOS;
	@FindBy(how=How.XPATH,using=".//*[@id='service-panel']/div[6]/div[1]/div[5]/div[1]/div/div/div/span") 
	private WebElement Add_Quote_Services_TOS_LOVBtn;
	@FindBy(how=How.ID,using="ui-id-12") 
	private WebElement Add_Quote_Services_TOS_LOVList;
	
	@FindBy(how=How.XPATH,using=".//*[@id='service-panel']/div[6]/div[1]/div[5]/div[2]/div/div[1]/input[2]") 
	private WebElement Add_Quote_Services_Grossweight;
	@FindBy(how=How.XPATH,using=".//*[@id='service-panel']/div[6]/div[1]/div[5]/div[2]/div/div[2]/input[2]") 
	private WebElement Add_Quote_Services_VolumeWeight;
	
	
	@FindBy(how=How.CLASS_NAME,using="today") 
	private WebElement Add_Quote_DateWidget_today;
	
	@FindBy(how=How.CLASS_NAME,using="active") 
	private WebElement Add_Quote_Datepicker_Selected;
		
	@FindBy(how=How.CLASS_NAME,using="datepicker-days") 
	private WebElement Add_Quote_Datepicker_Days;
	
	@FindBy(how=How.CLASS_NAME,using="datepicker-days") 
	private WebElement Add_Quote_Datepicker_Months;
	
	@FindBy(how=How.CLASS_NAME,using="datepicker-days") 
	private WebElement Add_Quote_Datepicker_Years;
	
	@FindBy(how=How.CLASS_NAME,using="datepicker-days") 
	private WebElement Add_Quote_Datepicker_Decades;
	
	@FindBy(how=How.CLASS_NAME,using="table-condensed") 
	private WebElement Add_Quote_DateWidgettable;
	
	
	
	@FindBy(how=How.XPATH,using=".//*[@id='main-view']/div/div/div/form/div/div[1]/div[2]/ul/li[2]/input") 
	private WebElement Add_Quote_SAVE;
	
	@FindBy(how=How.ID,using="ngdialog1-aria-describedby") 
	private WebElement Add_Quote_Confirmation_Message;
	
	@FindBy(how=How.CLASS_NAME,using="btn btn-primary btn-property accent-btn") 
	private WebElement Add_Quote_Confirmation_Message_OKBtn;
	
	@FindBy(how=How.XPATH,using=".//*[@id='main-view']/div/div/div[2]/div/div[1]/div/div[1]/div/button[1]") 
	private WebElement View_Quote_Back_Btn;
	
	

	
	//Basic
	public boolean IsAtQuotation()
	{
		try
		{
			String text=Add_Quote_button.getText();
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	public boolean IsAtAddQuotation()
	{
		try 
		{
			String text=Add_Quote_Party.getText();
		} 
		catch (Exception e) 
		{
			return false;
		}
		return true;
	}
	
	public void Goto(WebDriver drivernew)
	{
		Pages.TopNavigation(drivernew).Quotation(drivernew);
		System.out.println("Success Goto Quotation");
	}
	
	public void GotoAddQuotation(WebDriver drivernew)
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
		FindAndClick(drivernew,Add_Quote_button);
		
//		if(Pages.Quotation(driver).IsAtQuotation()==true)
//		{
//			clickWhenReady(Add_Quote_button, 30);
//		}
//		else
//		{
//			Pages.TopNavigation(driver).Quotation();
//			clickWhenReady(Add_Quote_button, 30);
//			
//		}
		
	}
	
	
	//For Data ENtry from Data Generators 
	public void EnterLastgeneratorsInQuote(WebDriver drivernew, Partye TypeOfCustomer)
	{
		
		//clickWhenReady(Add_Quote_Party, 30);
		selectFromLOV(drivernew, Add_Quote_Party, Auto.PartyBundle.get(TypeOfCustomer).partyName);
		RLog("INFO","Party name selected by key from LOV  as "+ Auto.PartyBundle.get(TypeOfCustomer).partyName);
		
		ClickAndClear(drivernew, Add_Quote_ValidFrom);
		enterDate(driver,Add_Quote_ValidFrom,0,"dd-MM-yyyy");
		RLog("INFO","ValidFrom entered as "+getDate(0, "dd-MM-yyyy"));
		
		ClickAndClear(drivernew, Add_Quote_ExpiresOn);
		enterDate(driver,Add_Quote_ExpiresOn,8,"dd-MM-yyyy");
		RLog("INFO","ExpiresOn entered as "+getDate(8, "dd-MM-yyyy"));
        
		selectFromLOV(drivernew, Add_Quote_SalesCoordinator,  Auto.PartyBundle.get(TypeOfCustomer).salesCoordinator);
		
		Add_Quote_ServicesTabPage.click();
		Add_Quote_ServicesTabPage.sendKeys(Keys.PAGE_DOWN);
		
		selectFromLOV(drivernew, Add_Quote_Services_Origin, Auto.PartyBundle.get(TypeOfCustomer).origin);
		
		selectFromLOV(drivernew, Add_Quote_Services_Destination, Auto.PartyBundle.get(TypeOfCustomer).destination);
		
		selectFromLOV(drivernew, Add_Quote_Services_TOS, Auto.PartyBundle.get(TypeOfCustomer).termOfShipment);
		
		Add_Quote_Services_Grossweight.click();
		Add_Quote_Services_Grossweight.sendKeys(RandomGetData.generateRandomNumber(10000));
		
		Add_Quote_Services_VolumeWeight.click();
		Add_Quote_Services_VolumeWeight.sendKeys(RandomGetData.generateRandomNumber(1000000));
		
	}
	
	public void EnterLastgeneratorsInQuoteExcept(WebDriver drivernew, Partye TypeOfCustomer, String FindByElementName)
	{
		clickWhenReady(drivernew, Add_Quote_Party, 30);
		if(!FindByElementName.contentEquals("Add_Quote_Party"))
		{
			selectFromLOV(drivernew, Add_Quote_Party, Auto.PartyBundle.get(Lastgenerator(driver1, TypeOfCustomer)).partyName);
			RLog("INFO","Party name selected by key from LOV  as "+ Auto.PartyBundle.get(Lastgenerator(driver1, TypeOfCustomer)).partyName);
			
		}
		if(FindByElementName.contentEquals("Add_Quote_Party_Address1"))
		{
			Add_Quote_Party_Address1.click();
			Add_Quote_Party_Address1.clear();
			
		}
		if(FindByElementName.contentEquals("Add_Quote_Party_Address2"))
		{
			Add_Quote_Party_Address2.click();
			Add_Quote_Party_Address2.clear();
			
		}
		if(FindByElementName.contentEquals("Add_Quote_Party_Address3"))
		{
			Add_Quote_Party_Address3.click();
			Add_Quote_Party_Address3.clear();
			
		}
		if(FindByElementName.contentEquals("Add_Quote_Attention"))
		{
			Add_Quote_Attention.click();
			Add_Quote_Attention.clear();
		}
		
		if(!FindByElementName.contentEquals("Add_Quote_ValidFrom"))
		{
			ClickAndClear(drivernew, Add_Quote_ValidFrom);
			enterDate(driver,Add_Quote_ValidFrom,0,"dd-MM-yyyy");
			RLog("INFO","ValidFrom entered as "+getDate(0, "dd-MM-yyyy"));
			
		}
		if(!FindByElementName.contentEquals("Add_Quote_ExpiresOn"))
		{
			ClickAndClear(drivernew, Add_Quote_ExpiresOn);
			enterDate(driver,Add_Quote_ExpiresOn,8,"dd-MM-yyyy");
			RLog("INFO","ExpiresOn entered as "+getDate(8, "dd-MM-yyyy"));
		}
		
		if(!FindByElementName.contentEquals("Add_Quote_SalesCoordinator"))
		{
			selectFromLOV(drivernew, Add_Quote_SalesCoordinator,  Auto.PartyBundle.get(Lastgenerator(driver1, TypeOfCustomer)).salesCoordinator);
		}
		
		
		Add_Quote_ServicesTabPage.click();
		Add_Quote_ServicesTabPage.sendKeys(Keys.PAGE_DOWN);
		
		if(!FindByElementName.contentEquals("Add_Quote_Services_Origin"))
		{
			selectFromLOV(drivernew, Add_Quote_Services_Origin, Auto.PartyBundle.get(Lastgenerator(driver1, TypeOfCustomer)).origin);
		}
		if(!FindByElementName.contentEquals("Add_Quote_Services_Destination"))
		{
			selectFromLOV(drivernew, Add_Quote_Services_Destination, Auto.PartyBundle.get(Lastgenerator(driver1, TypeOfCustomer)).destination);
		}
		if(!FindByElementName.contentEquals("Add_Quote_Services_TOS"))
		{
			selectFromLOV(drivernew, Add_Quote_Services_TOS, Auto.PartyBundle.get(Lastgenerator(driver1, TypeOfCustomer)).termOfShipment);
		}
		if(!FindByElementName.contentEquals("Add_Quote_Services_Grossweight"))
		{
			Add_Quote_Services_Grossweight.click();
			Add_Quote_Services_Grossweight.sendKeys(RandomGetData.generateRandomNumber(10000));
		}
		if(!FindByElementName.contentEquals("Add_Quote_Services_VolumeWeight"))
		{
			Add_Quote_Services_VolumeWeight.click();
			Add_Quote_Services_VolumeWeight.sendKeys(RandomGetData.generateRandomNumber(1000000));
		}
		
	}
	
	
	
	//Page Util FrameWork
	public void EntervalueInTextBox(WebDriver driernew, WebElement element, String Value)//framework
	{
		if(!element.isDisplayed())
		{
			Common_Page.sendKeys(Keys.PAGE_UP);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if(!element.isDisplayed())
			{
				Common_Page.sendKeys(Keys.PAGE_UP);
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(!element.isDisplayed())
				{
					Common_Page.sendKeys(Keys.PAGE_DOWN);
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					Common_Page.sendKeys(Keys.PAGE_DOWN);
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					Common_Page.sendKeys(Keys.PAGE_DOWN);
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					if(!element.isDisplayed())
					{
						Common_Page.sendKeys(Keys.PAGE_DOWN);
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			}
			
		}
		
		ClickAndClear(driernew, element);
		
		element.sendKeys(Value);
		element.sendKeys(Keys.TAB);
	
	}
	
	public int GetStringLengthFiled(WebElement element)//framework
	{
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		final String alphabet1 = element.getAttribute("value");
		
		return alphabet1.length();
	}
	
	/////////////////////////// PARTY ///////////////////////////////

	//Party Add New Option
	public String GetPartyFirstLOVText()
	{
		return FirstLOVText(driver,Add_Quote_Party);
	}
	
	public void ClickPartyFirstLOV()
	{
		ClickFirstLOV(driver,Add_Quote_Party);
	}
	
	
	//TO Enter Value in Party 
	public String EnterPartyNameinquote(WebDriver drivernew, Partye TypeOfCustomer)
	{
		//GeneratelastgeneratorName(drivernew, TypeOfCustomer);
		String s=selectFromLOV(drivernew, Add_Quote_Party, Auto.PartyBundle.get(Lastgenerator(drivernew, TypeOfCustomer)).partyName);
		RLog("INFO","Entered Party Name as " +Auto.PartyBundle.get(Lastgenerator(drivernew, TypeOfCustomer)).partyName);
		
		return s;
	}
	
	public String EnterRandomPartyNameinquote(WebDriver drivernew)
	{
		return selectFromLOV(drivernew, Add_Quote_Party, (PartyNameGenerator.generate()));
	}

	
	// To Check Character Acceptance
	public void EnterAlphaNumericSpecialCharactersInPartyAddress1Inquote(WebDriver drivernew, int Length)
	{
		EntervalueInTextBox(drivernew, Add_Quote_Party_Address1,RandomGetData.generateRandomAlphaNumeric(Length));
	}
	
	public void EnterAlphaNumericSpecialCharactersInPartyAddress2Inquote(WebDriver drivernew, int Length)
	{
		EntervalueInTextBox(drivernew, Add_Quote_Party_Address2,RandomGetData.generateRandomAlphaNumeric(Length));
	}
	
	public void EnterAlphaNumericSpecialCharactersInPartyAddress3Inquote(WebDriver drivernew, int Length)
	{
		EntervalueInTextBox(drivernew, Add_Quote_Party_Address3,RandomGetData.generateRandomAlphaNumeric(Length));
	}
	
	// To Check Character Acceptance
//	public void EnterAlphaNumericCharactersInquotePartyAttention(int Length)
//	{
//		if(Add_Quote_Attention.isDisplayed()==true)
//		{
//			EntervalueInTextBox(Add_Quote_Attention,RandomGetData.generateRandomAlphaNumeric(Length));
//		}
//		else
//		{
//			Add_Quote_Page.sendKeys(Keys.PAGE_UP);
//			try {
//				Thread.sleep(2000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			if(Add_Quote_Attention.isDisplayed()==true)
//			{
//				EntervalueInTextBox(Add_Quote_Attention,RandomGetData.generateRandomAlphaNumeric(Length));
//			}
//			
//		}
//	}
	
	public void EnterAlphaCharactersInquotePartyAttention(WebDriver dirvernew, int Length)
	{
		if(Add_Quote_Attention.isDisplayed()==true)
		{
			String RandomValue=RandomGetData.generateRandomAlpha(Length);
			EntervalueInTextBox(dirvernew, Add_Quote_Attention,RandomValue);
			
			RLog("INFO","Entered Alpha Character Length is 50"+ RandomValue);
		}
		else
		{
			Common_Page.sendKeys(Keys.PAGE_UP);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(Add_Quote_Attention.isDisplayed()==true)
			{
				String RandomValue=RandomGetData.generateRandomAlpha(Length);
				EntervalueInTextBox(dirvernew, Add_Quote_Attention,RandomValue);
				RLog("INFO","Entered Alpha Character Length is 50"+ RandomValue);
			}
			Common_Page.sendKeys(Keys.PAGE_DOWN);
			try 
			{
				Thread.sleep(2000);
			} 
			catch (InterruptedException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Common_Page.sendKeys(Keys.PAGE_DOWN);
			try 
			{
				Thread.sleep(2000);
			} 
			catch (InterruptedException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(Add_Quote_Attention.isDisplayed()==true)
			{
				String RandomValue=RandomGetData.generateRandomAlpha(Length);
				EntervalueInTextBox(dirvernew, Add_Quote_Attention,RandomValue);
				RLog("INFO","Entered Alpha Character Length is 50"+ RandomValue);
			}
		}
		
	}
	
	public void EnterLastGeneratedPartyAttentionInquote(WebDriver drivernew, Partye TypeOfCustomer)
	{
		if(Add_Quote_Attention.isDisplayed()==true)
		{
			EntervalueInTextBox(drivernew, Add_Quote_Attention,Auto.PartyBundle.get(TypeOfCustomer).partyAddressContactName);
		}
		else
		{
			Common_Page.sendKeys(Keys.PAGE_UP);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(Add_Quote_Attention.isDisplayed()==true)
			{
				EntervalueInTextBox(drivernew, Add_Quote_Attention,Auto.PartyBundle.get(TypeOfCustomer).partyAddressContactName);
			}
			
		}
		RLog("INFO","Entered Ateention value is : " +Auto.PartyBundle.get(TypeOfCustomer).partyAddressContactName);
	}

	//To check Address present String value
	public int GetQuotePartyAddress1StringLength()
	{
		return GetStringLengthFiled(Add_Quote_Party_Address1);
	}
	
	public int GetQuoteAttentionStringLength()
	{
		return GetStringLengthFiled(Add_Quote_Attention);
	}
	
	public int GetQuotePartyAddress2StringLength()
	{
		return GetStringLengthFiled(Add_Quote_Party_Address2);
	}
	
	public int GetQuotePartyAddress3StringLength()
	{
		return GetStringLengthFiled(Add_Quote_Party_Address3);
	}
	
	
	
	//To Handle Party Address Change 
	public void ChangePartyAddressToWareHouse(Partye TypeOfCustomer)
	{
		Add_Quote_Party_Address_Picker_Btn.click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("1"+PartyAddresse.WAREHOUSE.toString());
		WebElement AddressPanelHeadanddetail=driver
							.findElement(By.cssSelector("div[class^='logs-transition'][class$='sideView']"))
							.findElement(By.cssSelector("select-list-picker[class='ng-isolate-scope']"));
		
		
		System.out.println("112");
		WebElement AddressPanelHeadanddetail1=AddressPanelHeadanddetail.findElement(By.tagName("div"));
		
		System.out.println("12");
		WebElement AddressPanel=AddressPanelHeadanddetail1
								.findElement(By.cssSelector("div[id='selectList-Panel']"));
		System.out.println("13");
		List<WebElement> AlladdressList =AddressPanel
								.findElement(By.cssSelector("div[class='row']"))
								.findElement(By.cssSelector("div[class=''][ng-show^='config'][ng-show$= 'config.address']"))
								.findElements(By.cssSelector("div[class^='row'][ng-click='rowSelectAddress(dataObj,$index);']"));
		System.out.println("14"+AlladdressList.size());
		
		for(WebElement AddressSingle : AlladdressList)
		{
			System.out.println("2");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			WebElement Alltherow =AddressSingle
								.findElement(By.tagName("div"))
								.findElement(By.tagName("ul"));
			System.out.println("21");
			WebElement AddressType=Alltherow
								.findElement(By.cssSelector("li[class='text-info mb-10 ng-binding']"));
			System.out.println("22");
			WebElement AddressTypedetails=AddressType
								.findElement(By.tagName("i"));
			System.out.println("23");
			System.out.println(""+AddressType.getText());
			System.out.println("24");
			if(AddressType.getText().toString().toLowerCase().contentEquals(PartyAddresse.WAREHOUSE.toString().toLowerCase()))
			{
				System.out.println("3");
				AddressType.click();
				System.out.println("ADDRESS CLICKED FINAL ");
				break;
			}
			
		}
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//PartyAddresse.WAREHOUSE
	}

	public boolean IsLastGeneratedQuotePresentinQuoteList(WebDriver drivernew, String Code)
	{
		Pages.TopNavigation(driver).Quotation(drivernew);
		
		EnterListscreenSearch(driver,"Quotation No",Code);
		RLog("INFO","AFTER EnterListscreenSearch ");
		return IsRowpresentInListScreen();
	}
	
	//To Check Party And Address Filed String details 
	public boolean IsPartyPresenceinQuote()
	{
		
		try {
			
			if(!Add_Quote_Party.getAttribute("value").isEmpty())
			{
				return true;
			}
			else
			{
				return false;
			}
			
		} 
		catch (Exception e)
		{
			RLog("INFO","ERROR : "+e.getMessage());
		}
		return false;
	}
	
	public boolean IsPartyNameAndAddressPresenceinQuote(WebDriver driver, Partye TypeOfCustomer)
	{
		try 
		{
			
			if(Add_Quote_Party.getAttribute("value").contains(Auto.PartyBundle.get(Lastgenerator(driver,TypeOfCustomer)).partyName)==true 
				&&Add_Quote_Party_Address1.getAttribute("value").contentEquals(Auto.PartyBundle.get(Lastgenerator(driver,TypeOfCustomer)).partyAddress1)==true 
				&& Add_Quote_Party_Address2.getAttribute("value").contentEquals(Auto.PartyBundle.get(Lastgenerator(driver,TypeOfCustomer)).partyAddress2)==true)
			{
				
				return true;
			}
			else
			{
				return false;
			}
		} 
		catch (Exception e) 
		{
			RLog("INFO","ERROR : "+e.getMessage());
			//e.printStackTrace();
		}
		return false;
	}
	
	public boolean IsPartyPrimaryAddressPresenceinQuote(Partye TypeOfCustomer)
	{
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(Add_Quote_Party_Address1.getAttribute("value").contentEquals(Auto.PartyBundle.get(TypeOfCustomer).partyAddress1)==true 
				&& Add_Quote_Party_Address2.getAttribute("value").contentEquals(Auto.PartyBundle.get(TypeOfCustomer).partyAddress2)==true)
			{
				
				return true;
			}
			else
			{
				return false;
			}
	}
	
	public boolean IsPartyBillingAddressPresenceinQuote(Partye TypeOfCustomer)
	{
		if(Add_Quote_Party_Address1.getAttribute("value").contentEquals(Auto.PartyBundle.get(TypeOfCustomer).partyBillingAddress1)==true 
				&& Add_Quote_Party_Address2.getAttribute("value").contentEquals(Auto.PartyBundle.get(TypeOfCustomer).partyBillingAddress2)==true)
			{
				
				return true;
			}
			else
			{
				return false;
			}
	}
	
	public boolean IsPartyWareHoseAddressPresenceinQuote(Partye TypeOfCustomer)
	{
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(Add_Quote_Party_Address1.getAttribute("value").contentEquals(Auto.PartyBundle.get(TypeOfCustomer).partyWareHouseAddress1)==true 
				&& Add_Quote_Party_Address2.getAttribute("value").contentEquals(Auto.PartyBundle.get(TypeOfCustomer).partyWareHouseAddress2)==true)
			{
				
				return true;
			}
			else
			{
				return false;
			}
	}
	
	public boolean IsPartyOtherAddressPresenceinQuote(Partye TypeOfCustomer)
	{
		if(Add_Quote_Party_Address1.getAttribute("value").contentEquals(Auto.PartyBundle.get(TypeOfCustomer).partyOtherAddress1)==true 
				&& Add_Quote_Party_Address2.getAttribute("value").contentEquals(Auto.PartyBundle.get(TypeOfCustomer).partyOtherAddress2)==true)
			{
				
				return true;
			}
			else
			{
				return false;
			}
	}
	
	
	public boolean IsPartyAttentionPresenceinQuote(Partye TypeOfCustomer)
	{
		if(Add_Quote_Attention.getAttribute("value").contentEquals(Auto.PartyBundle.get(TypeOfCustomer).partyAddressContactName)==true)
		{
			
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public String createquote(WebDriver drivernew, Party lastGenparty)
	{
		
		clickWhenReady(drivernew, Add_Quote_Party, 30);
		
		selectFromLOV(drivernew, Add_Quote_Party, lastGenparty.partyName);
		RLog("INFO","Party name selected by key from LOV  as "+lastGenparty.partyName);
		
		enterDate(driver,Add_Quote_ValidFrom,0,"dd-MM-yyyy");
		RLog("INFO","ValidFrom entered as "+getDate(0, "dd-MM-yyyy"));
		
		enterDate(driver,Add_Quote_ExpiresOn,8,"dd-MM-yyyy");
		RLog("INFO","ExpiresOn entered as "+getDate(8, "dd-MM-yyyy"));
        
		selectFromLOV(drivernew, Add_Quote_SalesCoordinator, lastGenparty.salesCoordinator);
		
		Add_Quote_ServicesTabPage.click();
		Add_Quote_ServicesTabPage.sendKeys(Keys.PAGE_DOWN);
		
		selectFromLOV(drivernew, Add_Quote_Services_Origin,lastGenparty.origin);
		
		selectFromLOV(drivernew, Add_Quote_Services_Destination,lastGenparty.destination);
		
		selectFromLOV(drivernew, Add_Quote_Services_TOS,lastGenparty.termOfShipment);
		
		Add_Quote_Services_Grossweight.click();
		Add_Quote_Services_Grossweight.sendKeys(RandomGetData.generateRandomNumber(10000));
		
		Add_Quote_Services_VolumeWeight.click();
		Add_Quote_Services_VolumeWeight.sendKeys(RandomGetData.generateRandomNumber(1000000));
		
		Add_Quote_SAVE.click();
		RLog("INFO","Quotation SAVE Btton CLicked ");
		
		
		String OutPut=CheckFinal(drivernew);
		System.out.println(" Output" +OutPut);
		
		return OutPut;
	}
	
	public String createQuotAsLastGeneratedParty(WebDriver drivernew, Partye TypeOftheCustomer)
	{
		return createquote(drivernew, Auto.PartyBundle.get(TypeOftheCustomer)); 
	}
	
	// old
//	public void createquote(Partye TypeofCustomer)
//	{
//		Party party=Auto.GenerateParty(TypeofCustomer);
//		
//		selectFromLOV(Add_Quote_Party,party.partyName);//party.partyName
//		
//		selectFromLOV(Add_Quote_Shipper, party.shipperName);
//		
//		enterDate(Add_Quote_ValidFrom,0,"dd-MM-yyyy");
//		
//		enterDate(Add_Quote_ExpiresOn,8,"dd-MM-yyyy");
//		
//        
//		selectFromLOV(Add_Quote_SalesCoordinator, party.salesCoordinator);
//		
//		Add_Quote_ServicesTabPage.click();
//		Add_Quote_ServicesTabPage.sendKeys(Keys.PAGE_DOWN);
//		
//		selectFromLOV(Add_Quote_Services_Origin,party.origin);
//		
//		selectFromLOV(Add_Quote_Services_Destination,party.destination);
//		
//		selectFromLOV(Add_Quote_Services_TOS,party.termOfShipment);
//		
//		Add_Quote_Services_Grossweight.click();
//		Add_Quote_Services_Grossweight.sendKeys(RandomGetData.generateRandomNumber(10000));
//		
//		Add_Quote_Services_VolumeWeight.click();
//		Add_Quote_Services_VolumeWeight.sendKeys(RandomGetData.generateRandomNumber(1000000));
//		
//		Add_Quote_SAVE.click();
//		System.out.println("Done Save ");
//		
//		String OutPut=CheckFinal();
//		System.out.println(" Output" +OutPut);
//		
//	}
	
}
