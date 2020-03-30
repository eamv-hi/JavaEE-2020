package gruppe3.ejbClient.beans;

import java.util.List;
import javax.ejb.Local;
import gruppe3.ejbClient.DTO.TeamDTO;

@Local
public interface TeamBeanLocal {
	void Create(TeamDTO teamDTO);
	
	void Update(TeamDTO teamDTO);
	
	void Delete(TeamDTO teamDTO);
	void Delete(int Id);
	
	TeamDTO get(int Id);
	
	List<TeamDTO> getAll();
}
