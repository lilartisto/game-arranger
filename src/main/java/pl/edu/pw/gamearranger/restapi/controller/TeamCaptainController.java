package pl.edu.pw.gamearranger.restapi.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.pw.gamearranger.restapi.dto.CreateTeamCaptainDTO;
import pl.edu.pw.gamearranger.restapi.service.TeamCaptainService;

@RestController
@RequestMapping("api/teamcaptain")
public class TeamCaptainController {

    private final TeamCaptainService teamCaptainService;

    public TeamCaptainController(TeamCaptainService teamCaptainService) {
        this.teamCaptainService = teamCaptainService;
    }

    @PostMapping
    public void createTeamCaptain(@RequestBody CreateTeamCaptainDTO teamCaptain) {
        teamCaptainService.createTeamCaptain(teamCaptain);
    }
}
