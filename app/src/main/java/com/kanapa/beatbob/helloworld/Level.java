package com.kanapa.beatbob.helloworld;

import java.util.HashMap;

/**
 * Created by lm-go on 18.12.2016.
 */



public class Level {

    private int level,fieldToClick;
    private Pattern pattern;
    private ColorTemplate template;
    private HashMap<String, Integer> colorToString;
    private float time;
    private int[] fields;

    public Level(int level, Pattern pattern, ColorTemplate template, HashMap<String, Integer> colorToString, float time, int fieldToClick ,int[] fields){

        this.level=level;
        this.pattern=pattern;
        this.template=template;
        this.time=time;
        this.fieldToClick=fieldToClick;
        this.fields=fields;
        this.colorToString=colorToString;

    }

    public int getLevel(){

        return this.level;

    }

    public int getFieldToClick(){

        return this.fieldToClick;

    }

    public Pattern getPattern(){

        return this.pattern;

    }

    public HashMap<String, Integer> getColorToString(){

        return this.colorToString;

    }

    public int[] getColors()
    {
        return this.fields;
    }

    public int getColor(int n)
    {
        if(n<=this.fields.length) {
            return this.fields[n-1];
        }else{
            return this.fields[0];
        }
    }

    public void setColor(int field, int color)
    {
        if(field<=this.fields.length) {
            this.fields[field-1]=color;
        }
    }

}
