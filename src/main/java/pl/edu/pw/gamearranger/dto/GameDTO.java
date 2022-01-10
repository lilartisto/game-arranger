package pl.edu.pw.gamearranger.dto;

import pl.edu.pw.gamearranger.domain.Team;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

public class GameDTO {

    private Long id;
    private List<Team> teams;
    private String location;
    private Date date;
    private Time time;

    public GameDTO() {
    }

    public GameDTO(List<Team> teams, String location, Date date, Time time) {
        this.teams = teams;
        this.location = location;
        this.date = date;
        this.time = time;
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
}
