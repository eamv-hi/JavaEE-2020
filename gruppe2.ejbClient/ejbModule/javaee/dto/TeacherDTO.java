package javaee.dto;

public class TeacherDTO {

	private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNo;
    private String role;
    private int teacherNo;
	private String hiredDate;
	private String jobTitle;
	
	public TeacherDTO() {
		super();
	}
	
	 public TeacherDTO(int id, String firstname, String lastname, String email, String phoneNo, String role,int teacherNo, String hireddate, String jobtitle) {
	    	this.id = id;
	    	this.firstName = firstname;
	    	this.lastName = lastname;
	    	this.email = email;
	    	this.phoneNo = phoneNo;
	    	this.role = role;
	    	this.teacherNo = teacherNo;
	    	this.hiredDate = hireddate;
	    	this.jobTitle = jobtitle;
	    	
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

	public void setFirstName(String name) {
		this.firstName = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastname) {
		this.lastName = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
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
	
	@Override
	public String toString() {
		return "TeacherDTO [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", phoneNo=" + phoneNo + ", role=" + role + ", teacherNo=" + teacherNo + ", hiredDate=" + hiredDate
				+ ", jobTitle=" + jobTitle + "]";
	}
	
}
