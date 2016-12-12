package regPrototype;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;

public class registrarHome extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registrarHome frame = new registrarHome();
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
	public registrarHome() {
		setTitle("Registrar Home Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 102, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRegistrarPicture = new JLabel("Registrar Picture");
		lblRegistrarPicture.setBounds(10, 10, 177, 120);
		contentPane.add(lblRegistrarPicture);
		
		JLabel lblRegistrarName = new JLabel("Registrar Name");
		lblRegistrarName.setForeground(new Color(255, 255, 255));
		lblRegistrarName.setBounds(10, 140, 131, 14);
		contentPane.add(lblRegistrarName);
		
		JLabel lblDepartment = new JLabel("Department");
		lblDepartment.setForeground(new Color(255, 255, 255));
		lblDepartment.setBounds(10, 160, 131, 14);
		contentPane.add(lblDepartment);
		
		JButton btnRegisterStudent = new JButton("RegisterStudent");
		btnRegisterStudent.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				//Opens a new Register Student window, which displays a form that must be filled in order to add a new student
				dispose();
				new RegisterStudent().setVisible(true);
			}
		});
		btnRegisterStudent.setBounds(274, 30, 122, 23);
		contentPane.add(btnRegisterStudent);
		
		JButton btnViewStudent = new JButton("View Students");
		btnViewStudent.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent arg1) {
				//Opens a new View Student window, which displays all of the students in the database
				dispose();
				new ViewStudents().setVisible(true);
			}
		});
		btnViewStudent.setBounds(274, 72, 122, 23);
		contentPane.add(btnViewStudent);
		
		JButton btnLookUpClasses = new JButton("Add classes");
		btnLookUpClasses.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				//Opens a new addClassesRegistrar window, which contains a form in order to add a new course
				dispose();
				new addClassesRegistrar().setVisible(true);
			}
		});
		btnLookUpClasses.setBounds(274, 106, 122, 23);
		contentPane.add(btnLookUpClasses);
		
		JButton btnNewButton = new JButton("View all classes");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Opens a new viewAllCoursesRegistrar window, which contains all of the courses
				dispose();
				new ViewAllCoursesRegistrar().setVisible(true);
			}
		});
		btnNewButton.setBounds(274, 140, 122, 23);
		contentPane.add(btnNewButton);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new homePage().setVisible(true);
			}
		});
		btnLogOut.setBounds(335, 227, 89, 23);
		contentPane.add(btnLogOut);
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
