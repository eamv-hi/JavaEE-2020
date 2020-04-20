package gruppe1.ejb.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

import gruppe1.ejbClient.entity.CourseDTO;
import gruppe1.ejbClient.entity.EducationDTO;

@Entity
@NamedQuery(name = "getAllCourses", query = "SELECT c FROM Course c")

public class Course implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int courseId;
	private String name;
	// mulighed for at koble sammen med gruppe 2, maybe?
	private String teacherName;
	@ManyToOne(fetch = FetchType.EAGER)
	private Education education;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public int getCourseId() {
		return courseId;
	}

	public Education getEducation() {
		return education;
	}

	public void setEducation(Education education) {
		this.education = education;
	}

	public CourseDTO toDTO() {
		return toDTO(null);
	}

	public CourseDTO toDTO(EducationDTO educationDTO) {
		CourseDTO courseDTO = new CourseDTO();

		courseDTO.setCourseId(courseId);
		courseDTO.setName(name);
		courseDTO.setTeacherName(teacherName);
		if (education != null) {
			if (educationDTO != null && education.getEducationId() == educationDTO.getEducationId()) {
				courseDTO.setEducationDTO(educationDTO);
			} else {
				courseDTO.setEducationDTO(education.toDTO(courseDTO));
			}
		}

		return courseDTO;
	}

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", name=" + name + ", teacherName=" + teacherName + "]";
	}
}
