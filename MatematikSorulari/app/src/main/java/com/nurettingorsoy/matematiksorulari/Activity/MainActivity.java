package com.nurettingorsoy.matematiksorulari.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.nurettingorsoy.matematiksorulari.Game;
import com.nurettingorsoy.matematiksorulari.R;

public class MainActivity extends AppCompatActivity {

    Button btn_start,btn_answer0,btn_answer1,btn_answer2,btn_answer3;
    TextView tv_score,tv_bottommessage,tv_questions,tv_timer;
    ProgressBar prog_timer;

    Game g = new Game();

    int secondsRemaining = 30;

    CountDownTimer timer = new CountDownTimer(30000,1000) {
        @Override
        public void onTick(long millisUntilFinished) {
        secondsRemaining--;
        tv_timer.setText(Integer.toString(secondsRemaining) +" saniye ");
        prog_timer.setProgress(30 - secondsRemaining);
        }

        @Override
        public void onFinish() {
            btn_answer0.setEnabled(false);
            btn_answer1.setEnabled(false);
            btn_answer2.setEnabled(false);
            btn_answer3.setEnabled(false);
            tv_bottommessage.setText("Süre bitti!" + g.getNumberCorrect()+"/"+(g.getTotalQuestions()-1));

            final Handler handler = new Handler();
            
            handler.postDelayed(new Runnable(){
                @Override
                public void run(){
                    btn_start.setVisibility(View.VISIBLE);
                }
            },4000);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_start = findViewById(R.id.btn_start);
        btn_answer0 = findViewById(R.id.btn_answer0);
        btn_answer1 = findViewById(R.id.btn_answer1);
        btn_answer2 = findViewById(R.id.btn_answer2);
        btn_answer3 = findViewById(R.id.btn_answer3);

        tv_score = findViewById(R.id.tv_score);
        tv_bottommessage = findViewById(R.id.tv_bottommessage);
        tv_questions = findViewById(R.id.tv_questions);
        tv_timer = findViewById(R.id.tv_timer);

        prog_timer = findViewById(R.id.prog_timer);

        tv_timer.setText("0 Saniye");
        tv_questions.setText("");
        tv_bottommessage.setText("Press Go");
        tv_score.setText("0 Puan");


       View.OnClickListener startButtonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button start_button =(Button) v;

                start_button.setVisibility(View.INVISIBLE);
                secondsRemaining = 30;
                g = new Game();
                nextTurn();
                timer.start();
            }
        };
        View.OnClickListener answerButtonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button buttonClicked =(Button) v;

               int answerSelected = Integer.parseInt(buttonClicked.getText().toString());
               //Toast.makeText(MainActivity.this,"AnswerSelecte= "+ answerSelected,Toast.LENGTH_SHORT).show();


                g.checkAnswer(answerSelected);
                tv_score.setText(Integer.toString(g.getScore()));
                nextTurn();
            }
        };

        btn_start.setOnClickListener(startButtonClickListener);

        btn_answer0.setOnClickListener(answerButtonClickListener);
        btn_answer1.setOnClickListener(answerButtonClickListener);
        btn_answer2.setOnClickListener(answerButtonClickListener);
        btn_answer3.setOnClickListener(answerButtonClickListener);

    }
    private void nextTurn(){

        g.makeNewQuestion();
        int [] answer =  g.getCurrentQuestion().getAnswerArray();

        btn_answer0.setText(Integer.toString(answer[0]));
        btn_answer1.setText(Integer.toString(answer[1]));
        btn_answer2.setText(Integer.toString(answer[2]));
        btn_answer3.setText(Integer.toString(answer[3]));

        btn_answer0.setEnabled(true);
        btn_answer1.setEnabled(true);
        btn_answer2.setEnabled(true);
        btn_answer3.setEnabled(true);

        tv_questions.setText(g.getCurrentQuestion().getQuestionPhrase());

        tv_bottommessage.setText(g.getNumberCorrect() + "/"+ (g.getTotalQuestions() -1));
    }
}