import java.security.SecureRandom;
import java.util.Scanner;
public class GameGrid {

    public static void run(){

        SecureRandom oRand = new SecureRandom();
        int [][] aiGrid = new int[10][10];
        int iWallChance = 30;
        int iUserRow = 0;
        int iUserCol = 0;
        boolean exit = false;

        //loop through outer array
        for(int y = 0; y < aiGrid.length; y++){
            //loop through inner array
            for(int x = 0; x < aiGrid[y].length; x++){
                //aiGrid[y][x] = oRand.nextInt(2);
                int iChanceNum = oRand.nextInt(100);
                if(iChanceNum < iWallChance){
                    aiGrid[y][x] = 1;
                    aiGrid[0][0] = 0;
                }else{
                    aiGrid[y][x] = 0;
                    aiGrid[0][0] = 0;
                }
                System.out.print(aiGrid[y][x] + " ");
            }
            System.out.println();
        }
        while(!exit){
            System.out.println("Move down or right? (d/r)");
            Scanner scan = new Scanner(System.in);
            String input = scan.nextLine();
            if(input.equals("d")){
                iUserRow += 1;
                if(aiGrid[iUserRow][iUserCol] == 1){
                    exit = true;
                    System.out.println("You lost!!");
                }
                else if (iUserRow == 9)
                {
                    exit = true;
                    System.out.println("You won!!");
                }
            }else if(input.equals("r")){
                iUserCol += 1;
                if(aiGrid[iUserRow][iUserCol] == 1){
                    exit = true;
                    System.out.println("You lost!!");
                }
                else if (iUserCol == 9)
                {
                    exit = true;
                    System.out.println("You won!!");
                }
            }else{
                System.out.println("Enter d or r");
                input = scan.nextLine();
            }
        }
        for(int y = 0; y < aiGrid.length; y++){
            //loop through inner array
            for(int x = 0; x < aiGrid[y].length; x++){
                if(y == iUserRow && x == iUserCol)
                    System.out.println("X");
                else{
                    System.out.print(aiGrid[y][x] + " ");
                }
            }
            System.out.println();
        }
    }

}

