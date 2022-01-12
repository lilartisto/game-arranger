package pl.edu.pw.webapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import pl.edu.pw.webapi.domain.Game;
import pl.edu.pw.webapi.domain.Player;
import pl.edu.pw.webapi.domain.TeamCaptain;

import java.util.List;

public class TeamDTO {

    private Long id;
    private String name;
    private TeamCaptainDTO captain;
    private List<PlayerDTO> players;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<GameDTO> games;

    public TeamDTO() {
    }

    public TeamDTO(Long id, String name, TeamCaptainDTO captain, List<PlayerDTO> players, List<GameDTO> games) {
        this.id = id;
        this.name = name;
        this.captain = captain;
        this.players = players;
        this.games = games;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TeamCaptainDTO getCaptain() {
        return captain;
    }

    public void setCaptain(TeamCaptainDTO captain) {
        this.captain = captain;
    }

    public List<PlayerDTO> getPlayers() {
        return players;
    }

    public void setPlayers(List<PlayerDTO> players) {
        this.players = players;
    }

    public List<GameDTO> getGames() {
        return games;
    }

    public void setGames(List<GameDTO> games) {
        this.games = games;
    }
}
