package users;

import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
@Stateless
public class student extends User implements studentRemote, studentLocal {

	@NotNull
	private int studentNo;
   
    public student() {
        // TODO Auto-generated constructor stub
    }

}
