package pl.edu.pw.gamearranger.restapi.service;

import org.springframework.stereotype.Service;
import pl.edu.pw.gamearranger.restapi.domain.Game;
import pl.edu.pw.gamearranger.restapi.domain.Team;
import pl.edu.pw.gamearranger.restapi.dto.CreateGameDTO;
import pl.edu.pw.gamearranger.restapi.dto.GameDTO;
import pl.edu.pw.gamearranger.restapi.dto.mapper.GameMapper;
import pl.edu.pw.gamearranger.restapi.repository.GameRepository;
import pl.edu.pw.gamearranger.restapi.repository.TeamRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class GameServiceImpl implements GameService {

    private GameRepository gameRepository;
    private TeamRepository teamRepository;

    public GameServiceImpl(GameRepository gameRepository, TeamRepository teamRepository) {
        this.gameRepository = gameRepository;
        this.teamRepository = teamRepository;
    }

    @Override
    public List<GameDTO> getGames() {
        return new GameMapper().map(gameRepository.findAll());
    }

    @Override
    public GameDTO getGame(Long id) {
        Optional<Game> game = gameRepository.findById(id);
        if(game.isPresent()) {
            return new GameMapper().map(game.get());
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

        game.getTeams().add(team);
    }

    @Override
    @Transactional
    public void deleteTeam(Long gameId, Long teamId) {
        Game game = gameRepository.findById(gameId).orElseThrow(
                () -> new NoSuchElementException("Game with id = " + gameId));
        Team team = teamRepository.findById(teamId).orElseThrow(
                () -> new NoSuchElementException("Team with id = " + teamId));

        game.getTeams().remove(team);
    }
}
