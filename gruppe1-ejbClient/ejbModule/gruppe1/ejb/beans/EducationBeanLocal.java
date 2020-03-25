package gruppe1.ejb.beans;

import java.util.List;
import javax.ejb.Local;
import gruppe1.ejbClient.entity.EducationDTO;

@Local
public interface EducationBeanLocal {
	void create(EducationDTO education);
	
	void update(EducationDTO education);
	
	void delete(int id);

	EducationDTO get(int id);
	
	List<EducationDTO> getAll();
}
