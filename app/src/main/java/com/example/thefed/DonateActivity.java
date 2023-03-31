package com.example.thefed;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class DonateActivity extends AppCompatActivity {
    Button donateBt;
    ImageView view5, view7;
    TextView view27,view42,view40,donat;
    ProgressBar progressBar1;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        view5=findViewById(R.id.imageView5);
        view7=findViewById(R.id.imageView7);
        view27=findViewById(R.id.textView27);
        view42=findViewById(R.id.textView42);
        donat=findViewById(R.id.textViewDonators);
        view40= findViewById(R.id.textView40);
        progressBar1=findViewById(R.id.progressBar);
        donateBt=findViewById(R.id.button_do);

        view27.setText(getIntent().getExtras().getString("numtitle"));
        donat.setText(getIntent().getExtras().getString("numdonators"));
        view42.setText(getIntent().getExtras().getString("numdays"));
        view40.setText(getIntent().getExtras().getString("numdescription"));
        int hunger=getIntent().getIntExtra("hunger",0);
        int pandemic=getIntent().getIntExtra("pandemic",0);
        int education=getIntent().getIntExtra("education",0);
        int health=getIntent().getIntExtra("health",0);
        view5.setImageResource(hunger);
        view5.setImageResource(pandemic);
        view5.setImageResource(education);
        view5.setImageResource(health);

        view7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        donateBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DonateActivity.this, DonationActivity.class));
                finish();
            }
        });


    }
}