package gruppe3.ejbClient.DTO;

import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.xml.bind.annotation.XmlTransient;

@Named
@RequestScoped
public class SchoolDTO {
	private int schoolId;
	private String name;
	private String address;
	private int postalNumber;
	private String city;
	private String phone;
	@XmlTransient
	private List<EducationDTO> educationDTOs = new ArrayList<>();

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
	
	public List<EducationDTO> getEducationDTOs() {
		return educationDTOs;
	}

	public void setEducationDTO(List<EducationDTO> educationDTOs) {
		this.educationDTOs = educationDTOs;
	}
}
