import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.Action;

public class LoginWindow {

	private JFrame frame;
	private JTextField username;
	private final Action action = new SwingAction();
	private JTextField password;
	private String userN;
	String serverName;
	String serverPort;
	private ChatUser user;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginWindow window = new LoginWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the application.
	 */
	public LoginWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		//Create an instance of ChatUser
		this.user = new ChatUser("localhost", 8979);
        user.connect();
        
        
        
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel usernameLabel = new JLabel("Username: ");
		usernameLabel.setBounds(62, 71, 104, 16);
		frame.getContentPane().add(usernameLabel);

		JLabel passwordLabel = new JLabel("Password: ");
		passwordLabel.setBounds(233, 71, 96, 16);
		frame.getContentPane().add(passwordLabel);

		username = new JTextField();
		username.setBounds(62, 99, 130, 26);
		frame.getContentPane().add(username);
		username.setColumns(10);

		JLabel loginWelcome = new JLabel("Login");
		loginWelcome.setBounds(62, 21, 117, 16);
		frame.getContentPane().add(loginWelcome);

		JButton loginButton = new JButton("Login");
		loginButton.addActionListener(new ActionListener() {
			
			
		public void actionPerformed(ActionEvent arg0) {
				String usr = username.getText();
				String psw = password.getText();
				
				
				if (usr == null || psw == null) {
					JOptionPane.showMessageDialog(null, "Please re-enter your username and password");
				}
				
				//:TODO changeto if(match found in database)
				try {
					if (user.userLogin(usr, psw)) {
						
						// Close login window and open chat window	
						
						JOptionPane.showMessageDialog(null, "Login Successful!");
						frame.dispose();
					
						OnlineUsers onlineUsersWindow = new OnlineUsers(user);
						JFrame frame = new JFrame("User List");
		                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		                frame.setSize(400, 600);

		                frame.getContentPane().add(onlineUsersWindow, BorderLayout.CENTER);
		                frame.setVisible(true);

		      
						
					}
				} catch (HeadlessException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		
		
		
		loginButton.setForeground(new Color(102, 0, 153));
		loginButton.setBackground(new Color(153, 51, 204));
		loginButton.setBounds(157, 137, 117, 29);
		frame.getContentPane().add(loginButton);

		password = new JTextField();
		password.setBounds(230, 99, 130, 26);
		frame.getContentPane().add(password);
		password.setColumns(10);
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		public void actionPerformed(ActionEvent e) {
		}
		
		
	}
}
