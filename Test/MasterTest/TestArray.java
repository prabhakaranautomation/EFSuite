package MasterTest;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Master.Pages;
import MasterGenerators.Auto.Partye;
import testUtills.TestNGListerner2;

@Listeners(TestNGListerner2.class)
public class TestArray extends Testbase
{
	@Test
	public void arraylisttest()
	{
		Pages.TopNavigation(driver1).PartyMaster(driver1);
		Pages.PartyMaster(driver1).GotoAddParty(driver1);
		
		Pages.PartyMaster(driver1).RegisterNewParty(driver1,Partye.CUSTOMER);
		
		try 
		{
			Thread.sleep(15000);
		} 
		catch (InterruptedException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		
//		Pages.PartyMaster(driver).SavePage();
//		
//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		boolean s=Pages.PartyMaster(driver).isErrorPresent();
//		
//		SendTestAlertMessageAs("accc"+s);
//		
//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
////		
//		String Partydetails =Pages.PartyMaster(driver).RegisterNewParty(Partye.MULTIADDRESSCUSTOMER);
//		RLog("INFO", "Message is : "+Partydetails);
//
//		Pages.TopNavigation(driver).Quotation();
//		Pages.Quotation(driver).GotoAddQuotation();
//		Pages.Quotation(driver).EnterLastgeneratorsInQuoteExcept(Partye.MULTIADDRESSCUSTOMER, "Add_Quote_Attention");
//		
//		Pages.Quotation(driver).EnterAlphaCharactersInquotePartyAttention(100);
//		Pages.Quotation(driver).SavePage();
//		
//		String ActualMessage =Pages.Quotation(driver).CheckFinal();
//		RLog("INFO","ReceivedMessage is : "+ActualMessage);
//		
//		
//		Assert.assertTrue(
//				Pages.Quotation(driver).IsLastGeneratedQuotePresentinQuoteList
//				(GetCodefromMessage(ActualMessage,"quotation")));
//		
//		RLog("INFO","Pass");
//		
	}

}
