package pl.edu.pw.gamearranger.restapi.service;

import java.util.List;

import pl.edu.pw.gamearranger.restapi.dto.CreatePlayerDTO;
import pl.edu.pw.gamearranger.restapi.dto.CreateTeamDTO;
import pl.edu.pw.gamearranger.restapi.dto.TeamDTO;

public interface TeamService {

    void createTeam(CreateTeamDTO team);
    List<TeamDTO> getTeams();
    TeamDTO getTeam(Long id);
    void addPlayer(Long teamId, CreatePlayerDTO player);
    void deletePlayer(Long teamId, Long playerId);

}
