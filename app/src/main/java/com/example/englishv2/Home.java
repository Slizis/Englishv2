package com.example.englishv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import io.paperdb.Paper;

public class Home extends AppCompatActivity {
    private Button logout,start;
    private String selectedTopic = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        logout = (Button)findViewById(R.id.logout);
        final LinearLayout animal = findViewById(R.id.animal);
        final LinearLayout food = findViewById(R.id.food);
        final LinearLayout drink = findViewById(R.id.drink);
        final LinearLayout emotion = findViewById(R.id.emotion);
        final Button start = findViewById(R.id.start);


        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Paper.book().destroy();

                Intent logoutIntent = new Intent(Home.this, Main.class);
                startActivity(logoutIntent);
            }
        });
        animal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedTopic="animal";

                animal.setBackgroundResource(R.drawable.layout_push);

                food.setBackgroundResource(R.drawable.button);

                drink.setBackgroundResource(R.drawable.button);

                emotion.setBackgroundResource(R.drawable.button);


            }
        });

        food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedTopic="food";

                animal.setBackgroundResource(R.drawable.button);

                food.setBackgroundResource(R.drawable.layout_push);

                drink.setBackgroundResource(R.drawable.button);

                emotion.setBackgroundResource(R.drawable.button);

            }
        });

        drink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedTopic="drink";

                animal.setBackgroundResource(R.drawable.button);

                food.setBackgroundResource(R.drawable.button);

                drink.setBackgroundResource(R.drawable.layout_push);

                emotion.setBackgroundResource(R.drawable.button);

            }
        });

        emotion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedTopic="emotion";

                animal.setBackgroundResource(R.drawable.button);

                food.setBackgroundResource(R.drawable.button);

                drink.setBackgroundResource(R.drawable.button);

                emotion.setBackgroundResource(R.drawable.layout_push);

            }
        });

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (selectedTopic.isEmpty()) {
                    Toast.makeText(Home.this , "Выберите тему", Toast.LENGTH_LONG).show();
                }
                else {
                    Intent intent = new Intent(Home.this, Tap_pair.class);
                    intent.putExtra("SelectedTopic", selectedTopic);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

}