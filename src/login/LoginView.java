package login;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.*;

public class LoginView extends JFrame {
	private JLabel lblHumanResourceSystem, usernameLabel, passwordLabel;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JButton btnLogin, btnExit;
		
	public LoginView(){
		JPanel loginPanel = new JPanel();
		loginPanel.setLayout(null);
		loginPanel.setBackground(new Color(102, 204, 153));
		this.setSize(800,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setTitle("Login Page");
		this.setLocationRelativeTo(null);

		lblHumanResourceSystem = new JLabel("Human Resource System");
		lblHumanResourceSystem.setFont(new Font("Calibri", Font.BOLD, 30));
		lblHumanResourceSystem.setBounds(200, 130, 375, 80);
		loginPanel.add(lblHumanResourceSystem);
		
		usernameLabel = new JLabel("Username:");
		usernameLabel.setFont(new Font("Calibri", Font.PLAIN, 16));
		usernameLabel.setBounds(220, 250, 95, 45);
		loginPanel.add(usernameLabel);
		
		usernameField =new JTextField(8);
		usernameField.setBounds(350, 255, 110, 25);
		usernameField.setColumns(10);
		loginPanel.add(usernameField);
		
		passwordLabel = new JLabel("Password:");
		passwordLabel.setFont(new Font("Calibri", Font.PLAIN, 16));
		passwordLabel.setBounds(220, 320, 130, 40);
		loginPanel.add(passwordLabel);

		passwordField = new JPasswordField();
		passwordField.setBounds(350, 325, 110, 20);
		loginPanel.add(passwordField);
		passwordField.setColumns(10);
		
		btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Calibri", Font.BOLD, 15));
		btnLogin.setBounds(230, 380, 105, 40);
		loginPanel.add(btnLogin);
		
		btnExit = new JButton("Exit");
		//btnExit.addActionListener(new ActionListener() {);
		btnExit.setFont(new Font("Calibri", Font.BOLD, 15));
		btnExit.setBounds(350, 380, 105, 40);
		loginPanel.add(btnExit);
				
		this.add(loginPanel);

	}
	
	public String getUsername() {
		return usernameField.getText();
	}
	
	public String getPassword()	{
		return passwordField.getText();
	}

	public void loginListener(ActionListener listen) {
		btnLogin.addActionListener(listen);	
	}
	
	public void exitListener(ActionListener listen) {
		btnExit.addActionListener(listen);	
	}


}
