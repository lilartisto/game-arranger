package pl.edu.pw.gamearranger.restapi.service;

import pl.edu.pw.gamearranger.restapi.domain.TeamCaptain;
import pl.edu.pw.gamearranger.restapi.dto.CreateTeamCaptainDTO;

public interface TeamCaptainService {

    TeamCaptain getTeamCaptain(Long id);
    void createTeamCaptain(CreateTeamCaptainDTO teamCaptain);

}
