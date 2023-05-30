package com.example.englishv2;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.englishv2.ui.theme.QuestionBank;
import com.rey.material.widget.Button;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Tap_pair extends AppCompatActivity {

    private TextView questions;
    private TextView question;

    private AppCompatButton option1, option2, option3, option4;
    private AppCompatButton next;

    private Timer QuezTimer;
    private int seconds = 0;
    private int totalTime=3;
    private  List <QuestionList> questionList;

    private String selectedOption = "";
    private int currectQuestion = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tap_pair);

        final ImageView back = findViewById(R.id.back);
        final TextView topic = findViewById(R.id.topic);
        final TextView timer = findViewById(R.id.timer);

       question = findViewById(R.id.question);
       questions = findViewById(R.id.questions);

        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        option4 = findViewById(R.id.option4);

        next = findViewById(R.id.next);

        final String getSelectedTopic = getIntent().getStringExtra("SelectedTopic");

        topic.setText(getSelectedTopic);

        questionList = QuestionBank.getQuestions(getSelectedTopic);

        startTimer(timer);

        questions.setText((currectQuestion+1)+"/"+questionList.size());
        question.setText(questionList.get(0).getQuestion());
        option1.setText(questionList.get(0).getOption1());
        option2.setText(questionList.get(0).getOption2());
        option3.setText(questionList.get(0).getOption3());
        option4.setText(questionList.get(0).getOption4());

        back.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent backIntent = new Intent(Tap_pair.this, Home.class);
                startActivity(backIntent);
            }
        });
        option1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (selectedOption.isEmpty())
                {
                    selectedOption = option1.getText().toString();
                    option1.setBackgroundResource(R.drawable.incorrect);
                    option1.setTextColor(Color.WHITE);

                    corAnswer();
                    questionList.get(currectQuestion).setUserSelectedAnswer(selectedOption);
                }
            }
        });
        option2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (selectedOption.isEmpty())
                {
                    selectedOption = option2.getText().toString();
                    option2.setBackgroundResource(R.drawable.incorrect);
                    option2.setTextColor(Color.WHITE);

                    corAnswer();
                    questionList.get(currectQuestion).setUserSelectedAnswer(selectedOption);
                }
            }
        });
        option3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (selectedOption.isEmpty())
                {
                    selectedOption = option3.getText().toString();
                    option3.setBackgroundResource(R.drawable.incorrect);
                    option3.setTextColor(Color.WHITE);

                    corAnswer();
                    questionList.get(currectQuestion).setUserSelectedAnswer(selectedOption);
                }
            }
        });
        option4.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (selectedOption.isEmpty())
                {
                    selectedOption = option4.getText().toString();
                    option4.setBackgroundResource(R.drawable.incorrect);
                    option4.setTextColor(Color.WHITE);

                    corAnswer();
                    questionList.get(currectQuestion).setUserSelectedAnswer(selectedOption);
                }
            }
        });
        next.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (selectedOption.isEmpty())
                {
                    Toast.makeText(Tap_pair.this, "Сделайте,выбор" , Toast.LENGTH_SHORT).show();
                }
                else
                {
                    changeQuestion();
                }

            }
        });

    }

    private void startTimer (TextView timers)
    {
        QuezTimer = new Timer();
        QuezTimer.scheduleAtFixedRate(new TimerTask()
        {
            @Override
            public void run()
            {
                if (seconds == 0)
                {
                    totalTime--;
                    seconds=59;
                } else if (seconds == 0 && totalTime == 0)
                {
                    QuezTimer.purge();
                    QuezTimer.cancel();

                    Toast.makeText(Tap_pair.this, "Время вышло", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent();
                    intent.putExtra("correct", getCorrectAnswers());
                    intent.putExtra("uncorrect",getunCorrectAnswers());

                    startActivity(intent);
                    finish();
                }
                else
                {
                    seconds --;
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run()
                    {
                        String finalminutes = String.valueOf(totalTime);
                        String finalsecond = String.valueOf(seconds);

                        if (finalminutes.length() == 1)
                        {
                            finalminutes = "0" + finalminutes;
                        }
                        if (finalsecond.length() == 1)
                        {
                            finalsecond = "0" +finalsecond;
                        }
                        timers.setText(finalminutes + ":" + finalsecond);


                    }
                });

            }
        },1000,5000);
    }
    private int getCorrectAnswers ()
    {
        int correctAnswers = 0;

        for(int i=0; i < questionList.size(); i++)
        {
            final String getUserSelectedAnswer = questionList.get(i).getUserSelectedAnswer();
            final String getAnswer = questionList.get(i).getAnswer();

            if (getUserSelectedAnswer.equals(getAnswer))
            {
                correctAnswers++;
            }
        }
        return correctAnswers;
    }

    private int getunCorrectAnswers ()
    {
        int correctAnswers = 0;

        for(int i=0; i < questionList.size(); i++)
        {
            final String getUserSelectedAnswer = questionList.get(i).getUserSelectedAnswer();
            final String getAnswer = questionList.get(i).getAnswer();

            if (!getUserSelectedAnswer.equals(getAnswer))
            {
                correctAnswers++;
            }
        }
        return correctAnswers;
    }

    @Override
    public void onBackPressed()
    {
        QuezTimer.purge();
        QuezTimer.cancel();

        startActivity(new Intent(Tap_pair.this, Home.class));
        finish();
    }

    private void corAnswer ()
    {
        final String getAnswer = questionList.get(currectQuestion).getAnswer();

        if (option1.getText().toString().equals(getAnswer))
        {
            option1.setBackgroundResource(R.drawable.correct);
            option1.setTextColor(Color.WHITE);
        }
        else if (option2.getText().toString().equals(getAnswer))
        {
            option2.setBackgroundResource(R.drawable.correct);
            option2.setTextColor(Color.WHITE);
        }
        else if (option3.getText().toString().equals(getAnswer))
        {
            option3.setBackgroundResource(R.drawable.correct);
            option3.setTextColor(Color.WHITE);
        }
        else if (option4.getText().toString().equals(getAnswer))
        {
            option4.setBackgroundResource(R.drawable.correct);
            option4.setTextColor(Color.WHITE);
        }
    }

    private  void changeQuestion ()
    {
        currectQuestion++;

        if ((currectQuestion+1)== questionList.size())
        {
            next.setText("Готово");
        }
        if (currectQuestion < questionList.size())
        {
            selectedOption = "";
            option1.setBackgroundResource(R.drawable.bg_vibor);
            option1.setTextColor(Color.parseColor("#1F6BB8"));

            selectedOption = "";
            option2.setBackgroundResource(R.drawable.bg_vibor);
            option2.setTextColor(Color.parseColor("#1F6BB8"));

            selectedOption = "";
            option3.setBackgroundResource(R.drawable.bg_vibor);
            option3.setTextColor(Color.parseColor("#1F6BB8"));

            selectedOption = "";
            option4.setBackgroundResource(R.drawable.bg_vibor);
            option4.setTextColor(Color.parseColor("#1F6BB8"));

            questions.setText((currectQuestion+1)+"/"+questionList.size());
            question.setText(questionList.get(currectQuestion).getQuestion());
            option1.setText(questionList.get(currectQuestion).getOption1());
            option2.setText(questionList.get(currectQuestion).getOption2());
            option3.setText(questionList.get(currectQuestion).getOption3());
            option4.setText(questionList.get(currectQuestion).getOption4());

        }
        else
        {
            Intent intent = new Intent(Tap_pair.this, Result.class);
            intent.putExtra("Correct",getCorrectAnswers() );
            intent.putExtra("Incorrect",getunCorrectAnswers() );

            startActivity(intent);
            finish();
        }
    }
}