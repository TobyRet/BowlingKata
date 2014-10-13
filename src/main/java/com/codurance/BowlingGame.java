package com.codurance;

public class BowlingGame {

    private int rolls[] = new int[21];
    private int currentRoll = 0;


    public void roll(int pins) {
        rolls[currentRoll++] = pins;
    }

    public int score() {
        int score = 0;
        int firstInFrame=0;
        for(int frame = 0; frame<10; frame++) {
            if(rolls[firstInFrame]==10) {
                score += 10 + nextTwoBallsForStrike(firstInFrame);
                firstInFrame++;
            }
            else if(isSpare(firstInFrame)) {
                score +=10 + nextBallForSpare(firstInFrame);
                firstInFrame+=2;
            } else {
                score += twoBallsInFrame(firstInFrame);
                firstInFrame+=2;
            }
        }
        return score;
    }

    private int twoBallsInFrame(int firstInFrame) {
        return rolls[firstInFrame] + rolls[firstInFrame+1];
    }

    private int nextBallForSpare(int firstInFrame) {
        return rolls[firstInFrame + 2];
    }

    private int nextTwoBallsForStrike(int firstInFrame) {
        return rolls[firstInFrame + 1] + nextBallForSpare(firstInFrame);
    }

    private boolean isSpare(int firstInFrame) {
        return twoBallsInFrame(firstInFrame) == 10;
    }
}
