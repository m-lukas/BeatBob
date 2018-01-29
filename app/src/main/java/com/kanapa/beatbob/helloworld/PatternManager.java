package com.kanapa.beatbob.helloworld;

import java.util.Random;

/**
 * Created by lm-go on 17.12.2016.
 */

public class PatternManager {

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

    public void loadPattern(){

        String[] s = {"a","a","a","a","a","b","B","B","B","c","b","A","A","A","c","b","B","B","B","c","d","d","d","d","d"};
        String[] s2 = {"A","B","A","B","A","B","A","B","A","B","A","B","A","B","A","B","A","B","A","B","A","B","A","B","A"};
        Pattern.patterns.add(new Pattern(1,1,s));
        Pattern.patterns.add(new Pattern(2,1,s2));

    }

    public static Pattern randomPattern(){

        Random r = new Random();
        int index = r.nextInt(Pattern.patterns.size());
        Pattern pattern = Pattern.patterns.get(index);

        //CHANGE^^^^

        return pattern;

    }

}
