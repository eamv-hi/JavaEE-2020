package dk.hans.ejb;

import java.util.Arrays;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;

import dk.hans.dto.ParameterDTO;

/**
 * Session Bean implementation class ParameterBean
 */
@Stateless
public class ParameterBean implements ParameterBeanLocal {
	@EJB private ParameterEM em;

	@Override
	public ParameterDTO findParameter(String key) {
		return em.read(key);
	}

	@Override
	public List<ParameterDTO> searchParameters(String search) {
		return em.find(search);
	}

}
