package org.footlall.scoring.event.api;

import org.footlall.scoring.event.exception.TeamNotFountException;
import org.footlall.scoring.event.model.Team;
import org.footlall.scoring.event.service.TeamBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TeamBoardController {

    @Autowired
    TeamBoardService teamBoardService;

    @PostMapping("api/football/score")
    public Team saveScore(@RequestBody Team team) {
        return teamBoardService.createScore(team);
    }

    @GetMapping("api/football/score")
    public List<Team> getAll() {
        return teamBoardService.findAllScores();
    }

    @GetMapping("api/football/score/{name}")
    public List<Team> getByTeamOne(@PathVariable String name) {
        return teamBoardService.findByTeamOne(name);
    }

    @GetMapping("api/football/score/-{name}")
    public List<Team> getByTeamTwo(@PathVariable String name) {
        return teamBoardService.findByTeamTwo(name);
    }

    @GetMapping("api/football/score/id/{id}")
    public Optional<Team> getById(@PathVariable Long id) {
        return Optional.ofNullable(teamBoardService.findById(id).orElseThrow(() -> new TeamNotFountException("Id " + id + " not found")));
    }

    @PutMapping("api/football/score/id/{id}")
    Team updateBoard(@RequestBody Team team, @PathVariable Long id) {

        return teamBoardService.findById(id)
                .map(board -> {
                    board.setTeamTwo(team.getTeamTwo())
                         .setEvent(team.getEvent())
                         .setTeamOne(team.getTeamOne())
                         .setScoreOne(team.getScoreOne())
                         .setTeamTwo(team.getTeamTwo())
                         .setScoreTwo(team.getScoreTwo());
                    return teamBoardService.createScore(board);
                })
                .orElseGet(() -> {
                    team.setId(id);
                    return teamBoardService.createScore(team);
                });
    }
}
