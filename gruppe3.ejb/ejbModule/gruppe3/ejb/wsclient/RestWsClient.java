package gruppe3.ejb.wsclient;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import gruppe3.ejbClient.DTO.*;
import gruppe3.ejbClient.beans.EducationBeanLocal;

/**
 * Session Bean implementation class RestWsClient
 */
@Stateless
@LocalBean
public class RestWsClient implements EducationBeanLocal {

	private static final String PATH = "http://localhost:8080/gruppe1-web/api/"; 
	
	public EducationDTO getEducation(String educationId) {
		Client client = ClientBuilder.newClient();
		EducationDTO dto = client
				.target(PATH)
				.path("education/" + educationId)
				.request(MediaType.APPLICATION_JSON)
				.get(EducationDTO.class);
		client.close();
		return dto;
	}
	
	public List<EducationDTO> getAllEducations() {
		Client client = ClientBuilder.newClient();
		List<EducationDTO> list = client
				.target(PATH)
				.path("education/")
				.request(MediaType.APPLICATION_JSON)
				.get(new GenericType<List<EducationDTO>>() {});
		client.close();
		return list;
	}
}