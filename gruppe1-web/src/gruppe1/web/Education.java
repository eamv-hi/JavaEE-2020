package gruppe1.web;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import gruppe1.ejb.beans.EducationBeanLocal;
import gruppe1.ejbClient.entity.EducationDTO;

@Named("dtEducationView")
@RequestScoped
public class Education {
	private String educationId;
	private EducationDTO education;

	public String getEducationId() {
		return educationId;
	}

	public void setEducationId(String educationId) {
		this.educationId = educationId;
	}

	@Inject
	private EducationBeanLocal educationBean;

	public EducationDTO getEducation() {
		return educationBean.get(Integer.parseInt(educationId));
	}

	public String delete() {
		educationBean.delete(Integer.parseInt(educationId));
		return "schoolOverview?faces-redirect=true";
	}
}
