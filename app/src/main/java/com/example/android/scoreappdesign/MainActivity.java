package com.example.android.scoreappdesign;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int scoreTeamA;
    int scoreTeamB;
    String nameB;
    String nameA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scoreTeamA = 0;
        scoreTeamB = 0;
        nameB = "Player B";
        nameA = "Player A";
    }

    public void resetGame(View v){
        scoreTeamA = 0;
        scoreTeamB = 0;
        displayTeamA(scoreTeamA);
        displayTeamB(scoreTeamB);
        displayMsg("Good Luck!");
    }

    public void scoreTeamA(View v){

        displayTeamA(scoreTeamA);

        switch (v.getId()) {
            case R.id.humbleA: scoreTeamA = scoreTeamA + 6;
                displayMsg(nameA + " was Humble! +6 Points");
                displayTeamA(scoreTeamA);
                break;
            case R.id.defeat1A: scoreTeamA = scoreTeamA + 1;
                displayMsg(nameA + " was horribly defeated! +1 Points");
                displayTeamA(scoreTeamA);
                break;
            case R.id.defeat2A: scoreTeamA = scoreTeamA + 2;
                displayMsg(nameA + " a hard defeat! +2 Points");
                displayTeamA(scoreTeamA);
                break;
            case R.id.defeat3A: scoreTeamA = scoreTeamA + 3;
                displayMsg(nameA + " a narrow defeat! +3 Points");
                displayTeamA(scoreTeamA);
                break;
            case R.id.victoryA: scoreTeamA = scoreTeamA + 6;
                displayMsg("Victory for " + nameA +"! +6 Points");
                displayTeamA(scoreTeamA);
                break;
            case R.id.greedyA: displayMsg("Don't be greedy, "+ nameA +"! No Points.");
                displayTeamA(scoreTeamA);
                break;
        }
    }

    public void scoreTeamB(View v){
                switch (v.getId()) {
            case R.id.humbleB: scoreTeamB = scoreTeamB + 6;
                displayMsg(nameB + " was Humble! +6 Points");
                displayTeamB(scoreTeamB);
                break;
            case R.id.defeat1B: scoreTeamB = scoreTeamB + 1;
                displayMsg(nameB + " was defeated! +1 Point");
                displayTeamB(scoreTeamB);
                break;
            case R.id.defeat2B: scoreTeamB = scoreTeamB + 2;
                displayMsg(nameB + " a hard defeat! +2 Points");
                displayTeamB(scoreTeamB);
                break;
            case R.id.defeat3B: scoreTeamB = scoreTeamB + 3;
                displayMsg(nameB + " a narrow defeat! +3 Points");
                displayTeamB(scoreTeamB);
                break;
            case R.id.victoryB: scoreTeamB = scoreTeamB + 6;
                displayMsg("Victory for " + nameB +"! +6 Points");
                displayTeamB(scoreTeamB);
                break;
            case R.id.greedyB: displayMsg("Don't be greedy, "+ nameB +"! No Points.");
                displayTeamB(scoreTeamB);
                break;
        }
    }


    public void displayTeamA(int amount){
        TextView scoreView = (TextView) findViewById(R.id.player_a_score);
        scoreView.setText(String.valueOf(amount));
    }

    public void displayTeamB(int amount){
        TextView scoreView = (TextView) findViewById(R.id.player_b_score);
        scoreView.setText(String.valueOf(amount));
    }

    public void displayMsg(String mssg){
        TextView msgView = (TextView) findViewById(R.id.mssg);
        msgView.setText(String.valueOf(mssg));
    }
}
