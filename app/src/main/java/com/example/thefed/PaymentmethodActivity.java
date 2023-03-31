package com.example.thefed;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.braintreepayments.cardform.view.CardForm;
import com.google.firebase.firestore.FirebaseFirestore;

public class PaymentmethodActivity extends AppCompatActivity {

    CardForm cardForm;
    Button buy;
    AlertDialog.Builder alertBuilder;
    FirebaseFirestore fireBaseMM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paymentmethod);
        fireBaseMM = FirebaseFirestore.getInstance();

         cardForm = findViewById(R.id.card_form);
         buy = findViewById(R.id.btnBuy);

        cardForm.cardRequired(true)
                .expirationRequired(true)
                .cvvRequired(true)
                .postalCodeRequired(true)
                .mobileNumberRequired(true)
                //.amountRequired(true)
                .mobileNumberExplanation("SMS is required on this number")
                .setup(PaymentmethodActivity.this);

        cardForm.getCvvEditText().setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_VARIATION_PASSWORD);

        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // dbPay();
                if (cardForm.isValid()) {

                    alertBuilder = new AlertDialog.Builder(PaymentmethodActivity.this);
                    alertBuilder.setTitle("Confirm before purchase");
                    alertBuilder.setMessage("Card number: " + cardForm.getCardNumber() + "\n" +
                            "Card expiry date: " + cardForm.getExpirationDateEditText().getText().toString() + "\n" +
                            "Card CVV: " + cardForm.getCvv() + "\n" +
                            "Postal code: " + cardForm.getPostalCode() + "\n" +
                            "Phone number: " + cardForm.getMobileNumber()
                            //"Amount: " + cardForm.getAmount()
                            );
                    alertBuilder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            Toast.makeText(PaymentmethodActivity.this, "Thank you for your donation", Toast.LENGTH_LONG).show();


                           /* fireBaseMM.collection("MainRequests")
                                    .document(fireBaseMM.getInstance().getUid())
                                    .set(new PopularModel(donateamount,name,benefitcontact,donors));
                            //PopularModel popularModel=new PopularModel(donateamount,name,benefitname,donors);
                            String id=task.getResult().getUser().getUid();
                            database.getReference().child("users").child(id).setValue(userModel);*/
                        }
                    });
                    alertBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    AlertDialog alertDialog = alertBuilder.create();
                    alertDialog.show();

                }else {
                    Toast.makeText(PaymentmethodActivity.this, "Please complete the form", Toast.LENGTH_LONG).show();


                }
            }
        });
    }

    /*private void dbPay() {
        // Create a new user with a first and last name
        Map<String, Object> user = new HashMap<>();
        user.put("amount", "100");
        user.put("phone", "0791088006");
        user.put("name", "Makokha Derrick");

// Add a new document with a generated ID
        fireBaseMM.collection("users")
                .add(user)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error adding document", e);
                    }
                });*/

    
}