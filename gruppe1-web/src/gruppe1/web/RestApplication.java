package gruppe1.web;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

// https://eclipse-ee4j.github.io/jakartaee-tutorial/jaxrs.html#GIEPU
// https://www.baeldung.com/jax-rs-spec-and-implementations
// https://restfulapi.net/create-rest-apis-with-jax-rs-2-0/

@ApplicationPath("/api")
@Produces(MediaType.APPLICATION_JSON)
//@Consumes(MediaType.APPLICATION_JSON)
public class RestApplication extends Application {
}
