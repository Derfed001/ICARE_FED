package com.example.thefed;

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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    EditText mail,assword;
    TextView orgot,ignup;
    Button ogin;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mail=findViewById(R.id.email);
        assword=findViewById(R.id.password);
        //orgot=findViewById(R.id.forgot);
        ogin=findViewById(R.id.login);
        ignup=findViewById(R.id.signu);
        mAuth=FirebaseAuth.getInstance();

       /* ogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mailTxt=mail.getText().toString();
                String asswordTxt=assword.getText().toString();

                if(mailTxt.isEmpty()||asswordTxt.isEmpty()){
                    Toast.makeText(LoginActivity.this,"Please fill in the details", Toast.LENGTH_SHORT).show();
                }
                else{

                }
            }
        });*/

        ignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
                finish();
            }
        });
        ogin.setOnClickListener(view ->{
            loginUser();
        });


       /* orgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(LoginActivity.this,ForgotPassActivity.class));
                //finish();

                AlertDialog.Builder builder=new AlertDialog.Builder(LoginActivity.this);
                View dialogView=getLayoutInflater().inflate(R.layout.dialog_forgot,null);
                EditText emailBox=dialogView.findViewById(R.id.emailBox);

                builder.setView(dialogView);
                AlertDialog dialog=builder.create();
                dialogView.findViewById(R.id.btnReset).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String userEmail=emailBox.getText().toString();

                        if(TextUtils.isEmpty(userEmail)&& !Patterns.EMAIL_ADDRESS.matcher(userEmail).matches()){
                            Toast.makeText(LoginActivity.this,"Enter registered email address",Toast.LENGTH_SHORT).show();
                            return;
                        }

                        mAuth.sendPasswordResetEmail(userEmail).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if(task.isSuccessful()){
                                    Toast.makeText(LoginActivity.this,"Check your Email",Toast.LENGTH_SHORT).show();
                                    //startActivity(new Intent(LoginActivity.this,HomeActivity.class));
                                    dialog.dismiss();
                                }
                                else{
                                    Toast.makeText(LoginActivity.this,"Unable to send",Toast.LENGTH_SHORT).show();

                                    //Toast.makeText(LoginActivity.this,"Login error"+task.getException().getMessage(),Toast.LENGTH_SHORT).show();

                                }
                            }
                        });
                        dialogView.findViewById(R.id.btnCancel).setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                dialog.dismiss();
                            }
                        });
                        if(dialog.getWindow()!=null){
                            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
                        }
                        dialog.show();
                    }
                });
            }
        });*/



     /*  ogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String mailTxt=mail.getText().toString();
                String asswordTxt=assword.getText().toString();

                if(mailTxt.isEmpty()||asswordTxt.isEmpty()){
                    Toast.makeText(LoginActivity.this,"Please fill in the details",Toast.LENGTH_SHORT).show();
                }

                else {
                    databaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if (snapshot.hasChild(asswordTxt)) {
                                //Toast.makeText(LoginActivity.this, "Invalid email or password", Toast.LENGTH_SHORT).show();
                                databaseReference.child("users").child(mailTxt).child("ni").setValue(asswordTxt);
                                Toast.makeText(LoginActivity.this, "Login successfully", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(LoginActivity.this,HomeActivity.class));
                                finish();
                            }

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {


                        }
                    });
                    ignup.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
                            finish();
                        }
                    });

        orgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,ForgotPassActivity.class));
                finish();
            }
        });*/

        }

    private void loginUser() {
        String email=mail.getText().toString();
        String password=assword.getText().toString();
        //String confirmpass=vu.getText().toString();

        if(TextUtils.isEmpty(email)){
            mail.setError("Field cannot be empty");
            mail.requestFocus();
        }else if(TextUtils.isEmpty(password)) {
            assword.setError("Field cannot be empty");
            assword.requestFocus();
        }else{
            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(LoginActivity.this,"Login successfully",Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(LoginActivity.this,HomeActivity.class));
                    }else{
                        Toast.makeText(LoginActivity.this,"Login error"+task.getException().getMessage(),Toast.LENGTH_SHORT).show();

                    }

                }
            });
        }


        }


}