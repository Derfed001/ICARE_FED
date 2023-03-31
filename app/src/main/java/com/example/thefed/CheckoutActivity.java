package com.example.thefed;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.stripe.android.paymentsheet.PaymentSheet;
import com.stripe.android.paymentsheet.PaymentSheetResult;
public class CheckoutActivity extends AppCompatActivity {
    String paymentIntentClientSecret;
    PaymentSheet.CustomerConfiguration customerConfig;


        PaymentSheet paymentSheet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        paymentSheet = new PaymentSheet(this, this::onPaymentSheetResult);
    }

    void onPaymentSheetResult(final PaymentSheetResult paymentSheetResult) {
        // implemented in the next steps

    }
}