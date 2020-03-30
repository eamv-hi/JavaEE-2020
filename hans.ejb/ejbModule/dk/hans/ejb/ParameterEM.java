package dk.hans.ejb;

import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dk.hans.dto.ParameterDTO;
import dk.hans.entity.ParameterEntity;

/**
 * Session Bean implementation class ParameterEM
 */
@Stateless
@LocalBean
public class ParameterEM {

	@PersistenceContext private EntityManager em;
	
	public void create(ParameterDTO dto) {
		ParameterEntity entity = em.find(ParameterEntity.class, dto.getKey());
		if (entity != null) {
			throw new RuntimeException("ParameterEntity exists with key = " + dto.getKey());
		} else {
			em.persist(new ParameterEntity(dto));
		}
	}
	
	public ParameterDTO read(String key) {
		ParameterEntity entity = em.find(ParameterEntity.class, key);
		if (entity != null) {
			return entity.toDto();
		} else {
			throw new RuntimeException("No ParameterEntity found with key = " + key);
		}
	}
	
	public void update(ParameterDTO dto) {
		ParameterEntity entity = em.find(ParameterEntity.class, dto.getKey());
		if (entity != null) {
			entity.setValue(dto.getValue());
		} else {
			throw new RuntimeException("No ParameterEntity found with key = " + dto.getKey());
		}
	}
	
	public void delete(String key) {
		ParameterEntity entity = em.find(ParameterEntity.class, key);
		if (entity != null) {
			em.remove(entity);;
		} else {
			throw new RuntimeException("No ParameterEntity found with key = " + key);
		}
	}
	
	public List<ParameterDTO> find(String search) {
		return em.createNamedQuery("findParameters", ParameterEntity.class)
				.setParameter("search", '%' + search.toUpperCase() + '%')
				.getResultList()
				.stream()
				.map(p -> p.toDto())
				.collect(Collectors.toList());
	}
}
