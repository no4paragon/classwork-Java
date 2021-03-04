public class MinerTest {
    public static void main(String[] args){

        //Instantiate our runnable thread obj.
        MinerThread oMiner1 = new MinerThread();
        oMiner1.threadName = "Miner 1";
        //Instantiate a Thread object and pass in our Runnable from above
        Thread oThread1 = new Thread(oMiner1);

        //Start the thread
        oThread1.start();
    }
}
