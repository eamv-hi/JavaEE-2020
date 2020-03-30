package gruppe1.web;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import gruppe1.ejb.beans.SchoolBeanLocal;
import gruppe1.ejbClient.entity.SchoolDTO;

@Named("dtSchoolView")
@RequestScoped
public class SchoolOverview implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	private String address;
	private int postalNumber;
	private String city;
	private String phone;
	
	@Inject
	private SchoolBeanLocal school;
	
    public List<SchoolDTO> getSchools() {
    	return school.getAll();
    }
    
    public void addSchool(SchoolDTO schoolDTO) {
    	school.create(schoolDTO);
    }
    
    public void addSchool() {
    	SchoolDTO schoolDTO = new SchoolDTO();
    	
    	schoolDTO.setName(name);
    	schoolDTO.setAddress(address);
    	schoolDTO.setPostalNumber(postalNumber);
    	schoolDTO.setCity(city);
    	schoolDTO.setPhone(phone);
    	
    	school.create(schoolDTO);
    }

    
    
    
    
    
    
    
    
    
    
    
    
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
}
