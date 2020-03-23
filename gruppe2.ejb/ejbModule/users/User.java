package users;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "user")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

	@Id
    @GeneratedValue
    private int id;
	
	
    @Column(name = "fist_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "phoneNo")
    private int phoneNo;
    @Column(name = "role")
    private String role;
    
    public User(int id, String firstName, String lastName, String email, int phoneNo, String role) {
    	this.id = id;
    	this.firstName = firstName;
    	this.lastName = lastName;
    	this.email = email;
    	this.phoneNo = phoneNo;
    	this.role = role;
    }
    
    public User() {
    	super();
    }

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastname() {
		return lastName;
	}


	public void setLastname(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public int getPhoneNo() {
		return phoneNo;
	}


	public void setPhoneNo(int phoneNo) {
		this.phoneNo = phoneNo;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}
    
    

}
