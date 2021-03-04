/**
 * This Queue maintains the queue of messages coming from connected clients.
 */
public class P2PMessageQueue {

    private P2PMessage head = null;
    private P2PMessage tail = null;


    /**
     * This method allows adding a message object to the existing queue.
     * @param oMessage
     */
    public synchronized void enqueue(P2PMessage oMessage){

        if(tail == null){
            tail = head = oMessage;
        }
        else{
            tail.next = oMessage;
            tail = oMessage;
        }
    }


    /**
     * This method allows removing a message object from the existing queue.
     * @return
     */
    public synchronized P2PMessage dequeue(){

        if(!hasNodes()){

            return null;
        }


        P2PMessage temp = new P2PMessage();
        temp = head;
        head = head.next;
        if(head == null){
            tail = null;
        }return temp;
    }
    


    public boolean hasNodes(){
         // return head != null
        if(head != null){
            return true;
        }
        else {
            return false;
        }
    }
}

