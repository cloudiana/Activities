package com.example.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity3 extends AppCompatActivity {
    //Initialize button
    Button button3, button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main3);

        //Adds button command(i.e OnClickListener) to open alert dialog
        button3 = (Button) findViewById(R.id.dialogbutton);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity3.this);
                builder.setTitle("Stars in the skies")
                        .setMessage("Isn't it beautiful?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });

                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });
        //Adds button command(i.e OnClickListener) to redirect to the progress dialog activity
        button4 = (Button) findViewById(R.id.loadingbutton);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLoadingact();
            }
        });

    }
    //Method for using intent to redirect to the next activity
    public void openLoadingact(){
        Intent intent = new Intent(this, MainActivity4.class);
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