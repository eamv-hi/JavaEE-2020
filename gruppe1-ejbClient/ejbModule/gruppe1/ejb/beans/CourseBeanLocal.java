package gruppe1.ejb.beans;

import java.util.List;
import javax.ejb.Local;
import gruppe1.ejbClient.entity.CourseDTO;

@Local
public interface CourseBeanLocal {
	void create(CourseDTO course);

	void update(CourseDTO course);

	void delete(int id);

	CourseDTO get(int id);

	List<CourseDTO> getAll();
}
