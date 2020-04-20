package gruppe1.web;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.RowEditEvent;

import gruppe1.ejb.beans.CourseBeanLocal;
import gruppe1.ejbClient.entity.CourseDTO;

@Named("dtCourseOverviewView")
@RequestScoped
public class CourseOverview implements Serializable {
	private static final long serialVersionUID = 1L;
	private CourseDTO forCreate = new CourseDTO();
	private List<CourseDTO> courses;

	@Inject
	private CourseBeanLocal course;

	@PostConstruct
	public void init() {
		courses = course.getAll();
	}

	public CourseDTO getForCreate() {
		return forCreate;
	}

	public List<CourseDTO> getCourses() {
		return courses;
	}

	public void addCourse(CourseDTO courseDTO) {
		course.create(courseDTO);
	}

	public void addCourse() {
		forCreate = course.create(forCreate);
		courses.add(forCreate);
	}

	public void onRowEdit(RowEditEvent<CourseDTO> event) {
		CourseDTO courseDTO = event.getObject();

		// TODO lav pænere pop up
		FacesMessage msg = new FacesMessage("Course med navnet " + courseDTO.getName() + " blev redigeret");
		FacesContext.getCurrentInstance().addMessage(null, msg);

		course.update(courseDTO);
	}
}
