package pl.edu.pw.gamearranger.service;

import java.util.List;

import pl.edu.pw.gamearranger.dto.CreatePlayerDTO;
import pl.edu.pw.gamearranger.dto.PlayerDTO;

public interface PlayerService {

    List<PlayerDTO> getPlayers();
    void createPlayer(CreatePlayerDTO player);
    void deletePlayer(Long id);

}
