package pl.edu.pw.webapi.service;

import java.util.List;

import pl.edu.pw.webapi.dto.CreatePlayerDTO;
import pl.edu.pw.webapi.dto.CreateTeamDTO;
import pl.edu.pw.webapi.dto.TeamDTO;

public interface TeamService {

    void createTeam(CreateTeamDTO team);
    List<TeamDTO> getTeams();
    TeamDTO getTeam(Long id);
    void addPlayer(Long teamId, CreatePlayerDTO player);
    void deletePlayer(Long teamId, Long playerId);

}
