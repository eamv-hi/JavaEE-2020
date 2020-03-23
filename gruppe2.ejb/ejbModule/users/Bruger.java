package users;

import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
@Stateless
public class Bruger implements BrugerRemote, BrugerLocal {

	@Id
    @GeneratedValue
    private int id;
    @NotNull
    private String name;
    @NotNull
    private String lastname;
    @NotNull
    private String email;
    @NotNull
    private int PhoneNm;
    @NotNull
    private String rolle;
    
    
    public Bruger() {
        // TODO Auto-generated constructor stub
    }

}
