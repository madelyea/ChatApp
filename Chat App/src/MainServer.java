
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashSet;

public class MainServer {

	public static void main(String[] args) {
	
		try {
			int port = 8979;
			Server newServer = new Server(port);
			newServer.start();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
