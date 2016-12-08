package Master;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.http.cookie.ClientCookie;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import com.thoughtworks.selenium.webdriven.commands.WaitForPageToLoad;

import MasterGenerators.Auto;
import MasterGenerators.Auto.PartyAddresse;
import MasterGenerators.Auto.Partye;
import MasterGenerators.Party;
import Master_util.PageUtils;
import testUtills.Utills;

public class PartyMasterPage extends PageUtils
{
	//WebDriver Partydriver;

	public PartyMasterPage(WebDriver driverPartyMasterPage)//400
	{
		super(driverPartyMasterPage);
		this.driver=driverPartyMasterPage;
	}
	
	
	@FindBy(how=How.XPATH,using=".//*[@id='main-view']/div/div/div[1]/div/div[1]/div/div[1]/button") 
	private WebElement Add_Party_Btn;
	
	@FindBy(how=How.ID,using="partyName") 
	private WebElement Add_Party_Name;
	
	@FindBy(how=How.XPATH,using=".//*[@id='partyMain-panel']/ul/li/div/ul/li/div/div/div/div[2]/div/div[1]/div[1]/input") 
	private WebElement Add_Party_Country;
	
	
	
	
	@FindBy(how=How.ID,using="ui-id-1") 
	private WebElement Add_Party_Country_LOVList;
	
	//MoreInfo_Tabpage
	@FindBy(how=How.XPATH,using=".//*[@id='partyMain-panel']/div[2]/ul/li[2]/button") 
	private WebElement Add_Party_MoreInfo_Tabpage;
	
	
	
	@FindBy(how=How.XPATH,using=".//*[@id='partyMain-panel']/ul/ul/div/div[1]/ul/li[2]/div/div[1]/div/div/div/div[1]/input") 
	private WebElement Add_Party_MoreInfo_Tabpage_Category;
	@FindBy(how=How.XPATH,using=".//*[@id='partyMain-panel']/ul/ul/div/div[1]/ul/li[1]/ul/div[1]") 
	private WebElement Add_Party_MoreInfo_Tabpage_Category_LOVList;
	
	
//	@FindBy(how=How.ID,using="ui-id-1") 
//	private WebElement Add_Party_MoreInfo_Tabpage_Category_LOVList;
//	
	
	//Address_Tabpage
	@FindBy(how=How.XPATH,using=".//*[@id='partyMain-panel']/div[2]/ul/li[1]/button") 
	private WebElement Add_Party_Address_Tabpage;
	
	
	
	@FindBy(how=How.XPATH,using=".//*[@id='partyMain-panel']/ul/ul/div/div[2]/ul/div/div[1]/button") 
	private WebElement Add_Party_AddAddressButton;
	
	@FindBy(how=How.CSS,using="button-group[class='ng-isolate-scope'][state='partyAddressMaster.addressType']") 
	private WebElement Add_Party_AddAddress_PrimaryTypeButtons;
	
	
	
	
	@FindBy(how=How.XPATH,using=".//*[@id='partyMain-panel']/div[2]/div/div[2]/ul/div/div[2]/div[2]/ul/div[1]/div[1]/ul/li/ul/li[1]/button-group/div/div[1]/button") 
	private WebElement Add_Party_AddAddress_PrimaryTypeButton;
	@FindBy(how=How.XPATH,using=".//*[@id='partyMain-panel']/ul/ul/div/div[2]/ul/div/div[2]/div[2]/ul/div[1]/div[1]/ul/li/ul/li[1]/button-group/div/div[2]/button") 
	private WebElement Add_Party_AddAddress_BillingTypeButton;
	@FindBy(how=How.XPATH,using=".//*[@id='partyMain-panel']/ul/ul/div/div[2]/ul/div/div[2]/div[2]/ul/div[1]/div[1]/ul/li/ul/li[1]/button-group/div/div[3]/button") 
	private WebElement Add_Party_AddAddress_WarehouseTypeButton;
	@FindBy(how=How.XPATH,using=".//*[@id='partyMain-panel']/ul/ul/div/div[2]/ul/div/div[2]/div[2]/ul/div[1]/div[1]/ul/li/ul/li[1]/button-group/div/div[4]/button") 
	private WebElement Add_Party_AddAddress_OtherTypeButton;
	
	
	
	@FindBy(how=How.XPATH,using=".//*[@id='addressLine1PartyMaster0']") 
	private WebElement Add_Party_AddAddress_Address1;
	@FindBy(how=How.XPATH,using=".//*[@id='partyMain-panel']/div[2]/div/div[2]/div/div/div[2]/ul/div[1]/div[3]/div[1]/div/div/div[3]/div/input") 
	private WebElement Add_Party_AddAddress_Address2;
	@FindBy(how=How.XPATH,using=".//*[@id='partyMain-panel']/div[2]/div/div[2]/div/div/div[2]/ul/div[1]/div[3]/div[1]/div/div/div[4]/div/input") 
	private WebElement Add_Party_AddAddress_Address3;
	
	@FindBy(how=How.XPATH,using=".//*[@id='poZip0']")//.//*[@id='partyMain-panel']/div[2]/div/div[2]/div/div/div[2]/ul/div[1]/div[3]/div[1]/div/div/div[5]/div[1]/input 
	private WebElement Add_Party_AddAddress_ZipCode;
	
	@FindBy(how=How.XPATH,using=".//*[@id='city0']") 
	private WebElement Add_Party_AddAddress_City;
	
	@FindBy(how=How.XPATH,using=".//*[@id='stateProvince0']") 
	private WebElement Add_Party_AddAddress_State;
	
	@FindBy(how=How.XPATH,using=".//*[@id='conName0']") 
	private WebElement Add_Party_AddAddress_ContactName;
	@FindBy(how=How.XPATH,using=".//*[@id='addressemail0']") 
	private WebElement Add_Party_AddAddress_MailID;
	@FindBy(how=How.XPATH,using=".//*[@id='partyMain-panel']/div[2]/div/div[2]/div/div/div[2]/ul/div[1]/div[3]/div[2]/div/div[2]/div[2]/input") 
	private WebElement Add_Party_AddAddress_PhoneNo;
	@FindBy(how=How.XPATH,using=".//*[@id='partyMain-panel']/div[2]/div/div[2]/div/div/div[2]/ul/div[1]/div[3]/div[2]/div/div[3]/div[1]/input") 
	private WebElement Add_Party_AddAddress_MobileNo;
	@FindBy(how=How.XPATH,using=".//*[@id='partyMain-panel']/div[2]/div/div[2]/div/div/div[2]/ul/div[1]/div[3]/div[2]/div/div[3]/div[2]/input") 
	private WebElement Add_Party_AddAddress_FaxNo;
	
	
	
	@FindBy(how=How.XPATH,using=".//*[@id='partyMain-panel']/div[2]/div/div[2]/ul/div/div[2]/div[2]/ul/div[1]/div[3]/div[2]/div/div[4]/div/input") 
	private WebElement Add_Party_AddAddress_PickupHours;
	
	@FindBy(how=How.XPATH,using=".//*[@id='partyMain-panel']/ul/ul/div/div[2]/ul/div/div[2]/div[1]/div[2]/ul/li[2]/input") 
	private WebElement Add_Party_AddAddress_Save;
	
	//.//*[@id='partyMasterForm']/div/div[1]/div[2]/ul/li[2]/input
	@FindBy(how=How.XPATH,using=".//*[@id='partyMasterForm']/div/div[1]/div[2]/ul/li[1]/button") 
	private WebElement Add_Party_AddAddress_Discard;
	
	@FindBy(how=How.XPATH,using=".//*[@id='partyMain-panel']/ul/ul/div/div[2]/ul/div/div[1]/ul/div/div/div[1]/ul/li[2]/a/i") 
	private WebElement Add_Party_AddAddress_Edit;
	
	@FindBy(how=How.XPATH,using=".//*[@id='partyMain-panel']/ul/ul/div/div[2]/ul/div/div[1]/ul/div/div/div[1]/ul/li[3]/a/i") 
	private WebElement Add_Party_AddAddress_Delete;
	
	@FindBy(how=How.XPATH,using=".//*[@id='partyMasterForm']/div/div[1]/div[2]/ul/li[2]/input") 
	private WebElement Add_Party_Save;
	
	
	
	@FindBy(how=How.XPATH,using=".//*[@id='main-view']/div/div/div[3]/div/div[1]/div/div[2]/ul/li[2]/a/i") 
	private WebElement View_Party_Edit;
	
	@FindBy(how=How.CSS,using="show-status[class='ng-isolate-scope']") 
	private WebElement View_Party_Status;
	
	@FindBy(how=How.XPATH,using=".//*[@id='main-view']/div/div/div[2]/div/div[1]/div/button[1]") 
	private WebElement View_Party_Back;
	
	public void Goto(WebDriver drivernew)
	{
		if (Pages.PartyMaster(drivernew).IsAt()==false)
		{
			Pages.TopNavigation(drivernew).PartyMaster(drivernew);
		}
	}
	
	public boolean IsAt()
	{
		try 
		{
			System.out.println("Add_Party_Btn.isDisplayed()" +Add_Party_Btn.isDisplayed());
			boolean d=Add_Party_Btn.isDisplayed();
			return d;
		}
		catch (Exception e) 
		{
			return false;
		}
	}
	
	public boolean IsAtAddParty()
	{
		try 
		{
			String text=Add_Party_Name.getText();
			return true;
		} 
		catch (Exception e) 
		{
			return false;
		}
	}
	
	public void GotoAddParty(WebDriver drivernew)
	{
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//FindAndClick(Add_Party_Btn);
		
		clickWhenReady(drivernew,Add_Party_Btn, 30);
//		
//		if(Pages.PartyMaster(driver).IsAt()==true)
//		{
//			clickWhenReady(Add_Party_Btn, 30);
//		}
//		else if (Pages.PartyMaster(driver).IsAtAddParty()==false)
//		{
//			Pages.TopNavigation(driver).PartyMaster();
//			
//			clickWhenReady(Add_Party_Btn, 30);
//		}
//		else
//		{
//			System.out.println("Already in ADD PARTY MASTER screen : GOTOADDPARTY");
//		}
		RLog(drivernew,"INFO","Navigated to Add Party Screen");
	}
	
	public String RegisterNewParty(WebDriver Drivernew, Partye TypeOfCustomer)
	{
		//driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		//Create Party Name and Address from Generator
		Party NewpartyGEN=Auto.GenerateParty(Drivernew, TypeOfCustomer);
		
		
		//Passing Party Name Send from generator
		clickWhenReady(Drivernew,Add_Party_Name, 30);
		Add_Party_Name.sendKeys(NewpartyGEN.partyName);
		Add_Party_Name.sendKeys(Keys.TAB);
		RLog(Drivernew, "INFO","Party name Entered as  .."+NewpartyGEN.partyName);
		//System.out.println("%%%%%%%%%%%%%%"+ Auto.PartyBundle.get(TypeOfCustomer).partyCode);
		
		System.out.println("Before country Click ");
		//clickWhenReady(Add_Party_Country, 30);
		//System.out.println("Before country 2");
		selectFromLOV(Drivernew, Add_Party_Country, "India");
		Add_Party_Country.sendKeys(Keys.TAB);
		System.out.println("After country ");
		RLog(Drivernew,"INFO","Country name Entered as  .."+"India");
		
//		Add_Party_MoreInfo_Tabpage.click();
//		
//		SelectFromCheckBox("Customer");
//		RLog(Drivernew,"INFO","Customer Selected from  click ");
		
		Add_Party_Address_Tabpage.click();
		
//		clickWhenReady(Add_Party_AddAddressButton, 10);
//		RLog("INFO","Add Address Button clicked");
		
		if(TypeOfCustomer==Partye.MULTIADDRESSCUSTOMER)
		{
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			List<WebElement> AllAddresstypeBtns= Add_Party_AddAddress_PrimaryTypeButtons
									.findElement(By.tagName("div"))
									.findElements(By.tagName("div"));
			//System.out.println("SIZE"+AllAddresstypeBtns.size());
			
			for(WebElement AddressType : AllAddresstypeBtns)
			{
				WebElement AddressTypeButton=AddressType.findElement(By.tagName("button"));
				String AddressbuttonType=AddressTypeButton.getText();
				
				
				//System.out.println("MULTIADDRESS"+AddressbuttonType);
				
				switch(AddressbuttonType)
				{
					case "Primary" :
						
						clickWhenReady(Drivernew, AddressTypeButton, 10);
						
						//clickWhenReady(Add_Party_AddAddress_PrimaryTypeButton, 30);
						
						ClickAndClear(Drivernew, Add_Party_AddAddress_Address1);
						Add_Party_AddAddress_Address1.sendKeys(NewpartyGEN.partyAddress1);
						RLog(Drivernew,"INFO","Add_Party_AddAddress_Address1 entered as..."+NewpartyGEN.partyAddress1);
						
						ClickAndClear(Drivernew, Add_Party_AddAddress_Address2);
						Add_Party_AddAddress_Address2.sendKeys(NewpartyGEN.partyAddress2);
						
						FindAndClick(Drivernew, Add_Party_AddAddress_Save);
						RLog(Drivernew,"INFO","Primary Address Saved");
						
						clickWhenReady(Drivernew, Add_Party_AddAddressButton, 10);
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
			            
					case "Billing" :
						
						
						clickWhenReady(Drivernew, AddressTypeButton, 10);
						
			        	System.out.println("Billing!"); 
			        	//clickWhenReady(Add_Party_AddAddress_PrimaryTypeButton, 30);
						
						ClickAndClear(Drivernew, Add_Party_AddAddress_Address1);
						Add_Party_AddAddress_Address1.sendKeys(NewpartyGEN.partyBillingAddress1);
						RLog(Drivernew,"INFO","Add_Party_AddAddress_Address1 entered as..."+NewpartyGEN.partyBillingAddress1);
						
						ClickAndClear(Drivernew, Add_Party_AddAddress_Address2);
						Add_Party_AddAddress_Address2.sendKeys(NewpartyGEN.partyBillingAddress2);
						
						FindAndClick(Drivernew, Add_Party_AddAddress_Save);
						RLog(Drivernew,"INFO","Billing Address Saved ");
						
						clickWhenReady(Drivernew, Add_Party_AddAddressButton, 10);
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
			            
					case "Warehouse"  :
						
						System.out.println("Warehouse");
						clickWhenReady(Drivernew, AddressTypeButton, 10);
						//clickWhenReady(Add_Party_AddAddress_PrimaryTypeButton, 30);
						
						ClickAndClear(Drivernew, Add_Party_AddAddress_Address1);
						Add_Party_AddAddress_Address1.sendKeys(NewpartyGEN.partyWareHouseAddress1);
						RLog(Drivernew,"INFO","Add_Party_AddAddress_Address1 entered as..."+NewpartyGEN.partyWareHouseAddress1);
						
						ClickAndClear(Drivernew, Add_Party_AddAddress_Address2);
						Add_Party_AddAddress_Address2.sendKeys(NewpartyGEN.partyWareHouseAddress2);
						
						FindAndClick(Drivernew, Add_Party_AddAddress_Save);
						RLog(Drivernew,"INFO","Warehouse Address Saved ");
						
						clickWhenReady(Drivernew, Add_Party_AddAddressButton, 10);
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
						
					case "Other" :
						
						
						System.out.println("Warehouse");
						clickWhenReady(Drivernew, AddressTypeButton, 10);
						
						System.out.println("Other");
						//clickWhenReady(Add_Party_AddAddress_PrimaryTypeButton, 30);
						
						ClickAndClear(Drivernew, Add_Party_AddAddress_Address1);
						Add_Party_AddAddress_Address1.sendKeys(NewpartyGEN.partyOtherAddress1);
						RLog(Drivernew,"INFO","Add_Party_AddAddress_Address1 entered as..."+NewpartyGEN.partyOtherAddress1);
						
						ClickAndClear(Drivernew, Add_Party_AddAddress_Address2);
						Add_Party_AddAddress_Address2.sendKeys(NewpartyGEN.partyOtherAddress2);
						
						FindAndClick(Drivernew, Add_Party_AddAddress_Save);
						RLog(Drivernew,"INFO","Other Address Saved");
						
						break;
					default :
						System.out.println("Button doesnotmatch");
				}
			}
			
		}
		else
		{
			//clickWhenReady(Drivernew, Add_Party_AddAddress_PrimaryTypeButton, 10);
			
			ClickAndClear(Drivernew, Add_Party_AddAddress_Address1);
			Add_Party_AddAddress_Address1.sendKeys(NewpartyGEN.partyAddress1);
			Add_Party_AddAddress_Address1.sendKeys(Keys.TAB);
			RLog(Drivernew,"INFO","Party Address1 entered as..."+NewpartyGEN.partyAddress1);
			
			ClickAndClear(Drivernew, Add_Party_AddAddress_Address2);
			Add_Party_AddAddress_Address2.sendKeys(NewpartyGEN.partyAddress2);
			Add_Party_AddAddress_Address2.sendKeys(Keys.TAB);
			RLog(Drivernew,"INFO","Party Address2 entered as..."+NewpartyGEN.partyAddress2);

			//Add_Quote_Page.sendKeys(Keys.PAGE_DOWN);
			//Common_Page.sendKeys(Keys.PAGE_DOWN);
//			System.out.println("Before Tab-page");
//			FindAndClick(Drivernew, Add_Party_Address_Tabpage);
//			System.out.println("Before page down");
//			Add_Party_Address_Tabpage.sendKeys(Keys.PAGE_DOWN);
//			System.out.println("Before wait");
//			try 
//			{
//				System.out.println(" on wait ");
//				Thread.sleep(2000);
//			} 
//			catch (InterruptedException e) 
//			{
//				System.out.println("Party Master - Register new Party try catch issue Error is :"+e.getMessage());
//			}
			System.out.println("Before Clcick address 3");
			ClickAndClear(Drivernew,Add_Party_AddAddress_Address3);
			System.out.println("After Clcick address 3");
			
			//FindAndClick(Drivernew, Add_Party_AddAddress_Address3);
			Add_Party_AddAddress_Address3.sendKeys(NewpartyGEN.partyAddress3);
			Add_Party_AddAddress_Address3.sendKeys(Keys.TAB);
			RLog(Drivernew,"INFO","Party Address3 entered as..."+NewpartyGEN.partyAddress3);
			
			ClickAndClear(Drivernew, Add_Party_AddAddress_ZipCode);
			Add_Party_AddAddress_ZipCode.sendKeys(NewpartyGEN.partyAddressZipCode);
			Add_Party_AddAddress_ZipCode.sendKeys(Keys.TAB);
			RLog(Drivernew,"INFO","Party ZipCode entered as..."+NewpartyGEN.partyAddressZipCode);
			
//			//LOV
//			ClickAndClear(Add_Party_AddAddress_City);
//			Add_Party_AddAddress_City.sendKeys(NewpartyGEN.partyAddressCity);
//			Add_Party_AddAddress_City.sendKeys(Keys.TAB);
//			RLog("INFO","Party City entered as..."+NewpartyGEN.partyAddressCity);
//			//LOV
//			ClickAndClear(Add_Party_AddAddress_State);
//			Add_Party_AddAddress_State.sendKeys(NewpartyGEN.partyAddressState);
//			Add_Party_AddAddress_State.sendKeys(Keys.TAB);
//			RLog("INFO","Party State entered as..."+NewpartyGEN.partyAddressState);
			
			ClickAndClear(Drivernew, Add_Party_AddAddress_ContactName);
			Add_Party_AddAddress_ContactName.sendKeys(NewpartyGEN.partyAddressContactName);
			Add_Party_AddAddress_ContactName.sendKeys(Keys.TAB);
			RLog(Drivernew,"INFO","Party Contact Name  entered as..."+NewpartyGEN.partyAddressContactName);
			
			ClickAndClear(Drivernew, Add_Party_AddAddress_MailID);
			Add_Party_AddAddress_MailID.sendKeys(NewpartyGEN.partyAddressMailId);
			Add_Party_AddAddress_MailID.sendKeys(Keys.TAB);
			RLog(Drivernew,"INFO","Party Mail ID entered as..."+NewpartyGEN.partyAddressMailId);
			
			ClickAndClear(Drivernew, Add_Party_AddAddress_PhoneNo);
			Add_Party_AddAddress_PhoneNo.sendKeys(NewpartyGEN.partyAddressPhoneNo);
			Add_Party_AddAddress_PhoneNo.sendKeys(Keys.TAB);
			RLog(Drivernew,"INFO","Party Phone no entered as..."+NewpartyGEN.partyAddressPhoneNo);
			
			ClickAndClear(Drivernew, Add_Party_AddAddress_MobileNo);
			Add_Party_AddAddress_MobileNo.sendKeys(NewpartyGEN.partyAddressMobileNo);
			Add_Party_AddAddress_MobileNo.sendKeys(Keys.TAB);
			RLog(Drivernew,"INFO","Party Mobile no entered as..."+NewpartyGEN.partyAddressMobileNo);
			
			ClickAndClear(Drivernew, Add_Party_AddAddress_FaxNo);
			Add_Party_AddAddress_FaxNo.sendKeys(NewpartyGEN.partyAddressFaxNo);
			//Add_Party_AddAddress_FaxNo.sendKeys(Keys.TAB);
			RLog(Drivernew,"INFO","Party Fax no entered as..."+NewpartyGEN.partyAddressFaxNo);
			
			//ClickAndClear(Drivernew, Add_Party_AddAddress_PickupHours);
			//Add_Party_AddAddress_PickupHours.sendKeys(NewpartyGEN.partyAddressPickupHours);
			//Add_Party_AddAddress_PickupHours.sendKeys(Keys.TAB);
			//RLog(Drivernew,"INFO","Party PickUp hours entered as..."+NewpartyGEN.partyAddressPickupHours);
			
			
			//FindAndClick(Drivernew, Add_Party_AddAddress_Save);
			//RLog(Drivernew,"INFO","Address Save button clicked ");
			
		}
		
		System.out.println("before error check "+Add_Party_Save.isDisplayed());
		System.out.println("before error check "+Add_Party_Save.getLocation());
		System.out.println("before error check "+Add_Party_Save.getTagName());
		
//		try 
//		{
//			Actions action = new Actions(Drivernew);
//			action.moveToElement(elementnew).click(elementnew).build().perform();
//			//elementnew.click();
//		} 
//		catch (Exception e) 
//		{
//			System.out.println("Find And Click Error Occured "+e.getMessage());
//		}
		
		
//		Actions action = new Actions(Drivernew);
//		WebElement we = Drivernew.findElement(By.xpath("html/body/div[13]/ul/li[4]/a"));
//		action.moveToElement(we).moveToElement(Drivernew.findElement(By.xpath("/expression-here"))).click().build().perform();
		
		//Add_Party_Save.click();
		FindAndClick(Drivernew, Add_Party_Save);
		//clickWhenReady(Drivernew, Add_Party_Save, 30);
		System.out.println("before error check 2 ");
		
		//clickWhenReady(Drivernew, Add_Party_Save, 10);
		RLog(Drivernew,"INFO","Party Save button clicked ");
		
		System.out.println("before error check ");
		String OutPut=CheckFinal(Drivernew);
		System.out.println("Register before setHolderName print  time : "+getCurrentDateTime());
		
		Auto.PartyBundle.get(Lastgenerator(Drivernew,TypeOfCustomer)).setHolderName(TypeOfCustomer);
		System.out.println("Register setHolderName after   time : "+getCurrentDateTime());
		Auto.PartyBundle.get(Lastgenerator(Drivernew,TypeOfCustomer)).setPartyCode(GetCodefromMessage(OutPut,"PartyMaster"));
		System.out.println("Register setPartyCode after time : "+getCurrentDateTime());
		RLog(Drivernew,"INFO","New "+TypeOfCustomer.toString()+" Party Registered Successfully."+GetCodefromMessage(OutPut,"PartyMaster")+"-"+NewpartyGEN.partyName);
		System.out.println("Register last time : "+getCurrentDateTime());
		return OutPut;
		
	}
	
	public boolean IsLastGeneratedPartyPresentinPartyMaster(WebDriver drivernew, String Code)
	{
		System.out.println("IsLastGeneratedPartyPresentinPartyMaster 1 : "+getCurrentDateTime());
		Pages.TopNavigation(drivernew).PartyMaster(drivernew);
		
		System.out.println("IsLastGeneratedPartyPresentinPartyMaster 2 : "+getCurrentDateTime());
		EnterListscreenSearch(drivernew,"Code",Code);
		RLog(drivernew,"INFO","AFTER EnterListscreenSearch ");
		
		return IsRowpresentInListScreen();
	}
	
	public boolean InPartyMasterCheckIsPartyCodeStatusAs(WebDriver drivernew, String Status,String PartyCode)
	{
		try //ChangePartyStatusAsBlocked
		{
			Thread.sleep(1000);
		} 
		catch (InterruptedException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("1");
		Pages.TopNavigation(drivernew).PartyMaster(drivernew);
		
		EnterListscreenSearch(drivernew,"Code",PartyCode);
		RLog(drivernew,"INFO","AFTER EnterListscreenSearch ");
		
		ClickListscreen("Code",PartyCode);
		
		try //ChangePartyStatusAsBlocked
		{
			Thread.sleep(2000);
		} 
		catch (InterruptedException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(View_Party_Status.getText().contentEquals(Status))
		{
			View_Party_Back.click();
			return true;
		}
		else
		{
			View_Party_Back.click();
			return false;
		}
		
		//IsMasterStatusBlocked()
		//IsRowpresentInListScreen()
		
	}
	
	public String  ChangePartyStatusAs(WebDriver drivernew, Party LasGenedPaty, String StatusVisibleText)
	{
		try //ChangePartyStatusAsBlocked
		{
			Thread.sleep(5000);
		} 
		catch (InterruptedException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("%%%%%%%%%%%"+Auto.PartyBundle.size());
		
		EnterListscreenSearch(drivernew,"Code",LasGenedPaty.partyCode);
		RLog(drivernew,"INFO","AFTER EnterListscreenSearch ");
		
		ClickListscreen("Name",LasGenedPaty.partyName);
		RLog(drivernew,"INFO","AFTER CLICKED ");
		
		clickWhenReady(drivernew,View_Party_Edit, 30);		
		
		try 
		{
			Thread.sleep(3000);
		} 
		catch (InterruptedException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		WebElement dropdownselect=drivernew
				.findElement(By.cssSelector("div[ng-show='partyMaster.id!=null']"))
				.findElement(By.tagName("select"));

		dropdownselect.click();
		
		try 
		{
			Thread.sleep(2000);
		} 
		catch (InterruptedException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int j=0;
		int requiredvalueposition=0;
		int currentpositionNo=0;
		int totaloptions=0;
		String currentoptionvalue=null;
		
		List<WebElement> options=dropdownselect.findElements(By.tagName("option"));
		totaloptions=options.size();
		
		Select mySelect= new Select(dropdownselect);
		currentoptionvalue=mySelect.getFirstSelectedOption().getText();
		
		
		System.out.println("YYY selectByVisibleText(Block)" +mySelect.getFirstSelectedOption().getText());
		
		
		
		if(!mySelect.getFirstSelectedOption().getText().contentEquals(StatusVisibleText))//StatusVisibleText //"Block"
		{
			System.out.println("1");
			for(WebElement optionpostion:options)
			{
				j=j+1;
				if(optionpostion.getText().contentEquals(StatusVisibleText))//StatusVisibleText//"Block"
				{
					System.out.println("loop if  j"
							+j
							+optionpostion.getText());
					
					requiredvalueposition=j;
					
					//break;
				}
				else
				{
					if(currentoptionvalue.equals(optionpostion.getText()))
					{
						currentpositionNo=j;
						
						System.out.println("oop else "
													+j
													+optionpostion.getText()
													+currentpositionNo 
													+currentoptionvalue);
					}
				}
				
				
			}
			
			System.out.println("Drop******" 
					+totaloptions
					+"***"
					+ currentpositionNo 
					+"****"
					+ requiredvalueposition);
			
			if(currentpositionNo!=0 && requiredvalueposition!=0 && totaloptions!=0)
			{
				if(currentpositionNo > requiredvalueposition)
				{
					for(int k=0;k<currentpositionNo-requiredvalueposition;k++)
					{
						dropdownselect.sendKeys(Keys.ARROW_UP);
						try 
						{
							Thread.sleep(2000);
						} 
						catch (InterruptedException e) 
						{
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						//page up
					}
				}
				else if(requiredvalueposition > currentpositionNo)
				{
					for(int l=0;l<requiredvalueposition-currentpositionNo;l++)
					{
						dropdownselect.sendKeys(Keys.ARROW_DOWN);
						try 
						{
							Thread.sleep(2000);
						} 
						catch (InterruptedException e) 
						{
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						//page down
					}
				}
				else
				{
					System.out.println(" Frame work issue "
							+ "currentpositionNo and "
							+ "requiredvalueposition level issue in ");
				}
				
			}
			else
			{
				System.out.println(" Frame Work Error kindly check currentpositionNo requiredvalueposition may be 0");
			}
			
			currentoptionvalue=mySelect.getFirstSelectedOption().getText();
			System.out.println("xxx currentoptionvalue" +currentoptionvalue);
			
			if(currentoptionvalue.contentEquals(StatusVisibleText))//StatusVisibleText //"Block"
			{
				dropdownselect.sendKeys(Keys.TAB);
				
			}
			else
			{
				System.out.println("Frame work Down issue kindly check ");
			}
			
		}
		else
		{
			System.out.println("Already "+ StatusVisibleText+ " Blocked Party");
		}

		try 
		{
			Thread.sleep(2000);
		} 
		catch (InterruptedException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		drivernew.findElement(By
				.cssSelector("input[value='Update'][type='submit']"))
				.click();
		
		String output= CheckFinal(drivernew);
		try 
		{
			Thread.sleep(2000);
		} 
		catch (InterruptedException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//mySelect.selectByVisibleText("Block");
		
		
//		cancel
//		button[class^='btn'][class$='cancel-btn'][type='button'][ng-click='cancel()']
//		
//		Update
//		input[value='Update'][type='submit']
		
		
		
		return output;
		
	}
	
	public String ChangeLastRegisteredPartyStatusAsBlocked(WebDriver drivernew, Partye Typeofthecustomer)
	{
		//return ChangePartyStatusAsBlocked(Partye.SHIPPER,Auto.LastGeneratedPartys1.get(0).get(1));
		Party p=Auto.PartyBundle.get(Lastgenerator(drivernew,Typeofthecustomer));
		return ChangePartyStatusAs(drivernew, p,"Block");
	}
	
	public String ChangeLastRegisteredPartyStatusAsHidden(WebDriver drivernew, Partye Typeofthecustomer)
	{
		//return ChangePartyStatusAsBlocked(Partye.SHIPPER,Auto.LastGeneratedPartys1.get(0).get(1));
		Party p=Auto.PartyBundle.get(Lastgenerator(drivernew,Typeofthecustomer));
		
		return ChangePartyStatusAs(drivernew, p,"Hide");
	}
	
	
			

}
