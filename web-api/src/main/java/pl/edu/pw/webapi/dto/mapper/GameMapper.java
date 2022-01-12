package pl.edu.pw.webapi.dto.mapper;

import pl.edu.pw.webapi.domain.Game;
import pl.edu.pw.webapi.dto.CreateGameDTO;
import pl.edu.pw.webapi.dto.GameDTO;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GameMapper {

    public List<GameDTO> map(List<Game> games){
        List<GameDTO> mappedGames = new LinkedList<>();

        for (Game g: games) {
            mappedGames.add(map(g));
        }

        return mappedGames;
    }

    public GameDTO map(Game game) {
        return new GameDTO(
                game.getId(),
                new TeamMapper().map(game.getTeams()),
                game.getLocation(),
                game.getDate()
        );
    }

    public Game map(CreateGameDTO game) {
        Game g = new Game();
        g.setLocation(game.getLocation());
        g.setDate(game.getDate());
        g.setTeams(new ArrayList<>());
        return g;
    }

    public List<GameDTO> mapWithGamelessTeams(List<Game> games){
        List<GameDTO> mappedGames = new LinkedList<>();

        for (Game g: games) {
            mappedGames.add(mapWithGamelessTeams(g));
        }

        return mappedGames;
    }

    public GameDTO mapWithGamelessTeams(Game game) {
        return new GameDTO(
                game.getId(),
                new TeamMapper().mapWithoutGames(game.getTeams()),
                game.getLocation(),
                game.getDate()
        );
    }

    public List<GameDTO> mapWithoutTeams(List<Game> games){
        List<GameDTO> mappedGames = new LinkedList<>();

        for (Game g: games) {
            mappedGames.add(mapWithoutTeams(g));
        }

        return mappedGames;
    }

    public GameDTO mapWithoutTeams(Game game) {
        return new GameDTO(
                game.getId(),
                null,
                game.getLocation(),
                game.getDate()
        );
    }
}
