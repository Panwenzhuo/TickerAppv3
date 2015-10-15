package com.evtian.tixie.tickerappv3;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toolbar;

import com.evtian.tixie.tickerappv3.tabs.SlidingTabLayout;


public class MainActivity extends ActionBarActivity {  //using appcombat v7 so needs to be ActionBarActivity also make sure styles.xml is changed

    private Toolbar toolbar;
    private ViewPager mPager;
    private SlidingTabLayout mTabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar =(Toolbar) findViewById(R.id.app_bar);  //thats why you assign an id to app_bar.xml
        setActionBar(toolbar);  //for v7 use setSupportActionBar

        mPager = (ViewPager)findViewById(R.id.pager);
        mTabs = (SlidingTabLayout)findViewById(R.id.tabs);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public static class MyFragment extends Fragment{
        public static MyFragment getInstance(){
            MyFragment myFragment=new MyFragment();
            return myFragment;
        }

        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
            View layout=inflater.inflate(R.layout.fragment_my,container,false);
            return layout;
        }

 //test comment

    }

    class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return null;
        }

        @Override
        public int getCount() {
            return 0;
        }
    }
}


// android support

//http://stackoverflow.com/questions/14218519/want-to-use-viewpager-cannot-get-android-support-to-be-recognized  --  Want to use ViewPager, cannot get android.support.* to be recognized? - Stack Overflow
// to prevent IllegalStateException you need to change the styles.xml like in slidenerd's video: Android Material Design Colors: Android Tutorial For Beginners