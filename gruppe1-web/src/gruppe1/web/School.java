package gruppe1.web;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import gruppe1.ejb.beans.SchoolBeanLocal;
import gruppe1.ejbClient.entity.SchoolDTO;

@Named("dtSchoolView")
@RequestScoped
public class School {
	private String schoolId;
	private SchoolDTO school;

	public String getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
	}

	@Inject
	private SchoolBeanLocal schoolBean;

	public SchoolDTO getSchool() {
		return schoolBean.get(Integer.parseInt(schoolId));
	}

	public String delete() {
		schoolBean.delete(Integer.parseInt(schoolId));
		return "schoolOverview?faces-redirect=true";
	}
}
