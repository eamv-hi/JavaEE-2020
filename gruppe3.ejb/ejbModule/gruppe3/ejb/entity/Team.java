package gruppe3.ejb.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import gruppe3.ejbClient.DTO.TeamDTO;

/**
 * Entity implementation class for Entity: Team
 *
 */
@Entity

public class Team implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
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
	
	public TeamDTO toDTO() {
		TeamDTO teamDTO = new TeamDTO();
		
		teamDTO.setTeamId(teamId);
		teamDTO.setTeamName(teamName);
		teamDTO.setStartDate(startDate);
		teamDTO.setEndDate(endDate);
		teamDTO.setEducationId(educationId);
		
		return teamDTO;
	}
	
	@Override
	public String toString() {
		return "Team [teamId=" + teamId + ", teamName=" + teamName + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", educationId=" + educationId + "]";
	}
}
