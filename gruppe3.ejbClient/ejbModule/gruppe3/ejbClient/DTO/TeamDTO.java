package gruppe3.ejbClient.DTO;

import java.time.LocalDate;

public class TeamDTO {

	private int teamId;
	private String teamName;
	private LocalDate startDate;
	private LocalDate endDate;
	private int educationId;
	
	public String getTeamName() { return teamName; }
	public void setTeamName(String teamName) { this.teamName = teamName; }
	public LocalDate getStartDate() { return startDate; }
	public void setStartDate(LocalDate startDate) { this.startDate = startDate; }
	public LocalDate getEndDate() { return endDate; }
	public void setEndDate(LocalDate endDate) { this.endDate = endDate; }
	public int getEducationId() { return educationId; }
	public void setEducationId(int educationId) { this.educationId = educationId; }
	public int getTeamId() { return teamId; }
	public void setTeamId(int teamId) { this.teamId = teamId; }
	
}
