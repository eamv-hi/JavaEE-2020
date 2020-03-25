package gruppe1.ejb.beans;

import java.util.List;
import javax.ejb.Remote;
import gruppe1.ejbClient.entity.EducationDTO;

@Remote
public interface EducationBeanRemote {
	EducationDTO get(int id);
	
	List<EducationDTO> getAll();
}
