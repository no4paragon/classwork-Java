import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer implements Runnable {

    private int thisServerPort;

    // This constructor forces port to be passed in that is necessary for startup
    // of server socket.
    public SocketServer(int iPort){
        thisServerPort = iPort;
    }

    public void run(){

        try(ServerSocket oServerSocket = new ServerSocket(thisServerPort)){

            System.out.println("Server is listening on port " + thisServerPort);

            while(true){

                // Wait for connection.
                Socket oSocket = oServerSocket.accept();
                System.out.println("[server]: New client connected: " +
                        oSocket.getRemoteSocketAddress());

                InputStream input = oSocket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));

                OutputStream output = oSocket.getOutputStream();
                PrintWriter writer = new PrintWriter(output, true);

                // Get sent in message from client.
                String sReceivedMessage = reader.readLine();
                // Print out message.
                System.out.println("[server]: Server received message: " +
                        sReceivedMessage);


                /// Lab 5 Code Begins here ///
                String[] splitMessage = sReceivedMessage.split(", ");

                int sum = 0;
                for(int i = 0; i < splitMessage.length; i++)
                {
                    int temp = Integer.parseInt(splitMessage[i]);
                    sum += temp;
                }
                System.out.println("Sum of three numbers is " + sum);

                // Send back message to client.
                writer.println("Server received your message (" + sum + ")");

                // Guarantee that flush runs (sends built up message(s) back to client).
                writer.flush();
            }
        }
        catch(IOException ex){
            System.out.println("[server]: Server exception: " + ex.getMessage());
        }
    }
}
