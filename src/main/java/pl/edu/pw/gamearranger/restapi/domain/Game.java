package pl.edu.pw.gamearranger.restapi.domain;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Objects;

@Entity
@Table
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private List<Team> teams;
    private String location;
    private Date date;
    private Time time;

    public Game() {
    }

    public Game(Long id, List<Team> teams, String location, Date date, Time time) {
        this.id = id;
        this.teams = teams;
        this.location = location;
        this.date = date;
        this.time = time;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return Objects.equals(id, game.id) && Objects.equals(teams, game.teams) && Objects.equals(location, game.location) && Objects.equals(date, game.date) && Objects.equals(time, game.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, teams, location, date, time);
    }
}
