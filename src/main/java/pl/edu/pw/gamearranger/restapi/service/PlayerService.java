package pl.edu.pw.gamearranger.restapi.service;

import pl.edu.pw.gamearranger.restapi.domain.Player;
import pl.edu.pw.gamearranger.restapi.dto.CreatePlayerDTO;

public interface PlayerService {

    Player addPlayer(CreatePlayerDTO playerCreate);
    void deletePlayer(Long id);

}
