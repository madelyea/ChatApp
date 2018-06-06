
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashSet;

public class Server{
	
	public static void main(String[] args) {
		//Create an array list to store online users
		ArrayList<String> connectionList = new ArrayList<String>();
		
		int port = 8779;
		
		try{
			ServerSocket serverSocket = new ServerSocket(port);
			while(true){
				System.out.println("Waiting for client connection \n");
				Socket userSocket = serverSocket.accept();
				System.out.println("Accepted connection from " + userSocket);
				
				//Create an instance of ServerHelper
				ServerHelper helper = new ServerHelper(userSocket);
				helper.start();
			}

		
		}catch (IOException e){
		//	System.out.println("Could not listen on port " + port);
			e.printStackTrace();
		}
		
		


}

	
}
