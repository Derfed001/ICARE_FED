package com.example.thefed;

import android.app.DatePickerDialog;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class RequestActivity extends AppCompatActivity {
    static final int PICK_IMAGE_REQUEST=1;
    ImageView picha;
    Button chagua,submit;
    EditText jina,maelezo,pesa,beneJina,medate,phone;
    Spinner category,location;
    Uri imageUri;
    DatePickerDialog.OnDateSetListener setListener;
    private AdapterView<Adapter> parent;
    private char position;

     //DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReferenceFromUrl("https://the-fed-default-rtdb.firebaseio.com/");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);

/*
        chagua = findViewById(R.id.button4);
        submit = findViewById(R.id.button7);
        //docs=findViewById(R.id.supportdocs);
        location = findViewById(R.id.location);
        category = findViewById(R.id.spinner);
        picha = findViewById(R.id.imageView4);
        jina = findViewById(R.id.edittitle);
        maelezo = findViewById(R.id.description);
        pesa = findViewById(R.id.amount);
        beneJina = findViewById(R.id.beneficiaryName);
        medate = findViewById(R.id.editTextDate);
        phone = findViewById(R.id.editTextPhone);

        Calendar calendar= Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        medate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog=new DatePickerDialog(
                        RequestActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        month=month+1;
                        String date=day+"/"+month+"/"+year;
                        medate.setText(date);

                    }
                },year,month,day);
                datePickerDialog.show();

            }
        });
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Category, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        category.setAdapter(adapter);
        category.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String text = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(RequestActivity.this, "Please choose one category ", Toast.LENGTH_SHORT).show();

            }
        });
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.County, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        location.setAdapter(adapter2);
        location.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String text = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(RequestActivity.this, "Please select your location ", Toast.LENGTH_SHORT).show();


            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String jinaTt = jina.getText().toString();
                String maelezoTt = maelezo.getText().toString();
                String pesaTt = pesa.getText().toString();
                String benejinaTt = beneJina.getText().toString();
                String phoneTt = phone.getText().toString();

                validateinfo(jinaTt,maelezoTt,pesaTt,benejinaTt,phoneTt);

                if(picha==null||location==null||category==null||medate==null||jinaTt.isEmpty() || maelezoTt.isEmpty() || pesaTt.isEmpty() || benejinaTt.isEmpty()){
                    Toast.makeText(RequestActivity.this, "Please fill in all the details", Toast.LENGTH_SHORT).show();

                //}
              //  else if (jinaTt.isEmpty() || maelezoTt.isEmpty() || pesaTt.isEmpty() || benejinaTt.isEmpty()) {
                  //  Toast.makeText(RequestActivity.this, "Please fill in all the details", Toast.LENGTH_SHORT).show();
                } else {
                    databaseReference.child("Myrequests").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if (snapshot.hasChild(benejinaTt)) {
                                Toast.makeText(RequestActivity.this, "Donation request already exists ", Toast.LENGTH_SHORT).show();
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

                    Toast.makeText(RequestActivity.this, "Submitted successfully", Toast.LENGTH_SHORT).show();
                    //Toast.makeText(getActivity(), "Submitted successfully", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(RequestActivity.this, HomeActivity.class));
                    finish();

                }
            }

            private Boolean validateinfo(String jinaTt, String maelezoTt,String phoneTt, String pesaTt, String benejinaTt) {

                if (!jinaTt.matches("[a-zA-Z]+")) {
                    jina.requestFocus();
                    jina.setError("Enter only alphabetical characters");
                    return false;

                } else if (!benejinaTt.matches("[a-zA-Z]+")) {
                    beneJina.requestFocus();
                    beneJina.setError("Enter only alphabetical characters");
                    return false;
                } else if (!maelezoTt.matches("[a-zA-Z]+")) {
                    maelezo.requestFocus();
                    maelezo.setError("Enter only alphabetical characters");
                    return false;
                }
                else if(!pesaTt.matches("[0-9]")) {
                    pesa.requestFocus();
                    pesa.setError("Enter numbers");
                    return false;
                }
                else if(!phoneTt.matches("^[+][0-9]{10,13}$")) {
                    phone.requestFocus();
                    phone.setError("Correct format:+254xxxxxxxxx");
                    return false;

        }
            else{
                return true;
                }}});
    }
    int requestcode=1;

    public void onActivityResult(int requestcode, int resultCode, Intent data){
        super.onActivityResult(requestcode,resultCode,data);
        Context context=getApplicationContext();
        if(requestcode==requestcode &&resultCode== Activity.RESULT_OK){
            if(data==null)
            {
                return;
            }
            Uri uri=data.getData();
            picha.setImageURI(uri);

        }
    }
        @SuppressWarnings("deprecation")
        public void openfilechooser(View view){
            Intent intent=new Intent(Intent.ACTION_GET_CONTENT);
            intent.setType("image/*");
            startActivityForResult(intent,requestcode);*/
    }
}

