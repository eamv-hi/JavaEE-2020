package users;

import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
@Stateless
public class student extends Bruger implements studentRemote, studentLocal {

	
   
    public student() {
        // TODO Auto-generated constructor stub
    }

}
