package regPrototype;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Set;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class addClassesRegistrar extends JFrame {

	private JPanel contentPane;
	private JTextField courseName;
	private JTextField department;
	private JTextField teacher;
	private JTextField waitingListCap;
	private JTextField studentCap;
	private JTextField hours;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addClassesRegistrar frame = new addClassesRegistrar();
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
	public addClassesRegistrar() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 102, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAddANew = new JLabel("Add a new course");
		lblAddANew.setForeground(new Color(255, 255, 255));
		lblAddANew.setBounds(164, 11, 126, 14);
		contentPane.add(lblAddANew);
		
		JLabel lblNewLabel = new JLabel("Course Name");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(10, 39, 86, 14);
		contentPane.add(lblNewLabel);
		
		courseName = new JTextField();
		courseName.setBounds(20, 64, 86, 20);
		contentPane.add(courseName);
		courseName.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Department");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(127, 36, 79, 14);
		contentPane.add(lblNewLabel_1);
		
		department = new JTextField();
		department.setBounds(137, 64, 86, 20);
		contentPane.add(department);
		department.setColumns(10);
		
		JLabel lblProfessor = new JLabel("Professor");
		lblProfessor.setForeground(new Color(255, 255, 255));
		lblProfessor.setBounds(237, 39, 64, 14);
		contentPane.add(lblProfessor);
		
		teacher = new JTextField();
		teacher.setBounds(247, 64, 86, 20);
		contentPane.add(teacher);
		teacher.setColumns(10);
		
		JLabel lblWaitingListCap = new JLabel("Waiting List Cap");
		lblWaitingListCap.setForeground(new Color(255, 255, 255));
		lblWaitingListCap.setBounds(10, 95, 96, 14);
		contentPane.add(lblWaitingListCap);
		
		waitingListCap = new JTextField();
		waitingListCap.setBounds(20, 120, 86, 20);
		contentPane.add(waitingListCap);
		waitingListCap.setColumns(10);
		
		JLabel lblStudentCap = new JLabel("Student Cap");
		lblStudentCap.setForeground(new Color(255, 255, 255));
		lblStudentCap.setBounds(127, 95, 79, 14);
		contentPane.add(lblStudentCap);
		
		studentCap = new JTextField();
		studentCap.setBounds(137, 120, 86, 20);
		contentPane.add(studentCap);
		studentCap.setColumns(10);
		
		JLabel lblCreditHours = new JLabel("Credit Hours");
		lblCreditHours.setForeground(new Color(255, 255, 255));
		lblCreditHours.setBounds(237, 95, 96, 14);
		contentPane.add(lblCreditHours);
		
		hours = new JTextField();
		hours.setBounds(247, 120, 86, 20);
		contentPane.add(hours);
		hours.setColumns(10);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Set<Course> allCourses = homePage.getDatabase().allCourses;
				String CourseName = courseName.getText();
				String Department = department.getText();
				String Teacher = teacher.getText();
				int WaitingListCap = Integer.parseInt(waitingListCap.getText());
				int StudentCap = Integer.parseInt(studentCap.getText());
				int Hours = Integer.parseInt(hours.getText());
				Professor teacher = Professor.findProfessor(homePage.getDatabase().allProfessors, Teacher);
				allCourses.add(new Course(CourseName, Department, teacher, WaitingListCap, StudentCap, Hours, allCourses));
				dispose();
			}
		});
		btnConfirm.setBounds(17, 216, 89, 23);
		contentPane.add(btnConfirm);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new registrarHome().setVisible(true);
			}
		});
		btnBack.setBounds(335, 216, 89, 23);
		contentPane.add(btnBack);
	}

}
