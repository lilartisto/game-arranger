package pl.edu.pw.webapi.dto.mapper;

import pl.edu.pw.webapi.domain.Player;
import pl.edu.pw.webapi.dto.CreatePlayerDTO;

public class PlayerMapper {

    public Player map(CreatePlayerDTO player) {
        if(player != null && player.getFirstName() != null && player.getLastName() != null) {
            Player playerToSave = new Player();
            playerToSave.setFirstName(player.getFirstName());
            playerToSave.setLastName(player.getLastName());
            return playerToSave;
        } else {
            throw new IllegalArgumentException("Player cannot be null and player cannot contain null fields");
        }
    }
}
