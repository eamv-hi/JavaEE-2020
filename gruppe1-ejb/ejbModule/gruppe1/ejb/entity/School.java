package gruppe1.ejb.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import gruppe1.ejbClient.entity.EducationDTO;
import gruppe1.ejbClient.entity.SchoolDTO;

@Entity
@NamedQuery(name = "getAllSchools", query = "SELECT s FROM School s")
public class School implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int schoolId;
	private String name;
	private String address;
	private int postalNumber;
	private String city;
	private String phone;
	
    @OneToMany(
            mappedBy = "school",
            cascade = CascadeType.ALL,
            orphanRemoval = true
        )
	private List<Education> educations = new ArrayList<>();

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

	public void addEducation(Education education) {
		educations.add(education);
	}

	public void removeCourse(Education education) {
		educations.remove(education);
	}

	public SchoolDTO toDTO() {
		return toDTO(null);
	}

	public SchoolDTO toDTO(EducationDTO educationDTO) {
		SchoolDTO schoolDTO = new SchoolDTO();

		schoolDTO.setSchoolId(schoolId);
		schoolDTO.setName(name);
		schoolDTO.setAddress(address);
		schoolDTO.setPostalNumber(postalNumber);
		schoolDTO.setCity(city);
		schoolDTO.setPhone(phone);
		
		if (educations != null) {
			List<EducationDTO> educationsDTO = schoolDTO.getEducationDTOs();
			educations.forEach((e) -> {
				if (educationDTO != null && e.getEducationId() == educationDTO.getEducationId()) {
					educationsDTO.add(educationDTO);
				} else {
					educationsDTO.add(e.toDTO(schoolDTO, null));
				}
			});
		}

		return schoolDTO;
	}
	
	public static School fromDTO(School school, SchoolDTO dto) {
		school.setSchoolId(dto.getSchoolId());
		school.setName(dto.getName());
		school.setAddress(dto.getAddress());
		school.setPostalNumber(dto.getPostalNumber());
		school.setCity(dto.getCity());
		school.setPhone(dto.getPhone());

		return school;
	}

	@Override
	public String toString() {
		return "School [schoolId=" + schoolId + ", name=" + name + ", address=" + address + ", postalNumber="
				+ postalNumber + ", city=" + city + ", phone=" + phone + "]";
	}
}
