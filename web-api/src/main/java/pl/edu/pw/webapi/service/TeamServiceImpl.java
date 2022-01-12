package pl.edu.pw.webapi.service;

import org.springframework.stereotype.Service;
import pl.edu.pw.webapi.domain.Player;
import pl.edu.pw.webapi.domain.Team;
import pl.edu.pw.webapi.domain.TeamCaptain;
import pl.edu.pw.webapi.dto.CreatePlayerDTO;
import pl.edu.pw.webapi.dto.CreateTeamDTO;
import pl.edu.pw.webapi.dto.TeamDTO;
import pl.edu.pw.webapi.dto.mapper.TeamMapper;
import pl.edu.pw.webapi.repository.TeamRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;
    private final TeamCaptainService teamCaptainService;
    private final PlayerService playerService;

    public TeamServiceImpl(TeamRepository teamRepository, TeamCaptainService teamCaptainService, PlayerService playerService) {
        this.teamRepository = teamRepository;
        this.teamCaptainService = teamCaptainService;
        this.playerService = playerService;
    }

    @Override
    @Transactional
    public void createTeam(CreateTeamDTO team) {
        TeamCaptain teamCaptain = teamCaptainService.getTeamCaptain(team.getCaptainId());
        Team t = new TeamMapper().map(team, teamCaptain);

        teamRepository.save(t);
        teamCaptain.setTeam(t);
    }

    @Override
    public List<TeamDTO> getTeams() {
        return new TeamMapper().mapWithTeamlessGameAndCaptain(teamRepository.findAll());
    }

    @Override
    public TeamDTO getTeam(Long id) {
        Optional<Team> teamOptional = teamRepository.findById(id);
        if(teamOptional.isPresent()) {
            return new TeamMapper().mapWithTeamlessGameAndCaptain(teamOptional.get());
        } else {
            return null;
        }
    }

    @Override
    @Transactional
    public void addPlayer(Long teamId, CreatePlayerDTO playerCreate) {
        Team team = teamRepository.findById(teamId).orElseThrow(
                () -> new NoSuchElementException("Team with id = " + teamId));

        Player player = playerService.addPlayer(playerCreate);
        team.getPlayers().add(player);
    }

    @Override
    public void deletePlayer(Long teamId, Long playerId) {
        Team team = teamRepository.findById(teamId).orElseThrow(
                () -> new NoSuchElementException("Team with id = " + teamId));

        team.getPlayers().removeIf(player -> (player.getId().equals(playerId)));
        playerService.deletePlayer(playerId);
    }
}
