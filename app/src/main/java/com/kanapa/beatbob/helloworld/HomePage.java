package com.kanapa.beatbob.helloworld;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.TextView;

public class HomePage extends FragmentActivity {

    public static Game g;
    Thread t;
    static TextView timerView;
    static TextView levelView;
    public final static int FIRST_PAGE = 1;
    public static CustomViewPager pager;
    public static PagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        timerView = (TextView) findViewById(R.id.timerView);

        PatternManager.getManager().loadPattern();
        ColorTemplateManager.loadTemplates();
        g = GameManager.newGame();

        pager = (CustomViewPager) findViewById(R.id.viewpager);

        adapter = new PagerAdapter(this, this.getSupportFragmentManager());
        pager.setAdapter(adapter);

        pager.setCurrentItem(FIRST_PAGE);

        pager.setOffscreenPageLimit(1);

    }

    public void startTimer(final long duration) {

        final long startTime = System.currentTimeMillis();

        t = new Thread() {

            @Override
            public void run() {
                try {
                    while (!isInterrupted()) {
                        Thread.sleep(1);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                long currentTime = System.currentTimeMillis();
                                if (currentTime - startTime >= duration) {
                                    t.interrupt();
                                } else {
                                    long elapsedMillis = currentTime - startTime;
                                    float elapsedTime = 10000 - elapsedMillis;
                                    timerView.setText(elapsedTime + "ms");
                                }
                            }
                        });
                    }
                } catch (InterruptedException e) {
                }
            }
        };

        t.start();

    }

    public void cancelTimer() {

        t.interrupt();

    }

}