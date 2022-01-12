package pl.edu.pw.gamearranger.restapi.dto.mapper;

import pl.edu.pw.gamearranger.restapi.domain.Game;
import pl.edu.pw.gamearranger.restapi.dto.CreateGameDTO;
import pl.edu.pw.gamearranger.restapi.dto.GameDTO;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GameMapper {

    public List<GameDTO> map(List<Game> games){
        List<GameDTO> mappedGames = new LinkedList<>();

        for (Game g: games) {
            mappedGames.add(new GameDTO(g.getId(), g.getTeams(), g.getLocation(), g.getDate()));
        }

        return mappedGames;
    }

    public GameDTO map(Game game) {
        return new GameDTO(game.getId(), game.getTeams(), game.getLocation(), game.getDate());
    }

    public Game map(CreateGameDTO game) {
        Game g = new Game();
        g.setLocation(game.getLocation());
        g.setDate(game.getDate());
        g.setTeams(new ArrayList<>());
        return g;
    }
}
