package pl.edu.pw.gamearranger.restapi.service;

import pl.edu.pw.gamearranger.restapi.dto.CreateGameDTO;
import pl.edu.pw.gamearranger.restapi.dto.GameDTO;
import java.util.List;

public interface GameService {

    List<GameDTO> getGames();
    GameDTO getGame(Long id);
    void createGame(CreateGameDTO game);
    void addTeam(Long gameId, Long teamId);
    void deleteTeam(Long gameId, Long teamId);

}
