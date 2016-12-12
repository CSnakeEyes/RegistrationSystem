package regPrototype;

//Creates a new window that will contains the transcript of the student 

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

public class Transcript extends JFrame {
private JPanel contentPane;
private DefaultListModel<String> listModel;

	public Transcript() {
		setTitle("Transcript");		//give the name
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);	//set bounds
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 102, 153));	//set the color
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Student st = (Student) homePage.getCurrentUser();
		java.util.Iterator<Course> it = st.coursesCompleted.iterator();
				
		//Gets the current list of all courses in the database
		  listModel = new DefaultListModel<String>();
		  //List headers
		  listModel.addElement("Department     CRN     Course Name     Last Name     First Name   CreditHrs	  passed");
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
