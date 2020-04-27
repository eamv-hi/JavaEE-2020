package gruppe1.web;

import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import gruppe1.ejb.beans.CourseBeanLocal;
import gruppe1.ejbClient.entity.CourseDTO;

@Named("dtCourseView")
@ViewScoped
public class Course implements Serializable {
	private static final long serialVersionUID = 1L;
	private String courseId;
	private CourseDTO course = new CourseDTO();
	
	@Inject
	private CourseBeanLocal courseBean;

	public void init() {
		course = courseBean.get(Integer.parseInt(courseId));
	}
	
	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public CourseDTO getCourse() {
		return course;
	}

	public String delete() {
		courseBean.delete(Integer.parseInt(courseId));
		return "courseOverview?faces-redirect=true";
	}
	
	public String back() {
		return "education?educationId=" + course.getEducationDTO().getEducationId() + "&faces-redirect=true";
	}
}
