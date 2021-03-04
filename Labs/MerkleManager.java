public class MerkleManager {

    public static volatile String word;
    public static String enteredRoot;
    public static String root = null;
    public static int strikes = 0;

    public void manage(){
        Util util = new Util();
        enteredRoot = util.promptUser("Enter a root");

        Thread merkle = new Thread(new MerkleThread());
        Thread rouge = new Thread(new RogueThead());
        Thread monitor = new Thread(new MonitorThread());

        merkle.start();
        rouge.start();
        monitor.start();

        while(true){
            word = util.promptUser("Enter a word");
        }

    }


    public static synchronized String grabWord() {
        String temp = word;
        word = null;
        return temp;
    }
}
