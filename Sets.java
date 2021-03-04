import java.util.*;

public class Sets{

    public static void main(String[] args) {

        Set<Integer> setS = new HashSet<Integer>(); 
        Set<Integer> setT = new HashSet<Integer>();

        //Creating sets S
        System.out.println("Length of S: ");
        Scanner S = new Scanner(System.in);
        int sLength = S.nextInt();  
        System.out.println("Enter sets for S: " );
        for(int i = 0; i < sLength; i++){
            int sets = S.nextInt();
            setS.add(sets);
        }
        
        //Creating sets T
        System.out.println("Length of T: ");
        Scanner T = new Scanner(System.in);
        int tLength = T.nextInt();  
        System.out.println("Enter sets for T: " );
        for(int i = 0; i < tLength; i++){
            int sets = T.nextInt();
            setT.add(sets);
        }
    
        List<Integer> S_list = new ArrayList<Integer>(setS);
        List<Integer> T_list = new ArrayList<Integer>(setT);

        Set<Set<Integer>> ps = new HashSet<Set<Integer>>();
        
        // [1,2] set size is 2, there are 4 subsets
        //  0 0 = 0 { }
        //  0 1 = 1 { 2 }
        //  1 0 = 2 { 1 }
        //  1 1 = 3 { 1, 2 }
        
        // 1 0 1 
        //     1 => include this part of the set
        
        //   1 0
        //     0 => do not include this part of the set
            
        //     1
        //     1 => include this part of the set
            
        //  0001 = 1 = 2^0 = 1
        //  0010 = 2 = 2^1 = 2
        //  0100 = 4 = 2^2 = 4
        
        // 1 being shifted to the left * sLength.
        for( int i = 0; i < (1 << sLength); i++){
        // int s = int(Math.pow(2, sLength));
        // int() casting.
        
            Set<Integer> current = new HashSet<Integer>();
            for( int j = 0; j < sLength; j++ )
                if( (i >> j) % 2 == 1 )
                    current.add(S_list.get(j));
            ps.add(current);
        }
        System.out.println("P(s) = " + ps);
     
        System.out.print("S x T = ");
        for (int i = 0; i < sLength; i++) 
            for (int j = 0; j < tLength; j++)
                System.out.print( "[{"+ S_list.get(i)+"," + T_list.get(j)+"}]");
            System.out.println("");

		Set<Integer> union = new HashSet<Integer>(setS);
		union.addAll(setT);
		System.out.println("𝑆 ∪ 𝑇 = " + union);

        Set<Integer> intersection = new HashSet<Integer>(setS);
		intersection.retainAll(setT);
		System.out.println("𝑆 ∩ 𝑇 = " + intersection);

        Set<Integer> difference = new HashSet<Integer>(setS);  
        difference.removeAll(setT);  
        System.out.println("𝑆 - 𝑇 = " + difference);  

        Set<Integer> complement = new HashSet<Integer>(setS);  
        complement.addAll(setT);
        complement.removeAll(setS);
        System.out.println("𝑆' = " + complement);

    }
}
