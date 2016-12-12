package regPrototype;



import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JWindow;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.DropMode;
import javax.swing.ImageIcon;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;

import javax.swing.JPasswordField;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashSet;

public class homePage extends JFrame {
	private static int loginStatus = 0;
	private JPanel contentPane;
	private JTextField textUserName;
	private JPasswordField textPassword;
	private static Database userDatabase = new Database();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws IOException {
		JWindow window = new JWindow();
		window.getContentPane().add(
		    new JLabel("", new ImageIcon(new URL("https://media.giphy.com/media/tbGNixbTnIyVW/giphy.gif")), SwingConstants.CENTER));
		window.setBounds(500, 150, 572, 304);
		window.setVisible(true);
		try {
		    Thread.sleep(5000);
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
		window.setVisible(false);
		
		window.dispose();

		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					homePage frame = new homePage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public static Database getDatabase(){
		return userDatabase;
	}
	private class loginButtonListener implements ActionListener{
		public void actionPerformed (ActionEvent e){
			userDatabase.allRegistrars.add(new Registrar("Cristian", "Ayub", "cayub", "asdf1",userDatabase.allRegistrars));
			userDatabase.allProfessors.add(new Professor("Jesus", "Juarez", "jjuarez", "asdf2","Computer Science", userDatabase.allProfessors));
			userDatabase.allStudents.add(new Student("Gabriel", "Felix", "gmfelix", "asdf3", userDatabase.allStudents));
			String user = textUserName.getText();
			String pass = textPassword.getText();
			user = user.toLowerCase();
			loginStatus = User.login(userDatabase, user, pass);
			//Validate user
			if(loginStatus == 3){
				dispose();
				new registrarHome().setVisible(true);
			} else if(loginStatus == 1){
				dispose();
				new studentHome().setVisible(true);
			} else if(loginStatus == 2){
				dispose();
				new professorHome().setVisible(true);
			} else{
				JOptionPane.showMessageDialog(null, "Error: Wrong user name or password.");
			}
		}
	}
	
	private class resetButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			textUserName.setText("");
			textPassword.setText("");
		}
	}

	/**
	 * Create the frame.
	 */
	public homePage() {
		setTitle("Home Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 102, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnLogIn = new JButton("Log in");
		btnLogIn.setBounds(116, 208, 89, 23);
		contentPane.add(btnLogIn);
		btnLogIn.addActionListener(new loginButtonListener());
		
		textUserName = new JTextField();
		textUserName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textUserName.setText("");
			}
		});
		textUserName.setText("Enter username here...");
		textUserName.setBounds(133, 86, 170, 20);
		contentPane.add(textUserName);
		textUserName.setColumns(10);
		
		JLabel lblUserName = new JLabel("Username");
		lblUserName.setForeground(new Color(255, 255, 255));
		lblUserName.setBounds(133, 52, 170, 23);
		contentPane.add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(255, 255, 255));
		lblPassword.setBounds(133, 124, 170, 23);
		contentPane.add(lblPassword);
		
		textPassword = new JPasswordField();
		textPassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
					textPassword.addActionListener(new loginButtonListener());
			}
		});
		textPassword.setToolTipText("");
		textPassword.setBounds(133, 158, 170, 20);
		contentPane.add(textPassword);
		textPassword.setColumns(10);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBounds(241, 208, 89, 23);
		contentPane.add(btnReset);
		btnReset.addActionListener(new resetButtonListener());
	}
}
