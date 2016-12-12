package regPrototype;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JList;

public class adviceStudent extends JFrame {
private JPanel contentPane;
private JTable table;
private DefaultListModel<String> listModel;

	public adviceStudent() {
			
		setTitle("Courses");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 102, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblViewStudents = new JLabel("Students");
		lblViewStudents.setBounds(182, 11, 88, 14);
		contentPane.add(lblViewStudents);
		
		//Gets the current list of all courses in the database
		java.util.Iterator<Course> it = homePage.getDatabase().allCourses.iterator();
		listModel = new DefaultListModel<String>();
		//List headers
		listModel.addElement("Student   Student ID   Advised ");
		//Cycles through all of the elements and adds them to ListModel which will display them in a list element
		while(it.hasNext()){
			Course current = it.next();
			listModel.addElement(current.toString());
		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 38, 414, 212);
		contentPane.add(scrollPane);
		
		JList<String> list = new JList<String>(listModel);
		scrollPane.setViewportView(list);
		
	}
		
	
}
