import java.util.ArrayList;

public class MerkleThread implements Runnable {

    public static volatile ArrayList<String>lstWords;
    private int iMerkleTreeInputs = 4;
    public String threadName = "Merkle";
    @Override
    public void run() {

        Util util = new Util();
        lstWords = new ArrayList<>();

        System.out.println("Thread started: " + threadName);

        //Continuously run thread
        while(true){

            util.sleepRandomTime(threadName);
            System.out.println(threadName + " Woken up.");
            String sNewWord = MerkleManager.grabWord();
            if (sNewWord != null){
                System.out.println("Merkle grabbed the word!!");
                lstWords.add(sNewWord);
                if(lstWords.size() == iMerkleTreeInputs) {
                      MerkleManager.root = util.getMerkleRoot(lstWords);
                }
            }
        }
    }
}
