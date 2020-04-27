package gruppe3.web;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import gruppe3.ejbClient.DTO.TeamDTO;
import gruppe3.ejbClient.beans.TeamBeanLocal;

@Named("dtTeamView")
@RequestScoped
public class TeamOverview implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int teamId;
	private String teamName;
	private LocalDate startDate;
	private LocalDate endDate;
	private int educationId;
	private String option;
	
	public String getTeamName() { return teamName; }
	public void setTeamName(String teamName) { this.teamName = teamName; }
	public LocalDate getStartDate() { return startDate; }
	public void setStartDate(LocalDate startDate) { this.startDate = startDate; }
	public LocalDate getEndDate() { return endDate; }
	public void setEndDate(LocalDate endDate) { this.endDate = endDate; }
	public int getEducationId() { return educationId; }
	public void setEducationId(int educationId) { this.educationId = educationId; }
	public String getOption() { return option;}
	public void setOption(String option) {
		this.option = option;
		educationId = Integer.parseInt(option);
	}
	
	@Inject
	private TeamBeanLocal team;
	
	public List<TeamDTO> getTeams() {
		return team.getAll();
	}
	
//	public void addTeam(TeamDTO teamDTO) {
//		team.Create(teamDTO);
//	}
	
	public void addTeam() {
		TeamDTO teamDTO = new TeamDTO();
		
		teamDTO.setTeamName(teamName);
		teamDTO.setStartDate(startDate);
		teamDTO.setEndDate(endDate);
		teamDTO.setEducationId(educationId);
		
		team.Create(teamDTO);
	}
}
