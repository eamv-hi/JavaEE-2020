package dk.hans.ejb;

import java.util.Arrays;
import java.util.List;

import javax.ejb.Stateless;
import javax.jws.WebService;

import dk.hans.dto.ParameterDTO;

/**
 * Session Bean implementation class ParameterBean
 */
@Stateless
public class ParameterBean implements ParameterBeanLocal {

	@Override
	public ParameterDTO findParameter(String key) {
		return new ParameterDTO("Hans", "Iversen");
	}

	@Override
	public List<ParameterDTO> searchParameters(String search) {
		return Arrays.asList(new ParameterDTO("key1", "value1"), new ParameterDTO("key2", "value2"));
	}

}
