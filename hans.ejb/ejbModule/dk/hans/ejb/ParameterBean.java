package dk.hans.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import dk.hans.dto.ParameterDTO;
import dk.hans.wsclient.RestWsClient;

/**
 * Session Bean implementation class ParameterBean
 */
@Stateless
public class ParameterBean implements ParameterBeanLocal {
	@EJB private ParameterEM em;
	@EJB private RestWsClient test;

	@Override
	public ParameterDTO findParameter(String key) {
		return em.read(key);
	}

	@Override
	public List<ParameterDTO> searchParameters(String search) {
		return em.find(search);
	}

	@Override
	public ParameterDTO testWs1(String key) {
		return test.getParameter(key);
	}

	@Override
	public List<ParameterDTO> testWs2(String search) {
		return test.search(search);
	}

}
