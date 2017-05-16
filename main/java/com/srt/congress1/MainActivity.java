package com.srt.congress1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity{
    DrawerLayout mDrawerLayout;
    NavigationView mNavigationView;
    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.srt.congress1.R.layout.activity_main);
        //Intent i = new Intent(this, legisActivity.class);
        //startActivity(i);
        /**
         *
         *
         *Setup the DrawerLayout and NavigationView
         */


             mDrawerLayout = (DrawerLayout) findViewById(com.srt.congress1.R.id.drawerLayout);
             mNavigationView = (NavigationView) findViewById(com.srt.congress1.R.id.shinavview) ;

        /**
         * Lets inflate the very first fragment
         * Here , we are inflating the TabFragment as the first Fragment
         */

             mFragmentManager = getSupportFragmentManager();
             mFragmentTransaction = mFragmentManager.beginTransaction();
             mFragmentTransaction.replace(com.srt.congress1.R.id.containerView,new TabFragment()).commit();
        /**
         * Setup click events on the Navigation View Items.
         */

             mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
             @Override
             public boolean onNavigationItemSelected(MenuItem menuItem) {
                mDrawerLayout.closeDrawers();


                 if (menuItem.getItemId() == R.id.nav_bills) {
                     FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
                     fragmentTransaction.replace(com.srt.congress1.R.id.containerView,new TabFrag2()).commit();

                 }

                if (menuItem.getItemId() == R.id.nav_legis) {
                    FragmentTransaction xfragmentTransaction = mFragmentManager.beginTransaction();
                    xfragmentTransaction.replace(com.srt.congress1.R.id.containerView,new TabFragment()).commit();
                }

                 if (menuItem.getItemId() == R.id.nav_comm) {
                     FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
                     fragmentTransaction.replace(com.srt.congress1.R.id.containerView,new TabFrag3()).commit();

                 }

                 if (menuItem.getItemId() == R.id.nav_abtme) {
                     Intent i = new Intent(getApplication(),AboutActivity.class);
                     startActivity(i);

                 }


                 return false;
            }

        });

        /**
         * Setup Drawer Toggle of the Toolbar
         */

                android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(com.srt.congress1.R.id.toolbar);
                ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this,mDrawerLayout, toolbar, com.srt.congress1.R.string.app_name,
                com.srt.congress1.R.string.app_name);

                mDrawerLayout.setDrawerListener(mDrawerToggle);

                mDrawerToggle.syncState();

    }
    public void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);
    }


}