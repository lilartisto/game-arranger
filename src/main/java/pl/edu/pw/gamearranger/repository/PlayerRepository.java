package pl.edu.pw.gamearranger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.pw.gamearranger.domain.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

}
