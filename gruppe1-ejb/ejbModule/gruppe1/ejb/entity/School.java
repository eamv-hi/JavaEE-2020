package gruppe1.ejb.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

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

	public SchoolDTO toDTO() {
		SchoolDTO schoolDTO = new SchoolDTO();

		schoolDTO.setSchoolId(schoolId);
		schoolDTO.setName(name);
		schoolDTO.setAddress(address);
		schoolDTO.setPostalNumber(postalNumber);
		schoolDTO.setCity(city);
		schoolDTO.setPhone(phone);

		return schoolDTO;
	}

	@Override
	public String toString() {
		return "School [schoolId=" + schoolId + ", name=" + name + ", address=" + address + ", postalNumber="
				+ postalNumber + ", city=" + city + ", phone=" + phone + "]";
	}
}
