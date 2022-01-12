package pl.edu.pw.webapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.pw.webapi.domain.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
}
