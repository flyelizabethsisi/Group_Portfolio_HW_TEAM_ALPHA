package org.pursuit.group_portfolio_hw_team_alpha;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private DrawerLayout drawer;
    private TextView goalAppText;
    private ImageView cliff;
    private ImageView enrique;
    private ImageView elizabeth;
    private ImageView talha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        goalAppText = findViewById(R.id.goal_textView);
        goalAppText.setMovementMethod(new ScrollingMovementMethod());
        borderColors();

        cliff = findViewById(R.id.cliff_imageView);
        enrique = findViewById(R.id.enrique_imageView);
        elizabeth = findViewById(R.id.elizabeth_imageView);
        talha = findViewById(R.id.talha_imageView);
        goToPortfolio();

        Log.d("MAIN ACTIVITY","onCreate");

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.ic_hamburger_menu);
        actionBar.setDisplayHomeAsUpEnabled(true);


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


    public void goToPortfolio() {
        cliff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CliffPortfolio.class);
                startActivity(intent);
            }
        });

        enrique.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EnriquePortfolio.class);
                startActivity(intent);

            }
        });
        elizabeth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ElizabethPortfolio.class);
                startActivity(intent);
                Log.d(intent.toString(), "ELIZABETH PAGE ");

            }
        });
        talha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TalhaPortfolio.class);
                startActivity(intent);

            }
        });
    }

    @SuppressLint("ResourceAsColor")
    public void borderColors() {
        ShapeDrawable sd = new ShapeDrawable();
        sd.setShape(new RectShape());
        sd.getPaint().setColor(R.color.colorAccent);
        sd.getPaint().setStrokeWidth(10f);
        sd.getPaint().setStyle(Paint.Style.STROKE);
        goalAppText.setBackground(sd);
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
