package EJB;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import javaee.dto.StudentDTO;
import javaee.dto.TeacherDTO;
import users.Student;
import users.Teacher;


@Stateless
public class Authentication implements AuthenticationLocal {

	@PersistenceContext private EntityManager em;
	public List<TeacherDTO> list = new ArrayList<> ();

	public void student_create(StudentDTO student) {
		Student newstudent = new Student();
		newstudent.setId(student.getId());
		newstudent.setFirstName(student.getFirstName());
		newstudent.setLastname(student.getLastName());
		newstudent.setEmail(student.getEmail());
		newstudent.setPhoneNo(student.getPhoneNo());
		newstudent.setRole(student.getRole());
		newstudent.setStudentNo(student.getStudentNo());
		newstudent.setSubject(student.getSubject());
		em.persist(newstudent);
		
	}

	public void teacher_create(TeacherDTO teacher) {
		Teacher newteacher = new Teacher();
		newteacher.setId(teacher.getId());
		newteacher.setFirstName(teacher.getFirstName());
		newteacher.setLastname(teacher.getLastName());
		newteacher.setEmail(teacher.getEmail());
		newteacher.setPhoneNo(teacher.getPhoneNo());
		newteacher.setRole(teacher.getRole());
		newteacher.setTeacherNo(teacher.getTeacherNo());
		newteacher.setHiredDate(teacher.getHiredDate());
		newteacher.setJobTitle(teacher.getJobTitle());
		em.persist(newteacher);
	}

	public StudentDTO student_read(int id) {
		Student findstudent = em.find(Student.class, id);
		if(findstudent != null) {
			return findstudent.todto();
		}	else {
			throw new RuntimeException("Kunne ikke finde studerende" + id);
		}
	}

	public TeacherDTO teacher_read(int id) {
		Teacher findteacher = em.find(Teacher.class, id);
		if(findteacher != null){
			return findteacher.todto();
		}else {
			throw new RuntimeException("Kunne ikke finde studerende" + id);
		}
	}
	
	public List<TeacherDTO> teacher_readall() {
		Teacher findteacher = em.find(Teacher.class, "SELECT * FROM \"PUBLIC\".\"TEACHER_USER\"");
		while(findteacher != null){
			list.add(findteacher.todto());
		}
			return list;
		
	}

	public void student_update(StudentDTO student) {
		Student updatestudent = em.find(Student.class, student);
		if(updatestudent != null) {
			updatestudent.setFirstName(student.getFirstName());
			updatestudent.setLastname(student.getLastName());
			updatestudent.setEmail(student.getEmail());
			updatestudent.setPhoneNo(student.getPhoneNo());
			updatestudent.setSubject(student.getSubject());
		} else {
			throw new RuntimeException("Kunne ikke finde studerende " + student.getFirstName());
		}
		
	}

	public void teacher_update(TeacherDTO teacher) {
		Teacher updateteacher = em.find(Teacher.class, teacher);
		if(updateteacher != null) {
			updateteacher.setFirstName(teacher.getFirstName());
			updateteacher.setLastname(teacher.getLastName());
			updateteacher.setEmail(teacher.getEmail());
			updateteacher.setPhoneNo(teacher.getPhoneNo());
			updateteacher.setRole(teacher.getRole());
			updateteacher.setJobTitle(teacher.getJobTitle());
			
		} else {
			throw new RuntimeException("Kunne ikke finde studerende " + teacher.getFirstName());
		}
		
	}

	public void student_delete(StudentDTO student) {
		Student deletestudent = em.find(Student.class, student);
		if(deletestudent != null) {
			em.remove(deletestudent);
		} else {
			throw new RuntimeException("eleven med navnet: " + student.getFirstName() + "kunne ikke findes");
		}
		
	}

	public void teacher_delete(TeacherDTO teacher) {
		Teacher deleteteacher = em.find(Teacher.class, teacher);
		if(deleteteacher != null) {
			em.remove(deleteteacher);
		} else {
			throw new RuntimeException("eleven med navnet: " + teacher.getFirstName() + "kunne ikke findes");
		}
		
	}

    
	

}
