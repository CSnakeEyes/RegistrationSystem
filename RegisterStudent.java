package regPrototype;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashSet;
import java.util.Set;

public class RegisterStudent extends JFrame {

	private JPanel contentPane;
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField textUsername;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterStudent frame = new RegisterStudent();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RegisterStudent() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRegisterANew = new JLabel("Register a new student");
		lblRegisterANew.setBounds(150, 11, 112, 14);
		contentPane.add(lblRegisterANew);
		
		JTextPane txtpnPleaseEnterThe = new JTextPane();
		txtpnPleaseEnterThe.setText("Please enter the following information");
		txtpnPleaseEnterThe.setBounds(111, 23, 187, 20);
		contentPane.add(txtpnPleaseEnterThe);
		
		txtFirstName = new JTextField();
		txtFirstName.setToolTipText("First Name");
		txtFirstName.setBounds(10, 79, 86, 20);
		contentPane.add(txtFirstName);
		txtFirstName.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("First Name");
		lblNewLabel.setBounds(10, 54, 58, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(10, 110, 58, 14);
		contentPane.add(lblLastName);
		
		txtLastName = new JTextField();
		txtLastName.setToolTipText("Last Name");
		txtLastName.setBounds(10, 135, 86, 20);
		contentPane.add(txtLastName);
		txtLastName.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(115, 54, 58, 14);
		contentPane.add(lblUsername);
		
		textUsername = new JTextField();
		textUsername.setBounds(115, 79, 86, 20);
		contentPane.add(textUsername);
		textUsername.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(115, 110, 46, 14);
		contentPane.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(115, 135, 86, 20);
		contentPane.add(passwordField);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Set<Student> allStudents = new HashSet<Student>();
				allStudents = homePage.getDatabase().allStudents;
				String firstName = txtFirstName.getText();
				String lastName = txtLastName.getText();
				String userName = textUsername.getText();
				String passWord = passwordField.getText();
				allStudents.add(new Student(firstName, lastName, userName, passWord, allStudents ));
				dispose();
			}
		});
		btnConfirm.setBounds(10, 227, 89, 23);
		contentPane.add(btnConfirm);
	}
}
