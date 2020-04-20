package gruppe1.ejbClient.entity;

public class CourseDTO {
	private int courseId;
	private String name;
	private String teacherName;
	private EducationDTO educationDTO;

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

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	
	public EducationDTO getEducationDTO() {
		return educationDTO;
	}

	public void setEducationDTO(EducationDTO educationDTO) {
		this.educationDTO = educationDTO;
	}
}
