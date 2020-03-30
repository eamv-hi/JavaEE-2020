package EJB;

import javax.ejb.Local;

import javaee.dto.StudentDTO;
import javaee.dto.TeacherDTO;

@Local
public interface AuthenticationLocal {

	
	public void student_create(StudentDTO student);
	
	public void teacher_create(TeacherDTO teacher);
	
	public StudentDTO student_read(int id);

	public TeacherDTO teacher_read(int id);
	
	public void student_update(StudentDTO student);

	public void teacher_update(TeacherDTO teacher);
	
	public void student_delete(StudentDTO student);

	public void teacher_delete(TeacherDTO teacher);
	
}
