package gruppe2.web;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import EJB.AuthenticationLocal;
import javaee.dto.TeacherDTO;

@Named
@RequestScoped

public class TeacherLogic {
	@EJB
	private AuthenticationLocal ejb;
	private String firstname;
	private String lastname;
	private String phoneNo;
	private String email;
	private String role;

	public TeacherDTO teachers() {
		TeacherDTO teacherdto = new TeacherDTO();
		teacherdto.setFirstName("Karl");
		teacherdto.setLastName("Karlsen");
		teacherdto.setPhoneNo("648576");
		teacherdto.setEmail("test@test.dk");
		teacherdto.setRole("Teacher");
		return teacherdto;
	}
	
	public void saveTeacher() {
		TeacherDTO teacherdto = new TeacherDTO();
		teacherdto.setFirstName("firstName");
		teacherdto.setLastName("lastName");
		teacherdto.setPhoneNo("phoneNo");
		teacherdto.setEmail("email");
		teacherdto.setRole("role");
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
}
