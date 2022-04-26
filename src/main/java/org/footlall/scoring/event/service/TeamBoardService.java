package org.footlall.scoring.event.service;

import org.footlall.scoring.event.model.Team;
import org.footlall.scoring.event.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamBoardService {

    @Autowired
    private TeamRepository teamRepository;

    public Team createScore(Team team){
      return  teamRepository.save(team);
    }

    public List<Team> findAllScores(){
        return teamRepository.findAll();
    }

    public List<Team> findByTeamOne(String teamName){
        return teamRepository.findByTeamOne(teamName);
    }
    public List<Team> findByTeamTwo(String teamName){
        return teamRepository.findByTeamTwo(teamName);
    }

    public Optional<Team> findById(Long id){
        return teamRepository.findById(id);
    }

}
