package regPrototype;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class professorHome extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					professorHome frame = new professorHome();
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
	public professorHome() {
		setTitle("Professor Home Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 102, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblProfessorPicture = new JLabel("Professor Picture");
		lblProfessorPicture.setBounds(10, 10, 177, 120);
		contentPane.add(lblProfessorPicture);
		
		JLabel lblProfessorName = new JLabel("Professor Name");
		lblProfessorName.setForeground(new Color(255, 255, 255));
		lblProfessorName.setBounds(10, 136, 105, 14);
		contentPane.add(lblProfessorName);
		
		JLabel lblDepartment = new JLabel("Department");
		lblDepartment.setForeground(new Color(255, 255, 255));
		lblDepartment.setBounds(10, 156, 132, 14);
		contentPane.add(lblDepartment);
		
		JButton btnViewClasses = new JButton("View Classes");
		btnViewClasses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewClasses frame = new viewClasses();
				frame.setVisible(true);

			}
		});
		btnViewClasses.setBounds(274, 30, 122, 23);
		contentPane.add(btnViewClasses);
		
		JButton btnViewStudents = new JButton("View Students");
		btnViewStudents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewStudents frame = new viewStudents();
				frame.setVisible(true);
			}
		});
		btnViewStudents.setBounds(274, 110, 122, 23);
		contentPane.add(btnViewStudents);
		
		JButton btnAdviseStudent = new JButton("Advise Student");
		btnAdviseStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adviceStudent frame = new adviceStudent();
				frame.setVisible(true);
			}
		});
		btnAdviseStudent.setBounds(274, 183, 122, 23);
		contentPane.add(btnAdviseStudent);
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
