package gruppe1.ejb.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import gruppe1.ejbClient.entity.EducationDTO;

@Entity
@NamedQuery(name = "getAllEducations", query = "SELECT e FROM Education e")

public class Education implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int educationId;
	private String name;
	private int lengthOfSemesters;
	private int numberOfSemesters;
	private int lessonsPrWeek;
	private int ects;
	@OneToMany(mappedBy = "education", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Course> courses = new ArrayList<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLengthOfSemesters() {
		return lengthOfSemesters;
	}

	public void setLengthOfSemesters(int lengthOfSemesters) {
		this.lengthOfSemesters = lengthOfSemesters;
	}

	public int getNumberOfSemesters() {
		return numberOfSemesters;
	}

	public void setNumberOfSemesters(int numberOfSemesters) {
		this.numberOfSemesters = numberOfSemesters;
	}

	public int getLessonsPrWeek() {
		return lessonsPrWeek;
	}

	public void setLessonsPrWeek(int lessonsPrWeek) {
		this.lessonsPrWeek = lessonsPrWeek;
	}

	public int getEcts() {
		return ects;
	}

	public void setEcts(int ects) {
		this.ects = ects;
	}

	public int getEducationId() {
		return educationId;
	}

	public void addCourse(Course course) {
		courses.add(course);
	}

	public void removeCourse(Course course) {
		courses.remove(course);
	}

	public EducationDTO toDTO() {
		EducationDTO educationDTO = new EducationDTO();

		educationDTO.setEducationId(educationId);
		educationDTO.setName(name);
		educationDTO.setLengthOfSemesters(lengthOfSemesters);
		educationDTO.setNumberOfSemesters(numberOfSemesters);
		educationDTO.setLessonsPrWeek(lessonsPrWeek);
		educationDTO.setEcts(ects);

		return educationDTO;
	}

	@Override
	public String toString() {
		return "Education [educationId=" + educationId + ", name=" + name + ", lengthOfSemesters=" + lengthOfSemesters
				+ ", numberOfSemesters=" + numberOfSemesters + ", lessonsPrWeek=" + lessonsPrWeek + ", ects=" + ects
				+ "]";
	}
}
