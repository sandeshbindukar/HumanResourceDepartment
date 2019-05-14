package run;

import login.LoginController;
import login.LoginModel;
import login.LoginView;

public class Run {
	public static void main(String[] args) {
		LoginView view = new LoginView();
		LoginModel model = new LoginModel();
		new LoginController(view, model);
		view.setVisible(true); //displays the login panel
		
	}
}
