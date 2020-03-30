package gruppe1.ejb.beans;

import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import gruppe1.ejb.entity.School;
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
	public void create(SchoolDTO school) {
		if (school != null) {			
			em.persist(fromDTO(new School(), school));
		}
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
		//måske problem, hvis findSchool returnerer null?
		return findSchool(id).toDTO();
	}

	@Override
	public List<SchoolDTO> getAll() {
		return em.createNamedQuery("getAllSchools", School.class)
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
