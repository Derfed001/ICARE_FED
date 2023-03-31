package com.example.thefed;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class contactActivity extends AppCompatActivity {
    ImageView view6;
    TextView whatsap,emai;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        view6=findViewById(R.id.imageView6);
        whatsap=findViewById(R.id.callWhatsapp);
        emai=findViewById(R.id.callEmai);

        emai.setText(Html.fromHtml("<a href =\"mailto:derfedfederrick@gmail.com\">Email: derfedfederrick@gmail.com</a>"));
        emai.setMovementMethod(LinkMovementMethod.getInstance());

        view6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(contactActivity.this, HomeActivity.class));
                finish();
            }
        });

        whatsap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String wpurl="https://wa.me/+254791088006?text=Hello Admin";
                Intent intent =new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(wpurl));
                startActivity(intent);
            }
        });
    }
}