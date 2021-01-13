package com.example.pcbuilder;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.w3c.dom.Text;

public class CreateAccount extends AppCompatActivity {

    private FirebaseAuth mAuth;
    ProgressBar progressBar;
    EditText CreateName, CreateEmail, CreatePassword;
    Button Register;
    CalendarView Birthday;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createaccount);
        mAuth = FirebaseAuth.getInstance();

        progressBar = findViewById(R.id.progressbar);
        CreateName = findViewById(R.id.createname);
        CreateEmail = findViewById(R.id.createemail);
        CreatePassword = findViewById(R.id.createpassword);
        Register = findViewById(R.id.register);
        Birthday = findViewById(R.id.birthday);

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                mAuth.createUserWithEmailAndPassword(CreateEmail.getText().toString(), CreatePassword.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressBar.setVisibility(View.GONE);
                        if(task.isSuccessful()){
                            Toast.makeText(CreateAccount.this,"Account Created", Toast.LENGTH_LONG).show();
                        }else{
                            Toast.makeText(CreateAccount.this,task.getException().getMessage(), Toast.LENGTH_LONG).show();

                        }

                    }
                });
            }
        });

    }
    //Takes you back to the Login page
    public void Alreadyhaveacount(View v){
        startActivity(new Intent(CreateAccount.this, LoginActivity.class));
    }
}
