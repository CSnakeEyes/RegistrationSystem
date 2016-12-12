package regPrototype;

import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class Course {
	public String department;
	public int CRN;
	public String name;
	public Professor teacher;
	public Set<Student> students;
	public Set<Student> waitingList;
	public int waitingListCap;
	public int activeWaitingList;
	public int activeStudents;
	public int studentCap;
	public int hours;
	public boolean passed;
	
	public Course(String name, String department, Professor teacher, int waitingListCap, int studentCap, int hours, Set<Course> allCourses){
		this.name = name;
		this.department = department;
		this.teacher = teacher;
		this.waitingListCap = waitingListCap;
		this.studentCap = studentCap;
		this.hours = hours;
		Random rand = new Random();
		boolean uniqueLoop = true;
		int tries = 0;
		int tempCRN =-1;
		while(uniqueLoop && tries < 100){
			tempCRN = rand.nextInt((9999 - 0) + 1) + 0;
			boolean match = false;
			tries++;
			Iterator<Course> it = allCourses.iterator();
			while(it.hasNext()){
				Course current = it.next();
				if(current.name == name){
					CRN = -1;
					return;
				}
				if(current.CRN == CRN)
					match = true;
				if(match)
					uniqueLoop = true;
				else
					uniqueLoop = false;	
			}
		}
		CRN = tempCRN;
	}
	
	public static Course findCourse(Set<Course> allCourses, String inputCourse){
		Iterator<Course> it = allCourses.iterator();
		while(it.hasNext()){
			Course current = it.next();
			if(current.name == inputCourse){
				return current;
			}
		}
		return null;
	}
	
	public String toString2(){
		  return this.department+" "+this.CRN+" "+this.name+" "+this.teacher.lastName+" "+
		    this.teacher.firstName+" "+this.hours+" "+this.passed;
	}
}
