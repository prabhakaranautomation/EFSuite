package eSalesTest;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Master.Pages;
import MasterGenerators.Auto;
import MasterGenerators.Auto.Partye;
import MasterTest.Testbase;
import MasterTest.Testbase2;
import testUtills.TestNGListerner2;

//import org.testng.asserts.SoftAssert;
//import java.awt.SecondaryLoop;

//@Listeners(TestNGListerner2.class)
public class QuotationTest extends Testbase
{
	
	@Test(priority = 0 ,groups = { "Smoke" })
	public void CanCreateParty()
	{
		System.out.println("4");
	    
		
		Pages.TopNavigation(driver).PartyMaster(driver);
		Pages.PartyMaster(driver).GotoAddParty(driver);
		RLog("INFO","Navigated to Add Party Screen");
		
		String Party_Confirmation_message= 
				Pages.PartyMaster(driver).RegisterNewParty(driver, Partye.CUSTOMER);
		RLog("INFO", "After Saved Party Message is : "+Party_Confirmation_message);
		System.out.println("test time : "+getCurrentDateTime());
		
		Assert.assertTrue(
				Pages.PartyMaster(driver).IsLastGeneratedPartyPresentinPartyMaster
				(driver,GetCodefromMessage(Party_Confirmation_message,"PartyMaster")));
		
		RLog("INFO","Code Present in Party Master, Test Status : Pass");
		
	}
	
	@Test(priority = 1 ,groups = { "Smoke" })
	public void CanCreateBlockedParty()
	{
		System.out.println("4");
		
		Pages.TopNavigation(driver).PartyMaster(driver);
		Pages.PartyMaster(driver).GotoAddParty(driver);
		RLog("INFO","Navigated to Add Party Screen");
		
		String PartyGenerated_Confirmation_message= 
				Pages.PartyMaster(driver).RegisterNewParty(driver, Partye.BLOCKEDCUSTOMER);
		RLog("INFO", "New Party Registerd For Block. Confirmation Message is : "+PartyGenerated_Confirmation_message);
		
		Pages.PartyMaster(driver).Goto(driver);
		RLog("INFO", "PartyMaster.Goto Done " );
		
		String BlockedUpdatedMessage =
				Pages.PartyMaster(driver)
				.ChangeLastRegisteredPartyStatusAsBlocked(driver, Partye.BLOCKEDCUSTOMER);
		RLog("INFO", "Created Party Marked Status as Blocked. Confirmation message is  " +BlockedUpdatedMessage);
		
		
		Assert.assertTrue(
				Pages.PartyMaster(driver)
				.InPartyMasterCheckIsPartyCodeStatusAs
				(driver, "Block", GetCodefromMessage(BlockedUpdatedMessage,"PartyMaster")));
		
		RLog("INFO","Code Present in Party Master with Status as Blocked, Tatst Status : Pass");
		
	}
	
	@Test(priority = 2 ,groups = { "Smoke" })
	public void CanCreateHiddenParty()
	{
		 System.out.println("4");
	      //WebDriver driver = getDriver();
	      
	      long id = Thread.currentThread().getId();
		  System.out.println("idCanCreateParty"+id);
		  
	      System.out.println("5");	      
	      driver1.navigate().to("http://192.168.1.63:8080/index.html");
	      System.out.println("6");
	      driver1.manage().window().maximize();
	      System.out.println("7");
	      Pages.Home(driver1).EFSlogin(driver1, "EFS","sathish","sathish");
	      driver1.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		

		Pages.TopNavigation(driver1).PartyMaster(driver1);
		Pages.PartyMaster(driver1).GotoAddParty(driver1);
		RLog("INFO","Navigated to Add Party Screen");
		
		String PartyGenerated_Confirmation_message= 
				Pages.PartyMaster(driver1)
					 .RegisterNewParty(driver1, Partye.HIDDENCUSTOMER);
		RLog("INFO", "After Saved Party Message is : "+PartyGenerated_Confirmation_message);
		
		Pages.PartyMaster(driver1).Goto(driver1);
		RLog("INFO", "PartyMaster.Goto Done " );
		
		String HiddenUpdateMessage =
				Pages.PartyMaster(driver1)
					 .ChangeLastRegisteredPartyStatusAsHidden(driver1, Partye.HIDDENCUSTOMER);
		RLog("INFO", "COMPLETED " +HiddenUpdateMessage);
		
		Assert.assertTrue(
				Pages.PartyMaster(driver1)
				     .InPartyMasterCheckIsPartyCodeStatusAs
				     		(driver1, "Hide",GetCodefromMessage(HiddenUpdateMessage,"PartyMaster")));
		RLog("INFO","Pass");
		
	}
	
	@Test(priority = 12 ,groups = { "Smoke" })
	public void CanCreateMultiAddressParty()
	{
		Pages.TopNavigation(driver1).PartyMaster(driver1);
		Pages.PartyMaster(driver1).GotoAddParty(driver1);
		RLog("INFO","Navigated to Add Party Screen");
		String Party_Confirmation_message=
				Pages.PartyMaster(driver1).RegisterNewParty(driver1,Partye.MULTIADDRESSCUSTOMER);
		
		Assert.assertTrue(
				Pages.PartyMaster(driver1).IsLastGeneratedPartyPresentinPartyMaster
				(driver1,GetCodefromMessage(Party_Confirmation_message,"PartyMaster")));
		RLog("INFO"," Created "+GetCodefromMessage(Party_Confirmation_message,"PartyMaster")+"  Present in Party Master, Test Status : Pass");
	}
	
	
	
	//////////////////////////////PARTY START /////////////////////////////////////
	
	// EFS_QT_AIR_008 // Party code column values will be taken from Party master.
	@Test (priority = 3 , dependsOnMethods = { "CanCreateParty" }, groups = {"FrameWork","Unit"})
	public void IsQuotePartySelectedFromPartyMaster() // EFS_QT_AIR_008
	{
		
		Pages.TopNavigation(driver).Quotation(driver);
		Pages.Quotation(driver).GotoAddQuotation(driver);
		RLog("INFO","Navigated To Add Quotation Screen");
		
		Pages.Quotation(driver).EnterPartyNameinquote(driver,Partye.CUSTOMER);
		RLog("INFO","Entered Party Name "+Auto.PartyBundle.get(Partye.CUSTOMER).partyName);
		
		Assert.assertTrue(
				Pages.Quotation(driver)
				.IsPartyNameAndAddressPresenceinQuote(driver,Partye.CUSTOMER));
		
		RLog("INFO","Result : Pass");
		
	}
	
	
	// EFS_QT_AIR_009 // Without Party Code, system should not allow to save the Quotation.
	@Test (priority = 4, dependsOnMethods = { "CanCreateParty" }, groups = {"Mandatory","Unit"})
	public void IsQuoteRestrictedToSaveWithoutParty() // EFS_QT_AIR_009
	{
		Pages.TopNavigation(driver).Quotation(driver);
		Pages.Quotation(driver).GotoAddQuotation(driver);
		RLog("INFO","Navigated To Add Quotation Screen");
		
		Pages.Quotation(driver).EnterLastgeneratorsInQuoteExcept(driver,Partye.CUSTOMER, "Add_Quote_Party");
		RLog("INFO","With out this "+Auto.PartyBundle.get(Partye.CUSTOMER).partyName +" Party Name Entered all fileds in quotation  ");
		
		Pages.Quotation(driver).SavePage(driver);
		
		String ExpectedMessage="Customer information should be compulsorily Provided.";
		
		String ActualMessage =Pages.Quotation(driver).GetError();
		
		RLog("INFO","Expected Error : "+ExpectedMessage);
		RLog("INFO","Received Error : "+ActualMessage);
		
		Assert.assertEquals(ExpectedMessage, ActualMessage);
		RLog("INFO","Result : Pass");
		
	}
	
	
	// EFS_QT_AIR_010 // When enter invalid Party Code (Invalid means code not available in the Party master)
	@Test(priority = 5, groups = {"Unit"})
	public void IsQuoteRestrictedToSelectInvalidParty()// EFS_QT_AIR_010
	{
		Pages.TopNavigation(driver).Quotation(driver);
		Pages.Quotation(driver).GotoAddQuotation(driver);
		
		String ActualLOVRecord="No Records Found";
		String ReceivedLOVRecord=Pages.Quotation(driver).EnterRandomPartyNameinquote(driver);
		
		RLog("INFO", "ActualLOVRecord : " +ActualLOVRecord);
		RLog("INFO", "ReceivedLOVRecord : " +ReceivedLOVRecord);
		
		//////////////////////////////
		//ReceivedLOVRecord.contains("No Records Found");
		
		String ActualError="Customer information should be compulsorily Provided.";
		String ExpectedError=Pages.Quotation(driver).GetError();
		
		RLog("INFO", "ActualError : " +ActualError);
		RLog("INFO", "ExpectedError : " +ExpectedError);
		
		////////////////////////////////////////////////
		//Assert.assertEquals(ActualError, ExpectedError);
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//////////////////////////////////
		Assert.assertTrue(!Pages.Quotation(driver).IsPartyPresenceinQuote());
		
		RLog("INFO", "Pass");
		
	}

	
	// EFS_QT_AIR_011 // Select/Choose blocked Party Code column, “This Party code blocked in the master” message has come.
	@Test(priority = 6, dependsOnMethods = { "CanCreateBlockedParty" }, groups = { "Smoke" ,"Unit"})
	public void IsQuoteRestrictedToEnterBlockedParty()// EFS_QT_AIR_011
	{
		
		Pages.TopNavigation(driver).Quotation(driver);
		Pages.Quotation(driver).GotoAddQuotation(driver);
		
		Pages.Quotation(driver).EnterPartyNameinquote(driver,Partye.BLOCKEDCUSTOMER);
		
		Pages.Quotation(driver).SavePage(driver);
		
		///////////////////////////////////////////////////////////////
		String Expected="Customer information should be compulsorily Provided.";
		RLog("INFO", "Expected Result : " +Expected);
		
		String Actual=Pages.Quotation(driver).GetError();
		RLog("INFO", "Actual Result : " +Actual);
		
		//Assert.assertEquals(Actual, Expected);
		
		////////////////////////////////////////
		Assert.assertTrue(!Pages.Quotation(driver).IsPartyNameAndAddressPresenceinQuote(driver,Partye.BLOCKEDCUSTOMER));
		
		RLog("INFO", "Party Name And Address not Presend in Quote. Test Status : Pass");
		
	}
	
	
	// EFS_QT_AIR_012 //Enter hidden Party Code column in the  Party Code column field
	@Test(priority = 7, dependsOnMethods = { "CanCreateBlockedParty" }, groups = { "Smoke" ,"Unit"})
	public void IsHiddenPartyDisplayedInQuotePartyLOV()// EFS_QT_AIR_012
	{
		
		Pages.TopNavigation(driver).Quotation(driver);
		Pages.Quotation(driver).GotoAddQuotation(driver);
		
		String ReceivedLOVRecord="No Records Found";
		String ActualLOVRecord=Pages.Quotation(driver).EnterPartyNameinquote(driver,Partye.HIDDENCUSTOMER);
		
		Assert.assertEquals(ReceivedLOVRecord, ActualLOVRecord);
		RLog("INFO", "Pass");
		
	}
	
	
	// EFS_QT_AIR_013 //System should not allow the hidden Party Code column. While enter hidden Party code, following user message should show, “This Party Code hidden in the master”.
	@Test(priority = 8, dependsOnMethods = { "CanCreateHiddenParty" }, groups = { "Smoke"  ,"Unit"})
	public void IsQuoteRestrictedToEnterHiddenParty()// EFS_QT_AIR_013
	{
		Pages.TopNavigation(driver).Quotation(driver);
		Pages.Quotation(driver).GotoAddQuotation(driver);
		
		Pages.Quotation(driver).EnterPartyNameinquote(driver,Partye.HIDDENCUSTOMER);
		
		Pages.Quotation(driver).SavePage(driver);
		
		String Actual="Customer information should be compulsorily Provided.";
		RLog("INFO", "ActualResult : " +Actual);
		
		////////////////////////////////////////////////
		String Expected=Pages.Quotation(driver).GetError();
		RLog("INFO", "ExpectedResult : " +Expected);
		//Assert.assertEquals(Actual, Expected);
		
		///////////////////////////////////
		Assert.assertTrue(!Pages.Quotation(driver).IsPartyNameAndAddressPresenceinQuote(driver,Partye.HIDDENCUSTOMER));
		RLog("INFO", "Pass");
		
	}
	
	
	// EFS_QT_AIR_014 //Create Party button is visible always
	@Test(priority = 9, groups = { "Smoke" ,"Unit"})
	public void IsQuotePartyLOVHavingAddNewOption()// EFS_QT_AIR_014
	{
		Pages.TopNavigation(driver).Quotation(driver);
		Pages.Quotation(driver).GotoAddQuotation(driver);
		
		String ActualFirstLOVText="+ Add New";
		String ExpectedFirstLOVText=Pages.Quotation(driver).GetPartyFirstLOVText();
		
		Assert.assertEquals(ActualFirstLOVText, ExpectedFirstLOVText);
		RLog("INFO","Passs");
		
	}
	
	
	// EFS_QT_AIR_015 //When we click the Create party button, system will navigate to Party master screen 
	@Test(priority = 10, groups = { "Unit" })
	public void CanNavigateToPartyMasterFromQuoteParty()// EFS_QT_AIR_015
	{
		Pages.TopNavigation(driver).Quotation(driver);
		Pages.Quotation(driver).GotoAddQuotation(driver);
		
		Pages.Quotation(driver).ClickPartyFirstLOV();
		
		Assert.assertTrue(Pages.PartyMaster(driver).IsAtAddParty());
		RLog("INFO","After Created Party Via Add New, " 
				+ "When come back Party Fetched to Quote Test Status : Pass");
		
	}
	
	
	// EFS_QT_AIR_016 //After Create the party using Quotation screen, then come back to Quotation screen, created party will show in Party code column.
	@Test(priority = 11, groups = { "Smoke","Unit" })
	public void IsNavigatedAndCreatedPartyCanComeToQuote()// EFS_QT_AIR_016
	{
		Pages.TopNavigation(driver).Quotation(driver);
		Pages.Quotation(driver).GotoAddQuotation(driver);
		
		Pages.Quotation(driver).ClickPartyFirstLOV();
		
		String DummyPartyConfiramtionMessage=
				Pages.PartyMaster(driver).RegisterNewParty(driver,Partye.DUMMY);
		RLog("INFO","Party Confiramtion Message is : "+DummyPartyConfiramtionMessage);
		
		Assert.assertTrue(Pages.Quotation(driver).IsPartyNameAndAddressPresenceinQuote(driver,Partye.DUMMY));
		RLog("INFO","Party Present in Master. Test Status : Pass");
		
	}
	
	// EFS_QT_AIR_017 While Select the Party, Address will come by default.
	@Test(priority = 12, dependsOnMethods = { "CanCreateMultiAddressParty" }, groups = { "Smoke","Unit" })
	public void IsPartyAddressWillComeWhenSelectPartyName()// EFS_QT_AIR_016
	{
		
		Pages.TopNavigation(driver).Quotation(driver);
		Pages.Quotation(driver).GotoAddQuotation(driver);
		
		Pages.Quotation(driver).EnterPartyNameinquote(driver,Partye.MULTIADDRESSCUSTOMER);
		
		Assert.assertTrue(Pages.Quotation(driver).IsPartyPrimaryAddressPresenceinQuote(Partye.MULTIADDRESSCUSTOMER));
		RLog("INFO","Party Address Presence in Quote. Test Status : Pass");
	}
	
	
	// EFS_QT_AIR_018 //Party primary address will come by default while select the party
	@Test(priority = 13, dependsOnMethods = { "CanCreateMultiAddressParty" }, groups = { "Unit" })
	public void CanPrimaryAddressComeByDefaultInQuoteParty()// EFS_QT_AIR_018 
	{
		Pages.TopNavigation(driver).Quotation(driver);
		Pages.Quotation(driver).GotoAddQuotation(driver);
		
		Pages.Quotation(driver).EnterPartyNameinquote
								(driver,Partye.MULTIADDRESSCUSTOMER);

		Assert.assertTrue(Pages.Quotation(driver)
								.IsPartyPrimaryAddressPresenceinQuote
								(Partye.MULTIADDRESSCUSTOMER));
		
		RLog("INFO","Party Present in Master. Test Status : Pass");
	}
	
	
	// EFS_QT_AIR_019 //Address Column system allow to select other/billing/warehouse addresses from party address master for the party.
	@Test(priority = 14, dependsOnMethods = { "CanCreateMultiAddressParty" }, groups = { "Smoke" })//
	public void CanChangeQuotePartyAddress()// EFS_QT_AIR_019
	{
		
		Pages.TopNavigation(driver).Quotation(driver);
		Pages.Quotation(driver).GotoAddQuotation(driver);
		
		Pages.Quotation(driver).EnterPartyNameinquote(driver,Partye.MULTIADDRESSCUSTOMER);
		
		Pages.Quotation(driver).ChangePartyAddressToWareHouse(Partye.MULTIADDRESSCUSTOMER);
		
		Assert.assertTrue(Pages.Quotation(driver)
									.IsPartyWareHoseAddressPresenceinQuote
									(Partye.MULTIADDRESSCUSTOMER));
		RLog("INFO","Party Warehouse address Present in Master. Test Status :Pass");
	}
	
	
	//EFS_QT_AIR_020 //Party address 1 column allow alphanumeric and special characters.
	@Test(priority = 15, groups = { "Unit" })
	public void CanAllowAlphanumericAndSpecialCharactersByQuotePartyAddress1()// EFS_QT_AIR_020
	{
		Pages.TopNavigation(driver).PartyMaster(driver);
		Pages.PartyMaster(driver).GotoAddParty(driver);
		RLog("INFO","Navigated to Add Party Screen");
		Pages.PartyMaster(driver).RegisterNewParty(driver,Partye.DUMMY);
		
		Pages.TopNavigation(driver).Quotation(driver);
		Pages.Quotation(driver).GotoAddQuotation(driver);
		RLog("INFO","Navigated to Add Quote Screen");
		Pages.Quotation(driver).EnterLastgeneratorsInQuote(driver,Partye.DUMMY);
		
		Pages.Quotation(driver).EnterAlphaNumericSpecialCharactersInPartyAddress1Inquote(driver,150);
		Pages.Quotation(driver).SavePage(driver);
		
		String ActualMessage =Pages.Quotation(driver).CheckFinal(driver);
		RLog("INFO","ReceivedMessage is : "+ActualMessage);
		
		
		Assert.assertTrue(
				Pages.Quotation(driver).IsLastGeneratedQuotePresentinQuoteList
				(driver,GetCodefromMessage(ActualMessage,"quotation")));
		
		RLog("INFO","Pass");
	}
	
	
	// EFS_QT_AIR_021 //Party address 1 column allow to enter maximum 100 alphanumeric and special characters.
	@Test(priority = 16, groups = { "Unit" })
	public void QuotePartyAddress1CanAllowonly100AlphanumericAndSpecialCharacters()//EFS_QT_AIR_021
	{
		Pages.TopNavigation(driver).Quotation(driver);
		Pages.Quotation(driver).GotoAddQuotation(driver);
		
		//Pages.Quotation(driver).EnterPartyNameinquote(Partye.MULTIADDRESSCUSTOMER);
		
		Pages.Quotation(driver).EnterAlphaNumericSpecialCharactersInPartyAddress1Inquote(driver,150);
		RLog("INFO","Entered Alphanumeric Special Character Length is 150");
		
		int s=Pages.Quotation(driver).GetQuotePartyAddress1StringLength();
		RLog("INFO","Party Address 1 available Length is :"+s);
		
		Assert.assertTrue(s==100);
		RLog("INFO","Party Address 1 Allowed Alphanumeric Special Character Length is :"+s);
		
	}

	
	// EFS_QT_AIR_022 //Without Party address 1 column not allow to save the record.
	@Test(priority = 17, dependsOnMethods = { "CanCreateMultiAddressParty" }, groups = { "Unit" })
	public void IsQuoteRestrictedToSaveWithoutPartyAddress1Address()//EFS_QT_AIR_022
	{
		Pages.TopNavigation(driver).Quotation(driver);
		Pages.Quotation(driver).GotoAddQuotation(driver);
		
		Pages.Quotation(driver).EnterLastgeneratorsInQuoteExcept(driver,Partye.MULTIADDRESSCUSTOMER, "Add_Quote_Party_Address1");
		
		Pages.Quotation(driver).SavePage(driver);
		
		String ActualMessage="Customer address line-1 should be compulsorily Provided.";
		RLog("INFO","ActualMessage is :  "+ActualMessage);
		
		String ReceivedMessage =Pages.Quotation(driver).CheckFinal(driver);
		RLog("INFO","ReceivedMessage is : "+ReceivedMessage);
		
		Assert.assertEquals(ActualMessage, ReceivedMessage);
	}
	
	
	//EFS_QT_AIR_023 //Party address 2 column allow alphanumeric and special characters.
	@Test(priority = 18, groups = { "Unit" })
	public void CanAllowAlphanumericAndSpecialCharactersByQuotePartyAddress2()// EFS_QT_AIR_023
	{
		Pages.TopNavigation(driver).PartyMaster(driver);
		Pages.PartyMaster(driver).GotoAddParty(driver);
		Pages.PartyMaster(driver).RegisterNewParty(driver,Partye.DUMMY);
		
		Pages.TopNavigation(driver).Quotation(driver);
		Pages.Quotation(driver).GotoAddQuotation(driver);
		
		Pages.Quotation(driver).EnterLastgeneratorsInQuote(driver,Partye.DUMMY);
		
		Pages.Quotation(driver).EnterAlphaNumericSpecialCharactersInPartyAddress2Inquote(driver,150);
		Pages.Quotation(driver).SavePage(driver);
		
		String ActualMessage =Pages.Quotation(driver).CheckFinal(driver);
		RLog("INFO","ReceivedMessage is : "+ActualMessage);
		
		
		Assert.assertTrue(
				Pages.Quotation(driver).IsLastGeneratedQuotePresentinQuoteList
				(driver,GetCodefromMessage(ActualMessage,"quotation")));
		
		RLog("INFO","Pass");
		
	}
	
	
	//EFS_QT_AIR_024 //Party address 2 column allow to enter maximum 100 alphanumeric and special characters.
	@Test(priority = 19, groups = { "Unit" })
	public void QuotePartyAddress2CanAllowonly100AlphanumericAndSpecialCharacters()// EFS_QT_AIR_024
	{
		Pages.TopNavigation(driver).Quotation(driver);
		Pages.Quotation(driver).GotoAddQuotation(driver);
		
		//Pages.Quotation(driver).EnterPartyNameinquote(Partye.MULTIADDRESSCUSTOMER);
		
		Pages.Quotation(driver).EnterAlphaNumericSpecialCharactersInPartyAddress2Inquote(driver,150);
		RLog("INFO","Entered Alphanumeric Special Character Length is 150");
		
		int s=Pages.Quotation(driver).GetQuotePartyAddress2StringLength();
		RLog("INFO","Party Address 1 available Length is :"+s);
		
		Assert.assertTrue(s==100);
		RLog("INFO","Party Address 2 Allowed Alphanumeric Special Character Length is :"+s);
		
	}
	
	
	//EFS_QT_AIR_025 //Without Party address 2 column not allow to save the record.
	@Test(priority = 20, dependsOnMethods = { "CanCreateMultiAddressParty" }, groups = { "Unit" })
	public void IsQuoteRestrictedToSaveWithoutPartyAddress2Address()// EFS_QT_AIR_025
	{
		Pages.TopNavigation(driver).Quotation(driver);
		Pages.Quotation(driver).GotoAddQuotation(driver);
		
		Pages.Quotation(driver).EnterLastgeneratorsInQuoteExcept(driver,Partye.MULTIADDRESSCUSTOMER, "Add_Quote_Party_Address2");
		
		Pages.Quotation(driver).SavePage(driver);
		
		String ReceivedMessage="Customer address line-2 should be compulsorily Provided.";
		RLog("INFO","Expected Message is :  "+ReceivedMessage);
		
		String ActualMessage =Pages.Quotation(driver).CheckFinal(driver);
		RLog("INFO","Actual Received Message is : "+ActualMessage);
		
		Assert.assertEquals(ActualMessage, ReceivedMessage);
	}
	
	
	//EFS_QT_AIR_026 //Party address 3 column allow alphanumeric and special characters.
	@Test(priority = 21, groups = { "Unit" })
	public void CanAllowAlphanumericAndSpecialCharactersByQuotePartyAddress3()// EFS_QT_AIR_026
	{
		Pages.TopNavigation(driver).PartyMaster(driver);
		Pages.PartyMaster(driver).GotoAddParty(driver);
		RLog("INFO","Navigated to Add Party Screen");
		Pages.PartyMaster(driver).RegisterNewParty(driver,Partye.DUMMY);
		
		Pages.TopNavigation(driver).Quotation(driver);
		Pages.Quotation(driver).GotoAddQuotation(driver);
		Pages.Quotation(driver).EnterLastgeneratorsInQuote(driver,Partye.DUMMY);
		
		Pages.Quotation(driver).EnterAlphaNumericSpecialCharactersInPartyAddress3Inquote(driver,150);
		Pages.Quotation(driver).SavePage(driver);
		
		String ActualMessage =Pages.Quotation(driver).CheckFinal(driver);
		RLog("INFO","ReceivedMessage is : "+ActualMessage);
		
		
		Assert.assertTrue(
				Pages.Quotation(driver).IsLastGeneratedQuotePresentinQuoteList
				(driver,GetCodefromMessage(ActualMessage,"quotation")));
		
		RLog("INFO","Pass");
		
	}
	
	
	//EFS_QT_AIR_027 //Party address 3 column allow to enter maximum 100 alphanumeric and special characters.
	@Test(priority = 22, groups = { "Unit" })
	public void QuotePartyAddress3CanAllowonly100AlphanumericAndSpecialCharacters()// EFS_QT_AIR_027
	{
		Pages.TopNavigation(driver).Quotation(driver);
		Pages.Quotation(driver).GotoAddQuotation(driver);
		Pages.Quotation(driver).EnterAlphaNumericSpecialCharactersInPartyAddress3Inquote(driver,150);
		RLog("INFO","Entered Alphanumeric Special Character Length is 150");
		
		Pages.Quotation(driver).SavePage(driver);
		
		int s=Pages.Quotation(driver).GetQuotePartyAddress3StringLength();
		RLog("INFO","Party Address 3 available Length is :"+s);
		
		Assert.assertTrue(s==100);
		RLog("INFO","Party Address 3 Allowed Alphanumeric Special Character Length is :"+s);
		
	}
	
	
	//EFS_QT_AIR_028 //Without Party address 3 column allow to save the record.
	@Test(priority = 23, groups = { "Unit" })
	public void CanQuoteAllowtoSaveWithOutPartyAddress3Address()// EFS_QT_AIR_028
	{
		Pages.TopNavigation(driver).PartyMaster(driver);
		Pages.PartyMaster(driver).GotoAddParty(driver);
		Pages.PartyMaster(driver).RegisterNewParty(driver,Partye.DUMMY);
		
		Pages.TopNavigation(driver).Quotation(driver);
		Pages.Quotation(driver).GotoAddQuotation(driver);
		Pages.Quotation(driver).EnterLastgeneratorsInQuoteExcept(driver,Partye.DUMMY, "Add_Quote_Party_Address3");
		Pages.Quotation(driver).SavePage(driver);
		
		String ActualMessage =Pages.Quotation(driver).CheckFinal(driver);
		RLog("INFO","ReceivedMessage is : "+ActualMessage);
		
		
		Assert.assertTrue(
				Pages.Quotation(driver).IsLastGeneratedQuotePresentinQuoteList
				(driver,GetCodefromMessage(ActualMessage,"quotation")));
		
		RLog("INFO","Pass");

	}
	
	
	//////////////////////////PARTY   END/////////////////////////////////////
	
	//EFS_QT_AIR_029 to EFS_QT_AIR_038 // Employee Master
	
	///////////////////////////////ATTENDITION STARTED //////////////////////////////////
	
	
	//*EFS_QT_AIR_039 Attention column values will be taken from Party master. 
	//*EFS_QT_AIR_041 Attention Column should allow to change. If Quotation is not converted to Booking.
	//EFS_QT_AIR_047 Attention column should not allow Non printable values, leading space values.
	//EFS_QT_AIR_044 wrong 
	
	
	//EFS_QT_AIR_040 // Without  Attention, system should allow to save the Quotation Air.
	@Test(priority = 24, groups = { "Unit" })
	public void CanQuoteAllowtoSaveWithOutAttention()// EFS_QT_AIR_040
	{
		Pages.TopNavigation(driver).PartyMaster(driver);
		Pages.PartyMaster(driver).GotoAddParty(driver);
		Pages.PartyMaster(driver).RegisterNewParty(driver,Partye.DUMMY);
		
		Pages.TopNavigation(driver).Quotation(driver);
		Pages.Quotation(driver).GotoAddQuotation(driver);
		Pages.Quotation(driver).EnterLastgeneratorsInQuoteExcept(driver,Partye.DUMMY, "Add_Quote_Attention");
		
		Pages.Quotation(driver).SavePage(driver);
		
		String ActualMessage =Pages.Quotation(driver).CheckFinal(driver);
		RLog("INFO","ReceivedMessage is : "+ActualMessage);
		
		
		Assert.assertTrue(
				Pages.Quotation(driver).IsLastGeneratedQuotePresentinQuoteList
				(driver,GetCodefromMessage(ActualMessage,"quotation")));
		
		RLog("INFO","Pass");
	}
	
	//EFS_QT_AIR_042 // Attention column should come automatically when we select the Party. If party code have Contact Person, mapped in party master.
	@Test(priority = 25, dependsOnMethods = { "CanCreateParty" }, groups = { "Unit" })
	public void CanQuoteAttentionComeFromPartyMasterAddressContactName()// EFS_QT_AIR_042
	{
		Pages.TopNavigation(driver).Quotation(driver);
		Pages.Quotation(driver).GotoAddQuotation(driver);
		Pages.Quotation(driver).EnterPartyNameinquote(driver,Partye.CUSTOMER);
		
		Assert.assertTrue(Pages.Quotation(driver).IsPartyAttentionPresenceinQuote(Partye.CUSTOMER));
		RLog("INFO","Pass");
	}
	
	//EFS_QT_AIR_043 // Enter Alphanumeric values in Attention column 
	@Test(priority = 26, dependsOnMethods = { "CanCreateParty" }, groups = { "Unit" })
	public void CanAllowAlphanumericCharactersByQuotePartyAttention()// EFS_QT_AIR_043
	{
		Pages.TopNavigation(driver).Quotation(driver);
		Pages.Quotation(driver).GotoAddQuotation(driver);
		Pages.Quotation(driver).EnterLastgeneratorsInQuoteExcept(driver,Partye.CUSTOMER, "Add_Quote_Attention");
		
		Pages.Quotation(driver).EnterAlphaCharactersInquotePartyAttention(driver,100);
		Pages.Quotation(driver).SavePage(driver);
		
		String ActualMessage =Pages.Quotation(driver).CheckFinal(driver);
		RLog("INFO","ReceivedMessage is : "+ActualMessage);
		
		
		Assert.assertTrue(
				Pages.Quotation(driver).IsLastGeneratedQuotePresentinQuoteList
				(driver,GetCodefromMessage(ActualMessage,"quotation")));
		
		RLog("INFO","Pass");
	}
	
	//EFS_QT_AIR_045 // Attention column allows maximum 100 characters
	@Test(priority = 27, groups = { "Unit" })
	public void QuoteAttentionCanAllowonly100AlphaCharacters()// EFS_QT_AIR_045
	{
		Pages.TopNavigation(driver).Quotation(driver);
		Pages.Quotation(driver).GotoAddQuotation(driver);
		
		//Pages.Quotation(driver).EnterPartyNameinquote(Partye.MULTIADDRESSCUSTOMER);
		
		Pages.Quotation(driver).EnterAlphaCharactersInquotePartyAttention(driver,150);
		RLog("INFO","Entered Alpha Character Length is 150");
		
		int s=Pages.Quotation(driver).GetQuoteAttentionStringLength();
		RLog("INFO","Party Attention available Length is :"+s);
		
		Assert.assertTrue(s==100);
		RLog("INFO","Party Attention Allowed Alphanumeric Special Character Length is :"+s);
	}
	
	//EFS_QT_AIR_046 // Attention column allow to enter less than 100 characters.
	@Test(priority = 27, groups = { "Unit" })
	public void QuoteAttentionCanAllowLessThan100AlphaCharacters()//EFS_QT_AIR_046
	{
		Pages.TopNavigation(driver).PartyMaster(driver);
		Pages.PartyMaster(driver).GotoAddParty(driver);
		Pages.PartyMaster(driver).RegisterNewParty(driver,Partye.DUMMY);
		
		Pages.TopNavigation(driver).Quotation(driver);
		Pages.Quotation(driver).GotoAddQuotation(driver);
		Pages.Quotation(driver).EnterLastgeneratorsInQuoteExcept(driver,Partye.DUMMY,"Add_Quote_Attention");
		
		Pages.Quotation(driver).EnterAlphaCharactersInquotePartyAttention(driver,50);
		RLog("INFO","Entered Alpha Character Length is 50");
		
		Pages.Quotation(driver).SavePage(driver);
		
		String ActualMessage =Pages.Quotation(driver).CheckFinal(driver);
		RLog("INFO","ReceivedMessage is : "+ActualMessage);
		
		
		//////////////////////////////////////////////////////////////////
		// nEED TO CHECK THE EDIT SCREEN aTTENTION HAVING 50 CHAR SIZE  
		Assert.assertTrue(
				Pages.Quotation(driver).IsLastGeneratedQuotePresentinQuoteList
				(driver,GetCodefromMessage(ActualMessage,"quotation")));
		
		RLog("INFO","Pass");
	}
	
	//EFS_QT_AIR_048 // Same Attention name should allow to create more than once for different Party.
	@Test(priority = 28, groups = { "Unit" })
	public void QuoteAttentionCanAllowSameNameAgainAndAgain()// EFS_QT_AIR_048
	{
		Pages.TopNavigation(driver).PartyMaster(driver);
		Pages.PartyMaster(driver).GotoAddParty(driver);
		Pages.PartyMaster(driver).RegisterNewParty(driver,Partye.DUMMY);
		
		Pages.TopNavigation(driver).PartyMaster(driver);
		Pages.PartyMaster(driver).GotoAddParty(driver);
		Pages.PartyMaster(driver).RegisterNewParty(driver,Partye.DUMMY1);
		
		Pages.TopNavigation(driver).Quotation(driver);
		Pages.Quotation(driver).GotoAddQuotation(driver);
		Pages.Quotation(driver).EnterLastgeneratorsInQuoteExcept(driver,Partye.DUMMY, "Add_Quote_Attention");
		Pages.Quotation(driver).EnterLastGeneratedPartyAttentionInquote(driver,Partye.DUMMY);
		Pages.Quotation(driver).SavePage(driver);
		String ActualFirstMessage =Pages.Quotation(driver).CheckFinal(driver);
		RLog("INFO","ReceivedMessage is : "+ActualFirstMessage);
		Pages.Quotation(driver).IsLastGeneratedQuotePresentinQuoteList(driver,GetCodefromMessage(ActualFirstMessage,"quotation"));
		
		Pages.TopNavigation(driver).Quotation(driver);
		Pages.Quotation(driver).GotoAddQuotation(driver);
		Pages.Quotation(driver).EnterLastgeneratorsInQuoteExcept(driver,Partye.DUMMY1, "Add_Quote_Attention");
		Pages.Quotation(driver).EnterLastGeneratedPartyAttentionInquote(driver,Partye.DUMMY);
		Pages.Quotation(driver).SavePage(driver);
		String ActualsecondMessage =Pages.Quotation(driver).CheckFinal(driver);
		RLog("INFO","ReceivedMessage is : "+ActualsecondMessage);
		
		Assert.assertTrue(
				Pages.Quotation(driver).IsLastGeneratedQuotePresentinQuoteList
				(driver,GetCodefromMessage(ActualsecondMessage,"quotation")));
		
		RLog("INFO","Same Attention Used in 2 Quote and saved successfully. Test Status : Pass ");
		
	}

	
	/////////////////////////////////ATTENDITION END/////////////////////////////////////

	/////////////////////////////////VALID FROM DATE STARTED/////////////////////////////////////
	
	 //EFS_QT_AIR_049

	
	
	
	
	
	
	//EFS_QT_AIR_054
	/////////////////////////////////VALID FROM DATE END/////////////////////////////////////	
	
	/////////////////////////////////VALID TO DATE STARTED/////////////////////////////////////
	//EFS_QT_AIR_055

	
	
	
	
	
	 //EFS_QT_AIR_060
	/////////////////////////////////VALID TO DATE END/////////////////////////////////////
	
	//EFS_QT_AIR_061
	
	/////////////////////////////////ORIGIN STARTED /////////////////////////////////////
	//EFS_QT_AIR_062

	
	//EFS_QT_AIR_068	
	/////////////////////////////////ORIGIN END /////////////////////////////////////
	
	/////////////////////////////////DESTINATION  STARTED /////////////////////////////////////
	//EFS_QT_AIR_069
	
	
	//EFS_QT_AIR_076	
	/////////////////////////////////ORIGIN END /////////////////////////////////////

	/////////////////////////////////SHIPPER STARTED /////////////////////////////////////
	//EFS_QT_AIR_077
	
	//EFS_QT_AIR_097
	/////////////////////////////////SHIPPER END /////////////////////////////////////
	
	/////////////////////////////////SALES COORDINATOR STARTED /////////////////////////////////////
	
	
	
	/////////////////////////////////SALES COORDINATOR ENDED /////////////////////////////////////
	
	
	
	/////////////////////////////////CARRIER STARTED /////////////////////////////////////
	// EFS_QT_AIR_105

	//tO
	//EFS_QT_AIR_111
	/////////////////////////////////CARRIER ENDED /////////////////////////////////////
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Test(enabled = false, groups = { "Smoke" },priority = 20, dependsOnMethods = { "CanCreateParty" })
	public void CanCreateQuote()
	{
		Pages.TopNavigation(driver).Quotation(driver);
		Pages.Quotation(driver).GotoAddQuotation(driver);
		RLog("INFO", "Go to Add Quotatio done");
		
		String Quotenumber=Pages.Quotation(driver).createQuotAsLastGeneratedParty(driver,Partye.CUSTOMER);
		

		
//		Assert.assertTrue(Pages.Quotation(driver).IsQuotCreated(Quotenumber));
		//Expires on date should be greater than or equal to logged on date
		//Volume weight is invalid
	}

	
}
