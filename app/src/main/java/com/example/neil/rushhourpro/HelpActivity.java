package com.example.neil.rushhourpro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class HelpActivity extends AppCompatActivity {
    private TextView mr1;
    private TextView mr2;
    private TextView mr3;
    private TextView mr4;
    private TextView mr5;
    private TextView mr6;
    private TextView mr7;
    private ImageButton mstate;
    private ImageButton mhomeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        mr1 = (TextView) findViewById(R.id.rh1);
        mr2 = (TextView) findViewById(R.id.rh2);
        mr3 = (TextView) findViewById(R.id.rh3);
        mr4 = (TextView) findViewById(R.id.rh4);
        mr5 = (TextView) findViewById(R.id.rh5);
        mr6 = (TextView) findViewById(R.id.rh6);
        mr7 = (TextView) findViewById(R.id.rh7);
        mstate = (ImageButton) findViewById(R.id.gamestate);
        mhomeButton = (ImageButton)findViewById(R.id.homebutton);
        mstate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HelpActivity.this, String.valueOf("Example Game State"), Toast.LENGTH_SHORT).show();
            }
        });
        mr1.setText("......");
        mr2.setText("..^...");
        mr3.setText("SEU...");
        mr4.setText("..v.<>");
        mr5.setText("<L>.^^");
        mr6.setText("....vv");
        mr7.setText("S and E represent the red car, ^, U, v represent a car that moves up and down, and <, L, > represent a car that moves left and right");

        mhomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HelpActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}
