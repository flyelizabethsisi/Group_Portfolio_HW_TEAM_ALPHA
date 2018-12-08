package org.pursuit.group_portfolio_hw_team_alpha;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
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

    public void borderColors() {
        ShapeDrawable sd = new ShapeDrawable();
        sd.setShape(new RectShape());
        sd.getPaint().setColor(R.color.colorAccent);
        sd.getPaint().setStrokeWidth(10f);
        sd.getPaint().setStyle(Paint.Style.STROKE);
        goalAppText.setBackground(sd);
    }


}
