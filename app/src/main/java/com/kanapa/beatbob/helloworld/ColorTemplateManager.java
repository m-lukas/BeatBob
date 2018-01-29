package com.kanapa.beatbob.helloworld;

import android.graphics.Color;

import java.util.Random;

/**
 * Created by lm-go on 27.12.2016.
 */

public class ColorTemplateManager {

    private static ColorTemplateManager ctm = new ColorTemplateManager();

    public static ColorTemplateManager getManager() {
        return ctm;

    }

    public ColorTemplate getTemplate(int id) {
        for (ColorTemplate ct: ColorTemplate.templates) {
            if (ct.getId() == id) {
                return ct;
            }
        }
        return null;
    }

    public static void loadTemplates(){

        int[] i1 = {Color.parseColor("#b71c1c"),Color.parseColor("#880e4f"),Color.parseColor("#ffee58"),Color.parseColor("#9e9e9e"),Color.parseColor("#ff1744"), Color.parseColor("#F6F6F6")};

        ColorTemplate.templates.add(new ColorTemplate(1,1,0,i1));

    }

    public static ColorTemplate randomTemplate(){

        Random r = new Random();
        int index = r.nextInt(ColorTemplate.templates.size());
        ColorTemplate colorTemplate = ColorTemplate.templates.get(index);

        return colorTemplate;

    }

}
