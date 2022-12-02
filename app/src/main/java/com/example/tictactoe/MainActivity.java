package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton btnImages [][] = new ImageButton[3][3];
//        img00.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//               v.setBackgroundResource(R.drawable.x);
//
//            }
//        });

        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                String btnImgId = "img" +i + j;
                int resID = getResources().getIdentifier(btnImgId, "id", getPackageName());
                btnImages[i][j] = findViewById(resID);
                btnImages[i][j].setOnClickListener((View.OnClickListener) this);
            }
        }
    }

    @Override
    public void onClick(View view) {

    }
}