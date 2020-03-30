package dk.hans.wsclient;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

import dk.hans.dto.ParameterDTO;

/**
 * Session Bean implementation class RestWsClient
 */
@Stateless
@LocalBean
public class RestWsClient {

	private static final String PATH = "http://m13975:8080/hans.ws/rest/"; 
	
	public ParameterDTO getParameter(String key) {
		Client client = ClientBuilder.newClient();
		ParameterDTO dto = client
				.target(PATH)
				.path("parameter/read/" + key)
				.request(MediaType.APPLICATION_JSON)
				.get(ParameterDTO.class);
		client.close();
		return dto;
	}
}
