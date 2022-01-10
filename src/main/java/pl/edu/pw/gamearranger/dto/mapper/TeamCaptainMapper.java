package pl.edu.pw.gamearranger.dto.mapper;

import pl.edu.pw.gamearranger.domain.TeamCaptain;
import pl.edu.pw.gamearranger.dto.CreateTeamCaptainDTO;

public class TeamCaptainMapper {

    public TeamCaptain map(CreateTeamCaptainDTO captain) {
        TeamCaptain teamCaptain = new TeamCaptain();
        teamCaptain.setFirstName(captain.getFirstName());
        teamCaptain.setLastName(captain.getLastName());
        return teamCaptain;
    }
}
