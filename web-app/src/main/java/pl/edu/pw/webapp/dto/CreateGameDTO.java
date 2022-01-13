package pl.edu.pw.webapp.dto;

import java.sql.Date;

public class CreateGameDTO {

    private String location;
    private Date date;

    public CreateGameDTO() {
    }

    public CreateGameDTO(String location, Date date) {
        this.location = location;
        this.date = date;
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
