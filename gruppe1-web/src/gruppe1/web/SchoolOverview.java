package gruppe1.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.RowEditEvent;

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
	private List<SchoolDTO> schools;
	
	@Inject
	private SchoolBeanLocal school;

	@PostConstruct
	public void init() {
		schools = school.getAll();
	}
	
    public List<SchoolDTO> getSchools() {
	return schools;
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

    	schools.add(school.create(schoolDTO));
    }
    
    public void onRowEdit(RowEditEvent<SchoolDTO> event) {
    	SchoolDTO s = event.getObject();
    	
    	// TODO lav pænere pop up
        FacesMessage msg = new FacesMessage("Skole med navnet " + s.getName() + " blev redigeret");
        FacesContext.getCurrentInstance().addMessage(null, msg);

        SchoolDTO schoolDTO = new SchoolDTO();
        schoolDTO.setAddress(s.getAddress());
        schoolDTO.setCity(s.getCity());
        schoolDTO.setName(s.getName());
        schoolDTO.setPhone(s.getPhone());
        schoolDTO.setPostalNumber(s.getPostalNumber());
        schoolDTO.setSchoolId(s.getSchoolId());
        
        school.update(schoolDTO);
        
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
