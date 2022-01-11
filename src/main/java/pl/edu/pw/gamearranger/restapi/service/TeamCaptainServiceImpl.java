package pl.edu.pw.gamearranger.restapi.service;

import org.springframework.stereotype.Service;
import pl.edu.pw.gamearranger.restapi.domain.TeamCaptain;
import pl.edu.pw.gamearranger.restapi.dto.CreateTeamCaptainDTO;
import pl.edu.pw.gamearranger.restapi.dto.mapper.TeamCaptainMapper;
import pl.edu.pw.gamearranger.restapi.repository.TeamCaptainRepository;

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
