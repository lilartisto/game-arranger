package pl.edu.pw.webapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import pl.edu.pw.webapi.domain.Team;

public class TeamCaptainDTO {

    private Long id;
    private String firstName;
    private String lastName;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private TeamDTO team;

    public TeamCaptainDTO() {
    }

    public TeamCaptainDTO(Long id, String firstName, String lastName, TeamDTO team) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.team = team;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public TeamDTO getTeam() {
        return team;
    }

    public void setTeam(TeamDTO team) {
        this.team = team;
    }
}

