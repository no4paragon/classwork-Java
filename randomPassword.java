import java.security.SecureRandom;

public class randomPassword
{
    private static SecureRandom random = new SecureRandom();
    private static final String letters = "abcdefghijklmnopqrstuvwxyz";
    private static final String num = "0123456789";
    private static final String spChar = "*&$#";
    private static final String woNum = "abcdefghijklmnopqrstuvwxyz*&$#";

    public static void getProbability()
    {
        int allLetters = num.length() + letters.length() + spChar.length();
        double probability = num.length();
        for(int i = 0; i < 7; i++)
        {
          probability *= allLetters;
        }
        System.out.println(probability);
    }   
       
    public static String generatePass(int length, String str)
    {
        String result = "";
        for (int i = 0; i < length; i++) {
    	    int index = random.nextInt(str.length());
    	    result += str.charAt(index);
	    }
	    return result;
    }
    
	public static void main(String[] args)
	{
        System.out.println("Compute the number of passwords that satisfy the given constraints.");
    	getProbability();
    	System.out.println();
    	
    	String rest = generatePass(7, woNum);
    	String first = generatePass(1, num);
    	String password =  first + rest;
    	System.out.println("Password");
    	System.out.println(password);
	}
}
