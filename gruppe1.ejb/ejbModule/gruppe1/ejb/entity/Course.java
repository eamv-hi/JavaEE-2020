package gruppe1.ejb.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import gruppe1.ejbClient.entity.CourseDTO;

@Entity
@NamedQuery(name="getAllCourses", query="SELECT c FROM Course c")

public class Course implements Serializable {
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private int courseId;
	private String name;
	//mulighed for at koble sammen med gruppe 2, maybe?
	private String teacherName;
	
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
	
	public CourseDTO toDTO() {
		CourseDTO courseDTO = new CourseDTO();
		
		courseDTO.setCourseId(courseId);
		courseDTO.setName(name);
		courseDTO.setTeacherName(teacherName);
		
		return courseDTO;
	}
	
	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", name=" + name + ", teacherName=" + teacherName + "]";
	}
}
