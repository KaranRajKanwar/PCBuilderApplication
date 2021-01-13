package com.example.pcbuilder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    //Allows for Guest login without an account
    public void GuestLogin(View v){
        startActivity(new Intent(LoginActivity.this, HomeScreen.class));
    }

    //Takes you to the registration page
    public void CreateAccount(View v){
        startActivity(new Intent(LoginActivity.this, CreateAccount.class));
    }

}