package org.pursuit.group_portfolio_hw_team_alpha;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;

import java.net.URI;

public class TalhaPortfolio extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_talha_portfolio);
    }

    public void optionSelect(MenuItem item) { //delete your name case in your java code
        switch (item.getItemId()) {
            case R.id.enrique_page:
                Intent Enrique_intent = new Intent(this, EnriquePortfolio.class);
                startActivity(Enrique_intent);
            case R.id.clifford_page:
                Intent Clifford_intent = new Intent(this, CliffPortfolio.class);
                startActivity(Clifford_intent);
            case R.id.elizabeth_page:
                Intent Elizabeth_intent = new Intent(this, ElizabethPortfolio.class);
                startActivity(Elizabeth_intent);
            case R.id.talha_page:
                Intent Talha_intent = new Intent(this, TalhaPortfolio.class);
                startActivity(Talha_intent);
        }
    }

    public void GitHubMenu(View view) {
        PopupMenu TalhaGitMenu = new PopupMenu(this, view);
        TalhaGitMenu.setOnMenuItemClickListener(this);
        TalhaGitMenu.inflate(R.menu.talha_github_menu); //to the ID assigned to your menu in the xml
        TalhaGitMenu.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.Talha_AdventureGame:
                Intent intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/talharahman/Adventure_Game"));
                startActivity(intent1);
                return true;
            case R.id.Talha_JavaBank:
                Intent intent2 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/talharahman/JavaBank"));
                startActivity(intent2);
                return true;
            case R.id.Talha_AndroidStoryApp:
                Intent intent3 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/talharahman/StoryApp-HW-Rahman-Talha"));
                startActivity(intent3);
            default:
                return false;
        }
    }

}
