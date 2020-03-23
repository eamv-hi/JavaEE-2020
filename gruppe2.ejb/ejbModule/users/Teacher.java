package users;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import javaee.dto.TeacherDTO;

@Entity
public class Teacher extends User {

	@NotNull
    private int teacherNo;
	@NotNull
	private String hiredDate;
	@NotNull
	private String jobTitle;
	
    public Teacher() {
        super();
    }
    
    public Teacher(TeacherDTO teacherdto) {
        
    }

	public int getTeacherNo() {
		return teacherNo;
	}

	public void setTeacherNo(int teacherNo) {
		this.teacherNo = teacherNo;
	}

	public String getHiredDate() {
		return hiredDate;
	}

	public void setHiredDate(String hiredDate) {
		this.hiredDate = hiredDate;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
    
    

}
