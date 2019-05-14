package secretary;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import department.ContractLecturer;
import department.Department;
import department.FullTimeLecturer;
import department.PartTimeLecturer;
import homepage.HomePageModel;
import login.LoginModel;

public class SecretaryView extends JFrame{
	public JLabel lblHome, lblWelcome, lblLogOut, lblNavFullTimeLecturer,lblStaffId, lblNavPartTimeLecturer, lblNavContractLecturer, lblNavAllLecturer,lblNavQueryLecturer, lblViewFullTimeLecturer, lblViewPartTimeLecturer, lblViewContractLecturer, lblViewAllLecturer;
	public JPanel navPanel, displayPanel, viewFullTimeLecturerPanel, viewPartTimeLecturerPanel, viewContractLecturerPanel, viewAllLecturerPanel, viewQueryLecturerPanel, homePanel;
	public JTable viewFullTimeLecturerTable, viewPartTimeLecturerTable, viewContractLecturerTable;
	public static JTable viewAllLecturerTable, viewQueryLecturerTable;
	public JTextField staffIdField;
	public JButton searchButton;
	private Color tabColor, tabColor1;
	public DefaultTableModel tf, ftf, ctf, ptf;
	public static DefaultTableModel al;
	private JScrollPane fullTimeLecturerScrollPane, partTimeLecturerScrollPane, contractLecturerScrollPane, allLecturerScrollPane,queryLecturerScrollPane;
	
	public SecretaryView() {
		this.setSize(1200,700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.getContentPane().setLayout(null);
		
		tabColor = new Color (253, 245, 230);
		tabColor1 = new Color (224, 185, 42);
		
		navPanel = new JPanel();
		navPanel.setBackground(tabColor1);
		navPanel.setBounds(0, 0, 220, 665);
		this.getContentPane().add(navPanel);
		navPanel.setLayout(null);
		
		lblHome = new JLabel("Home");
		lblHome.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblHome.setBounds(55, 50, 70, 35);
		navPanel.add(lblHome);
		
		lblNavFullTimeLecturer = new JLabel("Full-Time Lecturer");
		lblNavFullTimeLecturer.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNavFullTimeLecturer.setBounds(25, 150, 200, 45);
		navPanel.add(lblNavFullTimeLecturer);
		
		lblNavPartTimeLecturer = new JLabel("Part-Time Lecturer");
		lblNavPartTimeLecturer.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNavPartTimeLecturer.setBounds(25, 210, 200, 45);
		navPanel.add(lblNavPartTimeLecturer);
		
		lblNavContractLecturer = new JLabel("Contract Lecturer");
		lblNavContractLecturer.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNavContractLecturer.setBounds(25, 270, 200, 45);
		navPanel.add(lblNavContractLecturer);
		
		lblNavAllLecturer = new JLabel("All Lecturer");
		lblNavAllLecturer.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNavAllLecturer.setBounds(25, 330, 200, 45);
		navPanel.add(lblNavAllLecturer);
		
		lblNavQueryLecturer = new JLabel("Query Lecturer");
		lblNavQueryLecturer.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNavQueryLecturer.setBounds(25, 390, 200, 45);
		navPanel.add(lblNavQueryLecturer);
		
		lblLogOut = new JLabel("Log Out");
		lblLogOut.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblLogOut.setBounds(50, 520, 110, 45);
		navPanel.add(lblLogOut);
		
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
		
		viewAllLecturerPanel = new JPanel();
		viewAllLecturerPanel.setBackground(Color.ORANGE);
		viewAllLecturerPanel.setLayout(null);
		this.getContentPane().add(viewAllLecturerPanel);
		
		viewQueryLecturerPanel = new JPanel();
		viewQueryLecturerPanel.setBackground(Color.ORANGE);
		viewQueryLecturerPanel.setLayout(null);
		this.getContentPane().add(viewQueryLecturerPanel);
		
		lblViewFullTimeLecturer = new JLabel("Full-Time Lecturer");
		lblViewFullTimeLecturer.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblViewFullTimeLecturer.setBounds(215, 40, 200, 25);
		viewFullTimeLecturerPanel.add(lblViewFullTimeLecturer);
		
		viewFullTimeLecturerTable = new JTable();
		fullTimeLecturerScrollPane = new JScrollPane(viewFullTimeLecturerTable);
		fullTimeLecturerScrollPane.setBounds(1, 100, 965, 565);
		fullTimeLecturerScrollPane.getViewport().setBackground(tabColor);
		viewFullTimeLecturerPanel.add(fullTimeLecturerScrollPane);
		
		
		lblViewPartTimeLecturer = new JLabel("Part-Time Lecturer");
		lblViewPartTimeLecturer.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblViewPartTimeLecturer.setBounds(215, 40, 200, 25);
		viewPartTimeLecturerPanel.add(lblViewPartTimeLecturer);
		
		viewPartTimeLecturerTable = new JTable();
		partTimeLecturerScrollPane = new JScrollPane(viewPartTimeLecturerTable);
		partTimeLecturerScrollPane.setBounds(1, 100, 965, 565);
		partTimeLecturerScrollPane.getViewport().setBackground(tabColor);
		viewPartTimeLecturerPanel.add(partTimeLecturerScrollPane);
		
		lblViewContractLecturer = new JLabel("Contract Lecturer");
		lblViewContractLecturer.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblViewContractLecturer.setBounds(215, 40, 200, 25);
		viewContractLecturerPanel.add(lblViewContractLecturer);
		
		viewContractLecturerTable = new JTable();
		contractLecturerScrollPane = new JScrollPane(viewContractLecturerTable);
		contractLecturerScrollPane.setBounds(1, 100, 965, 565);
		contractLecturerScrollPane.getViewport().setBackground(tabColor);
		viewContractLecturerPanel.add(contractLecturerScrollPane);
		
		lblViewAllLecturer = new JLabel("All Lecturer");
		lblViewAllLecturer.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblViewAllLecturer.setBounds(215, 40, 200, 25);
		viewAllLecturerPanel.add(lblViewAllLecturer);
		
		viewAllLecturerTable = new JTable();
		allLecturerScrollPane = new JScrollPane(viewAllLecturerTable);
		allLecturerScrollPane.setBounds(1, 100, 965, 565);
		allLecturerScrollPane.getViewport().setBackground(tabColor);
		viewAllLecturerPanel.add(allLecturerScrollPane);
		
		lblStaffId = new JLabel("Enter a Staff Id: ");
		lblStaffId.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblStaffId.setBounds(115, 40, 200, 25);
		viewQueryLecturerPanel.add(lblStaffId);
		
		staffIdField = new JTextField();
		staffIdField.setBounds(285, 40, 50, 25);
		viewQueryLecturerPanel.add(staffIdField);
		
		searchButton = new JButton("Search");
		searchButton.setBounds(350, 40, 100, 25);
		viewQueryLecturerPanel.add(searchButton);
		
		
		viewQueryLecturerTable = new JTable();
		queryLecturerScrollPane = new JScrollPane(viewQueryLecturerTable);
		queryLecturerScrollPane.setBounds(1, 100, 965, 565);
		queryLecturerScrollPane.getViewport().setBackground(tabColor);
		viewQueryLecturerPanel.add(queryLecturerScrollPane);
		
		//adds panel to the display panel
		displayPanel.add(homePanel);
		displayPanel.add(viewFullTimeLecturerPanel);
		displayPanel.add(viewPartTimeLecturerPanel);
		displayPanel.add(viewContractLecturerPanel);
		displayPanel.add(viewAllLecturerPanel);
		displayPanel.add(viewQueryLecturerPanel);
		
		//create lecturer table column
		createFullTimeLecturerTableColumn();
		createPartTimeLecturerTableColumn();
		createContractLecturerTableColumn();
		createAllLecturerTableColumn();
		createQueryLecturerTableColumn();
	}
	
	//Method for a action listener
	public void searchListener(ActionListener listen) {
		searchButton.addActionListener(listen);
	}
	public void lblHomeListener(MouseAdapter listen) {
		lblHome.addMouseListener(listen);
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
	public void lblAllLecturerListener(MouseAdapter listen) {
		lblNavAllLecturer.addMouseListener(listen);
	}
	public void lblQueryLecturerListener(MouseAdapter listen) {
		lblNavQueryLecturer.addMouseListener(listen);
	}
	public void lblLogOutListener(MouseAdapter listen) {
		lblLogOut.addMouseListener(listen);
	}
	
	//method to create the full time lecturer table column
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
	
	//method to add row in the full time lecturer table
	public void addFullTimeLecturerRowToTable(ArrayList<FullTimeLecturer> d) {
		ftf = (DefaultTableModel) viewFullTimeLecturerTable.getModel();
		ftf.setRowCount(0);
		for(int i=0; i<d.size(); i++ ) {
			ftf.addRow(new Object[] {d.get(i).id, d.get(i).name, d.get(i).address, d.get(i).phoneno,d.get(i).email, d.get(i).department, d.get(i).type, d.get(i).startdate,d.get(i).salary});
		}
	}
	
	//method to create the part time lecturer table column
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
	
	//method to add row in the part time lecturer table
	public void addPartTimeLecturerRowToTable(ArrayList<PartTimeLecturer> d) {
		ptf = (DefaultTableModel) viewPartTimeLecturerTable.getModel();
		ptf.setRowCount(0);
		for(int i=0; i<d.size(); i++ ) {
			ptf.addRow(new Object[] {d.get(i).id, d.get(i).name, d.get(i).address, d.get(i).phoneno,d.get(i).email, d.get(i).department, d.get(i).type, d.get(i).startdate,d.get(i).hourlyrate});
		}
	}
	
	//method to create the contract lecturer table column
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
	//method to add row in the contract lecturer table
	public void addContractLecturerRowToTable(ArrayList<ContractLecturer> d) {
		ctf = (DefaultTableModel) viewContractLecturerTable.getModel();
		ctf.setRowCount(0);
		for(int i=0; i<d.size(); i++ ) {
			ctf.addRow(new Object[] {d.get(i).id, d.get(i).name, d.get(i).address, d.get(i).phoneno,d.get(i).email, d.get(i).department, d.get(i).type, d.get(i).startdate,d.get(i).salary, d.get(i).enddate});
		}
	}
	
	//method to create the all lecturer table column
	public void createAllLecturerTableColumn() {
		ctf = (DefaultTableModel) viewAllLecturerTable.getModel();
		ctf.addColumn("Id");
		ctf.addColumn("Name");
		ctf.addColumn("Address");
		ctf.addColumn("Phone No");
		ctf.addColumn("Email");
		ctf.addColumn("Department");
		ctf.addColumn("Type");
		ctf.addColumn("Starting Date");
		ctf.addColumn("Salary");
		ctf.addColumn("Hourly Rate");
		ctf.addColumn("End Date");
	}

	//method to add row in the all lecturer table
	public static void addRowToLecturerTable(String[] strings) {
		al = (DefaultTableModel) viewAllLecturerTable.getModel();
		al.addRow(strings);
		
	}
	
	//method to display all the lecturers
	public void displayAllLecturer() {		
		for(FullTimeLecturer l : HomePageModel.readFullTimeLecturer()) {
			if(l.getLectDepartment().equals(LoginModel.name)) {
				addRowToLecturerTable(new String [] {Integer.toString(l.id()), l.getName(), l.getAddress(), l.getPhoneNum(), l.getEmail(), l.getLectDepartment(), l.getType(), l.getStartDate(),Double.toString(l.getSalary()), "-", "-"  });
			}
		}
		for(PartTimeLecturer l : HomePageModel.readPartTimeLecturer()) {
			if(l.getLectDepartment().equals(LoginModel.name)) {
				addRowToLecturerTable(new String [] {Integer.toString(l.id()), l.getName(), l.getAddress(), l.getPhoneNum(), l.getEmail(), l.getLectDepartment(), l.getType(), l.getStartDate(), "-", Double.toString(l.getHourlyRate()) ,"-" });
			}	
		}
		for(ContractLecturer l : HomePageModel.readContractLecturer()) {
			if(l.getLectDepartment().equals(LoginModel.name)) {
				addRowToLecturerTable(new String [] {Integer.toString(l.id()), l.getName(), l.getAddress(), l.getPhoneNum(), l.getEmail(), l.getLectDepartment(), l.getType(), l.getStartDate(),Double.toString(l.getSalary()), "-", l.getEndDate() });
			}
		}
	}
	
	//method to add row in the query lecturer table
	public void createQueryLecturerTableColumn() {
		ctf = (DefaultTableModel) viewQueryLecturerTable.getModel();
		ctf.addColumn("Id");
		ctf.addColumn("Name");
		ctf.addColumn("Address");
		ctf.addColumn("Phone No");
		ctf.addColumn("Email");
		ctf.addColumn("Department");
		ctf.addColumn("Type");
		ctf.addColumn("Starting Date");
		ctf.addColumn("Salary");
		ctf.addColumn("Hourly Rate");
		ctf.addColumn("End Date");
	}
	
	//method to add row in the query lecturer table
	public static void addRowToQueryLecturerTable(String[] strings) {
		al = (DefaultTableModel) viewQueryLecturerTable.getModel();
		al.setRowCount(0);
		al.addRow(strings);
		
	}
	
	//method to display query lecturer table
	public void displayQueryLecturer(int id) {		
		for(FullTimeLecturer l : HomePageModel.readFullTimeLecturer()) {
			if(l.id() == id ) {
				addRowToQueryLecturerTable(new String [] {Integer.toString(l.id()), l.getName(), l.getAddress(), l.getPhoneNum(), l.getEmail(), l.getLectDepartment(), l.getType(), l.getStartDate(),Double.toString(l.getSalary()), "-", "-"  });
			}
		}
		for(PartTimeLecturer l : HomePageModel.readPartTimeLecturer()) {
			if(l.id() == id) {
				addRowToQueryLecturerTable(new String [] {Integer.toString(l.id()), l.getName(), l.getAddress(), l.getPhoneNum(), l.getEmail(), l.getLectDepartment(), l.getType(), l.getStartDate(), "-", Double.toString(l.getHourlyRate()) ,"-" });
			}	
		}
		for(ContractLecturer l : HomePageModel.readContractLecturer()) {
			if(l.id() == id) {
				addRowToQueryLecturerTable(new String [] {Integer.toString(l.id()), l.getName(), l.getAddress(), l.getPhoneNum(), l.getEmail(), l.getLectDepartment(), l.getType(), l.getStartDate(),Double.toString(l.getSalary()), "-", l.getEndDate() });
			}
		}
	}
	
	
	
}
