package pl.edu.pw.webapi.service;

import pl.edu.pw.webapi.domain.Player;
import pl.edu.pw.webapi.dto.CreatePlayerDTO;

public interface PlayerService {

    Player addPlayer(CreatePlayerDTO playerCreate);
    void deletePlayer(Long id);

}
