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

public class EnriquePortfolio extends AppCompatActivity implements View.OnClickListener, PopupMenu.OnMenuItemClickListener {
    private TextView bioTextView;
    private FloatingActionButton fab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enrique_portfolio);
        bioTextView = findViewById(R.id.enrique_text);


        // setBorderColor();

        Button GitHubButton = findViewById(R.id.enrique_github_menu);
        GitHubButton.setOnClickListener(this);
        bioTextView.setMovementMethod(new ScrollingMovementMethod());

        fab = (FloatingActionButton) findViewById(R.id.enrique_email);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Email = new Intent(Intent.ACTION_SEND);
                Email.setType("text/email");
                Email.putExtra(Intent.EXTRA_EMAIL,
                        new String[]{"enriquecruz@pursuit.org"});  //developer 's email
                Email.putExtra(Intent.EXTRA_SUBJECT,
                        "Hello Enrique"); // Email 's Subject
                Email.putExtra(Intent.EXTRA_TEXT, "Dear Enrique," + "");  //Email 's Greeting text
                startActivity(Intent.createChooser(Email, "Send Message:"));
            }
        });
    }


    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {


        switch (menuItem.getItemId()) {
            case R.id.Mad_Libbs:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/enricky13/MADLIBBS_NOV_13_2018")));
                return true;
            case R.id.Bank_Teller:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/enricky13/Java_Bank_Pursuit_HW_CRUZ_ENRIQUE")));
                return true;
            case R.id.Adventure_Game:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/enricky13/enricky13-CYOA_Pursuit_HW_CRUZ_ENRIQUE")));
                return true;
            default:
                return false;
        }
    }

    @Override
    public void onClick(View v) {
        PopupMenu EnriqueGitMenu = new PopupMenu(v.getContext(), v);
        EnriqueGitMenu.setOnMenuItemClickListener(this); //refers to my activity
        EnriqueGitMenu.inflate(R.menu.enrique_github_menu);
        EnriqueGitMenu.show();
    }
}