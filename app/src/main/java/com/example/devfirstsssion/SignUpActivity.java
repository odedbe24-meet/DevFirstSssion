package com.example.devfirstsssion;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    private Button submit;
    private EditText email, password, name;
    private FirebaseAuth mAuth;

    private FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        email = findViewById(R.id.signupEmail);
        password = findViewById(R.id.signupPassword);
        name = findViewById(R.id.signupName);
        submit = findViewById(R.id.submit);
        submit.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if (v == submit) {
            create_user(email.getText().toString(), password.getText().toString());
        }

    }

    public void create_user(String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            DatabaseReference ref =database.getReference("Users");
                            ref.push().setValue("Hello, world");
                            database.getReference("Users").child(mAuth.getUid()).push().setValue(new User(name.getText().toString(),email,password));
                            Intent i = new Intent(SignUpActivity.this, HomeActivity.class);
                            startActivity(i);

                        } else {
                            Toast.makeText(SignUpActivity.this, "Auth Failed", Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
}
