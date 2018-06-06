import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.JScrollPane;
import java.awt.Color;

public class ChatAppWindow extends JPanel{

	private JFrame frame;
	private JTextField textField;
	private JList<String> onlineList = new JList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
		
			
			public void run() {
				try {
					ChatAppWindow window = new ChatAppWindow();
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
	public ChatAppWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(142, 205, 302, 67);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		
		JList onlineUsers = new JList();
		onlineUsers.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		onlineUsers.setBounds(6, 276, 135, -272);
		frame.getContentPane().add(onlineUsers);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 6, 135, 266);
		frame.getContentPane().add(scrollPane);
		
		JList list = new JList();
		list.setBackground(new Color(204, 255, 255));
		scrollPane.setViewportView(list);
	}
}
