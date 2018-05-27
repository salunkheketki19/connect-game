package com.example.user.conect3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int activePlayer = 0;

    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};

    int[][]  winningPositions = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 4, 8}, {2, 4, 6}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}};

    public void dropIn(View view) {

        ImageView counter = (ImageView) view;

        int tapCounter = Integer.parseInt(counter.getTag().toString());

        if (gameState[tapCounter] == 2) {

            gameState[tapCounter] = activePlayer;

            counter.setTranslationY(-1000f);

            if (activePlayer == 0) {

                counter.setImageResource(R.drawable.cntr32);

                activePlayer = 1;

            } else {

                counter.setImageResource(R.drawable.cont31);

                activePlayer = 0;

            }

            counter.animate().translationYBy(1000f).rotation(360).setDuration(300);

            for (int[] winningPosition : winningPositions) {

                if (gameState[winningPosition[0]] == gameState[winningPosition[1]] &&
                        gameState[winningPosition[1]] == gameState[winningPosition[2]] &&
                        gameState[winningPosition[0]] != 2) {

                    String winner = "Happy";

                    if (gameState[winningPosition[0]] == 0) {

                        winner = "Sad";

                    }
                    TextView winnerMessage = (TextView) findViewById(R.id.winnerMessage);

                    winnerMessage.setText(winner + "  has Won!!");

                    LinearLayout layout = (LinearLayout) findViewById(R.id.playAgainLayout);

                    layout.setVisibility(View.VISIBLE);
                }
            }
        }
    }

    public void playAgain(View view) {

        LinearLayout layout = (LinearLayout) findViewById(R.id.playAgainLayout);

        layout.setVisibility(View.INVISIBLE);

        activePlayer = 0;

        int gameState[] = {2, 2, 2, 2, 2, 2, 2, 2, 2};

        for (int i = 0; i < gameState.length; i++) {

            gameState[i] = 2;
        }

        GridLayout gridlayout =(GridLayout) findViewById(R.id.gridlayout);

        for(int i = 0 ; i < gridlayout.getChildCount() ; i++){

            ((ImageView) gridlayout.getChildAt(i)).setImageResource(0);
        }
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
