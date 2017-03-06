package com.fsebasorozco.turismotibasosaapp;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MenuActivity extends LogginActivity
{

    FragmentManager fm;
    FragmentTransaction ft;

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(pagerAdapter);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        ActionBar.TabListener tabListener = new ActionBar.TabListener() {
            @Override
            public void onTabSelected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {
                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {

            }

            @Override
            public void onTabReselected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {
            }
        };

        ActionBar.Tab tab = actionBar.newTab().setText("Bebidas").setTabListener(tabListener);
        actionBar.addTab (tab);
        tab = actionBar.newTab().setText("Pastas").setTabListener(tabListener);
        actionBar.addTab (tab);
        tab = actionBar.newTab().setText("Postres").setTabListener(tabListener);
        actionBar.addTab (tab);

        mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){
            @Override
            public void onPageSelected(int position) {
                getSupportActionBar().setSelectedNavigationItem(position);

            }
        });

    }

    public class PagerAdapter extends FragmentPagerAdapter {

        public PagerAdapter(android.support.v4.app.FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){

                default: return null;
            }
        }

        @Override
        public int getCount() {
            return 3;
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();
        if(id == R.id.menumain)
        {
            Intent intent = new Intent(this,MainActivity.class);
            intent.putExtra("User2",user);
            intent.putExtra("Pass2",pass);
            intent.putExtra("RePass2",repass);
            intent.putExtra("Email2",email);
            startActivityForResult(intent, 4567);
            setResult(RESULT_OK,intent);
            finish();
        }
        else if(id == R.id.menuover)
        {
            Intent intent = new Intent(this,PerfilActivity.class);
            intent.putExtra("User2",user);
            intent.putExtra("Pass2",pass);
            intent.putExtra("RePass2",repass);
            intent.putExtra("Email2",email);
            startActivityForResult(intent, 4567);
            setResult(RESULT_OK,intent);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
