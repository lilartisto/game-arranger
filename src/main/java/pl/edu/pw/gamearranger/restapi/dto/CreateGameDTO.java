package pl.edu.pw.gamearranger.restapi.dto;

import java.sql.Date;
import java.sql.Time;

public class CreateGameDTO {

    private String location;
    private Date date;
    private Time time;

    public CreateGameDTO() {
    }

    public CreateGameDTO(String location, Date date, Time time) {
        this.location = location;
        this.date = date;
        this.time = time;
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
