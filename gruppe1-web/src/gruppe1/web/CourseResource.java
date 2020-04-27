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

import gruppe1.ejb.beans.CourseBeanLocal;
import gruppe1.ejbClient.entity.CourseDTO;

@Path("/course")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CourseResource {
	@Inject
	private CourseBeanLocal courseBean;

	@GET
	public Response getCourses() {
		List<CourseDTO> courses = courseBean.getAll();
		return Response.ok().entity(courses).build();
	}

	@GET
	@Path("/{id}")
	public Response getCourseById(@PathParam("id") Integer id) {
		CourseDTO course = courseBean.get(id);
		if (course == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		return Response.ok().entity(course).build();
	}
}
