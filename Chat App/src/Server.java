import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server extends Thread {

	private int port;

	// Constructor
	public Server(int port) {
		this.port = port;
	}

	// Array List to hold online users
	ArrayList<ServerHelper> connectionList = new ArrayList<>();

	public void run() {

		try {
			ServerSocket serverSocket = new ServerSocket(port);
			while (true) {
				System.out.println("Waiting for client connection \n");
				Socket userSocket = serverSocket.accept();
				System.out.println("Accepted connection from " + userSocket);

				// Create an instance of ServerHelper
				ServerHelper helper = new ServerHelper(userSocket, null);
				connectionList.add(helper);
				System.out.println("This is the connection list: " + connectionList);
				helper.start();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public List<ServerHelper> getConnectionList(){
		return connectionList;
		
		//TODO: remove connection
	}
	
	

}
