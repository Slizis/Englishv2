package com.example.englishv2;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.englishv2.Prevalent.Prevalent;
import com.example.englishv2.model.Users;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import io.paperdb.Paper;

public class Main extends AppCompatActivity {

    private Button registrationButton, loginButton;
    private ProgressDialog loadingBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        registrationButton = (Button) findViewById(R.id.registrationButton);
        loginButton = (Button) findViewById(R.id.loginButton);
        loadingBar = new ProgressDialog(this);

        Paper.init(this);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginIntent = new Intent(Main.this , Sign_in.class);
                startActivity(loginIntent);

            }
        });
        registrationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent RegisterIntent = new Intent(Main.this, Register.class);
                startActivity(RegisterIntent);
            }
        });

    }

    private void ValidateUser(String phone, String password)
    {
        final DatabaseReference RootRef;
        RootRef = FirebaseDatabase.getInstance().getReference();

        RootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.child("Users").child(phone).exists())
                {
                    Users usersData = dataSnapshot.child("Users").child(phone).getValue(Users.class);

                    if(usersData.getPhone().equals(phone))
                    {
                        if(usersData.getPassword().equals(password)) {
                            loadingBar.dismiss();
                            Toast.makeText(Main.this, "Успешный вход", Toast.LENGTH_SHORT).show();

                            Intent homeIntent = new Intent(Main.this, Home.class);
                            startActivity(homeIntent);
                        }
                    }
                    else {
                        loadingBar.dismiss();
                    }
                }
                else{
                    loadingBar.dismiss();
                    Toast.makeText(Main.this, "Аккаунта не существует", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}