public class MonitorThread implements Runnable {
    public String threadName = "Monitor";
    @Override
    public void run() {
        Util util = new Util();
        while(true) {

            //util.sleepRandomTime(threadName);
            //System.out.println(threadName + " Woken up.");
            //String sNewWord = MerkleManager.grabWord();
            if (MerkleManager.root != null) {
                if (MerkleManager.root.equals(MerkleManager.enteredRoot)) {
                    System.out.println("You Win!!");
                    System.out.println(MerkleManager.root);
                    System.exit(0);
                } else {
                    System.out.println("Root is not correct!! Try again.");
                    System.exit(0);
                }

            } else if (MerkleManager.strikes == 3) {
                System.out.println("3 strikes: you lost!");
                System.exit(0);
            }

            util.sleep(1);
        }
    }
}
