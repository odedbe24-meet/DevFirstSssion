package com.example.devfirstsssion;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<User> usersArrayList = new ArrayList<User>();

    ArrayAdapter<User> arrayAdapter;

    FirebaseDatabase database;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        database = FirebaseDatabase.getInstance();
//        usersArrayList.add(new User("oded","odedb0105@gmail.com","dedo"));
//        usersArrayList.add(new User("Test_User","test@gmail.com","das"));


        listView = findViewById(R.id.user_list);

        arrayAdapter = new UserArrayAdapter(this, R.layout.custom_row,usersArrayList);
        listView.setAdapter(arrayAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options, menu);
        return true;
    }


    @Override
   public  boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
       if(id == R.id.signout){
           Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        return true;
    }
}