package gruppe3.ejbClient.beans;

import java.util.List;
import javax.ejb.Local;
import gruppe3.ejbClient.DTO.EducationDTO;

@Local
public interface EducationBeanLocal {
	EducationDTO getEducation(String educationId);
	List<EducationDTO> getAllEducations();
}
