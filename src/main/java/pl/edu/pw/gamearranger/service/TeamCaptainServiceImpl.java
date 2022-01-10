package pl.edu.pw.gamearranger.service;

import org.springframework.stereotype.Service;
import pl.edu.pw.gamearranger.dto.CreateTeamCaptainDTO;
import pl.edu.pw.gamearranger.dto.mapper.TeamCaptainMapper;
import pl.edu.pw.gamearranger.repository.TeamCaptainRepository;

@Service
public class TeamCaptainServiceImpl implements TeamCaptainService {

    private final TeamCaptainRepository teamCaptainRepository;

    public TeamCaptainServiceImpl(TeamCaptainRepository teamCaptainRepository) {
        this.teamCaptainRepository = teamCaptainRepository;
    }

    @Override
    public void createTeamCaptain(CreateTeamCaptainDTO teamCaptain) {
        teamCaptainRepository.save(new TeamCaptainMapper().map(teamCaptain));
    }

}
