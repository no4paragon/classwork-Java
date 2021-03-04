import java.util.ArrayList;

public class MinerThread implements Runnable {

    public String threadName;
    public void run() {

        Util util = new Util();
        ArrayList<String> lstTxs = new ArrayList<>();
        String sMerkleRoot;

        System.out.println("Thread started: " + threadName);

        //Populate arraylist with transactions
        lstTxs.add("tx1");
        lstTxs.add("tx2");
        lstTxs.add("tx3");
        lstTxs.add("tx4");

        //Get Merkle Root.
        sMerkleRoot = util.getMerkleRoot(lstTxs);
        System.out.println("root: " + sMerkleRoot);

        //Continuously run thread
        while(true){

            util.sleepRandomTime(threadName);
            System.out.println(threadName + " Woken up.");
        }


    }
}
