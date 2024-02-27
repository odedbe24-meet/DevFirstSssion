package com.example.devfirstsssion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView textView;
    private EditText name, email;
    private Button signin_button, signup_button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.greeting);
        name = findViewById(R.id.Name);
        email = findViewById(R.id.Email);
        signin_button = findViewById(R.id.SignIn_button);
        signin_button.setOnClickListener(this);
        signup_button = findViewById(R.id.SignUp_button);
        signup_button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == signin_button){
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
        }
        else if (v == signup_button){
            Toast toast = Toast.makeText(this,"under construction", Toast.LENGTH_SHORT);
            toast.show();
            Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
            startActivity(intent);
        }


    }



}