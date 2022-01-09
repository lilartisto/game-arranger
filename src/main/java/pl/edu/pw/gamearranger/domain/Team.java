package pl.edu.pw.gamearranger.domain;

import javax.persistence.*;
import java.util.List;

@Table
@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private TeamCaptain captain;
    private List<Player> players;
    private List<Game> games;

    public Team() {

    }

    public Team(Long id, TeamCaptain captain, List<Player> players, List<Game> games) {
        this.id = id;
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

    public TeamCaptain getCaptain() {
        return captain;
    }

    public void setCaptain(TeamCaptain captain) {
        this.captain = captain;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }
}
