package homepage;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import department.ContractLecturer;
import department.Department;
import department.FullTimeLecturer;
import department.PartTimeLecturer;

public class HomePageView extends JFrame{
	public JPanel navPanel, displayPanel, homePanel, addDepartmentPanel, viewDepartmentPanel, addLecturerPanel, viewFullTimeLecturerPanel, viewPartTimeLecturerPanel, viewContractLecturerPanel, selectLecturerPanel;
	private JLabel lblHome, lblWelcome, lblAddDepartment, lblViewDepartment, lblAddLecturer, lblLogOut;
	public JTable viewDepartmentTable, viewFullTimeLecturerTable, viewPartTimeLecturerTable, viewContractLecturerTable;
	public JTextField departmentIdField,departmentNameField, departmentTypeField, departmentAddressField, departmentUsernameField, departmentPasswordField, staffIdField, lecturerNameField, lecturerAddressField, phoneNumberField, emailAddressField, lectDepartmentField , dateStartedField;
	public JButton btnAddDepartment, btnEditDepartment, btnUpdateDepartment, btnDeleteDepartment, btnAddFullTimeLecturer, btnAddPartTimeLecturer, btnAddContractLecturer, btnEditFullTimeLecturer, btnUpdateFullTimeLecturer, btnDeleteFullTimeLecturer, btnEditPartTimeLecturer, btnUpdatePartTimeLecturer, btnDeletePartTimeLecturer, btnEditContractLecturer, btnUpdateContractLecturer, btnDeleteContractLecturer;
	private JLabel lblDepartmentId, lblAddDptment, lblDepartmentName, lblTypeOfDepartment, lblDepartmentAddress, lblUsername, lblPassword, lblViewDpment;
	private JLabel lblAddLecturerInPanel, lblStaffIdentificationNumber, lblLecturerName, lblLecturerAddress, lblPhoneNumber, lblEmailAddress, lblLectDepartment, lblDateStarted, lblLecturerType, lblFullTimeLecturer, lblPartTimeLecturer, lblContractLecturer, lblFullTimeSalary, lblPartTimeHR, lblContractSalary, lblContractEndDate;;;
	public JTextField fullTimeSalaryField, partTimeHRField, contractSalaryField, contractEndDateField;
	private JScrollPane departmentScrollPane, fullTimeLecturerScrollPane, partTimeLecturerScrollPane, contractLecturerScrollPane;
	private Color tabColor, tabColor1;
	public JRadioButton rdbtnFulltimeLecturer, rdbtnParttimeLecturer, rdbtnContractLecturer;
	private JLabel  lblNavFullTimeLecturer, lblNavPartTimeLecturer, lblNavContractLecturer, lblViewFullTimeLecturer, lblViewPartTimeLecturer, lblViewContractLecturer;
	public Panel selectFullTimeLecturer, selectPartTimeLecturer, selectContractLecturer;
	public ButtonGroup rBtnLecturer;
	public DefaultTableModel tf, ftf, ctf, ptf;
	
	public HomePageView() {
		this.setSize(1200,700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.getContentPane().setLayout(null);
		
		tabColor = new Color (253, 245, 230);
		tabColor1 = new Color (224, 185, 42);
		
		//Navigation Panel
		navPanel = new JPanel();
		navPanel.setBackground(tabColor1);
		navPanel.setBounds(0, 0, 220, 665);
		this.getContentPane().add(navPanel);
		navPanel.setLayout(null);
		
		lblHome = new JLabel("Home");
		lblHome.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblHome.setBounds(55, 50, 70, 35);
		navPanel.add(lblHome);
		
		lblAddDepartment = new JLabel("Add Department");
		lblAddDepartment.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAddDepartment.setBounds(25, 120, 180, 52);
		navPanel.add(lblAddDepartment);
		
		lblViewDepartment = new JLabel("View Department");
		lblViewDepartment.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblViewDepartment.setBounds(25, 180, 180, 45);
		navPanel.add(lblViewDepartment);
		
		lblAddLecturer = new JLabel("Add Lecturer");
		lblAddLecturer.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAddLecturer.setBounds(25, 240, 135, 45);
		navPanel.add(lblAddLecturer);
		
		lblNavFullTimeLecturer = new JLabel("Full-Time Lecturer");
		lblNavFullTimeLecturer.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNavFullTimeLecturer.setBounds(25, 300, 200, 45);
		navPanel.add(lblNavFullTimeLecturer);
		
		lblNavPartTimeLecturer = new JLabel("Part-Time Lecturer");
		lblNavPartTimeLecturer.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNavPartTimeLecturer.setBounds(25, 360, 200, 45);
		navPanel.add(lblNavPartTimeLecturer);
		
		lblNavContractLecturer = new JLabel("Contract Lecturer");
		lblNavContractLecturer.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNavContractLecturer.setBounds(25, 420, 200, 45);
		navPanel.add(lblNavContractLecturer);
		
		lblLogOut = new JLabel("Log Out");
		lblLogOut.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblLogOut.setBounds(50, 520, 110, 45);
		navPanel.add(lblLogOut);
		
		//Display Panel
		displayPanel = new JPanel();
		displayPanel.setBackground(Color.CYAN);
		displayPanel.setBounds(220, 0, 980, 665);
		this.getContentPane().add(displayPanel);	
		displayPanel.setLayout(new CardLayout(0, 0));
		
		
		//HOME
		homePanel = new JPanel();
		homePanel.setBackground(tabColor);
		homePanel.setLayout(null);
		this.getContentPane().add(homePanel);
		
		lblWelcome = new JLabel("<html>Welcome To Northampton <br/>  Metropolitan University</html>");
		lblWelcome.setFont(new Font("Tahoma", Font.BOLD + Font.ITALIC, 50));
		lblWelcome.setBounds(120, 100, 800, 350);
		homePanel.add(lblWelcome);
		
		
		//ADD DEPARTMENT

		addDepartmentPanel = new JPanel();
		addDepartmentPanel.setBackground(tabColor);
		addDepartmentPanel.setLayout(null);
		this.getContentPane().add(addDepartmentPanel);
		
		lblAddDptment = new JLabel("Add Department");
		lblAddDptment.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAddDptment.setBounds(235, 35, 195, 37);
		addDepartmentPanel.add(lblAddDptment);
		
		lblDepartmentId = new JLabel("Department Id");
		lblDepartmentId.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDepartmentId.setBounds(50, 90, 180, 40);
		addDepartmentPanel.add(lblDepartmentId);
		
		departmentIdField = new JTextField();
		departmentIdField.setBounds(50, 125, 150, 25);
		addDepartmentPanel.add(departmentIdField);
		departmentIdField.setColumns(10);
		
		lblDepartmentName = new JLabel("Department Name");
		lblDepartmentName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDepartmentName.setBounds(50, 165, 180, 40);
		addDepartmentPanel.add(lblDepartmentName);
		
		departmentNameField = new JTextField();
		departmentNameField.setBounds(50, 200, 180, 25);
		addDepartmentPanel.add(departmentNameField);
		departmentNameField.setColumns(10);
		
		lblTypeOfDepartment = new JLabel("Type Of Department");
		lblTypeOfDepartment.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTypeOfDepartment.setBounds(50, 240, 195, 25);
		addDepartmentPanel.add(lblTypeOfDepartment);
		
		departmentTypeField = new JTextField();
		departmentTypeField.setColumns(10);
		departmentTypeField.setBounds(50, 275, 180, 25);
		addDepartmentPanel.add(departmentTypeField);
		
		lblDepartmentAddress = new JLabel("Address");
		lblDepartmentAddress.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDepartmentAddress.setBounds(50, 315, 120, 25);
		addDepartmentPanel.add(lblDepartmentAddress);
		
		departmentAddressField = new JTextField();
		departmentAddressField.setColumns(10);
		departmentAddressField.setBounds(50, 345, 180, 25);
		addDepartmentPanel.add(departmentAddressField);
		
		lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUsername.setBounds(50, 385, 120, 25);
		addDepartmentPanel.add(lblUsername);
		
		departmentUsernameField = new JTextField();
		departmentUsernameField.setColumns(10);
		departmentUsernameField.setBounds(53, 420, 180, 25);
		addDepartmentPanel.add(departmentUsernameField);
		
		lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPassword.setBounds(50, 460, 120, 25);
		addDepartmentPanel.add(lblPassword);
		
		departmentPasswordField = new JTextField();
		departmentPasswordField.setColumns(10);
		departmentPasswordField.setBounds(50, 495, 180, 25);
		addDepartmentPanel.add(departmentPasswordField);
		
		btnAddDepartment = new JButton("Add Department");
		btnAddDepartment.setBackground(Color.LIGHT_GRAY);
		btnAddDepartment.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAddDepartment.setBounds(61, 545, 157, 37);
		addDepartmentPanel.add(btnAddDepartment);
		
		btnUpdateDepartment = new JButton("Update");
		btnUpdateDepartment.setBackground(Color.LIGHT_GRAY);
		btnUpdateDepartment.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnUpdateDepartment.setBounds(61, 545, 100, 37);
		btnUpdateDepartment.setVisible(false);
		addDepartmentPanel.add(btnUpdateDepartment);
		
		
		//VIEW DEPARTMENT
		viewDepartmentPanel = new JPanel();
		viewDepartmentPanel.setBackground(Color.orange);
		viewDepartmentPanel.setLayout(null);
		this.getContentPane().add(viewDepartmentPanel);
		
		lblViewDpment = new JLabel("View Department");
		lblViewDpment.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblViewDpment.setBounds(215, 40, 200, 25);
		viewDepartmentPanel.add(lblViewDpment);
		
		btnEditDepartment = new JButton("Edit");
		btnEditDepartment.setBackground(Color.yellow);
		btnEditDepartment.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEditDepartment.setBounds(100, 610, 70, 40);
		viewDepartmentPanel.add(btnEditDepartment);
		
		btnDeleteDepartment = new JButton("Delete");
		btnDeleteDepartment.setBackground(Color.red);
		btnDeleteDepartment.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDeleteDepartment.setBounds(200, 610, 100, 40);
		viewDepartmentPanel.add(btnDeleteDepartment);
		
		
		viewDepartmentTable = new JTable();
		departmentScrollPane = new JScrollPane(viewDepartmentTable);
		departmentScrollPane.setBounds(1, 100, 965, 500);
		departmentScrollPane.getViewport().setBackground(tabColor);
		viewDepartmentPanel.add(departmentScrollPane);
		
		
		//ADD LECTURER
		addLecturerPanel = new JPanel();
		addLecturerPanel.setBackground(tabColor);
		addLecturerPanel.setLayout(null);
		this.getContentPane().add(addLecturerPanel);
		
		lblAddLecturerInPanel = new JLabel("Add Lecturer");
		lblAddLecturerInPanel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAddLecturerInPanel.setBounds(210, 23, 145, 25);
		addLecturerPanel.add(lblAddLecturerInPanel);
		
		lblStaffIdentificationNumber = new JLabel("Staff Identification Number");
		lblStaffIdentificationNumber.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblStaffIdentificationNumber.setBounds(40, 70, 250, 25);
		addLecturerPanel.add(lblStaffIdentificationNumber);
		
		staffIdField = new JTextField();
		staffIdField.setBounds(310, 70, 120, 25);
		addLecturerPanel.add(staffIdField);
		staffIdField.setColumns(10);
		
		lblLecturerName = new JLabel("Name");
		lblLecturerName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLecturerName.setBounds(40, 115, 80, 25);
		addLecturerPanel.add(lblLecturerName);
		
		lecturerNameField = new JTextField();
		lecturerNameField.setColumns(10);
		lecturerNameField.setBounds(190, 115, 240, 25);
		addLecturerPanel.add(lecturerNameField);
		
		lblLecturerAddress = new JLabel("Address");
		lblLecturerAddress.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLecturerAddress.setBounds(40, 155, 80, 25);
		addLecturerPanel.add(lblLecturerAddress);
		
		lecturerAddressField = new JTextField();
		lecturerAddressField.setColumns(10);
		lecturerAddressField.setBounds(190, 155, 240, 25);
		addLecturerPanel.add(lecturerAddressField);
		
		lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPhoneNumber.setBounds(40, 200, 150, 25);
		addLecturerPanel.add(lblPhoneNumber);
		
		phoneNumberField = new JTextField();
		phoneNumberField.setColumns(10);
		phoneNumberField.setBounds(190, 200, 240, 25);
		addLecturerPanel.add(phoneNumberField);
		
		lblEmailAddress = new JLabel("Email Address");
		lblEmailAddress.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEmailAddress.setBounds(40, 245, 150, 25);
		addLecturerPanel.add(lblEmailAddress);
		
		emailAddressField = new JTextField();
		emailAddressField.setColumns(10);
		emailAddressField.setBounds(190, 245, 240, 25);
		addLecturerPanel.add(emailAddressField);
		
		lblLectDepartment = new JLabel("Department");
		lblLectDepartment.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLectDepartment.setBounds(40, 290, 150, 25);
		addLecturerPanel.add(lblLectDepartment);
		
		lectDepartmentField = new JTextField();
		lectDepartmentField.setColumns(10);
		lectDepartmentField.setBounds(190, 290, 240, 25);
		addLecturerPanel.add(lectDepartmentField);
		
		lblDateStarted = new JLabel("Starting Date");
		lblDateStarted.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDateStarted.setBounds(40, 420, 150, 25);
		addLecturerPanel.add(lblDateStarted);
		
		dateStartedField = new JTextField();
		dateStartedField.setColumns(10);
		dateStartedField.setBounds(190, 420, 240, 25);
		addLecturerPanel.add(dateStartedField);
		
		lblLecturerType = new JLabel("Lecturer Type");
		lblLecturerType.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLecturerType.setBounds(40, 340, 150, 25);
		addLecturerPanel.add(lblLecturerType);
		
		rdbtnFulltimeLecturer = new JRadioButton();
		rdbtnFulltimeLecturer.setSelected(true);
		rdbtnFulltimeLecturer.setActionCommand("Full-Time Lecturer");
		rdbtnFulltimeLecturer.setBounds(45, 370, 20, 25);
		
		lblFullTimeLecturer = new JLabel("Full-time Lecturer");
		lblFullTimeLecturer.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFullTimeLecturer.setBounds(65, 370, 125, 25);
		addLecturerPanel.add(lblFullTimeLecturer);
		
		rdbtnParttimeLecturer = new JRadioButton();
		rdbtnParttimeLecturer.setActionCommand("Part-Time Lecturer");
		rdbtnParttimeLecturer.setBounds(200, 370, 20, 25);
		
		lblPartTimeLecturer = new JLabel("Part-time Lecturer");
		lblPartTimeLecturer.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPartTimeLecturer.setBounds(220, 370, 125, 25);
		addLecturerPanel.add(lblPartTimeLecturer);
		
		rdbtnContractLecturer = new JRadioButton();
		rdbtnContractLecturer.setActionCommand("Contract Lecturer");
		rdbtnContractLecturer.setBounds(360, 370, 20, 25);
		
		lblContractLecturer = new JLabel("Contract Lecturer");
		lblContractLecturer.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblContractLecturer.setBounds(380, 370, 125, 25);
		addLecturerPanel.add(lblContractLecturer);
		
		//Add radio buttons to Button Group
		rBtnLecturer = new ButtonGroup();
		rBtnLecturer.add(rdbtnFulltimeLecturer);
		rBtnLecturer.add(rdbtnParttimeLecturer);
		rBtnLecturer.add(rdbtnContractLecturer);
		addLecturerPanel.add(rdbtnFulltimeLecturer);
		addLecturerPanel.add(rdbtnParttimeLecturer);
		addLecturerPanel.add(rdbtnContractLecturer);

		
		//creating new Jpanel to add multiple panel
		selectLecturerPanel = new JPanel();
		selectLecturerPanel.setBounds(0, 460, 980, 205);
		selectLecturerPanel.setBackground(tabColor);
		addLecturerPanel.add(selectLecturerPanel);
		selectLecturerPanel.setLayout(new CardLayout(0, 0));
		
		selectFullTimeLecturer = new Panel();
		selectFullTimeLecturer.setLayout(null);
		selectLecturerPanel.add(selectFullTimeLecturer);
		
		lblFullTimeSalary = new JLabel("Salary");
		lblFullTimeSalary.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblFullTimeSalary.setBounds(40, 5, 100, 25);
		selectFullTimeLecturer.add(lblFullTimeSalary);
		
	    fullTimeSalaryField = new JTextField();
		fullTimeSalaryField.setColumns(10);
		fullTimeSalaryField.setBounds(190, 5, 240, 25);
		selectFullTimeLecturer.add(fullTimeSalaryField);
		
		btnAddFullTimeLecturer = new JButton("Add Lecturer");
		btnAddFullTimeLecturer.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAddFullTimeLecturer.setBounds(100, 120, 150, 50);
		selectFullTimeLecturer.add(btnAddFullTimeLecturer);
		
		btnUpdateFullTimeLecturer = new JButton("Update");
		btnUpdateFullTimeLecturer.setBackground(Color.LIGHT_GRAY);
		btnUpdateFullTimeLecturer.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnUpdateFullTimeLecturer.setBounds(100, 120, 150, 50);
		btnUpdateFullTimeLecturer.setVisible(false);
		selectFullTimeLecturer.add(btnUpdateFullTimeLecturer);
		
		
		selectPartTimeLecturer = new Panel();
		selectPartTimeLecturer.setLayout(null);
		selectLecturerPanel.add(selectPartTimeLecturer);
		
		lblPartTimeHR = new JLabel("Hourly Rate");
		lblPartTimeHR.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPartTimeHR.setBounds(40, 5, 150, 25);
		selectPartTimeLecturer.add(lblPartTimeHR);
		
		partTimeHRField = new JTextField();
		partTimeHRField.setColumns(10);
		partTimeHRField.setBounds(190, 5, 240, 25);
		selectPartTimeLecturer.add(partTimeHRField);
		
		btnAddPartTimeLecturer = new JButton("Add Lecturer");
		btnAddPartTimeLecturer.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAddPartTimeLecturer.setBounds(100, 120, 150, 50);
		selectPartTimeLecturer.add(btnAddPartTimeLecturer);
		
		btnUpdatePartTimeLecturer = new JButton("Update");
		btnUpdatePartTimeLecturer.setBackground(Color.LIGHT_GRAY);
		btnUpdatePartTimeLecturer.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnUpdatePartTimeLecturer.setBounds(100, 120, 150, 50);
		btnUpdatePartTimeLecturer.setVisible(false);
		selectPartTimeLecturer.add(btnUpdatePartTimeLecturer);
		
		selectContractLecturer = new Panel();
		selectContractLecturer.setLayout(null);
		selectLecturerPanel.add(selectContractLecturer);
		
		lblContractSalary = new JLabel("Salary");
		lblContractSalary.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblContractSalary.setBounds(40, 5, 100, 25);
		selectContractLecturer.add(lblContractSalary);
		
		contractSalaryField = new JTextField();
		contractSalaryField.setColumns(10);
		contractSalaryField.setBounds(190, 5, 240, 25);
		selectContractLecturer.add(contractSalaryField);
		
		lblContractEndDate = new JLabel("End Date");
		lblContractEndDate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblContractEndDate.setBounds(40, 60, 100, 25);
		selectContractLecturer.add(lblContractEndDate);
		
		contractEndDateField = new JTextField();
		contractEndDateField.setColumns(10);
		contractEndDateField.setBounds(190, 60, 240, 25);
		selectContractLecturer.add(contractEndDateField);
		
		btnAddContractLecturer = new JButton("Add Lecturer");
		btnAddContractLecturer.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAddContractLecturer.setBounds(100, 120, 150, 50);
		selectContractLecturer.add(btnAddContractLecturer);
		
		btnUpdateContractLecturer = new JButton("Update");
		btnUpdateContractLecturer.setBackground(Color.LIGHT_GRAY);
		btnUpdateContractLecturer.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnUpdateContractLecturer.setBounds(100, 120, 150, 50);
		btnUpdateContractLecturer.setVisible(false);
		selectContractLecturer.add(btnUpdateContractLecturer);
				
		
		//VIEW LECTURER
		viewFullTimeLecturerPanel = new JPanel();
		viewFullTimeLecturerPanel.setBackground(Color.ORANGE);
		viewFullTimeLecturerPanel.setLayout(null);
		this.getContentPane().add(viewFullTimeLecturerPanel);
		
		viewPartTimeLecturerPanel = new JPanel();
		viewPartTimeLecturerPanel.setBackground(Color.ORANGE);
		viewPartTimeLecturerPanel.setLayout(null);
		this.getContentPane().add(viewPartTimeLecturerPanel);
		
		viewContractLecturerPanel = new JPanel();
		viewContractLecturerPanel.setBackground(Color.ORANGE);
		viewContractLecturerPanel.setLayout(null);
		this.getContentPane().add(viewContractLecturerPanel);
		
		lblViewFullTimeLecturer = new JLabel("Full-Time Lecturer");
		lblViewFullTimeLecturer.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblViewFullTimeLecturer.setBounds(215, 40, 200, 25);
		viewFullTimeLecturerPanel.add(lblViewFullTimeLecturer);
		
		viewFullTimeLecturerTable = new JTable();
		fullTimeLecturerScrollPane = new JScrollPane(viewFullTimeLecturerTable);
		fullTimeLecturerScrollPane.setBounds(1, 100, 965, 500);
		fullTimeLecturerScrollPane.getViewport().setBackground(tabColor);
		viewFullTimeLecturerPanel.add(fullTimeLecturerScrollPane);
		
		btnEditFullTimeLecturer = new JButton("Edit");
		btnEditFullTimeLecturer.setBackground(Color.yellow);
		btnEditFullTimeLecturer.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEditFullTimeLecturer.setBounds(100, 610, 70, 40);
		viewFullTimeLecturerPanel.add(btnEditFullTimeLecturer);
		
		btnDeleteFullTimeLecturer = new JButton("Delete");
		btnDeleteFullTimeLecturer.setBackground(Color.red);
		btnDeleteFullTimeLecturer.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDeleteFullTimeLecturer.setBounds(200, 610, 100, 40);
		viewFullTimeLecturerPanel.add(btnDeleteFullTimeLecturer);
		
		lblViewPartTimeLecturer = new JLabel("Part-Time Lecturer");
		lblViewPartTimeLecturer.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblViewPartTimeLecturer.setBounds(215, 40, 200, 25);
		viewPartTimeLecturerPanel.add(lblViewPartTimeLecturer);
		
		viewPartTimeLecturerTable = new JTable();
		partTimeLecturerScrollPane = new JScrollPane(viewPartTimeLecturerTable);
		partTimeLecturerScrollPane.setBounds(1, 100, 965, 500);
		partTimeLecturerScrollPane.getViewport().setBackground(tabColor);
		viewPartTimeLecturerPanel.add(partTimeLecturerScrollPane);
		
		btnEditPartTimeLecturer = new JButton("Edit");
		btnEditPartTimeLecturer.setBackground(Color.yellow);
		btnEditPartTimeLecturer.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEditPartTimeLecturer.setBounds(100, 610, 70, 40);
		viewPartTimeLecturerPanel.add(btnEditPartTimeLecturer);
		
		btnDeletePartTimeLecturer = new JButton("Delete");
		btnDeletePartTimeLecturer.setBackground(Color.red);
		btnDeletePartTimeLecturer.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDeletePartTimeLecturer.setBounds(200, 610, 100, 40);
		viewPartTimeLecturerPanel.add(btnDeletePartTimeLecturer);
		
		lblViewContractLecturer = new JLabel("Contract Lecturer");
		lblViewContractLecturer.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblViewContractLecturer.setBounds(215, 40, 200, 25);
		viewContractLecturerPanel.add(lblViewContractLecturer);
		
		viewContractLecturerTable = new JTable();
		contractLecturerScrollPane = new JScrollPane(viewContractLecturerTable);
		contractLecturerScrollPane.setBounds(1, 100, 965, 500);
		contractLecturerScrollPane.getViewport().setBackground(tabColor);
		viewContractLecturerPanel.add(contractLecturerScrollPane);
		
		btnEditContractLecturer = new JButton("Edit");
		btnEditContractLecturer.setBackground(Color.yellow);
		btnEditContractLecturer.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEditContractLecturer.setBounds(100, 610, 70, 40);
		viewContractLecturerPanel.add(		btnEditContractLecturer);
		 
		btnDeleteContractLecturer = new JButton("Delete");
		btnDeleteContractLecturer.setBackground(Color.red);
		btnDeleteContractLecturer.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDeleteContractLecturer.setBounds(200, 610, 100, 40);
		viewContractLecturerPanel.add(btnDeleteContractLecturer);
			
		
		//Add to display panel
		displayPanel.add(homePanel);
		displayPanel.add(addDepartmentPanel);
		displayPanel.add(viewDepartmentPanel);
		displayPanel.add(addLecturerPanel);
		displayPanel.add(viewFullTimeLecturerPanel);
		displayPanel.add(viewPartTimeLecturerPanel);
		displayPanel.add(viewContractLecturerPanel);
		
		//calling method to create the column of table
		createDepartmentTableColumn();
		createFullTimeLecturerTableColumn();
		createPartTimeLecturerTableColumn();
		createContractLecturerTableColumn();
	}
	
	//method to create department table column
	public void createDepartmentTableColumn() {
		tf = (DefaultTableModel) viewDepartmentTable.getModel();
		tf.addColumn("Id");
		tf.addColumn("Name");
		tf.addColumn("Type");
		tf.addColumn("Address");
		tf.addColumn("Username");
		tf.addColumn("Password");
	}
	
	//method to add row in the department table
	public void addDepartmentRowToTable(ArrayList<Department> d) {
		tf = (DefaultTableModel) viewDepartmentTable.getModel();
		tf.setRowCount(0);
		for(int i=0; i<d.size(); i++ ) {		
			tf.addRow(new Object[] {d.get(i).id,d.get(i).name, d.get(i).type, d.get(i).address, d.get(i).username,d.get(i).password});
		}
	}
	
	//method to create full time lecturer table column
	public void createFullTimeLecturerTableColumn() {
		ftf = (DefaultTableModel) viewFullTimeLecturerTable.getModel();
		ftf.addColumn("Id");
		ftf.addColumn("Name");
		ftf.addColumn("Address");
		ftf.addColumn("Phone No");
		ftf.addColumn("Email");
		ftf.addColumn("Department");
		ftf.addColumn("Type");
		ftf.addColumn("Starting Date");
		ftf.addColumn("Salary");
	}
	
	//method to add full row time lecturer in the table
	public void addFullTimeLecturerRowToTable(ArrayList<FullTimeLecturer> d) {
		ftf = (DefaultTableModel) viewFullTimeLecturerTable.getModel();
		ftf.setRowCount(0);
		for(int i=0; i<d.size(); i++ ) {
			ftf.addRow(new Object[] {d.get(i).id, d.get(i).name, d.get(i).address, d.get(i).phoneno,d.get(i).email, d.get(i).department, d.get(i).type, d.get(i).startdate,d.get(i).salary});
		}
	}
	
	//method to create part time lecturer table column
	public void createPartTimeLecturerTableColumn() {
		ptf = (DefaultTableModel) viewPartTimeLecturerTable.getModel();
		ptf.addColumn("Id");
		ptf.addColumn("Name");
		ptf.addColumn("Address");
		ptf.addColumn("Phone No");
		ptf.addColumn("Email");
		ptf.addColumn("Department");
		ptf.addColumn("Type");
		ptf.addColumn("Starting Date");
		ptf.addColumn("Hourly Rate");
	}
	
	//method to add part row time lecturer in the table
	public void addPartTimeLecturerRowToTable(ArrayList<PartTimeLecturer> d) {
		ptf = (DefaultTableModel) viewPartTimeLecturerTable.getModel();
		ptf.setRowCount(0);
		for(int i=0; i<d.size(); i++ ) {
			ptf.addRow(new Object[] {d.get(i).id, d.get(i).name, d.get(i).address, d.get(i).phoneno,d.get(i).email, d.get(i).department, d.get(i).type, d.get(i).startdate,d.get(i).hourlyrate});
		}
	}
	
	//method to create contract lecturer table column
	public void createContractLecturerTableColumn() {
		ctf = (DefaultTableModel) viewContractLecturerTable.getModel();
		ctf.addColumn("Id");
		ctf.addColumn("Name");
		ctf.addColumn("Address");
		ctf.addColumn("Phone No");
		ctf.addColumn("Email");
		ctf.addColumn("Department");
		ctf.addColumn("Type");
		ctf.addColumn("Starting Date");
		ctf.addColumn("Salary");
		ctf.addColumn("End Date");
	}
	
	//method to add part contract lecturer in the table
	public void addContractLecturerRowToTable(ArrayList<ContractLecturer> d) {
		ctf = (DefaultTableModel) viewContractLecturerTable.getModel();
		ctf.setRowCount(0);
		for(int i=0; i<d.size(); i++ ) {
			ctf.addRow(new Object[] {d.get(i).id, d.get(i).name, d.get(i).address, d.get(i).phoneno,d.get(i).email, d.get(i).department, d.get(i).type, d.get(i).startdate,d.get(i).salary, d.get(i).enddate});
		}
	}
	
	//Nav Label
	public void lblHomeListener(MouseAdapter listen) {
		lblHome.addMouseListener(listen);
	}
	public void lblAddDepartmentListener(MouseAdapter listen) {
		lblAddDepartment.addMouseListener(listen);
	}
	public void lblViewDepartmentListener(MouseAdapter listen) {
		lblViewDepartment.addMouseListener(listen);
	}
	public void lblAddLecturerListener(MouseAdapter listen) {
		lblAddLecturer.addMouseListener(listen);
	}
	public void lblFullTimeLecturerListener(MouseAdapter listen) {
		lblNavFullTimeLecturer.addMouseListener(listen);
	}
	public void lblPartTimeLecturerListener(MouseAdapter listen) {
		lblNavPartTimeLecturer.addMouseListener(listen);
	}
	public void lblContractLecturerListener(MouseAdapter listen) {
		lblNavContractLecturer.addMouseListener(listen);
	}
	public void lblLogOutListener(MouseAdapter listen) {
		lblLogOut.addMouseListener(listen);
	}
	
	//RadioButton
	public void rBtFullTimeLecturerListener(ActionListener listen) {
		rdbtnFulltimeLecturer.addActionListener(listen);
	}
	public void rBtPartTimeLecturerListener(ActionListener listen) {
		rdbtnParttimeLecturer.addActionListener(listen);
	}
	public void rBtContractLecturerListener(ActionListener listen) {
		rdbtnContractLecturer.addActionListener(listen);
	}
	
	//JButton
	public void addDepartmentListener(ActionListener listen){
		btnAddDepartment.addActionListener(listen);
	}
	public void editDepartmentListener(ActionListener listen) {
		btnEditDepartment.addActionListener(listen);
	}
	public void updateDepartmentListener(ActionListener listen) {
		btnUpdateDepartment.addActionListener(listen);
	}
	public void deleteDepartmentListener(ActionListener listen) {
		btnDeleteDepartment.addActionListener(listen);
	}
	public void addFullTimeLecturerListener(ActionListener listen){
		btnAddFullTimeLecturer.addActionListener(listen);
	}
	public void editFullTimeLecturerListener(ActionListener listen){
		btnEditFullTimeLecturer.addActionListener(listen);
	}
	public void updateFullTimeLecturerListener(ActionListener listen){
		btnUpdateFullTimeLecturer.addActionListener(listen);
	}
	public void deleteFullTimeLecturerListener(ActionListener listen) {
		btnDeleteFullTimeLecturer.addActionListener(listen);
	}
	public void addPartTimeLecturerListener(ActionListener listen){
		btnAddPartTimeLecturer.addActionListener(listen);
	}
	public void editPartTimeLecturerListener(ActionListener listen){
		btnEditPartTimeLecturer.addActionListener(listen);
	}
	public void updatePartTimeLecturerListener(ActionListener listen){
		btnUpdatePartTimeLecturer.addActionListener(listen);
	}
	public void deletePartTimeLecturerListener(ActionListener listen) {
		btnDeletePartTimeLecturer.addActionListener(listen);
	}
	public void addContractLecturerListener(ActionListener listen){
		btnAddContractLecturer.addActionListener(listen);
	}
	public void editContractLecturerListener(ActionListener listen){
		btnEditContractLecturer.addActionListener(listen);
	}
	public void updateContractLecturerListener(ActionListener listen){
		btnUpdateContractLecturer.addActionListener(listen);
	}
	public void deleteContractLecturerListener(ActionListener listen) {
		btnDeleteContractLecturer.addActionListener(listen);
	}
	
	
	//Department
	public int getDepartmentId() {
		return Integer.parseInt(departmentIdField.getText());
	}
	public String getDepartmentName() {
		return departmentNameField.getText();
	}
	public void setDepartmentname(String name) {
		departmentNameField.setText(name);
	}
	public String getDepartmentType() {
		return departmentTypeField.getText();
	}
	public String getDepartmentAddress() {
		return departmentAddressField.getText();
	}
	public String getDepartmentUsername() {
		return departmentUsernameField.getText();
	}
	public String getDepartmentPassword() {
		return departmentPasswordField.getText();
	}
	public void clearDepartment() {
		departmentIdField.setText(null);
		departmentNameField.setText(null);
		departmentTypeField.setText(null);
		departmentAddressField.setText(null);
		departmentUsernameField.setText(null);
		departmentPasswordField.setText(null);
	}
	
	//Lecturer
	public int getLecturerId() {
		return Integer.parseInt(staffIdField.getText());
	}
	public String getLecturerName() {
		return lecturerNameField.getText();
	}
	public String getLecturerAddress() {
		return lecturerAddressField.getText();
	}
	public String getLeturerPhoneNum() {
		return phoneNumberField.getText();
	}
	public String getLecturerEmail() {
		return emailAddressField.getText();
	}
	public String getLectDepartment() {
		return lectDepartmentField.getText();
	}
	public String getLecturerType() {
		return rBtnLecturer.getSelection().getActionCommand();
	}
	public String getStartingDate() {
		return dateStartedField.getText();
	}
	public double getFullTimeLecturerSalary() {
		return Double.parseDouble(fullTimeSalaryField.getText());
	}
	public int getPartTimeLecturerHRate() {
		return Integer.parseInt(partTimeHRField.getText());
	}
	public double getContractTimeLecturerSalary() {
		return Double.parseDouble(contractSalaryField.getText());
	}
	public String getContractEndDate() {
		return contractEndDateField.getText();
	}
	//method to clear lecturer
	public void clearLecturer() {
		staffIdField.setText(null);
		lecturerNameField.setText(null);
		lecturerAddressField.setText(null);
		emailAddressField.setText(null);
		phoneNumberField.setText(null);
		lectDepartmentField.setText(null);
		dateStartedField.setText(null);
		fullTimeSalaryField.setText(null);
		partTimeHRField.setText(null);
		contractSalaryField.setText(null);
		contractEndDateField.setText(null);
	}

}
