package gruppe1.ejb.beans;

import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import gruppe1.ejb.entity.Course;
import gruppe1.ejb.entity.Education;
import gruppe1.ejbClient.entity.CourseDTO;

@Stateless
@LocalBean
public class CourseBean implements CourseBeanRemote, CourseBeanLocal {
	@PersistenceContext
	private EntityManager em;

	@Resource
	private SessionContext ctx;

	@Override
	public CourseDTO create(CourseDTO courseDTO) {
		if (courseDTO != null) {
			Course course = fromDTO(new Course(), courseDTO);
			em.persist(course);
			return course.toDTO();
		}
		return null;
	}

	@Override
	public void update(CourseDTO course) {
		Course entity = findCourse(course.getCourseId());

		if (entity != null && course != null) {
			em.persist(fromDTO(entity, course));
		}
	}

	@Override
	public void delete(int id) {
		Course entity = findCourse(id);

		if (entity != null) {
			em.remove(entity);
		}
	}

	@Override
	public CourseDTO get(int id) {
		// måske problem, hvis findCourse returnerer null?
		return findCourse(id).toDTO();
	}

	@Override
	public List<CourseDTO> getAll() {
		return em.createNamedQuery("getAllCourses", Course.class)
				.getResultList()
				.stream()
				.map(c -> c.toDTO())
				.collect(Collectors.toList());
	}

	private Course fromDTO(Course course, CourseDTO dto) {
		course.setName(dto.getName());
		course.setTeacherName(dto.getTeacherName());
		course.setEducation(Education.fromDTO(new Education(), dto.getEducationDTO()));

		return course;
	}

	private Course findCourse(int id) {
		return em.find(Course.class, id);
	}

}
