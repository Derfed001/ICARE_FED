package com.example.thefed;

       /* back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DonationActivity.this, DonateMeActivity.class));
                finish();
            }
        });*/

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.FirebaseFirestore;

public class DonationActivity extends AppCompatActivity{
    ImageButton back;
    EditText mPhone,mAmount;
    ProgressBar mmEndelea;
    Button mPay;
    FirebaseFirestore dbPayment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation);
        dbPayment=FirebaseFirestore.getInstance();
        back=findViewById(R.id.btnback_from_donate);
        mAmount=findViewById(R.id.etAmount);
        mPhone=findViewById(R.id.etPhone);
        mPay=findViewById(R.id.btnPay);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DonationActivity.this, DonateMeActivity.class));
                finish();
            }
        });

        mPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String amountTxt=mAmount.getText().toString();
                String nambaTxt=mPhone.getText().toString();
                validateinfo( amountTxt,nambaTxt);
            }
        });


    }

    private void validateinfo(String amountTxt, String nambaTxt) {

        if(TextUtils.isEmpty(amountTxt)){
            mAmount.setError("Field cannot be empty");
            mAmount.requestFocus();
        }else if(TextUtils.isEmpty(nambaTxt)) {
            mPhone.setError("Field cannot be empty");
            mPhone.requestFocus();
        }else{
            Toast.makeText(DonationActivity.this,"details updated successfully successfully",Toast.LENGTH_SHORT).show();
            startActivity(new Intent(DonationActivity.this,PaymentmethodActivity.class));
        }
}}

