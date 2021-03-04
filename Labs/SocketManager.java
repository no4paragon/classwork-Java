import java.util.Scanner;

public class SocketManager {

    public static void main(String[] args){

        // First get server port from user.
        System.out.print("Enter port for this server to listen on: ");
        int iPort = new Scanner(System.in).nextInt();

        // Get target server info to connect to from user.
        System.out.print("Enter IP address of server to connect to: ");
        String sOtherServerIP = new Scanner(System.in).nextLine();
        System.out.print("Enter port of server to connect to: ");
        int iOtherServerPort = new Scanner(System.in).nextInt();

        // Start up server thread.
        SocketServer oServer = new SocketServer(iPort);
        Thread oServerThread = new Thread(oServer);
        oServerThread.start();

        while(true){

            SocketClient oClient = new SocketClient();
            System.out.print("Enter three numbers separated by commas: ");
            String sMessage = new Scanner(System.in).nextLine();
            String sReturnedMessage =
                    oClient.connectForOneMessage(sOtherServerIP,iOtherServerPort,sMessage);
            System.out.println("[client] Server reply: " + sReturnedMessage);
        }
    }
}
