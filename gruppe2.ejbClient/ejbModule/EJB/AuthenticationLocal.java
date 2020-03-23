package EJB;

import javax.ejb.Local;

import javaee.dto.StudentDTO;
import javaee.dto.TeacherDTO;

@Local
public interface AuthenticationLocal {

	
	public void student_create(StudentDTO student);
	
	public void teacher_create(TeacherDTO teacher);
	
	public String student_read(StudentDTO student);

	public String teacher_read(TeacherDTO teacher);
	
	public void student_update(StudentDTO student);

	public void teacher_update(TeacherDTO teacher);
	
	public void student_delete(StudentDTO student);

	public void teacher_delete(TeacherDTO teacher);
	
}
