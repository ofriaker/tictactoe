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
    ImageView xPlay, oPlay;
    ImageView xWin, oWin;
    ImageView noWin;
    ImageView mark1_l2r, mark2_r2l, mark3_left, mark4_center, mark5_right, mark6_up, mark7_middle, mark8_down;
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
        noWin = findViewById(R.id.noWin);
        mark1_l2r = findViewById(R.id.mark1_l2r);
        mark2_r2l = findViewById(R.id.mark2_r2l);
        mark3_left = findViewById(R.id.mark3_left);
        mark4_center = findViewById(R.id.mark4_center);
        mark5_right = findViewById(R.id.mark5_right);
        mark6_up = findViewById(R.id.mark6_up);
        mark7_middle = findViewById(R.id.mark7_middle);
        mark8_down = findViewById(R.id.mark8_down);
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
            } else if(turnCount == 9) {
                draw();
            } else {
                Xturn = !Xturn;
            }

    }

    private boolean checkForWin() {
        //lines
        for(int i=0; i<3; i++) {
            if(btnImages[i][0].getContentDescription().equals(btnImages[i][1].getContentDescription()) &&
                    btnImages[i][0].getContentDescription().equals(btnImages[i][2].getContentDescription()) &&
                   !btnImages[i][0].getContentDescription().equals("")) {
                if (i==0) {
                    mark6_up.setVisibility(View.VISIBLE);
                } else if (i == 1) { mark7_middle.setVisibility(View.VISIBLE);} else {mark8_down.setVisibility(View.VISIBLE);}
                return true;
            }
        }

        //colomns
        for(int i=0; i<3; i++) {
            if(btnImages[0][i].getContentDescription().equals(btnImages[1][i].getContentDescription()) &&
                    btnImages[0][i].getContentDescription().equals(btnImages[2][i].getContentDescription()) &&
                    !btnImages[0][i].getContentDescription().equals("")) {
                if (i==0) {
                    mark3_left.setVisibility(View.VISIBLE);
                } else if (i == 1) { mark4_center.setVisibility(View.VISIBLE);} else {mark5_right.setVisibility(View.VISIBLE);}
                return true;
            }
        }

        //left to right
        if(btnImages[0][0].getContentDescription().equals(btnImages[1][1].getContentDescription()) &&
                btnImages[0][0].getContentDescription().equals(btnImages[2][2].getContentDescription()) &&
                !btnImages[0][0].getContentDescription().equals("")) {
            mark1_l2r.setVisibility(View.VISIBLE);
            return true;
        }

        //right to left
        if(btnImages[0][2].getContentDescription().equals(btnImages[1][1].getContentDescription()) &&
                btnImages[0][2].getContentDescription().equals(btnImages[2][0].getContentDescription()) &&
                !btnImages[0][2].getContentDescription().equals("")) {
            mark2_r2l.setVisibility(View.VISIBLE);
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
        noWin.setVisibility(View.VISIBLE);
        playAgain.setVisibility(View.VISIBLE);
        playAgain.setOnClickListener(view -> resetBoard());
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
        noWin.setVisibility(View.INVISIBLE);
        mark1_l2r.setVisibility(View.INVISIBLE);
        mark2_r2l.setVisibility(View.INVISIBLE);
        mark3_left.setVisibility(View.INVISIBLE);
        mark4_center.setVisibility(View.INVISIBLE);
        mark5_right.setVisibility(View.INVISIBLE);
        mark6_up.setVisibility(View.INVISIBLE);
        mark7_middle.setVisibility(View.INVISIBLE);
        mark8_down.setVisibility(View.INVISIBLE);
        playAgain.setVisibility(View.INVISIBLE);

    }


}