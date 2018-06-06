import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;

public class LoginWindow {

	private JFrame frame;
	private JTextField username;
	private final Action action = new SwingAction();
	private JTextField password;
	private final ChatUser user =  new ChatUser();

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
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
				if (username.getText().isEmpty() || password.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please re-enter your username and password");
				}
				if (username.getText().equals("Admin") && password.getText().equals("123")) {
					JOptionPane.showMessageDialog(null, "Login Successful!");
					// Close login window and open chat window
					String usr = username.getText();
					String psw = password.getText();
					user.userLogin(usr, psw);
				//	Server server = new Server();
				//	server.connectionList.add(usr);
					
					frame.dispose();
					
				}
				if (username.getText().equals("Admin2") && password.getText().equals("123")) {
					JOptionPane.showMessageDialog(null, "Login Successful!");
					// Close login window and open chat window
					frame.dispose();
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
