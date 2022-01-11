package pl.edu.pw.gamearranger.restapi.controller;

import org.springframework.web.bind.annotation.*;
import pl.edu.pw.gamearranger.restapi.dto.CreateGameDTO;
import pl.edu.pw.gamearranger.restapi.dto.GameDTO;
import pl.edu.pw.gamearranger.restapi.service.GameService;

import java.util.List;

@RestController
@RequestMapping("api/game")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping
    public List<GameDTO> getGames() {
        return gameService.getGames();
    }

    @GetMapping(path = "{gameId}")
    public GameDTO getGame(@PathVariable("gameId") Long id) {
        return gameService.getGame(id);
    }

    @PostMapping
    public void createGame(@RequestBody CreateGameDTO game){
        gameService.createGame(game);
    }

    @PutMapping(path = "{gameId}/{teamId}")
    public void addTeamToGame(@PathVariable("gameId") Long gameId, @PathVariable("teamId") Long teamId) {
        gameService.addTeam(gameId, teamId);
    }

    @DeleteMapping(path = "{gameId}/{teamId}")
    public void deleteTeamFromGame(@PathVariable("gameId") Long gameId, @PathVariable("teamId") Long teamId) {
        gameService.deleteTeam(gameId, teamId);
    }


}
