package pl.edu.pw.webapi.service;

import org.springframework.stereotype.Service;
import pl.edu.pw.webapi.domain.TeamCaptain;
import pl.edu.pw.webapi.dto.CreateTeamCaptainDTO;
import pl.edu.pw.webapi.dto.mapper.TeamCaptainMapper;
import pl.edu.pw.webapi.repository.TeamCaptainRepository;

import java.util.NoSuchElementException;

@Service
public class TeamCaptainServiceImpl implements TeamCaptainService {

    private final TeamCaptainRepository teamCaptainRepository;

    public TeamCaptainServiceImpl(TeamCaptainRepository teamCaptainRepository) {
        this.teamCaptainRepository = teamCaptainRepository;
    }

    @Override
    public TeamCaptain getTeamCaptain(Long id) {
        return teamCaptainRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("Team captain with id = " + id));
    }

    @Override
    public void createTeamCaptain(CreateTeamCaptainDTO teamCaptain) {
        teamCaptainRepository.save(new TeamCaptainMapper().map(teamCaptain));
    }

}
