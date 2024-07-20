package com.mihika.quizapp;

import java.util.TimerTask;

public class TimerTask extends TimerTask {
    private long startTime;
    private long timeLimit; // in milliseconds

    public TimerTask(long timeLimit) {
        this.timeLimit = timeLimit;
        this.startTime = System.currentTimeMillis();
    }

    @Override
    public void run() {
        long elapsedTime = System.currentTimeMillis() - startTime;
        if (elapsedTime >= timeLimit) {
            System.out.println("Time's up!");
            // End the quiz or move to the next question
        }
    }

    public boolean isTimeUp() {
        return System.currentTimeMillis() - startTime >= timeLimit;
    }
}
