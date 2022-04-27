package com.example.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Initialize button
        Button button2;

        super.onCreate(savedInstanceState);

        //This code removes the title of the application
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main2);

        //Adds button command(i.e OnClickListener) to redirect to dialog activity
        button2 = (Button) findViewById(R.id.dialogbutton);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialogact();
            }
        });
    }
    //Method for using intent to redirect to the next activity
    public void openDialogact(){
        Intent intent = new Intent(this, MainActivity3.class);
        startActivity(intent);
        //Next animation
        overridePendingTransition(R.anim.sliderightin, R.anim.slideleftout);

    }
    //Method override for the return button
    @Override
    public void finish() {
        super.finish();
        //Return animation
        overridePendingTransition(R.anim.slideleftin, R.anim.sliderightout);
    }
}