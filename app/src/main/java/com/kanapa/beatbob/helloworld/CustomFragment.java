package com.kanapa.beatbob.helloworld;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;

import java.util.ArrayList;
import java.util.HashMap;

import static com.kanapa.beatbob.helloworld.HomePage.g;

/**
 * Created by lm-go on 19.02.2017.
 */

public class CustomFragment extends Fragment {

    Button b1;
    Button b2;
    Button b3;
    Button b4;
    Button b5;
    Button b6;
    Button b7;
    Button b8;
    Button b9;
    Button b10;
    Button b11;
    Button b12;
    Button b13;
    Button b14;
    Button b15;
    Button b16;
    Button b17;
    Button b18;
    Button b19;
    Button b20;
    Button b21;
    Button b22;
    Button b23;
    Button b24;
    Button b25;

    private ButtonGrid grid;
    Level curLevel;

    ArrayList<Button> disabledButtons = new ArrayList<>();
    ArrayList<Button> removedButtons = new ArrayList<>();
    HashMap<Integer, GridLayout.LayoutParams> temporaryButtons = new HashMap<>();
    HashMap<Integer, ArrayList<Integer>> buttonToFields = new HashMap<>();

    static int normalWidth,normalHeight;

    private int pos;

    public static Fragment newInstance(HomePage context, int pos) {
        Bundle b = new Bundle();
        b.putInt("pos", pos);
        return Fragment.instantiate(context, CustomFragment.class.getName(), b);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if (container == null) {
            return null;
        }

        ButtonGrid layout = (ButtonGrid)
                inflater.inflate(R.layout.fragment, container, false);

        pos = this.getArguments().getInt("pos");
        System.err.println("Fragment" + pos);

        grid = layout;

        resetButtonToFields();

        b1 = (Button) layout.findViewById(R.id.button1);
        b2 = (Button) layout.findViewById(R.id.button2);
        b3 = (Button) layout.findViewById(R.id.button3);
        b4 = (Button) layout.findViewById(R.id.button4);
        b5 = (Button) layout.findViewById(R.id.button5);
        b6 = (Button) layout.findViewById(R.id.button6);
        b7 = (Button) layout.findViewById(R.id.button7);
        b8 = (Button) layout.findViewById(R.id.button8);
        b9 = (Button) layout.findViewById(R.id.button9);
        b10 = (Button) layout.findViewById(R.id.button10);
        b11 = (Button) layout.findViewById(R.id.button11);
        b12 = (Button) layout.findViewById(R.id.button12);
        b13 = (Button) layout.findViewById(R.id.button13);
        b14 = (Button) layout.findViewById(R.id.button14);
        b15 = (Button) layout.findViewById(R.id.button15);
        b16 = (Button) layout.findViewById(R.id.button16);
        b17 = (Button) layout.findViewById(R.id.button17);
        b18 = (Button) layout.findViewById(R.id.button18);
        b19 = (Button) layout.findViewById(R.id.button19);
        b20 = (Button) layout.findViewById(R.id.button20);
        b21 = (Button) layout.findViewById(R.id.button21);
        b22 = (Button) layout.findViewById(R.id.button22);
        b23 = (Button) layout.findViewById(R.id.button23);
        b24 = (Button) layout.findViewById(R.id.button24);
        b25 = (Button) layout.findViewById(R.id.button25);

        b1.setOnClickListener(onClickListener);
        b2.setOnClickListener(onClickListener);
        b3.setOnClickListener(onClickListener);
        b4.setOnClickListener(onClickListener);
        b5.setOnClickListener(onClickListener);
        b6.setOnClickListener(onClickListener);
        b7.setOnClickListener(onClickListener);
        b8.setOnClickListener(onClickListener);
        b9.setOnClickListener(onClickListener);
        b10.setOnClickListener(onClickListener);
        b11.setOnClickListener(onClickListener);
        b12.setOnClickListener(onClickListener);
        b13.setOnClickListener(onClickListener);
        b14.setOnClickListener(onClickListener);
        b15.setOnClickListener(onClickListener);
        b16.setOnClickListener(onClickListener);
        b17.setOnClickListener(onClickListener);
        b18.setOnClickListener(onClickListener);
        b19.setOnClickListener(onClickListener);
        b20.setOnClickListener(onClickListener);
        b1.setOnClickListener(onClickListener);
        b22.setOnClickListener(onClickListener);
        b23.setOnClickListener(onClickListener);
        b24.setOnClickListener(onClickListener);
        b25.setOnClickListener(onClickListener);

        displayLevel(g.getCurrentLevel());
        curLevel = g.getCurrentLevel();

        return layout;
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        public void onClick(View v) {
                if (buttonToFields.containsKey(v.getId())) {
                    ArrayList<Integer> array = buttonToFields.get(v.getId());
                    if (array.contains(curLevel.getFieldToClick())) {
                        nextLevel();
                    } else {
                        System.err.println("Game Over");
                    }
                }
        }
    };

    public void displayLevel(Level l) {

        //for (Button b : disabledButtons) {
            //b.setEnabled(true);
        //}

        //disabledButtons.clear();

        //for (Map.Entry<Integer, GridLayout.LayoutParams> entry : temporaryButtons.entrySet()) {
            //Integer i = entry.getKey();
            //GridLayout.LayoutParams parms = entry.getValue();
            //Button b = fieldToButton(i);
            //grid.removeView(b);
            //parms.height=normalHeight;
            //parms.width=normalWidth;
            //b.setLayoutParams(parms);
            //grid.addView(b);
        //}

        //temporaryButtons.clear();

        //for (Button b : removedButtons) {
            //grid.addView(b);
        //}

        //removedButtons.clear();

        //resetButtonToFields();

        Button b1 = (Button) grid.findViewById(R.id.button1);
        b1.setBackgroundColor(l.getColor(1));
        if (l.getColor(1) == 0) {
            b1.setEnabled(false);
            disabledButtons.add(b1);
        }
        Button b2 = (Button) grid.findViewById(R.id.button2);
        b2.setBackgroundColor(l.getColor(2));
        if (l.getColor(2) == 0) {
            b2.setEnabled(false);
            disabledButtons.add(b2);
        }
        Button b3 = (Button) grid.findViewById(R.id.button3);
        b3.setBackgroundColor(l.getColor(3));
        if (l.getColor(3) == 0) {
            b3.setEnabled(false);
            disabledButtons.add(b3);
        }
        Button b4 = (Button) grid.findViewById(R.id.button4);
        b4.setBackgroundColor(l.getColor(4));
        if (l.getColor(4) == 0) {
            b4.setEnabled(false);
            disabledButtons.add(b4);
        }
        Button b5 = (Button) grid.findViewById(R.id.button5);
        b5.setBackgroundColor(l.getColor(5));
        if (l.getColor(5) == 0) {
            b5.setEnabled(false);
            disabledButtons.add(b5);
        }
        Button b6 = (Button) grid.findViewById(R.id.button6);
        b6.setBackgroundColor(l.getColor(6));
        if (l.getColor(6) == 0) {
            b6.setEnabled(false);
            disabledButtons.add(b6);
        }
        Button b7 = (Button) grid.findViewById(R.id.button7);
        b7.setBackgroundColor(l.getColor(7));
        if (l.getColor(7) == 0) {
            b7.setEnabled(false);
            disabledButtons.add(b7);
        }
        Button b8 = (Button) grid.findViewById(R.id.button8);
        b8.setBackgroundColor(l.getColor(8));
        if (l.getColor(8) == 0) {
            b8.setEnabled(false);
            disabledButtons.add(b8);
        }
        Button b9 = (Button) grid.findViewById(R.id.button9);
        b9.setBackgroundColor(l.getColor(9));
        if (l.getColor(9) == 0) {
            b9.setEnabled(false);
            disabledButtons.add(b9);
        }
        Button b10 = (Button) grid.findViewById(R.id.button10);
        b10.setBackgroundColor(l.getColor(10));
        if (l.getColor(10) == 0) {
            b10.setEnabled(false);
            disabledButtons.add(b10);
        }
        Button b11 = (Button) grid.findViewById(R.id.button11);
        b11.setBackgroundColor(l.getColor(11));
        if (l.getColor(11) == 0) {
            b11.setEnabled(false);
            disabledButtons.add(b11);
        }
        Button b12 = (Button) grid.findViewById(R.id.button12);
        b12.setBackgroundColor(l.getColor(12));
        if (l.getColor(12) == 0) {
            b12.setEnabled(false);
            disabledButtons.add(b12);
        }
        Button b13 = (Button) grid.findViewById(R.id.button13);
        b13.setBackgroundColor(l.getColor(13));
        if (l.getColor(13) == 0) {
            b13.setEnabled(false);
            disabledButtons.add(b13);
        }
        Button b14 = (Button) grid.findViewById(R.id.button14);
        b14.setBackgroundColor(l.getColor(14));
        if (l.getColor(14) == 0) {
            b14.setEnabled(false);
            disabledButtons.add(b14);
        }
        Button b15 = (Button) grid.findViewById(R.id.button15);
        b15.setBackgroundColor(l.getColor(15));
        if (l.getColor(15) == 0) {
            b15.setEnabled(false);
            disabledButtons.add(b15);
        }
        Button b16 = (Button) grid.findViewById(R.id.button16);
        b16.setBackgroundColor(l.getColor(16));
        if (l.getColor(16) == 0) {
            b16.setEnabled(false);
            disabledButtons.add(b16);
        }
        Button b17 = (Button) grid.findViewById(R.id.button17);
        b17.setBackgroundColor(l.getColor(17));
        if (l.getColor(17) == 0) {
            b17.setEnabled(false);
            disabledButtons.add(b17);
        }
        Button b18 = (Button) grid.findViewById(R.id.button18);
        b18.setBackgroundColor(l.getColor(18));
        if (l.getColor(18) == 0) {
            b18.setEnabled(false);
            disabledButtons.add(b18);
        }
        Button b19 = (Button) grid.findViewById(R.id.button19);
        b19.setBackgroundColor(l.getColor(19));
        if (l.getColor(19) == 0) {
            b19.setEnabled(false);
            disabledButtons.add(b19);
        }
        Button b20 = (Button) grid.findViewById(R.id.button20);
        b20.setBackgroundColor(l.getColor(20));
        if (l.getColor(20) == 0) {
            b20.setEnabled(false);
            disabledButtons.add(b20);
        }
        Button b21 = (Button) grid.findViewById(R.id.button21);
        b21.setBackgroundColor(l.getColor(21));
        if (l.getColor(21) == 0) {
            b21.setEnabled(false);
            disabledButtons.add(b21);
        }
        Button b22 = (Button) grid.findViewById(R.id.button22);
        b22.setBackgroundColor(l.getColor(22));
        if (l.getColor(22) == 0) {
            b22.setEnabled(false);
            disabledButtons.add(b22);
        }
        Button b23 = (Button) grid.findViewById(R.id.button23);
        b23.setBackgroundColor(l.getColor(23));
        if (l.getColor(23) == 0) {
            b23.setEnabled(false);
            disabledButtons.add(b23);
        }
        Button b24 = (Button) grid.findViewById(R.id.button24);
        b24.setBackgroundColor(l.getColor(24));
        if (l.getColor(24) == 0) {
            b25.setEnabled(false);
            disabledButtons.add(b24);
        }
        Button b25 = (Button) grid.findViewById(R.id.button25);
        b25.setBackgroundColor(l.getColor(25));
        if (l.getColor(25) == 0) {
            b25.setEnabled(false);
            disabledButtons.add(b25);
        }

        //HomePage.startTimer(g.getLevelTime());
        //levelView = (TextView) HomePage.findViewById(levelView); //Homepage - Fragment
        //levelView.setText("Level " + l.getLevel());

        //groupFields(l);

    }

    public void nextLevel() {

        GameManager.getManager().nextLevel(g);
        HomePage.pager.setCurrentItem(pos + 1, true);

    }

    public void groupFields(Level l) {

        ArrayList<String> containedFields = new ArrayList<>();

        for (String s : l.getColorToString().keySet()) {

            if (s.equals("a") || s.equals("b") || s.equals("c") || s.equals("d") || s.equals("e") || s.equals("f") || s.equals("g") || s.equals("h") || s.equals("i") || s.equals("j") || s.equals("k") || s.equals("l") || s.equals("m") || s.equals("n") || s.equals("o") || s.equals("p") || s.equals("j") || s.equals("r") || s.equals("s") || s.equals("t") || s.equals("u") || s.equals("v") || s.equals("w") || s.equals("x") || s.equals("y") || s.equals("z")) {

                if(!containedFields.contains(s)){

                    containedFields.add(s);

                }

            }

        }

        for (String s:containedFields) {

            ArrayList<Integer> fields = new ArrayList<>();
            int minField = 0;
            int maxField = 0;

            for (int i = 0; i < l.getPattern().getFields().length; i++) {

                if (l.getPattern().getField(i + 1).equals(s)) {

                    if (fields.size() == 0) {

                        minField = i;
                        fields.add(i);

                    } else {

                        fields.add(i);

                    }

                }

            }

            for (int i : fields) {
                if (i > maxField) {
                    maxField = i;
                }

                if (i != minField) {
                    Button b = fieldToButton(i);
                    removedButtons.add(b);
                    grid.removeView(b);
                }

                if (l.getFieldToClick() == i + 1) {
                    int c = l.getColor(i + 1);
                    fieldToButton(minField).setBackgroundColor(c);

                }

            }

            int minRow = Methods.getGridRow(minField);
            int maxRow = Methods.getGridRow(maxField);
            int minColumn = Methods.getGridColumn(minField);
            int maxColumn = Methods.getGridColumn(maxField);

            int columnSpan = maxColumn - minColumn + 1;
            int rowSpan = maxRow - minRow + 1;

            GridLayout.Spec row = GridLayout.spec(minRow);
            GridLayout.Spec column = GridLayout.spec(minColumn);

            Button bt = fieldToButton(minField);
            GridLayout.LayoutParams parms = (GridLayout.LayoutParams) bt.getLayoutParams();
            temporaryButtons.put(minField, parms);
            normalWidth=parms.width;
            normalHeight=parms.height;
            grid.removeView(bt);
            parms.columnSpec = GridLayout.spec(minColumn, columnSpan);
            parms.rowSpec = GridLayout.spec(minRow, rowSpan);
            parms.width = columnSpan * parms.width + (columnSpan - 1) * parms.leftMargin + (columnSpan - 1) * parms.rightMargin;
            parms.height = rowSpan * parms.height + (rowSpan - 1) * parms.leftMargin + (rowSpan - 1) * parms.rightMargin;
            bt.setLayoutParams(parms);
            grid.addView(bt);

            if (buttonToFields.containsKey(bt.getId())) {
                buttonToFields.get(bt.getId()).clear();
            }

            for (int i : fields) {
                //field+1!
                if (buttonToFields.containsKey(bt.getId())) {
                    ArrayList<Integer> ints = buttonToFields.get(bt.getId());
                    ints.add(i+1);
                } else {
                    ArrayList<Integer> ints = new ArrayList<>();
                    ints.add(i+1);
                    buttonToFields.put(bt.getId(), ints);
                }
            }


        }

    }

    public Button fieldToButton(int field) {

        Button b = null;

        switch (field + 1) {

            case (1):
                return (Button) grid.findViewById(R.id.button1);
            case (2):
                return (Button) grid.findViewById(R.id.button2);
            case (3):
                return (Button) grid.findViewById(R.id.button3);
            case (4):
                return (Button) grid.findViewById(R.id.button4);
            case (5):
                return (Button) grid.findViewById(R.id.button5);
            case (6):
                return (Button) grid.findViewById(R.id.button6);
            case (7):
                return (Button) grid.findViewById(R.id.button7);
            case (8):
                return (Button) grid.findViewById(R.id.button8);
            case (9):
                return (Button) grid.findViewById(R.id.button9);
            case (10):
                return (Button) grid.findViewById(R.id.button10);
            case (11):
                return (Button) grid.findViewById(R.id.button11);
            case (12):
                return (Button) grid.findViewById(R.id.button12);
            case (13):
                return (Button) grid.findViewById(R.id.button13);
            case (14):
                return (Button) grid.findViewById(R.id.button14);
            case (15):
                return (Button) grid.findViewById(R.id.button15);
            case (16):
                return (Button) grid.findViewById(R.id.button16);
            case (17):
                return (Button) grid.findViewById(R.id.button17);
            case (18):
                return (Button) grid.findViewById(R.id.button18);
            case (19):
                return (Button) grid.findViewById(R.id.button19);
            case (20):
                return (Button) grid.findViewById(R.id.button20);
            case (21):
                return (Button) grid.findViewById(R.id.button21);
            case (22):
                return (Button) grid.findViewById(R.id.button22);
            case (23):
                return (Button) grid.findViewById(R.id.button23);
            case (24):
                return (Button) grid.findViewById(R.id.button24);
            case (25):
                return (Button) grid.findViewById(R.id.button25);

        }

        return b;

    }

    public void resetButtonToFields(){

        b1 = (Button) grid.findViewById(R.id.button1);
        b2 = (Button) grid.findViewById(R.id.button2);
        b3 = (Button) grid.findViewById(R.id.button3);
        b4 = (Button) grid.findViewById(R.id.button4);
        b5 = (Button) grid.findViewById(R.id.button5);
        b6 = (Button) grid.findViewById(R.id.button6);
        b7 = (Button) grid.findViewById(R.id.button7);
        b8 = (Button) grid.findViewById(R.id.button8);
        b9 = (Button) grid.findViewById(R.id.button9);
        b10 = (Button) grid.findViewById(R.id.button10);
        b11 = (Button) grid.findViewById(R.id.button11);
        b12 = (Button) grid.findViewById(R.id.button12);
        b13 = (Button) grid.findViewById(R.id.button13);
        b14 = (Button) grid.findViewById(R.id.button14);
        b15 = (Button) grid.findViewById(R.id.button15);
        b16 = (Button) grid.findViewById(R.id.button16);
        b17 = (Button) grid.findViewById(R.id.button17);
        b18 = (Button) grid.findViewById(R.id.button18);
        b19 = (Button) grid.findViewById(R.id.button19);
        b20 = (Button) grid.findViewById(R.id.button20);
        b21 = (Button) grid.findViewById(R.id.button21);
        b22 = (Button) grid.findViewById(R.id.button22);
        b23 = (Button) grid.findViewById(R.id.button23);
        b24 = (Button) grid.findViewById(R.id.button24);
        b25 = (Button) grid.findViewById(R.id.button25);

        buttonToFields.clear();

        ArrayList<Integer> a1 = new ArrayList<>();
        a1.add(1);
        buttonToFields.put(b1.getId(), a1);
        ArrayList<Integer> a2 = new ArrayList<>();
        a2.add(2);
        buttonToFields.put(b2.getId(), a2);
        ArrayList<Integer> a3 = new ArrayList<>();
        a3.add(3);
        buttonToFields.put(b3.getId(), a3);
        ArrayList<Integer> a4 = new ArrayList<>();
        a4.add(4);
        buttonToFields.put(b4.getId(), a4);
        ArrayList<Integer> a5 = new ArrayList<>();
        a5.add(5);
        buttonToFields.put(b5.getId(), a5);
        ArrayList<Integer> a6 = new ArrayList<>();
        a6.add(6);
        buttonToFields.put(b6.getId(), a6);
        ArrayList<Integer> a7 = new ArrayList<>();
        a7.add(7);
        buttonToFields.put(b7.getId(), a7);
        ArrayList<Integer> a8 = new ArrayList<>();
        a8.add(8);
        buttonToFields.put(b8.getId(), a8);
        ArrayList<Integer> a9 = new ArrayList<>();
        a9.add(9);
        buttonToFields.put(b9.getId(), a9);
        ArrayList<Integer> a10 = new ArrayList<>();
        a10.add(10);
        buttonToFields.put(b10.getId(), a10);
        ArrayList<Integer> a11 = new ArrayList<>();
        a11.add(11);
        buttonToFields.put(b11.getId(), a11);
        ArrayList<Integer> a12 = new ArrayList<>();
        a12.add(12);
        buttonToFields.put(b12.getId(), a12);
        ArrayList<Integer> a13 = new ArrayList<>();
        a13.add(13);
        buttonToFields.put(b13.getId(), a13);
        ArrayList<Integer> a14 = new ArrayList<>();
        a14.add(14);
        buttonToFields.put(b14.getId(), a14);
        ArrayList<Integer> a15 = new ArrayList<>();
        a15.add(15);
        buttonToFields.put(b15.getId(), a15);
        ArrayList<Integer> a16 = new ArrayList<>();
        a16.add(16);
        buttonToFields.put(b16.getId(), a16);
        ArrayList<Integer> a17 = new ArrayList<>();
        a17.add(17);
        buttonToFields.put(b17.getId(), a17);
        ArrayList<Integer> a18 = new ArrayList<>();
        a18.add(18);
        buttonToFields.put(b18.getId(), a18);
        ArrayList<Integer> a19 = new ArrayList<>();
        a19.add(19);
        buttonToFields.put(b19.getId(), a19);
        ArrayList<Integer> a20 = new ArrayList<>();
        a20.add(20);
        buttonToFields.put(b20.getId(), a20);
        ArrayList<Integer> a21 = new ArrayList<>();
        a21.add(21);
        buttonToFields.put(b21.getId(), a21);
        ArrayList<Integer> a22 = new ArrayList<>();
        a22.add(22);
        buttonToFields.put(b22.getId(), a22);
        ArrayList<Integer> a23 = new ArrayList<>();
        a23.add(23);
        buttonToFields.put(b23.getId(), a23);
        ArrayList<Integer> a24 = new ArrayList<>();
        a24.add(24);
        buttonToFields.put(b24.getId(), a24);
        ArrayList<Integer> a25 = new ArrayList<>();
        a25.add(25);
        buttonToFields.put(b25.getId(), a25);

    }

    private class groupFieldsTask extends AsyncTask<Level, Integer[], Level> {
        @Override
        protected void onProgressUpdate(Integer[]... values) {

            int minField = values[1][0];
            int maxField = values[1][1];

            for (Integer i:values[0]
                 ) {
                if (i != minField) {
                    Button b = fieldToButton(i);
                    removedButtons.add(b);
                    grid.removeView(b);
                }

                if (i + 1 == values[2][0]) {
                    int c = values[2][1];
                    fieldToButton(minField).setBackgroundColor(c);

                }
            }

            int minRow = Methods.getGridRow(minField);
            int maxRow = Methods.getGridRow(maxField);
            int minColumn = Methods.getGridColumn(minField);
            int maxColumn = Methods.getGridColumn(maxField);

            int columnSpan = maxColumn - minColumn + 1;
            int rowSpan = maxRow - minRow + 1;

            Button bt = fieldToButton(minField);
            GridLayout.LayoutParams parms = (GridLayout.LayoutParams) bt.getLayoutParams();
            temporaryButtons.put(minField, parms);
            normalWidth=parms.width;
            normalHeight=parms.height;
            parms.columnSpec = GridLayout.spec(minColumn, columnSpan);
            parms.rowSpec = GridLayout.spec(minRow, rowSpan);
            parms.width = columnSpan * parms.width + (columnSpan - 1) * parms.leftMargin + (columnSpan - 1) * parms.rightMargin;
            parms.height = rowSpan * parms.height + (rowSpan - 1) * parms.leftMargin + (rowSpan - 1) * parms.rightMargin;
            bt.setLayoutParams(parms);
            grid.addView(bt);

            if (buttonToFields.containsKey(bt.getId())) {
                buttonToFields.get(bt.getId()).clear();
            }

            for (int i : values[0]) {
                //field+1!
                if (buttonToFields.containsKey(bt.getId())) {
                    ArrayList<Integer> ints = buttonToFields.get(bt.getId());
                    ints.add(i+1);
                } else {
                    ArrayList<Integer> ints = new ArrayList<>();
                    ints.add(i+1);
                    buttonToFields.put(bt.getId(), ints);
                }
            }
            super.onProgressUpdate(values);
        }

        @Override
        protected Level doInBackground(Level... params) {
            ArrayList<String> containedFields = new ArrayList<>();

            Level l = params[0];

            for (String s : l.getColorToString().keySet()) {

                if (s.equals("a") || s.equals("b") || s.equals("c") || s.equals("d") || s.equals("e") || s.equals("f") || s.equals("g") || s.equals("h") || s.equals("i") || s.equals("j") || s.equals("k") || s.equals("l") || s.equals("m") || s.equals("n") || s.equals("o") || s.equals("p") || s.equals("j") || s.equals("r") || s.equals("s") || s.equals("t") || s.equals("u") || s.equals("v") || s.equals("w") || s.equals("x") || s.equals("y") || s.equals("z")) {

                    if(!containedFields.contains(s)){

                        containedFields.add(s);

                    }

                }

            }

            for (String s:containedFields) {

                ArrayList<Integer> fields = new ArrayList<>();
                int minField = 0;
                int maxField = 0;
                Integer[] array1 = new Integer[25];
                Integer[] array2 = new Integer [2];
                Integer[] array3 = new Integer[2];

                for (int i = 0; i < l.getPattern().getFields().length; i++) {

                    if (l.getPattern().getField(i + 1).equals(s)) {

                        if (fields.size() == 0) {

                            minField = i;
                            fields.add(i);

                        } else {

                            fields.add(i);

                        }

                    }

                }

                array2[0] = minField;

                for (int i : fields) {
                    if (i > maxField) {
                        maxField = i;
                        array2[1] = maxField;
                    }

                    if (l.getFieldToClick() == i + 1) {
                        int c = l.getColor(i + 1);
                        array3[0] = l.getFieldToClick();
                        array3[1] = c;

                    }

                }

                int pos = 0;

                for (int i:fields) {
                    array1[pos] = i;
                    pos++;
                }

                publishProgress(array1,array2,array3);


            }
            return params[0];
        }
        @Override
        protected void onPostExecute(Level l) {
            super.onPostExecute(l);
        }

        @Override
        protected void onPreExecute() {
            // TODO Auto-generated method stub
            super.onPreExecute();
        }

    }

}

