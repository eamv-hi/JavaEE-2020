package gruppe3.ejbClient.beans;

import java.util.List;
import javax.ejb.Remote;
import gruppe3.ejbClient.DTO.TeamDTO;

@Remote
public interface TeamBeanRemote {
	TeamDTO get(int Id);
	
	List<TeamDTO> getAll();
}
