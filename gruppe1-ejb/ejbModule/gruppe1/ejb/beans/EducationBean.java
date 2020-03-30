package gruppe1.ejb.beans;

import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import gruppe1.ejb.entity.Education;
import gruppe1.ejbClient.entity.EducationDTO;

@Stateless
@LocalBean
public class EducationBean implements EducationBeanRemote, EducationBeanLocal {
	@PersistenceContext
	private EntityManager em;

	@Resource
	private SessionContext ctx;

	@Override
	public void create(EducationDTO education) {
		if (education != null) {
			em.persist(fromDTO(new Education(), education));
		}
	}

	@Override
	public void update(EducationDTO education) {
		Education entity = findEducation(education.getEducationId());

		if (entity != null && education != null) {
			em.persist(fromDTO(entity, education));
		}
	}

	@Override
	public void delete(int id) {
		Education entity = findEducation(id);

		if (entity != null) {
			em.remove(entity);
		}
	}

	@Override
	public EducationDTO get(int id) {
		// måske problem, hvis findCourse returnerer null?
		return findEducation(id).toDTO();
	}

	@Override
	public List<EducationDTO> getAll() {
		return em.createNamedQuery("getAllEducations", Education.class)
				.getResultList()
				.stream()
				.map(c -> c.toDTO())
				.collect(Collectors.toList());
	}

	private Education fromDTO(Education education, EducationDTO dto) {
		education.setName(dto.getName());
		education.setLengthOfSemesters(dto.getLengthOfSemesters());
		education.setNumberOfSemesters(dto.getNumberOfSemesters());
		education.setLessonsPrWeek(dto.getLessonsPrWeek());
		education.setEcts(dto.getEcts());

		return education;
	}

	private Education findEducation(int id) {
		return em.find(Education.class, id);
	}
}
