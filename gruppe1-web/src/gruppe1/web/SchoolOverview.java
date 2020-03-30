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
	private SchoolDTO forCreate = new SchoolDTO();
	private List<SchoolDTO> schools;

	@Inject
	private SchoolBeanLocal school;

	@PostConstruct
	public void init() {
		schools = school.getAll();
	}

	public SchoolDTO getForCreate() {
		return forCreate;
	}

	public List<SchoolDTO> getSchools() {
		return schools;
	}

	public void addSchool(SchoolDTO schoolDTO) {
		school.create(schoolDTO);
	}

	public void addSchool() {
		forCreate = school.create(forCreate);
		schools.add(forCreate);
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
}
