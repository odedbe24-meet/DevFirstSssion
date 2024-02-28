package com.example.devfirstsssion;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView textView;
    private EditText password, email;
    private Button signin_button, signup_button;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
        textView = findViewById(R.id.greeting);
        password = findViewById(R.id.Password);
        email = findViewById(R.id.Email);
        signin_button = findViewById(R.id.SignIn_button);
        signin_button.setOnClickListener(this);
        signup_button = findViewById(R.id.SignUp_button);
        signup_button.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v == signin_button){
            SignIn(email.getText().toString(), password.getText().toString());
        }
        else if (v == signup_button){
            Intent intent = new Intent(MainActivity.this, SignUpActivity.class).putExtra("Name", password.getText().toString()).putExtra("Email", email.getText().toString());
            startActivity(intent);
        }


    }


    public  void SignIn(String email, String password){

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Intent i = new Intent(MainActivity.this, HomeActivity.class);
                            startActivity(i);

                        } else {
                            Toast.makeText(MainActivity.this, "Auth Failed", Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }



}