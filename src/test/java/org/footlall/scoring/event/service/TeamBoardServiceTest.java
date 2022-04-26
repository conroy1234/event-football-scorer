package org.footlall.scoring.event.service;

import org.footlall.scoring.event.model.Team;
import org.footlall.scoring.event.repository.TeamRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;


class TeamBoardServiceTest {

    @InjectMocks
    TeamRepository teamRepository = mock(TeamRepository.class);
    @Mock
    TeamBoardService teamBoardService = mock(TeamBoardService.class);

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void whenFindAll() {
        List<Team> list = List.of(
                new Team("CHAMPIONS LEAGUE", "BARCELONA", 2, "MAN U", 1),
                new Team("PREMIER LEAGUE", "LIVERPOOL", 4, "MAN CITY", 2),
                new Team("PREMIER LEAGUE", "CHELSEA", 1, "ARSENAL", 5));

        when(teamRepository.findAll()).thenReturn(list);
        when(teamBoardService.findAllScores()).thenReturn(list);
        List<Team> teamServices = teamBoardService.findAllScores();
        assertEquals(3, teamRepository.findAll().size());
        assertEquals(3,teamServices.size());
        verify(teamRepository, times(1)).findAll();
    }

    @Test
    public void whenCreate() {
        Team team =  new Team("PREMIER LEAGUE", "CHELSEA", 1, "ARSENAL", 5);
        when(teamRepository.save(any())).thenReturn(team);
        when(teamBoardService.createScore(any())).thenReturn(team);
        assertEquals(team, teamRepository.save(team));
        assertEquals(team, teamBoardService.createScore(team));
        verify(teamRepository, times(1)).save(team);

    }

    @Test
    public void whenfindByTeamOne() {
        Team team =  new Team("PREMIER LEAGUE", "CHELSEA", 1, "ARSENAL", 5);
        when(teamRepository.findByTeamOne(any())).thenReturn(Arrays.asList(team));
        when(teamBoardService.findByTeamOne(anyString())).thenReturn(Arrays.asList(team));
        String result = teamBoardService.findByTeamOne(team.getTeamOne()).stream().filter(t->t.getTeamOne()
                .equals("CHELSEA")).map(t->t.getTeamOne()).collect(Collectors.joining());

        String resultRepo = teamRepository.findByTeamOne(team.getTeamOne()).stream().filter(t->t.getTeamOne()
                .equals("CHELSEA")).map(t->t.getTeamOne()).collect(Collectors.joining());

        assertEquals(team.getTeamOne(),result );
        verify(teamRepository, times(1)).findByTeamOne(resultRepo);

    }

    @Test
    public void whenfindByTeamTwo() {
        Team team =  new Team("PREMIER LEAGUE", "CHELSEA", 1, "ARSENAL", 5);
        when(teamRepository.findByTeamTwo(any())).thenReturn(Arrays.asList(team));
        when(teamBoardService.findByTeamTwo(anyString())).thenReturn(Arrays.asList(team));
        String result = teamBoardService.findByTeamTwo(team.getTeamTwo()).stream().filter(t->t.getTeamTwo()
                .equals("ARSENAL")).map(t->t.getTeamTwo()).collect(Collectors.joining());

        String resultRepo = teamRepository.findByTeamTwo(team.getTeamTwo()).stream().filter(t->t.getTeamTwo()
                .equals("ARSENAL")).map(t->t.getTeamTwo()).collect(Collectors.joining());
        assertEquals(team.getTeamTwo(),result );
        verify(teamRepository, times(1)).findByTeamTwo(resultRepo);

    }

    @Test
    public void whenfindById() {
        Team team =  new Team("PREMIER LEAGUE", "CHELSEA", 1, "ARSENAL", 5);
        when(teamRepository.findById(any())).thenReturn(Optional.<Team>of(team));
        when(teamBoardService.findById(any())).thenReturn(Optional.<Team>of(team));
        team.setId(2);
        int result = Math.toIntExact(teamBoardService.findById(team.getId()).stream().map(t -> t.getId()).collect(Collectors.toList()).get(0));

        Long resultRepo = Long.valueOf(Math.toIntExact(teamRepository.findById(team.getId()).stream().map(t -> t.getId()).collect(Collectors.toList()).get(0)));

        assertEquals(team.getId(),result );

        verify(teamRepository, times(1)).findById(resultRepo);

    }

}