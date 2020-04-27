package gruppe1.ejb.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import gruppe1.ejbClient.entity.CourseDTO;
import gruppe1.ejbClient.entity.EducationDTO;
import gruppe1.ejbClient.entity.SchoolDTO;

@Entity
@NamedQuery(name = "getAllEducations", query = "SELECT e FROM Education e")
@NamedQuery(name = "getAllEducationsWhitSchoolId", query = "SELECT e FROM Education e WHERE e.school.schoolId=:schoolId")
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

	@ManyToOne(fetch = FetchType.LAZY)
	private School school;

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	public void setEducationId(int educationId) {
		this.educationId = educationId;
	}

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
		return toDTO(null, null);
	}

	public EducationDTO toDTO(SchoolDTO schoolDTO, CourseDTO courseDTO) {
		EducationDTO educationDTO = new EducationDTO();

		educationDTO.setEducationId(educationId);
		educationDTO.setName(name);
		educationDTO.setLengthOfSemesters(lengthOfSemesters);
		educationDTO.setNumberOfSemesters(numberOfSemesters);
		educationDTO.setLessonsPrWeek(lessonsPrWeek);
		educationDTO.setEcts(ects);

		if (courses != null) {
			List<CourseDTO> coursesDTO = educationDTO.getCourseDTOs();
			courses.forEach((c) -> {
				if (courseDTO != null && c.getCourseId() == courseDTO.getCourseId()) {
					coursesDTO.add(courseDTO);
				} else {
					coursesDTO.add(c.toDTO(educationDTO));
				}
			});
		}
		
		if (school != null) {
			if (schoolDTO != null && school.getSchoolId() == schoolDTO.getSchoolId()) {
				educationDTO.setSchoolDTO(schoolDTO);
			} else {
				educationDTO.setSchoolDTO(school.toDTO(educationDTO));
			}
		}

		return educationDTO;
	}

	public static Education fromDTO(Education education, EducationDTO dto) {
		education.setEducationId(dto.getEducationId());
		education.setName(dto.getName());
		education.setLengthOfSemesters(dto.getLengthOfSemesters());
		education.setNumberOfSemesters(dto.getNumberOfSemesters());
		education.setLessonsPrWeek(dto.getLessonsPrWeek());
		education.setEcts(dto.getEcts());
		education.setSchool(School.fromDTO(new School(), dto.getSchoolDTO()));

		return education;
	}

	@Override
	public String toString() {
		return "Education [educationId=" + educationId + ", name=" + name + ", lengthOfSemesters=" + lengthOfSemesters
				+ ", numberOfSemesters=" + numberOfSemesters + ", lessonsPrWeek=" + lessonsPrWeek + ", ects=" + ects
				+ "]";
	}
}
