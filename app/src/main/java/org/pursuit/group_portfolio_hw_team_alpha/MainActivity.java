package org.pursuit.group_portfolio_hw_team_alpha;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    //private ActionBarDrawerToggle drawerToggle;
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("MAIN ACTIVITY","onCreate");

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.ic_hamburger_menu);
        actionBar.setDisplayHomeAsUpEnabled(true); //enables back button as nav drawer button


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: //button
                drawer.openDrawer(Gravity.START);
                break;
        }
        return true;
    }

    
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.enqrique_page:
                Intent enriqueIntent = new Intent(getApplicationContext(),EnriquePortfolio.class);
                startActivity(enriqueIntent);
                return true;
            case R.id.talha_page:
                Intent talhaIntent = new Intent(getApplicationContext(),TalhaPortfolio.class);
                startActivity(talhaIntent);
                return true;
            case R.id.elizabeth_page:
                Intent elizabethIntent = new Intent(getApplicationContext(),ElizabethPortfolio.class);
                startActivity(elizabethIntent);
                return true;
            case R.id.cliff_page:
                Intent cliffIntent = new Intent(getApplicationContext(),CliffPortfolio.class);
                startActivity(cliffIntent);
                return true;
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

}
