package com.srt.congress1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class TabFrag3 extends Fragment {

    public static TabLayout tabLayout;
    public static ViewPager viewPager;
    public static int int_items = 3 ;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        /**
         *Inflate tab_layout and setup Views.
         */
        //View vi = getView();
        Toolbar mActionBarToolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        //setSupportActionBar(mActionBarToolbar);
        mActionBarToolbar.setTitle("Committees");
        View x =  inflater.inflate(com.srt.congress1.R.layout.tab_layout,null);
        tabLayout = (TabLayout) x.findViewById(com.srt.congress1.R.id.tabs);
        viewPager = (ViewPager) x.findViewById(com.srt.congress1.R.id.viewpager);

        /**
         *Set an Apater for the View Pager
         */
        viewPager.setAdapter(new MyAdapter(getChildFragmentManager()));

        /**
         * Now , this is a workaround ,
         * The setupWithViewPager dose't works without the runnable .
         * Maybe a Support Library Bug .
         */

        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                tabLayout.setupWithViewPager(viewPager);
            }
        });

        return x;

    }

    class MyAdapter extends FragmentPagerAdapter{

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        /**
         * Return fragment with respect to Position .
         */

        @Override
        public Fragment getItem(int position)
        {
            switch (position){
                case 0 : return new CommFrag1();
                case 1 : return new CommFrag2();
                case 2 : return new CommFrag3();
            }
            return null;
        }

        @Override
        public int getCount() {

            return int_items;

        }

        /**
         * This method returns the title of the tab according to the position.
         */

        @Override
        public CharSequence getPageTitle(int position) {

            switch (position){
                case 0 :
                    return "HOUSE";
                case 1 :
                    return "SENATE";
                case 2 :
                    return "JOINT";

            }
            return null;
        }
    }

}
