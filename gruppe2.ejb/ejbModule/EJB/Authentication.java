package EJB;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javaee.dto.StudentDTO;
import javaee.dto.TeacherDTO;


@Stateless
@LocalBean
public class Authentication implements AuthenticationLocal {

	@PersistenceContext private EntityManager em;

	public void student_create(StudentDTO student) {
		// TODO Auto-generated method stub
		
	}

	public void teacher_create(TeacherDTO teacher) {
		// TODO Auto-generated method stub
		
	}

	public String student_read(StudentDTO student) {
		// TODO Auto-generated method stub
		return null;
	}

	public String teacher_read(TeacherDTO teacher) {
		// TODO Auto-generated method stub
		return null;
	}

	public void student_update(StudentDTO student) {
		// TODO Auto-generated method stub
		
	}

	public void teacher_update(TeacherDTO teacher) {
		// TODO Auto-generated method stub
		
	}

	public void student_delete(StudentDTO student) {
		// TODO Auto-generated method stub
		
	}

	public void teacher_delete(TeacherDTO teacher) {
		// TODO Auto-generated method stub
		
	}
    
	

}
