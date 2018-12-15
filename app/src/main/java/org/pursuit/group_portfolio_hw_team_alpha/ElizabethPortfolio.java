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

public class ElizabethPortfolio extends AppCompatActivity implements View.OnClickListener, PopupMenu.OnMenuItemClickListener {
    private TextView bioTextView;
    private FloatingActionButton fab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elizabeth_portfolio);
        bioTextView = findViewById(R.id.elizabeth_text);


        // setBorderColor();

        Button GitHubButton = findViewById(R.id.elizabeth_github_menu);
        GitHubButton.setOnClickListener(this);
        bioTextView.setMovementMethod(new ScrollingMovementMethod());

        fab = (FloatingActionButton) findViewById(R.id.elizabeth_email);

            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent Email = new Intent(Intent.ACTION_SEND);
                    Email.setType("text/email");
                    Email.putExtra(Intent.EXTRA_EMAIL,
                            new String[]{"elizabethyu@pursuit.org"});  //developer 's email
                    Email.putExtra(Intent.EXTRA_SUBJECT,
                            "Hello Elizabeth"); // Email 's Subject
                    Email.putExtra(Intent.EXTRA_TEXT, "Dear Elizabeth," + "");  //Email 's Greeting text
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
        PopupMenu ElizabethGitMenu = new PopupMenu(v.getContext(), v);
        ElizabethGitMenu.setOnMenuItemClickListener(this); //refers to my activity
        ElizabethGitMenu.inflate(R.menu.elizabeth_github_menu);
        ElizabethGitMenu.show();
    }


/*    public void setBorderColor() {
        ShapeDrawable sd = new ShapeDrawable();
        sd.setShape(new RectShape());
        sd.getPaint().setColor(Color.BLACK);
        sd.getPaint().setStrokeWidth(1f);
        sd.getPaint().setStyle(Paint.Style.STROKE);
        bioTextView.setBackground(sd);
    }*/


}


