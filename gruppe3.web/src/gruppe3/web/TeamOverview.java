package gruppe3.web;

import java.util.Date;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import gruppe3.ejbClient.DTO.TeamDTO;
import gruppe3.ejbClient.beans.TeamBeanLocal;

@Named("dtTeamView")
@RequestScoped
public class TeamOverview {
	private static final long serialVersionUID = 1L;
	
	private int teamId;
	private String teamName;
	private Date startDate;
	private Date endDate;
	private int educationId;
	
	public String getTeamName() { return teamName; }
	public void setTeamName(String teamName) { this.teamName = teamName; }
	public Date getStartDate() { return startDate; }
	public void setStartDate(Date startDate) { this.startDate = startDate; }
	public Date getEndDate() { return endDate; }
	public void setEndDate(Date endDate) { this.endDate = endDate; }
	public int getEducationId() { return educationId; }
	public void setEducationId(int educationId) { this.educationId = educationId; }
	
	@Inject
	private TeamBeanLocal team;
	
	public List<TeamDTO> getTeams() {
		return team.getAll();
	}
	
	public void addTeam() {
		TeamDTO teamDTO = new TeamDTO();
		
		teamDTO.setTeamName(teamName);
		teamDTO.setStartDate(startDate);
		teamDTO.setEndDate(endDate);
		teamDTO.setEducationId(educationId);
		
		team.Create(teamDTO);
	}
}
