package com.kanapa.beatbob.helloworld;

import java.util.ArrayList;

/**
 * Created by lm-go on 17.12.2016.
 */

public class Pattern {

    public static ArrayList<Pattern> patterns = new ArrayList<>();
    private int id,tier;
    private String[] fields;

    public Pattern(int id, int tier, String[] fields){

        this.id=id;
        this.tier=tier;
        this.fields=fields;

        patterns.add(this);

    }

    public int getId(){

        return this.id;

    }

    public int getTier(){

        return this.tier;

    }

    public String[] getFields()
    {
        return this.fields;
    }

    public String getField(int n)
    {
        if(n<=this.fields.length) {
            return this.fields[n-1];
        }else{
            return this.fields[0];
        }
    }





















}
