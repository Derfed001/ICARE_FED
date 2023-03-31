package com.example.thefed;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.fragment.app.Fragment;


public class RequestFragment<Private> extends Fragment {
 private static final int PICK_IMAGE_REQUEST=1;
  ImageView picha;
  Button chagua,submit;
  EditText jina,maelezo,pesa,beneJina;
  Spinner category,location;
  TextView docs;
  Uri imageUri;
  DatePicker date;
  //DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReferenceFromUrl("https://the-fed-default-rtdb.firebaseio.com/");

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //return inflater.inflate(R.layout.fragment_request, container, false);
        View root= inflater.inflate(R.layout.fragment_home, container, false);
/*
        chagua=root.findViewById(R.id.button4);
        submit=root.findViewById(R.id.button7);
        docs=root.findViewById(R.id.supportdocs);
        location=root.findViewById(R.id.location);
        category=root.findViewById(R.id.spinner);
        picha=root.findViewById(R.id.imageView4);
        jina=root.findViewById(R.id.edittitle);
        maelezo=root.findViewById(R.id.description);
        pesa=root.findViewById(R.id.amount);
        beneJina=root.findViewById(R.id.beneficiaryName);
        date=root.findViewById(R.id.editTextDate);


        chagua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFileChooser();
            }

            @SuppressWarnings("deprecation")
            private void openFileChooser() {
                Intent intent= new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent,PICK_IMAGE_REQUEST);
            }
            @SuppressWarnings("deprecation")
            protected void onActivityResult(int requestCode, int resultCode, Intent data){
                RequestFragment.super.onActivityResult(requestCode,resultCode,data);

                if (requestCode==PICK_IMAGE_REQUEST && resultCode==RESULT_OK && data !=null && data.getData() !=null ){
                    imageUri=data.getData();


                    //Picasso.with(this).load(imageUri).into(picha);
                    picha.setImageURI(imageUri);
                }
            }

        });
    ArrayAdapter<String> adapter2=new ArrayAdapter<String>(getContext() , android.R.layout.simple_spinner_item,
            getResources().getStringArray(R.array.Category));
        category.setAdapter(adapter2);
        category.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            //display.setText("Index"+i+"\n"+"Item"+adapterView.getItemAtPosition(i));


        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String jinaTt=jina.getText().toString();
                String maelezoTt=maelezo.getText().toString();
                String pesaTt=pesa.getText().toString();
                String benejinaTt=beneJina.getText().toString();


                if(jinaTt.isEmpty()||maelezoTt.isEmpty()||pesaTt.isEmpty()||benejinaTt.isEmpty()) {
                    Toast.makeText(getActivity(), "Please fill in all the details", Toast.LENGTH_SHORT).show();
                }
                //else if(category=null){
                   // Toast.makeText(RegisterActivity.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
               // }
                else{
                    databaseReference.child("Myrequests").addListenerForSingleValueEvent(new ValueEventListener() {
                       @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if(snapshot.hasChild(benejinaTt)){
                                Toast.makeText(getActivity(), "Donation request already exists ", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });

                    databaseReference.child("Myrequests").child(benejinaTt).child("jina").setValue(jinaTt);
                    databaseReference.child("Myrequests").child(benejinaTt).child("maelezo").setValue(maelezoTt);
                    databaseReference.child("Myrequests").child(benejinaTt).child("pesa").setValue(pesaTt);
                    //databaseReference.child("Myrequests").child(nambaTxt).child("maile").setValue(maileTxt);
                  //  databaseReference.child("Myrequests").child(nambaTxt).child("kito").setValue(kitoTxt);

                    //Toast.makeText(RegisterActivity.this, "User registered successfully", Toast.LENGTH_SHORT).show();
                     Toast.makeText(getActivity(), "Submitted successfully", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getActivity(),HomeActivity.class));
                    //finish();

        }
            }
        });*/
        return root;
    }
}