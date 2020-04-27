package gruppe1.ejbClient.entity;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlTransient;

public class EducationDTO {
	private int educationId;
	private String name;
	private int lengthOfSemesters;
	private int numberOfSemesters;
	private int lessonsPrWeek;
	private int ects;
	private SchoolDTO schoolDTO;
	@XmlTransient
	private List<CourseDTO> courseDTOs = new ArrayList<>();

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

	public void setEducationId(int educationId) {
		this.educationId = educationId;
	}
	
	public SchoolDTO getSchoolDTO() {
		return schoolDTO;
	}

	public void setSchoolDTO(SchoolDTO schoolDTO) {
		this.schoolDTO = schoolDTO;
	}
	
	public List<CourseDTO> getCourseDTOs() {
		return courseDTOs;
	}

	public void setCourseDTO(List<CourseDTO> courseDTOs) {
		this.courseDTOs = courseDTOs;
	}
}
