package com.kanapa.beatbob.helloworld;

/**
 * Created by lm-go on 18.12.2016.
 */

public class GameManager {

    private static GameManager gm = new GameManager();
    public static Game game;

    public static GameManager getManager() {
        return gm;

    }

    public static Game newGame(){

        int score=0;
        float time=0;
        long levelTime=10*1000;
        Level currentLevel = LevelManager.createLevel(1);
        Level nextLevel = LevelManager.createLevel(2);

        game = new Game(score,time,levelTime,currentLevel,nextLevel);
        return game;

    }

    public static Level nextLevel(Game game){

        Level l = game.getNextLevel();
        game.setCurrentLevel(l);
        game.setNextLevel(LevelManager.getManager().createLevel(game.getCurrentLevel().getLevel()+1));
        game.setLevelTime(10*1000);
        game.setScore(game.getScore()+1);
        return l;

    }

}
