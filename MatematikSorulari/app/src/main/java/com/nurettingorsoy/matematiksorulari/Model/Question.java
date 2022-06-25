package com.nurettingorsoy.matematiksorulari.Model;

import java.util.Random;

public class Question {

    private int firstNumber;
    private int secondNumber;
    private int answer;

    //Kullanıcının seçim yapabileceği dört olası seçenek.
    private int [] answerArray;

    //Dört konumdan hangisi doğrudur, 0,1 2 veya 3
    private int answerPosition;

    //firstNumber veya secondNumber'ın maximum değeri
    private int upperLimit;//üstsınır

    //Sorunun string çıktısı. e.g. "4+9 = "
    private String questionPhrase; //sorucümlesi


    //Rastgele soru oluştur
    public Question(int upperLimit){
        this.upperLimit = upperLimit;
        Random randomNumberMaker = new Random(); //rastgele sayı oluşturucu

        this.firstNumber = randomNumberMaker.nextInt(upperLimit);
        this.secondNumber = randomNumberMaker.nextInt(upperLimit);
        this.answer = this.firstNumber + this.secondNumber;
        this.questionPhrase = this.firstNumber + " + " + secondNumber + " = ";

        this.answerPosition = randomNumberMaker.nextInt(4);
        this.answerArray = new int[] {0,1,2,3};

        this.answerArray[0] = answer + 1;
        this.answerArray[1] = answer + 10;
        this.answerArray[2] = answer - 5;
        this.answerArray[3] = answer - 2;

        this.answerArray = shuffleArray(this.answerArray);

        answerArray[answerPosition] = answer;
    }
    private int [] shuffleArray(int[] array){ //karışık dizi
        int index, temp;
        Random randomNumberGenerator = new Random(); //rastgele numara üreticisi

        for (int i = array.length-1; i>0; i--){
            index = randomNumberGenerator.nextInt(i+1);
            temp = array[index];
            array[index]  = array[i];
            array[i] = temp;
        }
        return array;
    }



    public int getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(int firstNumber) {
        this.firstNumber = firstNumber;
    }

    public int getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(int secondNumber) {
        this.secondNumber = secondNumber;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public int[] getAnswerArray() {
        return answerArray;
    }

    public void setAnswerArray(int[] answerArray) {
        this.answerArray = answerArray;
    }

    public int getAnswerPosition() {
        return answerPosition;
    }

    public void setAnswerPosition(int answerPosition) {
        this.answerPosition = answerPosition;
    }

    public int getUpperLimit() {
        return upperLimit;
    }

    public void setUpperLimit(int upperLimit) {
        this.upperLimit = upperLimit;
    }

    public String getQuestionPhrase() {
        return questionPhrase;
    }

    public void setQuestionPhrase(String questionPhrase) {
        this.questionPhrase = questionPhrase;
    }
}
