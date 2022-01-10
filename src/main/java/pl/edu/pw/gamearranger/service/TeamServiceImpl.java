package pl.edu.pw.gamearranger.service;

import org.springframework.stereotype.Service;
import pl.edu.pw.gamearranger.domain.Player;
import pl.edu.pw.gamearranger.domain.Team;
import pl.edu.pw.gamearranger.domain.TeamCaptain;
import pl.edu.pw.gamearranger.dto.CreatePlayerDTO;
import pl.edu.pw.gamearranger.dto.CreateTeamDTO;
import pl.edu.pw.gamearranger.dto.TeamDTO;
import pl.edu.pw.gamearranger.dto.mapper.PlayerMapper;
import pl.edu.pw.gamearranger.dto.mapper.TeamMapper;
import pl.edu.pw.gamearranger.repository.PlayerRepository;
import pl.edu.pw.gamearranger.repository.TeamCaptainRepository;
import pl.edu.pw.gamearranger.repository.TeamRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;
    private final TeamCaptainRepository teamCaptainRepository;
    private final PlayerRepository playerRepository;
    private final PlayerService playerService;

    public TeamServiceImpl(TeamRepository teamRepository, TeamCaptainRepository teamCaptainRepository,
                           PlayerRepository playerRepository, PlayerService playerService) {
        this.teamRepository = teamRepository;
        this.teamCaptainRepository = teamCaptainRepository;
        this.playerRepository = playerRepository;
        this.playerService = playerService;
    }

    @Override
    @Transactional
    public void createTeam(CreateTeamDTO team) {
        TeamCaptain teamCaptain = teamCaptainRepository.findById(team.getCaptainId()).orElseThrow(
                () -> new NoSuchElementException("Team captain with id = " + team.getCaptainId()));

        Team t = new TeamMapper().map(team, teamCaptain);

        teamRepository.save(t);
        teamCaptain.setTeam(t);
    }

    @Override
    public List<TeamDTO> getTeams() {
        return new TeamMapper().map(teamRepository.findAll());
    }

    @Override
    public TeamDTO getTeam(Long id) {
        Optional<Team> teamOptional = teamRepository.findById(id);
        if(teamOptional.isPresent()) {
            return new TeamMapper().map(teamOptional.get());
        } else {
            return null;
        }
    }

    @Override
    @Transactional
    public void addPlayer(Long teamId, CreatePlayerDTO playerCreate) {
        Team team = teamRepository.findById(teamId).orElseThrow(
                () -> new NoSuchElementException("Team with id = " + teamId));
        Player player = new PlayerMapper().map(playerCreate);

        playerRepository.save(player);
        team.getPlayers().add(player);
    }

    @Override
    public void deletePlayer(Long teamId, Long playerId) {
        Team team = teamRepository.findById(teamId).orElseThrow(
                () -> new NoSuchElementException("Team with id = " + teamId));

        playerService.deletePlayer(playerId);
        team.getPlayers().removeIf(player -> (player.getId().equals(playerId)));
    }
}
