public class LinkedList {

    private Node headNode;

    public void addHeadNode(int x, int y)
    {

        Node oNode = new Node(x, y);
        oNode.nextNode = headNode;
        headNode = oNode;
    }


    public Node removeHeadNode(){

        // Set temp node variable to head node.
        Node tempNode = headNode;

        // if head node is NOT null then...
            // Set head node to head node's next node.
        if(tempNode != null){
            headNode = headNode.nextNode;
        }

        return tempNode;
    }



}
