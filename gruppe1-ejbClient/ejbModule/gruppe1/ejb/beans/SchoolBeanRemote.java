package gruppe1.ejb.beans;

import java.util.List;
import javax.ejb.Remote;
import gruppe1.ejbClient.entity.SchoolDTO;

@Remote
public interface SchoolBeanRemote {
	SchoolDTO get(int id);
	
	List<SchoolDTO> getAll();
}
