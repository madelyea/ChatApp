
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class ServerHelper extends Thread {

	private final Socket userSocket;
	
	public ServerHelper(Socket userSocket){
		this.userSocket = userSocket;
	}
	public void run(){
		try {
			socketConnection();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	private void socketConnection() throws IOException, InterruptedException {
		
		InputStream inputStream = userSocket.getInputStream();
		OutputStream outputStream = userSocket.getOutputStream();
		
		//To read in line by line
		BufferedReader read = new BufferedReader(new InputStreamReader(inputStream));{
			String readLine;
			while ((readLine = read.readLine()) != null){
			
				String output = "You typed: " + readLine + "\n";	
			if ("quit".equalsIgnoreCase(readLine)){
				break;
			}
		//	String output = "You typed: " + readLine + "\n";
			outputStream.write(output.getBytes());
		}
		userSocket.close();
		
	}

}
	
}