package pl.edu.pw.gamearranger.dto;

import pl.edu.pw.gamearranger.domain.TeamCaptain;

public class CreateTeamDTO {

    private TeamCaptain captain;
    private String name;

    public CreateTeamDTO() {
    }

    public CreateTeamDTO(TeamCaptain captain, String name) {
        this.captain = captain;
        this.name = name;
    }

    public TeamCaptain getCaptain() {
        return captain;
    }

    public void setCaptain(TeamCaptain captain) {
        this.captain = captain;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
