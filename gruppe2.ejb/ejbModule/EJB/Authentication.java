package EJB;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jboss.security.auth.spi.Users.User;

import javaee.dto.StudentDTO;
import users.Student;


@Stateless
@LocalBean
public class Authentication implements AuthenticationLocal {

	@PersistenceContext private EntityManager em;
    
	public void createStudent(StudentDTO student) {
		User users = new User();
	}

}
