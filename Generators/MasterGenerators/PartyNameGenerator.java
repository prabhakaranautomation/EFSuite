package MasterGenerators;

import java.util.UUID;

public class PartyNameGenerator
{
	public static String generate()
	{
		String arr[]=UUID.randomUUID().toString().split("-");
		String name=("Zd"+arr[0]+" PVT LTD");
		return name;
	}
	
	
}
