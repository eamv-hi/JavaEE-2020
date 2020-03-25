package gruppe1.ejb.beans;

import java.util.List;
import javax.ejb.Remote;
import gruppe1.ejbClient.entity.CourseDTO;

@Remote
public interface CourseBeanRemote {
	CourseDTO get(int id);
	
	List<CourseDTO> getAll();
}
