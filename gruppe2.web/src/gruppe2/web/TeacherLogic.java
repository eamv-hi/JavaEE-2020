package gruppe2.web;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import javaee.dto.TeacherDTO;

@Named
@RequestScoped

public class TeacherLogic {

	
	public TeacherDTO teachers() {
		TeacherDTO teacherdto = new TeacherDTO();
		teacherdto.setFirstName("Karl");
		teacherdto.setLastName("Karlsen");
		teacherdto.setPhoneNo(648576);
		teacherdto.setEmail("test@test.dk");
		teacherdto.setRole("Teacher");
		return teacherdto;
	}
	
	
}
