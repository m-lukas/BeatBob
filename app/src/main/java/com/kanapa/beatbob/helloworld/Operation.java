package com.kanapa.beatbob.helloworld;

import java.util.ArrayList;

/**
 * Created by lm-go on 28.12.2016.
 */

public class Operation {

    public static ArrayList<Operation> operations = new ArrayList<>();

    public static int ROTATE90 = 0;
    public static int ROTATE180 = 1;
    public static int ROTATE270 = 2;
    public static int REFLECTVERTICAL = 3;
    public static int REFLECTHORIZONTAL = 4;
    public static int CONTRASTPLUS = 5;
    public static int CONTRASTMINUS = 6;

    private int id, tier;

    public Operation(int id, int tier){

        this.id=id;
        this.tier=tier;

        operations.add(this);

    }

    public int getId(){

        return this.id;

    }

    public int getTier(){

        return this.tier;

    }

}
