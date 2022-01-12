package pl.edu.pw.webapi.service;

import pl.edu.pw.webapi.dto.CreateGameDTO;
import pl.edu.pw.webapi.dto.GameDTO;

import java.util.List;

public interface GameService {

    List<GameDTO> getGames();
    GameDTO getGame(Long id);
    void createGame(CreateGameDTO game);
    void addTeam(Long gameId, Long teamId);
    void deleteTeam(Long gameId, Long teamId);

}
