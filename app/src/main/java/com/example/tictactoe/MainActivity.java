package com.example.tictactoe;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    char move = 'o';
    char[] chanceRem = {'n', 'n', 'n', 'n', 'n', 'n', 'n', 'n', 'n'};
    int[][] winningPattern = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};
    boolean gameRun = true;
    String msg = "Draw!";


    public void place(View view) {

        ImageView block = (ImageView) view;

        int tag = Integer.parseInt(view.getTag().toString());
        if (chanceRem[tag] == 'n' && gameRun == true) {

            block.setTranslationY(-1000f);
            if (move == 'x') {
                block.setImageResource(R.drawable.o);
                move = 'o';
                chanceRem[tag] = 'o';
            } else {
                block.setImageResource(R.drawable.x);
                move = 'x';
                chanceRem[tag] = 'x';
            }

            block.animate().translationYBy(1000f).setDuration(200);

            for (int[] win : winningPattern) {
                if (chanceRem[win[0]] == chanceRem[win[1]] && chanceRem[win[1]] == chanceRem[win[2]] && chanceRem[win[0]] == chanceRem[win[2]] && chanceRem[win[0]] != 'n') {
                    gameRun = false;
                    if (chanceRem[win[0]] == 'x') {
                        msg = "X Has Won!";
                    } else if (chanceRem[win[0]] == 'o') {
                        msg = "O Has Won!";
                    }
                }
            }

        }
        int count = 0;
        for (int i : chanceRem) {
            if (i == 'n') {
                count++;
                break;
            }
        }
        if (count == 0) {
            msg = "Draw!";
            gameRun = false;
        }


        if (gameRun == false) {
            ConstraintLayout dialogue = findViewById(R.id.dialog);
            TextView message = findViewById(R.id.msg);
            message.setText(msg);
            dialogue.setVisibility(View.VISIBLE);
        }

    }

    public void playAgain(View view) {

        move = 'o';
        for (int k = 0; k < chanceRem.length; k++) {
            chanceRem[k] = 'n';
        }
        gameRun = true;
        ConstraintLayout dialogue = findViewById(R.id.dialog);
        dialogue.setVisibility(View.INVISIBLE);
        ImageView image1 = findViewById(R.id.imageView1);
        ImageView image2 = findViewById(R.id.imageView2);
        ImageView image3 = findViewById(R.id.imageView3);
        ImageView image4 = findViewById(R.id.imageView4);
        ImageView image5 = findViewById(R.id.imageview5);
        ImageView image6 = findViewById(R.id.imageView6);
        ImageView image7 = findViewById(R.id.imageView7);
        ImageView image8 = findViewById(R.id.imageView8);
        ImageView image9 = findViewById(R.id.imageView9);

        image1.setImageResource(0);
        image2.setImageResource(0);
        image3.setImageResource(0);
        image4.setImageResource(0);
        image5.setImageResource(0);
        image6.setImageResource(0);
        image7.setImageResource(0);
        image8.setImageResource(0);
        image9.setImageResource(0);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
