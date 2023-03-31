package com.example.thefed;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.example.thefed.models.PopularModel;
import com.stripe.android.PaymentConfiguration;
import com.stripe.android.paymentsheet.PaymentSheet;
import com.stripe.android.paymentsheet.PaymentSheetResult;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class  DonateMeActivity extends AppCompatActivity {
    Button donateBt;
    ImageView view5, view7;
    TextView view27,view42,view40,donat,view51,view52,view53,view54;
    ProgressBar progressBar1;
    PopularModel popularModel=null;
    PaymentSheet paymentSheet;
    String PUBLISH_KEY="pk_test_51MluAFEMbBMhBeVydIgN6moRUXnup8MO7VxsjolZ6HGJ4cFrcPiqg01FsUjRWNirIfJsL7QzCXjfxTt1kK3kMhbL00d1gEgMYz";
    String SECRET_KEY="sk_test_51MluAFEMbBMhBeVy54bI4xopHmSlaIJkhOBqDBhRUcm20cHjRHlXIjGG6V8MbMacWoapI8yKA8Psa1PHInzc6kh600eb4urSjV";
   // @SuppressLint("MissingInflatedId")
    String customerID;
    String EphiricalKey;
    String ClientSecret;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_donate_me);

        view5=findViewById(R.id.imageView5);
        view7=findViewById(R.id.imageView7);
        view27=findViewById(R.id.textView27);
        view42=findViewById(R.id.textView42);
      //  view51=findViewById(R.id.textView51);
     //   view52=findViewById(R.id.textView52);
        view53=findViewById(R.id.textView53);
        view54=findViewById(R.id.textView54);
        //donat=findViewById(R.id.textViewDonators);
        view40= findViewById(R.id.textView40);
       // progressBar1=findViewById(R.id.progressBar);
        donateBt=findViewById(R.id.button_do);


        PaymentConfiguration.init(this,PUBLISH_KEY);
        paymentSheet=new PaymentSheet(this,paymentSheetResult -> {
            onPaymentResult(paymentSheetResult);

        });
            StringRequest stringRequest=new StringRequest(Request.Method.POST, "https://api.stripe.com/v1/customers", new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {

                    try {
                        JSONObject object=new JSONObject(response);
                        customerID=object.getString("id");
                        Toast.makeText(DonateMeActivity.this,customerID,Toast.LENGTH_SHORT).show();

                        getEphericalKey(customerID);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            }){
                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    Map<String,String>header=new HashMap<>();
                    header.put("Authorization","Bearer"+SECRET_KEY);
                    return header;
                }
            };
            RequestQueue requestQueue= Volley.newRequestQueue(DonateMeActivity.this);
            requestQueue.add(stringRequest);

        //String category=getIntent().getStringExtra("category");
        final Object object=getIntent().getSerializableExtra("category");
        if(object instanceof PopularModel){
            popularModel=(PopularModel) object;
        }
        if(popularModel !=null){
            Glide.with(getApplicationContext()).load(popularModel.getImage_url()).into(view5);
            view27.setText(popularModel.getName());
           // Glide.with(context).load(popularModelList.get(position).getImage_url()).into(holder.popImg);
            //holder.name.setText(popularModelList.get(position).getName());

            view40.setText(popularModel.getDescription());
            view51.setText(popularModel.getDonateamount());
            //description.setText(popularModel.getDescription());
            view54.setText(popularModel.getBenefitcontact());
            view42.setText(popularModel.getDonationperiod());
            //holder.description.setText(popularModelList.get(position).getDescription());
            view53.setText(popularModel.getBenefitname());

        }

        donateBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

             //PaymentFlow();
                startActivity(new Intent(DonateMeActivity.this, DonationActivity.class));
                finish();
            }
        });

        view7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_INTENT,"Contact Admin @ +254791088006 to upload or share a request");
                intent.setType("text/plain");

                if(intent.resolveActivity(getPackageManager())!=null){
                    startActivity(intent);
                }
            }
        });


    }

    private void onPaymentResult(PaymentSheetResult paymentSheetResult) {

            if(paymentSheetResult instanceof PaymentSheetResult.Completed){
                Toast.makeText(this,"Donated successfully",Toast.LENGTH_SHORT).show();
            }else if(paymentSheetResult instanceof PaymentSheetResult.Canceled) {
                Toast.makeText(this, "Donation Cancelled", Toast.LENGTH_SHORT).show();
            }else if(paymentSheetResult instanceof PaymentSheetResult.Failed) {
                Toast.makeText(this, "Donation Failed", Toast.LENGTH_SHORT).show();
            }
    }

    private void getEphericalKey(String customerID) {

        StringRequest stringRequest=new StringRequest(Request.Method.POST, "https://api.stripe.com/v1/ephemeral_keys", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject object=new JSONObject(response);
                    EphiricalKey=object.getString("id");
                    Toast.makeText(DonateMeActivity.this,EphiricalKey,Toast.LENGTH_SHORT).show();

                    getClientSecret(customerID,EphiricalKey);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String,String>header=new HashMap<>();
                header.put("Authorization","Bearer"+SECRET_KEY);
                header.put("Stripe-Version","2022-11-15");
                return header;
            }

            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params=new HashMap<>();
                params.put("customer",customerID);
                return params;
            }
        };
        RequestQueue requestQueue= Volley.newRequestQueue(DonateMeActivity.this);
        requestQueue.add(stringRequest);
    }

    private void getClientSecret(String customerID, String ephiricalKey) {

        StringRequest stringRequest=new StringRequest(Request.Method.POST,
                "https://api.stripe.com/v1/payment_intents", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject object=new JSONObject(response);
                    ClientSecret=object.getString("client_secret");
                    Toast.makeText(DonateMeActivity.this,ClientSecret,Toast.LENGTH_SHORT).show();
                    
                   // PaymentFlow();
                    //getClientSecret(customerID,EphiricalKey);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String,String>header=new HashMap<>();
                header.put("Authorization","Bearer"+SECRET_KEY);
                return header;
            }

           // @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params=new HashMap<>();
                params.put("customer",customerID);
                params.put("amount","1"+"00");
                params.put("currency","usd");
                params.put("automatic_payment_methods[enabled]","true");
                return params;
            }
        };
        RequestQueue requestQueue= Volley.newRequestQueue(DonateMeActivity.this);
        requestQueue.add(stringRequest);
    }

    private void PaymentFlow() {
            paymentSheet.presentWithPaymentIntent(
                    ClientSecret,new PaymentSheet.Configuration("ICARE CHARITY"
                    ,new PaymentSheet.CustomerConfiguration(
                            customerID,
                            EphiricalKey
                    ))
            );
    }
}