package com.kanapa.beatbob.helloworld;

/**
 * Created by lm-go on 18.12.2016.
 */

public class Game {

    private int score;
    private float time;
    private long levelTime;
    private Level currentLevel, nextLevel;

    public Game(int score, float time, long levelTime, Level currentLevel, Level nextLevel){

        this.score=score;
        this.time=time;
        this.levelTime=levelTime;
        this.currentLevel=currentLevel;
        this.nextLevel=nextLevel;

    }

    public int getScore(){

        return this.score;

    }

    public float getTime(){

        return this.time;

    }

    public long getLevelTime(){

        return this.levelTime;

    }

    public Level getCurrentLevel(){

        return this.currentLevel;

    }

    public Level getNextLevel(){

        return this.nextLevel;

    }

    public Level nextLevel(){

        return this.nextLevel;

    }

    public void setScore(int score){

        this.score=score;

    }

    public void setLevelTime(long time){

        this.levelTime=time;

    }

    public void setCurrentLevel(Level currentLevel){

        this.currentLevel=currentLevel;

    }

    public void setNextLevel(Level nextLevel){

        this.nextLevel=nextLevel;

    }

}
