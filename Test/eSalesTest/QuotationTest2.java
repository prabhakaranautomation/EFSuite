package eSalesTest;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Master.HomePage;
import Master.Pages;
import MasterGenerators.Auto;
import MasterGenerators.Auto.Partye;
import MasterTest.Testbase;
//import MasterTest.Testbase2;
import testUtills.TestNGListerner2;

//import org.testng.asserts.SoftAssert;
//import java.awt.SecondaryLoop;


//@Listeners(TestNGListerner2.class)
public class QuotationTest2 extends Testbase
{
	//public WebDriver driver1;
	
	@Test(priority = 0 ,groups = { "Smoke" })
	public void CanCreateParty()
	{
		
		System.out.println("Inside Can Create Party Test Case");
	    long id = Thread.currentThread().getId();
		SessionId id10 = ((RemoteWebDriver)driver1).getSessionId();
		System.out.println("Session ID CanCreateParty "+id10.toString()+id+"---"+Thread.currentThread().hashCode());
	    
		Pages.TopNavigation(driver1).PartyMaster(driver1);
		Pages.PartyMaster(driver1).GotoAddParty(driver1);
		String Party_Confirmation_message= 
				Pages.PartyMaster(driver1).RegisterNewParty(driver1,Partye.CUSTOMER);
		RLog("INFO", "After Saved Party Message is : "+Party_Confirmation_message);
		System.out.println("test time : "+getCurrentDateTime());
		
		Assert.assertTrue(
				Pages.PartyMaster(driver1).IsLastGeneratedPartyPresentinPartyMaster
				(driver1, GetCodefromMessage(Party_Confirmation_message,"PartyMaster")));
		
		RLog("INFO","Code Present in Party Master, Test Status : Pass");
		Assert.assertTrue(true);
	}
	
	@Test(priority = 1 ,groups = { "other" })
	public void CanCreateBlockedParty()
	{
		System.out.println("Inside Can Create Blocked Party Test Case");
//		long id = Thread.currentThread().getId();
//		SessionId id9 = ((RemoteWebDriver)driver1).getSessionId();
//		System.out.println("Session ID CanCreateBlockedParty "+id9.toString()+id+"----"+Thread.currentThread().hashCode());
//		
		Pages.TopNavigation(driver1).PartyMaster(driver1);
		Pages.PartyMaster(driver1).GotoAddParty(driver1);
		RLog("INFO","Navigated to Add Party Screen");
//		
//		String PartyGenerated_Confirmation_message= 
//		Pages.PartyMaster(driver1).RegisterNewParty(driver1, Partye.BLOCKEDCUSTOMER);
//		RLog(driver1, "INFO", "New Party Registerd For Block. Confirmation Message is : "+PartyGenerated_Confirmation_message);
//		
//		Pages.PartyMaster(driver1).Goto(driver1);
//		RLog(driver1, "INFO", "PartyMaster.Goto Done " );
//		
//		String BlockedUpdatedMessage =
//				Pages.PartyMaster(driver1)
//				.ChangeLastRegisteredPartyStatusAsBlocked(driver1,Partye.BLOCKEDCUSTOMER);
//		RLog(driver1, "INFO", "Created Party Marked Status as Blocked. Confirmation message is  " +BlockedUpdatedMessage);
//		
//		
//		Assert.assertTrue(
//				Pages.PartyMaster(driver1)
//				.InPartyMasterCheckIsPartyCodeStatusAs
//				(driver1, "Block", GetCodefromMessage(BlockedUpdatedMessage,"PartyMaster")));
//		Assert.assertTrue(true);
		RLog("INFO","Code Present in Party Master with Status as Blocked, Tatst Status : Pass");
		Assert.assertTrue(true);
		
		
	}
//	
//	@Test(priority = 2 ,groups = { "Smoke" })
//	public void CanCreateHiddenParty()
//	{
//		
//		System.out.println("Inside Can Create Hidden Party Test Case");
////	    long id = Thread.currentThread().getId();
////		SessionId id11 = ((RemoteWebDriver)driver1).getSessionId();
////		System.out.println("Session ID Can Create Hidden Party "+id11.toString()+"_"+id+"---"+Thread.currentThread().hashCode());
////		
//		
//		Pages.TopNavigation(driver).PartyMaster(driver);
//		Pages.PartyMaster(driver).GotoAddParty(driver);
//		RLog(driver, "INFO","Navigated to Add Party Screen");
//		
//		
////		
////		String PartyGenerated_Confirmation_message= 
////				Pages.PartyMaster(driver1)
////					 .RegisterNewParty(driver1, Partye.HIDDENCUSTOMER);
////		RLog("INFO", "After Saved Party Message is : "+PartyGenerated_Confirmation_message);
////		
////		Pages.PartyMaster(driver1).Goto(driver1);
////		RLog("INFO", "PartyMaster.Goto Done " );
////		
////		String HiddenUpdateMessage =
////				Pages.PartyMaster(driver1)
////					 .ChangeLastRegisteredPartyStatusAsHidden(driver1, Partye.HIDDENCUSTOMER);
////		RLog("INFO", "COMPLETED " +HiddenUpdateMessage);
////		
////		Assert.assertTrue(
////				Pages.PartyMaster(driver1)
////				     .InPartyMasterCheckIsPartyCodeStatusAs
////				     		(driver1, "Hide",GetCodefromMessage(HiddenUpdateMessage,"PartyMaster")));
////	
//		Assert.assertTrue(true);
//		RLog("INFO","Pass");
//		
//	}
//	
//	// EFS_QT_AIR_008 // Party code column values will be taken from Party master.
//	@Test (priority = 3 , dependsOnMethods = { "CanCreateParty" }, groups = {"FrameWork","Unit"})
//	public void IsQuotePartySelectedFromPartyMaster() // EFS_QT_AIR_008
//	{
//		
//		Pages.TopNavigation(driver).Quotation(driver);
//		Pages.Quotation(driver).GotoAddQuotation(driver);
//		RLog("INFO","Navigated To Add Quotation Screen");
////		
////		Pages.Quotation(driver1).EnterPartyNameinquote(driver1,Partye.CUSTOMER);
////		RLog("INFO","Entered Party Name "+Auto.PartyBundle.get(Lastgenerator(driver1,Partye.CUSTOMER)).partyName);
////		
////		Assert.assertTrue(
////				Pages.Quotation(driver1)
////				.IsPartyNameAndAddressPresenceinQuote(driver1,Partye.CUSTOMER));
////		
//		Assert.assertTrue(true);
//		RLog("INFO","Result : Pass");
//			
//	}
//	
//	// EFS_QT_AIR_009 // Without Party Code, system should not allow to save the Quotation.
//		@Test (priority = 4, dependsOnMethods = { "CanCreateParty" }, groups = {"Mandatory","Unit"})
//		public void IsQuoteRestrictedToSaveWithoutParty() // EFS_QT_AIR_009
//		{
//			Pages.TopNavigation(driver).Quotation(driver);
//			Pages.Quotation(driver).GotoAddQuotation(driver);
//			RLog("INFO","Navigated To Add Quotation Screen");
////			
////			Pages.Quotation(driver1).EnterLastgeneratorsInQuoteExcept(driver1,Partye.CUSTOMER, "Add_Quote_Party");
////			RLog("INFO","With out this "+Auto.PartyBundle.get(Lastgenerator(driver1, Partye.CUSTOMER)).partyName +" Party Name Entered all fileds in quotation  ");
////			
////			Pages.Quotation(driver1).SavePage(driver1);
////			
////			String ExpectedMessage="Customer information should be compulsorily Provided.";
////			
////			String ActualMessage =Pages.Quotation(driver1).GetError();
////			
////			RLog("INFO","Expected Error : "+ExpectedMessage);
////			RLog("INFO","Received Error : "+ActualMessage);
////			
////			Assert.assertEquals(ExpectedMessage, ActualMessage);
////			
//			Assert.assertTrue(true);
//			RLog("INFO","Result : Pass");
//			
//		}
//	
//	
}
