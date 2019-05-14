package login;

import java.util.ArrayList;

import department.Department;
import homepage.HomePageModel;

public class LoginModel {
	public static String name;
	//methods to check the username and passwords
	public boolean verifyLogin(String username, String password) {
		boolean login = false;
		if (username.equals("admin") && password.equals("admin")) {
			login = true;
		}
		return login;
	}
	
	public boolean checkLogin(String username, String password) {
		boolean login = false;
		ArrayList<Department> dep = new ArrayList<Department>();
		dep = HomePageModel.readDepartment(); //read department
		for (Department d : dep) {
			if (d.getUsername().equals(username)&& d.getPassword().equals(password)) {
				login = true;
				name = d.getName(); //sets name 
				break;
			}
		}
		return login;
	}
	

}