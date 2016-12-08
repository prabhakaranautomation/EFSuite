package MasterGenerators;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import MasterGenerators.Auto.Partye;
import testUtills.Utills;

public class Auto extends Utills
{
	
	public static enum Partye {DUMMY, DUMMY1, MULTIADDRESSCUSTOMER, HIDDENCUSTOMER, BLOCKEDCUSTOMER, CUSTOMER, SHIPPER, CONSIGNEE, FORWARDER, FIRSTNOTIFY, SECONDNOTIFY};
	
	public static enum PartyAddresse {PRIMARY, BILLING, WAREHOUSE, OTHER};
	
	//public static HashMap<Partye, Party> PartyBundle;
	
    public static void initialize() 
    {
        //PartyBundle = new HashMap<String, Party>();
    	
    }
    
    public static Party GenerateParty(WebDriver driver, Partye customerType) 
    {
    	Party party = new Party();
    	
    	party.setHolderName(customerType);
        party.setPartyCode("DUMMYCODE");
        
        party.setPartyName(PartyNameGenerator.generate());//AAD ENTERPRISES
        
        party.setPartyType(PartyAddresse.PRIMARY);
        
        party.setPartyAddress1("Primary Address Chennai1");
        party.setPartyAddress2("Primary Address Chennai2");
        party.setPartyAddress3("Primary Address Chennai3");
        party.setPartyAddress4("Primary Address Chennai4");
        party.setPartyAddressZipCode("Primary Address ZipCode");
        party.setPartyAddressCity("Primary Address City");
        party.setPartyAddressState("Primary Address State");
        party.setPartyAddressContactName("Primary Address ContactName");
        party.setPartyAddressMailId("Primary"+RandomGetData.generateRandomEmailId(25));
        party.setPartyAddressPhoneNo(RandomGetData.generateRandomNumber(1000000000));
        party.setPartyAddressMobileNo(RandomGetData.generateRandomNumber(1000000000));
        party.setPartyAddressFaxNo(RandomGetData.generateRandomNumber(1000000000));
        party.setPartyAddressPickupHours("Primary Address PickupHours");
        
        party.setPartyWareHouseAddress1("WareHouse Address Line1");
        party.setPartyWareHouseAddress2("WareHouse Address Line2");
        party.setPartyWareHouseAddress3("WareHouse Address Line3");
        party.setPartyWareHouseAddress4("WareHouse Address Line4");
        party.setPartyWareHouseAddressZipCode("WareHouse Address ZipCode");
        party.setPartyWareHouseAddressCity("WareHouse Address City");
        party.setPartyWareHouseAddressState("WareHouse Address State");
        party.setPartyWareHouseAddressContactName("WareHouse Address ContactName");
        party.setPartyWareHouseAddressMailId("WareHouse"+RandomGetData.generateRandomEmailId(25));
        party.setPartyWareHouseAddressPhoneNo(RandomGetData.generateRandomNumber(1000000000));
        party.setPartyWareHouseAddressMobileNo(RandomGetData.generateRandomNumber(1000000000));
        party.setPartyWareHouseAddressFaxNo(RandomGetData.generateRandomNumber(1000000000));
        party.setPartyWareHouseAddressPickupHours("WareHouse Address PickupHours");
        
        party.setPartyBillingAddress1("Billing Address Line1");
        party.setPartyBillingAddress2("Billing Address Line2");
        party.setPartyBillingAddress3("Billing Address Line3");
        party.setPartyBillingAddress4("Billing Address Line4");
        party.setPartyBillingAddressZipCode("Billing Address ZipCode");
        party.setPartyBillingAddressCity("Billing Address City");
        party.setPartyBillingAddressState("Billing Address State");
        party.setPartyBillingAddressContactName("Billing Address ContactName");
        party.setPartyBillingAddressMailId("Billing"+RandomGetData.generateRandomEmailId(25));
        party.setPartyBillingAddressPhoneNo(RandomGetData.generateRandomNumber(1000000000));
        party.setPartyBillingAddressMobileNo(RandomGetData.generateRandomNumber(1000000000));
        party.setPartyBillingAddressFaxNo(RandomGetData.generateRandomNumber(1000000000));
        party.setPartyBillingAddressPickupHours("Billing Address PickupHours");
        
        party.setPartyOtherAddress1("Other Address Line1");
        party.setPartyOtherAddress2("Other Address Line2");
        party.setPartyOtherAddress3("Other Address Line3");
        party.setPartyOtherAddress4("Other Address Line4");
        party.setPartyOtherAddressZipCode("Other Address ZipCode");
        party.setPartyOtherAddressCity("Other Address City");
        party.setPartyOtherAddressState("Other Address State");
        party.setPartyOtherAddressContactName("Other Address ContactName");
        party.setPartyOtherAddressMailId("Other"+RandomGetData.generateRandomEmailId(25));
        party.setPartyOtherAddressPhoneNo(RandomGetData.generateRandomNumber(1000000000));
        party.setPartyOtherAddressMobileNo(RandomGetData.generateRandomNumber(1000000000));
        party.setPartyOtherAddressFaxNo(RandomGetData.generateRandomNumber(1000000000));
        party.setPartyOtherAddressPickupHours("Other Address PickupHours");
        
        
        
        party.setShipperName(RandomGetData.generateRandomNumber(10000));//"Shanmuganathan1"
        party.setShipperAddress1("Chennai");
        
        
        
        party.setValidFrom("10-08-2016");
        party.setExpiresOn("11-09-2016");
        
        party.setSalesCoordinator("CMani");
        
        party.setOrigin("Mumbai");
        party.setDestination("Dubai");
       
        party.setTermOfShipment("Ex Works");
        
//        party.setGrossWeight(RandomGetData.generateRandomNumber(10000));
//        party.setVolumeWeight(RandomGetData.generateRandomNumber(10000));
        
        
//        ////////////////////////////////////
         // Map<Partye, Party> objMap = new HashMap<Partye, Party>();
        
          
        
        
//        ArrayList<Party> d=new ArrayList<Party>();
//        
//        //d.add(0,"SHIPPER");
//        
//        ArrayList<Object> d1=new ArrayList<Object>();
//        System.out.println("1");
//        d1.add(0,Partye.SHIPPER);
//        d1.add(1,party);
//        System.out.println("2");
//        
//        LastGeneratedPartys1.add((LastGeneratedPartys1.size()), d1);
//        
//        System.out.println("3"+LastGeneratedPartys1.get(0).get(0).toString());
//        
//        LastGeneratedPartyBundle.add(party);
//        
//        //LastGenerated.SHIPPER=party;  
//        ///////////////////////////////////////////////////
        
        //LastGeneratedPartyBundle.add
        //LastGeneratedParty=party;
       
        System.out.println("BUN1  :"+Lastgenerator(driver,customerType));
        
        PartyBundle.put(Lastgenerator(driver,customerType), party);//customer
        System.out.println("BUN 2 ");
        return party;
    }
    
}
