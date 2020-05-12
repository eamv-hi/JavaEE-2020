package dk.hans.ejb;

import java.util.List;

import javax.ejb.Local;

import dk.hans.dto.ParameterDTO;

@Local
public interface ParameterBeanLocal {

	public ParameterDTO findParameter(String key);
	
	public List<ParameterDTO> searchParameters(String search);
	
	public ParameterDTO testWs1(String key);
	
	public List<ParameterDTO> testWs2(String search);
	
}
