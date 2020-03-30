package gruppe3.web;

import java.util.Date;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named("")
@RequestScoped
public class TeamOverview {
	private static final long serialVersionUID = 1L;
	
	private int teamId;
	private String teamName;
	private Date startDate;
	private Date endDate;
	private int educationId;
}
