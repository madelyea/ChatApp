import java.io.IOException;
import java.net.Socket;
import java.io.*;

public class ChatUser {
	String login;
	private final static int port = 8979;
//	Server server = new Server(port);
	private String serverName;
	private int serverPort;
	private BufferedReader readIn;
	private InputStream serverIn;
	private OutputStream outputStream;
	private Socket socket;
	
	public ChatUser(String serverName, int serverPort) {
		this.serverName = serverName;
		this.serverPort = serverPort;

	}

	public static void main(String [] args) throws IOException{
	ChatUser user = new ChatUser("localhost", 8979);	
		if (!user.connect()){
			System.err.println("Could not connect");
		}
			else
				System.out.println("Connected");
				user.userLogin("Admin", "123");
				
		}
	
	
	
	
	
	public void message(String receiver, String message) throws IOException {
		String sendMessage = "message" + receiver + " " + message + "\n";
		outputStream.write(sendMessage.getBytes());
	}

	// Reads in login information
	public boolean userLogin(String username, String password) throws IOException{
		System.out.println("Attempting login");
		String login = "login" + " " + username + " " + password;
        outputStream.write(login.getBytes());
        System.out.println("Wrote to outputstream");
        
        return true;
  /*      System.out.println(this.outputStream);
        //Read in server's response
        String success = readIn.readLine();
        System.out.println("inputstream");
        System.out.println("Response Line:" + success);
        
        if("success".equals(success)){
        	System.out.println("Login successful!");
        	return true;
        }
        else
        	return false;
	 */}

	
/*	public void readMessage(){
        Thread t = new Thread() {
            public void run() {
                loopReadMessage();
            }
        };
        t.start();
	}
	
	private loopReadMessage
	*/
	public boolean connect() {
		try {
			this.socket = new Socket(serverName, serverPort);
			System.out.println("Client port is " + socket.getLocalPort());
			this.outputStream = socket.getOutputStream();
			System.out.println(this.outputStream);
			this.serverIn = socket.getInputStream();
			this.readIn = new BufferedReader(new InputStreamReader(serverIn));
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

}
