
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
