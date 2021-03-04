import java.security.SecureRandom;
import java.util.Scanner;
public class GameGrid {

    public static void run(){

        SecureRandom oRand = new SecureRandom();
        LinkedList oLink = new LinkedList();
        int [][] aiGrid = new int[10][10];
        int iWallChance = 30;
        int iUserRow = 0;
        int iUserCol = 0;
        boolean exit = false;
        int counter = 0;

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
                oLink.addHeadNode(iUserCol, iUserRow);
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
                oLink.addHeadNode(iUserCol, iUserRow);
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

        Node oNode = oLink.removeHeadNode();
        while(oNode != null){
            aiGrid[oNode.yPosi][oNode.xPosi] = 3;
            aiGrid[0][0] = 3;
            oNode = oLink.removeHeadNode();
            counter ++;
        }

        for(int y = 0; y < aiGrid.length; y++){
            //loop through inner array
            for(int x = 0; x < aiGrid[y].length; x++){
                if(y == iUserRow && x == iUserCol)
                    System.out.print("X ");
                else{
                    System.out.print(aiGrid[y][x] + " ");
                }
            }
            System.out.println();
        }
        System.out.println("You moved " + counter + " times!!");
    }
}

