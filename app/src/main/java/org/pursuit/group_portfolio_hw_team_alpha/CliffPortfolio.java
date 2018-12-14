package org.pursuit.group_portfolio_hw_team_alpha;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class CliffPortfolio extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener, View.OnClickListener {
    private TextView bioTextView;
    private FloatingActionButton fab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliff_portfolio);

        setBorderColor();

        Button GitHubButton = findViewById(R.id.cliff_github_menu);
        GitHubButton.setOnClickListener(this);

        fab = (FloatingActionButton) findViewById(R.id.cliff_email);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Email = new Intent(Intent.ACTION_SEND);
                Email.setType("text/email");
                Email.putExtra(Intent.EXTRA_EMAIL,
                        new String[]{"cliffcharles@pursuit.org"});  //developer 's email
                Email.putExtra(Intent.EXTRA_SUBJECT,
                        "Hello Cliff"); // Email 's Subject
                Email.putExtra(Intent.EXTRA_TEXT, "Dear Cliff," + "");  //Email 's Greeting text
                startActivity(Intent.createChooser(Email, "Send Message:"));
            }
        });
    }



    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {


        switch (menuItem.getItemId()) {
            case R.id.elizabeth_EYrestaurant:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/flyelizabethsisi/EYrestaurant")));
                return true;
            case R.id.elizabeth_JavaBank:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/flyelizabethsisi/Java_Bank_Pursuit_HW_YU_ELIZABETH")));
                return true;
            case R.id.elizabeth_AndroidStoryApp:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/flyelizabethsisi/Story_App_HW_YU_ELIZABETH")));
                return true;
            default:
                return false;
        }
    }

    @Override
    public void onClick(View v) {
        PopupMenu CliffGitMenu = new PopupMenu(v.getContext(), v);
        CliffGitMenu.setOnMenuItemClickListener(this); //refers to my activity
        CliffGitMenu.inflate(R.menu.cliff_github_menu);
        CliffGitMenu.show();
    }


    public void setBorderColor() {
        ShapeDrawable sd = new ShapeDrawable();
        sd.setShape(new RectShape());
        sd.getPaint().setColor(Color.BLACK);
        sd.getPaint().setStrokeWidth(1f);
        sd.getPaint().setStyle(Paint.Style.STROKE);
        bioTextView.setBackground(sd);
    }
}