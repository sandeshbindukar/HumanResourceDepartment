package secretary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import department.ContractLecturer;
import department.FullTimeLecturer;
import department.PartTimeLecturer;
import login.LoginController;
import login.LoginModel;
import login.LoginView;

public class SecretaryController {
	
	SecretaryView view;
	SecretaryModel model;
	 
	 public SecretaryController(SecretaryView view, SecretaryModel model) {
		 this.view = view;
		 this.model = model;
		 
		 //to set the home panel visible
		 this.view.lblHomeListener(new MouseAdapter() {
			 public void mouseClicked(MouseEvent e) {
				view.homePanel.setVisible(true);
				view.viewFullTimeLecturerPanel.setVisible(false);
				view.viewPartTimeLecturerPanel.setVisible(false);
				view.viewContractLecturerPanel.setVisible(false);
				view.viewAllLecturerPanel.setVisible(false);
				view.viewQueryLecturerPanel.setVisible(false);
			}
		}); 
		 
		 //to set the full time lecturer panel visible
			this.view.lblFullTimeLecturerListener(new MouseAdapter() {
				 public void mouseClicked(MouseEvent e) {
					view.homePanel.setVisible(false);
					view.viewFullTimeLecturerPanel.setVisible(true);
					view.viewPartTimeLecturerPanel.setVisible(false);
					view.viewContractLecturerPanel.setVisible(false);
					view.viewAllLecturerPanel.setVisible(false);
					view.viewQueryLecturerPanel.setVisible(false);
				}
			});
			 
			 //to set the part time lecturer panel visible
			 this.view.lblPartTimeLecturerListener(new MouseAdapter() {
				 public void mouseClicked(MouseEvent e) {
					view.homePanel.setVisible(false);
					view.viewFullTimeLecturerPanel.setVisible(false);
					view.viewPartTimeLecturerPanel.setVisible(true);
					view.viewContractLecturerPanel.setVisible(false);
					view.viewAllLecturerPanel.setVisible(false);
					view.viewQueryLecturerPanel.setVisible(false);
				}
			});
			 
			 //to set the contract lecturer panel visible
			 this.view.lblContractLecturerListener(new MouseAdapter() {
				 public void mouseClicked(MouseEvent e) {
					view.homePanel.setVisible(false);
					view.viewFullTimeLecturerPanel.setVisible(false);
					view.viewPartTimeLecturerPanel.setVisible(false);
					view.viewContractLecturerPanel.setVisible(true);
					view.viewAllLecturerPanel.setVisible(false);
					view.viewQueryLecturerPanel.setVisible(false);
				}
			});
			 
			 //to set the all lecturer panel visible
			 this.view.lblAllLecturerListener(new MouseAdapter() {
				 public void mouseClicked(MouseEvent e) {
					view.homePanel.setVisible(false);
					view.viewFullTimeLecturerPanel.setVisible(false);
					view.viewPartTimeLecturerPanel.setVisible(false);
					view.viewContractLecturerPanel.setVisible(false);
					view.viewAllLecturerPanel.setVisible(true);
					view.viewQueryLecturerPanel.setVisible(false);
				}
			});
			 
			 //to set the query lecturer panel visible
			 this.view.lblQueryLecturerListener(new MouseAdapter() {
				 public void mouseClicked(MouseEvent e) {
					view.homePanel.setVisible(false);
					view.viewFullTimeLecturerPanel.setVisible(false);
					view.viewPartTimeLecturerPanel.setVisible(false);
					view.viewContractLecturerPanel.setVisible(false);
					view.viewAllLecturerPanel.setVisible(false);
					view.viewQueryLecturerPanel.setVisible(true);
				}
			});
			 
			 //to gets logged out
			 this.view.lblLogOutListener(new MouseAdapter() {
				 public void mouseClicked(MouseEvent e) {
					 LoginView lview = new LoginView();
					 LoginModel lmodel = new LoginModel();
					 new LoginController(lview,lmodel);
					 lview.setVisible(true);
					 
					 view.setVisible(false);
				 }
			});
			 
			 //to add lecturer in the table
			 this.view.addFullTimeLecturerRowToTable(this.model.readFullTimeLecturer()); 
			 this.view.addPartTimeLecturerRowToTable(this.model.readPartTimeLecturer());
			 this.view.addContractLecturerRowToTable(this.model.readContractLecturer());
			 
			 //to display all the lecturer in the table
			 this.view.displayAllLecturer();
			 
			 //when search button is pressed 
			 this.view.searchListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					view.displayQueryLecturer(Integer.parseInt(view.staffIdField.getText()));		
				}
			});
			 
	 }
	 
	

}
