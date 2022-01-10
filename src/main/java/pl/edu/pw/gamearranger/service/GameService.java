package pl.edu.pw.gamearranger.service;

import pl.edu.pw.gamearranger.dto.CreateGameDTO;
import pl.edu.pw.gamearranger.dto.GameDTO;
import java.util.List;

public interface GameService {

    List<GameDTO> getGames();
    GameDTO getGame(Long id);
    void createGame(CreateGameDTO game);
    void addTeam(Long gameId, Long teamId);
    void deleteTeam(Long id);

}
