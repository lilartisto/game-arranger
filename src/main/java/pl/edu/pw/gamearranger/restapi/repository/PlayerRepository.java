package pl.edu.pw.gamearranger.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.pw.gamearranger.restapi.domain.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

}
