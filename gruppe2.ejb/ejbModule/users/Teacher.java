package users;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import javaee.dto.TeacherDTO;

@Entity
@Table(name = "teacher_user")
public class Teacher extends User {

	@Column(name = "teacher_No", nullable = false)
    private int teacherNo;
	@Column(name = "hiredDate", nullable = false)
	private String hiredDate;
	@Column(name = "jobTitle", nullable = false)
	private String jobTitle;
	
    public Teacher() {
        super();
    }
    
    public Teacher(TeacherDTO teacherdto) {
    	this.id = teacherdto.getId();
    	this.firstName = teacherdto.getFirstName();
    	this.lastName = teacherdto.getLastName();
    	this.email = teacherdto.getEmail();
    	this.phoneNo = teacherdto.getPhoneNo();
    	this.role = teacherdto.getRole();
    	this.teacherNo = teacherdto.getTeacherNo();
    	this.hiredDate = teacherdto.getHiredDate();
    	this.jobTitle = teacherdto.getJobTitle();
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
