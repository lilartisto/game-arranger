package pl.edu.pw.webapi.dto.mapper;

import pl.edu.pw.webapi.domain.TeamCaptain;
import pl.edu.pw.webapi.dto.CreateTeamCaptainDTO;

public class TeamCaptainMapper {

    public TeamCaptain map(CreateTeamCaptainDTO captain) {
        TeamCaptain teamCaptain = new TeamCaptain();
        teamCaptain.setFirstName(captain.getFirstName());
        teamCaptain.setLastName(captain.getLastName());
        return teamCaptain;
    }
}
