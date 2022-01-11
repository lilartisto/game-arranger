package pl.edu.pw.gamearranger.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.pw.gamearranger.restapi.domain.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
}
