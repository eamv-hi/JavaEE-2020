package gruppe1.ejb.beans;

import java.util.List;
import javax.ejb.Local;
import gruppe1.ejbClient.entity.SchoolDTO;

@Local
public interface SchoolBeanLocal {
	SchoolDTO create(SchoolDTO school);

	void update(SchoolDTO school);

	void delete(int id);

	SchoolDTO get(int id);

	List<SchoolDTO> getAll();
}
