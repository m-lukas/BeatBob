package com.kanapa.beatbob.helloworld;

/**
 * Created by lm-go on 29.12.2016.
 */

public class PathManager {

    private static PatternManager pm = new PatternManager();

    public static PatternManager getManager() {
        return pm;

    }

    public Pattern getPattern(int id) {
        for (Pattern p: Pattern.patterns) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

}
