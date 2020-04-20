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
import gruppe1.ejb.entity.School;
import gruppe1.ejbClient.entity.EducationDTO;
import gruppe1.ejbClient.entity.SchoolDTO;

/**
 * Session Bean implementation class SchoolBean
 */
@Stateless
@LocalBean
public class SchoolBean implements SchoolBeanRemote, SchoolBeanLocal {
	@PersistenceContext
	private EntityManager em;

	@Resource
	private SessionContext ctx;

	@Override
	public SchoolDTO create(SchoolDTO schoolDTO) {
		if (schoolDTO != null) {
			School school = fromDTO(new School(), schoolDTO);
			em.persist(school);
			return school.toDTO();
		}
		return null;
	}

	@Override
	public void update(SchoolDTO school) {
		School entity = findSchool(school.getSchoolId());

		if (entity != null && school != null) {
			em.persist(fromDTO(entity, school));
		}
	}

	@Override
	public void delete(int id) {
		School entity = findSchool(id);

		if (entity != null) {
			em.remove(entity);
		}
	}

	@Override
	public SchoolDTO get(int id) {
		School school = findSchool(id);
		return school != null ? school.toDTO() : null;
	}

	@Override
	public List<SchoolDTO> getAll() {
		return em.createNamedQuery("getAllSchools", School.class)
				.getResultList()
				.stream()
				.map(c -> c.toDTO())
				.collect(Collectors.toList());
	}
	
	@Override
	public List<EducationDTO> getAllEducations(int id) {
		return em.createNamedQuery("getAllEducationsWhitSchoolId", Education.class)
				.setParameter("schoolId", id)
				.getResultList()
				.stream()
				.map(c -> c.toDTO())
				.collect(Collectors.toList());
	}

	private School fromDTO(School school, SchoolDTO dto) {
		school.setName(dto.getName());
		school.setAddress(dto.getAddress());
		school.setPostalNumber(dto.getPostalNumber());
		school.setCity(dto.getCity());
		school.setPhone(dto.getPhone());

		return school;
	}

	private School findSchool(int id) {
		return em.find(School.class, id);
	}
}
