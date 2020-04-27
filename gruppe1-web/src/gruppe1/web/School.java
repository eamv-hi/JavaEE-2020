package gruppe1.web;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.event.RowEditEvent;
import gruppe1.ejb.beans.EducationBeanLocal;
import gruppe1.ejb.beans.SchoolBeanLocal;
import gruppe1.ejbClient.entity.EducationDTO;
import gruppe1.ejbClient.entity.SchoolDTO;

@Named("dtSchoolView")
@ViewScoped
public class School implements Serializable {
	private static final long serialVersionUID = 1L;
	private String schoolId;
	private SchoolDTO school = new SchoolDTO();
	private EducationDTO forCreate = new EducationDTO();

	@Inject
	private EducationBeanLocal educationBean;

	@Inject
	private SchoolBeanLocal schoolBean;
	
	public void init() {
		school = schoolBean.get(Integer.parseInt(schoolId));
	}
	
	public String getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
	}
	
	public EducationDTO getForCreate() {
		return forCreate;
	}

	public void setForCreate(EducationDTO forCreate) {
		this.forCreate = forCreate;
	}
	
	public SchoolDTO getSchool() {
		return school;
	}
	
	public String delete() {
		schoolBean.delete(Integer.parseInt(schoolId));
		return "schoolOverview?faces-redirect=true";
	}

	public void addEducation() {
		forCreate.setSchoolDTO(school);
		forCreate = educationBean.create(forCreate);
		school.getEducationDTOs().add(forCreate);
	}
	
	public void onRowEdit(RowEditEvent<EducationDTO> event) {
		EducationDTO educationDTO = event.getObject();

		FacesMessage msg = new FacesMessage("", "Uddannelse med navnet " + educationDTO.getName() + " blev redigeret");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		
		educationBean.update(educationDTO);
	}
	
	public String back() {
		return "schoolOverview?faces-redirect=true";
	}
}
