package gruppe1.web;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import gruppe1.ejb.beans.CourseBeanLocal;
import gruppe1.ejbClient.entity.CourseDTO;

@Named("dtCourseView")
@RequestScoped
public class Course {
	private String courseId;
	private CourseDTO course;

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	@Inject
	private CourseBeanLocal courseBean;

	public CourseDTO getCourse() {
		return courseBean.get(Integer.parseInt(courseId));
	}

	public String delete() {
		courseBean.delete(Integer.parseInt(courseId));
		return "courseOverview?faces-redirect=true";
	}
}
