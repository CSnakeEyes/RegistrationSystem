package regPrototype;

import java.awt.BorderLayout;
import java.awt.Color;
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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		contentPane.setBackground(new Color(0, 102, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRegisterANew = new JLabel("Register a new student");
		lblRegisterANew.setForeground(new Color(255, 255, 255));
		lblRegisterANew.setBounds(150, 11, 133, 14);
		contentPane.add(lblRegisterANew);
		
		JTextPane txtpnPleaseEnterThe = new JTextPane();
		txtpnPleaseEnterThe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtpnPleaseEnterThe.setText("");
			}
		});
		txtpnPleaseEnterThe.setText("Please enter the following information");
		txtpnPleaseEnterThe.setBounds(111, 36, 187, 20);
		contentPane.add(txtpnPleaseEnterThe);
		
		txtFirstName = new JTextField();
		txtFirstName.setToolTipText("First Name");
		txtFirstName.setBounds(10, 108, 86, 20);
		contentPane.add(txtFirstName);
		txtFirstName.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("First Name");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(10, 82, 86, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setForeground(new Color(255, 255, 255));
		lblLastName.setBounds(10, 139, 74, 14);
		contentPane.add(lblLastName);
		
		txtLastName = new JTextField();
		txtLastName.setToolTipText("Last Name");
		txtLastName.setBounds(10, 164, 86, 20);
		contentPane.add(txtLastName);
		txtLastName.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setForeground(new Color(255, 255, 255));
		lblUsername.setBounds(150, 82, 81, 14);
		contentPane.add(lblUsername);
		
		textUsername = new JTextField();
		textUsername.setBounds(150, 108, 86, 20);
		contentPane.add(textUsername);
		textUsername.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(255, 255, 255));
		lblPassword.setBounds(153, 139, 67, 14);
		contentPane.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(150, 164, 86, 20);
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
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new registrarHome().setVisible(true);
			}
		});
		btnBack.setBounds(335, 227, 89, 23);
		contentPane.add(btnBack);
	}
}
