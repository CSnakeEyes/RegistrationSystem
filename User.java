package regPrototype;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class User {
	private int ID;
	public String firstName;
	public String lastName;
	private String userName;
	private String password;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getUserName() {
		return userName.toLowerCase();
	}
	public void setUserName(String userName) {
		this.userName = userName.toLowerCase();
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public static User findUser(Set<User> allUsers, String inputUsername){
		Iterator<User> it = allUsers.iterator();
		while(it.hasNext()){
			User current =it.next();
			if(current.userName.equals(inputUsername)){
				return current;
			}
		}
		return null;
	}
	
	public static int login(Database userDatabase, String inputUsername, String inputPassword){
		Set<User> allUsers = new HashSet<User>();
		allUsers.addAll(userDatabase.allProfessors);
		allUsers.addAll(userDatabase.allRegistrars);
		allUsers.addAll(userDatabase.allStudents);
		User current = findUser(allUsers, inputUsername);
		if(current!= null){
			if(current.getPassword().equals(inputPassword)){
				homePage.setCurrentUser(current);
				switch(current.getClass().getName()){
				case "regPrototype.Student":
					return 1;
				case "regPrototype.Professor":
					return 2;
				case "regPrototype.Registrar":
					return 3;
				default:
					return 0;
				}
			}
		}
		return 0;
	}
}
