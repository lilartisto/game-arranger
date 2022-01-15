package pl.edu.pw.webapi.dto.mapper;

import pl.edu.pw.webapi.domain.TeamCaptain;
import pl.edu.pw.webapi.dto.CreateTeamCaptainDTO;
import pl.edu.pw.webapi.dto.TeamCaptainDTO;

public class TeamCaptainMapper {

    public TeamCaptain map(CreateTeamCaptainDTO captain) {
        TeamCaptain teamCaptain = new TeamCaptain();
        teamCaptain.setFirstName(captain.getFirstName());
        teamCaptain.setLastName(captain.getLastName());
        return teamCaptain;
    }

    public TeamCaptainDTO map(TeamCaptain captain) {
        return new TeamCaptainDTO(
                captain.getId(),
                captain.getFirstName(),
                captain.getLastName(),
                captain.getTeam() == null ? null : new TeamMapper().map(captain.getTeam())
        );
    }

    public TeamCaptainDTO mapWithoutTeam(TeamCaptain captain) {
        return new TeamCaptainDTO(
                captain.getId(),
                captain.getFirstName(),
                captain.getLastName(),
                null
        );
    }
}
