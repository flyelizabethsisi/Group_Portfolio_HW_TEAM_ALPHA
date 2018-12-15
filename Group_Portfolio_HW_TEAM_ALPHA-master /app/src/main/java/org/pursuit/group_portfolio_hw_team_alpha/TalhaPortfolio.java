package org.pursuit.group_portfolio_hw_team_alpha;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.text.method.ScrollingMovementMethod;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TalhaPortfolio extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener, View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_talha_portfolio);

        TextView talhaBio = findViewById(R.id.talha_text);
        talhaBio.setMovementMethod(new ScrollingMovementMethod()); // This is a scroll view

        Button talha_github = findViewById(R.id.talha_github_menu);
        talha_github.setOnClickListener(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.talha_email);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Email = new Intent(Intent.ACTION_SEND);
                Email.setType("text/email");
                Email.putExtra(Intent.EXTRA_EMAIL,
                        new String[]{"talharahman@pursuit.org"});  //developer 's email
                Email.putExtra(Intent.EXTRA_SUBJECT,
                        "Hello Talha"); // Email 's Subject
                Email.putExtra(Intent.EXTRA_TEXT, "Dear Talha," + "");  //Email 's Greeting text
                startActivity(Intent.createChooser(Email, "Send Message:"));
            }
        });
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.Talha_AdventureGame:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/talharahman/Adventure_Game")));
                return true;
            case R.id.Talha_JavaBank:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/talharahman/JavaBank")));
                return true;
            case R.id.Talha_AndroidStoryApp:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/talharahman/StoryApp-HW-Rahman-Talha")));
            default:
                return false;
        }
    }

    @Override
    public void onClick(View v) {
        PopupMenu TalhaGitMenu = new PopupMenu(v.getContext(), v);
        TalhaGitMenu.setOnMenuItemClickListener(this); //refers to my activity
        TalhaGitMenu.inflate(R.menu.talha_github_menu); //to the ID assigned to your menu in the xml
        TalhaGitMenu.show();
    }

}
