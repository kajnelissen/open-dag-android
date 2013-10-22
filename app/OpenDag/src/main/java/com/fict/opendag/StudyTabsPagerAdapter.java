package com.fict.opendag;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.fict.opendag.data.EntityManager;

/**
 * Created by Kaj on 21-10-13.
 */
public class StudyTabsPagerAdapter extends FragmentPagerAdapter {

    public StudyTabsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int index) {

        EntityManager em = EntityManager.getInstance();

        switch (index) {
            case 0:
                // Top Rated fragment activity
//                return new TopRatedFragment();
//                return new StudyFragment(em.studies().getById());
            case 1:
                // Games fragment activity
//                return new GamesFragment();
            case 2:
                // Movies fragment activity
//                return new MoviesFragment();
        }

        return null;
    }

    @Override
    public int getCount() {
        // get item count - equal to number of tabs
        return 3;
    }

}
