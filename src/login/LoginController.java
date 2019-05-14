package login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import homepage.HomePageController;
import homepage.HomePageModel;
import homepage.HomePageView;
import secretary.SecretaryController;
import secretary.SecretaryModel;
import secretary.SecretaryView;

public class LoginController {
	 LoginView view;
	 LoginModel model;
	 
	 public LoginController(LoginView view, LoginModel model) {
		 this.view = view;
		 this.model = model;
		 
		 //when login button is pressed or to get logged in
		 this.view.loginListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (model.verifyLogin(view.getUsername(), view.getPassword())) {	
					HomePageView viewHome = new HomePageView();
					HomePageModel modelHome = new HomePageModel();
					new HomePageController(viewHome, modelHome);
					viewHome.setVisible(true); //goes to department head home panel
					view.setVisible(false);			
				} 
				else if(model.checkLogin(view.getUsername(), view.getPassword())) {
					SecretaryView sview = new SecretaryView();
					SecretaryModel smodel = new SecretaryModel();
					new SecretaryController(sview, smodel);
					sview.setVisible(true);  //goes to secretary home panel
					view.setVisible(false);	
				}
				else { //invalid username or password
					JOptionPane.showMessageDialog(null, "Invalid username or password", "Login page", JOptionPane.ERROR_MESSAGE);
				}		
			}
		 });	 
		 
		 //to exit from the system
		 this.view.exitListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
	 }
	

}
