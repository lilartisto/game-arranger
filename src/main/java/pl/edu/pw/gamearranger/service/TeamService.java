package pl.edu.pw.gamearranger.service;

import java.util.List;
import pl.edu.pw.gamearranger.domain.Team;
import pl.edu.pw.gamearranger.dto.CreatePlayerDTO;
import pl.edu.pw.gamearranger.dto.CreateTeamDTO;
import pl.edu.pw.gamearranger.dto.TeamDTO;

public interface TeamService {

    void createTeam(CreateTeamDTO team);
    List<TeamDTO> getTeams();
    TeamDTO getTeam(Long id);
    void addPlayer(Long teamId, CreatePlayerDTO player);
    void deletePlayer(Long teamId, Long playerId);

}
