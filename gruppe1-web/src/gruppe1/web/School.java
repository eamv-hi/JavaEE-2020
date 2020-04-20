package gruppe1.web;

import java.io.Console;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.RowEditEvent;

import gruppe1.ejb.beans.EducationBeanLocal;
import gruppe1.ejb.beans.SchoolBeanLocal;
import gruppe1.ejbClient.entity.EducationDTO;
import gruppe1.ejbClient.entity.SchoolDTO;

@Named("dtSchoolView")
@RequestScoped
public class School implements Serializable {
	private static final long serialVersionUID = 1L;
	private EducationDTO forCreate = new EducationDTO();
	private List<EducationDTO> educations;
	private String schoolId;
	private SchoolDTO school;

	@Inject
	private EducationBeanLocal educationBean;
	@Inject
	private SchoolBeanLocal schoolBean;
	
	@PostConstruct
	public void init() {
	}
	
	public String getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
	}
	
	public List<EducationDTO> getEducations(){
		educations = schoolBean.getAllEducations(Integer.parseInt(schoolId));
		return educations;
	}

	public SchoolDTO getSchool() {
		return schoolBean.get(Integer.parseInt(schoolId));
	}

	public String delete() {
		schoolBean.delete(Integer.parseInt(schoolId));
		return "schoolOverview?faces-redirect=true";
	}

	public EducationDTO getForCreate() {
		return forCreate;
	}

//	public List<EducationDTO> getEducations() {
//		return educations;
//	}

	public void addEducation(EducationDTO educationDTO) {
		educationBean.create(educationDTO);
	}

	public void addEducation() {
		//FIXME NullPointerException?? hva fuck
		forCreate = educationBean.create(forCreate);
		educations.add(forCreate);
	}

	public void onRowEdit(RowEditEvent<EducationDTO> event) {
		EducationDTO educationDTO = event.getObject();

		// TODO lav pænere pop up
		FacesMessage msg = new FacesMessage("Uddannelse med navnet " + educationDTO.getName() + " blev redigeret");
		FacesContext.getCurrentInstance().addMessage(null, msg);

		educationBean.update(educationDTO);
	}
}
