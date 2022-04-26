package org.footlall.scoring.event.model;

import javax.persistence.*;
import java.util.List;

@Entity(name = "scoreboard")
public class Team {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name ="event")
    private String event;
    @Column(name="TEAM_NAME_1")
    private String teamOne;
    @Column(name="TEAM_ONE_SCORE")
    private int scoreOne;
    @Column(name="TEAM_NAME_2")
    private String teamTwo;
    @Column(name="TEAM_TWO_SCORE")
    private int scoreTwo;

    public Team(){

    }

    public Team(String event, String teamOne, int scoreOne, String teamTwo, int scoreTwo) {
        this.event = event;
        this.teamOne = teamOne;
        this.scoreOne = scoreOne;
        this.teamTwo = teamTwo;
        this.scoreTwo = scoreTwo;

    }

    public long getId() {
        return id;
    }

    public Team setId(long id) {
        this.id = id;
        return this;
    }

    public String getEvent() {
        return event;
    }

    public Team setEvent(String event) {
        this.event = event;
        return this;
    }

    public String getTeamOne() {
        return teamOne;
    }

    public Team setTeamOne(String teamOne) {
        this.teamOne = teamOne;
        return this;
    }

    public String getTeamTwo() {
        return teamTwo;
    }

    public Team setTeamTwo(String teamTwo) {
        this.teamTwo = teamTwo;
        return this;
    }

    public int getScoreOne() {
        return scoreOne;
    }

    public Team setScoreOne(int scoreOne) {
        this.scoreOne = scoreOne;
        return this;
    }

    public int getScoreTwo() {
        return scoreTwo;
    }

    public Team setScoreTwo(int scoreTwo) {
        this.scoreTwo = scoreTwo;
        return this;
    }

    @Override
    public String toString() {
        return "ScoreBoard{" +
                "id=" + id +
                ", event='" + event + '\'' +
                ", teamOne='" + teamOne + '\'' +
                ", scoreOne=" + scoreOne +
                ", teamTwo='" + teamTwo + '\'' +
                ", scoreTwo=" + scoreTwo +
                '}';
    }
}
