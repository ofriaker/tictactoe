package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    boolean Xturn = true;
    int turnCount = 0;
    ImageButton btnImages [][] = new ImageButton[3][3];
    ImageView xPlay;
    ImageView oPlay;
    ImageView xWin;
    ImageView oWin;
    Button playAgain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        xPlay = findViewById(R.id.xPlay);
        oPlay = findViewById(R.id.oPlay);
        oPlay.setVisibility(View.INVISIBLE);
        xWin = findViewById(R.id.xWin);
        oWin = findViewById(R.id.oWin);
        playAgain = findViewById(R.id.reset_board_btn);

        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                String btnImgId = "img" +i + j;
                int resID = this.getResources().getIdentifier(btnImgId, "id", this.getPackageName());
                ImageButton btn = findViewById(resID);
                btn.setOnClickListener(this);
                btnImages[i][j] = btn;
                btnImages[i][j].setContentDescription("");
            }
        }
    }

    @Override
    public void onClick(View view) {
        if (Xturn) {
            view.setBackgroundResource(R.drawable.x);
            view.setContentDescription("X");
            xPlay.setVisibility(View.INVISIBLE);
            oPlay.setVisibility(View.VISIBLE);
        }
        else {
            view.setBackgroundResource(R.drawable.o);
            view.setContentDescription("O");
            xPlay.setVisibility(View.VISIBLE);
            oPlay.setVisibility(View.INVISIBLE);
        }
        turnCount++;

        if(checkForWin()) {
            if(Xturn) {
                Xwin();
            } else {
                Owin();
            }
        } else if(turnCount ==9) {
            draw();
        } else {
            Xturn = !Xturn;
        }
    }

    private boolean checkForWin() {
        for(int i=0; i<3; i++) {
            if(btnImages[i][0].getContentDescription().equals(btnImages[i][1].getContentDescription()) &&
                    btnImages[i][0].getContentDescription().equals(btnImages[i][2].getContentDescription()) &&
                   !btnImages[i][0].getContentDescription().equals("")) {
                return true;
            }
        }

        for(int i=0; i<3; i++) {
            if(btnImages[0][i].getContentDescription().equals(btnImages[1][i].getContentDescription()) &&
                    btnImages[0][i].getContentDescription().equals(btnImages[2][i].getContentDescription()) &&
                    !btnImages[0][i].getContentDescription().equals("")) {
                return true;
            }
        }

        if(btnImages[0][0].getContentDescription().equals(btnImages[1][1].getContentDescription()) &&
                btnImages[0][0].getContentDescription().equals(btnImages[2][2].getContentDescription()) &&
                !btnImages[0][0].getContentDescription().equals("")) {
            return true;
        }

        if(btnImages[0][2].getContentDescription().equals(btnImages[1][1].getContentDescription()) &&
                btnImages[0][2].getContentDescription().equals(btnImages[2][0].getContentDescription()) &&
                !btnImages[0][2].getContentDescription().equals("")) {
            return true;
        }

        return false;
    }

    private void Xwin() {
        xWin.setVisibility(View.VISIBLE);
        playAgain.setVisibility(View.VISIBLE);
        playAgain.setOnClickListener(view -> resetBoard());
    }

    private void Owin() {
        oWin.setVisibility(View.VISIBLE);
        playAgain.setVisibility(View.VISIBLE);
        playAgain.setOnClickListener(view -> resetBoard());
    }

    private void draw() {

    }

    private void resetBoard() {
        for(int i = 0; i<3; i++) {
            for(int j=0; j<3; j++) {
                btnImages[i][j].setBackgroundResource(R.drawable.empty);
                btnImages[i][j].setContentDescription("");
            }
        }

        turnCount = 0;
        Xturn = true;
        xWin.setVisibility(View.INVISIBLE);
        oWin.setVisibility(View.INVISIBLE);
        xPlay.setVisibility(View.VISIBLE);
        oPlay.setVisibility(View.INVISIBLE);
        playAgain.setVisibility(View.INVISIBLE);

    }


}