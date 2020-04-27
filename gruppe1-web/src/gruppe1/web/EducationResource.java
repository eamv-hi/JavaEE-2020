package gruppe1.web;

import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import gruppe1.ejb.beans.EducationBeanLocal;
import gruppe1.ejbClient.entity.EducationDTO;

@Path("/education")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EducationResource {
	@Inject
	private EducationBeanLocal educationBean;

	@GET
	public Response getEducations() {
		List<EducationDTO> educations = educationBean.getAll();
		return Response.ok().entity(educations).build();
	}

	@GET
	@Path("/{id}")
	public Response getEducationById(@PathParam("id") Integer id) {
		EducationDTO education = educationBean.get(id);
		if (education == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		return Response.ok().entity(education).build();
	}
}
