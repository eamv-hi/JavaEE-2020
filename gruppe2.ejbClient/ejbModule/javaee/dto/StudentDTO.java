package javaee.dto;

public class StudentDTO {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNo;
    private String role;
    private int studentNo;
    private String subject;

    public StudentDTO() {
    	super();
    }
    
    public StudentDTO(int id, String firstname, String lastname, String email, String phoneNo, String role, int studentNo, String subject ) {
    	this.id = id;
    	this.firstName = firstname;
    	this.lastName = lastname;
    	this.email = email;
    	this.phoneNo = phoneNo;
    	this.role = role;
    	this.studentNo = studentNo;
    	this.subject = subject;
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

	public int getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(int studentNo) {
		this.studentNo = studentNo;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	
	
}
