package users;

import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
@Stateless
public class Teacher extends User implements TeacherRemote, TeacherLocal {

	@NotNull
    private int teacherNo;
	@NotNull
	private String hiredDate;
	@NotNull
	private String jobTitle;
	
    public Teacher() {
        // TODO Auto-generated constructor stub
    }

}
