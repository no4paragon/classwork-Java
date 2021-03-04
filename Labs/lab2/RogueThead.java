public class RogueThead implements Runnable {
    public String threadName = "Rogue";

    @Override
    public void run() {
        Util util = new Util();

        //Continuously run thread
        while (true) {

            util.sleepRandomTime(threadName);
            System.out.println(threadName + " Woken up.");
            String sNewWord = MerkleManager.grabWord();
            if (sNewWord != null) {
                MerkleManager.strikes++;
                System.out.println("STRIKE!");

            }
        }
    }
}
