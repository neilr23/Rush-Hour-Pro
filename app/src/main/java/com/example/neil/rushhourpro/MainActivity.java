package com.example.neil.rushhourpro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageButton mtitle;
    private ImageButton msolveButton;
    private ImageButton mhelpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mtitle = (ImageButton)findViewById(R.id.nofunction);
        msolveButton = (ImageButton)findViewById(R.id.solvebutton);
        mhelpButton = (ImageButton)findViewById(R.id.helpbutton);
        mtitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, String.valueOf("Welcome!"), Toast.LENGTH_SHORT).show();
            }
        });
        msolveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, InputActivity.class);
                startActivity(i);
            }
        });
        mhelpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, HelpActivity.class);
                startActivity(i);
            }
        });
    }
}
