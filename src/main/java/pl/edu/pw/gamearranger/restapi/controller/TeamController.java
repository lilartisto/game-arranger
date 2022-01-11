package pl.edu.pw.gamearranger.restapi.controller;

import org.springframework.web.bind.annotation.*;
import pl.edu.pw.gamearranger.restapi.dto.CreatePlayerDTO;
import pl.edu.pw.gamearranger.restapi.dto.CreateTeamDTO;
import pl.edu.pw.gamearranger.restapi.dto.TeamDTO;
import pl.edu.pw.gamearranger.restapi.service.TeamService;
import java.util.List;

@RestController
@RequestMapping("api/team")
public class TeamController {

    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @PostMapping
    public void createTeam(@RequestBody CreateTeamDTO team) {
        teamService.createTeam(team);
    }

    @GetMapping
    public List<TeamDTO> getTeams() {
        return teamService.getTeams();
    }

    @GetMapping(path = "{teamId}")
    public TeamDTO getTeam(@PathVariable("teamId") Long id) {
        return teamService.getTeam(id);
    }

    @PutMapping(path = "{teamId}")
    public void addPlayerToTeam(@PathVariable("teamId") Long teamId, @RequestBody CreatePlayerDTO player) {
        teamService.addPlayer(teamId, player);
    }

    @DeleteMapping(path = "{teamId}/{playerId}")
    public void deletePlayerFromTeam(@PathVariable("teamId") Long teamId, @PathVariable("playerId") Long playerId) {
        teamService.deletePlayer(teamId, playerId);
    }

}
