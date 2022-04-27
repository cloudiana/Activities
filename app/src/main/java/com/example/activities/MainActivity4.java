package com.example.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity4 extends AppCompatActivity {
    //Initialize button
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main4);

        //Adds button command(i.e OnClickListener) to open alert dialog
        button = (Button) findViewById(R.id.loadingbutton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProgressDialog progression = new ProgressDialog(MainActivity4.this);
                progression.setTitle("Loading...");
                progression.setMessage("Waitttt!!!");
                progression.show();

                //Runs the progress dialog
                Runnable progressDuration = new Runnable() {
                    @Override
                    public void run() {
                        progression.cancel();
                    }
                };
                //Duration handler for the progress dialog
                Handler handler = new Handler();
                handler.postDelayed(progressDuration,10000);
                openRickAstley();
            }
        });
    }
    //Method for using intent to redirect to the next activity
    public void openRickAstley(){
        Intent intent = new Intent(this, MainActivity5.class);
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