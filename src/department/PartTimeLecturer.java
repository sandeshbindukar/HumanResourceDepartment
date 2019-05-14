package department;

import java.io.Serializable;

public class PartTimeLecturer implements Serializable {
public String name, address, phoneno, email, department, type, startdate;
public int id, hourlyrate;

	//constructor
	public PartTimeLecturer( int id, String name, String address, String phoneno, String email, String department, String type, String startdate, int hourlyrate) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.phoneno = phoneno;		
		this.email = email;
		this.department = department;
		this.type = type;
		this.startdate = startdate;
		this.hourlyrate = hourlyrate;
	}
	
	//getter and setter method
	public void setId(int id) {
		this.id = id;
	}
	public int id() {
		return id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddress() {
		return address;
	}
	public void setPhoneNum(String phoneno) {
		this.phoneno = phoneno;
	}
	public String getPhoneNum() {
		return phoneno;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmail() {
		return email;
	}
	public void setLectDepartment(String department) {
		this.department = department;
	}
	public String getLectDepartment() {
		return department;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getType() {
		return type;
	}
	public void setStartDate(String startdate) {
		this.startdate = startdate;
	}
	public String getStartDate() {
		return startdate;
	}
	public void setHourlyRate(int hourlyrate) {
		this.hourlyrate = hourlyrate;
	}
	public double getHourlyRate() {
		return hourlyrate;
	}
	
}
