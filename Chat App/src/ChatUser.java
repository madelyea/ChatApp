import java.io.IOException;

public class ChatUser {
	String login;
	
	//Reads in login information
	public String userLogin(String username, String password){
		String loginInfo = username + "#" + password;
		System.out.println(loginInfo);
		
		this.login = username;
		System.out.println("User " + login + " has logged in.\n");
		
		
		return loginInfo;
}
	
}
