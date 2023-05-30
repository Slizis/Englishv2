package com.example.englishv2;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.englishv2.databinding.ActivitySignInBinding;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.englishv2.Prevalent.Prevalent;
import com.example.englishv2.model.Users;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rey.material.widget.CheckBox;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

import io.paperdb.Paper;

    public class Sign_in extends AppCompatActivity {

        private Button loginButton;
        private EditText phone_input , password_input;
        private ProgressDialog loadingBar;
        private String parentDBName ="Users";
        private DataSnapshot dataSnapshot;
        private CheckBox checkBoxRememberMe;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_sign_in);

            loginButton = (Button)findViewById(R.id.loginButton);
            phone_input = (EditText)findViewById(R.id.phone_input);
            password_input = (EditText)findViewById(R.id.password_input);
            loadingBar = new ProgressDialog(this);
            checkBoxRememberMe = (CheckBox)findViewById(R.id.login_checkbox);
            Paper.init(this);


            loginButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    loginUser();
                }
            });
        }

        private void loginUser() {
            String phone = phone_input.getText().toString();
            String password = password_input.getText().toString();

            if (TextUtils.isEmpty(phone)) {
                Toast.makeText(this, "Введите phone", Toast.LENGTH_SHORT).show();
            } else if (TextUtils.isEmpty(password)) {
                Toast.makeText(this, "Введите password", Toast.LENGTH_SHORT).show();
            } else {
                loadingBar.setTitle("Вход в приложение");
                loadingBar.setMessage("Пожайлуста,подождите...");
                loadingBar.setCanceledOnTouchOutside(false);
                loadingBar.show();

                ValidateUser(phone, password);
            }
        }

        private void ValidateUser(String phone, String password) {

            if(checkBoxRememberMe.isChecked())
            {
                Paper.book().write(Prevalent.UserPhoneKey, phone);
                Paper.book().write(Prevalent.passwordPhoneKey, password);
            }
            final DatabaseReference RootRef;
            RootRef = FirebaseDatabase.getInstance().getReference();

            RootRef.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if(dataSnapshot.child(parentDBName).child(phone).exists())
                    {
                        Users usersData = dataSnapshot.child(parentDBName).child(phone).getValue(Users.class);

                        if(usersData.getPhone().equals(phone))
                        {
                            if(usersData.getPassword().equals(password)) {
                                loadingBar.dismiss();
                                Toast.makeText(Sign_in.this, "Успешный вход", Toast.LENGTH_SHORT).show();

                                Intent homeIntent = new Intent(Sign_in.this, Home.class);
                                startActivity(homeIntent);
                            }
                        }
                        else {
                            loadingBar.dismiss();
                            Toast.makeText(Sign_in.this, "Неверный пароль", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        loadingBar.dismiss();
                        Toast.makeText(Sign_in.this, "Аккаунта не существует", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }
    }

