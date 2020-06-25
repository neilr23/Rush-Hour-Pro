package com.example.neil.rushhourpro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

public class SolveActivity extends AppCompatActivity {

    private int mCurrentIndex = 0;
    private String mCurrentPuzzle;
    private String mSpace;
    private String ms1;
    private String ms2;
    private String ms3;
    private String ms4;
    private String ms5;
    private String ms6;
    private ArrayList<String> mSeq;
    private TextView mr1;
    private TextView mr2;
    private TextView mr3;
    private TextView mr4;
    private TextView mr5;
    private TextView mr6;
    private ImageButton mNextButton;
    private ImageButton mhomeButton;
    private ImageButton mprevButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solve);
        mr1 = (TextView) findViewById(R.id.r1);
        mr2 = (TextView) findViewById(R.id.r2);
        mr3 = (TextView) findViewById(R.id.r3);
        mr4 = (TextView) findViewById(R.id.r4);
        mr5 = (TextView) findViewById(R.id.r5);
        mr6 = (TextView) findViewById(R.id.r6);
        mSpace = "";
        mSeq = getIntent().getStringArrayListExtra("list");
        mNextButton = (ImageButton) findViewById(R.id.next_button);
        mCurrentPuzzle = mSeq.get(0);
        mhomeButton = (ImageButton)findViewById(R.id.homebutton);
        mprevButton = (ImageButton)findViewById(R.id.prevbutton);
        ms1 = mCurrentPuzzle.substring(0,6) + mSpace;
        ms2 = mCurrentPuzzle.substring(6,12) + mSpace;
        ms3 = mCurrentPuzzle.substring(12,18) + mSpace;
        ms4 = mCurrentPuzzle.substring(18,24) + mSpace;
        ms5 = mCurrentPuzzle.substring(24,30) + mSpace;
        ms6 = mCurrentPuzzle.substring(30) + mSpace;
        mr1.setText(ms1);
        mr2.setText(ms2);
        mr3.setText(ms3);
        mr4.setText(ms4);
        mr5.setText(ms5);
        mr6.setText(ms6);

        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCurrentIndex < mSeq.size()-1)
                    mCurrentIndex ++;
                if (mCurrentIndex < mSeq.size())
                {
                    mCurrentPuzzle = mSeq.get(mCurrentIndex);
                    String r1 = mCurrentPuzzle.substring(0,6) + mSpace;
                    String r2 = mCurrentPuzzle.substring(6,12) + mSpace;
                    String r3 = mCurrentPuzzle.substring(12,18) + mSpace;
                    String r4 = mCurrentPuzzle.substring(18,24) + mSpace;
                    String r5 = mCurrentPuzzle.substring(24,30) + mSpace;
                    String r6 = mCurrentPuzzle.substring(30) + mSpace;
                    mr1.setText(r1);
                    mr2.setText(r2);
                    mr3.setText(r3);
                    mr4.setText(r4);
                    mr5.setText(r5);
                    mr6.setText(r6);
                }
            }
        });
        mhomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SolveActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
        mprevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCurrentIndex >= 1)
                     mCurrentIndex --;
                if (mCurrentIndex >= 0){
                    mCurrentPuzzle = mSeq.get(mCurrentIndex);
                    String r1 = mCurrentPuzzle.substring(0,6) + mSpace;
                    String r2 = mCurrentPuzzle.substring(6,12) + mSpace;
                    String r3 = mCurrentPuzzle.substring(12,18) + mSpace;
                    String r4 = mCurrentPuzzle.substring(18,24) + mSpace;
                    String r5 = mCurrentPuzzle.substring(24,30) + mSpace;
                    String r6 = mCurrentPuzzle.substring(30) + mSpace;
                    mr1.setText(r1);
                    mr2.setText(r2);
                    mr3.setText(r3);
                    mr4.setText(r4);
                    mr5.setText(r5);
                    mr6.setText(r6);
                }
            }
        });
    }
}
