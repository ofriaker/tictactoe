package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    boolean Xturn = true;
    int turnCount = 0;
    boolean isVictory = false;
    ImageButton btnImages [][] = new ImageButton[3][3];
    ImageView xPlay;
    ImageView oPlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        xPlay = findViewById(R.id.xPlay);
        oPlay = findViewById(R.id.oPlay);
        oPlay.setVisibility(View.INVISIBLE);

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
        if(turnCount < 9 && !isVictory) {
            if (Xturn) {
                view.setBackgroundResource(R.drawable.x);
                Xturn = false;
                xPlay.setVisibility(View.INVISIBLE);
                oPlay.setVisibility(View.VISIBLE);
            }
            else {
                view.setBackgroundResource(R.drawable.o);
                Xturn = true;
                xPlay.setVisibility(View.VISIBLE);
                oPlay.setVisibility(View.INVISIBLE);
            }
            turnCount++;
        }
    }

}