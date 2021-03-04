import java.util.Scanner;
import java.util.ArrayList;

public class Main
{
    
    static void fistFunction() {
        
        int first[];  
        first = new int[100];
        boolean isInjective = true;
        
    	for(int i = 0; i < first.length; i++){
    	    first[i] = 3 * (i + 1);
    	}
    	
    	for (int i = 0; i < first.length; i++) { 
    	    for (int j = i + 1; j < first.length; j++) { 
    	        if (first[i] == first[j]) { 
    	           
    	            isInjective = false;
    	        }
    	    } 
    	}
    	
    	if(isInjective == false){
    	    System.out.println("This function is NOT injective!!");
    	}else{
    	    System.out.println("This function is injective!!");
    	}
    	
    }

	static void secondFunction() {
	    
		int second[];  
        second = new int[100];
        boolean isInjective = true;
        
    	for(int i = 0; i < second.length; i++){
    	    second[i] = (i + 1) * (i + 1);
    	}
    	
    	for (int i = 0; i < second.length; i++) { 
    	    for (int j = i + 1; j < second.length; j++) { 
    	        if (second[i] == second[j]) { 
    	            isInjective = false;
    	        }
    	    } 
    	}
    	
    	if(isInjective == false){
    	    System.out.println("This function is NOT injective!!"); 
    	}else{
    	    System.out.println("This function is injective!!"); 
    	}
	}

    static void thirdFunction() {
        
    	int third[];  
        third = new int[100];
        boolean isInjective = true;
        
    	for(int i = 0; i < third.length; i++){
    	    third[i] = (2*i) - 2 ;
    	}
    	
    	for (int i = 0; i < third.length; i++) { 
    	    for (int j = i + 1; j < third.length; j++) { 
    	        if (third[i] == third[j]) { 
    	            isInjective = false;
    	        }
    	    } 
    	}
    	
    	if(isInjective == false){
    	    System.out.println("This function is NOT injective!!");
    	}else{
    	    System.out.println("This function is injective!!"); 
    	}
    }	
	
	public static void main(String[] args) {
    	System.out.println("Select the function to run [1 | 2 | 3]");	
    	System.out.println("1. 3x");
        System.out.println("2. x^2");
        System.out.println("3. 2x-2");
    
    	Scanner in = new Scanner(System.in);
    	int choice = in.nextInt();
    	
        if(choice == 1){
            System.out.println("\n3x");
            fistFunction();
        }else if(choice == 2){
            System.out.println("\nx^2");
            secondFunction();
        }else if(choice == 3){
            System.out.println("\n2x-2");
            thirdFunction();
        }else{
            System.out.println("Choose from 1 to 3!!");
        }
        
        System.out.println("An injective function is a function that maps distinct elements of its domain to distinct elements of its codomain.");
		
	}
}
