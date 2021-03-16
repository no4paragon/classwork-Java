import java.util.Scanner;

public class Recursion5
{
    public static long recursive(int x, int y){
        long result = 1;
        if(y > 0){
            result = x * recursive(x,y - 1); 
                  // 3 * (3,2)
                  // 3 * recursive(3,1)
                  // 3 * recursive(3,0)
                  // 1
        }
        return result;
    }
    
	public static void main(String[] args) {

        System.out.println("Enter an integer");
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        in.close();
        long squared = recursive(a,a);
        System.out.println(a + " to the power of " + a + " is " + squared);
	}
}