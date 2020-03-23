package users;

import java.io.Serializable;

import javax.annotation.security.RolesAllowed;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import javaee.dto.StudentDTO;

@Entity
@RolesAllowed("role2")
public class Student extends User implements Serializable{

	
	@NotNull
	private int studentNo;
   
	private static final long serialVersionUID = 1L;
    public Student() {
        super();
    }
    
    public Student(StudentDTO studentdto) {
        
    }
    
	public int getStudentNo() {
		return studentNo;
	}
	public void setStudentNo(int studentNo) {
		this.studentNo = studentNo;
	}
    
    

}
