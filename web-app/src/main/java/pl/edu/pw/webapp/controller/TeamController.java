package pl.edu.pw.webapp.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.edu.pw.webapp.dto.CreatePlayerDTO;
import pl.edu.pw.webapp.dto.TeamDTO;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
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

//        DataOutputStream wr = new DataOutputStream (
//                connection.getOutputStream());
//        wr.writeBytes("");
//        wr.close();

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

        String response = readResponse(connection);
        System.out.println(response);

        return "redirect:/team/" + teamId;
    }

    private String readResponse(HttpURLConnection connection) throws IOException {
        InputStream is = connection.getInputStream();
        BufferedReader rd = new BufferedReader(new InputStreamReader(is));
        StringBuilder response = new StringBuilder(); // or StringBuffer if Java version 5+
        String line;
        while ((line = rd.readLine()) != null) {
            response.append(line);
            response.append('\r');
        }
        rd.close();
        return response.toString();
    }

}
