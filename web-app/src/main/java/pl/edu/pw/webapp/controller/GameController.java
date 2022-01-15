package pl.edu.pw.webapp.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.edu.pw.webapp.dto.CreateGameDTO;
import pl.edu.pw.webapp.dto.GameDTO;
import pl.edu.pw.webapp.dto.TeamDTO;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

@Controller
public class GameController {

    private final String url = "http://localhost:8081/";

    @GetMapping("/game")
    public String gameListView(Model model) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) new URL(url + "api/game").openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Content-Type",
                "application/json");
        connection.setDoOutput(true);

        String response = readResponse(connection);
        ObjectMapper objectMapper = new ObjectMapper();
        List<GameDTO> games = objectMapper.readValue(response, new TypeReference<List<GameDTO>>() {});

        model.addAttribute("games", games);

        return "games";
    }

    @GetMapping("/game/{id}")
    public String gameView(@PathVariable("id") Long id, Model model) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) new URL(url + "api/game/" + id).openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Content-Type",
                "application/json");
        connection.setDoOutput(true);

        String response = readResponse(connection);
        model.addAttribute("game", new ObjectMapper().readValue(response, GameDTO.class));

        return "game_detail";
    }

    @GetMapping("/game/newgame")
    public String newGameView(Model model) {
        CreateGameDTO game = new CreateGameDTO();
        model.addAttribute("game", game);
        return "add_game";
    }

    @PostMapping("/game/newgame")
    public String newGame(@ModelAttribute("game") CreateGameDTO game) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) new URL(url + "api/game").openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type",
                "application/json");
        connection.setDoOutput(true);

        DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
        wr.writeBytes(new ObjectMapper().writeValueAsString(game));
        wr.close();

        readResponse(connection);

        return "redirect:/game";
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
