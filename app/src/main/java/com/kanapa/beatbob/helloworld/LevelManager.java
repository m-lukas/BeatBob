package com.kanapa.beatbob.helloworld;

import android.graphics.Color;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * Created by lm-go on 18.12.2016.
 */

public class LevelManager {

    private static LevelManager lm = new LevelManager();

    public static LevelManager getManager() {
        return lm;

    }

    public static Level createLevel(int level){

        int tier = Methods.getTierForLevel(level);

        //random ColorTemplate
        //random Pattern
        //random operations ---> Pattern bearbeiten --> Farben zuweisen -->Pattern in einzelne Felder spalten und auf Level übertragen
        //ColorToString speichern

        Pattern p = PatternManager.randomPattern();
        ColorTemplate c = ColorTemplateManager.randomTemplate();

        ArrayList<Integer> colors = new ArrayList<>();

        for(int i =1; i<=c.getColors().length; i ++){

            int colorInt = c.getColor(i);
            colors.add(colorInt);

        }

        ArrayList<String> fieldTypes = new ArrayList<>();

        for(int i =1; i<=p.getFields().length; i ++){

            String fieldString = p.getField(i);
            if(!fieldTypes.contains(fieldString)) {
                fieldTypes.add(fieldString);
            }

        }

        HashMap<String, Integer> colorToString = new HashMap<>();
        Random r = new Random();

        for (String s:fieldTypes) {

            if(!colorToString.containsKey(s)) {

                if(!s.equals("0")) {

                    int i = r.nextInt(colors.size());
                    int color = colors.get(i);
                    colorToString.put(s, color);
                    colors.remove(i);

                }else{

                    colorToString.put(s, 0);

                }

            }

        }

        int[] fields = new int[25];

        for (int i=1; i<=25; i++) {

            String s = p.getField(i);
            int color = colorToString.get(s);
            fields[i-1]=color;

        }

        int fieldToClick = r.nextInt(25);
        fieldToClick=fieldToClick+1;

        String colorString = p.getField(fieldToClick);
        //int i = r.nextInt(colors.size());
        //int color = colors.get(i);
        int colorOld = colorToString.get(colorString);
        int red = Color.red(colorOld);
        int green = Color.green(colorOld);
        int blue = Color.blue(colorOld);
        System.err.println(red + " " + green + " " + blue);
        if(red<100){
            red=red+100;
        }else if(red>155){
            red=red-100;
        }else{
            red=red+100;
        }
        if(green<100){
            green=green+100;
        }else if(green>155){
            green=green-100;
        }else{
            green=green+100;
        }
        if(blue<100){
            blue=blue+100;
        }else if(blue>155){
            blue=blue-100;
        }else{
            blue=blue+100;
        }
        int color=Color.rgb(red, green,blue);
        fields[fieldToClick-1]=color;

        return new Level(level,p,c,colorToString,0,fieldToClick,fields);

    }



}
