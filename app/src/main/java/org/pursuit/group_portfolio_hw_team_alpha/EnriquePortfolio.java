package org.pursuit.group_portfolio_hw_team_alpha;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class EnriquePortfolio extends AppCompatActivity {
    private TextView bioTextView;
    private ImageButton backToMenuButton;
    private Button gitProjectButton;
    private String linkToGithubString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enrique_portfolio);
        setReferences();
        goToMenu();
        setBorderColor();
        alertBoxForGithub();

    }

    public void setReferences(){
        bioTextView = findViewById(R.id.enrique_text);
        gitProjectButton = findViewById(R.id.enrique_github_menu);
        linkToGithubString = getResources().getString(R.string.link_to_github);

        bioTextView.setMovementMethod(new ScrollingMovementMethod());       // This is a scroll view

    }

    public void goToMenu(){
        backToMenuButton.setOnClickListener(new View.OnClickListener() {    // This button goes back to the Home Page
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public void goToProjects(){
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse(linkToGithubString));
                startActivity(intent);
    }

    public void alertBoxForGithub(){
        gitProjectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder gitAlertBuilder = new AlertDialog.Builder(EnriquePortfolio.this);
                gitAlertBuilder.setTitle(R.string.alert_title);
                gitAlertBuilder.setMessage(R.string.alert_message);

                //This button is for when the user clicks on ok
                gitAlertBuilder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        goToProjects();
                    }
                });


                gitAlertBuilder.show();

            }
        });
    }

    public void setBorderColor(){
        ShapeDrawable sd = new ShapeDrawable();
        sd.setShape(new RectShape());
        sd.getPaint().setColor(Color.BLACK);
        sd.getPaint().setStrokeWidth(1f);
        sd.getPaint().setStyle(Paint.Style.STROKE);
        bioTextView.setBackground(sd);
    }

//    The menu and its functions are here along with more options on the menu

}
