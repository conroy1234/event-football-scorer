package org.footlall.scoring.event;

import org.footlall.scoring.event.model.Team;
import org.footlall.scoring.event.service.TeamBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class EventFootballScorerApplication implements CommandLineRunner {
	@Autowired
	TeamBoardService teamBoardService;

	public static void main(String[] args) {
		SpringApplication.run(EventFootballScorerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		List<Team> teams = List.of(
				new Team("CHAMPIONS LEAGUE","BARCELONA",2 ,"MAN U",1),
				new Team("PREMIER LEAGUE","LIVERPOOL",4 ,"MAN CITY",2),
				new Team("PREMIER LEAGUE","CHELSEA",1 ,"ARSENAL",5));
		teams.stream().forEach(scoreBoard -> {
			teamBoardService.createScore(scoreBoard);
		});

	}
}
