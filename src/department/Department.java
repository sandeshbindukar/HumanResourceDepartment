package department;

import java.io.Serializable;

public class Department implements Serializable{
	public int id;
	public String name, type, address, username, password;
	
	//constructor
	public Department( int id, String name, String type, String address, String username, String password) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.address = address;
		this.username = username;
		this.password = password;
	}
	
	//getter and setter method
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	public String getType() {
		return type;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddress() {
		return address;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUsername() {
		return username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword() {
		return password;
	}
	
	
	
}
