import java.util.ArrayList;

public class GenericsTest {

    public static void main(String [] args){

        //old way
        Object o = new Object();
        ArrayList lstNames = new ArrayList();
        lstNames.add("Harry");
        lstNames.add("Corky");
        lstNames.add(o);
        String sName = (String)lstNames.get(0);

        //New way with Generics
        ArrayList<String> lstOtherNames = new ArrayList<>();
        lstOtherNames.add("Sally");
        lstOtherNames.add("Darby");
        //Can't do this now
        //lstOtherNames.add(o);

        String sOtherName = lstOtherNames.get(0);

        Pair<String, Double> oStock1 = new Pair<>("goog",255.34);
        Pair<String, Double> oStock2 = new Pair<>("appl",125.22);
        ArrayList<Pair<String, Double>>lstStocks = new ArrayList<>();
        lstStocks.add(oStock1);
        lstStocks.add(oStock2);

        for(int x = 0; x < lstStocks.size(); x++){
            Pair<String, Double> oStock = lstStocks.get(x);
            System.out.println("Stock: " + oStock.getFirst() + " (" + oStock.getSecond() + ")");
        }

    }
}
