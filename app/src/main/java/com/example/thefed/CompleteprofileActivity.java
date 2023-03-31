package com.example.thefed;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.card.MaterialCardView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Member;
import java.util.ArrayList;

public class CompleteprofileActivity extends AppCompatActivity {

    ImageView prof;
    Button submi;
  //  Uri imageUri;
    //ImageButton imageButton;
    EditText aboutme,ni,namba,maileww;
    Spinner gender,locate;
    TextView tvInterests;
    MaterialCardView selectedCard;
    Member member;
    int maxid=0;
    boolean[] selectedInterests;
    ArrayList<Integer>interestList=new ArrayList<>();
    String[]interestArray={"Education","Health","Environment","Hunger"};

    DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReferenceFromUrl("https://decorummerlia-10d80-default-rtdb.firebaseio.com/");


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_completeprofile);

       // gender=findViewById(R.id.spinner5);
       // locate=findViewById(R.id.spinner4);
        submi=findViewById(R.id.button7);
       // selectedCard=findViewById(R.id.selectedCard);
       // aboutme=findViewById(R.id.about_me);
      //  tvInterests=findViewById(R.id.tvInterests);
        ni=findViewById(R.id.username);
         maileww=findViewById(R.id.admin_email2);
        namba=findViewById(R.id.admin_phone);

        selectedInterests=new boolean[interestArray.length];

        selectedCard.setOnClickListener(v -> {
            showInterestsDialog();
        });


      /*  imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
                public void onClick(View v) {openFileChooser();}

                @SuppressWarnings("deprecation")
                private void openFileChooser() {
                    Intent intent= new Intent();
                    intent.setType("image/*");
                    intent.setAction(Intent.ACTION_GET_CONTENT);
                    startActivityForResult(intent,PICK_IMAGE_REQUEST);
                }
                @SuppressWarnings("deprecation")
                protected void onActivityResult(int requestCode, int resultCode, Intent data){
                    CompleteprofileActivity.super.onActivityResult(requestCode,resultCode,data);

                    if (requestCode==PICK_IMAGE_REQUEST && resultCode==RESULT_OK && data !=null && data.getData() !=null ){
                        imageUri=data.getData();


                        //Picasso.with(this).load(imageUri).into(picha);
                        prof.setImageURI(imageUri);
            }}
        });*/



        ArrayAdapter<CharSequence> adapter10 = ArrayAdapter.createFromResource(this, R.array.Gender, android.R.layout.simple_spinner_item);
        adapter10.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        gender.setAdapter(adapter10);
        gender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String text = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(CompleteprofileActivity.this, "Please select your gender ", Toast.LENGTH_SHORT).show();

            }
        });
        ArrayAdapter<CharSequence> adapter20 = ArrayAdapter.createFromResource(this, R.array.County, android.R.layout.simple_spinner_item);
        adapter20.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        locate.setAdapter(adapter20);
        locate.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String text = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(CompleteprofileActivity.this, "Please select your location ", Toast.LENGTH_SHORT).show();


            }
        });

        submi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String aboutTt = aboutme.getText().toString();
              // String genderTt = gender.getText().toString();
                // String jinaTxt=jina.getText().toString();
                //String languTxt=langu.getText().toString();
                String niTxt=ni.getText().toString();
                String maileTxt=maileww.getText().toString();
                String nambaTxt=namba.getText().toString();
                validateinfo( maileTxt,nambaTxt);

                /*if (prof == null || tvInterests==null || locate == null || gender == null || maileTxt.isEmpty()||aboutTt.isEmpty()||niTxt.isEmpty()||nambaTxt.isEmpty()) {
                    Toast.makeText(CompleteprofileActivity.this, "Please fill in all the details", Toast.LENGTH_SHORT).show();
                }
                {*/
                        databaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {

                                    databaseReference.child("users").child(nambaTxt).child("locate").setValue(locate);
                                    databaseReference.child("users").child(nambaTxt).child("namba").setValue(nambaTxt);
                                    databaseReference.child("users").child(nambaTxt).child("ni").setValue(niTxt);
                                    databaseReference.child("users").child(nambaTxt).child("gender").setValue(gender);
                                    databaseReference.child("users").child(nambaTxt).child("aboutme").setValue(aboutTt);
                                    databaseReference.child("users").child(nambaTxt).child("maileww").setValue(maileTxt);
                                    databaseReference.child("users").child(nambaTxt).child("tvInterests").setValue(tvInterests);

                                    Toast.makeText(CompleteprofileActivity.this, "Profile updated successfully", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(CompleteprofileActivity.this, CompleteprofileActivity.class));
                                    finish();

                                }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        });
                    }
        private Boolean validateinfo(String maileTxt,String nambaTxt) {

            /* if (!fullnaTt.matches("[a-zA-Z]+")) {
                fullna.requestFocus();
                fullna.setError("Enter only alphabetical characters");
                return false;
            } else if (!aboutTt.matches("[a-zA-Z0-9_&$#@]+")) {
                aboutme.requestFocus();
                //aboutme.setError("Enter only alphabetical characters");
                return false;
            }
           private Boolean validateinfo(String niTxt, String maileTxt,String nambaTxt, String kitoTxt) {


               else if(kitoTxt.length()<=7) {
                    kito.requestFocus();
                    kito.setError("Minimum eight characters required");
                    return false;
                }
                else if (!maileTxt.matches("[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}"+"\\@"+"[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}"+"("+"\\."+"[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}"+")+")) {
                    maileww.requestFocus();
                    maileww.setError("Invalid email address");
                    return false;
                }

                if (!niTxt.matches("[a-zA-Z0-9]+")) {
                    ni.requestFocus();
                   // ni.setError("Enter only alphabetical or number characters");
                    return false;
                }
                 else if (!aboutTt.matches("[a-zA-Z0-9_&$#@]+")) {
                aboutme.requestFocus();
                //aboutme.setError("Enter only alphabetical characters");
                return false;
                }*/

                if(!nambaTxt.matches("^[+0-9]{10,13}$")) {
                    namba.requestFocus();
                    namba.setError("Correct format:+254xxxxxxxxx||07xxxxxxxx||01xxxxxxxx");
                    return false;

                }
                else if (!maileTxt.matches("[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}"+"\\@"+"[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}"+"("+"\\."+"[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}"+")+")) {
                    maileww.requestFocus();
                    maileww.setError("Invalid email address");
                    return false;
                }
                else {
                    return true;
                } }});

    /*    int requestcode=1;

        public void onActivityResult(int requestcode, int resultCode, Intent data){
            super.onActivityResult(requestcode,resultCode,data);
            Context context=getApplicationContext();
            if(requestcode==requestcode &&resultCode== Activity.RESULT_OK){
                if(data==null)
                {
                    return;
                }
                Uri uri=data.getData();
                prof.setImageURI(uri);

            }
        }
        @SuppressWarnings("deprecation")
        public void openfilechooser(View view){
            android.content.Intent intent=new Intent(android.content.Intent.ACTION_GET_CONTENT);
            intent.setType("image/*");
            startActivityForResult(intent,requestcode);*/
    }

    private void showInterestsDialog() {
        AlertDialog.Builder builder=new AlertDialog.Builder(CompleteprofileActivity.this);
       // builder.setCancelable(false);
        builder.setMultiChoiceItems(interestArray, selectedInterests, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                if(isChecked){
                    interestList.add(which);
                }
                else {
                    interestList.remove(which);
                }

            }
        }).setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                StringBuilder stringBuilder=new StringBuilder();
                for(int i=0;i<interestList.size();i++){
                    stringBuilder.append(interestArray[interestList.get(i)]);
                    if(i != interestList.size()-1){
                        stringBuilder.append(",");
                        tvInterests.setText(stringBuilder.toString());
                    }
                }

            }
        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();

            }
        }).setNeutralButton("Clear all", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                for(int i=0;i<interestList.size();i++){
                    selectedInterests[i]=false;
                    interestList.clear();
                    tvInterests.setText("");
                }

            }
        });
        builder.show();

    }
}