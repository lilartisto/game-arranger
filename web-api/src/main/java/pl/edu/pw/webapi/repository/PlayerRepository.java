package pl.edu.pw.webapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.pw.webapi.domain.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

}
