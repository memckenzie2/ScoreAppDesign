package com.example.android.scoreappdesign;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    /**
     * Create global variables for each teams score and team name
     * NOTE: Long term I want to allow for dynamic names which is why I kepy team names in variables rather than just calling something from string.xml
     */
    int scoreTeamA;
    int scoreTeamB;
    String nameB;
    String nameA;


    /**
     * Initializes variables for the app.
     * Scores start at 0 for both teams.
     * The team names are pulled from the strings.xml file
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        scoreTeamA = 0;
        scoreTeamB = 0;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameB = getString(R.string.player_b);
        nameA = getString(R.string.player_a);
    }

    /**
     * Saves the scores for each team in case of change to the state such as changing screen orientation
     */
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // call superclass to save any view hierarchy
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("scoreA", scoreTeamA);
        savedInstanceState.putInt("scoreB", scoreTeamB);
    }

    /**
     * Restores the scores for each team in case of change to the state such as changing screen orientation
     */
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        // Restore UI state from the savedInstanceState.
        // This bundle has also been passed to onCreate.
        int teamA = savedInstanceState.getInt("scoreA");
        int teamB = savedInstanceState.getInt("scoreB");
        scoreTeamA = teamA;
        scoreTeamB = teamB;
        displayTeamA(scoreTeamA);
        displayTeamB(scoreTeamB);
    }

    /**
     * Resets game so that all scores are 0 and message box displays generic good luck message
     */
    public void resetGame(View v){
        scoreTeamA = 0;
        scoreTeamB = 0;
        displayTeamA(scoreTeamA);
        displayTeamB(scoreTeamB);
        displayMsg(getString(R.string.good_luck));
    }

    /**
     * Updates the score for team A and displays a message to user to indicate what happened on button press
     * Currently uses a switch statement to determine the number of points scored based on the id of the button that called the method
     */
    public void scoreTeamA(View v){

        switch (v.getId()) {
            case R.id.humbleA: scoreTeamA = scoreTeamA + 6;
                displayMsg(nameA + getString(R.string.six_point));
                displayTeamA(scoreTeamA);
                break;
            case R.id.defeat1A: scoreTeamA = scoreTeamA + 1;
                displayMsg(nameA + getString(R.string.one_point));
                displayTeamA(scoreTeamA);
                break;
            case R.id.defeat2A: scoreTeamA = scoreTeamA + 2;
                displayMsg(nameA + getString(R.string.two_point));
                displayTeamA(scoreTeamA);
                break;
            case R.id.defeat3A: scoreTeamA = scoreTeamA + 3;
                displayMsg(nameA + getString(R.string.three_point));
                displayTeamA(scoreTeamA);
                break;
            case R.id.victoryA: scoreTeamA = scoreTeamA + 6;
                displayMsg(getString(R.string.victory_point_a) + nameA +getString(R.string.victory_point_b));
                displayTeamA(scoreTeamA);
                break;
            case R.id.greedyA: displayMsg(getString(R.string.greedy_point_a)+ nameA + getString(R.string.greedy_point_b));
                displayTeamA(scoreTeamA);
                break;
        }
    }

    /**
     * Updates the score for team B and displays a message to user to indicate what happened on button press
     * Currently uses a switch statement to determine the number of points scored based on the id of the button that called the method
     */
    public void scoreTeamB(View v){
                switch (v.getId()) {
            case R.id.humbleB: scoreTeamB = scoreTeamB + 6;
                displayMsg(nameB + getString(R.string.six_point));
                displayTeamB(scoreTeamB);
                break;
            case R.id.defeat1B: scoreTeamB = scoreTeamB + 1;
                displayMsg(nameB + getString(R.string.one_point));
                displayTeamB(scoreTeamB);
                break;
            case R.id.defeat2B: scoreTeamB = scoreTeamB + 2;
                displayMsg(nameB + getString(R.string.two_point));
                displayTeamB(scoreTeamB);
                break;
            case R.id.defeat3B: scoreTeamB = scoreTeamB + 3;
                displayMsg(nameB + getString(R.string.three_point));
                displayTeamB(scoreTeamB);
                break;
            case R.id.victoryB: scoreTeamB = scoreTeamB + 6;
                displayMsg(getString(R.string.victory_point_a) + nameB +getString(R.string.victory_point_b));
                displayTeamB(scoreTeamB);
                break;
            case R.id.greedyB:
                displayMsg(getString(R.string.greedy_point_a)+ nameB +getString(R.string.greedy_point_b));
                displayTeamB(scoreTeamB);
                break;
        }
    }

    /**
     * Updates the score TextView for team A with given value
     * @param amount is the current score
     */
    public void displayTeamA(int amount){
        TextView scoreView = findViewById(R.id.player_a_score);
        scoreView.setText(String.valueOf(amount));
        scoreView.setContentDescription(getString(R.string.score_announce_a) + String.valueOf(amount));
    }

    /**
     * Updates the score TextView for team B with given value
     * @param amount is the current score
     */
    public void displayTeamB(int amount){
        TextView scoreView = findViewById(R.id.player_b_score);
        scoreView.setText(String.valueOf(amount));
        scoreView.setContentDescription(getString(R.string.score_announce_b) + String.valueOf(amount));
    }

    /**
     * Updates the message TextView with information about scoring based on last button press or generic message for change of state
     * @param mssg is a string with the current message
     */
    public void displayMsg(String mssg){
        TextView msgView = findViewById(R.id.mssg);
        msgView.setText(String.valueOf(mssg));
        msgView.setContentDescription(getString(R.string.mssg_display) + String.valueOf(mssg));
    }
}
