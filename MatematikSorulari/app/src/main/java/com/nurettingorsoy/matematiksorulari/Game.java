package com.nurettingorsoy.matematiksorulari;

import com.nurettingorsoy.matematiksorulari.Model.Question;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<Question> questions; //sorular
    private int numberCorrect; //doğru numara
    private int numberIcorrect; //yanlış numaara
    private int totalQuestions; //toplam soru
    private int score;
    private Question currentQuestion; //güncel soru

    public Game(){
        numberCorrect = 0;
        numberIcorrect = 0;
        totalQuestions = 0;
        score = 0;
        currentQuestion = new Question(10);
        questions = new ArrayList<Question>();
    }

    public void makeNewQuestion(){

        currentQuestion = new Question(totalQuestions*2 + 5);//güncel soru
        totalQuestions++;
        questions.add(currentQuestion);
    }

    public boolean checkAnswer(int submittedAnswer){
        boolean isCorrect;
        if(currentQuestion.getAnswer() == submittedAnswer){
            numberCorrect++;
            isCorrect = true;
        }
        else{
            numberIcorrect++;
            isCorrect = false;
        }
        score = numberCorrect * 10 - numberIcorrect * 30;
        return isCorrect;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public int getNumberCorrect() {
        return numberCorrect;
    }

    public void setNumberCorrect(int numberCorrect) {
        this.numberCorrect = numberCorrect;
    }

    public int getNumberIcorrect() {
        return numberIcorrect;
    }

    public void setNumberIcorrect(int numberIcorrect) {
        this.numberIcorrect = numberIcorrect;
    }

    public int getTotalQuestions() {
        return totalQuestions;
    }

    public void setTotalQuestions(int totalQuestions) {
        this.totalQuestions = totalQuestions;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Question getCurrentQuestion() {
        return currentQuestion;
    }

    public void setCurrentQuestion(Question currentQuestion) {
        this.currentQuestion = currentQuestion;
    }
}
