public class MatrixConnection{
    
    public static void main(String args[]){
    
        int first[][]={{1,0,0,1},{0,1,0,1},{0,0,1,0},{1,1,1,0}};    
        int second[][]={{0,1,1,1},{1,1,0,1},{0,1,0,1},{1,0,1,0}};    
        int result[][]=new int[4][4];
        int connection = 0;
        
        System.out.println("The new matrix (created by multiplying 2 matrices).");
        for(int i = 0; i < 4; i++){    
            for(int j = 0; j < 4; j++){    
                for(int k = 0; k < 4; k++){    
                    result[i][j] += first[i][k] * second[k][j];    
                }
            System.out.print("[" + result[i][j] + "]" + " ");
            }
        System.out.println();
        }

        for(int i = 0; i < 4; i++){    
            for(int j = 0; j < 4; j++){           
                connection += result[i][j];
            }
        }
        System.out.println("\nThe number of connections within the matrix is " + connection);

    }
}
