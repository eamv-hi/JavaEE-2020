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
import gruppe1.ejbClient.entity.CourseDTO;

@Stateless
@LocalBean
public class CourseBean implements CourseBeanRemote, CourseBeanLocal {
	@PersistenceContext
	private EntityManager em;
	
	@Resource
	private SessionContext ctx;
	
	@Override
	public void create(CourseDTO course) {
		if (course != null) {			
			em.persist(fromDTO(new Course(), course));
		}
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
		//måske problem, hvis findCourse returnerer null?
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
		
		return course;
	}
	
	private Course findCourse(int id) {
		return em.find(Course.class, id);
	}

}
