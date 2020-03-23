package dk.hans.ws;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dk.hans.dto.ParameterDTO;
import dk.hans.ejb.ParameterBeanLocal;

@Path("/parameter")
public class ParameterWS {

	@EJB ParameterBeanLocal ejb;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("read/{key}")

	public ParameterDTO read(@PathParam("key") String key) {
		return ejb.findParameter(key);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("search/{key}")
	public List<ParameterDTO> search(@PathParam("key") String key) {
		return ejb.searchParameters(key);
	}
}
