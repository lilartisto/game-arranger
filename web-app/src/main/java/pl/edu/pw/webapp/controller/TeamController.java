package pl.edu.pw.webapp.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.edu.pw.webapp.dto.*;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

@Controller
public class TeamController {

    private final String url = "http://localhost:8081/";

    @GetMapping("/team")
    public String teamsListView(Model model) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) new URL(url + "api/team").openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Content-Type",
                "application/json");
        connection.setDoOutput(true);

        String response = readResponse(connection);
        ObjectMapper objectMapper = new ObjectMapper();
        List<TeamDTO> teams = objectMapper.readValue(response, new TypeReference<List<TeamDTO>>() {});

        model.addAttribute("teams", teams);

        return "teams";
    }

    @GetMapping("/team/{id}")
    public String teamDetailsView(@PathVariable("id") Long id, Model model) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) new URL(url + "api/team/" + id).openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Content-Type",
                "application/json");
        connection.setDoOutput(true);

        String response = readResponse(connection);
        model.addAttribute("team", new ObjectMapper().readValue(response, TeamDTO.class));
        model.addAttribute("joinGame", new JoinGameDTO());

        return "team_detail";
    }

    @GetMapping("/team/{teamId}/newplayer")
    public String addPlayerView(@PathVariable("teamId") Long teamId, Model model) {
        CreatePlayerDTO player = new CreatePlayerDTO();
        model.addAttribute("player", player);
        model.addAttribute("teamId", teamId);
        return "add_player";
    }

    @PostMapping("/team/{teamId}/newplayer")
    public String addPlayer(@PathVariable("teamId") Long teamId, @ModelAttribute("player") CreatePlayerDTO player) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) new URL(url + "api/team/" + teamId).openConnection();
        connection.setRequestMethod("PUT");
        connection.setRequestProperty("Content-Type",
                "application/json");
        connection.setDoOutput(true);

        DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
        wr.writeBytes(new ObjectMapper().writeValueAsString(player));
        wr.close();

        readResponse(connection);

        return "redirect:/team/" + teamId;
    }

    @GetMapping("/team/{teamId}/deleteplayer/{playerId}")
    public String deletePlayer(@PathVariable("teamId") Long teamId, @PathVariable("playerId") Long playerId) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) new URL(url + "api/team/" + teamId + "/" + playerId).openConnection();
        connection.setRequestMethod("DELETE");
        connection.setRequestProperty("Content-Type",
                "application/json");
        connection.setDoOutput(true);

        readResponse(connection);

        return "redirect:/team/" + teamId;
    }

    @PostMapping("/team/{teamId}/joingame")
    public String joinGame(@PathVariable("teamId") Long teamId, @ModelAttribute("gameId") JoinGameDTO joinGame, Model model) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) new URL(url + "api/game/" + joinGame.getGameId() + "/" + teamId).openConnection();
        connection.setRequestMethod("PUT");
        connection.setRequestProperty("Content-Type",
                "application/json");
        connection.setDoOutput(true);

        readResponse(connection);

        return "redirect:/team/" + teamId;
    }

    @GetMapping("/team/{teamId}/deletegame/{gameId}")
    public String deleteTeam(@PathVariable("gameId") Long gameId, @PathVariable("teamId") Long teamId, Model model) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) new URL(url + "api/game/" + gameId + "/" + teamId).openConnection();
        connection.setRequestMethod("DELETE");
        connection.setRequestProperty("Content-Type",
                "application/json");
        connection.setDoOutput(true);

        readResponse(connection);

        return "redirect:/team/" + teamId;
    }

    @GetMapping("/team/newteam")
    public String createTeamView(Model model) {
        CreateTeamCaptainDTO captain = new CreateTeamCaptainDTO();
        CreateTeamDTO team = new CreateTeamDTO();

        model.addAttribute("captain", captain);
        model.addAttribute("team", team);

        return "add_team";
    }

    @PostMapping("team/newteam")
    public String createTeam(@ModelAttribute("team") CreateTeamDTO team, @ModelAttribute("captain") CreateTeamCaptainDTO captain) throws IOException {
        TeamCaptainDTO teamCaptain = createTeamCaptain(captain);
        team.setCaptainId(teamCaptain.getId());
        createTeam(team);

        return "redirect:/team";
    }

    private void createTeam(CreateTeamDTO team) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) new URL(url + "api/team").openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type",
                "application/json");
        connection.setDoOutput(true);

        DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
        wr.writeBytes(new ObjectMapper().writeValueAsString(team));
        wr.close();

        readResponse(connection);
    }

    private TeamCaptainDTO createTeamCaptain(CreateTeamCaptainDTO captain) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        HttpURLConnection connection = (HttpURLConnection) new URL(url + "api/teamcaptain").openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type",
                "application/json");
        connection.setDoOutput(true);

        DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
        wr.writeBytes(mapper.writeValueAsString(captain));
        wr.close();

        return mapper.readValue(readResponse(connection), TeamCaptainDTO.class);
    }

    private String readResponse(HttpURLConnection connection) throws IOException {
        InputStream is = connection.getInputStream();
        BufferedReader rd = new BufferedReader(new InputStreamReader(is));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            response.append(line);
            response.append('\r');
        }
        rd.close();
        return response.toString();
    }

}
