import java.util.ArrayList;


/**
 * This holds the values for a Block in the Blockchain, and it has methods to compute the Merkle Root and generate a hash.
 */
public class Block {


    private String sMerkleRoot;
    private int iDifficulty = 5; // Mining seconds in testing 5: 6,10,15,17,20,32 | testing 6: 12,289,218
    private String sNonce;
    private String sMinerUsername;
    private String sHash;



    /**
     * This computes the Merkle Root. It either accepts 2 or 4 items, or if made to be dynamic, then accepts any
     * multiple of 2 (2,4,8.16.32,etc.) items.
     * @param lstItems
     * @return
     */
    public synchronized String computeMerkleRoot(ArrayList<String> lstItems) {

        if(isPowerOfTwo(lstItems.size())){
            ArrayList<MerkleNode>arr = new ArrayList<>();
            for(int i = 0; i < lstItems.size(); i++ ){
                MerkleNode node = new MerkleNode();
                node.sHash = BlockchainUtil.generateHash(lstItems.get(i));
                arr.add(node);
            }


           // create new merkl node arr list
            //for loop thru list items in
            //1 create a new merkl node 2 call s.hash on this node obj  set == block chain util generate hash(index of the for loop)
            //3 call merkl node arr list .add(merklnode)

            int calc = ((arr.size()*2) - 2);
            for(int i = 0; i < calc; i += 2){
                MerkleNode node2 = new MerkleNode();
                populateMerkleNode(node2, arr.get(i),arr.get(i+1));
                arr.add(node2);
            }


            //for loop, create int variable calc size  (calc.size()*2) -2
            //1 for inti=0 i<calc.size i+=2
            //2 create a new merkl node obj, 3 PopulateMerkleNode(merklnode, merklnodes.get(i),merklnodes.get(i+1))
            //merklnodes.add(merklenode)

            return arr.get(calc).sHash;

        }
         return null;


    }

    public boolean isPowerOfTwo(int n)
    {
        return (int)(Math.ceil((Math.log(n) / Math.log(2))))
                == (int)(Math.floor(((Math.log(n) / Math.log(2)))));
    }

    /**
     * This method populates a Merkle node's left, right, and hash variables.
     * @param oNode
     * @param oLeftNode
     * @param oRightNode
     */
    private void populateMerkleNode(MerkleNode oNode, MerkleNode oLeftNode, MerkleNode oRightNode){


        oNode.oLeft = oLeftNode;
        oNode.oRight = oRightNode;
        oNode.sHash = BlockchainUtil.generateHash(oNode.oLeft.sHash + oNode.oRight.sHash);
    }


    // Hash this block, and hash will also be next block's previous hash.

    /**
     * This generates the hash for this block by combining the properties and hashing them.
     * @return
     */
    public String computeHash() {

        return new BlockchainUtil().generateHash(sMerkleRoot + iDifficulty + sMinerUsername + sNonce);
    }



    public int getDifficulty() {
        return iDifficulty;
    }


    public String getNonce() {
        return sNonce;
    }
    public void setNonce(String nonce) {
        this.sNonce = nonce;
    }

    public void setMinerUsername(String sMinerUsername) {
        this.sMinerUsername = sMinerUsername;
    }

    public String getHash() { return sHash; }
    public void setHash(String h) {
        this.sHash = h;
    }

    public synchronized void setMerkleRoot(String merkleRoot) { this.sMerkleRoot = merkleRoot; }




    /**
     * Run this to test your merkle tree logic.
     * @param args
     */
    public static void main(String[] args){

        ArrayList<String> lstItems = new ArrayList<>();
        Block oBlock = new Block();
        String sMerkleRoot;

        // These merkle root hashes based on "t1","t2" for two items, and then "t3","t4" added for four items.
        String sExpectedMerkleRoot_2Items = "3269f5f93615478d3d2b4a32023126ff1bf47ebc54c2c96651d2ac72e1c5e235";
        String sExpectedMerkleRoot_4Items = "e08f7b0331197112ff8aa7acdb4ecab1cfb9497cbfb84fb6d54f1cfdb0579d69";

        lstItems.add("t1");
        lstItems.add("t2");


        // *** BEGIN TEST 2 ITEMS ***

        sMerkleRoot = oBlock.computeMerkleRoot(lstItems);

        if(sMerkleRoot.equals(sExpectedMerkleRoot_2Items)){

            System.out.println("Merkle root method for 2 items worked!");
        }

        else{
            System.out.println("Merkle root method for 2 items failed!");
            System.out.println("Expected: " + sExpectedMerkleRoot_2Items);
            System.out.println("Received: " + sMerkleRoot);

        }


        // *** BEGIN TEST 4 ITEMS ***

        lstItems.add("t3");
        lstItems.add("t4");
        sMerkleRoot = oBlock.computeMerkleRoot(lstItems);

        if(sMerkleRoot.equals(sExpectedMerkleRoot_4Items)){

            System.out.println("Merkle root method for 4 items worked!");
        }

        else{
            System.out.println("Merkle root method for 4 items failed!");
            System.out.println("Expected: " + sExpectedMerkleRoot_4Items);
            System.out.println("Received: " + sMerkleRoot);

        }
    }
}
