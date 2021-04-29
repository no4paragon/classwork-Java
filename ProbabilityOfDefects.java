import java.math.BigInteger;

public class ProbabilityOfDefects{
    
    static BigInteger fact(int n)
    {
        BigInteger res = BigInteger.valueOf(1);
        for (int i = 2; i <= n; i++)
            res = res.multiply(BigInteger.valueOf(i));
        return res;
    }
    
    static BigInteger nCr(int n, int r){
        return fact(n).divide(fact(r).multiply(fact(n-r)));
    }
 
    static double calc(int defects){
        int make = 100;
        return Math.pow(0.99, make - defects) * Math.pow(0.01, defects);
    }
    
	public static void main(String[] args) {
	    
	    //What is the probability that out of 100 circuit boards made exactly 0 have defects?
	    double case1 = calc(0);
	   
	    //What is the probability that out of 100 circuit boards made exactly 1 have defects?
	    long second = nCr(100,1).longValue();
	    double case2 = second * calc(1);

	    //What is the probability that out of 100 circuit boards made exactly 2 have defects?
	    long third = nCr(100,2).longValue();
	    double case3 = third * calc(2);
	   
	    //What is the probability that out of 100 circuit boards made at least 3 have defects?
	    long fourth = nCr(100,3).longValue();
	    double case4 = 1 - case1 - case2 - case3;
	    
        System.out.println("There is a probability of " + String.format("%.5f", case1) + " to have 0 defects in 100 circuit boards.");
        System.out.println("There is a probability of " + String.format("%.5f", case2) + " to have 1 defects in 100 circuit boards.");
        System.out.println("There is a probability of " + String.format("%.5f", case3) + " to have 2 defects in 100 circuit boards.");
        System.out.println("There is a probability of " + String.format("%.5f", case4) + " to have 3 or more defects in 100 circuit boards.");
	
	}
}
