package com.kanapa.beatbob.helloworld;

import java.util.ArrayList;

/**
 * Created by lm-go on 27.12.2016.
 */

public class ColorTemplate {

    public static ArrayList<ColorTemplate> templates = new ArrayList<>();
    private int id, tier, tierPLUS;
    private int[] colors;

    public ColorTemplate(int id, int tier, int tierPLUS, int[] colors) {

        this.id = id;
        this.tier = tier;
        this.tierPLUS=tierPLUS;
        this.colors=colors;

        templates.add(this);

    }

    public int getId() {

        return this.id;

    }

    public int getTier() {

        return this.tier;

    }

    public int getTierPLUS() {

        return this.tierPLUS;

    }

    public void setTierPLUS(int tierPLUS) {

        this.tierPLUS=tierPLUS;

    }

    public int[] getColors()
    {
        return this.colors;
    }

    public int getColor(int n)
    {
        if(n<=this.colors.length) {
            return this.colors[n-1];
        }else{
            return this.colors[0];
        }
    }

    public void setColors(int[] colors){

        this.colors=colors;

    }

}
