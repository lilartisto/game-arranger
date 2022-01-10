package pl.edu.pw.gamearranger.service;

import org.springframework.stereotype.Service;
import pl.edu.pw.gamearranger.domain.Player;
import pl.edu.pw.gamearranger.dto.CreatePlayerDTO;
import pl.edu.pw.gamearranger.dto.mapper.PlayerMapper;
import pl.edu.pw.gamearranger.repository.PlayerRepository;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class PlayerServiceImpl implements PlayerService {

    private PlayerRepository playerRepository;

    public PlayerServiceImpl(PlayerRepository playerRepository) {
        super();
        this.playerRepository = playerRepository;
    }

    @Override
    public void deletePlayer(Long id) {
        Optional<Player> player = playerRepository.findById(id);
        if(player.isPresent()){
            playerRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("There is no player with id = " + id);
        }
    }
}