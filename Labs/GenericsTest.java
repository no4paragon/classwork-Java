import java.util.ArrayList;

public class GenericsTest {

    public static void main(String [] args){

        Triple<String,Integer,Integer>[] teamList = new Triple[5];
        ArrayList[String] lstNames = new ArrayList[String]();

        teamList[0] = new Triple<>("SD", 1, 9);
        teamList[1] = new Triple<>("LA", 5, 2);
        teamList[2] = new Triple<>("FL", 4, 6);
        teamList[3] = new Triple<>("TX", 8, 2);
        teamList[4] = new Triple<>("NY", 7, 3);

        Pair<String, Double>[] stats = new Pair [5];

        // Populate stats with for loop
        for(int x = 0; x < teamList.length; x++){
            stats[x] = new Pair(teamList[x].getFirst(), 100 * (teamList[x].getSecond() / 10.0));
        }

        // Establish comparison value for team win % before loop
        String highestName = stats[0].getFirst();
        double highestWins = stats[0].getSecond();

        for(int i = 0; i< stats.length; i++){
            System.out.println(stats[i].getFirst() + " " + stats[i].getSecond() + "%");
            if(stats[i].getSecond() > highestWins){
                highestWins = stats[i].getSecond();
                highestName = stats[i].getFirst();
            }
        }

        System.out.println("Best team: " + highestName + "\nWin Rate: " + highestWins + "%");

    }
}