package gruppe1.web;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.RowEditEvent;

import gruppe1.ejb.beans.CourseBeanLocal;
import gruppe1.ejb.beans.EducationBeanLocal;
import gruppe1.ejbClient.entity.CourseDTO;
import gruppe1.ejbClient.entity.EducationDTO;

@Named("dtEducationView")
@ViewScoped
public class Education implements Serializable {
	private static final long serialVersionUID = 1L;
	// TODO: Ændre til int
	private String educationId;
	private EducationDTO education = new EducationDTO();
	private CourseDTO forCreate = new CourseDTO();

	@Inject
	private EducationBeanLocal educationBean;

	@Inject
	private CourseBeanLocal course;

	public void init() {
		education = educationBean.get(Integer.parseInt(educationId));
	}

	public String getEducationId() {
		return educationId;
	}

	public void setEducationId(String educationId) {
		this.educationId = educationId;
	}

	public CourseDTO getForCreate() {
		return forCreate;
	}

	public void setForCreate(CourseDTO forCreate) {
		this.forCreate = forCreate;
	}

	public EducationDTO getEducation() {
		return education;
	}

	public String delete() {
		educationBean.delete(Integer.parseInt(educationId));
		return "schoolOverview?faces-redirect=true";
	}

	public void addCourse() {
		// TODO: Undersøg om den kan flyttes til init
		forCreate.setEducationDTO(education);
		forCreate = course.create(forCreate);
		education.getCourseDTOs().add(forCreate);
	}

	public void onRowEdit(RowEditEvent<CourseDTO> event) {
		CourseDTO courseDTO = event.getObject();

		FacesMessage msg = new FacesMessage("", "Course med navnet " + courseDTO.getName() + " blev redigeret");
		FacesContext.getCurrentInstance().addMessage(null, msg);

		// TODO: Man bør nok overveje om at vi kan opdatere vha. educationBean.
		course.update(courseDTO);
	}
	
	public String back() {
		return "school?schoolId=" + education.getSchoolDTO().getSchoolId() + "&faces-redirect=true";
	}
}
