package com.kanapa.beatbob.helloworld;

import android.graphics.Color;

import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by lm-go on 22.12.2016.
 */

public class Methods {

    public static int basictier = 2;

    public static Pattern rotate(Pattern p,int angle){

        String s1="";
        String s2="";
        String s3="";
        String s4="";
        String s5="";
        String s6="";
        String s7="";
        String s8="";
        String s9="";
        String s10="";
        String s11="";
        String s12="";
        String s13="";
        String s14="";
        String s15="";
        String s16="";
        String s17="";
        String s18="";
        String s19="";
        String s20="";
        String s21="";
        String s22="";
        String s23="";
        String s24="";
        String s25="";

        switch (angle){

            case 90:
                s1=p.getField(21);
                s2=p.getField(16);
                s3=p.getField(11);
                s4=p.getField(6);
                s5=p.getField(1);
                s6=p.getField(22);
                s7=p.getField(17);
                s8=p.getField(12);
                s9=p.getField(7);
                s10=p.getField(2);
                s11=p.getField(23);
                s12=p.getField(18);
                s13=p.getField(13);
                s14=p.getField(8);
                s15=p.getField(3);
                s16=p.getField(24);
                s17=p.getField(19);
                s18=p.getField(14);
                s19=p.getField(9);
                s20=p.getField(4);
                s21=p.getField(25);
                s22=p.getField(20);
                s23=p.getField(15);
                s24=p.getField(10);
                s25=p.getField(5);
                break;
            case 180:
                s1=p.getField(25);
                s2=p.getField(24);
                s3=p.getField(23);
                s4=p.getField(22);
                s5=p.getField(21);
                s6=p.getField(20);
                s7=p.getField(19);
                s8=p.getField(18);
                s9=p.getField(17);
                s10=p.getField(16);
                s11=p.getField(15);
                s12=p.getField(14);
                s13=p.getField(13);
                s14=p.getField(12);
                s15=p.getField(11);
                s16=p.getField(10);
                s17=p.getField(9);
                s18=p.getField(8);
                s19=p.getField(7);
                s20=p.getField(6);
                s21=p.getField(5);
                s22=p.getField(4);
                s23=p.getField(3);
                s24=p.getField(2);
                s25=p.getField(1);
                break;
            case 270:
                s1=p.getField(5);
                s2=p.getField(10);
                s3=p.getField(15);
                s4=p.getField(20);
                s5=p.getField(25);
                s6=p.getField(4);
                s7=p.getField(9);
                s8=p.getField(14);
                s9=p.getField(19);
                s10=p.getField(24);
                s11=p.getField(3);
                s12=p.getField(8);
                s13=p.getField(13);
                s14=p.getField(18);
                s15=p.getField(23);
                s16=p.getField(2);
                s17=p.getField(7);
                s18=p.getField(12);
                s19=p.getField(17);
                s20=p.getField(22);
                s21=p.getField(1);
                s22=p.getField(6);
                s23=p.getField(11);
                s24=p.getField(16);
                s25=p.getField(21);
                break;

        }

        String[] s = {s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,s13,s14,s15,s16,s17,s18,s19,s20,s22,s23,s24,s25};
        Pattern pnew = new Pattern(p.getId(), p.getTier(),s);

        return pnew;

    }

    public static int getTierForLevel(int level){

        int i = 1/30*(level^2)+basictier;
        return i;
    }

    public static ColorTemplate decreaseDistance(ColorTemplate ct, int color, int value){

        ColorTemplate newColorTemplate = new ColorTemplate(ct.getId(),ct.getTier(), ct.getTierPLUS(), ct.getColors());

        int[] colors = ct.getColors();

        ArrayList<Integer> colorArray = new ArrayList<>();

        int red1=Color.red(color);
        int green1=Color.green(color);
        int blue1=Color.blue(color);

        for (int c:colors) {

            if(c!=color){

                int indexOfColor = 0;

                for(int i=0;i<colors.length;i++){

                    if(colors[i]==c){

                        indexOfColor=i;

                    }

                }

                int red2=Color.red(c);
                int green2=Color.green(c);
                int blue2=Color.blue(c);

                double distance = Math.sqrt((Math.pow(red2,2)-Math.pow(red1,2))+(Math.pow(green2,2)-Math.pow(green1,2))+(Math.pow(blue2,2)-Math.pow(blue1,2)));

                Vector mainVector = new Vector();
                mainVector.add(0,red1);
                mainVector.add(1,green1);
                mainVector.add(2,blue1);

                Vector directionVector = new Vector();
                directionVector.add(0,red2-red1);
                directionVector.add(1,green2-green1);
                directionVector.add(2,blue2-blue1);

                if(!(distance-value<=0)){

                    double partialDistance = 1-(value/distance);
                    int newRed = ((Double)((int)directionVector.get(0)*partialDistance)).intValue();
                    int newGreen = ((Double)((int)directionVector.get(1)*partialDistance)).intValue();
                    int newBlue = ((Double)((int)directionVector.get(2)*partialDistance)).intValue();

                    int newColor=Color.rgb(newRed,newGreen,newBlue);

                    colors[indexOfColor]=newColor;

                }

            }

        }

        newColorTemplate.setColors(colors);

        return newColorTemplate;

    }

    public static ColorTemplate increaseDistance(ColorTemplate ct, int color, int value){

        ColorTemplate newColorTemplate = new ColorTemplate(ct.getId(),ct.getTier(), ct.getTierPLUS(), ct.getColors());

        int[] colors = ct.getColors();

        ArrayList<Integer> colorArray = new ArrayList<>();

        int red1=Color.red(color);
        int green1=Color.green(color);
        int blue1=Color.blue(color);

        for (int c:colors) {

            if(c!=color){

                int indexOfColor = 0;

                for(int i=0;i<colors.length;i++){

                    if(colors[i]==c){

                        indexOfColor=i;

                    }

                }

                int red2=Color.red(c);
                int green2=Color.green(c);
                int blue2=Color.blue(c);

                double distance = Math.sqrt((Math.pow(red2,2)-Math.pow(red1,2))+(Math.pow(green2,2)-Math.pow(green1,2))+(Math.pow(blue2,2)-Math.pow(blue1,2)));

                Vector mainVector = new Vector();
                mainVector.add(0,red1);
                mainVector.add(1,green1);
                mainVector.add(2,blue1);

                Vector directionVector = new Vector();
                directionVector.add(0,red2-red1);
                directionVector.add(1,green2-green1);
                directionVector.add(2,blue2-blue1);

                if(!(distance-value<=0)){

                    double partialDistance = 1+(value/distance);
                    int newRed = ((Double)((int)directionVector.get(0)*partialDistance)).intValue();
                    int newGreen = ((Double)((int)directionVector.get(1)*partialDistance)).intValue();
                    int newBlue = ((Double)((int)directionVector.get(2)*partialDistance)).intValue();

                    int newColor=Color.rgb(newRed,newGreen,newBlue);

                    colors[indexOfColor]=newColor;

                }

            }

        }

        newColorTemplate.setColors(colors);

        return newColorTemplate;

    }

    public static int getGridRow(int field){

        int row = 0;

        switch (field+1){

            case(1):
                row=0;
                break;
            case(2):
                row=0;
                break;
            case(3):
                row=0;
                break;
            case(4):
                row=0;
                break;
            case(5):
                row=0;
                break;
            case(6):
                row=1;
                break;
            case(7):
                row=1;
                break;
            case(8):
                row=1;
                break;
            case(9):
                row=1;
                break;
            case(10):
                row=1;
                break;
            case(11):
                row=2;
                break;
            case(12):
                row=2;
                break;
            case(13):
                row=2;
                break;
            case(14):
                row=2;
                break;
            case(15):
                row=2;
                break;
            case(16):
                row=3;
                break;
            case(17):
                row=3;
                break;
            case(18):
                row=3;
                break;
            case(19):
                row=3;
                break;
            case(20):
                row=3;
                break;
            case(21):
                row=4;
                break;
            case(22):
                row=4;
                break;
            case(23):
                row=4;
                break;
            case(24):
                row=4;
                break;
            case(25):
                row=4;
                break;

        }

        return row;

    }

    public static int getGridColumn(int field){

        int column = 0;

        switch (field+1){

            case(1):
                column=0;
                break;
            case(2):
                column=1;
                break;
            case(3):
                column=2;
                break;
            case(4):
                column=3;
                break;
            case(5):
                column=4;
                break;
            case(6):
                column=0;
                break;
            case(7):
                column=1;
                break;
            case(8):
                column=2;
                break;
            case(9):
                column=3;
                break;
            case(10):
                column=4;
                break;
            case(11):
                column=0;
                break;
            case(12):
                column=1;
                break;
            case(13):
                column=2;
                break;
            case(14):
                column=3;
                break;
            case(15):
                column=4;
                break;
            case(16):
                column=0;
                break;
            case(17):
                column=1;
                break;
            case(18):
                column=2;
                break;
            case(19):
                column=3;
                break;
            case(20):
                column=4;
                break;
            case(21):
                column=0;
                break;
            case(22):
                column=1;
                break;
            case(23):
                column=2;
                break;
            case(24):
                column=3;
                break;
            case(25):
                column=4;
                break;

        }

        return column;

    }

}
