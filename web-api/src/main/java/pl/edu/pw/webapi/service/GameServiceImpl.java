package pl.edu.pw.webapi.service;

import org.springframework.stereotype.Service;
import pl.edu.pw.webapi.domain.Game;
import pl.edu.pw.webapi.domain.Team;
import pl.edu.pw.webapi.dto.CreateGameDTO;
import pl.edu.pw.webapi.dto.GameDTO;
import pl.edu.pw.webapi.dto.mapper.GameMapper;
import pl.edu.pw.webapi.repository.GameRepository;
import pl.edu.pw.webapi.repository.TeamRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;
    private final TeamRepository teamRepository;

    public GameServiceImpl(GameRepository gameRepository, TeamRepository teamRepository) {
        this.gameRepository = gameRepository;
        this.teamRepository = teamRepository;
    }

    @Override
    public List<GameDTO> getGames() {
        return new GameMapper().mapWithGamelessTeams(gameRepository.findAll());
    }

    @Override
    public GameDTO getGame(Long id) {
        Optional<Game> game = gameRepository.findById(id);
        if(game.isPresent()) {
            return new GameMapper().mapWithGamelessTeams(game.get());
        } else {
            return null;
        }
    }

    @Override
    public void createGame(CreateGameDTO game) {
        gameRepository.save(new GameMapper().map(game));
    }

    @Override
    @Transactional
    public void addTeam(Long gameId, Long teamId) {
        Game game = gameRepository.findById(gameId).orElseThrow(
                () -> new NoSuchElementException("Game with id = " + gameId));
        Team team = teamRepository.findById(teamId).orElseThrow(
                () -> new NoSuchElementException("Team with id = " + teamId));

        List<Team> teamsInGame = game.getTeams();

        if(!teamsInGame.contains(team)) {
            team.getGames().add(game);
            teamsInGame.add(team);
        } else {
            throw new IllegalArgumentException("Team " + teamId + " is already signed in game " + gameId);
        }
    }

    @Override
    @Transactional
    public void deleteTeam(Long gameId, Long teamId) {
        Game game = gameRepository.findById(gameId).orElseThrow(
                () -> new NoSuchElementException("Game with id = " + gameId));
        Team team = teamRepository.findById(teamId).orElseThrow(
                () -> new NoSuchElementException("Team with id = " + teamId));

        game.getTeams().remove(team);
        team.getGames().remove(game);
    }
}
