package users;

import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
@Stateless
public class Teacher extends Bruger implements TeacherRemote, TeacherLocal {

    
    
    public Teacher() {
        // TODO Auto-generated constructor stub
    }

}
