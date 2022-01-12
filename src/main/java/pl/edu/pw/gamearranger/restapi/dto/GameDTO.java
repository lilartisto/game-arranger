package pl.edu.pw.gamearranger.restapi.dto;

import pl.edu.pw.gamearranger.restapi.domain.Team;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

public class GameDTO {

    private Long id;
    private List<Team> teams;
    private String location;
    private Date date;

    public GameDTO() {
    }

    public GameDTO(Long id, List<Team> teams, String location, Date date) {
        this.id = id;
        this.teams = teams;
        this.location = location;
        this.date = date;
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
}
