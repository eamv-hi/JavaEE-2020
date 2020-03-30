package gruppe3.ejb.beans;

import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import gruppe3.ejb.entity.Team;
import gruppe3.ejbClient.DTO.TeamDTO;
import gruppe3.ejbClient.beans.TeamBeanLocal;
import gruppe3.ejbClient.beans.TeamBeanRemote;

/**
 * Session Bean implementation class TeamBean
 */
@Stateless
@LocalBean
public class TeamBean implements TeamBeanLocal, TeamBeanRemote {
	@PersistenceContext
	private EntityManager em;

	@Override
	public void Create(TeamDTO teamDTO) {
		if (teamDTO != null) {
			em.persist(fromDTO(new Team(), teamDTO));
		}
	}

	@Override
	public void Update(TeamDTO teamDTO) {
		Team entity = findTeam(teamDTO.getTeamId());
		
		if (entity != null && teamDTO != null) {
			em.persist(fromDTO(entity, teamDTO));
		}
	}

	@Override
	public void Delete(TeamDTO teamDTO) {
		Delete(teamDTO.getTeamId());
	}

	@Override
	public void Delete(int Id) {
		Team entity = findTeam(Id);
		
		if (entity != null) {
			em.remove(entity);
		}
	}

	@Override
	public TeamDTO get(int Id) {
		return findTeam(Id).toDTO();
	}

	@Override
	public List<TeamDTO> getAll() {
		return em.createNamedQuery("getAllTeams", Team.class)
				.getResultList()
				.stream()
				.map(t -> t.toDTO())
				.collect(Collectors.toList());
	}

	private Team fromDTO(Team team, TeamDTO teamDTO) {
		team.setTeamName(teamDTO.getTeamName());
		team.setStartDate(teamDTO.getStartDate());
		team.setEndDate(teamDTO.getEndDate());
		team.setEducationId(teamDTO.getEducationId());
		
		return team;
	}
	
	private Team findTeam(int id) {
		return em.find(Team.class, id);
	}
}
