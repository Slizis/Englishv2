package com.example.englishv2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        final AppCompatButton startnew = findViewById(R.id.Startnew);
        final TextView correct = findViewById(R.id.correctAnswear);
        final TextView incorrect = findViewById(R.id.incorrectAnswear);

        final int getCorrectAnswers = getIntent().getIntExtra("Correct", 0 );
        final int getunCorrectAnswers = getIntent().getIntExtra("Incorrect", 0 );

        correct.setText(String.valueOf("количество верных ответов -" + getCorrectAnswers));
        incorrect.setText(String.valueOf("количество неверных ответов -" + getunCorrectAnswers));

        startnew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Result.this, Home.class));
                finish();
            }
        });
    }


}