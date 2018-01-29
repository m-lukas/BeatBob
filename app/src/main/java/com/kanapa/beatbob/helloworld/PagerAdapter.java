package com.kanapa.beatbob.helloworld;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by lm-go on 19.02.2017.
 */

public class PagerAdapter extends FragmentStatePagerAdapter {

    private ButtonGrid cur = null;
    private ButtonGrid next = null;
    private HomePage context;
    private FragmentManager fm;

    public PagerAdapter(HomePage context, FragmentManager fm) {
        super(fm);
        this.fm = fm;
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        // make the first pager bigger than others
        //position = position % MainActivity.PAGES;
        return CustomFragment.newInstance(context, position);
    }

    @Override
    public int getCount() {
        return 128;
    }
}
