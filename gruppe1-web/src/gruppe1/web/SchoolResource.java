package gruppe1.web;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import gruppe1.ejb.beans.SchoolBeanLocal;
import gruppe1.ejbClient.entity.SchoolDTO;

// https://eclipse-ee4j.github.io/jakartaee-tutorial/jaxrs.html#GIEPU
// https://www.baeldung.com/jax-rs-spec-and-implementations
// https://restfulapi.net/create-rest-apis-with-jax-rs-2-0/

@Path("/school")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SchoolResource {

	@Inject
	private SchoolBeanLocal schoolBean;

	@GET
	public Response getSchools() {
		List<SchoolDTO> schools = schoolBean.getAll();
		return Response.ok().entity(schools).build();
	}

	@GET
	@Path("/{id}")
	public Response getSchoolById(@PathParam("id") Integer id) {
		SchoolDTO school = schoolBean.get(id);
		if (school == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		return Response.ok().entity(school).build();
	}

//	@POST
//	public Response createSchool(SchoolDTO schoolDTO) {
//		schoolDTO = schoolBean.create(schoolDTO);
//		return Response.status(Response.Status.CREATED).entity(schoolDTO).build();
//	}
//
//	@PUT
//	@Path("/{id}")
//	public Response updateSchool(@PathParam("id") Integer id, SchoolDTO schoolDTO) {
//		if (schoolBean.get(id) == null) {
//			return Response.status(Response.Status.NOT_FOUND).build();
//		}
//		schoolBean.update(schoolDTO);
//		return Response.status(Response.Status.NO_CONTENT).build();
//	}
//
//	@DELETE
//	@Path("/{id}")
//	public Response deleteSchool(@PathParam("id") Integer id) {
//		schoolBean.delete(id);
//		// TODO: Returner 404 hvis den ikke findes
//		return Response.ok().build();
//	}
}
