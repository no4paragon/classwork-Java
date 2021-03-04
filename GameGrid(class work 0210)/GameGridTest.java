import java.security.SecureRandom;

public class GameGridTest {

    public static void main(String[] args) {

        SecureRandom oRand = new SecureRandom();

        int iRandomNum = oRand.nextInt(10) +1;

        System.out.println(iRandomNum);

//        Add static to runtTest1 or instantiate in main method.
//        GameGridTest oTest = new GameGridTest();
//        oTest.test();

        runtTest1();

    }

    public static void runtTest1(){

        SecureRandom oRand = new SecureRandom();

        int [][] aiGrid = new int[10][8];

        int iWallChance = 30;

        //loop through outer array
        for(int y = 0; y < aiGrid.length; y++){
            //loop through inner array
            for(int x = 0; x < aiGrid[y].length; x++){

                //aiGrid[y][x] = oRand.nextInt(2);
                int iChanceNum = oRand.nextInt(100);
                if(iChanceNum < iWallChance){
                    aiGrid[y][x] = 1;
                }else{
                    aiGrid[y][x] = 0;
                }

                System.out.print(aiGrid[y][x] + " ");
            }
            System.out.println();
        }
    }
}
