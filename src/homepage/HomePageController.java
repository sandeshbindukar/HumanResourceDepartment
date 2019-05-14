package homepage;

import homepage.HomePageView;
import login.LoginController;
import login.LoginModel;
import login.LoginView;
import homepage.HomePageModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;


public class HomePageController{
	HomePageView view;
	HomePageModel model;
	 
	 public HomePageController(HomePageView view, HomePageModel model) {
		 this.view = view;
		 this.model = model;

		 //Radio Buttons Action Listener
		 this.view.rBtFullTimeLecturerListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view.rdbtnParttimeLecturer.setSelected(false);
				view.rdbtnContractLecturer.setSelected(false);			
				view.selectFullTimeLecturer.setVisible(true);
				view.selectPartTimeLecturer.setVisible(false);
				view.selectContractLecturer.setVisible(false);		
			}
		});
		 
		 this.view.rBtPartTimeLecturerListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					view.rdbtnFulltimeLecturer.setSelected(false);
					view.rdbtnContractLecturer.setSelected(false);				
					view.selectFullTimeLecturer.setVisible(false);
					view.selectPartTimeLecturer.setVisible(true);
					view.selectContractLecturer.setVisible(false);
				}
			});
		 
		 this.view.rBtContractLecturerListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					view.rdbtnFulltimeLecturer.setSelected(false);
					view.rdbtnParttimeLecturer.setSelected(false);	
					view.selectFullTimeLecturer.setVisible(false);
					view.selectPartTimeLecturer.setVisible(false);
					view.selectContractLecturer.setVisible(true);	
				}
			});
		  
		 //Navigation Panel Action Listener
		 this.view.lblHomeListener(new MouseAdapter() {
			 public void mouseClicked(MouseEvent e) {
				view.homePanel.setVisible(true);
				view.addDepartmentPanel.setVisible(false);
				view.viewDepartmentPanel.setVisible(false);
				view.addLecturerPanel.setVisible(false);
				view.viewFullTimeLecturerPanel.setVisible(false);
				view.viewPartTimeLecturerPanel.setVisible(false);
				view.viewContractLecturerPanel.setVisible(false);
			}
		}); 
		 
		 this.view.lblAddDepartmentListener(new MouseAdapter() {
			 public void mouseClicked(MouseEvent e) {
				view.btnAddDepartment.setVisible(true);
				view.homePanel.setVisible(false);
				view.addDepartmentPanel.setVisible(true);
				view.viewDepartmentPanel.setVisible(false);
				view.addLecturerPanel.setVisible(false);
				view.viewFullTimeLecturerPanel.setVisible(false);
				view.viewPartTimeLecturerPanel.setVisible(false);
				view.viewContractLecturerPanel.setVisible(false);
			}
		});
		 
		 this.view.lblViewDepartmentListener(new MouseAdapter() {
			 public void mouseClicked(MouseEvent e) {
				view.homePanel.setVisible(false);
				view.addDepartmentPanel.setVisible(false);
				view.viewDepartmentPanel.setVisible(true);
				view.addLecturerPanel.setVisible(false);
				view.viewFullTimeLecturerPanel.setVisible(false);
				view.viewPartTimeLecturerPanel.setVisible(false);
				view.viewContractLecturerPanel.setVisible(false);
			}
		});
		 
		 this.view.lblAddLecturerListener(new MouseAdapter() {
			 public void mouseClicked(MouseEvent e) {
				view.homePanel.setVisible(false);
				view.addDepartmentPanel.setVisible(false);
				view.viewDepartmentPanel.setVisible(false);
				view.addLecturerPanel.setVisible(true);
				view.viewFullTimeLecturerPanel.setVisible(false);
				view.viewPartTimeLecturerPanel.setVisible(false);
				view.viewContractLecturerPanel.setVisible(false);
			}
		});
		 
		 this.view.lblFullTimeLecturerListener(new MouseAdapter() {
			 public void mouseClicked(MouseEvent e) {
				view.homePanel.setVisible(false);
				view.addDepartmentPanel.setVisible(false);
				view.viewDepartmentPanel.setVisible(false);
				view.addLecturerPanel.setVisible(false);
				view.viewFullTimeLecturerPanel.setVisible(true);
				view.viewPartTimeLecturerPanel.setVisible(false);
				view.viewContractLecturerPanel.setVisible(false);
			}
		});
		 
		 this.view.lblPartTimeLecturerListener(new MouseAdapter() {
			 public void mouseClicked(MouseEvent e) {
				view.homePanel.setVisible(false);
				view.addDepartmentPanel.setVisible(false);
				view.viewDepartmentPanel.setVisible(false);
				view.addLecturerPanel.setVisible(false);
				view.viewFullTimeLecturerPanel.setVisible(false);
				view.viewPartTimeLecturerPanel.setVisible(true);
				view.viewContractLecturerPanel.setVisible(false);
			}
		});
		 
		 this.view.lblContractLecturerListener(new MouseAdapter() {
			 public void mouseClicked(MouseEvent e) {
				view.homePanel.setVisible(false);
				view.addDepartmentPanel.setVisible(false);
				view.viewDepartmentPanel.setVisible(false);
				view.addLecturerPanel.setVisible(false);
				view.viewFullTimeLecturerPanel.setVisible(false);
				view.viewPartTimeLecturerPanel.setVisible(false);
				view.viewContractLecturerPanel.setVisible(true);
			}
		});
		 
		 //log out listener
		 this.view.lblLogOutListener(new MouseAdapter() {
			 public void mouseClicked(MouseEvent e) {
				 LoginView lview = new LoginView();
				 LoginModel lmodel = new LoginModel();
				 new LoginController(lview,lmodel);
				 lview.setVisible(true);
				 
				 view.setVisible(false);
			 }
		});
		 
		 //Add Department
		 this.view.addDepartmentRowToTable(this.model.readDepartment());  //view department in the table
		 this.view.addDepartmentListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = view.getDepartmentId();
				String depName = view.getDepartmentName();
				String depType = view.getDepartmentType();
				String depAddress = view.getDepartmentAddress();
				String depUsername = view.getDepartmentUsername();
				String depPassword = view.getDepartmentPassword();
			
				model.addDepartment(id,depName, depType, depAddress, depUsername, depPassword);
				view.addDepartmentRowToTable(model.readDepartment()); //add department details in the table
				JOptionPane.showMessageDialog(null, "Department Added");
				view.clearDepartment(); 
			}
		});
		  
		 //Edit Department
		 this.view.editDepartmentListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				view.addDepartmentPanel.setVisible(true);
				view.btnAddDepartment.setVisible(false);
				view.btnUpdateDepartment.setVisible(true);
				view.viewDepartmentPanel.setVisible(false);
				view.departmentIdField.setText((view.viewDepartmentTable.getValueAt(view.viewDepartmentTable.getSelectedRow(), 0).toString()));
				view.departmentNameField.setText((view.viewDepartmentTable.getValueAt(view.viewDepartmentTable.getSelectedRow(), 1).toString()));
				view.departmentTypeField.setText((view.viewDepartmentTable.getValueAt(view.viewDepartmentTable.getSelectedRow(),2).toString()));
				view.departmentAddressField.setText((view.viewDepartmentTable.getValueAt(view.viewDepartmentTable.getSelectedRow(), 3).toString()));
				view.departmentUsernameField.setText((view.viewDepartmentTable.getValueAt(view.viewDepartmentTable.getSelectedRow(), 4).toString()));
				view.departmentPasswordField.setText((view.viewDepartmentTable.getValueAt(view.viewDepartmentTable.getSelectedRow(), 5).toString()));
			}
		});
		 this.view.updateDepartmentListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = view.getDepartmentId();
				String depName = view.getDepartmentName();
				String depType = view.getDepartmentType();
				String depAddress = view.getDepartmentAddress();
				String depUsername = view.getDepartmentUsername();
				String depPassword = view.getDepartmentPassword();
				
				model.editDepartment(id,depName, depType, depAddress, depUsername, depPassword);
				view.addDepartmentRowToTable(model.readDepartment()); //add department details in the table
				JOptionPane.showMessageDialog(null, "Department Updated");
				view.clearDepartment();
				
			}
		});
		 
		 //delete department
		 this.view.deleteDepartmentListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {			
					model.deleteDepartment(Integer.parseInt((view.viewDepartmentTable.getValueAt(view.viewDepartmentTable.getSelectedRow(), 0).toString())));
					JOptionPane.showMessageDialog(null, "Department Deleted");		
					view.addDepartmentRowToTable(model.readDepartment()); 				
				}
			});
		 
		 //Add Full Time Lecturer
		 this.view.addFullTimeLecturerRowToTable(this.model.readFullTimeLecturer()); 
		 this.view.addFullTimeLecturerListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = view.getLecturerId();
				String name = view.getLecturerName();
				String address = view.getLecturerAddress();
				String phoneno = view.getLeturerPhoneNum();
				String email = view.getLecturerEmail();
				String department = view.getLectDepartment();
				String type = view.getLecturerType();
				String startdate = view.getStartingDate();
				double salary = view.getFullTimeLecturerSalary();
				
				model.addFullTimeLecturer(id, name, address, phoneno, email, department, type, startdate, salary);
				view.addFullTimeLecturerRowToTable(model.readFullTimeLecturer()); 
				JOptionPane.showMessageDialog(null, "Full-Time Lecturer Added");
				view.clearLecturer();	
			}
		});
		 
		// Edit Full Time Lecturer
		 this.view.editFullTimeLecturerListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {	
					view.viewFullTimeLecturerPanel.setVisible(false);
					view.addLecturerPanel.setVisible(true);
					view.btnAddFullTimeLecturer.setVisible(false);
					view.btnUpdateFullTimeLecturer.setVisible(true);
					
					view.staffIdField.setText((view.viewFullTimeLecturerTable.getValueAt(view.viewFullTimeLecturerTable.getSelectedRow(), 0).toString()));
					view.lecturerNameField.setText((view.viewFullTimeLecturerTable.getValueAt(view.viewFullTimeLecturerTable.getSelectedRow(),1).toString()));
					view.lecturerAddressField.setText((view.viewFullTimeLecturerTable.getValueAt(view.viewFullTimeLecturerTable.getSelectedRow(), 2).toString()));
					view.phoneNumberField.setText((view.viewFullTimeLecturerTable.getValueAt(view.viewFullTimeLecturerTable.getSelectedRow(), 3).toString()));
					view.emailAddressField.setText((view.viewFullTimeLecturerTable.getValueAt(view.viewFullTimeLecturerTable.getSelectedRow(), 4).toString()));
					view.lectDepartmentField.setText((view.viewFullTimeLecturerTable.getValueAt(view.viewFullTimeLecturerTable.getSelectedRow(), 5).toString()));
//					view.rBtnLecturer.getSelection().getActionCommand();
					view.rdbtnFulltimeLecturer.setSelected(true);	
					view.rdbtnParttimeLecturer.setSelected(false);
					view.rdbtnContractLecturer.setSelected(false);
					view.dateStartedField.setText((view.viewFullTimeLecturerTable.getValueAt(view.viewFullTimeLecturerTable.getSelectedRow(), 7).toString()));
					view.fullTimeSalaryField.setText((view.viewFullTimeLecturerTable.getValueAt(view.viewFullTimeLecturerTable.getSelectedRow(), 8).toString()));
				}
			});
			 
			 this.view.updateFullTimeLecturerListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int id = view.getLecturerId();
					String name = view.getLecturerName();
					String address = view.getLecturerAddress();
					String phoneno = view.getLeturerPhoneNum();
					String email = view.getLecturerEmail();
					String department = view.getLectDepartment();
					String type = view.getLecturerType();
					String startdate = view.getStartingDate();
					double salary = view.getFullTimeLecturerSalary();
					
					model.editFullTimeLecturer(id, name, address, phoneno, email, department, type, startdate, salary);
					view.addFullTimeLecturerRowToTable(model.readFullTimeLecturer()); 
					JOptionPane.showMessageDialog(null, "Full-Time Lecturer Updated");
					view.clearLecturer();
					
				}
			});
			 //Delete Full Time Lecturer
			 this.view.deleteFullTimeLecturerListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {			
						model.deleteFullTimeLecturer(Integer.parseInt((view.viewFullTimeLecturerTable.getValueAt(view.viewFullTimeLecturerTable.getSelectedRow(), 0).toString())));
						JOptionPane.showMessageDialog(null, "Full-Time Lecturer Deleted");		
						view.addFullTimeLecturerRowToTable(model.readFullTimeLecturer()); 					
					}
				});
		 
		 
		 //Add Part Time Lecturer
		 this.view.addPartTimeLecturerRowToTable(this.model.readPartTimeLecturer()); 
		 this.view.addPartTimeLecturerListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = view.getLecturerId();
				String name = view.getLecturerName();
				String address = view.getLecturerAddress();
				String phoneno = view.getLeturerPhoneNum();
				String email = view.getLecturerEmail();
				String department = view.getLectDepartment();
				String type = view.getLecturerType();
				String startdate = view.getStartingDate();
				int hourlyrate = view.getPartTimeLecturerHRate();
				
				model.addPartTimeLecturer(id, name, address, phoneno, email, department, type, startdate, hourlyrate);
				view.addPartTimeLecturerRowToTable(model.readPartTimeLecturer()); 
				JOptionPane.showMessageDialog(null, "Part-Time Lecturer Added");
				view.clearLecturer();	
			}
		});
		 
		 //Edit Part Time Lecturer
		 this.view.editPartTimeLecturerListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {	
					view.viewPartTimeLecturerPanel.setVisible(false);
					view.addLecturerPanel.setVisible(true);
					view.btnAddPartTimeLecturer.setVisible(false);
					view.btnUpdatePartTimeLecturer.setVisible(true);
					
					view.staffIdField.setText((view.viewPartTimeLecturerTable.getValueAt(view.viewPartTimeLecturerTable.getSelectedRow(), 0).toString()));
					view.lecturerNameField.setText((view.viewPartTimeLecturerTable.getValueAt(view.viewPartTimeLecturerTable.getSelectedRow(),1).toString()));
					view.lecturerAddressField.setText((view.viewPartTimeLecturerTable.getValueAt(view.viewPartTimeLecturerTable.getSelectedRow(), 2).toString()));
					view.phoneNumberField.setText((view.viewPartTimeLecturerTable.getValueAt(view.viewPartTimeLecturerTable.getSelectedRow(), 3).toString()));
					view.emailAddressField.setText((view.viewPartTimeLecturerTable.getValueAt(view.viewPartTimeLecturerTable.getSelectedRow(), 4).toString()));
					view.lectDepartmentField.setText((view.viewPartTimeLecturerTable.getValueAt(view.viewPartTimeLecturerTable.getSelectedRow(), 5).toString()));
//					view.rBtnLecturer.getSelection().getActionCommand();
					view.rdbtnFulltimeLecturer.setSelected(false);	
					view.rdbtnParttimeLecturer.setSelected(true);
					view.rdbtnContractLecturer.setSelected(false);
					view.dateStartedField.setText((view.viewPartTimeLecturerTable.getValueAt(view.viewPartTimeLecturerTable.getSelectedRow(), 7).toString()));
					view.partTimeHRField.setText((view.viewPartTimeLecturerTable.getValueAt(view.viewPartTimeLecturerTable.getSelectedRow(), 8).toString()));
				}
			});
			 
			 this.view.updatePartTimeLecturerListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int id = view.getLecturerId();
					String name = view.getLecturerName();
					String address = view.getLecturerAddress();
					String phoneno = view.getLeturerPhoneNum();
					String email = view.getLecturerEmail();
					String department = view.getLectDepartment();
					String type = view.getLecturerType();
					String startdate = view.getStartingDate();
					int hourlyrate = view.getPartTimeLecturerHRate();
					
					model.editPartTimeLecturer(id, name, address, phoneno, email, department, type, startdate, hourlyrate);
					view.addPartTimeLecturerRowToTable(model.readPartTimeLecturer()); 
					JOptionPane.showMessageDialog(null, "Part-Time Lecturer Updated");
					view.clearLecturer();
					
				}
			});
			 //Delete Part Time Lecturer
			 this.view.deletePartTimeLecturerListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {			
						model.deletePartTimeLecturer(Integer.parseInt((view.viewPartTimeLecturerTable.getValueAt(view.viewPartTimeLecturerTable.getSelectedRow(), 0).toString())));
						JOptionPane.showMessageDialog(null, "Part-Time Lecturer Deleted");		
						view.addPartTimeLecturerRowToTable(model.readPartTimeLecturer()); 					
					}
				});
	
		 //Add Contract Lecturer
		 this.view.addContractLecturerRowToTable(this.model.readContractLecturer()); 
		 this.view.addContractLecturerListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = view.getLecturerId();
				String name = view.getLecturerName();
				String address = view.getLecturerAddress();
				String phoneno = view.getLeturerPhoneNum();
				String email = view.getLecturerEmail();
				String department = view.getLectDepartment();
				String type = view.getLecturerType();
				String startdate = view.getStartingDate();
				double salary = view.getContractTimeLecturerSalary();
				String enddate = view.getContractEndDate();
				
				model.addContractLecturer(id, name, address, phoneno, email, department, type, startdate, salary, enddate);
				view.addContractLecturerRowToTable(model.readContractLecturer()); 
				JOptionPane.showMessageDialog(null, "Contract Lecturer Added");
				view.clearLecturer();	
			}
		});
		 
			// Edit Contract Lecturer
		 this.view.editContractLecturerListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {	
					view.viewContractLecturerPanel.setVisible(false);
					view.addLecturerPanel.setVisible(true);
					view.btnAddContractLecturer.setVisible(false);
					view.btnUpdateContractLecturer.setVisible(true);
					
					view.staffIdField.setText((view.viewContractLecturerTable.getValueAt(view.viewContractLecturerTable.getSelectedRow(), 0).toString()));
					view.lecturerNameField.setText((view.viewContractLecturerTable.getValueAt(view.viewContractLecturerTable.getSelectedRow(),1).toString()));
					view.lecturerAddressField.setText((view.viewContractLecturerTable.getValueAt(view.viewContractLecturerTable.getSelectedRow(), 2).toString()));
					view.phoneNumberField.setText((view.viewContractLecturerTable.getValueAt(view.viewContractLecturerTable.getSelectedRow(), 3).toString()));
					view.emailAddressField.setText((view.viewContractLecturerTable.getValueAt(view.viewContractLecturerTable.getSelectedRow(), 4).toString()));
					view.lectDepartmentField.setText((view.viewContractLecturerTable.getValueAt(view.viewContractLecturerTable.getSelectedRow(), 5).toString()));
//					view.rBtnLecturer.getSelection().getActionCommand();
					view.rdbtnFulltimeLecturer.setSelected(false);	
					view.rdbtnParttimeLecturer.setSelected(false);
					view.rdbtnContractLecturer.setSelected(true);
					view.dateStartedField.setText((view.viewContractLecturerTable.getValueAt(view.viewContractLecturerTable.getSelectedRow(), 7).toString()));
					view.contractSalaryField.setText((view.viewContractLecturerTable.getValueAt(view.viewContractLecturerTable.getSelectedRow(), 8).toString()));
					view.contractEndDateField.setText((view.viewContractLecturerTable.getValueAt(view.viewContractLecturerTable.getSelectedRow(), 9).toString()));
				}
			});
			 
			 this.view.updateContractLecturerListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int id = view.getLecturerId();
					String name = view.getLecturerName();
					String address = view.getLecturerAddress();
					String phoneno = view.getLeturerPhoneNum();
					String email = view.getLecturerEmail();
					String department = view.getLectDepartment();
					String type = view.getLecturerType();
					String startdate = view.getStartingDate();
					double salary = view.getContractTimeLecturerSalary();
					String enddate = view.getContractEndDate();
					
					model.editContractLecturer(id, name, address, phoneno, email, department, type, startdate, salary,enddate);
					view.addContractLecturerRowToTable(model.readContractLecturer()); 
					JOptionPane.showMessageDialog(null, "Contract Lecturer Updated");
					view.clearLecturer();
					
				}
			});
			 //Delete Contract Lecturer
			 this.view.deleteContractLecturerListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {			
						model.deleteContractLecturer(Integer.parseInt((view.viewContractLecturerTable.getValueAt(view.viewContractLecturerTable.getSelectedRow(), 0).toString())));
						JOptionPane.showMessageDialog(null, "Contract Lecturer Deleted");		
						view.addContractLecturerRowToTable(model.readContractLecturer()); 					
					}
				});
		 
	 }
		
}
