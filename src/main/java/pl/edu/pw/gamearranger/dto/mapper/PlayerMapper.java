package pl.edu.pw.gamearranger.dto.mapper;

import pl.edu.pw.gamearranger.domain.Player;
import pl.edu.pw.gamearranger.dto.CreatePlayerDTO;

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
