package gruppe1.ejbClient.entity;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class SchoolDTO {
	private int schoolId;
	private String name;
	private String address;
	private int postalNumber;
	private String city;
	private String phone;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public int getPostalNumber() {
		return postalNumber;
	}
	
	public void setPostalNumber(int postalNumber) {
		this.postalNumber = postalNumber;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public int getSchoolId() {
		return schoolId;
	}
	
	public void setSchoolId(int schoolId) {
		this.schoolId = schoolId;
	}
}
