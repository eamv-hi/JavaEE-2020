package gruppe3.ejbClient.DTO;

import java.util.Date;

public class TeamDTO {

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
	public int getTeamId() { return teamId; }
	public void setTeamId(int teamId) { this.teamId = teamId; }
	
}
