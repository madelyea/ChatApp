
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.List;

public class ServerHelper extends Thread {

	private Socket userSocket;
	public String username;
	public String password;
	public String login;
	private Server server;
	private OutputStream outputStream;
	DataInputStream inStream = null;
	String readLine = null; 

	// Constructor
	public ServerHelper(Socket userSocket, Server server) {
		this.userSocket = userSocket;
		this.server = server;

	}

	public void run() {
		try {
			socketConnection();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public boolean login(String [] inputArray, OutputStream outputStream) {
		this.username = inputArray[1];
		this.password = inputArray[2];

		if (username == "Admin" && password == "123"){
			this.login = username;
			String messageOnline = "success";
	
			try {
				outputStream.write(messageOnline.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
			return true;
		}
		else
			return false;
	
		}

	// Reads in messages from the ChatUser class and outputs to ChatUser Class
	private void socketConnection() throws IOException, InterruptedException {
		
		
		InputStream inputStream = userSocket.getInputStream();
		this.outputStream = userSocket.getOutputStream();
		System.out.println(outputStream);
		// To read in line by line
		
		BufferedReader read = new BufferedReader(new InputStreamReader(inputStream));
		String readLine = read.readLine();
		System.out.println(readLine);
	//	br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		
		while ((readLine = read.readLine()) != null) {
			String[] inputArray = readLine.split(" "); //separate input into tokens    
			String command = inputArray[0];
			System.out.println(inputArray.toString());
			System.out.println("hello");
			//Login Attempt
			if ("login".equals(command))
				login(inputArray, outputStream);
			
			if ("quit".equals(command))
				break;
		}
		userSocket.close();
	}

	public String getUsername() {
		return username;
	}

}
