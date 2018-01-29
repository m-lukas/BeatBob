package com.kanapa.beatbob.helloworld;

import java.util.ArrayList;

/**
 * Created by lm-go on 28.12.2016.
 */

public class Path {

    public static ArrayList<Path> paths = new ArrayList<>();

    private int id, tier, countOfTierPLUS, templateId, patternId;
    private int[] operations;

    public Path(int id, int tier, int countOfTierPLUS, int patternId, int templateId, int[] operations){

        this.id=id;
        this.tier=tier;
        this.countOfTierPLUS=countOfTierPLUS;
        this.patternId=patternId;
        this.templateId=templateId;
        this.operations=operations;

        paths.add(this);

    }

    public int getId(){

        return this.id;

    }

    public int getTier(){

        return this.tier;

    }

    public int getCountOfTierPLUS(){

        return this.countOfTierPLUS;

    }

    public int getPatternId(){

        return this.patternId;

    }

    public int getTemplateId(){

        return this.templateId;

    }

    public int[] getOperations()
    {
        return this.operations;
    }

    public int getOperation(int n)
    {
        if(n<=this.operations.length) {
            return this.operations[n];
        }else{
            return this.operations[1];
        }
    }

}
