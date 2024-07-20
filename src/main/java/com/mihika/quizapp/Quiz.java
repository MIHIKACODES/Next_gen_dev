package com.mihika.quizapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;

public class Quiz {
    private List<Question> questions;
    private int score;

    public Quiz() {
        questions = new ArrayList<>();
        score = 0;

        // Sample questions
        questions.add(new Question("What is the capital of France?", new String[]{"Berlin", "Madrid", "Paris", "Rome"}, 2));
        questions.add(new Question("What is 2 + 2?", new String[]{"3", "4", "5", "6"}, 1));
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        Timer timer = new Timer();

        for (Question question : questions) {
            System.out.println(question.getQuestionText());
            String[] options = question.getOptions();
            for (int i = 0; i < options.length; i++) {
                System.out.println((i + 1) + ". " + options[i]);
            }

            TimerTask timerTask = new TimerTask(10000); // 10 seconds for each question
            timer.schedule(timerTask, 10000);

            int answer = -1;
            while (!timerTask.isTimeUp() && answer < 1 || answer > options.length) {
                System.out.print("Your answer (1-" + options.length + "): ");
                if (scanner.hasNextInt()) {
                    answer = scanner.nextInt();
                } else {
                    scanner.next(); // Clear invalid input
                }
            }

            if (answer - 1 == question.getCorrectAnswerIndex()) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect. The correct answer was: " + options[question.getCorrectAnswerIndex()]);
            }
        }

        System.out.println("Quiz over! Your score: " + score + "/" + questions.size());
    }

    public static void main(String[] args) {
        Quiz quiz = new Quiz();
        quiz.start();
    }
}
