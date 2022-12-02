package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    boolean Xturn = true;
    int turnCount = 0;
    boolean isVictory = false;
    ImageButton btnImages [][] = new ImageButton[3][3];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                String btnImgId = "img" +i + j;
                int resID = this.getResources().getIdentifier(btnImgId, "id", this.getPackageName());
                ImageButton btn = findViewById(resID);
                btn.setOnClickListener(this);
                btnImages[i][j] = btn;
            }
        }
    }

    @Override
    public void onClick(View view) {
        view.setVisibility(View.VISIBLE);
        if(turnCount < 9 && !isVictory) {
            if (Xturn) {
                view.setBackgroundResource(R.drawable.x);
                Xturn = false;
            }
            else {
                view.setBackgroundResource(R.drawable.o);
                Xturn = true;
            }
            turnCount++;
        }
    }

}