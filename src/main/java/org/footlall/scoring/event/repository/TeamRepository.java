package org.footlall.scoring.event.repository;

import org.footlall.scoring.event.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamRepository extends JpaRepository<Team,Long> {

    List<Team> findByTeamOne(String teamName);
    List<Team> findByTeamTwo(String teamName);

    Team findByScoreOne(int score);
    Team findByScoreTwo(int score);

}
