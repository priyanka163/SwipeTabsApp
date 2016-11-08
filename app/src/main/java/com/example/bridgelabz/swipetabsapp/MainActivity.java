package com.example.bridgelabz.swipetabsapp;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

public class MainActivity extends AppCompatActivity {

    Toolbar mToolbar;
    TabLayout mTabLayout;
    ViewPager mViewpager;
    private  int[] tabIcon={
            R.drawable.ggl,R.drawable.fb,R.drawable.bird,R.drawable.whatsapp
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewpager = (ViewPager) findViewById(R.id.viewpage);

        mTabLayout = (TabLayout) findViewById(R.id.tabs);
        mTabLayout.setupWithViewPager(mViewpager);

        //    mToolbar= (Toolbar) findViewById(R.id.toolbar);
        //   setSupportActionBar(mToolbar);//this is used for safer sake
// im using appcompactactivity so i used getsupportActionbar
        //    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //


        setupViewPager(mViewpager);
        setupTabIcon();
    }

    private void setupTabIcon(){
        mTabLayout.getTabAt(0).setIcon(tabIcon[0]);
        mTabLayout.getTabAt(1).setIcon(tabIcon[1]);
        mTabLayout.getTabAt(2).setIcon(tabIcon[2]);
        mTabLayout.getTabAt(3).setIcon(tabIcon[3]);
    }

    private void setupViewPager(ViewPager mViewpager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new FragmentOneApp(), "google");
        adapter.addFragment(new FragmentTwoApp(), "Facebook");
        adapter.addFragment(new FragmentThreeApp(), "Twitter");
        adapter.addFragment(new FragmentFourApp(), "WhatsApp");
        mViewpager.setAdapter(adapter);

    }

    //crating class of viewpagerAdapter
    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragments = new ArrayList<>();
        private final List<String> mFragmentsTittlelist = new ArrayList<>();


        //calling constructor
        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        public void addFragment(Fragment fragment, String tittle) {
            mFragments.add(fragment);
            mFragmentsTittlelist.add(tittle);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentsTittlelist.get(position);
        }

    }
}
