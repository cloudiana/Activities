package com.example.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    //Initialize button
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Set activity title
        getSupportActionBar().setTitle("Moon, Stars and Sky");

        //Add button command(i.e OnClickListener) to redirect to no title activity
        button = (Button) findViewById(R.id.loadingbutton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openNoTitle();
            }
        });

    }

    //Method for using intent to redirect to the next activity
    public void openNoTitle(){
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
        //Next animation
        overridePendingTransition(R.anim.sliderightin, R.anim.slideleftout);

    }
}