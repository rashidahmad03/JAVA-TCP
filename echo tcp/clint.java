import java.net.*;
import java.io.*;

class GreetingClient {

   public static void main(String [] args) {
      String localhost = args[0];
      int port = Integer.parseInt(args[1]);
      try {
         System.out.println("Connecting to " + localhost + " on port " + 8080);
         Socket client = new Socket(localhost, 8080);
         
         System.out.println("Just connected to " + client.getRemoteSocketAddress());
         OutputStream outToServer = client.getOutputStream();
         DataOutputStream out = new DataOutputStream(outToServer);
         
         out.writeUTF("Hello from " + client.getLocalSocketAddress());
         InputStream inFromServer = client.getInputStream();
         DataInputStream in = new DataInputStream(inFromServer);
         
         System.out.println("Server says " + in.readUTF());
         client.close();
      }catch(IOException e) {
         e.printStackTrace();
      }
   }
}