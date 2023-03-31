package com.example.thefed;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.thefed.models.UserModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {

        EditText maile,kito,vu;
        Button ongeza;
       // ImageView rudi;
        TextView jinanmimi,log;
        FirebaseAuth mAuth;
        FirebaseDatabase database;

        @SuppressLint("MissingInflatedId")
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_register);

            maile = findViewById(R.id.admin_email);
            kito = findViewById(R.id.admin_pass);
            vu = findViewById(R.id.confirm_pass);
            ongeza = findViewById(R.id.add_admin);
            jinanmimi=findViewById(R.id.textView50);
            log = findViewById(R.id.mmww);
            mAuth=FirebaseAuth.getInstance();
            database=FirebaseDatabase.getInstance();
           // DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReferenceFromUrl("https://decorummerlia-10d80-default-rtdb.firebaseio.com/");



           log.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                    finish();
                }
            });
            jinanmimi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(RegisterActivity.this, Termsandconditions.class));
                    finish();
                }
            });

           /* rudi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                    finish();
                }
            });*/

           ongeza.setOnClickListener(view ->{
                createUser();


            }  );

        }

        private void createUser() {

            String email=maile.getText().toString();
            String password=kito.getText().toString();
            String confirmpass=vu.getText().toString();


            if(TextUtils.isEmpty(email)){
                maile.setError("Field cannot be empty");
                maile.requestFocus();
            }else if(TextUtils.isEmpty(password)) {
                kito.setError("Field cannot be empty");
                kito.requestFocus();
            }else if(TextUtils.isEmpty(confirmpass)) {
                vu.setError("Field cannot be empty");
                vu.requestFocus();
            } else{
                mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful()){
                            UserModel userModel=new UserModel(email,password);
                            String id=task.getResult().getUser().getUid();
                            database.getReference().child("users").child(id).setValue(userModel);
                            Toast.makeText(RegisterActivity.this,"User registered successfully",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
                        }else{
                            Toast.makeText(RegisterActivity.this,"Registration error"+task.getException().getMessage(),Toast.LENGTH_SHORT).show();

                        }
                    }
                });
            }
        }}

