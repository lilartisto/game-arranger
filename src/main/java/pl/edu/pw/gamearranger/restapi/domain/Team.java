package pl.edu.pw.gamearranger.restapi.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Table
@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToOne
    private TeamCaptain captain;
    @OneToMany
    private List<Player> players;
    @ManyToMany
    private List<Game> games;

    public Team() {

    }

    public Team(Long id, TeamCaptain captain, List<Player> players, List<Game> games, String name) {
        this.id = id;
        this.captain = captain;
        this.players = players;
        this.games = games;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return Objects.equals(id, team.id) && Objects.equals(name, team.name) && Objects.equals(captain, team.captain) && Objects.equals(players, team.players) && Objects.equals(games, team.games);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, captain, players, games);
    }
}
