package MasterGenerators;

import java.util.Random;

public class RandomGetData 
{
//	public String generateRandomString(int length)
//	{
////		Random randomGenerator = new Random();
////		 String randomInt = randomGenerator.nextInt(length);
////		return RandomStringUtils.randomAlphabetic(length);
//	}
		 
	 public static String generateRandomNumber(int length)
	 {
		 String n = null;
		 Random randomGenerator = new Random();
		 int randomInt = randomGenerator.nextInt(length);
		 
		 n=(""+randomInt);
		 return n;
	 }
	 
	 public static String generateRandomAlphaNumeric(int length)
	 {
		 final Random r = new Random();
		 final char[] choices = ("abcdefghijklmnopqrstuvwxyz" +"0123456789" ).toCharArray();
		 
		 StringBuilder salt = new StringBuilder(length);
		 
		 for (int i = 0; i<length; ++i)
		 {
			 salt.append(choices[r.nextInt(choices.length)]);
		 }
		 return salt.toString();
	 }
	 
	 public static String generateRandomAlpha(int length)
	 {
		 final Random r = new Random();
		 final char[] choices = ("abcdefghijklmnopqrstuvwxyz" +"ABCDEFGHIJKLMNOPQRSTUVWXYZ" ).toCharArray();
		 
		 StringBuilder salt = new StringBuilder(length);
		 
		 for (int i = 0; i<length; ++i)
		 {
			 salt.append(choices[r.nextInt(choices.length)]);
		 }
		 return salt.toString();
	 }
	 
	 public static String generateRandomEmailId(int EnterMinimumlength11)
	 {
		 String NewEmail=generateRandomAlphaNumeric(EnterMinimumlength11-10)+"@gmail.com";
		 
		 return NewEmail;
	 }
	 
	 public static String generateRandomAlphaNumericSpecial(int length)
	 {
		 final Random r = new Random();
		 final char[] choices = ("abcdefghijklmnopqrstuvwxyz" +
			      "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
			      "0123456789" +
			      "!@#$%^&*()_+{}[];:'?/><-~").toCharArray();
		 
		 StringBuilder salt = new StringBuilder(length);
		 
		 for (int i = 0; i<length; ++i)
		 {
			 salt.append(choices[r.nextInt(choices.length)]);
		 }
			 
		 return salt.toString();
		 
//		 
//		 final String alphabet = "!@#$%^&*()_+{}[];:'?/><-~";
//		 final int N = alphabet.length();
//		 System.out.println("N"+N);
//		 
//		 final String numeric=""
//		 
//		 Random randomGenerator = new Random();
//		 //int iLength = <length you want>;
//		 
//		 StringBuilder sb = new StringBuilder(length);
//		 for (int i = 0; i < length; i++) {
//		     sb.append(alphabet.charAt(randomGenerator.nextInt(N)));
//		 }
//		 String AlphaNumericSpecial=sb.toString();
//		 
//		 System.out.println("AlphaNumericSpecial"+AlphaNumericSpecial);
//		 //RandomStringUtils.randomAlphanumeric(length);
//		 
		 //return AlphaNumericSpecial;
		 
	 }
//	 
//	 public String generateStringWithAllobedSplChars(int length,String allowdSplChrs)
//	 {
//	  String allowedChars="abcdefghijklmnopqrstuvwxyz" +   //alphabets
//	    "1234567890" +   //numbers
//	    allowdSplChrs;
//	  return RandomStringUtils.random(length, allowedChars);
//	 }
//	 
//	 public String generateEmail(int length) 
//	 {
//	  String allowedChars="abcdefghijklmnopqrstuvwxyz" +   //alphabets
//	    "1234567890" +   //numbers
//	    "_-.";   //special characters
	 
//	  String email="";
//	  String temp=RandomStringUtils.random(length,allowedChars);
//	  email=temp.substring(0,temp.length()-9)+"@test.org";
//	  return email;
//	 }
//	 
//	 public String generateUrl(int length) 
//	 {
//	  String allowedChars="abcdefghijklmnopqrstuvwxyz" +   //alphabets
//	    "1234567890" +   //numbers
//	    "_-.";   //special characters
//	  String url="";
//	  String temp=RandomStringUtils.random(length,allowedChars);
//	  url=temp.substring(0,3)+"."+temp.substring(4,temp.length()-4)+"."+temp.substring(temp.length()-3);
//	  return url;
//	 }
//	}

}
