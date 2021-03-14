public class Main{
    
    public static int[][] maltiply(int[][]a,int[][]b){
        
        int result[][]=new int[4][4];
        
        for(int i = 0; i < 4; i++){    
            for(int j = 0; j < 4; j++){    
                for(int k = 0; k < 4; k++){    
                    result[i][j] += a[i][k] * b[k][j];
                    if(result[i][j] > 1){
                        result[i][j] = 1;
                    }
                }
            }
        }
    return result;
    }
    
    public static void dispMaltiply(int[][]a){
        System.out.println("The new matrix (created by multiplying 2 matrices).");
        for(int i = 0; i < 4; i++){    
            for(int j = 0; j < 4; j++){           
                System.out.print("[" + a[i][j] + "]" + " ");
            }
        System.out.println();
        }
    }
    
    public static void connection(int[][]c){
        int connection = 0;
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){           
                connection += c[i][j];
            }
        }
    System.out.println("The number of connections within the matrix is " + connection);
    }

    public static void main(String args[]){
    
        int first[][]={{1,0,0,1},{0,1,0,1},{0,0,1,0},{1,1,1,0}};    
        int second[][]={{0,1,1,1},{1,1,0,1},{0,1,0,1},{1,0,1,0}};    
        
        int[][] m = maltiply(first, second);
        dispMaltiply(m);
        connection(m);
    }
}
