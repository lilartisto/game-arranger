package pl.edu.pw.webapi.dto.mapper;

import pl.edu.pw.webapi.domain.Player;
import pl.edu.pw.webapi.domain.Team;
import pl.edu.pw.webapi.dto.CreatePlayerDTO;
import pl.edu.pw.webapi.dto.PlayerDTO;
import pl.edu.pw.webapi.dto.TeamDTO;

import java.util.LinkedList;
import java.util.List;

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

    public List<PlayerDTO> map(List<Player> players) {
        List<PlayerDTO> mappedPlayers = new LinkedList<>();
        for(Player p: players) {
            mappedPlayers.add(map(p));
        }
        return mappedPlayers;
    }

    public PlayerDTO map(Player player) {
        return new PlayerDTO(
                player.getId(),
                player.getFirstName(),
                player.getLastName()
        );
    }


}
