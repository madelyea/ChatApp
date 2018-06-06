import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.JScrollPane;
import java.awt.Color;

public class OnlineUsers extends JPanel{

	private JFrame frame;
	private JList<String> onlineList = new JList<>();
	private static ChatUser user;
	

	public OnlineUsers(ChatUser user){
		this.user = user;
		initialize();
	}
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
		
			
			public void run() {
				try {
					OnlineUsers window = new OnlineUsers(user);
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


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JList onlineUsers = new JList();
		onlineUsers.setBounds(6, 276, 135, -272);
		onlineUsers.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		frame.getContentPane().add(onlineUsers);
		
		JList list = new JList();
		list.setBackground(new Color(153, 255, 255));
		list.setBounds(212, 142, 1, 1);
		frame.getContentPane().add(list);
	}
}
