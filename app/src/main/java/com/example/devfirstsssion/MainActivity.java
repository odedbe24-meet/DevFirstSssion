package com.example.devfirstsssion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView textView;
    private EditText name, email;
    private Button submit_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.greeting);
        name = findViewById(R.id.Name);
        email = findViewById(R.id.Email);
        submit_button = findViewById(R.id.Submit_button);
        submit_button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == submit_button){
           String name1 = name.getText().toString();
            textView.setText(name1);
        }
    }
}