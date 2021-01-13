package com.example.pcbuilder;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText email,password;
    Button eye;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email = findViewById(R.id.Email);
        //eye = findViewById(R.id.ShowPass);


        }


    //Allows for Guest login without an account
    public void GuestLogin(View v){
        startActivity(new Intent(LoginActivity.this, HomeScreen.class));
    }

    //Takes you to the registration page
    public void CreateAccount(View v){
        startActivity(new Intent(LoginActivity.this, CreateAccount.class));
    }

    //Takes you to the forgot password page
    public void ForgotPassword(View v){
        startActivity(new Intent(LoginActivity.this, ForgotPassword.class));
    }
}