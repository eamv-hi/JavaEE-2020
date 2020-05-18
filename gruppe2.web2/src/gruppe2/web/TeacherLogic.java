package gruppe2.web;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;


import EJB.AuthenticationLocal;
import javaee.dto.StudentDTO;
import javaee.dto.TeacherDTO;

@Named
@RequestScoped

public class TeacherLogic {
	@EJB
	private AuthenticationLocal ejb;
	private int id;
	private String firstname;
	private String lastname;
	private String phoneNo;
	private String email;
	private String role;

	
	
	public void create_teacher() {
		TeacherDTO teacherdto = new TeacherDTO();
		teacherdto.setFirstName(firstname);
		teacherdto.setLastName(lastname);
		teacherdto.setPhoneNo(phoneNo);
		teacherdto.setEmail(email);
		teacherdto.setRole(role);
		
		ejb.teacher_create(teacherdto);
	}

	public void create_student() {
		StudentDTO studentdto = new StudentDTO();
		studentdto.setFirstName(firstname);
		studentdto.setLastName(lastname);
		studentdto.setPhoneNo(phoneNo);
		studentdto.setEmail(email);
		studentdto.setRole(role);
		
		ejb.student_create(studentdto);
	}
	
	public void read_student() {
		StudentDTO studentdto = ejb.student_read(id);
		
		firstname = studentdto.getFirstName();
		lastname = studentdto.getLastName();
		phoneNo = studentdto.getPhoneNo();
		email = studentdto.getEmail();
		role = studentdto.getRole();
	}
	
	public void read_teacher() {
		TeacherDTO teacherdto = ejb.teacher_read(1);
	
		firstname = teacherdto.getFirstName();
		lastname = teacherdto.getLastName();
		phoneNo = teacherdto.getPhoneNo();
		email = teacherdto.getEmail();
		role = teacherdto.getRole();
	}
	
	public void readall_teacher() {
		List<TeacherDTO> teachers = ejb.teacher_readall();
		
		for (TeacherDTO teacherDTO : teachers) {
			firstname = teacherDTO.getFirstName();
			lastname = teacherDTO.getLastName();
			phoneNo = teacherDTO.getPhoneNo();
			email = teacherDTO.getEmail();
			role = teacherDTO.getRole();
		}
	}
	
	public void update_student() {
		StudentDTO studentdto = new StudentDTO();
		studentdto.setId(id);
		studentdto.setFirstName(firstname);
		studentdto.setLastName(lastname);
		studentdto.setPhoneNo(phoneNo);
		studentdto.setEmail(email);
		studentdto.setRole(role);
		
		ejb.student_update(studentdto);
	}
	
	public void update_teacher() {
		TeacherDTO teacherdto = new TeacherDTO();
		teacherdto.setFirstName(firstname);
		teacherdto.setLastName(lastname);
		teacherdto.setPhoneNo(phoneNo);
		teacherdto.setEmail(email);
		teacherdto.setRole(role);
		
		ejb.teacher_update(teacherdto);
	}
	
	public void delete_teacher() {
		TeacherDTO teacherdto = new TeacherDTO();
		teacherdto.setFirstName(firstname);
		teacherdto.setLastName(lastname);
		teacherdto.setPhoneNo(phoneNo);
		teacherdto.setEmail(email);
		teacherdto.setRole(role);
		
		
		ejb.teacher_delete(teacherdto);
		
	}
	
	public void delete_student() {
		StudentDTO studentdto = new StudentDTO();
		studentdto.setId(id);
		studentdto.setFirstName(firstname);
		studentdto.setLastName(lastname);
		studentdto.setPhoneNo(phoneNo);
		studentdto.setEmail(email);
		studentdto.setRole(role);
		
		ejb.student_delete(studentdto);
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
}
