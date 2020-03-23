package users;

import java.io.Serializable;

import javax.annotation.security.RolesAllowed;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import javaee.dto.StudentDTO;

@Entity
@RolesAllowed("role2")
@Table(name = "student_user")
public class Student extends User implements Serializable{


   
	@Column(name = "student_No", nullable = false)
	private int studentNo;
	
	
	private static final long serialVersionUID = 1L;
	
    public Student(int id, String firstName, String lastName,
    		String email, int phoneNo, String role, int studentNo) {
    	super(id, firstName, lastName, email, phoneNo, role);
    	this.studentNo = studentNo;
    }
    public Student() {
    	super();
    }
    
    public Student(StudentDTO student) {
    	
    }
    
    
	public int getStudentNo() {
		return studentNo;
	}
	public void setStudentNo(int studentNo) {
		this.studentNo = studentNo;
	}
    
    

}
