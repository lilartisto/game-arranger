package pl.edu.pw.webapi.service;

import pl.edu.pw.webapi.domain.TeamCaptain;
import pl.edu.pw.webapi.dto.CreateTeamCaptainDTO;

public interface TeamCaptainService {

    TeamCaptain getTeamCaptain(Long id);
    void createTeamCaptain(CreateTeamCaptainDTO teamCaptain);

}
