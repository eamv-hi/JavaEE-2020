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
public class EducationBean implements EducationBeanRemote, EducationBeanLocal {
	@PersistenceContext
	private EntityManager em;

	@Resource
	private SessionContext ctx;

	@Override
	public EducationDTO create(EducationDTO educationDTO) {
		System.out.println("TESTING");
		if (educationDTO != null) {
			Education education = Education.fromDTO(new Education(), educationDTO);
			em.persist(education);
			return education.toDTO();
		}
		return null;
	}

	@Override
	public void update(EducationDTO education) {
		Education entity = findEducation(education.getEducationId());

		if (entity != null && education != null) {
			em.persist(Education.fromDTO(entity, education));
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

	private Education findEducation(int id) {
		return em.find(Education.class, id);
	}
}
