package gruppe2.web;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import EJB.AuthenticationLocal;
import javaee.dto.TeacherDTO;


@Named
@RequestScoped
public class Teacher_bean {

	@EJB
	private AuthenticationLocal ejb;
	
    public Teacher_bean() {
    	
    }
    
    public void make_teacher() {
    	TeacherDTO teacherdto = new TeacherDTO();
		teacherdto.setFirstName("firstName");
		teacherdto.setLastName("lastName");
		teacherdto.setPhoneNo("phoneNo");
		teacherdto.setEmail("email");
		teacherdto.setRole("role");
		
    	ejb.teacher_create(teacherdto);
    	
    }

}
