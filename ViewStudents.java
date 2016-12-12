package regPrototype;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.html.HTMLDocument.Iterator;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;

import java.awt.List;
import java.util.Objects;

import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JLabel;

public class ViewStudents extends JFrame {

	private JPanel contentPane;
	private DefaultListModel<String> listModel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewStudents frame = new ViewStudents();
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
	public ViewStudents() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(0, 102, 153));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblViewStudents = new JLabel("View Students");
		lblViewStudents.setBounds(182, 11, 68, 14);
		lblViewStudents.setForeground(new Color(255, 255, 255));
		contentPane.add(lblViewStudents);
		
		//Gets the current list of all students and fills the listModel for the list element, which will display all of them.
		java.util.Iterator<Student> it = homePage.getDatabase().allStudents.iterator();
		listModel = new DefaultListModel<String>();
		//Header of the list
		listModel.addElement("ID   First Name   Last Name   GPA");
		while(it.hasNext()){
			Student current = it.next();
			listModel.addElement(current.toString());
		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 38, 414, 212);
		contentPane.add(scrollPane);
		
		JList<String> list = new JList<String>(listModel);
		scrollPane.setViewportView(list);
		
	}
}
